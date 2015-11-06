package iut.k2.data;

import iut.k2.Constants;
import iut.k2.data.objects.Entity;
import iut.k2.data.objects.PeckerCurve;
import iut.k2.gui.renderfunc.DrawBird;
import iut.k2.physics.Coordinate2D;
import iut.k2.physics.functions.ParamCurve;
import iut.k2.physics.functions.SimpleLine;
import iut.k2.physics.functions.SquareParam;
import iut.k2.util.loggin.UtilLog;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class WorldControlerR1 extends AbstractWorldControler {
    private final static Logger LOG = UtilLog.getLog(WorldControlerR1.class.getName());
    private final float TIME_MAX_MS = 5000;
    private boolean endingGame = false;
    private ParamCurve[] curves = new ParamCurve[]{
            new SquareParam(2, Constants.SIZE_WIDE),
            new SimpleLine(1, 1, 300, 300),
            new SquareParam(2.5, Constants.SIZE_WIDE),
            new SquareParam(2.2, Constants.SIZE_WIDE),
            new SquareParam(1.8, Constants.SIZE_WIDE),
            new SquareParam(3, Constants.SIZE_WIDE)};

    public WorldControlerR1(Level level) {
        super(level);
    }

    public void checkColisions() {
        List<Entity> lsEntity = getLevel().getLsEntitys();
        for (Entity e : lsEntity) {
            for (Entity e2 : lsEntity) {
                if (e == e2) {
                    continue;
                }
                if (e.getClass() == e2.getClass()) {
                    continue;
                }
                if (e.overlap(e2)) {
                    LOG.fine("Found colision ! e1 : " + e + " ; e2 : " + e2);
                    e.setColor(Color.GREEN);
                    e2.setColor(Color.GREEN);
                    endingGame = true;
                }
            }
        }
        for (Entity e : getLevel().getLsEntitys()) {
            if (e instanceof PeckerCurve) {
                LOG.fine("pecker pos : " + e.getCoordinate());
                if (e.getCoordinate().getY() < 0 || e.getCoordinate().getY() > Constants.SIZE_HEIGHT - DrawBird.SIZE_BIRD * 2) {
                    endingGame = true;
                }
                if (e.getCoordinate().getX() < 0 || e.getCoordinate().getX() > Constants.SIZE_WIDE - DrawBird.SIZE_BIRD * 2) {
                    endingGame = true;
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
        int nmbRuns = 0;
        Timer timer = new Timer("loop");
        ((LevelTest) getLevel()).setCurve(curves[nmbRuns]);
        getLevel().init();
        while (nmbRuns <= 5) {
            for (WorldRenderer worldRenderer : getWorldRenderers()) {
                worldRenderer.setTextDisplayed(((LevelTest) getLevel()).getCurve().toString());
            }

            // keep looping round til the game ends
            timer.scheduleAtFixedRate(new RunTimer(), 0, 10);
            while (isGameRunning()) {
            }
            timer.purge();
            render();
            LOG.finest("Timer is over !");
            ((LevelTest) getLevel()).setCurve(curves[nmbRuns]);
            getLevel().init();
            nmbRuns++;
            setGameRunning(true);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        timer.cancel();
    }

    public void update(float deltaTime) {
        getLevel().update(deltaTime);
    }

    private class RunTimer extends TimerTask {
        long lastLoopTime = System.currentTimeMillis();
        boolean isRuning = true;
        long cumul = 0;

        @Override
        public void run() {
            if (!isRuning) {
                return;
            }
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long delta = System.currentTimeMillis() - lastLoopTime;
            lastLoopTime = System.currentTimeMillis();
            cumul += delta;

            LOG.finest("Handling input");
            handleInput();
            LOG.finest("Updating the game with " + delta + " of delta time");
            update(delta);
            LOG.finest("Updating collisions");
            checkColisions();
            LOG.finest("Rendering !");
            render();
            if (cumul >= TIME_MAX_MS) {
                endingGame = true;
            }
            if (endingGame) {
                LOG.finest("Found out the game is over, purging the timer");
                endingGame = false;
                isRuning = false;
                setGameRunning(false);
                cancel();
            }
        }
    }

    private void singleRun(ParamCurve curve, Coordinate2D pos) {

    }


}
