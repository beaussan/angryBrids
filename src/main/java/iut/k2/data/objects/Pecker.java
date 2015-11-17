package iut.k2.data.objects;

import iut.k2.gui.renderfunc.DrawBird;
import iut.k2.physics.Coordinate2D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pecker extends Entity {
    private final static Logger LOG = LoggerFactory.getLogger(Pecker.class);

	public Pecker(Coordinate2D c) {
		super(c);
        LOG.debug("Creating new Pecker at {}", c);

        // Set physics values
        setTerminalVelocity(new Coordinate2D(1000.0f, 1000.0f));
        setFriction(new Coordinate2D(.005, 0));
        setAcceleration(new Coordinate2D(0.0f, -0.25f));
        //setVelocity(new Coordinate2D(200, 300));
    }

	@Override
	public void render(Graphics batch) {
        DrawBird.drawBird(batch, getCoordinate(), getCoordinate().add(getVelocity().times(2)));
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        getLsShapes().clear();
        getLsShapes().add(new Ellipse2D.Double((int) getCoordinate().getX() - (DrawBird.SIZE_BIRD / 2),
                (int) getCoordinate().getY() - (DrawBird.SIZE_BIRD / 2),
                DrawBird.SIZE_BIRD, DrawBird.SIZE_BIRD));
    }
}


