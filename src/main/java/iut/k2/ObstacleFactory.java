package iut.k2;

import iut.k2.data.objects.Balloon;
import iut.k2.data.objects.Cadre;
import iut.k2.data.objects.Cercle;
import iut.k2.data.objects.Obstacle;
import iut.k2.data.objects.Rocher;
import iut.k2.data.objects.Square;
import iut.k2.physics.Coordinate2D;

public class ObstacleFactory {
	public static Obstacle getObstacle(String nom, Coordinate2D coord) throws Exception{
		Obstacle o;
		
		switch(nom){
			case "cadre":
				o = new Cadre(coord);
				break;
			case "balloon":
				o = new Balloon(coord);
				break;
			case "rocher":
				o = new Rocher(coord);
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
