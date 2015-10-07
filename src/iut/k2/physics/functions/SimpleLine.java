package iut.k2.physics.functions;

/**
 * Created by Nicolas Beaussart on 07/10/15 for angryBrids.
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

    @Override
    public double getTMax() {
        return tMax;
    }

    @Override
    public double getTMin() {
        return tMin;
    }

    @Override
    public double x(double t) {
        return t * x;
    }

    @Override
    public double y(double t) {
        return t * y;
    }
}
