package iut.k2.data;

import iut.k2.Constants;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class WorldRenderer {
    private final BufferStrategy strategy;
    private WorldControler worldControler;

    public WorldRenderer(BufferStrategy strategy, WorldControler worldControler) {
        this.strategy = strategy;
        this.worldControler = worldControler;
        worldControler.addRenderer(this);
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Constants.SIZE_WIDE + 20, Constants.SIZE_HEIGHT + 20);
        worldControler.getLevel().render(g);
        renderAxis(g);
    }

    public void render() {
        Graphics g = strategy.getDrawGraphics();
        render(g);
        g.dispose();
        strategy.show();
    }


    private void renderAxis(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(0, 0, Constants.SIZE_WIDE, 0);
        g.drawLine(0, 0, 0, Constants.SIZE_HEIGHT);
    }
}
