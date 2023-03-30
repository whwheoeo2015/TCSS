/*
 * TCSS 305 - Assignment 3
 */

package model;

/**
 * An enumeration of traffic light statuses.
 * 
 * @author TCSS 305 instructors
 * @version 1.2
 */

public enum Light {
    /**
     * Green means go.
     */
    GREEN,

    /**
     * Yellow means caution.
     */
    YELLOW,

    /**
     * Red means stop.
     */
    RED;

    /**
     * Returns the next light in sequence after this one. The sequence is GREEN,
     * YELLOW, RED.
     * 
     * @return the next light in sequence.
     */
    public Light advance() {
        Light result = Light.GREEN;

        switch (this) {
            case GREEN:
                result = YELLOW;
                break;

            case YELLOW:
                result = RED;
                break;

            case RED:
                result = GREEN;
                break;

            default:
        }

        return result;
    }
}
