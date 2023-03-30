package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyDrawingPanel extends JPanel {

        /**
     * 
     */
    private static final long serialVersionUID = 1L;

        public MyDrawingPanel()  {
            setBackground(Color.WHITE);
        }

        public void paintComponent(final Graphics theGraphics) {
            super.paintComponent(theGraphics);
            final Graphics2D g2d = (Graphics2D) theGraphics;

            g2d.draw(new Rectangle2D.Double(100, 100, 500, 500));

            for (int i = 0; i < 7; i++) {
                if (i % 3 == 0)  {
                    g2d.fill(new Ellipse2D.Double(i * 100, i * 100, 100, 100));
                } else {
                    g2d.draw(new Ellipse2D.Double(i * 100, i * 100, 100, 100));
                }
            }
        }

}
