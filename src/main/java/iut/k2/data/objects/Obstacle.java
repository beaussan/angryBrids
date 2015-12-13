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
    private Coordinate2D base;
    private Color col = Color.BLUE;
    private int directionX;
    private int directionY;

    /**
     * Instantiate an obstacle with a color and add it to the map of shapes
     * to be displayed in the view
     */
	public Obstacle(Coordinate2D c, int moveX, int moveY, int directionX, int directionY) {
		super(c);
        renderTo = Tools.getSwingCords(c);
        addShape(new Circle(c.getX(), c.getY(), SIZE));
        //addShape(new Rectangle2D(c.getX(), c.getY(), 30, 30));
        shapes = new HashMap<>();
        shapes.put(new Circle(renderTo.getX(), renderTo.getY(), SIZE), Color.BLUE);
        //shapes.put(new Rectangle2D(renderTo.getX(), renderTo.getY(), 30, 30), Color.BLUE);
        //if(moveY>0){
        if(directionX>0 && directionY>0){
        	savedcoordinatesh = new Coordinate2D(renderTo.getX()+moveX , renderTo.getY()+moveY);
        	savedcoordinatesb = new Coordinate2D(renderTo.getX()-moveX , renderTo.getY()-moveY);
        	this.directionX = directionX;
        	this.directionY = directionY;
        }
        else if(directionX<0 && directionY>0){
        	savedcoordinatesh = new Coordinate2D(renderTo.getX()-moveX , renderTo.getY()+moveY);
        	savedcoordinatesb = new Coordinate2D(renderTo.getX()+moveX , renderTo.getY()-moveY);
        	this.directionX = directionX;
        	this.directionY = directionY;
        }
        else if(directionX>0 && directionY<0){
        	savedcoordinatesh = new Coordinate2D(renderTo.getX()+moveX , renderTo.getY()-moveY);
        	savedcoordinatesb = new Coordinate2D(renderTo.getX()-moveX , renderTo.getY()+moveY);
        	this.directionX = directionX;
        	this.directionY = directionY;
        }
        else if(directionX<0 && directionY<0){
        	savedcoordinatesh = new Coordinate2D(renderTo.getX()-moveX , renderTo.getY()-moveY);
        	savedcoordinatesb = new Coordinate2D(renderTo.getX()+moveX , renderTo.getY()+moveY);
        	this.directionX = directionX;
        	this.directionY = directionY;
        }

        base= new Coordinate2D(c.getX(),c.getY());
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
    
    /**
     * Move the obstacles
     */
    public void updatePosition(){
    	if(pos){
    		renderTo.setX(renderTo.getX()-directionX);
    		renderTo.setY(renderTo.getY()-directionY);
    		base.setX(base.getX()-directionX);
    		base.setY(base.getY()+directionY);
    		for(Shape shape :shapes.keySet()){
    			if(shape instanceof Circle){
    				this.getLsShapes().clear();
    				addShape(new Circle(base.getX(), base.getY(), SIZE));
    				shapes.clear();
    				shapes.put(new Circle(renderTo.getX(), renderTo.getY(), SIZE), Color.BLUE);
    			} else if(shape instanceof Rectangle2D){
    				this.getLsShapes().clear();
    		        addShape(new Rectangle2D(base.getX(), base.getY(), 30, 30));
    	            shapes.clear();
    	            shapes.put(new Rectangle2D(renderTo.getX(), renderTo.getY(), 30, 30), Color.BLUE);
    	    	}
            if((renderTo.getX()==savedcoordinatesb.getX()) || (renderTo.getY()==savedcoordinatesb.getY()))
            	pos=false;
    		}
    	}
    	else{
    		renderTo.setX(renderTo.getX()+directionX);
    		renderTo.setY(renderTo.getY()+directionY);
    		base.setX(base.getX()+directionX);
    		base.setY(base.getY()-directionY);
    		for(Shape shape :shapes.keySet()){
    			if(shape instanceof Circle){
    				this.getLsShapes().clear();
    				addShape(new Circle(base.getX(), base.getY(), SIZE));
    				shapes.clear();
    				shapes.put(new Circle(renderTo.getX(), renderTo.getY(), SIZE), Color.BLUE);
    			}
       			if(shape instanceof Rectangle2D){
    				this.getLsShapes().clear();
    		        addShape(new Rectangle2D(base.getX(), base.getY(), 30, 30));
    	            shapes.clear();
    	            shapes.put(new Rectangle2D(renderTo.getX(), renderTo.getY(), 30, 30), Color.BLUE);
    	    	}
            if((renderTo.getX()==savedcoordinatesh.getX()) || (renderTo.getY()==savedcoordinatesh.getY()))
    		pos=true;
    		}
    	}
    	
    }
}
