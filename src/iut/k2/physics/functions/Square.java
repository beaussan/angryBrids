package iut.k2.physics.functions;

/**
 * Created by PROPRIETAIRE on 29/09/2015.
 */
public class Square extends ParamCurve {
    public final double tMin = -10;
    public final double tMax = 10;

    @Override
    public double getTMin() {
        return tMin;
    }

    @Override
    public double getTMax() {
        return tMax;
    }

    @Override
    public double x(double t) {
        return t;
    }

    @Override
    public double y(double t) {
        return -Math.pow(t, 2);
    }

    @Override
    public double xPrim(double t) {
        return 1;
    }

    @Override
    public double yPrim(double t) {
        return -t;
    }
}
