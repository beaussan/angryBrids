package iut.k2.data;

import iut.k2.physics.Coordinate2D;

import java.util.Random;

public class Obstacle extends Entity {

	int largEcran = 700;
	int hautEcran = 500;
	
	public Obstacle(Coordinate2D c) {
		super(c);
		randomize();
	}

	public void randomize(){
		Random r = new Random();
		int x = r.nextInt(largEcran/2)+largEcran/2;
		int y = r.nextInt(hautEcran);
		setCoordinate(new Coordinate2D(x, y));
	}

	@Override
	public void update(float deltaTime) {

	}

}
