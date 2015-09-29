package iut.k2.data.functions;

import iut.k2.physics.Coordinate2D;

/**
 * Created by Nicolas Beaussart on 29/09/15 for angryBrids.
 */
public class SquareSimple extends AbstractFunction {

    private static SquareSimple instance = null;

    public static AbstractFunction getInstance(){
        if (instance == null){
            instance = new SquareSimple();
        }
        return instance;
    }

    private SquareSimple() {
    }

    @Override
    public Coordinate2D getResultat(Coordinate2D cords, double movement) {
        double xMp = cords.getX()+movement;
        double yMp = Math.pow(xMp,2);
        return new Coordinate2D(xMp, yMp);
    }
}
