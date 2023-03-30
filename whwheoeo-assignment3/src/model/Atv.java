/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * Represents a Atv.
 * 
 * @author Junghyon Jo 
 * @version 01 Nov 2022 
 */
public class Atv extends AbstractVehicle {
    
    /** The death counter number for Atv. */
    private static final int TOTAL_DEATH_COUNT = 20;
    
    /**
     * ArrayList to store valid direction for Atv.
     */
    private ArrayList<Direction> myChoiceDirList;
    /**
     * To create a valid random direction for Atv.
     */
    private Random myRand;
    
    /**
     * Initialize the instance fields.
     * 
     * @param theVehicleX the x of the vehicle
     * @param theVehicleY the y of the vehicle
     * @param theDir the direction of the vehicle
     */
    public Atv(final int theVehicleX, final int theVehicleY, final Direction theValueOf) {
        super(theVehicleX, theVehicleY, theValueOf, TOTAL_DEATH_COUNT);
        myAliveImage = "atv.gif";
        myDeathImage = "atv_dead.gif";
    }
    
    /**
     * method to define Atv behavior.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        myChoiceDirList = new ArrayList<Direction>();
        final int index;
        myRand = new Random();
        
        if (!(theNeighbors.get(getDirection()) == Terrain.WALL)) {
            myChoiceDirList.add(this.getDirection());
        }
        if (!(theNeighbors.get(getDirection().left()) == Terrain.WALL)) {
            myChoiceDirList.add(this.getDirection().left());
        } 
        if (!(theNeighbors.get(getDirection().right()) == Terrain.WALL)) {
            myChoiceDirList.add(this.getDirection().right());
        }
        
        if (myChoiceDirList.size() > 0) {
            index = myRand.nextInt(myChoiceDirList.size());
            myChoice = myChoiceDirList.get(index);
        } else {
            myChoice = this.getDirection().reverse();
        }
        
        return myChoice;
    }
    
    /**
     * Method to decide valid direction for Atv.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        myPass = true;
        if (theTerrain == Terrain.WALL) {
            myPass = false;
        }
        return myPass;
    }
}
