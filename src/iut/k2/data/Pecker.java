package iut.k2.data;

import iut.k2.physics.Coordinate2D;

public class Pecker extends Entite{

	double positionBec;

	public Pecker(Coordinate2D c) {
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
