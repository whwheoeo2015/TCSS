package tools;

import java.awt.Shape;
import java.awt.geom.Line2D;

public class LineTool extends AbstractPaintTool {

    @Override
    public Shape getShape() {
        return new Line2D.Double(getStartPoint(), getEndPoint());
    }

}
