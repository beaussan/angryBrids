package iut.k2.gui;

import iut.k2.Constants;
import iut.k2.data.*;

import javax.annotation.Nonnull;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class GameLoop extends JFrame {
    public static void main(String[] args) {
        Level l = new LevelTest();
        AbstractWorldControler abstractWorldControler = new WorldControlerR2(l);
        new GameLoop(abstractWorldControler);
        //new GameLoop(abstractWorldControler);

        new Thread(abstractWorldControler).start();

    }
    /**
     * The stragey that allows us to use accelerate page flipping
     */
    private BufferStrategy strategy;
    private boolean gameRunning = true;

    public GameLoop(@Nonnull AbstractWorldControler abstractWorldControler) {
        checkNotNull(abstractWorldControler);

        addKeyListener(abstractWorldControler.getKeyMap());

        setVisible(true);
        setSize(new Dimension(Constants.SIZE_WIDE + 20, Constants.SIZE_HEIGHT + 20));
        setLocationRelativeTo(null);

        // create the buffering strategy which will allow AWT
        // to manage our accelerated graphics
        createBufferStrategy(3);
        strategy = getBufferStrategy();
        new WorldRenderer(strategy, abstractWorldControler);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public BufferStrategy getStrategy() {
        return strategy;
    }


}
