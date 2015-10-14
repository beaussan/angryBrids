package iut.k2.gui;

import iut.k2.Constants;
import iut.k2.data.Level;
import iut.k2.data.TestObject;
import iut.k2.data.WorldControler;
import iut.k2.data.WorldRenderer;
import iut.k2.physics.Coordinate2D;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class GameLoop extends JFrame {
    public static void main(String[] args) {
        Level l = new Level() {
            @Override
            public void init() {
                for (int i = 0; i < 250; i++) {
                    addRenderObject(new TestObject(new Coordinate2D(100, 100)), 0);
                }
            }
        };
        //UtilLog.setLevelGlobal(java.util.logging.Level.ALL, "iut.k2.data");
        WorldControler worldControler = new WorldControler(l);
        GameLoop gameLoop = new GameLoop(worldControler);
        GameLoop gameLoop2 = new GameLoop(worldControler);
        new Thread(worldControler).start();

        //gameLoop.loop();
    }
    /**
     * The stragey that allows us to use accelerate page flipping
     */
    private BufferStrategy strategy;
    private boolean gameRunning = true;

    public GameLoop(WorldControler worldControler) {

        addKeyListener(worldControler.getKeyMap());

        setVisible(true);
        setSize(new Dimension(Constants.SIZE_WIDE, Constants.SIZE_HEIGHT));
        setLocationRelativeTo(null);

        // create the buffering strategy which will allow AWT
        // to manage our accelerated graphics
        createBufferStrategy(3);
        strategy = getBufferStrategy();
        new WorldRenderer(strategy, worldControler);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public BufferStrategy getStrategy() {
        return strategy;
    }


}
