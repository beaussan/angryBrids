package iut.k2.data.objects.Shapes;

public interface Shape {

	public boolean contains(double x, double y);
	/**
	 * Return true if all the points of the given shape are located in
	 * the Rectangle
	 */
	public boolean contains(double x, double y, double w, double h);
	public boolean contains(Rectangle2D r);
	public Rectangle getBounds();
	public Rectangle2D getBounds2D();
	/**
	 * If one point is contained is the current Shape, then
	 * it intersects it.
	 */
	public boolean intersects(double x, double y, double w, double h);
	public boolean intersects(Rectangle2D r2);
	
}
