// Finish and comment me!

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
/** 
 *  This program set information of items 
 *  with their name, price, bulk quantity, and bulk price.
 *  It also offers hash code of the items.
 *  It also compares that the item is identical with another item. 
 *  
 * @author Junghyon Jo 
 * @version 22 Oct 2022 
 */
public final class Item {
    
    //instance fields
    /** Name of the item.*/
    private String myName;
    /** price of the item.*/
    private BigDecimal myPrice;
    /** bulk quantity of the item.*/
    private BigDecimal myBulkPrice;
    /** bulk price of the item.*/
    private int myBulkQuantity;
    
    /**
     * Constructs a Item with name and price.
     * 
     * @param theName The name of the item.
     * @param thePrice The price of the item.
     */
    public Item(final String theName, final BigDecimal thePrice) {
        
        myName = theName;
        myPrice = thePrice;

    }

    /**
     * Constructs a Item with name, price, bulk quantity and bulk price.
     * 
     * @param theName The name of the item.
     * @param thePrice The price of the item.
     * @param theBulkQuantity The bulk quantity of the item.
     * @param theBulkPrice The bulk price of the item.
     */
    public Item(final String theName, final BigDecimal thePrice,
                final int theBulkQuantity, final BigDecimal theBulkPrice) {
        
        myName = theName;
        myPrice = thePrice;
        myBulkPrice = theBulkPrice;
        myBulkQuantity = theBulkQuantity;

    }
    
    /**
     * What is the name of the item?
     * 
     * @return the name of the item.
     */
    public String getName() {
        
        return myName;
    }
    
    /**
     * What is the price of the item?
     * 
     * @return the price of the item.
     */
    public BigDecimal getPrice() {
        
        return myPrice;
    }
    
    /**
     * What is the bulk quantity of the item?
     * 
     * @return the bulk quantity of the item.
     */
    public int getBulkQuantity() {
        
        return myBulkQuantity;
    }
    
    /**
     * What is the bulk price of the item?
     * 
     * @return the bulk price of the item.
     */
    public BigDecimal getBulkPrice() {
        
        return myBulkPrice;
    }

    /**
     * Is the item bulk?
     * 
     * @return true or false
     */
    public boolean isBulk() {

        if (myBulkQuantity > 0) {
            return true;
        } 
        
        return false;
    }
    
    /**
     * The method will return information of the items 
     * with name, price, bulk quantity and bulk price.
     * 
     * @return String
     */
    @Override
    public String toString() {
        
        final StringBuilder builder = new StringBuilder(128);
        final NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        final String symbol = ")"; 
        final String anotherSymbol = ", ";
        
        if (isBulk()) {
        
            builder.append(myName);
            builder.append(anotherSymbol);
            builder.append(nf.format(myPrice));
            builder.append(" (");
            builder.append(myBulkQuantity);
            builder.append(" for ");
            builder.append(nf.format(myBulkPrice));
            builder.append(symbol);
        
        } else {
            
            builder.append(myName);
            builder.append(anotherSymbol);
            builder.append(nf.format(myPrice));
            
        }
        
        return builder.toString();
        
    }

    /**
     * Returns true if the parameter is a item with. 
     * identical name, price, bulk quantity and bulk price. false otherwise as the item.
     * 
     */
    @Override
    public boolean equals(final Object theOther) {
        
        if (this == theOther) {
            return true;
        }

        if (theOther == null) {
            return false;
        }

        if (!(theOther instanceof Item)) {
            return false;
        }

        final Item otherItem = (Item) theOther;
      
        return Objects.equals(myPrice, otherItem.myPrice)
            && Objects.equals(myName, otherItem.myName)
            && myBulkQuantity == otherItem.myBulkQuantity
            && Objects.equals(myBulkPrice, otherItem.myBulkPrice);
    }


    @Override
    public int hashCode() {

        return Objects.hash(myName, myPrice, myBulkQuantity, myBulkPrice);
        
    }

}
