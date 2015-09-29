package iut.k2.data;

import java.awt.Graphics;

import javax.swing.JComponent;

import iut.k2.physics.Coordinate2D;

public class Pecker extends Entity {

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


