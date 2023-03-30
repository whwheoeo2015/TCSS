package tools;

import java.awt.Point;

public abstract class AbstractPaintTool implements PaintTool {
    
    /** Initial point which will be located at outside of the frame. */
    public static final Point INITIAL_POINT = new Point(-100, -100);
    
    /** Based on user input, 
     *  It is a point where the user will start drawing shape.
     */
    private Point myStartPoint;
    
    /** Based on user input, 
     *  It is a point where user will finish drawing shape.
     */
    private Point myEndPoint; 

    protected AbstractPaintTool() {
        myStartPoint = INITIAL_POINT;
        myEndPoint = INITIAL_POINT;
    }

    @Override
    public void setStartPoint(final Point thePoint) {      
        myStartPoint = (Point) thePoint.clone();
        myEndPoint = (Point) thePoint.clone();
    }

    protected Point getStartPoint() {
        return myStartPoint;
    }
    
    @Override
    public void setEndPoint(final Point thePoint) {      
        myEndPoint = (Point) thePoint.clone();
    }

    protected Point getEndPoint() {
        return myEndPoint;
    }

}
