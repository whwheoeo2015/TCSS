/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Direction;
import model.Light;
import model.Terrain;
import model.Truck;
import org.junit.jupiter.api.Test;


/**
 * Test methods for Truck class.
 * 
 * @author Junghyon Jo
 * @version 10/Nov/2022
 */
class TruckTest {
    
    /**
     * The number of times to repeat a test random direction.
     */
    private static final int TRIES_FOR_RANDOMNESS = 50;
    
    /**
     * Test method for {@link model.Truck#canPass(model.Terrain, model.Light)}.
     */
    @Test
    void testCanPass() {
        final List<Terrain> validTerrain = new ArrayList<>();
        validTerrain.add(Terrain.STREET);
        validTerrain.add(Terrain.LIGHT);
        validTerrain.add(Terrain.CROSSWALK);
                
        final Truck truck = new Truck(0, 0, Direction.NORTH);
        
        for (final Terrain destinationTerrain : Terrain.values()) {
            for (final Light currentLightCondition : Light.values()) {
                if (destinationTerrain == Terrain.STREET) {
                
                    assertTrue("Truck should be able to pass STREET"
                               + ", with light " + currentLightCondition,
                               truck.canPass(destinationTerrain, currentLightCondition));
                    
                } else if (destinationTerrain == Terrain.LIGHT) {
                
                    assertTrue("Truck should be able to pass LIGHT"
                               + ", with light " + currentLightCondition,
                               truck.canPass(destinationTerrain, currentLightCondition));
                    
                } else if (destinationTerrain == Terrain.CROSSWALK) {
                           
                    if (currentLightCondition == Light.RED) {
                        assertFalse("Truck should NOT be able to pass " + destinationTerrain
                            + ", with light " + currentLightCondition,
                            truck.canPass(destinationTerrain,
                                          currentLightCondition));
                    } else if (currentLightCondition == Light.YELLOW) {
                        assertTrue("Truck should be able to pass " + destinationTerrain
                            + ", with light " + currentLightCondition,
                            truck.canPass(destinationTerrain,
                                          currentLightCondition));
                    } else {
                        assertTrue("Truck should be able to pass " + destinationTerrain
                                + ", with light " + currentLightCondition,
                                truck.canPass(destinationTerrain,
                                              currentLightCondition));
                    }
                } else if (!validTerrain.contains(destinationTerrain)) {
 
                    assertFalse("Truck should NOT be able to pass " + destinationTerrain
                        + ", with light " + currentLightCondition,
                        truck.canPass(destinationTerrain, currentLightCondition));
                }
            } 
        }
    }
    
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    void testChooseDirectionSurroundedByInvalidTrail() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.TRAIL);
        neighbors.put(Direction.NORTH, Terrain.TRAIL);
        neighbors.put(Direction.EAST, Terrain.TRAIL);
        neighbors.put(Direction.SOUTH, Terrain.LIGHT);
        
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        final Truck truck = new Truck(0, 0, Direction.NORTH);
        
        final Direction d = truck.chooseDirection(neighbors);
            
        if (d == Direction.WEST) {
            seenWest = true;
        } else if (d == Direction.NORTH) {
            seenNorth = true;
        } else if (d == Direction.EAST) {
            seenEast = true;
        } else if (d == Direction.SOUTH) {
            seenSouth = true;
        }
 
        assertFalse("Truck chooseDirection() fails to select reverse "
                   + "among all impossible invalid choices!",
                   seenWest || seenNorth || seenEast);
            
        assertTrue("Truck chooseDirection() reversed direction when it is necessary!",
                    seenSouth);
    }
    
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    void testChooseDirectionSurroundedByInvalidWall() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.WALL);
        neighbors.put(Direction.NORTH, Terrain.WALL);
        neighbors.put(Direction.EAST, Terrain.WALL);
        neighbors.put(Direction.SOUTH, Terrain.CROSSWALK);
        
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        final Truck truck = new Truck(0, 0, Direction.NORTH);
        
        final Direction d = truck.chooseDirection(neighbors);
            
        if (d == Direction.WEST) {
            seenWest = true;
        } else if (d == Direction.NORTH) {
            seenNorth = true;
        } else if (d == Direction.EAST) {
            seenEast = true;
        } else if (d == Direction.SOUTH) {
            seenSouth = true;
        }
 
        assertFalse("Truck chooseDirection() fails to select reverse "
                   + "among all impossible invalid choices!",
                   seenWest || seenNorth || seenEast);
            
        assertTrue("Truck chooseDirection() reversed direction when it is necessary!",
                    seenSouth);
    }

    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    void testChooseDirectionSurroundedByInvalidGrass() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.GRASS);
        neighbors.put(Direction.NORTH, Terrain.GRASS);
        neighbors.put(Direction.EAST, Terrain.GRASS);
        neighbors.put(Direction.SOUTH, Terrain.STREET);
        
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        final Truck truck = new Truck(0, 0, Direction.NORTH);
        
        final Direction d = truck.chooseDirection(neighbors);
            
        if (d == Direction.WEST) {
            seenWest = true;
        } else if (d == Direction.NORTH) {
            seenNorth = true;
        } else if (d == Direction.EAST) {
            seenEast = true;
        } else if (d == Direction.SOUTH) {
            seenSouth = true;
        }
 
        assertFalse("Truck chooseDirection() fails to select reverse "
                   + "among all impossible invalid choices!",
                   seenWest || seenNorth || seenEast);
            
        assertTrue("Truck chooseDirection() reversed direction when it is necessary!",
                    seenSouth);
        
        
    }
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    void testChooseDirectionSurroundedByStreet() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.STREET);
        neighbors.put(Direction.NORTH, Terrain.STREET);
        neighbors.put(Direction.EAST, Terrain.STREET);
        neighbors.put(Direction.SOUTH, Terrain.STREET);
        
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        final Truck truck = new Truck(0, 0, Direction.NORTH);
        
        for (int count = 0; count < TRIES_FOR_RANDOMNESS; count++) {
            final Direction d = truck.chooseDirection(neighbors);
            
            if (d == Direction.WEST) {
                seenWest = true;
            } else if (d == Direction.NORTH) {
                seenNorth = true;
            } else if (d == Direction.EAST) {
                seenEast = true;
            } else if (d == Direction.SOUTH) {
                seenSouth = true;
            }
        }
 
        assertTrue("Truck chooseDirection() fails to select randomly "
                   + "among all possible valid choices!",
                   seenWest && seenNorth && seenEast);
            
        assertFalse("Truck chooseDirection() reversed direction when not necessary!",
                    seenSouth);
    }
    
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    void testChooseDirectionSurroundedByLight() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.LIGHT);
        neighbors.put(Direction.NORTH, Terrain.LIGHT);
        neighbors.put(Direction.EAST, Terrain.LIGHT);
        neighbors.put(Direction.SOUTH, Terrain.LIGHT);
        
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        final Truck truck = new Truck(0, 0, Direction.NORTH);
        
        for (int count = 0; count < TRIES_FOR_RANDOMNESS; count++) {
            final Direction d = truck.chooseDirection(neighbors);
            
            if (d == Direction.WEST) {
                seenWest = true;
            } else if (d == Direction.NORTH) {
                seenNorth = true;
            } else if (d == Direction.EAST) {
                seenEast = true;
            } else if (d == Direction.SOUTH) {
                seenSouth = true;
            }
        }
 
        assertTrue("Truck chooseDirection() fails to select randomly "
                   + "among all possible valid choices!",
                   seenWest && seenNorth && seenEast);
            
        assertFalse("Truck chooseDirection() reversed direction when not necessary!",
                    seenSouth);
    }
    
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    void testChooseDirectionSurroundedByCrossWalk() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.CROSSWALK);
        neighbors.put(Direction.NORTH, Terrain.CROSSWALK);
        neighbors.put(Direction.EAST, Terrain.CROSSWALK);
        neighbors.put(Direction.SOUTH, Terrain.CROSSWALK);
        
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        final Truck truck = new Truck(0, 0, Direction.NORTH);
        
        for (int count = 0; count < TRIES_FOR_RANDOMNESS; count++) {
            final Direction d = truck.chooseDirection(neighbors);
            
            if (d == Direction.WEST) {
                seenWest = true;
            } else if (d == Direction.NORTH) {
                seenNorth = true;
            } else if (d == Direction.EAST) {
                seenEast = true;
            } else if (d == Direction.SOUTH) {
                seenSouth = true;
            }
        }
 
        assertTrue("Truck chooseDirection() fails to select randomly "
                   + "among all possible valid choices!",
                   seenWest && seenNorth && seenEast);
            
        assertFalse("Truck chooseDirection() reversed direction when not necessary!",
                    seenSouth);
    }

    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    void testTruck() {
        final Truck truck = new Truck(20, 10, Direction.EAST);
        
        assertEquals("Truck x coordinate not initialized correctly!", 20, truck.getX());
        assertEquals("Truck y coordinate not initialized correctly!", 10, truck.getY());
        assertEquals("Truck direction not initialized correctly!",
                     Direction.EAST, truck.getDirection());
        assertEquals("Truck death time not initialized correctly!", -10, truck.getDeathTime());
        assertTrue("Truck isAlive() fails initially!", truck.isAlive());
    }
    
    /**
     * Test method for set methods for x, y, and direction.
     */
    @Test
    public void testHumanSetters() {
        final Truck truck = new Truck(20, 10, Direction.EAST);
        
        truck.setX(15);
        assertEquals("Human setX failed!", 15, truck.getX());
        truck.setY(5);
        assertEquals("Human setY failed!", 5, truck.getY());
        truck.setDirection(Direction.SOUTH);
        assertEquals("Human setDirection failed!", Direction.SOUTH, truck.getDirection());
    }

}
