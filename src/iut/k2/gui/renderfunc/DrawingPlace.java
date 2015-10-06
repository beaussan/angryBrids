package iut.k2.gui.renderfunc;

import iut.k2.physics.functions.ParamCurve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by PROPRIETAIRE on 29/09/2015.
 */
public class DrawingPlace extends JPanel {

    private final static int TIMER_DURRATION = 100;

    private Dimension dim;

    private Timer timer;

    private ParamCurve curve;
    private Drawing drawing;


    public DrawingPlace(ParamCurve cur) {
        dim = getPreferredSize();
        setBackground(Color.lightGray);
        curve = cur;
        drawing = new Drawing(dim, curve);
        updateDims();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateDims();
                resetTimer();
            }
        });
    }

    private void updateDims() {
        dim = new Dimension(getWidth(), getHeight());
        drawing.defineCoords(dim, curve);
        resetTimer();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawing.drawCurve(g, curve);
    }

    private void resetTimer() {
        if (timer == null) {
            timer = new Timer(TIMER_DURRATION, null);
        }
        timer.stop();
        for (ActionListener ac : timer.getActionListeners()) {
            timer.removeActionListener(ac);
        }
        drawing.setCurrMaxPoints(0);
        timer.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int drawingPoints = drawing.getCurrMaxPoints();
                if (drawingPoints >= drawing.NB_STEPS) {
                    timer.stop();
                }
                drawingPoints++;
                drawing.setCurrMaxPoints(drawingPoints);
                repaint();
            }
        });
        timer.start();
    }
}
