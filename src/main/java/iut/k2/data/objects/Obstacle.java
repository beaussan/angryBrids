package iut.k2.data.objects;

import iut.k2.physics.Coordinate2D;
import iut.k2.util.Tools;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Obstacle extends Entity {
    private final static int SIZE = 20;
    private final Coordinate2D renderTo;

    private Color col = Color.BLUE;

	public Obstacle(Coordinate2D c) {
		super(c);
        renderTo = Tools.getSwingCords(c);
        addShape(new Ellipse2D.Double((int) c.getX() - SIZE / 2, (int) c.getY() - SIZE / 2, SIZE, SIZE));
    }

	@Override
	public void render(Graphics batch) {
        batch.setColor(col);
        ((Graphics2D) batch).fill(new Ellipse2D.Double((int) renderTo.getX() - SIZE/2, (int) renderTo.getY() - SIZE /2, SIZE, SIZE));
	}

    @Override
    public void setColor(Color color) {
        col = color;
    }


}
