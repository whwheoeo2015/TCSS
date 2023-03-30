package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import tools.EllipseTool;
import tools.LineTool;
import tools.RectangleTool;

/**
 *  Display space with options for drawing shapes.
 *  It will allow user to select tools to draw such as line, ellipse and rectangle.
 *  It will also display information about the application, and
 *  let user revise shape with color and thickness.
 * 
 * @author Junghyon Jo
 * @version 11/29/2022
 */
public final class PaintGUI {
    /** Initial size of the frame. */
    private static final Dimension INITIAL_SIZE = new Dimension(600, 400);
    
    /** The frame to have all the components for painting shapes. */
    private final JFrame myFrame;

    public PaintGUI() {
        super();
        
        myFrame = new JFrame("TCSS 305 Paint - Autumn 2022");
        setup();
    }

    private void setup() {
        
        myFrame.setSize(new Dimension(INITIAL_SIZE));
        
        final ImageIcon img = new ImageIcon("files/w_small.png");
        myFrame.setIconImage(img.getImage());
        
        final DrawingPanel panel = new DrawingPanel();
        final PaintGuiMenuBar menuBar = new PaintGuiMenuBar(panel);
        final PaintGuiToolBar toolBar = new PaintGuiToolBar();
        final ChangeableFill fill = new ChangeableFill("No Fill");
        
        final LineTool lineTool = new LineTool();
        final EllipseTool ellipseTool = new EllipseTool();
        final RectangleTool rectangleTool = new RectangleTool();
        
        panel.setCurrentTool(lineTool);
        panel.getChangeableText().addPropertyChangeListener(menuBar);
        fill.addPropertyChangeListener(menuBar);
        
        final Action[] actions = {new LineAction(panel, lineTool, fill), 
            new EllipseAction(panel, ellipseTool, fill),
            new RectangleAction(panel, rectangleTool, fill)};
        
        for (final Action action : actions) {
            menuBar.createMenuButton(action);
            toolBar.createToolBarButton(action);
        }
        
        if (toolBar.getWidth() == myFrame.getWidth()) {
            final Dimension size = new Dimension(400, 400 - toolBar.getHeight());
            panel.setPreferredSize(size);
        } else if (toolBar.getHeight() == myFrame.getHeight()) {
            final Dimension size = new Dimension(400 - myFrame.getWidth(), 400);
            panel.setSize(size);
        }

        myFrame.setJMenuBar(menuBar);
        myFrame.add(toolBar, BorderLayout.SOUTH);
        myFrame.add(panel, BorderLayout.CENTER);
        
        myFrame.setVisible(true);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
