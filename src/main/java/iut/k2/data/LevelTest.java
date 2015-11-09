package iut.k2.data;

import iut.k2.Constants;
import iut.k2.data.objects.AbstractGameObject;
import iut.k2.data.objects.Montain;
import iut.k2.data.objects.Obstacle;
import iut.k2.data.objects.Pecker;
import iut.k2.physics.Coordinate2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LevelTest extends Level {
    private Coordinate2D startPos;

    public LevelTest() {
        startPos = new Coordinate2D(10, 10);
        init();
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


        addRenderObject(new Montain("sprites/mountain_left.png", new Coordinate2D(-20, -60), 200, 200, 200), -1);
        addRenderObject(new Montain("sprites/mountain_right.png", new Coordinate2D(-90, -30), 150, 150, 150), -2);
        addRenderObject(new Montain("sprites/mountain_left.png", new Coordinate2D(-60, -15), 100, 100, 100), -3);

        //Création de l'oiseau
        //Pecker p = new Pecker(new Coordinate2D(0, 0));

        //Attention à ne pas trop augmenter la pente
        Pecker p = new Pecker(startPos);

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
