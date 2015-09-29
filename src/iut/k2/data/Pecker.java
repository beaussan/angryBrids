package iut.k2.data;

import java.awt.Graphics;

import javax.swing.JComponent;

import iut.k2.physics.Coordinate2D;
import iut.k2.physics.Vector;

public class Pecker extends Entity {

	double positionBec;
	Vector vector;

	public Pecker(Coordinate2D c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	public void updateBec(double radian){
		//TODO radian = vector.
		positionBec = radian%(2*Math.PI);
	}
	
	public double getPositionBec(){
		return positionBec;
	}
	
 
}


