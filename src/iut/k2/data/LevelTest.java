package iut.k2.data;

import iut.k2.physics.Coordinate2D;

import java.util.Random;

public class LevelTest extends Level{

	/**
	 * Le level de test contiendra 1 Pecker et 5 à 10 obstacles
	 */
	public void init() {
		// TODO Auto-generated method stub
		Random r = new Random();
		getLsEntitys().add(new Pecker(new Coordinate2D(0,0)));
		int nbObstacles = r.nextInt(6)+5;
		
		for(int i = 0; i < nbObstacles; i++){
			int x = r.nextInt(Constants.SIZE_WIDE/2)+largEcran/2;
			int y = r.nextInt(hautEcran);
			getLsEntitys().add(new Obstacle(new Coordinate2D(x, y)));
		}
		
	}

}
