package iut.k2.data;

import iut.k2.Constants;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class WorldRenderer {
    private final BufferStrategy strategy;
    private AbstractWorldControler abstractWorldControler;
    private String textDisplayed;

    public WorldRenderer(BufferStrategy strategy, AbstractWorldControler abstractWorldControler) {
        this.strategy = strategy;
        this.abstractWorldControler = abstractWorldControler;
        abstractWorldControler.addRenderer(this);
    }

    /**
     * Getter for property 'textDisplayed'.
     *
     * @return Value for property 'textDisplayed'.
     */
    public String getTextDisplayed() {
        return textDisplayed;
    }

    /**
     * Setter for property 'textDisplayed'.
     *
     * @param textDisplayed Value to set for property 'textDisplayed'.
     */
    public void setTextDisplayed(String textDisplayed) {
        this.textDisplayed = textDisplayed;
    }

    public void render() {
        Graphics g = strategy.getDrawGraphics();
        render(g);
        g.dispose();
        strategy.show();
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Constants.SIZE_WIDE + 20, Constants.SIZE_HEIGHT + 20);
        writeTxtInfo(g);
        abstractWorldControler.getLevel().render(g);
        renderAxis(g);
    }

    public void writeTxtInfo(Graphics g) {
        if (textDisplayed == null || textDisplayed.equals("")) {
            return;
        }
        g.setColor(Color.LIGHT_GRAY);
        g.drawString(textDisplayed, 10, 50);
    }

    private void renderAxis(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(0, 0, Constants.SIZE_WIDE, 0);
        g.drawLine(0, 0, 0, Constants.SIZE_HEIGHT);
    }
}
