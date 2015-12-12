package iut.k2.data.objects;

import iut.k2.data.objects.Shapes.Circle;
import iut.k2.physics.Coordinate2D;
import iut.k2.util.Tools;

import iut.k2.data.objects.Shapes.*;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class Obstacle extends Entity implements ShapeBased{
    private final static int SIZE = 25;
    private final Coordinate2D renderTo;
    private final Map<Shape, Color> shapes;


    private Color col = Color.BLUE;

	public Obstacle(Coordinate2D c) {
		super(c);
        renderTo = Tools.getSwingCords(c);
        addShape(new Circle(c.getX()+SIZE/2, c.getY()+SIZE/2, SIZE));
        shapes = new HashMap<>();
        shapes.put(new Circle(renderTo.getX()+SIZE/2, renderTo.getY()+SIZE/2, SIZE), Color.BLUE);


    }

    @Override
    public void setColor(Color color) {
        col = color;
    }


    @Override
    public Map<Shape, Color> getDrawsShapes() {
        return shapes;
    }
}
