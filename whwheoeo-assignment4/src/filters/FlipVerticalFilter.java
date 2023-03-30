/*
 * TCSS 305
 */

package filters;

import image.Pixel;
import image.PixelImage;

/**
 * A filter that flips the image vertically.
 * 
 * @author TCSS 305 instructors
 * @version 1.3
 */
public class FlipVerticalFilter extends AbstractFilter {
    /**
     * Constructs a new flip vertical filter.
     */
    public FlipVerticalFilter() {
        super("Flip Vertical");
    }

    /**
     * Filters the specified image.
     * 
     * @param theImage The image.
     */
    @Override
    public void filter(final PixelImage theImage) {
        final Pixel[][] data = theImage.getPixelData();
        for (int row = 0; row < theImage.getHeight() / 2; row++) {
            for (int col = 0; col < theImage.getWidth(); col++) {
                swap(data, row, col, theImage.getHeight() - row - 1, col);
            }
        }
        theImage.setPixelData(data);
    }
}
