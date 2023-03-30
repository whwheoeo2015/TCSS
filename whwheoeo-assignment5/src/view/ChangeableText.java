package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChangeableText {
    
    /** The text to check that the panel has some shapes.
     *  If it has some shapes, the text will set Clear... button is able to use.
     */
    private String myText;
    
    /**
     * Support for firing property change events from this class.
     */
    private final PropertyChangeSupport myPCS = new PropertyChangeSupport(this);
    
    public ChangeableText(final String theIntialText) {
        myText = theIntialText;
    }
    
    public void setText(final String theText) {
        final String empty = "Empty Panel";
        final String noClean = "Not Clear";
        
        if (empty.equals(theText)) {
            myPCS.firePropertyChange(empty, myText, theText);
            myText = theText;
        } else if (noClean.equals(theText)) {
            myPCS.firePropertyChange(noClean, myText, theText);
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
