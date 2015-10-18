package iut.k2.data.objects;

import iut.k2.physics.Coordinate2D;
import iut.k2.util.Tools;

import java.awt.*;

public class Obstacle extends Entity {
    private final static int SIZE = 20;
    Coordinate2D renderTo;
    private Color col = Color.BLUE;

	public Obstacle(Coordinate2D c) {
		super(c);

        renderTo = Tools.getSwingCords(c);
    }

	@Override
	public void render(Graphics batch) {
        batch.setColor(col);
        batch.fillOval((int) renderTo.getX() + SIZE / 2, (int) renderTo.getY() + SIZE / 2, SIZE, SIZE);

	}

    public void setColor(Color col) {
        this.col = col;
    }

	@Override
	public void update(float deltaTime) {

	}

}
