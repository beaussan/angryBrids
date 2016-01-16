package iut.k2;

import iut.k2.data.objects.Cercle;
import iut.k2.data.objects.Obstacle;
import iut.k2.data.objects.Square;
import iut.k2.physics.Coordinate2D;

public class ObstacleFactory {
	public static Obstacle getObstacle(String nom, Coordinate2D coord) throws Exception{
		Obstacle o;
		
		switch(nom){
			case "cercle":
				o = new Cercle(coord);
				break;
			case "carre":
				o = new Square(coord);
				break;
			default:
				throw new Exception("Obstacle : " + nom + " non connu");
				
		}
		return o;
}
}
