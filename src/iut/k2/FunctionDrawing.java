package iut.k2;

import iut.k2.gui.renderfunc.DrawingPlace;
import iut.k2.physics.functions.Square;

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
                
                DrawingPlace dp = new DrawingPlace(new Square());
                dp.setPreferredSize(new Dimension(250, 250));
                jf.add(dp);
                jf.setLocationRelativeTo(null);
                jf.setSize(new Dimension(300, 300));
                jf.setVisible(true);
                jf.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        //System.exit(0);
                    }
                });
            }
        });
    }
}
