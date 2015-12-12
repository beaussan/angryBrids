package iut.k2.data.objects.Shapes;

import iut.k2.physics.Coordinate2D;

public class Polygon implements Shape{

	private int[] arrayX;
	private int[] arrayY;
	private int nbPoints;
	
	public Polygon(int[] arrayX, int[] arrayY, int nbPoints) {
		this.arrayX = arrayX;
		this.arrayY = arrayY;
		this.nbPoints = nbPoints;
	}

	public void setArrayX(int[] arrayX) {
		this.arrayX = arrayX;
	}

	public void setArrayY(int[] arrayY) {
		this.arrayY = arrayY;
	}

	public int[] getArrayX() {
		return arrayX;
	}

	public int[] getArrayY() {
		return arrayY;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	@Override
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Shape s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intersects(Shape s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move(Coordinate2D c) {
		// TODO Auto-generated method stub
		
	}
	
	

}
