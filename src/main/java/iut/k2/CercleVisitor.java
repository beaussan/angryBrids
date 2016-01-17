package iut.k2;

import iut.k2.data.Level;
import iut.k2.data.objects.AbstractGameObject;
import iut.k2.data.objects.Balloon;
import iut.k2.data.objects.Cadre;
import iut.k2.data.objects.Cercle;
import iut.k2.data.objects.Rocher;

import java.util.List;
import java.util.Map;

public class CercleVisitor implements ObstacleVisitor {

	@Override
	public void visit(Level l) {
		int total = 0;
		int cadre = 0;
		int balloon = 0;
		int brick = 0;
		
		for(AbstractGameObject obstacle :l.getLsObjects().get(2)){
			if(obstacle instanceof Cercle)
				total++;
			if(obstacle instanceof Cadre)
				cadre++;
			else if(obstacle instanceof Balloon)
				balloon++;
			else if(obstacle instanceof Rocher)
				brick++;
		}
		System.out.println("nombre de cercle(s) généré(s): " + total);
		System.out.println("nombre de ballon(s) généré(s): " + balloon);
		System.out.println("nombre de cadre(s) généré(s): " + cadre);
		System.out.println("nombre de rocher(s) généré(s): " + brick);

	}
}
