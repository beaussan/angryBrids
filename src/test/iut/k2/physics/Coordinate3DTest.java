package test.iut.k2.physics;

import iut.k2.physics.Coordinate3D;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Nicolas Beaussart on 29/09/15 for angryBrids.
 */
public class Coordinate3DTest {

    Coordinate3D toWork = new Coordinate3D(2,4,10);
    Coordinate3D toWork2 = new Coordinate3D(10,5,10);

    @Test
    public void testTimesSimple() throws Exception {
        assertEquals(toWork.times(2),new Coordinate3D(4,8,20));
        assertEquals(toWork.times(-2),new Coordinate3D(-4,-8,-20));
        assertEquals(toWork.times(0),new Coordinate3D(0,0,0));
    }

    @Test(expectedExceptions = { NullPointerException.class })
    public void testTimes2() throws Exception {
        assertEquals(toWork.times(new Coordinate3D(1,2,0.5)),new Coordinate3D(2,8,5));
        assertEquals(toWork.times(new Coordinate3D(3,2,2)),new Coordinate3D(6,8,20));
        assertEquals(toWork.times(new Coordinate3D(0,2,0)),new Coordinate3D(0,8,0));
        toWork.times(null);
    }


    @Test
    public void testTimes3() throws Exception {
        assertEquals(toWork.times(2,1,0.5),new Coordinate3D(4,4,5));
        assertEquals(toWork.times(-1,1,2),new Coordinate3D(-2,4,20));
        assertEquals(toWork.times(0,1,0),new Coordinate3D(0,4,0));
    }

    @Test
    public void testMinus1() throws Exception {
        assertEquals(toWork.minus(3, 9,4), new Coordinate3D(-1,-5,6));
        assertEquals(toWork.minus(3, 0,1), new Coordinate3D(-1, 4,9));
        assertEquals(toWork.minus(3, -3,-10), new Coordinate3D(-1, 7,20));
        assertEquals(toWork.minus(0, 0,0), toWork);
    }

    @Test(expectedExceptions = { NullPointerException.class })
    public void testMinus() throws Exception {
        assertEquals(toWork.minus(new Coordinate3D(3, 9,4)), new Coordinate3D(-1, -5,6));
        assertEquals(toWork.minus(new Coordinate3D(3, 0,1)), new Coordinate3D(-1, 4,9));
        assertEquals(toWork.minus(new Coordinate3D(3, -3,-10)), new Coordinate3D(-1, 7,20));
        assertEquals(toWork.minus(new Coordinate3D(0, 0,0)), toWork);
        toWork.minus(null);
    }


    @Test(expectedExceptions = { NullPointerException.class ,
            IllegalStateException.class,
            IllegalStateException.class})
    public void testDivide2() throws Exception {
        assertEquals(toWork2.divide(4, 2, 2), new Coordinate3D(2.5, 2.5, 5));
        assertEquals(toWork2.divide(4, -2, 4), new Coordinate3D(2.5, -2.5, 2.5));
        toWork2.times(0, 1, 1);
        toWork2.times(1, 0,1);
        toWork2.times(1, 1,0);

    }

    @Test(expectedExceptions = { NullPointerException.class , IllegalStateException.class,
            IllegalStateException.class, IllegalStateException.class})
    public void testDivide1() throws Exception {
        assertEquals(toWork2.divide(new Coordinate3D(4,2,2)),new Coordinate3D(2.5,2.5,5));
        assertEquals(toWork2.divide(new Coordinate3D(4, -2,2)), new Coordinate3D(2.5, -2.5,5));
        toWork2.divide(new Coordinate3D(0,1,1));
        toWork2.divide(new Coordinate3D(1,0,1));
        toWork2.divide(new Coordinate3D(1,1,0));
        toWork2.divide(null);
    }

    @Test(expectedExceptions = { IllegalStateException.class })
    public void testDivide() throws Exception {
        assertEquals(toWork.divide(2),new Coordinate3D(1,2,5));
        assertEquals(toWork.divide(-2),new Coordinate3D(-1,-2,-5));
        toWork.times(0);
    }

    @Test
    public void testAdd1() throws Exception {
        assertEquals(toWork.add(3,9,2), new Coordinate3D(5, 13,12));
        assertEquals(toWork.add(3,0,5), new Coordinate3D(5, 4,15));
        assertEquals(toWork.add(3,-3,-5), new Coordinate3D(5, 1, 5));
        assertEquals(toWork.add(0,0,0), toWork);
    }

    @Test(expectedExceptions = { NullPointerException.class })
    public void testAdd() throws Exception {
        assertEquals(toWork.add(new Coordinate3D(3,9,2)), new Coordinate3D(5, 13,12));
        assertEquals(toWork.add(new Coordinate3D(3,0,5)), new Coordinate3D(5, 4,15));
        assertEquals(toWork.add(new Coordinate3D(3,-3,-5)), new Coordinate3D(5, 1,5));
        assertEquals(toWork.add(new Coordinate3D(0,0,0)), toWork);

        toWork.add(null);

    }
}