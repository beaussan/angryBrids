package iut.k2.physics;

import iut.k2.data.objects.Shapes.Rectangle2D;
import iut.k2.physics.Coordinate2D;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class Rectangle2DTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    @Test
    public void containsTest(){
    	Rectangle2D r2 = new Rectangle2D(30, 30, 20, 20);
    	Coordinate2D c1 = new Coordinate2D(30, 30);
    	Coordinate2D c2 = new Coordinate2D(30, 50);
    	Coordinate2D c3 = new Coordinate2D(50, 30);
    	Coordinate2D c4 = new Coordinate2D(50, 50);
    	Coordinate2D c5 = new Coordinate2D(40, 40);
    	Coordinate2D c6 = new Coordinate2D(29, 29);
    	Coordinate2D c7 = new Coordinate2D(50, 51);
    	
    	assertTrue(r2.contains(c1.getX(), c1.getY()));
    	assertTrue(r2.contains(c2.getX(), c2.getY()));
    	assertTrue(r2.contains(c3.getX(), c3.getY()));
    	assertTrue(r2.contains(c4.getX(), c4.getY()));
    	assertTrue(r2.contains(c5.getX(), c5.getY()));
    	assertFalse(r2.contains(c6.getX(), c6.getY()));
    	assertFalse(r2.contains(c7.getX(), c7.getY()));
    	
    }
    
}