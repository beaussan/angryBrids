package iut.k2.data.objects.Shapes;

import iut.k2.physics.Coordinate2D;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Circle implements Shape{

	//Placé au centre du Cercle
	private Coordinate2D coord;
	private double radius;
	private List<Rectangle2D> hitBoxes;
	
	public Circle(double x, double y, double radius){
		coord = new Coordinate2D(x, y);
		this.radius = radius;
		hitBoxes = new ArrayList<Rectangle2D>();
		generateHitBoxes();
	}
	
	private void generateHitBoxes(){
		
		double largeRect1L = 2*Math.abs(Math.cos(9*Math.PI/10)*radius);
		double largeRect1H = 2*Math.abs(Math.sin(9*Math.PI/10)*radius);
		double largeRect1X = Math.cos(9*Math.PI/10)*radius+coord.getX();
		double largeRect1Y = -(Math.sin(9*Math.PI/10)*radius)+coord.getY();
		
		double largeRect2L = 2*Math.abs(Math.cos(8*Math.PI/10)*radius);
		double largeRect2H = 2*Math.abs(Math.sin(8*Math.PI/10)*radius);
		double largeRect2X = Math.cos(8*Math.PI/10)*radius+coord.getX();
		double largeRect2Y = -(Math.sin(8*Math.PI/10)*radius)+coord.getY();
		
		double largeRect3L = 2*Math.abs(Math.cos(7*Math.PI/10)*radius);
		double largeRect3H = 2*Math.abs(Math.sin(7*Math.PI/10)*radius);
		double largeRect3X = Math.cos(7*Math.PI/10)*radius+coord.getX();
		double largeRect3Y = -(Math.sin(7*Math.PI/10)*radius)+coord.getY();
		
		double largeRect4L = 2*Math.abs(Math.cos(6*Math.PI/10)*radius);
		double largeRect4H = 2*Math.abs(Math.sin(6*Math.PI/10)*radius);
		double largeRect4X = Math.cos(6*Math.PI/10)*radius+coord.getX();
		double largeRect4Y = -(Math.sin(6*Math.PI/10)*radius)+coord.getY();
		
		/*
		int parts = 5;
		int pas = 2*parts;
		int nbRectangles = parts-1;
		for(int i = 1; i < nbRectangles; i++){
			double largeRectL = 2*Math.abs(Math.cos((pas-i)*Math.PI/pas)*radius);
			double largeRectH = 2*Math.abs(Math.sin((pas-i)*Math.PI/pas)*radius);
			double largeRectX = Math.cos((pas-i)*Math.PI/pas)*radius+coord.getX();
			double largeRectY = -(Math.sin((pas-i)*Math.PI/pas)*radius)+coord.getY();
			hitBoxes.add(new Rectangle2D(largeRectL, largeRectH, largeRectX, largeRectY));
		}
		*/
		
		hitBoxes.add(new Rectangle2D(largeRect1X, largeRect1Y, largeRect1L, largeRect1H));
		hitBoxes.add(new Rectangle2D(largeRect2X, largeRect2Y, largeRect2L, largeRect2H));
		hitBoxes.add(new Rectangle2D(largeRect3X, largeRect3Y, largeRect3L, largeRect3H));
		hitBoxes.add(new Rectangle2D(largeRect4X, largeRect4Y, largeRect4L, largeRect4H));
		
	}
	
	@Override
	public boolean contains(double x, double y) {
		return false;
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		
		return false;
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
			double distance = getDistance(c.getCenter());
			if(distance < c.getRadius()+getRadius()){
				return true;
			}else{
				return false;
			}
			
		}else{
			int cmp = 0;
			for(Rectangle2D r2 : hitBoxes){
				if(r2.intersects(s)){
					return true;
				}
				cmp++;
			}
		}
		return false;
	}
	
	public double getDistance(Coordinate2D c2){
		double xA = coord.getX();
		double yA = coord.getY();
		double xB = c2.getX();
		double yB = c2.getY();
		
		return Math.sqrt((xB-xA)*(xB-xA)+(yB-yA)*(yB-yA));
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
    	final Rectangle2D r= new Rectangle2D(100, 100, 20, 20);
    	final Rectangle2D r2 = new Rectangle2D(110, 110, 15, 15);
    	final Rectangle2D r22 = new Rectangle2D(130, 130, 20, 20);
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
				g.setColor(Color.GREEN);
				//System.out.println((int)r22.getX()+" " +(int)r22.getY()+" "+ (int)r22.getWidth()+" "+ (int)r22.getHeight());
				g.drawRect((int)r22.getX(), (int)r22.getY(), (int)r22.getWidth(), (int)r22.getHeight());
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
