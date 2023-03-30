/*
 * TCSS 305
 */

package filters;

/**
 * A filter that makes the image less sharp.
 * 
 * @author TCSS 305 instructors
 * @version 1.3
 */
public class SoftenFilter extends AbstractWeightedFilter {
    /**
     * A 3x3 grid of weights to use for the weighted filter algorithm.
     */
    private static final int[][] WEIGHTS = {{1, 2, 1}, {2, 4, 2}, {1, 2, 1}};

    /**
     * Constructs a new softening filter.
     */
    public SoftenFilter() {
        super("Soften", WEIGHTS);
    }

}
