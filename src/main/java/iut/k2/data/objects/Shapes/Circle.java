package iut.k2.data.objects.Shapes;

import iut.k2.physics.Coordinate2D;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Circle is an implementation of the interface Shape which 
 * is used for dealing with hitBoxes.
 * Circle contains 4 attributes: its coordinates, its radius, 
 * the number of hitBoxes and a list of its hitBoxes
 *   
 * The coordinates of the Circle are located on its center.
 * 
 * The Rectangles used for the hitBoxes are created inside the Circle,
 * so everytime we want to check for a collision, we will have to test
 * the collision on each Rectangle until a collision is found.
 *  
 * @author Benjamin D'Hoop
 *
 */
public class Circle implements Shape{

	private Coordinate2D coord; 			//coord indicates the center of the Circle
	private double radius;
	
	private final int nbRectangle = 10; 	//The more rectangles, the more precise
	private List<Rectangle2D> hitBoxes;
	
	public Circle(double x, double y, double radius){
		coord = new Coordinate2D(x, y);
		if(radius > 0)
			this.radius = radius;
		hitBoxes = new ArrayList<Rectangle2D>();
		generateHitBoxes();
	}
	
	/**
	 * Generate the hitBoxes (list of Rectangle2D) 
	 * for the Circle
	 */
	private void generateHitBoxes(){
		hitBoxes.clear();

		int parts = nbRectangle+1;
		int pas = 2*parts;
		
		//Optimization for calculs made multiple times
		double interval = Math.PI/pas;
		for(int i = 1; i < parts; i++){
			double largeRectL = 2*Math.abs(Math.cos((pas-i)*interval)*radius);
			double largeRectH = 2*Math.abs(Math.sin((pas-i)*interval)*radius);
			double largeRectX = Math.cos((pas-i)*interval)*radius+coord.getX();
			double largeRectY = -(Math.sin((pas-i)*interval)*radius)+coord.getY();
			hitBoxes.add(new Rectangle2D(largeRectX, largeRectY, largeRectL, largeRectH));
		}
		
	}
	
	@Override
	public boolean contains(double x, double y) {
		for(Rectangle2D r : hitBoxes){
			if(r.contains(x, y))
				return true;
		}
		return false;
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		//Données de la figure en paramère
		double xMin = x;
		double xMax = x + w;
		double yMin = y;
		double yMax = y + h;
		
		return contains(xMin, yMin)
				&& contains(xMin, yMax)
				&& contains(xMax, yMin)
				&& contains(xMax, yMax);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean intersects(Shape s) {
		if(s instanceof Circle){
			Circle c = (Circle)s;
			if(getCenter().equals(c.getCenter())){
				return true;
			}else{
				double distanceCarre = getDistanceCarre(c.getCenter());
				if(distanceCarre < (c.getRadius()+getRadius())*(c.getRadius()+getRadius())){
					return true;
				}else{
					return false;
				}
			}
			
		}else{
			for(Rectangle2D r2 : hitBoxes){
				if(r2.intersects(s)){
					return true;
				}
			}
		}
		return false;
	}
	
	public double getDistanceCarre(Coordinate2D c2){
		double xA = coord.getX();
		double yA = coord.getY();
		double xB = c2.getX();
		double yB = c2.getY();
		
		return (xB-xA)*(xB-xA)+(yB-yA)*(yB-yA);
	}
	
	@Override
	public boolean contains(Shape s) {
		// TODO Auto-generated method stub
		return false;
	}		// TODO Auto-generated method stub
	
	
	public Coordinate2D getCenter(){
		return coord;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public List<Rectangle2D> getHitBoxes(){
		return hitBoxes;
	}
	
	public void setCenter(Coordinate2D coord){
		this.coord = coord;
		generateHitBoxes();
	}
	
	public void setRadius(double radius){
		this.radius = radius;
		generateHitBoxes();
	}

	@Override
	public void move(Coordinate2D c) {
		coord.setX(coord.getX()+c.getX());
		coord.setY(coord.getY()+c.getY());
		generateHitBoxes();
	}
	
	/*
	 * Testing method for showing the hitboxes
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("test");
		f.setPreferredSize(new Dimension(500, 500));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Circle c = new Circle(100, 100, 20);
    	final Rectangle2D r = new Rectangle2D(71, 71, 15, 15);
    	final Rectangle2D r2 = new Rectangle2D(100, 100, 20, 20);
		JPanel p = new JPanel(){
			public void paintComponent(Graphics g){
				for(Rectangle2D r : c.getHitBoxes()){
					//System.out.println((int)r.getX()+" " +(int)r.getY()+" "+ (int)r.getWidth()+" "+ (int)r.getHeight());
					g.drawRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
				}
				
				g.setColor(Color.DARK_GRAY);
				//System.out.println((int)r2.getX()+" " +(int)r2.getY()+" "+ (int)r2.getWidth()+" "+ (int)r2.getHeight());
				g.drawRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
				g.setColor(Color.RED);
				//System.out.println((int)r2.getX()+" " +(int)r2.getY()+" "+ (int)r2.getWidth()+" "+ (int)r2.getHeight());
				g.drawRect((int)r2.getX(), (int)r2.getY(), (int)r2.getWidth(), (int)r2.getHeight());
				//g.setColor(Color.GREEN);
				//System.out.println((int)r22.getX()+" " +(int)r22.getY()+" "+ (int)r22.getWidth()+" "+ (int)r22.getHeight());
				//g.drawRect((int)r22.getX(), (int)r22.getY(), (int)r22.getWidth(), (int)r22.getHeight());
				
				
				g.setColor(Color.BLACK);
				g.drawOval((int)(c.getCenter().getX()-c.getRadius()), (int)(c.getCenter().getY()
						-c.getRadius()), (int)(c.getRadius()*2), (int)(c.getRadius()*2));
				
			}
		};
		/*
		System.out.println("Cercle intersects Gray: " + c.intersects(r));
		System.out.println("Cercle intersects Red: " + c.intersects(r2));
		System.out.println("Cercle intersects Green: " + c.intersects(r22)) ;
		*/
		f.getContentPane().add(p);
		f.pack();
		f.setVisible(true);
		
	}


}
