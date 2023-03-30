/**
 * 
 */
package tests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import model.Item;
import model.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Junghyon Jo
 * @version 10/21/2022
 */
class ItemTest {
    
    /**
     * A Item to use in the tests.
     */
    private Item myItem;
    
    /**
     * The method to initialize Item before testing each method.
     */
    @BeforeEach
    // The method will run before tests.
    void setUp() {
        
        final String name = "Silly Putty";
        final String strPrice = "1.45";
        final BigDecimal price = new BigDecimal(strPrice);
        
        myItem = new Item(name, price);
        
    }

    /**
     * Test method for {@link model.Item#hashCode()}.
     */
    @Test
    void testHashCode() {
        
        final String name = "Silly Putty";
        final String strPrice = "1.45";
        final BigDecimal price = new BigDecimal(strPrice);
        final int testHash = myItem.hashCode();
        
        final Item testItem = new Item(name, price);
        
        assertEquals(testHash, testItem.hashCode());
        
    }

    /**
     * Test method for {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test
    void testItemStringBigDecimal() {
        
        final String name = "Silly Putty";
        final String strPrice = "1.45";
        final BigDecimal price = new BigDecimal(strPrice);
        
        myItem = new Item(name, price);
        
        final String testName = "Silly Putty";
        final BigDecimal testPrice = new BigDecimal(strPrice);
        
        assertEquals(testName, myItem.getName());
        assertEquals(testPrice, myItem.getPrice());
    
    }

    /**
     * Test method for {@link model.Item#Item
     * (java.lang.String, java.math.BigDecimal, int, java.math.BigDecimal)}.
     */
    @Test
    void testItemStringBigDecimalIntBigDecimal() {
        
        final String name = "Silly Putty";
        final String strPrice = "1.45";
        final BigDecimal price = new BigDecimal(strPrice);
        final int bulQuantity = 5;
        final String strBulkPrice = "5.00";
        final BigDecimal bulkPrice = new BigDecimal(strBulkPrice);
        
        myItem = new Item(name, price, bulQuantity, bulkPrice);
        
        final String testName = "Silly Putty";
        final BigDecimal testPrice = new BigDecimal(strPrice);
        final int testBulQuantity = 5;
        final BigDecimal testBulkPrice = new BigDecimal(strBulkPrice);
        
        assertEquals(testName, myItem.getName());
        assertEquals(testPrice, myItem.getPrice());
        assertEquals(testBulQuantity, myItem.getBulkQuantity());
        assertEquals(testBulkPrice, myItem.getBulkPrice());
        
    }

    /**
     * Test method for {@link model.Item#isBulk()}.
     */
    @Test
    void testIsBulk() {
        
        final String name = "Silly Putty";
        final String strPrice = "1.45";
        final BigDecimal price = new BigDecimal(strPrice);
        final int bulQuantity = 5;
        final String strBulkPrice = "5.00";
        final BigDecimal bulkPrice = new BigDecimal(strBulkPrice);
        
        myItem = new Item(name, price);
        assertEquals(false, myItem.isBulk());
        
        myItem = new Item(name, price, bulQuantity, bulkPrice);
        assertEquals(true, myItem.isBulk());
        
    }

    /**
     * Test method for {@link model.Item#toString()}.
     */
    @Test
    void testToString() {
        
        final String name = "Silly Putty";
        final String strPrice = "1.45";
        final BigDecimal price = new BigDecimal(strPrice);
        final int bulQuantity = 5;
        final String strBulkPrice = "5.00";
        final BigDecimal bulkPrice = new BigDecimal(strBulkPrice);        
        final StringBuilder testBuilder = new StringBuilder(128);
        final StringBuilder testBuilderBulk = new StringBuilder(128);
        final String symbol = ")"; 
        final String anotherSymbol = ", ";
        
        final NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        
        testBuilder.append(name);
        testBuilder.append(", ");
        testBuilder.append(nf.format(price));
        myItem = new Item(name, price);
        assertEquals(testBuilder.toString(), myItem.toString());
        
        
        testBuilderBulk.append(name);
        testBuilderBulk.append(anotherSymbol);
        testBuilderBulk.append(nf.format(price));
        testBuilderBulk.append(" (");
        testBuilderBulk.append(bulQuantity);
        testBuilderBulk.append(" for ");
        testBuilderBulk.append(nf.format(bulkPrice));
        testBuilderBulk.append(symbol);
        myItem = new Item(name, price, bulQuantity, bulkPrice);
        assertEquals(testBuilderBulk.toString(), myItem.toString());
    
    }

    /**
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    void testEqualsObject() {
        
        final String name = "Silly Putty";
        final String strPrice = "1.45";
        final BigDecimal price = new BigDecimal(strPrice);
        final int bulQuantity = 5;
        final String strBulkPrice = "5.00";
        final BigDecimal bulkPrice = new BigDecimal(strBulkPrice);
        
        myItem = new Item(name, price, bulQuantity, bulkPrice);
        
        assertEquals(myItem, myItem);
        
        assertNotEquals(myItem, null);
        
        assertNotEquals(myItem, new ShoppingCart());
        
        final String wrongName = "Billy Putty";
        
        assertFalse(myItem.equals(new Item(wrongName, price, bulQuantity, bulkPrice)));
        assertFalse(myItem.equals(new Item(name, bulkPrice, bulQuantity, bulkPrice)));
        assertFalse(myItem.equals(new Item(name, price, 10, bulkPrice)));
        assertFalse(myItem.equals(new Item(name, price, bulQuantity, price)));
        assertEquals(true, myItem.equals(new Item(name, price, bulQuantity, bulkPrice)));
        
    }

}
