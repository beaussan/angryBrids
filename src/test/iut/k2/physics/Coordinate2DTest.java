package test.iut.k2.physics;

import iut.k2.physics.Coordinate2D;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class Coordinate2DTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

	Coordinate2D toWork = new Coordinate2D(2, 4);
	Coordinate2D toWork2 = new Coordinate2D(10, 5);

    @Test
    public void testAdd() {
        assertEquals(toWork.add(new Coordinate2D(3, 9)),
				new Coordinate2D(5, 13));
		assertEquals(toWork.add(new Coordinate2D(3, 0)), new Coordinate2D(5, 4));
		assertEquals(toWork.add(new Coordinate2D(3, -3)),
				new Coordinate2D(5, 1));
		assertEquals(toWork.add(new Coordinate2D(0, 0)), toWork);

        exception.expect(NullPointerException.class);
        toWork.add(null);

	}

	@Test
    public void testAdd1() {
        assertEquals(toWork.add(3, 9), new Coordinate2D(5, 13));
		assertEquals(toWork.add(3, 0), new Coordinate2D(5, 4));
		assertEquals(toWork.add(3, -3), new Coordinate2D(5, 1));
		assertEquals(toWork.add(0, 0), toWork);
	}

    @Test
    public void testDivdeExp4() {
        exception.expect(IllegalStateException.class);
        toWork.divide(0);
    }

    @Test
    public void testDivide() {
        assertEquals(toWork.divide(2), new Coordinate2D(1, 2));
		assertEquals(toWork.divide(-2), new Coordinate2D(-1, -2));

        exception.expect(IllegalStateException.class);
        toWork.divide(0);
	}

    @Test
    public void testDivide1() {
        assertEquals(toWork2.divide(new Coordinate2D(4, 2)), new Coordinate2D(
                2.5, 2.5));
		assertEquals(toWork2.divide(new Coordinate2D(4, -2)), new Coordinate2D(
                2.5, -2.5));
	}

    @Test
    public void testDivide2() {
        assertEquals(toWork2.divide(4, 2), new Coordinate2D(2.5, 2.5));
		assertEquals(toWork2.divide(4, -2), new Coordinate2D(2.5, -2.5));

        exception.expect(NullPointerException.class);
        assertEquals(toWork2.divide(null), new Coordinate2D(2.5, -2.5));

        exception.expect(IllegalStateException.class);
        toWork2.divide(0, 1);

        exception.expect(IllegalStateException.class);
        toWork2.divide(1, 0);
    }

    @Test
    public void testDivideExp1() {
        exception.expect(IllegalStateException.class);
        toWork2.divide(new Coordinate2D(0, 1));
    }

    @Test
    public void testDivideExp2() {
        exception.expect(IllegalStateException.class);
        toWork2.divide(new Coordinate2D(1, 0));
    }

    @Test
    public void testDivideExp3() {
        exception.expect(NullPointerException.class);
        toWork2.divide(null);
    }

    @Test
    public void testMinus() {
        assertEquals(toWork.minus(new Coordinate2D(3, 9)), new Coordinate2D(-1,
				-5));
		assertEquals(toWork.minus(new Coordinate2D(3, 0)), new Coordinate2D(-1,
				4));
		assertEquals(toWork.minus(new Coordinate2D(3, -3)), new Coordinate2D(
				-1, 7));
		assertEquals(toWork.minus(new Coordinate2D(0, 0)), toWork);

        exception.expect(NullPointerException.class);
        toWork.minus(null);
	}

	@Test
    public void testMinus1() {
        assertEquals(toWork.minus(3, 9), new Coordinate2D(-1, -5));
		assertEquals(toWork.minus(3, 0), new Coordinate2D(-1, 4));
		assertEquals(toWork.minus(3, -3), new Coordinate2D(-1, 7));
		assertEquals(toWork.minus(0, 0), toWork);
	}

    @Test
    public void testTimes2() {
        assertEquals(toWork.times(new Coordinate2D(1, 2)), new Coordinate2D(2,
				8));
		assertEquals(toWork.times(new Coordinate2D(3, 2)), new Coordinate2D(6,
				8));
		assertEquals(toWork.times(new Coordinate2D(0, 2)), new Coordinate2D(0,
				8));

        exception.expect(NullPointerException.class);
        toWork.times(null);
	}

	@Test
    public void testTimes3() {
        assertEquals(toWork.times(2, 1), new Coordinate2D(4, 4));
		assertEquals(toWork.times(-1, 1), new Coordinate2D(-2, 4));
		assertEquals(toWork.times(0, 1), new Coordinate2D(0, 4));
	}

	@Test
    public void testTimesSimple1() {
        assertEquals(toWork.times(2), new Coordinate2D(4, 8));
	}

	@Test
    public void testTimesSimple2() {
        assertEquals(toWork.times(-2), new Coordinate2D(-4, -8));
	}

	@Test
    public void testTimesSimple3() {
        assertEquals(toWork.times(0), new Coordinate2D(0, 0));
	}
}
