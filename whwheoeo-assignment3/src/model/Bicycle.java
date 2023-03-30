/**
 * 
 */
package model;

import java.util.Map;

/**
 * Represents a bicycle.
 * 
 * @author Junghyon Jo 
 * @version 01 Nov 2022 
 */
public class Bicycle extends AbstractVehicle {
    
    /** The death counter number for bicycle. */
    private static final int TOTAL_DEATH_COUNT = 30;
    
    /**
     * Initialize the instance fields.
     * 
     * @param theVehicleX the x of the vehicle
     * @param theVehicleY the y of the vehicle
     * @param theDir the direction of the vehicle
     */
    public Bicycle(final int theVehicleX, final int theVehicleY, final Direction theValueOf) {
        super(theVehicleX, theVehicleY, theValueOf, TOTAL_DEATH_COUNT);
        myAliveImage = "bicycle.gif";
        myDeathImage = "bicycle_dead.gif";
    }
    
    /**
     * method to define bicycle behavior.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {

        if (theNeighbors.get(getDirection()) == Terrain.TRAIL) {
            myChoice = this.getDirection();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
            myChoice = this.getDirection().right();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
            myChoice = this.getDirection().left();
        } else if (theNeighbors.get(getDirection()) == Terrain.STREET
                || theNeighbors.get(getDirection()) == Terrain.LIGHT
                || theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
            myChoice = this.getDirection();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.STREET
                || theNeighbors.get(getDirection().right()) == Terrain.LIGHT
                || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK) {
            myChoice = this.getDirection().right();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.STREET
                || theNeighbors.get(getDirection().left()) == Terrain.LIGHT
                || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK) {
            myChoice = this.getDirection().left();
        } else {
            myChoice = this.getDirection().reverse();
        }
            
        if (!myPass) {
            if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
                myChoice = this.getDirection().right();
            } else if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
                myChoice = this.getDirection().left();
            }
        }
            
        
        return myChoice;
    }

    /**
     * Method to decide valid direction for bicycle.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        myPass = false;
        
        if (theTerrain == Terrain.TRAIL || theTerrain == Terrain.STREET) {
            myPass = true;
        }
        if (theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN) {
            myPass = true;
        }
        if (theTerrain == Terrain.LIGHT && theLight == Light.GREEN) {
            myPass = true;
        }
        
        return myPass;
    }
}
