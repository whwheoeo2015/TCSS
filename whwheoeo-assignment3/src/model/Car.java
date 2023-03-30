/**
 * 
 */
package model;

import java.util.Map;

/**
 * Represents a Car.
 * 
 * @author Junghyon Jo 
 * @version 01 Nov 2022 
 */
public class Car extends AbstractVehicle {
    
    /** The death counter number for Car. */
    private static final int TOTAL_DEATH_COUNT = 10;
    
    /**
     * Initialize the instance fields.
     * 
     * @param theVehicleX the x of the vehicle
     * @param theVehicleY the y of the vehicle
     * @param theDir the direction of the vehicle
     */
    public Car(final int theVehicleX, final int theVehicleY, final Direction theValueOf) {
        super(theVehicleX, theVehicleY, theValueOf, TOTAL_DEATH_COUNT);
        myAliveImage = "car.gif";
        myDeathImage = "car_dead.gif";
    }
    
    /**
     * Method to decide valid direction for Car.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        
        myPass = false;
        
        if (theTerrain == Terrain.STREET) {
            myPass = true;
        } 
        
        if (theTerrain == Terrain.LIGHT && theLight == Light.GREEN) {
            myPass = true;
        }
        
        if (theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN) {
            myPass = true;
        }
        
        return myPass;
    }
    
    /**
     * method to define Car behavior.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        
        if (theNeighbors.get(getDirection()) == Terrain.STREET
                || theNeighbors.get(getDirection()) == Terrain.CROSSWALK
                || theNeighbors.get(getDirection()) == Terrain.LIGHT) {
            myChoice = this.getDirection();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.STREET) {
            myChoice = this.getDirection().right();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.STREET) {
            myChoice = this.getDirection().left();
        } else {
            myChoice = this.getDirection().reverse();
        }
        return myChoice;
    }
}
