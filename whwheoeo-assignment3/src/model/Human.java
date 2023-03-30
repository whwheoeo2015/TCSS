/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * Represents a Human.
 * 
 * @author Junghyon Jo 
 * @version 01 Nov 2022 
 */
public class Human extends AbstractVehicle {
    
    /** The death counter number for Human. */
    private static final int TOTAL_DEATH_COUNT = 40;
    
    /**
     * ArrayList to store valid direction for Human.
     */
    private ArrayList<Direction> myChoiceGrassList;
    /**
     * To create a valid random direction for Human.
     */
    private Random myRand;
    
    /**
     * Initialize the instance fields.
     * 
     * @param theVehicleX the x of the vehicle
     * @param theVehicleY the y of the vehicle
     * @param theDir the direction of the vehicle
     */
    public Human(final int theVehicleX, final int theVehicleY, final Direction theValueOf) {
        super(theVehicleX, theVehicleY, theValueOf, TOTAL_DEATH_COUNT);
        myAliveImage = "human.gif";
        myDeathImage = "human_dead.gif";
    }
    
    /**
     * method to define Human behavior.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        myChoiceGrassList = new ArrayList<Direction>();
        final int index;
        myRand = new Random();
        
        if (theNeighbors.get(getDirection()) != Terrain.CROSSWALK
                && theNeighbors.get(getDirection().left()) != Terrain.CROSSWALK
                && theNeighbors.get(getDirection().right()) != Terrain.CROSSWALK) {
            if (theNeighbors.get(getDirection()) == Terrain.GRASS) {
                myChoiceGrassList.add(this.getDirection());
            }
            if (theNeighbors.get(getDirection().left()) == Terrain.GRASS) {
                myChoiceGrassList.add(this.getDirection().left());
            }
            if (theNeighbors.get(getDirection().right()) == Terrain.GRASS) {
                myChoiceGrassList.add(this.getDirection().right());
            }
        } else if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
            myChoice = this.getDirection();
            return myChoice;
        } else if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK) {
            myChoice = this.getDirection().left();
            return myChoice;
        } else if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK) {
            myChoice = this.getDirection().right();
            return myChoice;
        }
            
        if (myChoiceGrassList.size() > 0) {
            index = myRand.nextInt(myChoiceGrassList.size());
            myChoice = myChoiceGrassList.get(index);
        } else {
            myChoice = this.getDirection().reverse();
        }
        return myChoice;
    }
    
    /**
     * Method to decide valid direction for Human.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        myPass = false;
        
        if (theTerrain == Terrain.GRASS) {
            myPass = true;
        }
        if (theTerrain == Terrain.CROSSWALK && !(theLight == Light.GREEN)) {
            myPass = true;
        }
        
        return myPass;
    }
}
