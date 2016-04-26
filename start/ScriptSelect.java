/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

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

public class ScriptSelect {
    private JFrame frame;
    private String cat_type = "Function";
    private String cat = "Test";
    private int[] scripts = Categories.TEST_CAT;
    private static final String[] col_names = {"Script Name", "Description", ""};
    private static final String INTRO = "The scripts for this category are listed below and include script name and a brief description of its function. Select a script by clicking 'SELECT', where you can see more details and run the script.";
    private static final int TITLE_FONT_SIZE = 15;
    private static final int SUBSCRIPT_FONT_SIZE = 10;

    public ScriptSelect(String cat){
        this.cat = cat;
        System.out.println("Category is " + cat);
        this.scripts = Categories.getCategory(this.cat);
        this.createAndShowGUI();
    }

    private void addTable(Container pane, JFrame frame){

        // set up data table
        Object[][] tableData = new Object[scripts.length][3];
        // tableData[0][0] = col_names[0];
        // tableData[0][1] = col_names[1];
        // tableData[0][2] = col_names[2];
        for (int i = 0; i < scripts.length; i++){
            String [] rowData = Categories.getData(scripts[i]);
            // tableData[i] = {rowData[0], rowData[1], "Button"};
            tableData[i][0] = "  " + rowData[0];
            tableData[i][1] = "<html><div style='text-align: center;'>" + rowData[1] + "</html>";
            tableData[i][2] = "Select";
            // System.out.println(rowData[0] + "..." + rowData[1]);
        }


        DefaultTableModel tableModel = new DefaultTableModel(tableData, col_names) {

           @Override
           public boolean isCellEditable(int row, int column) {
               //Only the third column
               return (column == 2 ? true : false);
           }
        };
        // Action action = new MyAction();
        JTable scriptTable = new JTable(tableModel);
        JFrame jf = this.frame;
        Action select = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                jf.setVisible(false);
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                System.out.println("Script selected: " + table.getModel().getValueAt(modelRow, 0) + " " + modelRow);
                ScriptForm test = new ScriptForm(scripts[modelRow], table.getModel().getValueAt(modelRow, 0).toString(), jf);
                test.createAndShowGUI();
                // ((DefaultTableModel)table.getModel()).removeRow(modelRow);
            }
        };
        ButtonColumn bc = new ButtonColumn(scriptTable, select, 2);
        scriptTable.getTableHeader().setReorderingAllowed(false);
        scriptTable.getTableHeader().setResizingAllowed(false);
        scriptTable.setRowHeight(50);
        TableColumnModel c_model = scriptTable.getColumnModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        // table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        c_model.getColumn(0).setPreferredWidth(200);
        c_model.getColumn(0).setMaxWidth(300);
        c_model.getColumn(1).setCellRenderer(centerRenderer);
        // c_model.getColumn(1).setPreferredWidth(400);
        // c_model.getColumn(1).setMinWidth(300);
        c_model.getColumn(2).setPreferredWidth(100);
        c_model.getColumn(2).setMaxWidth(200);
        JScrollPane scrollP = new JScrollPane(scriptTable);
        // scrollP.setMaximumSize(new Dimension(1200, 500));
        // System.out.println(scrollP.getPreferredSize().getHeight() + "....." + scrollP.getWidth());
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

        // JLabel instruc = new JLabel("<html></html>");
        // instruc.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Border inBorder = BorderFactory.createEmptyBorder(15,20,2,20);
        // Border outBorder = BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);
        // instruc.setBorder(BorderFactory.createCompoundBorder(outBorder,inBorder));
        // pane.add(instruc);

        JLabel intro = new JLabel("<html>" + INTRO + "</html>");
        // intro.setFont(new Font(label.getFont().getFontName(), Font.BOLD, label.getFont().getSize()));
        intro.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border introBorder = BorderFactory.createEmptyBorder(10,25,15,25);
        Border introBorder2 = BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK);
        intro.setBorder(BorderFactory.createCompoundBorder(introBorder2,introBorder));
        pane.add(intro);
        System.out.println("Size: " + intro.getFont().getSize());

        addTable(pane, frame);

        // Scripts Button
        JButton button3 = new JButton("<< Back to Categories");
        // button.setAlignmentX(Component.CENTER_ALIGNMENT);
        // pane.add(button);
        button3.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) { 
            frame.dispose();
            SelectCat.run();
            // System.exit(0);
          } 
        });

        // Get Data Button
        JButton button4 = new JButton("Home");
        button4.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) { 
            frame.dispose();
            Home.createAndShowGUI();
            // System.exit(0);
          } 
        });
        // button.setAlignmentX(Component.CENTER_ALIGNMENT);
        // pane.add(button);
        // button4.setEnabled(false);  // temporarily turned off
        
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
    
    public static void main(String[] args) {
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
        
        // //Schedule a job for the event dispatch thread:
        // //creating and showing this application's GUI.
        // javax.swing.SwingUtilities.invokeLater(new Runnable() {
        //     public void run() {
        //         createAndShowGUI();
        //     }
        // });
        ScriptSelect me = new ScriptSelect("Test");
        me.createAndShowGUI();
    }

}