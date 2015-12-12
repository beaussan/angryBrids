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
    public void collisionCercleCercle(){
    	Circle c = new Circle(100, 100, 20);
    	Circle c2 = new Circle(100, 120, 20);
    	Circle c3 = new Circle(90, 133, 10);
    	
    	assertTrue(c.intersects(c2));
    	assertFalse(c.intersects(c3));
    }
    
    @Test
    public void collisionRectangleRectangle(){
    	//Gris
    	Rectangle2D r= new Rectangle2D(100, 100, 20, 20);
    	//Rouge
    	Rectangle2D r2 = new Rectangle2D(120, 120, 15, 15);
    	//Vert
    	Rectangle2D r22 = new Rectangle2D(130, 130, 20, 20);
    	
    	assertTrue(r.intersects(r2));
    	assertTrue(r2.intersects(r));
    	
    	assertFalse(r.intersects(r22));
    	assertFalse(r22.intersects(r));
    	
    	assertTrue(r2.intersects(r22));
    	assertTrue(r22.intersects(r2));
    	
    }
    
    /**
     * Can fail due to the choice of the precision for the hitboxes of the Circle
     * The more Rectangle there are, the more precise the hitBox of the Circle will get
     */
    @Test
    public void collisionCircleRectangle() {
    	Circle c = new Circle(100, 100, 20);
    	Rectangle2D r2 = new Rectangle2D(60, 60, 15, 15);
    	Rectangle2D r22 = new Rectangle2D(94, 94, 20, 20);
    	
    	assertTrue(c.intersects(r2));
    	assertFalse(c.intersects(r22));
    	assertTrue(r2.intersects(c));
    	assertFalse(r22.intersects(c));
    }
    
}
