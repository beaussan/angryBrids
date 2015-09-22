package entities;

import physics.Coordonnees;

public abstract class Entite{

	private Coordonnees c;
	private double positionBec;
	
	public Entite(Coordonnees c){
		this.c = c;
	}
	
	public void move(int x, int y){
		int tmpX = getCoordonnees().getX();
		int tmpY = getCoordonnees().getY();
		
		setCoordonnees(new Coordonnees(tmpX+x, tmpY+y));
	}
	
	public void setCoordonnees(Coordonnees c){
		this.c = c;
	}
	
	public Coordonnees getCoordonnees(){
		return c;	
	}
	
}
