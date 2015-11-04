package iut.k2.data.objects;

import iut.k2.gui.renderfunc.DrawBird;
import iut.k2.physics.Coordinate2D;
import iut.k2.physics.functions.ParamCurve;
import iut.k2.util.Tools;
import iut.k2.util.loggin.UtilLog;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Nicolas Beaussart on 15/10/15 for angryBrids.
 */
public class PeckerCurve extends Entity {
    public final static float SPEED = 200;
    private final static Logger LOG = UtilLog.getLog(PeckerCurve.class.getName());
    private final static float INTERVAL_DOTS_BACK = 30;
    private final static int SIZE_DOT = 6;
    private final static Color COLOR_DOT = Color.PINK;
    private final Coordinate2D INIT_CORDS;
    private ParamCurve curve;
    private Coordinate2D nextCord;
    private Coordinate2D vector;
    private float currDeltaPos = 0;
    private float deltaCummul = 0;
    private List<Point2D> lsPoints = new ArrayList<>();
    private Color colBird = DrawBird.COLOR_BODY;


    public PeckerCurve(Coordinate2D c, ParamCurve curve) {
        super(c);
        this.curve = curve;
        INIT_CORDS = c;
    }

    @Override
    public void render(Graphics batch) {
        // rendering of dots
        batch.setColor(COLOR_DOT);
        for (Point2D point2D : lsPoints) {
            batch.fillOval((int) point2D.getX(), (int) point2D.getY(), SIZE_DOT, SIZE_DOT);
        }

        // rendering of bird
        nextCord = getCoordinate().add(vector);
        Coordinate2D curr = Tools.getSwingCords(getCoordinate());
        Coordinate2D next = Tools.getSwingCords(nextCord);
        getLsShapes().clear();
        addShape(DrawBird.drawBird(batch, curr.getX(), curr.getY(), next.getX(), next.getY(), colBird));


    }

    public void reset() {
        nextCord = new Coordinate2D(curve.x(currDeltaPos + .1), curve.y(currDeltaPos + .1));
        currDeltaPos = 0;
        setCoordinate(INIT_CORDS);
        calculateVector(1);

    }

    @Override
    public void setColor(Color color) {
        colBird = color;
    }

    @Override
    public void update(float deltaTime) {
        calculateVector(deltaTime);
        //FIXME not worink... I think at least...
        setCoordinate(getCoordinate().add(vector));

        deltaCummul += deltaTime;
        if (deltaCummul > INTERVAL_DOTS_BACK) {
            double tmpDel = currDeltaPos - (deltaCummul - INTERVAL_DOTS_BACK);
            Coordinate2D tmp = Tools.getSwingCords(new Coordinate2D(curve.x(tmpDel), curve.y(tmpDel)));
            lsPoints.add(new Point2D.Double(tmp.getX(), tmp.getY()));
            deltaCummul = (deltaCummul - INTERVAL_DOTS_BACK);
        }
        //nextCord = new Coordinate2D(curve.x(currDeltaPos), curve.y(currDeltaPos));
    }

    private void calculateVector(float deltaTime) {
        vector = new Coordinate2D(curve.x(currDeltaPos), curve.y(currDeltaPos));
        currDeltaPos += (SPEED * deltaTime) / 1000;
        vector = new Coordinate2D(curve.x(currDeltaPos), curve.y(currDeltaPos)).minus(vector);
    }
}
