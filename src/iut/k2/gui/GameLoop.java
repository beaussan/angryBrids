package iut.k2.gui;

import iut.k2.data.WorldControler;
import iut.k2.data.WorldRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class GameLoop extends JFrame {
    /**
     * The stragey that allows us to use accelerate page flipping
     */
    private BufferStrategy strategy;

    private WorldControler worldControler;
    private WorldRenderer worldRenderer;
    private boolean gameRunning = true;

    public GameLoop(WorldControler worldControler) {
        this.worldControler = worldControler;
        worldRenderer = new WorldRenderer(strategy, worldControler);
        addKeyListener(worldControler.getKeyMap());


        // create the buffering strategy which will allow AWT
        // to manage our accelerated graphics
        createBufferStrategy(2);
        strategy = getBufferStrategy();
    }

    public void loop() {
        long lastLoopTime = System.currentTimeMillis();

        // keep looping round til the game ends
        while (gameRunning) {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long delta = System.currentTimeMillis() - lastLoopTime;
            lastLoopTime = System.currentTimeMillis();

            // Get hold of a graphics context for the accelerated
            // surface and blank it out
            Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, 800, 600);

            worldControler.handleInput();
            worldControler.update(delta);
            worldRenderer.render(g);
            worldControler.checkColisions();

            // finally, we've completed drawing so clear up the graphics
            // and flip the buffer over
            g.dispose();
            strategy.show();


            // finally pause for a bit. Note: this should run us at about
            // 100 fps but on windows this might vary each loop due to
            // a bad implementation of timer
            try {
                Thread.sleep(10);
            } catch (Exception ignored) {
            }
        }
    }


}
