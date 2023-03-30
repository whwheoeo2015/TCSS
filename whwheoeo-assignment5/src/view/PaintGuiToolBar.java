package view;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class PaintGuiToolBar extends JToolBar {

    private static final long serialVersionUID = -3923229997470692445L;
    
    /** Button group to add tool features, line, ellipse, and rectangle. */
    private final ButtonGroup myGroup;
    
    public PaintGuiToolBar() {
        super();
        myGroup = new ButtonGroup();
    }
    
    public void createToolBarButton(final Action theAction) {
        final JToggleButton toggleButton = new JToggleButton(theAction);
        myGroup.add(toggleButton);
        add(toggleButton);
    }
}
