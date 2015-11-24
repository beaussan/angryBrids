package iut.k2.data;

import iut.k2.data.objects.Entity;
import iut.k2.data.objects.Pecker;
import iut.k2.physics.Coordinate2D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class WorldControlerR2 extends AbstractWorldControler {
    private final static Logger LOG = LoggerFactory.getLogger(WorldControlerR2.class);
    private final static int NMB_RUNS = 10;
    private final long TIME_MAX_MS = 15000;
    private long timeBreak= 1000;
    private boolean endingGame = false;

    public WorldControlerR2(@Nonnull Level level) {
        super(level);
    }

    public void bouncyBird() {

        for (Entity e : getLevel().getLsEntitys()) {
            if (e instanceof Pecker) {
                LOG.trace("pecker pos : {}", e.getCoordinate());
                if (e.getCoordinate().getY() < 0) {
                    e.getCoordinate().setY(0);
                    if (e.getVelocity().getY()  >= -10){
                        e.getAcceleration().setX(0);
                        e.getAcceleration().setY(0);
                        e.getVelocity().setX(0);
                        e.getVelocity().setY(0);
                    } else {
                        e.getVelocity().setY(-e.getVelocity().getY() / 2);
                    }
                    e.getVelocity().setX(e.getVelocity().getX() / 1.2);
                }
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
                if (e.getClass() == e2.getClass()) {
                    continue;
                }
                if (e.overlap(e2)) {
                    LOG.debug("Found colision ! e1 : {} ; e2 : {}", e, e2);
                    e.setColor(Color.GREEN);
                    e2.setColor(Color.GREEN);
                    endingGame = true;
                    timeBreak=2000;
                }
            }
        }
        bouncyBird();
    }

    public void handleDebugInput() {
        if (getKeyMap().getKey(KeyEvent.VK_D)) {
            for (Entity entity : getLevel().getLsEntitys()) {
                LOG.trace("Entity : {}", entity.getCoordinate());
            }
        }
    }

    public void handleInput() {
        handleDebugInput();
    }
    
    
	@Override
	public void mouseDragged(MouseEvent e) {
        LOG.debug("x : {}, y : {}", e.getX(), e.getY());

        if ((new Ellipse2D.Double(0, 590, 20, 20)).contains(e.getX(), e.getY())) {
            for (Entity en : getLevel().getLsEntitys()) {
	            if (en instanceof Pecker && en.getCoordinate().equals(new Coordinate2D(10,0))) {
	                en.setTerminalVelocity(new Coordinate2D(1000.0f, 1000.0f));
	                en.setFriction(new Coordinate2D(.005, 0));
	                en.setAcceleration(new Coordinate2D(0.0f, -0.25f));
	                en.setVelocity(new Coordinate2D(100	, 300));
	            }
		 }
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

    /**
     * render on allss renderers
     */
    public void render() {
        for (WorldRenderer worldRenderer : getWorldRenderers()) {
            worldRenderer.render();
        }
    }

    @Override
    public void run() {
        int nmbRuns = 0;
        Timer timer = new Timer("loop");
        while (nmbRuns < NMB_RUNS) {
            getLevel().init();

            // keep looping round til the game ends
            timer.scheduleAtFixedRate(new RunTimer(), 0, 10);
            while (isGameRunning()) {
            }
            timer.purge();
            render();
            LOG.debug("Timer is over !");
            nmbRuns++;
            setGameRunning(true);

            try {
                Thread.sleep(timeBreak);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeBreak=1000;
        }
        timer.cancel();
    }

    /**
     * update the level
     * @param deltaTime the time between two frames
     */
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

            LOG.trace("Handling input");
            handleInput();
            LOG.trace("Updating the game with {} of delta time", delta);
            update(delta);
            LOG.trace("Updating collisions");
            checkColisions();
            LOG.trace("Rendering !");
            render();
            if (cumul >= TIME_MAX_MS) {
                endingGame = true;
            }
            if (endingGame) {
                LOG.debug("Found out the game is over, purging the timer");
                endingGame = false;
                isRuning = false;
                setGameRunning(false);
                cancel();
            }
        }
    }




}
