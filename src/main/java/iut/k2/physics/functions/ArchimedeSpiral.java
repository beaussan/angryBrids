package iut.k2.physics.functions;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by Nicolas Beaussart on 29/09/2015 for angryBrids.
 *
 */
public class ArchimedeSpiral extends ParamCurve {
    public final double tMin = -10;
    public final double tMax = 10;
    public double a = 400;

    public ArchimedeSpiral(int a) {
        this.a = a;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getTMax() {
        return tMax;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getTMin() {
        return tMin;
    }

    @Override
    public String toString() {
        return "ArchimedeSpirale{x=" + a + "*(t*cos(t); y=" + a + "*(t*sin(t) } ";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double x(double t) {
        return a*(t* cos(t));
    }

    /** {@inheritDoc} */
    @Override
    public double y(double t) {
        return a*(t* sin(t));
    }
}
