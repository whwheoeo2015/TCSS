/*
 * TCSS 305
 */

package filters;

import image.Pixel;
import image.PixelImage;

/**
 * A filter that flips the image horizontally.
 * 
 * @author TCSS 305 instructors
 * @version 1.3
 */
public class FlipHorizontalFilter extends AbstractFilter {
    /**
     * Constructs a new flip horizontal filter.
     */
    public FlipHorizontalFilter() {
        super("Flip Horizontal");
    }

    /**
     * Filters the specified image.
     * 
     * @param theImage The image.
     */
    @Override
    public void filter(final PixelImage theImage) {
        final Pixel[][] data = theImage.getPixelData();
        for (int row = 0; row < theImage.getHeight(); row++) {
            for (int col = 0; col < theImage.getWidth() / 2; col++) {
                swap(data, row, col, row, theImage.getWidth() - col - 1);
            }
        }
        theImage.setPixelData(data);
    }
}
