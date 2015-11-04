package test.iut.k2.physics;

import iut.k2.physics.Coordinate2D;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Coordinate2DTest {

    Coordinate2D toWork = new Coordinate2D(2,4);
    Coordinate2D toWork2 = new Coordinate2D(10,5);

    @Test(expectedExceptions = {NullPointerException.class})
    public void testAdd() throws Exception {
        assertEquals(toWork.add(new Coordinate2D(3, 9)), new Coordinate2D(5, 13));
        assertEquals(toWork.add(new Coordinate2D(3, 0)), new Coordinate2D(5, 4));
        assertEquals(toWork.add(new Coordinate2D(3, -3)), new Coordinate2D(5, 1));
        assertEquals(toWork.add(new Coordinate2D(0, 0)), toWork);

        toWork.add(null);

    }

    @Test
    public void testAdd1() throws Exception {
        assertEquals(toWork.add(3, 9), new Coordinate2D(5, 13));
        assertEquals(toWork.add(3, 0), new Coordinate2D(5, 4));
        assertEquals(toWork.add(3, -3), new Coordinate2D(5, 1));
        assertEquals(toWork.add(0, 0), toWork);
    }

    @Test(expectedExceptions = {IllegalStateException.class})
    public void testDivide() throws Exception {
        assertEquals(toWork.divide(2), new Coordinate2D(1, 2));
        assertEquals(toWork.divide(-2), new Coordinate2D(-1, -2));
        toWork.divide(0);
    }

    @Test(expectedExceptions = {NullPointerException.class, IllegalStateException.class, IllegalStateException.class})
    public void testDivide1() throws Exception {
        assertEquals(toWork2.divide(new Coordinate2D(4, 2)), new Coordinate2D(2.5, 2.5));
        assertEquals(toWork2.divide(new Coordinate2D(4, -2)), new Coordinate2D(2.5, -2.5));
        toWork2.divide(new Coordinate2D(0, 1));
        toWork2.divide(new Coordinate2D(1, 0));
        toWork2.divide(null);
    }

    @Test(expectedExceptions = {NullPointerException.class, IllegalStateException.class})
    public void testDivide2() throws Exception {
        assertEquals(toWork2.divide(4, 2), new Coordinate2D(2.5, 2.5));
        assertEquals(toWork2.divide(4, -2), new Coordinate2D(2.5, -2.5));
        assertEquals(toWork2.divide(null), new Coordinate2D(2.5, -2.5));
        toWork2.times(0, 1);
        toWork2.times(1, 0);
    }

    @Test(expectedExceptions = {NullPointerException.class})
    public void testMinus() throws Exception {
        assertEquals(toWork.minus(new Coordinate2D(3, 9)), new Coordinate2D(-1, -5));
        assertEquals(toWork.minus(new Coordinate2D(3, 0)), new Coordinate2D(-1, 4));
        assertEquals(toWork.minus(new Coordinate2D(3, -3)), new Coordinate2D(-1, 7));
        assertEquals(toWork.minus(new Coordinate2D(0, 0)), toWork);
        toWork.minus(null);
    }

    @Test
    public void testMinus1() throws Exception {
        assertEquals(toWork.minus(3, 9), new Coordinate2D(-1,-5));
        assertEquals(toWork.minus(3, 0), new Coordinate2D(-1, 4));
        assertEquals(toWork.minus(3, -3), new Coordinate2D(-1, 7));
        assertEquals(toWork.minus(0, 0), toWork);
    }

    @Test(expectedExceptions = { NullPointerException.class })
    public void testTimes2() throws Exception {
        assertEquals(toWork.times(new Coordinate2D(1, 2)), new Coordinate2D(2, 8));
        assertEquals(toWork.times(new Coordinate2D(3, 2)), new Coordinate2D(6, 8));
        assertEquals(toWork.times(new Coordinate2D(0, 2)), new Coordinate2D(0, 8));
        toWork.times(null);
    }

    @Test
    public void testTimes3() throws Exception {
        assertEquals(toWork.times(2, 1), new Coordinate2D(4, 4));
        assertEquals(toWork.times(-1, 1), new Coordinate2D(-2, 4));
        assertEquals(toWork.times(0, 1), new Coordinate2D(0, 4));
    }

    @Test
    public void testTimesSimple1() throws Exception {
        assertEquals(toWork.times(2), new Coordinate2D(4, 8));
    }

    @Test
    public void testTimesSimple2() throws Exception {
        assertEquals(toWork.times(-2), new Coordinate2D(-4, -8));
    }

    @Test
    public void testTimesSimple3() throws Exception {
        assertEquals(toWork.times(0), new Coordinate2D(0, 0));
    }
}