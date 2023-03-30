package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import tools.PaintShape;
import tools.PaintTool;

public class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    /** Initial color to draw. */
    private static final Color UW_PURPLE = new Color(51, 0, 111);
    /** Initial color to fill shapes. */
    private static final Color UW_GOLD = new Color(232, 211, 162);
    /** Initial thickness to draw. */
    private static final int BASICTHICKNESS = 3;
    
    /** A collection of previously drawn shapes. */
    private final List<PaintShape> myPreviousShape;
    /** The PaintTool currently in use. */
    private PaintTool myCurrentTool;
    /** The Color currently in use. */
    private Color myColor;
    /** The Color currently in use to fill shapes. */
    private Color myFillColor;
    /** The thickness currently in use. */
    private int myThickness;
    /** Check that the panel is drawn or clear. */
    private final ChangeableText myClear;
    /** Operator to draw shapes. */
    private boolean myOperator;
    /** Operator to fill shapes. */
    private boolean myFillOperator;
    
    public DrawingPanel() {
        super();
        setBackground(Color.WHITE);
        myColor = UW_PURPLE;
        myFillColor = UW_GOLD;
        myThickness = BASICTHICKNESS;
        myPreviousShape = new ArrayList<>();
        final MouseInputAdapter mouseAction = new MyMouseListener();
        addMouseListener(mouseAction);
        addMouseMotionListener(mouseAction);
        myClear = new ChangeableText("Empty Panel");
    }
    
    public void setCurrentTool(final PaintTool theTool) {
        myCurrentTool = theTool;
    }
    
    public void setColor(final Color theColor) {
        myColor = theColor;
    }
    
    public void setFillColor(final Color theColor) {
        myFillColor = theColor;
    }
    
    public void setThickness(final int theValue) {
        myThickness = theValue;
    }
    
    public void setFillOperator(final boolean theValue) {
        myFillOperator = theValue;
    }
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        
        final Graphics2D g2d = (Graphics2D) theGraphics;
        
        for (final PaintShape s : myPreviousShape) {
            g2d.setColor(s.getColor());
            g2d.setStroke(new BasicStroke(s.getThickness()));
            g2d.draw(s.getShape());
            if (!(s.getFillColor() == null)) {
                g2d.setPaint(s.getFillColor());
                g2d.fill(s.getShape());
            }
        }
        
        if (myOperator) {
            g2d.setColor(myColor);
            g2d.setStroke(new BasicStroke(myThickness));
            g2d.draw(myCurrentTool.getShape());
            if (myFillOperator) {
                g2d.setPaint(myFillColor);
                g2d.fill(myCurrentTool.getShape());
            }
        }
    }
    
    public List<PaintShape> getPreviousShape() {
        return myPreviousShape;
    }
    
    public ChangeableText getChangeableText() {
        return myClear;
    }
    
    public void setOperator(final boolean theOperator) {
        myOperator = theOperator;
    }

    class MyMouseListener extends MouseInputAdapter {
        
        @Override
        public void mouseEntered(final MouseEvent theEvent) {
            setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            
        }
        
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            if (myThickness > 0) {
                myCurrentTool.setStartPoint(theEvent.getPoint());
                myClear.setText("Not Clear");
            }
        } 
        
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            
            if (myThickness > 0) {
                myOperator = true;
                myCurrentTool.setEndPoint(theEvent.getPoint());
                repaint();
            }
        }
        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            if (myFillOperator) {
                final PaintShape currentShpae = new PaintShape(
                        myColor, myCurrentTool.getShape(), myThickness, myFillColor);
                myPreviousShape.add(currentShpae);
            } else {
                final PaintShape currentShpae = new PaintShape(
                        myColor, myCurrentTool.getShape(), myThickness);
                myPreviousShape.add(currentShpae);
            }
        }
        
    }
}
