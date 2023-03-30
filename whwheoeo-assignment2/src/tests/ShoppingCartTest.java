/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import model.Item;
import model.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Junghyon Jo
 * @version 10/21/2022
 */
class ShoppingCartTest {
    
    /**
     * A shopping cart to use in the tests.
     */
    private ShoppingCart myCartTest;
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() {
        myCartTest = new ShoppingCart();
    }

    /**
     * Test method for {@link model.ShoppingCart#calculateTotal()}.
     */
    @Test
    void testCalculateTotal() {
        
        final String name = "Silly Putty";
        final String strPrice = "10.00";
        final String strSecondPrice = "1.20";
        
        final BigDecimal price = new BigDecimal(strPrice);
        final BigDecimal secondPrice = new BigDecimal(strSecondPrice);
        final int bulQuantity = 10;
        final BigDecimal bulkPrice = new BigDecimal(strPrice);
        
        final Item firstItem = new Item(name, price);
        
        myCartTest.add(firstItem, 2);
        
        myCartTest.setMembership(false);
        
        final String comparePrice = "20.00";
        final BigDecimal testTotalPrice = new BigDecimal(comparePrice);
        
        assertEquals(testTotalPrice, myCartTest.calculateTotal());
        
        myCartTest.clear();
        
        final Item secondItem = new Item(name, secondPrice, bulQuantity, bulkPrice);
        
        myCartTest.add(secondItem, 40);
        
        myCartTest.setMembership(true);
        
        final String comparePriceBulk = "36.00";
        final BigDecimal testSecondTotalPrice = new BigDecimal(comparePriceBulk);
        
        assertEquals(testSecondTotalPrice, myCartTest.calculateTotal());
        
    }

}
