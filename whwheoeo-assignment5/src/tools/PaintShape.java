package tools;

import java.awt.Color;
import java.awt.Shape;

/**
 * @author Junghyon Jo
 * @version 12/09/2022
 */
public class PaintShape {
    /** Shape information of color. */
    private final Color myColor;
    /** Shape information of color to fill shape. */
    private final Color myFillColor;
    /** Shape information of shape such as line, ellipse, and rectangle. */
    private final Shape myShape;
    /** Shape information of thickness. */
    private final int myThickness;
    
    
    public PaintShape(final Color theColor, final Shape theShape, final int theThickness) {
        myColor = theColor;
        myShape = theShape;
        myThickness = theThickness;
        myFillColor = null;
    }
    
    public PaintShape(final Color theColor, final Shape theShape, final int theThickness, 
            final Color theFillColor) {
        myColor = theColor;
        myShape = theShape;
        myThickness = theThickness;
        myFillColor = theFillColor;
    }
    
    public Color getFillColor() {
        return myFillColor;
    }
    
    public Color getColor() {
        return myColor;
    }
    
    public Shape getShape() {
        return myShape;
    }
    
    public int getThickness() {
        return myThickness;
    }

}
