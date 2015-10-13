package iut.k2.data;

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
    }

    public void render(Graphics g) {
        worldControler.getLevel().render(g);
        renderAxis(g);
    }

    public void render() {
        render(strategy.getDrawGraphics());
    }


    private void renderAxis(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(0, 0, 400, 0);
        g.drawLine(0, 0, 0, 400);
    }
}
