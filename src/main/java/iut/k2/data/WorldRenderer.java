package iut.k2.data;

import com.google.common.base.Strings;
import iut.k2.Constants;

import javax.annotation.Nonnull;
import java.awt.*;
import java.awt.image.BufferStrategy;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class WorldRenderer {
    private final BufferStrategy strategy;
    private AbstractWorldControler abstractWorldControler;
    private String textDisplayed;

    public WorldRenderer(@Nonnull BufferStrategy strategy,
                         @Nonnull AbstractWorldControler abstractWorldControler) {
        this.strategy = checkNotNull(strategy);
        this.abstractWorldControler = checkNotNull(abstractWorldControler);
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
        this.textDisplayed = Strings.nullToEmpty(textDisplayed);
    }

    public void render() {
        Graphics g = strategy.getDrawGraphics();
        render(g);
        g.dispose();
        strategy.show();
    }

    public void render(@Nonnull Graphics g) {
        checkNotNull(g, "Graphics must not be null !");
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Constants.SIZE_WIDE + 20, Constants.SIZE_HEIGHT + 20);
        writeTxtInfo(g);
        abstractWorldControler.getLevel().render(g);
        renderAxis(g);
    }

    private void writeTxtInfo(Graphics g) {
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
