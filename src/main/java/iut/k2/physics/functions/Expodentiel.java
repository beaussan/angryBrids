package iut.k2.physics.functions;

/**
 * Created by Nicolas Beaussart on 06/11/15 for AngriBrids.
 */
public class Expodentiel extends ParamCurve {
    final float factor;

    public Expodentiel(float factor) {
        this.factor = factor;
    }


    @Override
    public double getTMax() {
        return 200;
    }

    @Override
    public double getTMin() {
        return 0;
    }

    @Override
    public double x(double t) {
        return t * factor;
    }

    @Override
    public double y(double t) {
        return Math.exp(t * 2);
    }
}
