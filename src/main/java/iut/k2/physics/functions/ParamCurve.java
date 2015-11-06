package iut.k2.physics.functions;

/**
 * Created by Nicolas Beaussart on 29/09/2015 for angryBrids.
 *
 */
public abstract class ParamCurve {
    /**
     * Getter for property 'TMax'.
     *
     * @return Value for property 'TMax'.
     */
    public abstract double getTMax();

    /**
     * Getter for property 'TMin'.
     *
     * @return Value for property 'TMin'.
     */
    public abstract double getTMin();

    public abstract double x(double t);

    public abstract double y(double t);

}
