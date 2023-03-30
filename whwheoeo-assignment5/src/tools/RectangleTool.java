package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class RectangleTool extends AbstractPaintTool {

    @Override
    public Shape getShape() {
        final Rectangle2D.Double rectangle = new Rectangle2D.Double();
        final Point start = getStartPoint();
        final Point end = getEndPoint();
        rectangle.setFrameFromDiagonal(start, end);
        return rectangle;
    }
}
