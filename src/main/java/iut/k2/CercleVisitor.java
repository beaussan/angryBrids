package iut.k2;

import iut.k2.data.Level;
import iut.k2.data.objects.AbstractGameObject;
import iut.k2.data.objects.Cercle;

import java.util.List;
import java.util.Map;

public class CercleVisitor implements ObstacleVisitor {

	@Override
	public void visit(Level l) {
		int total = 0;
		for(AbstractGameObject obstacle :l.getLsObjects().get(2)){
			if(obstacle instanceof Cercle)
				total++;
		}
		System.out.println("nombre de cercle(s) généré(s): " + total);
	}
}
