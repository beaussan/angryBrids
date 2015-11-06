package iut.k2.data;

import iut.k2.Constants;
import iut.k2.data.objects.AbstractGameObject;
import iut.k2.data.objects.Obstacle;
import iut.k2.data.objects.PeckerCurve;
import iut.k2.physics.Coordinate2D;
import iut.k2.physics.functions.ParamCurve;
import iut.k2.physics.functions.SquareParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LevelTest extends Level {
    private ParamCurve curve;
    private Coordinate2D startPos;

    public LevelTest() {
        curve = new SquareParam(2, Constants.SIZE_WIDE);
        startPos = new Coordinate2D(0, 0);
        init();
    }

    public LevelTest(ParamCurve curve, Coordinate2D startPos) {
        this.curve = curve;
        this.startPos = (startPos == null) ? new Coordinate2D(0, 0) : startPos;
        init();
    }

    public LevelTest(ParamCurve curve) {
        this.curve = curve;
        startPos = new Coordinate2D(0, 0);
        init();
    }

    /**
     * Getter for property 'curve'.
     *
     * @return Value for property 'curve'.
     */
    public ParamCurve getCurve() {
        return curve;
    }

    /**
     * Setter for property 'curve'.
     *
     * @param curve Value to set for property 'curve'.
     */
    public void setCurve(ParamCurve curve) {
        this.curve = curve;
    }

    /**
     * Getter for property 'startPos'.
     *
     * @return Value for property 'startPos'.
     */
    public Coordinate2D getStartPos() {
        return startPos;
    }

    /**
     * Setter for property 'startPos'.
     *
     * @param startPos Value to set for property 'startPos'.
     */
    public void setStartPos(Coordinate2D startPos) {
        this.startPos = startPos;
    }

    /**
     * Le level de test contiendra 1 Pecker et 5 à 10 obstacles
     */
    public void init() {
        getLsEntitys().clear();
        getLsObjects().clear();
        Random r = new Random();
        int nbObstacles = r.nextInt(6) + 5;

        //Création de l'oiseau
        //Pecker p = new Pecker(new Coordinate2D(0, 0));

        //Attention à ne pas trop augmenter la pente
        PeckerCurve p = new PeckerCurve(startPos, curve);

        // ajout du piaf dans les données au plan 1
        addRenderObject(p, 1);

        List<AbstractGameObject> listeObstacle = new ArrayList<>();
        for (int i = 0; i < nbObstacles; i++) {
            //Coordonnées de l'obstacle
            int x = r.nextInt(Constants.SIZE_WIDE / 2) + Constants.SIZE_WIDE / 2;
            int y = r.nextInt(Constants.SIZE_HEIGHT);

            //Création d'un obstacle
            Obstacle o = new Obstacle(new Coordinate2D(x, y));
            addRenderObject(o, 2);
        }
    }
}
