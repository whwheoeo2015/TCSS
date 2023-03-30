package view;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import tools.EllipseTool;

public class EllipseAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    /** Panel to be drawn.*/
    private final DrawingPanel myPanel;
    /** Drawing tool for ellipse shape. */
    private final EllipseTool myEllipseTool;
    /** Set to filling is available or unavailable. */
    private final ChangeableFill myFill;
    
    protected EllipseAction(final DrawingPanel thePanel, 
            final EllipseTool theTool, final ChangeableFill theFill) {
        super("Ellipse", new ImageIcon("./files/ellipse_bw.gif"));
        myPanel = thePanel;
        myEllipseTool = theTool;
        putValue(Action.SELECTED_KEY, true);
        myFill = theFill;
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(myEllipseTool);
        myFill.setText("Fill the shape");
    }

}
