package iut.k2.data;


import iut.k2.physics.Coordinate2D;

public abstract class Entite{

	private Coordinate2D c;
	private double positionBec;

	public Entite(Coordinate2D c) {
		this.c = c;
	}
	
	public void move(int x, int y){
		int tmpX = getCoordonnees().getX();
		int tmpY = getCoordonnees().getY();

		setCoordonnees(new Coordinate2D(tmpX + x, tmpY + y));
	}

	public Coordinate2D getCoordonnees() {
		return c;
	}

	public void setCoordonnees(Coordinate2D c) {
		this.c = c;
	}
	
}
