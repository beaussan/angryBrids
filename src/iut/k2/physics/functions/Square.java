package iut.k2.physics.functions;

/**
 * Created by Nicolas Beaussart on 29/09/2015 for angryBrids.
 *
 */
public class Square extends ParamCurve {
    public final double tMin = -10;
    public final double tMax = 10;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public double x(double t) {
        return t;
    }

    /** {@inheritDoc} */
    @Override
    public double y(double t) {
        return -Math.pow(t, 2);
    }

}
