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
import javax.swing.table.*;
import scripts.*;
import java.io.PrintWriter;
import java.io.IOException;


public class ScriptSelect {
    private JFrame frame;
    private String cat_type = "Function";
    private String cat = "Test";
    private int[] scripts = Categories.TEST_CAT;
    private static final String[] col_names = {"Script Name", "Description", ""};
    private static final String INTRO = "The scripts for this category are listed below and include script name and a brief description of its function. Select a script by clicking 'SELECT', where you can see more details and run the script.";
    private static final int TITLE_FONT_SIZE = 15;
    private static final int SUBSCRIPT_FONT_SIZE = 10;
    private PrintWriter pw;

    public ScriptSelect(String cat, PrintWriter pw){
        this.cat = cat;
        this.pw = pw;
        System.out.println("Category is " + cat);
        this.scripts = Categories.getCategory(this.cat);
        this.createAndShowGUI();
    }

    private void print(String s){
        this.pw.println(s);
    }

    private void addTable(Container pane, JFrame frame){

        // set up data table
        Object[][] tableData = new Object[scripts.length][3];
        for (int i = 0; i < scripts.length; i++){
            String [] rowData = Categories.getData(scripts[i]);
            tableData[i][0] = "  " + rowData[0];
            tableData[i][1] = "<html><div style='text-align: center;'>" + rowData[1] + "</html>";
            tableData[i][2] = "Select";
        }


        DefaultTableModel tableModel = new DefaultTableModel(tableData, col_names) {

           @Override
           public boolean isCellEditable(int row, int column) {
               //Only the third column
               return (column == 2 ? true : false);
           }
        };

        JTable scriptTable = new JTable(tableModel);
        JFrame jf = this.frame;
        PrintWriter pw = this.pw;
        Action select = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                jf.setVisible(false);
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                System.out.println("Script selected: " + table.getModel().getValueAt(modelRow, 0) + " " + modelRow);
                // this.pw.close(); // will reopen in form.. having trouble passing
                ScriptForm test = new ScriptForm(scripts[modelRow], table.getModel().getValueAt(modelRow, 0).toString(), jf, pw);

            }
        };
        ButtonColumn bc = new ButtonColumn(scriptTable, select, 2);
        scriptTable.getTableHeader().setReorderingAllowed(false);
        scriptTable.getTableHeader().setResizingAllowed(false);
        scriptTable.setRowHeight(50);
        TableColumnModel c_model = scriptTable.getColumnModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        c_model.getColumn(0).setPreferredWidth(200);
        c_model.getColumn(0).setMaxWidth(300);
        c_model.getColumn(1).setCellRenderer(centerRenderer);
        c_model.getColumn(2).setPreferredWidth(100);
        c_model.getColumn(2).setMaxWidth(200);
        JScrollPane scrollP = new JScrollPane(scriptTable);
        Border sp_Border = BorderFactory.createEmptyBorder(20,20,2,20);
        scrollP.setBorder(BorderFactory.createCompoundBorder(scrollP.getBorder(),sp_Border));
        pane.add(scrollP);

    }
    
    public void addComponentsToPane(Container pane, JFrame frame) {

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        // // Welcome statement
        JLabel label = new JLabel("Scripts By Function Test:");
        label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, TITLE_FONT_SIZE));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border pBorder = BorderFactory.createEmptyBorder(20,0,2,0);
        label.setBorder(BorderFactory.createCompoundBorder(label.getBorder(),pBorder));
        pane.add(label);

        JLabel intro = new JLabel("<html>" + INTRO + "</html>");
        intro.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border introBorder = BorderFactory.createEmptyBorder(10,25,15,25);
        Border introBorder2 = BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK);
        intro.setBorder(BorderFactory.createCompoundBorder(introBorder2,introBorder));
        pane.add(intro);

        addTable(pane, frame);

        // Scripts Button
        JButton button3 = new JButton("<< Back to Categories");
        button3.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) { 
            frame.dispose();
            // this.print("'Back to Categories' selected. Closing Script Selection.");
            SelectCat sc = new SelectCat(pw);
            // System.exit(0);
          } 
        });

        // Get Data Button
        JButton button4 = new JButton("Home");
        button4.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) { 
            frame.dispose();
            // this.print("'Home' selected. Closing Script Selection.");
            try {
                Home hom = new Home(pw);
                // System.exit(0);
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
          } 
        });

        // script directory Button
        JButton c_dir = new JButton("Change Scripts Location");
        c_dir.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) { 
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Home.findScripts(null);
                }

               });
            t.start();
          } 
        });
        
        // Panel to hold both buttons
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPane.add(button3);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(button4);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(c_dir);
        buttonPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border buttonBorder = BorderFactory.createEmptyBorder(20,0,20,0);
        buttonPane.setBorder(BorderFactory.createCompoundBorder(buttonPane.getBorder(),buttonBorder));
        buttonPane.setMinimumSize(new Dimension(1200, 200));
        pane.add(buttonPane);

    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private void createAndShowGUI() {
        
        //Create and set up the window.
        this.frame = new JFrame("Script Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,700);

        //Set up the content pane.
        Container pane = frame.getContentPane();
        // BorderLayout bl = pane.getLayout();
        // bl.setHgap(2);
        // bl.getVgap(1);
        addComponentsToPane(pane, frame);
        //Use the content pane's default BorderLayout. No need for
        // setLayout(new BorderLayout());
        //Display the window.
        // frame.pack();
        frame.setVisible(true);
    }
    
    // public static void main(String[] args) {
    //     /* Use an appropriate Look and Feel */
    //     try {
    //         //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    //         UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    //     } catch (UnsupportedLookAndFeelException ex) {
    //         ex.printStackTrace();
    //     } catch (IllegalAccessException ex) {
    //         ex.printStackTrace();
    //     } catch (InstantiationException ex) {
    //         ex.printStackTrace();
    //     } catch (ClassNotFoundException ex) {
    //         ex.printStackTrace();
    //     }
    //     /* Turn off metal's use bold fonts */
    //     UIManager.put("swing.boldMetal", Boolean.FALSE);
        
    //     // //Schedule a job for the event dispatch thread:
    //     // //creating and showing this application's GUI.
    //     // javax.swing.SwingUtilities.invokeLater(new Runnable() {
    //     //     public void run() {
    //     //         createAndShowGUI();
    //     //     }
    //     // });
    //     ScriptSelect me = new ScriptSelect("Test");
    //     me.createAndShowGUI();
    // }

}