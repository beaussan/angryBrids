package entities;

import physics.Coordonnees;

public class Pecker extends Entite{

	double positionBec;
	
	public Pecker(Coordonnees c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	public void updateBec(double radian){
		positionBec = radian;
	}
	
	public double getPositionBec(){
		return positionBec;
	}

}
