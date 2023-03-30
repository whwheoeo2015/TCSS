package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class EllipseTool extends AbstractPaintTool {

    @Override
    public Shape getShape() {
        final Ellipse2D.Double ellipse = new Ellipse2D.Double();
        final Point start = getStartPoint();
        final Point end = getEndPoint();
        ellipse.setFrameFromDiagonal(start, end);
        return ellipse;
    }
}
