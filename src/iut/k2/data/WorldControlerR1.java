package iut.k2.data;

import iut.k2.data.objects.Entity;
import iut.k2.data.objects.PeckerCurve;
import iut.k2.util.loggin.UtilLog;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class WorldControlerR1 extends AbstractWorldControler {
    private final static Logger LOG = UtilLog.getLog(WorldControlerR1.class.getName());
    private PeckerCurve peckerCurve;

    public WorldControlerR1(Level level) {
        super(level);
        for (Entity e : level.getLsEntitys()) {
            if (e instanceof PeckerCurve) {
                peckerCurve = (PeckerCurve) e;
                break;
            }
        }
    }

    public void checkColisions() {
        List<Entity> lsEntity = getLevel().getLsEntitys();
        for (Entity e : lsEntity) {
            for (Entity e2 : lsEntity) {
                if (e == e2) {
                    continue;
                }
                if (e.overlap(e2)) {
                    LOG.fine("Found colision ! e1 : " + e + " ; e2 : " + e2);
                    e.setColor(Color.GREEN);
                    e2.setColor(Color.GREEN);
                    setGameRunning(false);
                }
            }
        }
        for (Entity e : getLevel().getLsEntitys()) {
            if (e instanceof PeckerCurve) {
                LOG.fine("pecker pos : " + e.getCoordinate());
                if (e.getCoordinate().getY() < 0) {
                    setGameRunning(false);
                }
                break;
            }
        }
    }

    public void handleDebugInput() {
        if (getKeyMap().getKey(KeyEvent.VK_D)) {
            for (Entity entity : getLevel().getLsEntitys()) {
                LOG.fine("Entity : " + entity.getCoordinate());
            }
        }
    }

    public void handleInput() {
        handleDebugInput();
    }

    public void render() {
        for (WorldRenderer worldRenderer : getWorldRenderers()) {
            worldRenderer.render();
        }
    }

    @Override
    public void run() {
        long lastLoopTime = System.currentTimeMillis();
        int nmbRuns = 0;
        while (nmbRuns <= 5) {
            // keep looping round til the game ends
            while (isGameRunning()) {
                // work out how long its been since the last update, this
                // will be used to calculate how far the entities should
                // move this loop
                long delta = System.currentTimeMillis() - lastLoopTime;
                lastLoopTime = System.currentTimeMillis();

                LOG.finest("Handling input");
                handleInput();
                LOG.finest("Updating the game with  " + delta + " of delta time");
                update(delta);
                LOG.finest("Updating collisions");
                checkColisions();
                LOG.finest("Rendering !");
                render();

                // finally pause for a bit. Note: this should run us at about
                // 100 fps but on windows this might vary each loop due to
                // a bad implementation of timer
                try {
                    Thread.sleep(10);
                } catch (Exception ignored) {
                }
            }
            LOG.finest("Rendering !");
            render();

            try {
                Thread.sleep(300);
            } catch (Exception ignored) {
            }
            getLevel().init();
            nmbRuns++;
            setGameRunning(true);
        }


    }

    public void update(float deltaTime) {
        getLevel().update(deltaTime);
    }
}
