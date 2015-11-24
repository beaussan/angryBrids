package iut.k2.data.objects.Shapes;

public class Rectangle2D implements Shape{

	private double x;
	private double y;
	private double width;
	private double height;
	
	public Rectangle2D(double x, double y, double width, double height){
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public boolean contains(double x, double y) {
		double xMin = this.x;
		double xMax = xMin + width;
		double yMin = this.y;
		double yMax = yMin + height;
		return (x > xMin && x < xMax) && (y > yMin && y < yMax);
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

	@Override
	public boolean contains(Rectangle2D r) {
		//Données de la figure en paramère
		double xMin = r.getX();
		double yMin = r.getY();
		double width = r.getWidth();
		double height = r.getHeight();
		
		return contains(xMin, yMin, width, height);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y , (int)width, (int)height);
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
	public boolean intersects(Rectangle2D r2) {
		return intersects(r2.getX(), 
				r2.getY(), 
				r2.getWidth(), 
				r2.getHeight());
	}

}
