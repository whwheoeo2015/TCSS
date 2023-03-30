/*
 * TCSS 305 Assignment 2
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import model.Item;
import model.ShoppingCart;

/**
 * ShoppingFrame provides the user interface for a shopping cart program.
 * 
 * @author TCSS 305 instructors
 * 
 * @version 2.1
 */
public final class ShoppingFrame extends JFrame {
    
    /** A generated serialization id. */
    private static final long serialVersionUID = 4479585442295889730L;

    // constants to capture screen dimensions
    /** A ToolKit. */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /** The Dimension of the screen. */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();

    /** The width of the text field in the GUI. */
    private static final int TEXT_FIELD_WIDTH = 12;
    
    /*
     * For the UW color palette and other UW branding information see
     * http://www.washington.edu/brand/graphic-elements/primary-color-palette/ 
     */
    
    /**
     * The color for some elements in the GUI.
     */
    private static final Color UW_GOLD = new Color(232, 211, 162);

    /**
     * The color for some elements in the GUI.
     */
    private static final Color UW_PURPLE = new Color(51, 0, 111);

    /**
     * The shopping cart used by this GUI.
     */
    private final ShoppingCart myItems;
    
    /**
     * The list that stores the inventory.
     */
    private final List<Item> myInventory;
    
    /**
     * The text field used to display the total amount owed by the customer.
     */
    private final JTextField myTotal;

    /**
     * A List of the item text fields.
     */
    private final List<JTextField> myQuantities;
    
    /**
     * Initializes the shopping cart GUI.
     * 
     * @param theInventory The list of Items.
     */
    public ShoppingFrame(final List<Item> theInventory) {
        
        super(); // No title on the JFrame. We can set this later.
        
        myItems = new ShoppingCart();

        // set up text field with order total
        myTotal = new JTextField("$0.00", TEXT_FIELD_WIDTH);
        
        myQuantities = new LinkedList<>();
        
        myInventory = theInventory;
        setupGUI();
    }    

    /**
     * Setup the various parts of the GUI.
     */
    private void setupGUI() {
        
        // replace the default JFrame icon
//        final ImageIcon img = new ImageIcon("files/w.gif");
//        setIconImage(img.getImage());
//        
        setTitle("Shopping Cart");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(makeTotalPanel(), BorderLayout.NORTH);
        
        final JPanel itemsPanel = makeItemsPanel(myInventory); 
        add(itemsPanel, BorderLayout.CENTER);
        
        add(makeCheckBoxPanel(), BorderLayout.SOUTH);

        // adjust size to just fit
        pack();
        
        // make the GUI so that it cannot be resized by the user dragging a corner
        setResizable(false);
        
        // position the frame in the center of the screen
        setLocation(SCREEN_SIZE.width / 2 - getWidth() / 2,
                    SCREEN_SIZE.height / 2 - getHeight() / 2);
        setVisible(true);
    }
    

    /**
     * Creates a panel to hold the total.
     * 
     * @return The created panel
     */
    private JPanel makeTotalPanel() {
        // tweak the text field so that users can't edit it, and set
        // its color appropriately

        myTotal.setEditable(false);
        myTotal.setEnabled(false);
        myTotal.setDisabledTextColor(Color.BLACK);

        // create the panel, and its label

        final JPanel totalPanel = new JPanel();
        totalPanel.setBackground(UW_PURPLE);
        final JLabel l = new JLabel("order total");
        l.setForeground(Color.WHITE);
        totalPanel.add(l);
        totalPanel.add(myTotal);
        
        final JPanel p = new JPanel(new BorderLayout());
        p.add(totalPanel, BorderLayout.CENTER);
        
        return p;
    }

    /**
     * Creates a panel to hold the specified list of items.
     * 
     * @param theItems The items
     * @return The created panel
     */
    private JPanel makeItemsPanel(final List<Item> theItems) {
        final JPanel p = new JPanel(new GridLayout(theItems.size(), 1));
        
        for (final Item item : theItems) {
            addItem(item, p);
        }

        return p;
    }

    /**
     * Creates and returns the checkbox panel.
     * 
     * @return the checkbox panel
     */
    private JPanel makeCheckBoxPanel() {
        final JPanel p = new JPanel();
        p.setBackground(UW_PURPLE);
        
        final JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myItems.clear();
                for (final JTextField field : myQuantities) {
                    field.setText("");
                }
                updateTotal();
            }
        });
        p.add(clearButton);
        
        final JCheckBox cb = new JCheckBox("customer has store membership");
        cb.setForeground(Color.WHITE);
        cb.setBackground(UW_PURPLE);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myItems.setMembership(cb.isSelected());
                updateTotal();
            }
        });
        p.add(cb);
        
        return p;
    }

    /**
     * Adds the specified product to the specified panel.
     * 
     * @param theItem The product to add.
     * @param thePanel The panel to add the product to.
     */
    private void addItem(final Item theItem, final JPanel thePanel) {
        final JPanel sub = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sub.setBackground(UW_GOLD);
        final JTextField quantity = new JTextField(3);
        myQuantities.add(quantity);
        quantity.setHorizontalAlignment(SwingConstants.CENTER);
        quantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                quantity.transferFocus();
            }
        });
        quantity.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(final FocusEvent theEvent) {
                updateItem(theItem, quantity);
            }
        });
        sub.add(quantity);
        final JLabel l = new JLabel(theItem.toString());
        l.setForeground(UW_PURPLE);
        sub.add(l);
        thePanel.add(sub);
    }

    /**
     * Updates the set of items by changing the quantity of the specified
     * product to the specified quantity.
     * 
     * @param theItem The product to update.
     * @param theQuantity The new quantity.
     */
    private void updateItem(final Item theItem, final JTextField theQuantity) {
        final String text = theQuantity.getText().trim();
        int number = 0;
        try {
            number = Integer.parseInt(text);
            if (number < 0) {
                // disallow negative numbers
                throw new NumberFormatException();
            }
        } catch (final NumberFormatException e) {
            number = 0;
            theQuantity.setText("");
        }
        myItems.add(theItem, number);
        updateTotal();
    }

    /**
     * Updates the total displayed in the window.
     */
    private void updateTotal() {
        final double total = myItems.calculateTotal().doubleValue();
        myTotal.setText(NumberFormat.getCurrencyInstance().format(total));
    }
}

// end of class ShoppingFrame
