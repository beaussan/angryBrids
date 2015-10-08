package iut.k2.physics.functions;

/**
 * Created by Nicolas Beaussart on 07/10/15 for angryBrids for angryBrids.
 *
 */
public class SimpleLine extends ParamCurve {
    private final double x;
    private final double y;
    private final double tMax;
    private final double tMin;

    public SimpleLine(double x, double y, double tMax, double tMin) {
        this.x = x;
        this.y = y;
        this.tMax = tMax;
        this.tMin = tMin;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public double x(double t) {
        return t * x;
    }

    /** {@inheritDoc} */
    @Override
    public double y(double t) {
        return t * y;
    }
}
