package start;

/*
    This class opens the home screen for the EmQiime Application
    It can navigate from the home screen to the catagory screen or get data path
*/


import java.awt.Component;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.border.*;
import java.awt.Cursor;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
import scripts.Script;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;



public class Home {
    // path where the qiime loga is found
    private static final String QIIME_LOGO = "qiime_logo_large.png";
    private static final String QIIME_LINK = "http://qiime.org/index.html";
    private static final int IMAGE_MAX_SIZE = 11000;
    private PrintWriter pw;
    private JFrame frame;

    public Home(PrintWriter pw) throws IOException{
        this.pw = pw;
        this.pw.println("Opening Home Screen");
        if (Script.SCRIPTS_PATH == null){
            JOptionPane.showMessageDialog(this.frame, "Need to Select Directory containing Qiime Scripts.\nPress okay to select directory.");
            findScripts(null);
        }
        this.frame = new JFrame("Home");
        this.createAndShowGUI();
    }

    protected void print(String s){
        this.pw.println(s);
    }

    // opens the webiste in the brower
    private void openQiimePage() {
        if (Desktop.isDesktopSupported()) {
          try {
            Desktop.getDesktop().browse(new URI(QIIME_LINK));
          } catch (IOException e) { 
            e.printStackTrace();
          } catch (URISyntaxException e){
            e.printStackTrace();
          }
        } else { 
            this.print("Desktop is not supported");
         }
    }

    protected static void findScripts(Component f) {
        final JFileChooser fc = new JFileChooser();        
        try{

            EventQueue.invokeAndWait(new Runnable() {
                int fin;
                @Override
                public void run() {
                    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                    int f_select = fc.showOpenDialog(null);
                    if (f_select == JFileChooser.APPROVE_OPTION){
                        // file selected
                        File sel = fc.getSelectedFile();
                        System.out.println("Got Directory: " + sel.getAbsolutePath());
                        Script.setScriptPath(sel.getAbsolutePath() + "/");
                        System.out.println("Set Path: " + Script.SCRIPTS_PATH);
                    }
                    else {
                        // no file selected
                        if (Script.SCRIPTS_PATH == null){
                            // need a directory
                            JOptionPane.showMessageDialog(f, "Cannot run Qiime without scripts.\nExiting.");
                            System.exit(0);
                        }
                    }
                }
            });
        }
        catch (InterruptedException|InvocationTargetException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }

        // if (f_select == JFileChooser.APPROVE_OPTION){
        //     // file selected
        //     File sel = fc.getSelectedFile();
        //     System.out.println("Got Directory: " + sel.getAbsolutePath());
        //     Script.setScriptPath(sel.getAbsolutePath() + "/");
        //     System.out.println("Set Path: " + Script.SCRIPTS_PATH);
        // }
        // else {
        //     // no file selected
        //     if (Script.SCRIPTS_PATH == null){
        //         // need a directory
        //         JOptionPane.showMessageDialog(f, "Cannot run Qiime without scripts.\nExiting.");
        //         System.exit(0);
        //     }
        // }


        
    }
    
    /*
        This functions adds all the elements to the Home screen
    */
    public void addComponentsToPane(Container pane, JFrame frame) throws IOException{

        // Box Layout
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        // Qiime logo
        JPanel panel = new JPanel(); 
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        Border logoBorder = BorderFactory.createEmptyBorder(80,0,20,0);
        panel.setBorder(BorderFactory.createCompoundBorder(panel.getBorder(),logoBorder));
        System.out.println("About to add icon");

        // byte[] buffer = new byte[IMAGE_MAX_SIZE];
        // InputStream imageStream = getClass().getClassLoader().getResourceAsStream(QIIME_LOGO);
        // imageStream.read(buffer, 0, IMAGE_MAX_SIZE);

        ImageIcon icon = new ImageIcon(getClass().getResource(QIIME_LOGO)); 
        JLabel logo = new JLabel(); 
        logo.setIcon(icon); 
        panel.add(logo);
        pane.add(panel);
        System.out.println("added.....");

        // Welcome statement
        JLabel label = new JLabel("Welcome to EmQiime!");
        label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, label.getFont().getSize()));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border pBorder = BorderFactory.createEmptyBorder(20,0,2,0);
        label.setBorder(BorderFactory.createCompoundBorder(label.getBorder(),pBorder));
        pane.add(label);

        // Brief Application description
        JLabel label2 = new JLabel("An easy-to-use interface for Qiime command line scripts");
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border pBorder2 = BorderFactory.createEmptyBorder(2,0,20,0);
        label2.setBorder(BorderFactory.createCompoundBorder(label2.getBorder(),pBorder2));
        pane.add(label2);
        
        // Qiime description from Website
        JLabel descrip = new JLabel("<html>" + 
            "QIIME is an open-source bioinformatics pipeline for performing microbiome analysis from raw DNA sequencing data. QIIME is designed to take users from raw sequencing data generated on the Illumina or other platforms through publication quality graphics and statistics. This includes demultiplexing and quality filtering, OTU picking, taxonomic assignment, and phylogenetic reconstruction, and diversity analyses and visualizations. QIIME has been applied to studies based on billions of sequences from tens of thousands of samples."
            + "</html>");
        descrip.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border paddingBorder = BorderFactory.createEmptyBorder(0,60,10,60);
        descrip.setBorder(BorderFactory.createCompoundBorder(descrip.getBorder(),paddingBorder));
        pane.add(descrip);

        // Qiime Link
        JLabel link = new JLabel("Qiime Website");
        link.setCursor(new Cursor(Cursor.HAND_CURSOR));
        link.setAlignmentX(Component.CENTER_ALIGNMENT);
        link.setForeground(Color.BLUE);
        link.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                // System.out.println("Link Clicked");
                openQiimePage();
            }
        });
        pBorder = BorderFactory.createEmptyBorder(5,0,5,0);
        link.setBorder(BorderFactory.createCompoundBorder(link.getBorder(),pBorder));
        pane.add(link);

        // Script instruction
        JLabel instruc = new JLabel("Select 'Run Scripts' to view and run Qiime scripts");
        instruc.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border inB = BorderFactory.createEmptyBorder(10,0,2,0);
        instruc.setBorder(BorderFactory.createCompoundBorder(instruc.getBorder(),inB));
        pane.add(instruc);

        // Get Data instruction
        JLabel instruc2 = new JLabel("Select 'Get Data' to view and fetch data from the Human Microbiome Project");
        instruc2.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border inB2 = BorderFactory.createEmptyBorder(10,0,2,0);
        instruc2.setBorder(BorderFactory.createCompoundBorder(instruc2.getBorder(),inB2));
        pane.add(instruc2);

        // Scripts Button
        JButton button3 = new JButton("Go To Scripts");

        button3.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) { 
            // this.print("'Go To Scripts' selected. Opening Scripts. Closing Home Screen.");
            frame.dispose();
            SelectCat sc = new SelectCat(pw);
            // System.exit(0);
          } 
        });

        // Get Data Button
        JButton button4 = new JButton("Get Data");

        button4.setEnabled(false);  // temporarily turned off
        
        // Panel to hold both buttons
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPane.add(button3);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(button4);
        buttonPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border buttonBorder = BorderFactory.createEmptyBorder(20,0,20,0);
        buttonPane.setBorder(BorderFactory.createCompoundBorder(buttonPane.getBorder(),buttonBorder));
        pane.add(buttonPane);

    }
    
    /*
        This function creates the window for the home screen and displays it
        It then calls addComponentsToPane() to add elements
    */
    protected void createAndShowGUI() throws IOException{
        
        //Create and set up the window.
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(600,700);

        Container pane = this.frame.getContentPane();

        addComponentsToPane(pane, this.frame);

        this.frame.setVisible(true);
    }
    
    // public static void main(String[] args) {
    //     try {
    //         /* Use an appropriate Look and Feel */
    //         try {
    //             //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    //             UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    //         } catch (UnsupportedLookAndFeelException ex) {
    //             ex.printStackTrace();
    //         } catch (IllegalAccessException ex) {
    //             ex.printStackTrace();
    //         } catch (InstantiationException ex) {
    //             ex.printStackTrace();
    //         } catch (ClassNotFoundException ex) {
    //             ex.printStackTrace();
    //         }
    //         /* Turn off metal's use bold fonts */
    //         UIManager.put("swing.boldMetal", Boolean.FALSE);
            
    //         //Schedule a job for the event dispatch thread:
    //         //creating and showing this application's GUI.
    //         javax.swing.SwingUtilities.invokeLater(new Runnable() {
    //             public void run() {
    //                 createAndShowGUI();
    //             }
    //         });
    //     }
    //     catch (Exception e){
    //         System.out.println("Error happened..... Exiting.");
    //         System.exit(0);
    //     }
    // }
}