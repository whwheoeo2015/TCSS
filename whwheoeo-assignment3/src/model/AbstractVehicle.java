/**
 * 
 */
package model;

import java.util.Map;

/** 
 *  This is an abstract class for Atv, Bicycle, Car, Truck, and Human.
 *  It is a place to define default behaviors for its child classes
 *   
 * @author Junghyon Jo 
 * @version 01 Nov 2022 
 */
public abstract class AbstractVehicle implements Vehicle {
    
    /**
     *  Direction that vehicle will go.
     */
    protected Direction myChoice;
    /**
     *  Define valid direction or invalid direction.
     */
    protected boolean myPass;
    /**
     *  To store alive image for vehicle at child class.
     */
    protected String myAliveImage;
    /**
     *  To store dead image for vehicle at child class.
     */
    protected String myDeathImage;
    
    //instance field
    /**
     *  To display information of Child class such as current X, current Y, 
     *  type of vehicle, and remaining count to revive. 
     */
    private StringBuilder myBulder;
    /**
     *  Current reaming count of vehicle to revive.
     */
    private int myCount;
    /**
     *  Original death count number of vehicle.
     */
    private int myDeathTime;
    /**
     *  Current direction of vehicle.
     */
    private Direction myDir;
    /**
     *  Current image of vehicle for alive or dead.
     */
    private String myImage;
    /**
     *  Current X value of vehicle.
     */
    private int myX;
    /**
     *  Current Y value of vehicle.
     */
    private int myY;
    /**
     *  Current status value of vehicle for alive or dead.
     */
    private boolean myStatus;
    /**
     *  Original X value of vehicle.
     */
    private int myResetX;
    /**
     *  Original Y value of vehicle.
     */
    private int myResetY;
    /**
     *  Original death count value of vehicle.
     */
    private int myResetDeath;
    /**
     *  Original direction value of vehicle.
     */
    private Direction myResetDir;
    
    /**
     * Initialize the instance fields.
     * 
     * @param theVehicleX the x of the vehicle
     * @param theVehicleY the y of the vehicle
     * @param theDir the direction of the vehicle
     * @param theDeathCount number of the count to revive the vehicle
     */
    public AbstractVehicle(final int theVehicleX, final int theVehicleY, 
            final Direction theDir, final int theDeathCount) {
        
        myX = theVehicleX;
        myY = theVehicleY;
        myDir = theDir;
        myDeathTime = theDeathCount;
        myCount = theDeathCount;
        
        myResetX = theVehicleX;
        myResetY = theVehicleY;        
        myResetDir = theDir;
        myResetDeath = theDeathCount;
    }
    
    /**
     * Abstract method to be defined at child class.
     */
    @Override
    public abstract boolean canPass(Terrain theTerrain, Light theLight);
    
    /**
     * Abstract method to be defined at child class.
     */
    @Override
    public abstract Direction chooseDirection(Map<Direction, Terrain> theNeighbors);
    
    /**
     * Collision behavior of the vehicles.
     * The method decide which vehicle should be alive or be dead.
     */
    @Override
    public void collide(final Vehicle theOther) {
        if (this.isAlive() && theOther.isAlive()) {
            if (myDeathTime > theOther.getDeathTime()) {
                myStatus = false;
                myCount = myCount - 1;
            }
        }
    }
    
    /**
     * Return the original death count number for vehicle.
     * 
     * @return original death count number
     */
    @Override
    public int getDeathTime() {
        return myDeathTime;
    }
    
    /**
     * Return the direction of the vehicle.
     * 
     * @return current direction
     */
    @Override
    public Direction getDirection() {
        return myDir;
    }
    
    /**
     * Return the x value of the vehicle.
     * 
     * @return current x
     */
    @Override
    public int getX() {
        return myX;
    }
    
    /**
     * Return the y value of the vehicle.
     * 
     * @return current y
     */
    @Override
    public int getY() {
        return myY;
    }
    
    /**
     * Return the current image of vehicle depending on current status of the vehicle.
     * 
     * @return current image of vehicle
     */
    @Override
    public String getImageFileName() {
        
        if (isAlive()) {
            myImage = myAliveImage;
        } else {
            myImage = myDeathImage;
        }
        
        return myImage;
    }
    
    /**
     * Return the current status of the vehicle.
     * 
     * @return current status of the vehicle
     */
    @Override
    public boolean isAlive() {
        if (myCount == myDeathTime) {
            myStatus = true;
        } else {
            myStatus = false;
        }
        
        return myStatus;
    }
    
    /**
     * Counting death count to keep that the vehicle is dead, or
     * to decide that the vehicle is revived.
     */
    @Override
    public void poke() {
        if (!(this.isAlive())) {
            if (myCount != 0) {
                myCount = myCount - 1;
            } else if (myCount == 0) {
                myCount = myDeathTime;
                myStatus = true;
                myDir = Direction.randomDirection();
            } else if (myCount < 0) {
                myStatus = true;
            }
        }
        
    }
    
    /**
     * To reset the vehicle with its original x, y, direction, death count number and status.
     **/
    @Override
    public void reset() {
        this.setX(myResetX);
        this.setY(myResetY);
        this.setDirection(myResetDir);
        myCount = myResetDeath;
        myStatus = true;
    }
    
    /**
     * Method to set Direction.
     */
    @Override
    public void setDirection(final Direction theDir) {
        myDir = theDir;

    }
    
    /**
     * Method to set x.
     */
    @Override
    public void setX(final int theX) {
        myX = theX;

    }
    
    /**
     * Method to set y.
     */
    @Override
    public void setY(final int theY) {
        myY = theY;

    }
    
    /**
     * Method to return information of vehicle as String.
     * @return information of vehicle
     */
    public String toString() {
        final int initiSB = 128;
        myBulder = new StringBuilder(initiSB);
        
        myBulder.append(getClass().getSimpleName());
        myBulder.append(" X: ");
        myBulder.append(myX);
        myBulder.append(" Y: ");
        myBulder.append(myY);
        myBulder.append(" Direction: ");
        myBulder.append(myDir);
        myBulder.append(" Count: ");
        myBulder.append(myCount);
        return myBulder.toString();
    }
}
