package iut.k2.data;

import com.google.common.base.Strings;
import iut.k2.Constants;
import iut.k2.data.objects.AbstractGameObject;
import iut.k2.data.objects.ShapeBased;
import iut.k2.data.objects.SpriteBased;
import iut.k2.gui.Sprite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.awt.*;
import java.awt.image.BufferStrategy;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class WorldRenderer {
    private final static Logger LOG = LoggerFactory.getLogger(WorldRenderer.class);
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
        Level l = abstractWorldControler.getLevel();
        renderWorld(g, l);
        renderAxis(g);
    }

    private void renderWorld(Graphics g, Level l) {
        for (Integer in : l.getLsObjects().keySet()) {
            for (AbstractGameObject ago : l.getLsObjects().get(in)) {
                if (ago instanceof ShapeBased) {
                    ShapeBased shapeBased = (ShapeBased) ago;
                    for (Shape shape : shapeBased.getDrawsShapes().keySet()) {
                    	if (!g.getColor().equals(shapeBased.getDrawsShapes().get(shape))){
                    		g.setColor(shapeBased.getDrawsShapes().get(shape));
                    	}
                        
                        ((Graphics2D) g).fill(shape);
                    }
                } else if (ago instanceof SpriteBased) {
                    SpriteBased sb = (SpriteBased) ago;
                    for (Sprite sprite : sb.getLsSprites().keySet()) {
                        sprite.draw(g, (int) sb.getLsSprites().get(sprite).getX(), (int) sb.getLsSprites().get(sprite).getY());
                    }
                } else {
                    LOG.error("I got an entity I don't know how to draw it ! ( {} )", ago);
                }
            }
        }
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
