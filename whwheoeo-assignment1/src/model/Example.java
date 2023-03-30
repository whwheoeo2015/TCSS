package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;

public class Example extends JFrame {

    public Example(){
        setTitle("Drawing a Circle");
        setSize(1000, 1000);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics theGraphics) {
        final Graphics2D g2d = (Graphics2D) theGraphics;

        g2d.draw(new Rectangle2D.Double(150, 150, 700, 700));

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)  {
                g2d.fill(new Ellipse2D.Double(i * 100, i * 100, 100, 100));
            } else {
                g2d.draw(new Ellipse2D.Double(i * 100, i * 100, 100, 100));
            }
        }
    }

    

    public static void main(String[] args) {

       new Example();

    }
}
