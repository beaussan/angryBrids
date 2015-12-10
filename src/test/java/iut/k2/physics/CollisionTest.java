package iut.k2.physics;

import iut.k2.data.objects.Shapes.Circle;
import iut.k2.data.objects.Shapes.Rectangle2D;
import iut.k2.physics.Coordinate2D;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CollisionTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void collisionCircleRectangle() {
    	Circle c = new Circle(100, 100, 20);
    	Rectangle2D r2 = new Rectangle2D(73, 73, 15, 15);
    	Rectangle2D r22 = new Rectangle2D(100, 100, 20, 20);
    	
    	assertTrue(c.intersects(r22));
    	assertFalse(c.intersects(r2));
    	assertTrue(r22.intersects(c));
    	assertFalse(r2.intersects(c));
    }
    
    @Test
    public void collisionCercleCercle(){
    	Circle c = new Circle(100, 100, 20);
    	Circle c2 = new Circle(100, 120, 20);
    	Circle c3 = new Circle(90, 133, 10);
    	
    	assertTrue(c.intersects(c2));
    	assertFalse(c.intersects(c3));
    }
    
}
