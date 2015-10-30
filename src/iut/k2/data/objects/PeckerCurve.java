package iut.k2.data.objects;

import iut.k2.gui.renderfunc.DrawBird;
import iut.k2.physics.Coordinate2D;
import iut.k2.physics.functions.ParamCurve;
import iut.k2.util.Tools;

import java.awt.*;

/**
 * Created by Nicolas Beaussart on 15/10/15 for angryBrids.
 */
public class PeckerCurve extends Entity {
    private final static float SPEED = 200;
    private final Coordinate2D INIT_CORDS;
    private ParamCurve curve;
    private Coordinate2D nextCord;
    private Coordinate2D vector;
    private float currDelt = 0;

    public PeckerCurve(Coordinate2D c, ParamCurve curve) {
        super(c);
        this.curve = curve;
        INIT_CORDS = c;
    }

    @Override
    public void render(Graphics batch) {
        calculateVector(1);
        nextCord = getCoordinate().add(vector);
        Coordinate2D curr = Tools.getSwingCords(getCoordinate());
        Coordinate2D next = Tools.getSwingCords(nextCord);
        DrawBird.drawBird(batch, curr.getX(), curr.getY(), next.getX(), next.getY());
    }

    public void reset() {
        nextCord = new Coordinate2D(curve.x(currDelt + .1), curve.y(currDelt + .1));
        currDelt = 0;
        setCoordinate(INIT_CORDS);
        calculateVector(1);

    }

    @Override
    public void update(float deltaTime) {
        calculateVector(deltaTime);
        //FIXME not worink...
        setCoordinate(getCoordinate().add(vector));
        //nextCord = new Coordinate2D(curve.x(currDelt), curve.y(currDelt));
    }

    private void calculateVector(float deltaTime) {
        vector = new Coordinate2D(curve.x(currDelt), curve.y(currDelt));
        currDelt += (SPEED * deltaTime) / 1000;
        vector = new Coordinate2D(curve.x(currDelt), curve.y(currDelt)).minus(vector);
    }
}
