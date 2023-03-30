/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * Represents a Truck.
 * 
 * @author Junghyon Jo 
 * @version 01 Nov 2022 
 */
public class Truck extends AbstractVehicle {
    
    /**
     * The death counter number for Truck.
     * It is assigned with negative number to be alive 
     * when it collides with other object. 
     */
    private static final int TOTAL_DEATH_COUNT = -10;
    /**
     * ArrayList to store valid direction for Truck.
     */
    private ArrayList<Direction> myChoiceDirList;
    /**
     * To create a valid random direction for Truck.
     */
    private Random myRand;
    
    /**
     * Initialize the instance fields.
     * 
     * @param theVehicleX the x of the vehicle
     * @param theVehicleY the y of the vehicle
     * @param theDir the direction of the vehicle
     */
    public Truck(final int theVehicleX, final int theVehicleY, final Direction theValueOf) {
        super(theVehicleX, theVehicleY, theValueOf, TOTAL_DEATH_COUNT);
        myAliveImage = "truck.gif";
        myDeathImage = "truck_dead.gif";
    }
    
    /**
     * Method to decide valid direction for Truck.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        myPass = false;
        
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT) {
            myPass = true;
        }
        if (theTerrain == Terrain.CROSSWALK && !(theLight == Light.RED)) {
            myPass = true;
        }
        
        return myPass;
    }
    
    /**
     * method to define Truck behavior.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {  
        myChoiceDirList = new ArrayList<Direction>();
        final int index;
        myRand = new Random();
        if (theNeighbors.get(getDirection()) == Terrain.STREET
                || theNeighbors.get(getDirection()) == Terrain.CROSSWALK
                || theNeighbors.get(getDirection()) == Terrain.LIGHT) {
            myChoiceDirList.add(this.getDirection());
        }
        if (theNeighbors.get(getDirection().left()) == Terrain.STREET
                || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                || theNeighbors.get(getDirection().left()) == Terrain.LIGHT) {
            myChoiceDirList.add(this.getDirection().left());
        } 
        if (theNeighbors.get(getDirection().right()) == Terrain.STREET
                || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                || theNeighbors.get(getDirection().right()) == Terrain.LIGHT) {
            myChoiceDirList.add(this.getDirection().right());
        }
        if (!(myChoiceDirList.size() > 0)) {
            myChoice = this.getDirection().reverse();
        } else {
            index = myRand.nextInt(myChoiceDirList.size());
            myChoice = myChoiceDirList.get(index);
        }
        return myChoice;
    }
}
