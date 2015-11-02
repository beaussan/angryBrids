package iut.k2.data.objects;


import iut.k2.physics.Coordinate2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity extends AbstractGameObject {

    protected Coordinate2D c;
    private List<Shape> lsShapes;

    public Entity(Coordinate2D c) {
        this.c = c;
        lsShapes = new ArrayList<>();
    }

    public boolean addShape(Shape shape) {
        return lsShapes.add(shape);
    }

    /**
     * Getter for property 'coordinate'.
     *
     * @return Value for property 'coordinate'.
     */
    public Coordinate2D getCoordinate() {
        return c;
    }

    /**
     * Setter for property 'coordinate'.
     *
     * @param c Value to set for property 'coordinate'.
     */
    public void setCoordinate(Coordinate2D c) {
        this.c = c;
    }

    /**
     * Getter for property 'lsShapes'.
     *
     * @return Value for property 'lsShapes'.
     */
    public List<Shape> getLsShapes() {
        return lsShapes;
    }

    public void move(double x, double y) {
        setCoordinate(getCoordinate().add(x, y));
    }

    public boolean overlap(Entity other) {
        for (Shape s : lsShapes) {
            for (Shape so : other.lsShapes) {
                if (s.intersects(so.getBounds2D())) {
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

    public abstract void update(float deltaTime);

}
