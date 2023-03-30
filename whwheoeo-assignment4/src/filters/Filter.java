/*
 * TCSS 305
 */

package filters;

import image.PixelImage;

/**
 * An interface for filters that modify images.
 * 
 * @author TCSS 305 instructors
 * @version 1.3
 */
public interface Filter {
    /**
     * Modifies the image according to this filter's algorithm.
     * 
     * @param theImage The image.
     */
    void filter(PixelImage theImage);

    /**
     * Returns a text description of this filter.
     * 
     * @return a text description of this filter.
     */
    String getDescription();
}
