package iut.k2;

import iut.k2.gui.renderfunc.DrawingPlace;
import iut.k2.physics.functions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by PROPRIETAIRE on 29/09/2015.
 */
public class FunctionDrawing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jf = new JFrame("Hello curve");

                DrawingPlace dp = new DrawingPlace(new SimpleLine(0, 1, 300, 0),
                		new SimpleLine(1, 0, 150, 0));
                dp.TIMER_DURRATION = 2;
                dp.setPreferredSize(new Dimension(250, 250));
                jf.add(dp);
                jf.setLocationRelativeTo(null);
                jf.setSize(new Dimension(300, 300));
                jf.setVisible(true);
                jf.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosed(WindowEvent e) {
                        //System.exit(0);
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
            }
        });
    }
}
