package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChangeableFill {
    
    /** The text to check that the panel has some shapes.
     *  If it has some shapes, the text will set Clear... button is able to use.
     */
    private String myText;
    
    /**
     * Support for firing property change events from this class.
     */
    private final PropertyChangeSupport myPCS = new PropertyChangeSupport(this);
    
    public ChangeableFill(final String theIntialText) {
        myText = theIntialText;
    }
    
    public void setText(final String theText) {
        final String emptyFill = "No Fill";
        final String fill = "Fill the shape";
        
        if (emptyFill.equals(theText)) {
            myPCS.firePropertyChange(emptyFill, myText, theText);
            myText = theText;
        } else if (fill.equals(theText)) {
            myPCS.firePropertyChange(fill, myText, theText);
            myText = theText;
        }
    }
    
    public void addPropertyChangeListener(final PropertyChangeListener theListener) {
        myPCS.addPropertyChangeListener(theListener);
    }
    
    public void removePropertyChangeListener(final PropertyChangeListener theListener) {
        myPCS.removePropertyChangeListener(theListener);
    }
}
