package test.iut.k2.data.objects;

import iut.k2.data.objects.PeckerCurve;
import iut.k2.physics.Coordinate2D;
import iut.k2.physics.functions.ParamCurve;
import iut.k2.physics.functions.SimpleLine;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Nicolas Beaussart on 04/11/15 for angryBrids.
 */
public class PeckerCurveTest {

    @Test
    public void testUpdate() throws Exception {
        ParamCurve curve = new SimpleLine(1, 1, 300, 300);
        PeckerCurve peckerCurve = new PeckerCurve(new Coordinate2D(0, 0), curve);
        peckerCurve.update(1000);
        Assert.assertEquals("" + peckerCurve.getCoordinate().getX(), "" + PeckerCurve.SPEED);
        Assert.assertEquals("" + peckerCurve.getCoordinate().getY(), "" + PeckerCurve.SPEED);
    }
}