package iut.k2.physics.functions;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by PROPRIETAIRE on 29/09/2015.
 */
public class ArchimedeSpiral extends ParamCurve {
    public final double tMin = -10;
    public final double tMax = 10;
    public double a = 400;

    public ArchimedeSpiral(int a) {
        this.a = a;
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
        return a*(t* cos(t));
    }

    @Override
    public double y(double t) {
        return a*(t* sin(t));
    }

}
