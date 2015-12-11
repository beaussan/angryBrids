package iut.k2.data.objects.Shapes;

import iut.k2.physics.Coordinate2D;

public interface Shape {

	public boolean contains(double x, double y);
	/**
	 * Return true if all the points of the given shape are located in
	 * the Rectangle
	 */
	public boolean contains(double x, double y, double w, double h);
	public boolean contains(Shape s);
	public Rectangle getBounds();
	public Rectangle2D getBounds2D();
	/**
	 * If one point is contained is the current Shape, then
	 * it intersects it.
	 */
	public boolean intersects(double x, double y, double w, double h);
	public boolean intersects(Shape s);
	
	public void move(Coordinate2D c);
	
}
