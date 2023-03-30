/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;
import java.awt.geom.Point2D;
import model.Circle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test methods for Circle class.
 * 
 * @author Junghyon Jo
 * @version 10/14/2022
 */
public class CircleTest {
    
    /**
     *  When we test some methods with radius,
     *  the constant variable will be used for exact equality.  
     */
    private static final double TOLERANCE = .000001;
    /**
     * A circle to use in the tests.
     */
    // The test fixture. The Objects I will use in the tests.
    private Circle myCircle;

    /**
     * The method to initialize Circle before testing each method.
     */
    @BeforeEach
    // The method will run before tests.
    public void setUp() {
        myCircle = new Circle();
    }

    /**
     * Test constructor to create circle by passing radius, Point variable, and
     * Color variable as parameters.
     */
    @Test
    public void testCircleDoublePoint2DColor() {
        final Circle c1 = new Circle(2.0, new Point2D.Double(4.0, 6.0), Color.RED);

        assertEquals(2.0, c1.getRadius(), TOLERANCE);
        assertEquals(new Point2D.Double(4.0, 6.0), c1.getCenter());
        assertEquals(Color.RED, c1.getColor());
        
    }

    /**
     * Test method which check that 
     * radius is less than or equal to 0.
     */
    @Test
    public void testCircleDoubleRadiusException() {
        
        assertThrows(IllegalArgumentException.class, () -> 
                    new Circle(0.0, new Point2D.Double(2.0, 2.0) , Color.BLACK));
    
    }
    
    /**
     * Test method which check that
     * color of circle is null,
     * and center of circle is null.
     */
    @Test
    public void testCircleColorException() {
        
        assertThrows(NullPointerException.class, () ->
                    new Circle(1.0, new Point2D.Double(2.0, 2.0) , null));
    
    }
    
    /**
     * Test method which check that
     * color of circle is null,
     * and center of circle is null.
     */
    @Test
    public void testCircleCenterException() {
        
        assertThrows(NullPointerException.class, () ->
                    new Circle(1.0, null , Color.black));
    
    }
    
    /**
     * Test default constructor which initialize circle with DEFAULT_RADIUS, DEFAULT_CENTER,
     * and DEFAULT_COLOR in Circle class.
     */
    @Test
    public void testCircle() {

        assertEquals(1.0, myCircle.getRadius());
        assertEquals(new Point2D.Double(0.0, 0.0), myCircle.getCenter());
        assertEquals(Color.BLACK, myCircle.getColor());

    }
    
    /**
     * Test method which check that 
     * center of the parameter is null.
     */
    @Test
    public void setCenterException() {
        
        assertThrows(NullPointerException.class, () -> myCircle.setCenter(null));
        
    }

    /**
     * Test method which check that 
     * color of the parameter is null.
     */
    @Test
    public void setColorException() {
    
        assertThrows(NullPointerException.class, () -> myCircle.setColor(null));
    
    }
    
    /**
     * Test method which check that 
     * radius of the parameter is less than or equal to 0.
     */
    @Test
    public void setRadiusException() {
        
        assertThrows(IllegalArgumentException.class, () -> myCircle.setRadius(0));
        
    }

    /**
     * Test method which set the radius of circle with positive value by passing
     * parameter.
     */
    @Test
    public void testSetRadius() {

        myCircle.setRadius(8.0);

        assertEquals(8.0, myCircle.getRadius());
    
    }

    /**
     * Test method which set the center of circle by passing Point2D variable as
     * parameter.
     */
    @Test
    public void testSetCenter() {

        myCircle.setCenter(new Point2D.Double(5.0, 5.0));

        assertEquals(new Point2D.Double(5.0, 5.0), myCircle.getCenter());

    }

    /**
     * Test method which set the color of circle by passing Color variable as
     * parameter.
     */
    @Test
    public void testSetColor() {

        myCircle.setColor(Color.BLUE);

        assertEquals(Color.BLUE, myCircle.getColor());

    }

    /**
     * Test method for calculateDiameter() by assigning radius with setRadius
     * (radius).
     */
    @Test
    public void testCalculateDiameter() {

        myCircle.setRadius(5);
        assertEquals(10.0, myCircle.calculateDiameter(), TOLERANCE);

        myCircle.setRadius(6);
        assertEquals(12.0, myCircle.calculateDiameter(), TOLERANCE);

        myCircle.setRadius(7);
        assertEquals(14.0, myCircle.calculateDiameter(), TOLERANCE);

    }

    /**
     * Test method for calculateCircumference() by assigning radius with setRadius
     * (radius).
     */
    @Test
    public void testCalculateCircumference() {

        myCircle.setRadius(5);
        assertEquals(2 * 5 * Math.PI, myCircle.calculateCircumference(), TOLERANCE);

        myCircle.setRadius(6);
        assertEquals(2 * 6 * Math.PI, myCircle.calculateCircumference(), TOLERANCE);

        myCircle.setRadius(7);
        assertEquals(2 * 7 * Math.PI, myCircle.calculateCircumference(), TOLERANCE);

    }

    /**
     * Test method for calculateArea() by assigning radius with setRadius (radius).
     */
    @Test
    public void testCalculateArea() {

        myCircle.setRadius(5);
        assertEquals(5 * 5 * Math.PI, myCircle.calculateArea(), TOLERANCE);

        myCircle.setRadius(6);
        assertEquals(6 * 6 * Math.PI, myCircle.calculateArea(), TOLERANCE);

        myCircle.setRadius(7);
        assertEquals(7 * 7 * Math.PI, myCircle.calculateArea(), TOLERANCE);

    }

    /**
     * Test method for {@link model.Circle#toString()}.
     */
    @Test
    public void testToString() {

        final String checkCircleString = 
                "Circle [radius=1.00, " 
                + "center=Point2D.Double[0.0, 0.0], "
                + "color=java.awt.Color[r=0,g=0,b=0]]";

        myCircle = new Circle();
        assertEquals(checkCircleString, myCircle.toString());

    }
}