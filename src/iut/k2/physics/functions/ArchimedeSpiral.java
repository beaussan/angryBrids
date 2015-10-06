package iut.k2.physics.functions;

import static java.lang.Math.*;

/**
 * Created by PROPRIETAIRE on 29/09/2015.
 */
public class ArchimedeSpiral extends ParamCurve {
    public final double tMin = -10;
    public final double tMax = 10;
    public final double a = 400;

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
        return a*(t* cos(t));
    }

    @Override
    public double y(double t) {
        return a*(t* sin(t));
    }

    @Override
    public double xPrim(double t) {
        return (cos(t)-t* sin(t))/ sqrt(1 + pow(t, 2));
    }

    @Override
    public double yPrim(double t) {
        return (t*cos(t)-sin(t))/ sqrt(1 + pow(t, 2));
    }
}
