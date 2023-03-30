// finish and comment me!

package gui;

import filters.EdgeDetectFilter;
import filters.EdgeHighlightFilter;
import filters.FlipHorizontalFilter;
import filters.FlipVerticalFilter;
import filters.GrayscaleFilter;
import filters.SharpenFilter;
import filters.SoftenFilter;
import image.PixelImage;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The program let user select image file to manipulate with filter buttons and open button.
 * It also let user save the image and choose another image to manipulate.
 * 
 * @author Junghyon Jo
 * @version 11/12/2022
 */
public class GUI extends JFrame {
    
    /** A generated serial version UID for object Serialization. */
    private static final long serialVersionUID = 5756891741199164658L;
    
    /** A size for the JFrame. */
    private static final Dimension FRAME_SIZE = new Dimension(400, 300);

    /** The number of rows. */
    private static final int ROW = 7;
    
    /** The number of columns. */
    private static final int COL = 1;

    /**
     * Array for left Buttons.
     */
    private static final String[] WESTBUTTON =
        {"Edge Detect",
         "Edge Highlight",
         "Flip Horizontal",
         "Flip Vertical",
         "Grayscale",
         "Sharpen",
         "Soften"};
    
    //Instance fields
    /**
     *  My buttons for manipulate image.
     */
    private JButton[] myWestButtons;
    /**
     *  My button to save image.
     */
    private JButton mySaveButton;
    /**
     *  My button to close image.
     */
    private JButton myCloseButton;
    /**
     *  My Label to display image.
     */
    private JLabel myLabel;
    /**
     *  My image file.
     */
    private PixelImage myImage;
    /**
     *  Chooser to select file.
     */
    private JFileChooser myFileChooser; 
    /**
     * current directory.
     */
    private String myLocation;
    
    public GUI() {
        super("Assignment 4");
    }
    /**
     * Method to create filter buttons.
     * @param theButton
     * @param thePanel
     */
    private void createWestButtons(final String[] theButton, final JPanel thePanel) {
        final int numButton = theButton.length;
        myWestButtons = new JButton[theButton.length];
        for (int i = 0; i < numButton; i++) {
            myWestButtons[i] = new JButton(theButton[i]);
            myWestButtons[i].setEnabled(false);
            thePanel.add(createWestButtons(myWestButtons, i));
        }
    }
    /**
     * Overloading method to create filter buttons.
     * @param theButton
     * @param theIndex
     * @return Button
     */
    private JButton createWestButtons(final JButton[] theButton, final int theIndex) {
        JButton button = new JButton();
        button = theButton[theIndex];
        final int action = theIndex;
        
        class AnActionListener implements ActionListener {

            public void actionPerformed(final ActionEvent theEvent) {
                doSomething(action);
            }
        }

        button.addActionListener(new AnActionListener());

        return button;
    }
    /**
     * Method for each filter performance.
     * @param theIndex
     */
    private void doSomething(final int theIndex) {
        final int caseNum = theIndex + 1;
        switch (caseNum) {
            case 1:  final EdgeDetectFilter edgeDetect = new EdgeDetectFilter();
                     edgeDetect.filter(myImage);
                     myLabel.setIcon(new ImageIcon(myImage));
                     break;
                 
            case 2:  final EdgeHighlightFilter edgeHighlight = new EdgeHighlightFilter();
                     edgeHighlight.filter(myImage);
                     myLabel.setIcon(new ImageIcon(myImage));
                     break;
                 
            case 3:  final FlipHorizontalFilter flipHorizontal = new FlipHorizontalFilter();
                     flipHorizontal.filter(myImage);
                     myLabel.setIcon(new ImageIcon(myImage));
                     break;
                 
            case 4:  final FlipVerticalFilter flipVertical = new FlipVerticalFilter();
                     flipVertical.filter(myImage);
                     myLabel.setIcon(new ImageIcon(myImage));
                     break;
                 
            case 5:  final GrayscaleFilter grayscale = new GrayscaleFilter();
                     grayscale.filter(myImage);
                     myLabel.setIcon(new ImageIcon(myImage));
                     break;
                 
            case 6:  final SharpenFilter sharpen = new SharpenFilter();
                     sharpen.filter(myImage);
                     myLabel.setIcon(new ImageIcon(myImage));
                     break;
                 
            case 7:  final SoftenFilter soften = new SoftenFilter();
                     soften.filter(myImage);
                     myLabel.setIcon(new ImageIcon(myImage));
                     break;
                 
            default: break;
        }
    }
    /**
     * Method to create open button.
     * @return Button
     */
    private JButton createOpenButtons() {
        
        final JButton button = new JButton("Open...");
        
        class SouthActionListener implements ActionListener {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myLocation = ".";
                myFileChooser = new JFileChooser(myLocation);
                int result = myFileChooser.showOpenDialog(null);
                while (result != JFileChooser.CANCEL_OPTION) { 
                    final String warning = "The selected file did not contain an image!";
                    try {
                        myImage = PixelImage.load(new File(myFileChooser.
                                getSelectedFile().toString()));
                        myLabel.setIcon(new ImageIcon(myImage));
                        
                        final int resizeFrameX = 110;
                        final int resizeFrameY = 70;
                        
                        setSize(myImage.getWidth() + resizeFrameX, 
                                myImage.getHeight() + resizeFrameY);
                        
                        myLabel.setHorizontalAlignment(JLabel.CENTER);
                        myLabel.setVerticalAlignment(JLabel.CENTER);
                        
                        result = JFileChooser.CANCEL_OPTION;
                        mySaveButton.setEnabled(true);
                        myCloseButton.setEnabled(true);
                        for (int i = 0; i < myWestButtons.length; i++) {
                            myWestButtons[i].setEnabled(true);
                        }
                    } catch (final IOException e) {
                        JOptionPane.showMessageDialog(null, warning, "Error!",  
                                JOptionPane.ERROR_MESSAGE);
                        result = myFileChooser.showOpenDialog(null);
                    }
                }
            }
        }
            
        
        button.addActionListener(new SouthActionListener());
        
        return button;
    }
    /**
     * Method to create save button.
     * @return Button
     */
    private JButton createSaveButtons() {
        
        final JButton button = new JButton("Save As...");
        button.setEnabled(false);
        
        class SouthActionListener implements ActionListener {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myFileChooser = new JFileChooser(myLocation);
                int result = myFileChooser.showSaveDialog(null);
                
                while (result != JFileChooser.CANCEL_OPTION) { 
                    try {
                        
                        myImage.save(new File(myFileChooser.
                                getSelectedFile().toString()));
                        result = JFileChooser.CANCEL_OPTION;
                    } catch (final IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
            
        
        button.addActionListener(new SouthActionListener());
        
        return button;
    }
    /**
     * Method to create close button.
     * @return Button
     */
    private JButton createCloseButtons() {
    
        final JButton button = new JButton("Close Image");
        button.setEnabled(false);
    
        class SouthActionListener implements ActionListener {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                
                myLabel.setIcon(null);
                
                mySaveButton.setEnabled(false);
                myCloseButton.setEnabled(false);
                for (int i = 0; i < myWestButtons.length; i++) {
                    myWestButtons[i].setEnabled(false);
                }
                
            }
        }
        
        button.addActionListener(new SouthActionListener());
    
        return button;
    }

    public void start() {
        
        setSize(FRAME_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JButton openButton;
        final JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(ROW, COL));
        final JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        myLabel = new JLabel();
        
        createWestButtons(WESTBUTTON, leftPanel);
        openButton = createOpenButtons();
        mySaveButton = createSaveButtons();
        myCloseButton = createCloseButtons();
        
        bottomPanel.add(openButton);
        bottomPanel.add(mySaveButton);
        bottomPanel.add(myCloseButton);
        
        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
        add(bottomPanel, BorderLayout.SOUTH);
        add(myLabel, BorderLayout.CENTER);
        
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}