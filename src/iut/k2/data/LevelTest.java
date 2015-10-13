package iut.k2.data;

import iut.k2.Constants;
import iut.k2.physics.Coordinate2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LevelTest extends Level{

	/**
	 * Le level de test contiendra 1 Pecker et 5 à 10 obstacles
	 */
	public void init() {
		Random r = new Random();
		int nbObstacles = r.nextInt(6)+5;
		
		//Création de l'oiseau
		Pecker p = new Pecker(new Coordinate2D(0,0));
		
			//Ajout dans la liste entity
			getLsEntitys().add(p);
			//Ajout dans la map AbstractGameObject
			List<AbstractGameObject> listePecker = new ArrayList<AbstractGameObject>();
			listePecker.add(p);
			getLsObjects().put(1, listePecker);
		
			List<AbstractGameObject> listeObstacle = new ArrayList<AbstractGameObject>();
		for(int i = 0; i < nbObstacles; i++){
			//Coordonnées de l'obstacle
			int x = r.nextInt(Constants.SIZE_WIDE/2)+Constants.SIZE_WIDE/2;
			int y = r.nextInt(Constants.SIZE_HEIGHT);
			
			//Création d'un obstacle
			Obstacle o = new Obstacle(new Coordinate2D(x, y));
			
			//Ajout de l'obstacle dans la liste entity
			getLsEntitys().add(o);
			
			//Ajout de l'obstace dans la map AbstractGameObject
			listeObstacle.add(o);
			getLsObjects().put(2, listeObstacle);
		}
		
	}

}
