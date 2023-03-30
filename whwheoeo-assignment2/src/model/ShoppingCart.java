// Finish and comment me!

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/** 
 *  This program collects information about items
 *  and calculate the total price of items.
 *  
 * @author Junghyon Jo 
 * @version 22 Oct 2022 
 */
public class ShoppingCart {
    
    //instance fields
    /** Map to store quantity of item with key.*/
    private Map<String, Integer> myItemQuantity;
    /** Map to store bulk quantity of item with key.*/
    private Map<String, Integer> myItemBulkQuantity;
    /** Map to store bulk price of item with key.*/
    private Map<String, BigDecimal> myItemBulkPrice;
    /** Map to store price of item with key.*/
    private Map<String, BigDecimal> myItemPrice;
    /** Boolean value to store customer's membership status.*/
    private boolean myMembership;
    /** valid key values to access map.*/
    private Set<String> myKeys;

    public ShoppingCart() {
        myItemQuantity = new HashMap<String, Integer>();
        myItemBulkQuantity = new HashMap<String, Integer>();
        myItemBulkPrice = new HashMap<String, BigDecimal>();
        myItemPrice = new HashMap<String, BigDecimal>();
    }


    public void add(final Item theItem, final int theQuantity) {
        myItemQuantity.put(theItem.getName(), theQuantity);
        myItemBulkQuantity.put(theItem.getName(), theItem.getBulkQuantity());
        myItemBulkPrice.put(theItem.getName(), theItem.getBulkPrice());
        myItemPrice.put(theItem.getName(), theItem.getPrice());
        myKeys = myItemQuantity.keySet();
    }


    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }


    public BigDecimal calculateTotal() {
        
        final String iniToZero = "0";
        final String strDisscount = "0.90";
        final String strComparePrice = "15.00";
        
        BigDecimal totalPrice = new BigDecimal(iniToZero);
        BigDecimal totalItemPrice = new BigDecimal(iniToZero);
        BigDecimal totalBulkPrice = new BigDecimal(iniToZero);
        final BigDecimal comparePrice = new BigDecimal(strComparePrice);
        final BigDecimal discount = new BigDecimal(strDisscount);
        
        final Iterator<String> itr = myKeys.iterator();
       
        while (itr.hasNext()) {
            final String key = itr.next();
            int remainQuantity = 0;
            int bulkQuantity = 0;
            
            if (myItemBulkQuantity.get(key) > 0) {
                remainQuantity = myItemQuantity.get(key) % myItemBulkQuantity.get(key);
                bulkQuantity = myItemQuantity.get(key) / myItemBulkQuantity.get(key);
                
                totalItemPrice =  myItemPrice.get(key).multiply(
                                  new BigDecimal(remainQuantity));
                totalBulkPrice =  myItemBulkPrice.get(key).multiply(
                                  new BigDecimal(bulkQuantity));
                
                totalPrice = totalPrice.add(totalItemPrice).
                        setScale(2, RoundingMode.HALF_EVEN);
                totalPrice = totalPrice.add(totalBulkPrice).
                        setScale(2, RoundingMode.HALF_EVEN);
            } else {
                totalItemPrice = myItemPrice.get(key).multiply(
                        new BigDecimal(myItemQuantity.get(key)));
                totalPrice = totalPrice.add(totalItemPrice).
                        setScale(2, RoundingMode.HALF_EVEN);
            }
        }
        
        if (totalPrice.compareTo(comparePrice) > 0 && myMembership) {
            
            totalPrice = totalPrice.multiply(discount).setScale(2, RoundingMode.HALF_EVEN);
            
        }
        
        return totalPrice;

    }
    
    public void clear() {
        
        myItemQuantity.clear();
        myItemBulkQuantity.clear();
        myItemBulkPrice.clear();
        myItemPrice.clear();
        
    }

}
