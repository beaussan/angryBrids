package iut.k2.data.functions;

import iut.k2.physics.Coordinate2D;

/**
 * Created by Nicolas Beaussart on 29/09/15 for angryBrids.
 */
public abstract class AbstractFunction {


    abstract public Coordinate2D getResultat(Coordinate2D cords, double movement);
}
