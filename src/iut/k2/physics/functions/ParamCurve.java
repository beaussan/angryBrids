package iut.k2.physics.functions;

/**
 * Created by PROPRIETAIRE on 29/09/2015.
 */
public abstract class ParamCurve {
    public abstract double getTMax();

    public abstract double getTMin();

    public abstract double x(double t);

    public abstract double y(double t);

}
