package iut.k2;

import iut.k2.data.Level;
import iut.k2.data.objects.AbstractGameObject;
import iut.k2.data.objects.Square;

import java.util.List;
import java.util.Map;

public class SquareVisitor implements ObstacleVisitor {

	@Override
	public void visit(Level l) {
		int total = 0;
		for(AbstractGameObject obstacle :l.getLsObjects().get(2)){
			if(obstacle instanceof Square)
				total++;
		}
		System.out.println("nombre de carré(s) généré(s): " + total);
	}
}
