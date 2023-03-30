/*
 * TCSS 305 Assignment 2
 */

package view;

import java.awt.EventQueue;
import utility.FileLoader;

/**
 * ShoppingMain provides the main method for a simple shopping cart GUI.
 * 
 * @author TCSS 305 Instructors
 * 
 * @version 2.1
 */

public final class ShoppingMain {
    
    /**
     * The path and name of the inventory file.
     */
    private static final String INVENTORY_FILE = "files/items.txt";   

    /**
     * A private constructor, to prevent external instantiation.
     */
    private ShoppingMain() {
    }

    /**
     * The main() method - displays and runs the shopping cart GUI.
     * 
     * @param theArgs Command line arguments, ignored by this program.
     */
    public static void main(final String... theArgs) { 
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShoppingFrame(FileLoader.readItemsFromFile(INVENTORY_FILE));
            }
        });
    } // end main()

} // end class ShoppingMain
