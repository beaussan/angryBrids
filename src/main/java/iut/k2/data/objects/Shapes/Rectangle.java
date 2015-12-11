package iut.k2.data.objects.Shapes;

import iut.k2.physics.Coordinate2D;

public class Rectangle implements Shape{

	private int x;
	private int y;
	private int width;
	private int height;
	
	public Rectangle(){
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}
	
	public Rectangle(int width, int height){
		x = 0;
		y = 0;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	@Override
	public boolean contains(double x, double y) {
		int xMin = this.x;
		int xMax = xMin + width;
		int yMin = this.y;
		int yMax = yMin + height;
		return (x >= xMin && x <= xMax) && (y >= yMin && y <= yMax);
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		boolean retour = true;
		
		//Données de la figure en paramère
		double xMin = x;
		double xMax = x + w;
		double yMin = y;
		double yMax = y + h;
		
		retour = retour && contains(xMin, yMin);
		retour = retour && contains(xMin, yMax);
		retour = retour && contains(xMax, yMin);
		retour = retour && contains(xMax, yMax);
		
		return retour;
	}

	/*
	@Override
	public boolean contains(Rectangle2D r) {
		//Données de la figure en paramère
		double xMin = r.getX();
		double yMin = r.getY();
		double width = r.getWidth();
		double height = r.getHeight();
		
		return contains(xMin, yMin, width, height);
	}
	*/

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y , width, height);
	}
	
	@Override
	public Rectangle2D getBounds2D() {
		double x = (double) this.x;
		double y = (double) this.y;
		double width = (double)(this.width);
		double height = (double)(this.height);
		return new Rectangle2D(x, y, width, height);
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		boolean retour;
		
		double xMin = x;
		double xMax = x + width;
		double yMin = y;
		double yMax = y + height;
		
		retour = contains(xMin,yMin) || 
				contains(xMin,yMax) ||
				contains(xMax,yMin) ||
				contains(xMax,yMax);
		
		return retour;
	}

	@Override
	public boolean intersects(Shape s) {
		if(s instanceof Rectangle2D){
			Rectangle2D r2 = (Rectangle2D)s;
			return intersects(r2.getX(), 
				r2.getY(), 
				r2.getWidth(), 
				r2.getHeight());
		}else if(s instanceof Circle){
			Circle c = (Circle)s;
			return s.intersects(this);
		}
		return false;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public boolean contains(Shape s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move(Coordinate2D c) {
		x += c.getX();
		y += c.getY();
	}

}
