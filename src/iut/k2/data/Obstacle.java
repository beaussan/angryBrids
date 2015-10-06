package iut.k2.data;

import java.util.Random;

import iut.k2.physics.Coordinate2D;

public class Obstacle extends Entity {

	public Obstacle(Coordinate2D c) {
		super(c);
	}
	
	public void randomize(int limite){
		Random r = new Random();
		int x = r.nextInt(limite);
		int y = r.nextInt(limite);
		Coordinate2D cTmp = new Coordinate2D(x, y);
		c = new Coordinate2D(cTmp);
	}

}
