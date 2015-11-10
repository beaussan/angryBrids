package iut.k2.data.objects;

import iut.k2.gui.renderfunc.DrawBird;
import iut.k2.physics.Coordinate2D;

import java.awt.*;

public class Pecker extends Entity {

	public Pecker(Coordinate2D c) {
		super(c);

        // Set physics values
        setTerminalVelocity(new Coordinate2D(1000.0f, 1000.0f));
        setFriction(new Coordinate2D(.005, 0));
        setAcceleration(new Coordinate2D(0.0f, -0.25f));
        setVelocity(new Coordinate2D(200, 500));
    }

	@Override
	public void render(Graphics batch) {
        DrawBird.drawBird(batch, getCoordinate(), getCoordinate().add(getVelocity().times(2)));
    }


}


