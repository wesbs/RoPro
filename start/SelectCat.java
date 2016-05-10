
package start;

/*
 * BorderLayoutDemo.java
 *
 */
import java.awt.Component;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.border.*;
import scripts.*;
import java.io.PrintWriter;


public class SelectCat {
    JFrame frame;
    // public static boolean RIGHT_TO_LEFT = false;
    private static final String INTRO = "Please select a category for the type of script you would like to run. You then will be able to select the exact script. If you are unsure of what category the desired script might be in, please select 'ALL SCRIPTS'. Workflow scripts execute multiple scripts in one command.";
    private static final int TITLE_FONT_SIZE = 15;
    private static final int SUBSCRIPT_FONT_SIZE = 10;
    private static final int BUTTON_FONT_SIZE = 14;
    private PrintWriter pw;

    public SelectCat(PrintWriter pw){
        this.pw = pw;
        this.pw.println("Select Category Screen Opening");
        this.run();
    }

    private void print(String s){
        this.pw.println(s);
    }
    
    public void addComponentsToPane(Container pane, JFrame frame) {

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        // scripts descriptions
        JLabel intro = new JLabel("<html>" + INTRO + "</html>");
        intro.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border introBorder = BorderFactory.createEmptyBorder(10,20,15,20);
        Border introBorder2 = BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK);
        intro.setBorder(BorderFactory.createCompoundBorder(introBorder2,introBorder));
        pane.add(intro);

        // line under intro

        // file intput category description
        JPanel panel1 = new JPanel(); 
        panel1.setMaximumSize(new Dimension(795,50));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel fileinD = new JLabel("<html><u>Scripts By Input File Type:</u></html>");
        fileinD.setFont(new Font(fileinD.getFont().getFontName(), Font.BOLD, TITLE_FONT_SIZE));
        panel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border fileinDborder = BorderFactory.createEmptyBorder(10,20,0,0);
        fileinD.setBorder(BorderFactory.createCompoundBorder(fileinD.getBorder(),fileinDborder));
        panel1.add(fileinD);
        JLabel sidenote1 = new JLabel("(If the file type you are looking for isn't listed, select 'OTHER')");
        sidenote1.setFont(new Font(sidenote1.getFont().getFontName(), Font.PLAIN, SUBSCRIPT_FONT_SIZE));
        Border sidenote1Border = BorderFactory.createEmptyBorder(13,10,0,0);
        sidenote1.setBorder(BorderFactory.createCompoundBorder(sidenote1.getBorder(),sidenote1Border));
        panel1.add(sidenote1);
        pane.add(panel1);

        // file input category buttons
        JPanel buttonpanel = new JPanel(); 
        buttonpanel.setMaximumSize(new Dimension(790, 100));
        buttonpanel.setLayout(new GridLayout(3,3));
        Border panelBorder = BorderFactory.createEmptyBorder(10,10,15,10);
        Border panelBorder2 = BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);
        buttonpanel.setBorder(BorderFactory.createCompoundBorder(panelBorder2,panelBorder));
        JButton catButton;
        for (int i = 0; i < Categories.INPUT_CAT_NAMES.length; i++){
            catButton = new JButton(Categories.INPUT_CAT_NAMES[i]);
            final String cat = Categories.INPUT_CAT_NAMES[i];
            catButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                // this.print("Category Selected: Input " + cat);
                // this.print("Opening Script Select Form. Closing Category Screen");
                ScriptSelect scriptS = new ScriptSelect("Input " + cat, pw);
                // scriptS.createAndShowGUI();
                // System.exit(0);
              } 
            });
            buttonpanel.add(catButton);
        }
        pane.add(buttonpanel);

        // file output category description
        JPanel panel2 = new JPanel(); 
        panel2.setMaximumSize(new Dimension(795,50));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel fileoutD = new JLabel("<html><u>Scripts By Output File Type:</u></html>");
        fileoutD.setFont(new Font(fileoutD.getFont().getFontName(), Font.BOLD, TITLE_FONT_SIZE));
        panel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border fileoutDborder = BorderFactory.createEmptyBorder(10,20,0,0);
        fileoutD.setBorder(BorderFactory.createCompoundBorder(fileoutD.getBorder(),fileoutDborder));
        panel2.add(fileoutD);
        JLabel sidenote2 = new JLabel("(If the file type you are looking for isn't listed, select 'OTHER')");
        sidenote2.setFont(new Font(sidenote2.getFont().getFontName(), Font.PLAIN, SUBSCRIPT_FONT_SIZE));
        Border sidenote2Border = BorderFactory.createEmptyBorder(13,10,0,0);
        sidenote2.setBorder(BorderFactory.createCompoundBorder(sidenote2.getBorder(),sidenote2Border));
        panel2.add(sidenote2);
        pane.add(panel2);

        // file output category buttons
        buttonpanel = new JPanel(); 
        buttonpanel.setMaximumSize(new Dimension(790, 100));
        buttonpanel.setLayout(new GridLayout(3,3));
        panelBorder = BorderFactory.createEmptyBorder(10,10,15,10);
        panelBorder2 = BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);
        buttonpanel.setBorder(BorderFactory.createCompoundBorder(panelBorder2,panelBorder));
        for (int i = 0; i < Categories.OUTPUT_CAT_NAMES.length; i++){
            catButton = new JButton(Categories.OUTPUT_CAT_NAMES[i]);
            final String cat = Categories.OUTPUT_CAT_NAMES[i];
            catButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                // this.print("Category Selected: Output " + cat);
                // this.print("Opening Script Select Form. Closing Category Screen");

                ScriptSelect scriptS = new ScriptSelect("Output " + cat, pw);
                // scriptS.createAndShowGUI();
                // System.exit(0);
              } 
            });
            buttonpanel.add(catButton);
        }
        pane.add(buttonpanel);


        // file function category description
        JPanel panel3 = new JPanel(); 
        panel3.setMaximumSize(new Dimension(795,50));
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel filefuncD = new JLabel("<html><u>Scripts By Function:</u></html>");
        filefuncD.setFont(new Font(filefuncD.getFont().getFontName(), Font.BOLD, TITLE_FONT_SIZE));
        panel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border filefuncDborder = BorderFactory.createEmptyBorder(10,20,0,0);
        filefuncD.setBorder(BorderFactory.createCompoundBorder(filefuncD.getBorder(),filefuncDborder));
        panel3.add(filefuncD);
        JLabel sidenote3 = new JLabel("(If the function you are looking for isn't listed, select 'OTHER')");
        sidenote3.setFont(new Font(sidenote3.getFont().getFontName(), Font.PLAIN, SUBSCRIPT_FONT_SIZE));
        Border sidenote3Border = BorderFactory.createEmptyBorder(13,10,0,0);
        sidenote3.setBorder(BorderFactory.createCompoundBorder(sidenote3.getBorder(),sidenote3Border));
        panel3.add(sidenote3);
        pane.add(panel3);

        // file function category buttons
        buttonpanel = new JPanel(); 
        buttonpanel.setMaximumSize(new Dimension(790, 100));
        buttonpanel.setLayout(new GridLayout(3,3));
        panelBorder = BorderFactory.createEmptyBorder(10,10,15,10);
        panelBorder2 = BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);
        buttonpanel.setBorder(BorderFactory.createCompoundBorder(panelBorder2,panelBorder));
        for (int i = 0; i < Categories.FUNC_CAT_NAMES.length; i++){
            catButton = new JButton(Categories.FUNC_CAT_NAMES[i]);
            final String cat = Categories.FUNC_CAT_NAMES[i];
            catButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                // this.print("Category Selected: Function " + cat);
                // this.print("Opening Script Select Form. Closing Category Screen");

                ScriptSelect scriptS = new ScriptSelect("Func " + cat, pw);
                // scriptS.createAndShowGUI();
                // System.exit(0);
              } 
            });
            buttonpanel.add(catButton);
        }
        pane.add(buttonpanel);

        // All scripts and workflow buttons
        JButton as_button = new JButton("ALL SCRIPTS");
        as_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                // this.print("Category Selected: All Scripts");
                // this.print("Opening Script Select Form. Closing Category Screen");

                ScriptSelect scriptS = new ScriptSelect("All Scripts", pw);
            }
        });
        as_button.setPreferredSize(new Dimension(200, 40));
        as_button.setFont(new Font(as_button.getFont().getFontName(), Font.BOLD, BUTTON_FONT_SIZE));
        JButton wf_button = new JButton("Workflow Scripts");
        wf_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                // this.print("Category Selected: Workflow");
                // this.print("Opening Script Select Form. Closing Category Screen");

                ScriptSelect scriptS = new ScriptSelect("Workflow", pw);
            }
        });
        wf_button.setPreferredSize(new Dimension(200, 40));
        wf_button.setFont(new Font(wf_button.getFont().getFontName(), Font.BOLD, BUTTON_FONT_SIZE));
        JPanel buttonPane = new JPanel();
        buttonPane.setMinimumSize(new Dimension(300, 100));
        buttonPane.setLayout(new FlowLayout());
        buttonPane.add(as_button);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(wf_button);
        buttonPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border buttonBorder = BorderFactory.createEmptyBorder(20,0,20,0);
        buttonPane.setBorder(BorderFactory.createCompoundBorder(buttonPane.getBorder(),buttonBorder));
        pane.add(buttonPane);

    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private void createAndShowGUI() {
        
        //Create and set up the window.
        JFrame frame = new JFrame("Script Categories");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);

        //Set up the content pane.
        Container pane = frame.getContentPane();
        addComponentsToPane(pane, frame);
        frame.setVisible(true);
    }
    
    public void run() {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}