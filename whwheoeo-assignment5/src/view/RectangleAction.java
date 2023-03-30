package view;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import tools.RectangleTool;

public class RectangleAction extends AbstractAction {
    
    private static final long serialVersionUID = 1L;
    
    /** Panel to be drawn.*/
    private final DrawingPanel myPanel;
    /** Drawing tool for rectangle shape. */
    private final RectangleTool myRectangleTool;
    /** Set to filling is available or unavailable. */
    private final ChangeableFill myFill;
    
    protected RectangleAction(final DrawingPanel thePanel, 
            final RectangleTool theTool, final ChangeableFill theFill) {
        super("Rectangle", new ImageIcon("./files/rectangle_bw.gif"));
        myPanel = thePanel;
        myRectangleTool = theTool;
        putValue(Action.SELECTED_KEY, true);
        myFill = theFill;
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(myRectangleTool);  
        myFill.setText("Fill the shape");
    }

}
