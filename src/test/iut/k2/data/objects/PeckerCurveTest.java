package test.iut.k2.data.objects;

import iut.k2.data.objects.Obstacle;
import iut.k2.data.objects.PeckerCurve;
import iut.k2.physics.Coordinate2D;
import iut.k2.physics.functions.ParamCurve;
import iut.k2.physics.functions.SimpleLine;

import org.testng.annotations.Test;

import junit.framework.TestCase;

/**
 * Created by Nicolas Beaussart on 04/11/15 for angryBrids.
 */
public class PeckerCurveTest extends TestCase {

    @Test
    public void testUpdate() throws Exception {
        ParamCurve curve = new SimpleLine(1, 1, 300, 300);
        PeckerCurve peckerCurve = new PeckerCurve(new Coordinate2D(0, 0), curve);
        peckerCurve.update(1000);
        assertEquals("" + peckerCurve.getCoordinate().getX(), "" + PeckerCurve.SPEED);
        assertEquals("" + peckerCurve.getCoordinate().getY(), "" + PeckerCurve.SPEED);
    }
    
    public void testCollision() throws Exception{
    	ParamCurve curve = new SimpleLine(1, 1, 300, 300);
    	PeckerCurve peckerCurve = new PeckerCurve(new Coordinate2D(0,0), curve);
    	Obstacle obstacle = new Obstacle(new Coordinate2D(200,200));
    	Obstacle obstacle2 = new Obstacle(new Coordinate2D(0,0));
    	System.out.println("Avant: x:" + peckerCurve.getCoordinate().getX() + " y:" + peckerCurve.getCoordinate().getY());
    	System.out.println("Avant(obstacle): x:" + obstacle.getCoordinate().getX() + " y:" + obstacle.getCoordinate().getY());
    	peckerCurve.update(1000);
    	System.out.println("Après: x:" + peckerCurve.getCoordinate().getX() + " y:" + peckerCurve.getCoordinate().getY());
    	System.out.println("Après(obstacle): x:" + obstacle.getCoordinate().getX() + " y:" + obstacle.getCoordinate().getY());
    	assertTrue(peckerCurve.overlap(obstacle));
    	assertFalse(peckerCurve.overlap(obstacle2));
    	
    }
}
