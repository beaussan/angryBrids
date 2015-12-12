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
    private boolean pos =true;
    private Coordinate2D savedcoordinatesh;
    private Coordinate2D savedcoordinatesb;


    private Color col = Color.BLUE;

    /**
     * Instantiate an obstacle with a color and add it to the map of shapes
     * to be displayed in the view
     */
	public Obstacle(Coordinate2D c) {
		super(c);
        renderTo = Tools.getSwingCords(c);
        addShape(new Circle(c.getX(), c.getY(), SIZE));
        shapes = new HashMap<>();
        shapes.put(new Circle(renderTo.getX(), renderTo.getY(), SIZE), Color.BLUE);
        savedcoordinatesh= new Coordinate2D(renderTo.getX()+30 , renderTo.getY()+30);
        savedcoordinatesb= new Coordinate2D(renderTo.getX()-30 , renderTo.getY()-30);
    }

	 /**
     * Change the color of the obstacle
     *
     * @param color
     */
    @Override
    public void setColor(Color color) {
        col = color;
    }

    /**
     * Return the map of shapes of this object
     *
     * @return shapes
     */
    @Override
    public Map<Shape, Color> getDrawsShapes() {
        return shapes;
    }
    
    public void updatePosition(){
    	if(pos){
    		renderTo.setX(renderTo.getX()-1);
    		renderTo.setY(renderTo.getY()-1);
            addShape(new Circle(renderTo.getX(), renderTo.getY(), SIZE));
            shapes.clear();
            shapes.put(new Circle(renderTo.getX(), renderTo.getY(), SIZE), Color.BLUE);
            if((renderTo.getX()==savedcoordinatesb.getX()) && (renderTo.getY()==savedcoordinatesb.getY()))
    		pos=false;
    	}
    	else{
    		renderTo.setX(renderTo.getX()+1);
    		renderTo.setY(renderTo.getY()+1);
            addShape(new Circle(renderTo.getX(), renderTo.getY(), SIZE));
            shapes.clear();
            shapes.put(new Circle(renderTo.getX(), renderTo.getY(), SIZE), Color.BLUE);
            if((renderTo.getX()==savedcoordinatesh.getX()) && (renderTo.getY()==savedcoordinatesh.getY()))
    		pos=true;
    	}
    	
    }
}
