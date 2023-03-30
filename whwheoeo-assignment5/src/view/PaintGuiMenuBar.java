package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class PaintGuiMenuBar extends JMenuBar implements PropertyChangeListener {
    /** Maximum number of slider, which user can increase for thickness. */
    private static final int MAX_NUMBER = 15;
    /** Minimum number of slider, which user can decrease for thickness. */
    private static final int MIN_NUMBER = 0;
    /** Initial number of slider. */
    private static final int BASE_NUMBER = 3;
    /** Large scale for the slider. */
    private static final int MAJOR_THICKNESS = 5;
    /** Small scale for the slider. */
    private static final int MIONR_THICKNESS = 1;
    /** Initial color for colorChooser. */
    private static final Color UW_PURPLE = new Color(51, 0, 111);
    /** Initial color for colorChooser. */
    private static final Color UW_GOLD = new Color(232, 211, 162);
    
    private static final long serialVersionUID = -4080874021962785907L;
    /** Menu to contain options, thickness, color and clear. */
    private final JMenu myOption;
    /** Drawing tools, line, ellipse, and rectangle. */
    private final JMenu myTools;
    /** Menu to contain option, About... */
    private final JMenu myHelp;
    /** Menu to contain slider for thickness. */
    private final JMenu myThickness;
    /** Collect buttons, line, ellipse, and rectangle. */
    private final ButtonGroup myMenuBarGroup;
    /** Slider for thickness. */
    private JSlider mySlider;
    /** Option to clean the drawing panel. */
    private JMenuItem myClear;
    /** Space for that shapes will be drawn. */
    private final DrawingPanel myPanel;
    /** Option to check color for filling shape. */
    private JCheckBoxMenuItem myFill;
    
    public PaintGuiMenuBar(final DrawingPanel thePanel) {
        super();
        myPanel = thePanel;
        myOption = new JMenu("Options"); 
        myTools = new JMenu("Tools"); 
        myHelp = new JMenu("Help");
        myThickness = new JMenu("Thickness");
        myMenuBarGroup = new ButtonGroup();
        setup();
    }
    
    private void setup() {
        final JMenuItem color = new JMenuItem("Color...");
        final String colorChooserName = "Select the color";
      
        createClear();
        createFill();
        
        color.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                Color result = null;

                do {    
                    result = JColorChooser.showDialog(null, colorChooserName, UW_PURPLE);
                    myPanel.setColor(result);
                    result = null;
                } while (result != null);
                
            }
            
        });
        
        final JMenuItem fillColor = new JMenuItem("Fill Color...");
        
        fillColor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                Color result = null;

                do {    
                    result = JColorChooser.showDialog(null, colorChooserName, UW_GOLD);
                    myPanel.setFillColor(result);
                    result = null;
                } while (result != null);
                
            }
            
        });
        
        final JMenuItem about = new JMenuItem("About...");
        
        about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final String info = "Junghyon Jo"
                        + "\n" + "Autumn 2022";
                
                JOptionPane.showMessageDialog(null, info, "TCSS 305 Paint",  
                        JOptionPane.DEFAULT_OPTION, new ImageIcon("files/w_small.png"));
                
            }
            
        });
        
        myHelp.add(about);
        
        createSlider();
        
        myThickness.add(mySlider);
        myOption.add(myThickness);
        myOption.add(new JSeparator());
        myOption.add(color);
        myOption.add(new JSeparator());
        myOption.add(fillColor);
        myOption.add(new JSeparator());
        myOption.add(myFill);
        myOption.add(new JSeparator());
        myOption.add(myClear);
        
        add(myOption);
        add(myTools);
        add(myHelp);
    }
    
    private void createFill() {
        myFill = new JCheckBoxMenuItem("Fill");
        myFill.setEnabled(false);
        myFill.setSelected(false);
        
        myFill.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                if (myFill.getState()) {
                    myPanel.setFillOperator(true);
                } else {
                    myPanel.setFillOperator(false);
                }
            }
            
        });
        
    }
    
    private void createClear() {
        myClear = new JMenuItem("Clear");
        myClear.setEnabled(false);
        myClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.getChangeableText().setText("Initial Panel");
                myPanel.getPreviousShape().clear();
                myPanel.setOperator(false);
                myPanel.repaint();
            }
                
        });
    }
    
    private void createSlider() {
        
        mySlider = new JSlider(SwingConstants.HORIZONTAL, MIN_NUMBER, MAX_NUMBER, BASE_NUMBER);
        mySlider.setMajorTickSpacing(MAJOR_THICKNESS);
        mySlider.setMinorTickSpacing(MIONR_THICKNESS);
        mySlider.setPaintLabels(true);
        mySlider.setPaintTicks(true);
        
        mySlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                
                final int value = mySlider.getValue();
                myPanel.setThickness(value);
               
            }
            
        });
    }
    
    public void createMenuButton(final Action theAction) {
        final JRadioButtonMenuItem createdButton = new JRadioButtonMenuItem(theAction);
        myMenuBarGroup.add(createdButton);
        myTools.add(createdButton);
    }
    
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("Not Clear".equals(theEvent.getPropertyName())) {
            myClear.setEnabled(true);
        } else if ("Fill the shape".equals(theEvent.getPropertyName())) {
            myFill.setEnabled(true);
        } else if ("No Fill".equals(theEvent.getPropertyName())) {
            myFill.setEnabled(false);
        } else if ("Empty Panel".equals(theEvent.getPropertyName())) {
            myClear.setEnabled(false);
        }
    }
}