package view;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import tools.LineTool;


public class LineAction extends AbstractAction {
    
    private static final long serialVersionUID = 1L;
    /** Panel to be drawn.*/
    private final DrawingPanel myPanel;
    /** Drawing tool for line shape. */
    private final LineTool myLineTool;
    /** Set to filling is available or unavailable. */
    private final ChangeableFill myFill;
    
    protected LineAction(final DrawingPanel thePanel, final LineTool theTool, 
            final ChangeableFill theFill) {
        super("Line", new ImageIcon("./files/line_bw.gif"));
        myPanel = thePanel;
        myLineTool = theTool;
        putValue(Action.SELECTED_KEY, true);
        myFill = theFill;
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(myLineTool);
        myFill.setText("No Fill");
    }

}
