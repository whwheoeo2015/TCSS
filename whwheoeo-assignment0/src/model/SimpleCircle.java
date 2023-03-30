package model;

import java.awt.Point;

public class SimpleCircle {
    private double myRadius;
    private Point myCenterPoint;
    
    SimpleCircle (final double theRadius, final Point theCenterPoint) {
        myRadius = theRadius;
        myCenterPoint = theCenterPoint;
    }
    
    public Point getCenter() {
        return myCenterPoint;
    }
}
