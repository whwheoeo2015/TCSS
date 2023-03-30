/*
 * TCSS 305 - Assignment 3
 */

package view;

import java.awt.EventQueue;

/**
 * Runs the Easy Street program.
 * 
 * @author TCSS 305 instructors
 * @version 1.2
 */

public final class Driver {
    
    /**
     * Private constructor to prevent construction of instances.
     */
    private Driver() {
        // do nothing
    }

    /**
     * Constructs the main GUI window frame.
     * 
     * @param theArgs Command line arguments (ignored).
     */
    public static void main(final String... theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();     
            }
        });
    }
}
