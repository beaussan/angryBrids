package iut.k2.data;

import iut.k2.Constants;
import iut.k2.ObstacleFactory;
import iut.k2.data.objects.AbstractGameObject;
import iut.k2.data.objects.Montain;
import iut.k2.data.objects.Obstacle;
import iut.k2.data.objects.Pecker;
import iut.k2.physics.Coordinate2D;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LevelTest extends Level {
    private final static Logger LOG = LoggerFactory.getLogger(LevelTest.class);
    private Coordinate2D startPos = new Coordinate2D(10, 10);

    public LevelTest() {
        this(new Coordinate2D(70, 0));
    }
    public LevelTest(Coordinate2D source) {
        super();
        LOG.debug("Creating level test");
        startPos = source;
        LOG.debug("Start pos = {}", startPos);
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
     * Le level de test contiendra 1 Pecker et 5 à 10 obstacles
     */
    public void init() {
        LOG.debug("Inint test level");
        LOG.debug("Start pos = {}", startPos);
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
        Pecker p = new Pecker(new Coordinate2D(startPos));

        // ajout du piaf dans les données au plan 1
        addRenderObject(p, 1);

        List<AbstractGameObject> listeObstacle = new ArrayList<>();
        for (int i = 0; i < nbObstacles; i++) {
            //Coordonnées de l'obstacle
            int x = r.nextInt(Constants.SIZE_WIDE / 2) + Constants.SIZE_WIDE / 2;
            int y = r.nextInt(Constants.SIZE_HEIGHT);
            //int directionX = 0;
            //int directionY = 0;
            int forme = new Random().nextInt(2);
            Obstacle o = null;
            
            /*int moveX = new Random().nextInt(100);
            int moveY = new Random().nextInt(100);
            do{
            	while(directionX==0)
            directionX = new Random().nextInt(3)-1;
            }while(directionX==0 && ((double)x + (double)moveX) % (double)directionX !=0 && ((double)x-(double)moveX) % (double)directionX != 0);
            do{
            	while(directionY==0)
            directionY = new Random().nextInt(3)-1;
            }while(directionY==0 && ((double)y + (double)moveY) % (double)directionY !=0 && ((double)y-(double)moveY) % (double)directionY != 0);
			*/
            //Création d'un obstacle
            
            try{
            if(forme==0)
            	o = ObstacleFactory.getObstacle("cercle",new Coordinate2D(x, y));
            else if(forme==1)
            	o = ObstacleFactory.getObstacle("carre",new Coordinate2D(x, y));
            }catch(Exception e){e.printStackTrace();};
            
            //Obstacle o = new Obstacle(new Coordinate2D(x, y)/*, moveX, moveY, directionX, directionY*/);
            addRenderObject(o, 2);
        }

    }
}
