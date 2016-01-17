package iut.k2.data.objects;

import java.awt.Color;

import iut.k2.data.objects.Shapes.Circle;
import iut.k2.physics.Coordinate2D;

public class Balloon extends Cercle {

	public Balloon(Coordinate2D c) {
		super(c);
	}
	public void update(float deltaTime) {
		
		   updateMotionX(deltaTime);
	       updateMotionY(deltaTime);

	        // Move to new position
	        position.setX(position.getX() + ((velocity.getX() * deltaTime) / 1000));
	        position.setY(position.getY() - ((velocity.getY() * deltaTime) / 1000));
	        renderTo.setX(renderTo.getX() + ((velocity.getX() * deltaTime) / 1000));
	        renderTo.setY(renderTo.getY() + ((velocity.getY() * deltaTime) / 1000));
			this.getLsShapes().clear();
			addShape(new Circle(position.getX(), position.getY(), SIZE));
			shapes.clear();
			shapes.put(new Circle(renderTo.getX(), renderTo.getY(), SIZE), Color.BLUE);
	}
}
