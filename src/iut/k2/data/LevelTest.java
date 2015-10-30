package iut.k2.data;

import iut.k2.Constants;
import iut.k2.data.objects.AbstractGameObject;
import iut.k2.data.objects.Obstacle;
import iut.k2.data.objects.PeckerCurve;
import iut.k2.physics.Coordinate2D;
import iut.k2.physics.functions.SquareParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LevelTest extends Level {

    /**
     * Le level de test contiendra 1 Pecker et 5 à 10 obstacles
     */
    public void init() {
        Random r = new Random();
        int nbObstacles = r.nextInt(6) + 5;

        //Création de l'oiseau
        //Pecker p = new Pecker(new Coordinate2D(0, 0));
        
        //Attention à ne pas trop augmenter la pente
        PeckerCurve p = new PeckerCurve(new Coordinate2D(0, 0), new SquareParam(2, Constants.SIZE_WIDE));

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
