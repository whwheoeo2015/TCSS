/* 
 * TCSS 305 - Example code
 */

package tools;

import java.awt.Point;
import java.awt.Shape;

/**
 * Defines required behaviors for all paint tools.
 * 
 * @author Alan Fowler (acfowler@uw.edu)
 * @version 1.1
 */
public interface PaintTool {

    /**
     * Returns the Shape that this tools draws.
     * 
     * @return the Shape to draw
     */
    Shape getShape();

    /**
     * Sets the initial point for the Shape drawn by this tool.
     * 
     * @param thePoint the start point to set
     */
    void setStartPoint(Point thePoint);
    
    /**
     * Sets the end point for the Shape drawn by this tool.
     * 
     * @param thePoint the end point to set
     */
    void setEndPoint(Point thePoint);

}
