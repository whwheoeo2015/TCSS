package model;

import java.awt.Point;

public class TestSimpleCircle {

    public static void main(String[] args) {
        final Point p1 = new Point(0,0);
        final SimpleCircle c1 = new SimpleCircle(2.0, p1);
        p1.setLocation(42, 42);
        final SimpleCircle c2 = new SimpleCircle(2.0, p1);
        p1.setLocation(13, 13);
        final SimpleCircle c3 = new SimpleCircle(2.0, p1);
        
        System.out.println(c1.getCenter().getX());
        System.out.println(c2.getCenter().getX());
        System.out.println(c3.getCenter().getX());

    }

}
