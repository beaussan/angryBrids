package iut.k2.data.objects;


import iut.k2.physics.Coordinate2D;
import iut.k2.util.MathUtils;

import javax.annotation.Nullable;
import iut.k2.data.objects.Shapes.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity extends AbstractGameObject {

    private Coordinate2D position;
    private List<Shape> lsShapes;
    private float rotation;
    private Coordinate2D velocity;
    private Coordinate2D terminalVelocity;
    private Coordinate2D friction;
    private Coordinate2D acceleration;

    public Entity(@Nullable Coordinate2D c) {
        this.position = (c == null) ? new Coordinate2D(50, 50) : c;
        lsShapes = new ArrayList<>();
        rotation = 0;
        velocity = new Coordinate2D(0, 0);
        terminalVelocity = new Coordinate2D(1, 1);
        friction = new Coordinate2D(0, 0);
        acceleration = new Coordinate2D(0, 0);
    }

    public boolean addShape(Shape shape) {
        return lsShapes.add(shape);
    }

    /**
     * Getter for property 'acceleration'.
     *
     * @return Value for property 'acceleration'.
     */
    public Coordinate2D getAcceleration() {
        return acceleration;
    }

    /**
     * Setter for property 'acceleration'.
     *
     * @param acceleration Value to set for property 'acceleration'.
     */
    public void setAcceleration(Coordinate2D acceleration) {
        this.acceleration = acceleration;
    }

    /**
     * Getter for property 'coordinate'.
     *
     * @return Value for property 'coordinate'.
     */
    public Coordinate2D getCoordinate() {
        return position;
    }

    /**
     * Setter for property 'coordinate'.
     *
     * @param c Value to set for property 'coordinate'.
     */
    public void setCoordinate(Coordinate2D c) {
        this.position = c;
    }

    /**
     * Getter for property 'friction'.
     *
     * @return Value for property 'friction'.
     */
    public Coordinate2D getFriction() {
        return friction;
    }

    /**
     * Setter for property 'friction'.
     *
     * @param friction Value to set for property 'friction'.
     */
    public void setFriction(Coordinate2D friction) {
        this.friction = friction;
    }

    /**
     * Getter for property 'lsShapes'.
     *
     * @return Value for property 'lsShapes'.
     */
    public List<Shape> getLsShapes() {
        return lsShapes;
    }

    /**
     * Getter for property 'rotation'.
     *
     * @return Value for property 'rotation'.
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * Setter for property 'rotation'.
     *
     * @param rotation Value to set for property 'rotation'.
     */
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    /**
     * Getter for property 'terminalVelocity'.
     *
     * @return Value for property 'terminalVelocity'.
     */
    public Coordinate2D getTerminalVelocity() {
        return terminalVelocity;
    }

    /**
     * Setter for property 'terminalVelocity'.
     *
     * @param terminalVelocity Value to set for property 'terminalVelocity'.
     */
    public void setTerminalVelocity(Coordinate2D terminalVelocity) {
        this.terminalVelocity = terminalVelocity;
    }

    /**
     * Getter for property 'velocity'.
     *
     * @return Value for property 'velocity'.
     */
    public Coordinate2D getVelocity() {
        return velocity;
    }

    /**
     * Setter for property 'velocity'.
     *
     * @param velocity Value to set for property 'velocity'.
     */
    public void setVelocity(Coordinate2D velocity) {
        this.velocity = velocity;
    }

    public void move(double x, double y) {
        setCoordinate(getCoordinate().add(x, y));
    }

    public boolean overlap(Entity other) {
        for (Shape s : lsShapes) {
            for (Shape so : other.lsShapes) {
                if (s.intersects(so)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeShape(Shape shape) {
        return lsShapes.remove(shape);
    }

    public void setColor(Color color) {

    }

    public void update(float deltaTime) {
        updateMotionX(deltaTime);
        updateMotionY(deltaTime);

        // Move to new position
        position.setX(position.getX() + ((velocity.getX() * deltaTime) / 1000));
        position.setY(position.getY() + ((velocity.getY() * deltaTime) / 1000));
    }

    protected void updateMotionX(float deltaTime) {
        if (velocity.getX() != 0) {
            // Apply friction
            if (velocity.getX() > 0) {
                velocity.setX(Math.max(velocity.getX() - friction.getX() * deltaTime, 0));
            } else {
                velocity.setX(Math.min(velocity.getX() + friction.getX() * deltaTime, 0));
            }
        }
        // Apply acceleration
        velocity.setX(velocity.getX() + acceleration.getX() * deltaTime);
        // Make sure the object's velocity does not exceed the
        // positive or negative terminal velocity
        velocity.setX(MathUtils.clamp(velocity.getX(), -terminalVelocity.getX(), terminalVelocity.getX()));
    }

    protected void updateMotionY(float deltaTime) {
        if (velocity.getY() != 0) {
            // Apply friction
            if (velocity.getY() > 0) {
                velocity.setY(Math.max(velocity.getY() - friction.getY() * deltaTime, 0));
            } else {
                velocity.setY(Math.min(velocity.getY() + friction.getY() * deltaTime, 0));
            }
        }
        // Apply acceleration
        velocity.setY(velocity.getY() + acceleration.getY() * deltaTime);
        // Make sure the object's velocity does not exceed the
        // positive or negative terminal velocity
        velocity.setY(MathUtils.clamp(velocity.getY(), -terminalVelocity.getY(), terminalVelocity.getY()));
    }
}
