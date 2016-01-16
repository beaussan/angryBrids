package iut.k2;

import iut.k2.data.Level;
import iut.k2.data.objects.AbstractGameObject;

import java.util.List;
import java.util.Map;

public interface ObstacleVisitor {

	public void visit(Level l);

}
