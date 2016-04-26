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
import java.awt.Cursor;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Desktop;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.JOptionPane;
import scripts.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ScriptForm implements ActionListener{
    // private String cat_type = "Function";
    private Container prnt;
    private JFrame prev_screen;
    private JFrame frame;
    private Script script;
    private String title;
    private List<Object> r_op_buttons;
    private List<Object> e_op_buttons;
    private JLabel outPath;
    private int[] scripts = Categories.TEST_CAT;
    private static final String[] col_names = {"Script Name", "Description", ""};
    private static final String INTRO = "The scripts for this category are listed below and include script name and a brief description of its function. Select a scripts by clicking 'SELECT', where you can see more details and run the script.";
    private static final String HELP_ICON_PATH = "./pictures/help_icon.png";
    private static final int TITLE_FONT_SIZE = 15;
    private static final int SUBSCRIPT_FONT_SIZE = 10;

    public ScriptForm(int scriptNum, String title, JFrame prev_screen){
        this.script = Categories.getScript(scriptNum);
        this.title = title;
        this.outPath = new JLabel("");
        this.prev_screen = prev_screen;
    }

    // opens the webiste in the brower
    private void openScriptPage() {
        if (Desktop.isDesktopSupported()) {
          try {
            Desktop.getDesktop().browse(new URI(this.script.getLink()));
          } catch (IOException e) { 
            e.printStackTrace();
          } catch (URISyntaxException e){
            e.printStackTrace();
          }
        } else { 
            System.out.println("Desktop is not supported");
         }
      }

    private String getFormOptions(){
        List<Option> r_ops = this.script.getReqOptions();
        List<Option> e_ops = this.script.getExtraOptions();

        for (int i = 0; i < r_ops.size(); i++){
            if (r_ops.get(i).getFlag().equals("-o"))
                continue;
            else{
                System.out.println("Option: " + r_ops.get(i).getFlag());
                switch (r_ops.get(i).getType()){
                    case Option.SELECT:
                        // will be a button group in list
                        ButtonGroup selects = (ButtonGroup)this.r_op_buttons.get(i);
                        if (!r_ops.get(i).setSelected(selects.getSelection().getActionCommand()))
                            System.out.println("Error getting selected radio button ... " + selects.getSelection().getActionCommand());
                        else
                            System.out.println("Set selected: " + r_ops.get(i).getSelected());
                        break;
                    case Option.NUM:
                        // will be input field in list
                        JTextField n_in = (JTextField)this.r_op_buttons.get(i);
                        if (!n_in.getText().equals("")){
                            try {
                                Float val = Float.parseFloat(n_in.getText());
                                r_ops.get(i).setValue(val);
                                System.out.println("Input value: " + val);
                            } catch (NumberFormatException e) {
                                System.out.println("Not a number entered");
                                String err = "<html><div style='text-align: center;'>" + n_in.getText() + " is not a valid entry for option '" + r_ops.get(i).getLabel() + "'.<br><br>Please enter a number.</html>";
                                JOptionPane.showMessageDialog(this.frame, err);
                                return "";
                            }
                        }
                        // change to float?
                        break;
                    case Option.PATH:
                        // taken care of when a file or directory is selected
                        break;
                    case Option.NOARG:
                        // will be button group
                        JRadioButtonMenuItem fls = (JRadioButtonMenuItem)this.r_op_buttons.get(i);
                        if (!fls.isSelected())
                            r_ops.get(i).turnOff();
                        else
                            r_ops.get(i).turnOn();
                        break;
                    case Option.LIST:
                        break;
                    case Option.INPUT:
                        // will be input field
                        System.out.println("---> " + r_ops.size() + " " + this.r_op_buttons.size());
                        JTextField input = (JTextField)this.r_op_buttons.get(i);
                        String str = input.getText();
                        r_ops.get(i).setInput(str);
                        System.out.println("Input value: " + r_ops.get(i).getInput());
                        break;
                }
            }
        }

        for (int i = 0; i < e_ops.size(); i++){
            if (e_ops.get(i).getFlag().equals("-o"))
                continue;
            else{
                System.out.println("Option: " + e_ops.get(i).getFlag());
                switch (e_ops.get(i).getType()){
                    case Option.SELECT:
                        // will be a button group in list
                        ButtonGroup selects = (ButtonGroup)this.e_op_buttons.get(i);
                        if (!e_ops.get(i).setSelected(selects.getSelection().getActionCommand()))
                            System.out.println("Error getting selected radio button ... " + selects.getSelection().getActionCommand());
                        else
                            System.out.println("Set selected: " + e_ops.get(i).getSelected());
                        break;
                    case Option.NUM:
                        // will be input field in list
                        JTextField n_in = (JTextField)this.e_op_buttons.get(i);
                        if (!n_in.getText().equals("")){
                            try {
                                Float val = Float.parseFloat(n_in.getText());
                                e_ops.get(i).setValue(val);
                                System.out.println("Input value: " + val);
                            } catch (NumberFormatException e) {
                                System.out.println("Not a number entered");
                                String err = "<html><div style='text-align: center;'>" + n_in.getText() + " is not a valid entry for option '" + e_ops.get(i).getLabel() + "'.<br><br>Please enter a number.</html>";
                                JOptionPane.showMessageDialog(this.frame, err);
                                return "";
                            }
                        }
                        // change to float?
                        break;
                    case Option.PATH:
                        // taken care of when a file or directory is selected
                        break;
                    case Option.NOARG:
                        // will be button group
                        JRadioButtonMenuItem fls = (JRadioButtonMenuItem)this.e_op_buttons.get(i);
                        if (!fls.isSelected())
                            System.out.println("False");
                        else
                            System.out.println("True");
                        break;
                    case Option.LIST:
                        break;
                    case Option.INPUT:
                        // will be input field
                        System.out.println("---> " + e_ops.size() + " " + this.e_op_buttons.size());
                        JTextField input = (JTextField)this.e_op_buttons.get(i);
                        String str = input.getText();
                        e_ops.get(i).setInput(str);
                        System.out.println("Input value: " + e_ops.get(i).getInput());
                        break;
                }
            }
        }
        return null;
    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    private void showFullDescription(){
        // JFrame descripFrame = new JFrame("Script Description");
        // descripFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Container pane = descripFrame.getContentPane();
        // // pane.setPreferredSize(new Dimension(400,400));
        // pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        // JLabel desc = new JLabel("<html><div style='text-align: center;'>" + this.script.getLongDesc() + "</html>");
        // Border border = BorderFactory.createEmptyBorder(20,20,20,20);
        // desc.setBorder(BorderFactory.createCompoundBorder(desc.getBorder(),border));
        // pane.add(desc, BorderLayout.CENTER);
        // // JButton close = new JButton("Close");
        // // close.addActionListener(new ActionEvent(){
        // //     public void actionPerformed(ActionEvent e){
        // //         this.frame.dispose();
        // //     }
        // // });
        // descripFrame.pack();
        // descripFrame.setVisible(true);
        String fulldes = "<html><div style='text-align: center;'>" + this.script.getLongDesc() + "</html>";
        JOptionPane.showMessageDialog(this.frame, fulldes);
    }


    private void createFormOption(Container pane, Option op, Boolean req, int index){
        JPanel optionPane = new JPanel();
        optionPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        optionPane.setPreferredSize(new Dimension(900,40));
        // optionPane.setMaximumSize(new Dimension(900,40));
        // Border opBorder = BorderFactory.createEmptyBorder(2,20,2,20);
        // Border opBorder2 = BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK);
        // optionPane.setBorder(BorderFactory.createCompoundBorder(opBorder2,opBorder));
        
        //Option Description
        ImageIcon help = new ImageIcon(HELP_ICON_PATH);
        JLabel details = new JLabel(new ImageIcon(getScaledImage(help.getImage(), 20, 20)));
        details.setToolTipText("<html>" + op.getDescription() + "</html>");
        optionPane.add(details);

        //Option title
        JLabel title = new JLabel(op.getLabel() + (op.getLabel().charAt(op.getLabel().length()-1) == '?' ? "" : ":"));
        Border tBorder = BorderFactory.createEmptyBorder(3,0,3,0);
        title.setBorder(BorderFactory.createCompoundBorder(title.getBorder(),tBorder));
        optionPane.add(title);



        switch (op.getType()){
            case Option.SELECT:
                JRadioButtonMenuItem select;
                ButtonGroup selects = new ButtonGroup();
                for (int i = 0; i < op.getSelections().size(); i++){
                    if (op.getSelectedIndex() == i)
                        select = new JRadioButtonMenuItem(op.getSelections().get(i), true);
                    else
                        select = new JRadioButtonMenuItem(op.getSelections().get(i));
                    select.setActionCommand(op.getSelections().get(i));
                    selects.add(select);
                    optionPane.add(select);
                }
                if (req)
                    this.r_op_buttons.add(selects);
                else
                    this.e_op_buttons.add(selects);
                break;
            case Option.NUM:
                JTextField numinput = new JTextField(30);
                optionPane.add(numinput);
                if (req)
                    this.r_op_buttons.add(numinput);
                else
                    this.e_op_buttons.add(numinput);
                break;
            case Option.PATH:
                // System.out.println(op.getLabel() + "  " + op.getSelectedIndex());
                JButton fileButton;
                JLabel selected = new JLabel("");
                // JFileChooser fc;
                if (op.getNumFiles() > 1){
                    for (int i = 0; i < op.getNumFiles(); i++){
                        fileButton = new JButton("Select Path");
                        fileButton.setActionCommand(op.getFlag().equals("-o") ? "out" : (req ? "R" : "E") + "-" + index + "-" + i);
                        fileButton.addActionListener(this);
                        optionPane.add(fileButton); 
                    }
                }
                else if (op.getNumFiles() == 0) {
                    // when a variable number of files


                }
                else {
                    fileButton = new JButton("Select Path");
                    fileButton.setActionCommand((op.getFlag().equals("-o") ? "out" : (req ? "R" : "E") + "-" + index));
                    fileButton.addActionListener(this);
                    optionPane.add(fileButton);
                }
                if (!op.getFlag().equals("-o")){
                    if (req)
                        this.r_op_buttons.add(selected);
                    else
                        this.e_op_buttons.add(selected);
                    optionPane.add(selected);
                }
                else{
                    optionPane.add(outPath);
                }
                break;
            case Option.NOARG:
                ButtonGroup tf = new ButtonGroup();
                JRadioButtonMenuItem select2;
                select2 = new JRadioButtonMenuItem("True");
                tf.add(select2);
                optionPane.add(select2);
                select2 = new JRadioButtonMenuItem("False", true);
                tf.add(select2);
                optionPane.add(select2);
                if (req)
                    this.r_op_buttons.add(select2);
                else
                    this.e_op_buttons.add(select2);
                break;
            case Option.LIST:
                break;
            case Option.INPUT:
                JTextField input = new JTextField(30);
                optionPane.add(input);
                if (req)
                    this.r_op_buttons.add(input);
                else
                    this.e_op_buttons.add(input);
                break;
        }
        pane.add(optionPane);
    }
    
    public void addComponentsToPane(Container pane, JFrame frame) {

        // Box Layout
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        System.out.println(this.title);
        System.out.println(this.script.getCommand());

        JPanel introPane = new JPanel();
        introPane.setLayout(new BoxLayout(introPane, BoxLayout.Y_AXIS));
        Border intBorder = BorderFactory.createEmptyBorder(2,20,20,20);
        Border intBorder2 = BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);
        introPane.setBorder(BorderFactory.createCompoundBorder(intBorder2,intBorder));

        // Script Title
        JLabel label = new JLabel(this.title);
        label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, TITLE_FONT_SIZE));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border pBorder = BorderFactory.createEmptyBorder(20,0,0,0);
        label.setBorder(BorderFactory.createCompoundBorder(label.getBorder(),pBorder));
        introPane.add(label);

        // Script Link
        JLabel link = new JLabel("Script Website");
        link.setCursor(new Cursor(Cursor.HAND_CURSOR));
        link.setAlignmentX(Component.CENTER_ALIGNMENT);
        link.setForeground(Color.BLUE);
        link.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                System.out.println("Link Clicked");
                openScriptPage();
            }
        });
        pBorder = BorderFactory.createEmptyBorder(10,0,10,0);
        link.setBorder(BorderFactory.createCompoundBorder(link.getBorder(),pBorder));
        introPane.add(link);

        // Description title
        JLabel label2 = new JLabel("Description:");
        label2.setFont(new Font(label2.getFont().getFontName(), Font.BOLD, label2.getFont().getSize()));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        pBorder = BorderFactory.createEmptyBorder(0,0,2,0);
        label2.setBorder(BorderFactory.createCompoundBorder(label2.getBorder(),pBorder));
        introPane.add(label2);

        // Script Description
        Boolean cut = false;
        String cut_desc = this.script.getLongDesc();
        if (cut_desc.length() > 600){
            for (int i = 0; i < 20; i++){
                if (cut_desc.length() >= 591+i && cut_desc.charAt(590+i) == ' '){
                    cut_desc = cut_desc.substring(0,590+i) + "...";
                    cut = true;
                }
            }
            if (!cut)
                cut_desc = cut_desc.substring(0, 590) + "...";
            // cut_desc = cut_desc.substring(0, 400);
        }
        JLabel descrip = new JLabel("<html><div style='text-align: center;'>" + cut_desc + "</html>");
        descrip.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border deBorder = BorderFactory.createEmptyBorder(2,20,10,20);
        // Border deBorder2 = BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);
        descrip.setBorder(BorderFactory.createCompoundBorder(descrip.getBorder(),deBorder));
        introPane.add(descrip);

        // if cut short add link
        if (cut){
            JLabel see_more = new JLabel("See More...");
            see_more.setCursor(new Cursor(Cursor.HAND_CURSOR));
            see_more.setForeground(Color.BLUE);
            see_more.setAlignmentX(Component.CENTER_ALIGNMENT);
            see_more.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    System.out.println("Show more details");
                    showFullDescription();
                }
            });
            introPane.add(see_more);
        }

        pane.add(introPane);

        // Set up panel to hold req options
        JPanel ropPane = new JPanel();
        ropPane.setLayout(new BoxLayout(ropPane, BoxLayout.Y_AXIS));
        Border ropBorder = BorderFactory.createEmptyBorder(20,20,2,20);
        Border ropBorder2 = BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);
        ropPane.setBorder(BorderFactory.createCompoundBorder(ropBorder2,ropBorder));

        // Req Options title
        label2 = new JLabel("Required Options:");
        label2.setFont(new Font(label2.getFont().getFontName(), Font.BOLD, label2.getFont().getSize()));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        ropPane.add(label2);

        // Req Options intro
        label2 = new JLabel("These options are required to run the script. Hover over the ? to get option details.");
        // label2.setFont(new Font(label2.getFont().getFontName(), Font.BOLD, label2.getFont().getSize()));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        pBorder = BorderFactory.createEmptyBorder(0,0,10,0);
        label2.setBorder(BorderFactory.createCompoundBorder(label2.getBorder(),pBorder));
        ropPane.add(label2);

        // add Req Optons
        List<Option> r_options = this.script.getReqOptions();
        this.r_op_buttons = new ArrayList<Object>(r_options.size());
        if (r_options.size() == 0){
            JLabel no_ops = new JLabel("No required options for this script.");
            no_ops.setAlignmentX(Component.CENTER_ALIGNMENT);
            pBorder = BorderFactory.createEmptyBorder(0,0,10,0);
            no_ops.setBorder(BorderFactory.createCompoundBorder(no_ops.getBorder(),pBorder));
            ropPane.add(no_ops);
        }
        else {
            for (int i = 0; i < r_options.size(); i++){
                if (!r_options.get(i).getFlag().equals("-o"))
                    createFormOption(ropPane, r_options.get(i), true, i);
                else
                    this.r_op_buttons.add(null);
            }
        }
        JScrollPane ropScroll = new JScrollPane(ropPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ropScroll.setMinimumSize(new Dimension(900, 120));
        pane.add(ropScroll);

        // Set up panel to hold extra options
        JPanel eopPane = new JPanel();
        eopPane.setLayout(new BoxLayout(eopPane, BoxLayout.Y_AXIS));
        Border eopBorder = BorderFactory.createEmptyBorder(20,20,2,20);
        Border eopBorder2 = BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);
        eopPane.setBorder(BorderFactory.createCompoundBorder(eopBorder2,eopBorder));
        // Extra Options title
        label2 = new JLabel("Extra Options:");
        label2.setFont(new Font(label2.getFont().getFontName(), Font.BOLD, label2.getFont().getSize()));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        eopPane.add(label2);

        // Extra Options title
        label2 = new JLabel("These options are not required to run the script.");
        // label2.setFont(new Font(label2.getFont().getFontName(), Font.BOLD, label2.getFont().getSize()));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        pBorder = BorderFactory.createEmptyBorder(0,0,10,0);
        label2.setBorder(BorderFactory.createCompoundBorder(label2.getBorder(),pBorder));
        eopPane.add(label2);

        // add Extra Optons
        List<Option> e_options = this.script.getExtraOptions();
        this.e_op_buttons = new ArrayList<Object>(e_options.size());
        if (e_options.size() == 0){
            JLabel no_ops = new JLabel("No extra options for this script.");
            no_ops.setAlignmentX(Component.CENTER_ALIGNMENT);
            pBorder = BorderFactory.createEmptyBorder(0,0,10,0);
            no_ops.setBorder(BorderFactory.createCompoundBorder(no_ops.getBorder(),pBorder));
            eopPane.add(no_ops);
        }
        else {
            System.out.println(e_options.size());
            for (int i = 0; i < e_options.size(); i++){
                if (!e_options.get(i).getFlag().equals("-o"))
                    createFormOption(eopPane, e_options.get(i), false, i);
                else 
                    this.e_op_buttons.add(null);
            }
        }
        JScrollPane eopScroll = new JScrollPane(eopPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        eopScroll.setMinimumSize(new Dimension(900, 120));
        pane.add(eopScroll);

        // pane.add(eopPane);

        // Set up panel to output descrip and option
        JPanel outPane = new JPanel();
        outPane.setLayout(new BoxLayout(outPane, BoxLayout.Y_AXIS));
        Border outBorder = BorderFactory.createEmptyBorder(20,20,2,20);
        Border outBorder2 = BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);
        outPane.setBorder(BorderFactory.createCompoundBorder(outBorder2,outBorder));

        label2 = new JLabel("Output:");
        label2.setFont(new Font(label2.getFont().getFontName(), Font.BOLD, label2.getFont().getSize()));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        outPane.add(label2);

        JLabel outDesc = new JLabel("<html><div style='text-align: center;'>" + this.script.getOutputDesc() + "</html>");
        outDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
        pBorder = BorderFactory.createEmptyBorder(0,0,10,0);
        outDesc.setBorder(BorderFactory.createCompoundBorder(outDesc.getBorder(),pBorder));
        outPane.add(outDesc);
        Option outOp = this.script.findOption("-o");
        if (outOp != null)
            createFormOption(outPane, outOp, false, -1);
        else {
            JLabel no_out = new JLabel("No output for this script.");
            Border noO_border = BorderFactory.createEmptyBorder(10,0,10,0);
            no_out.setBorder(BorderFactory.createCompoundBorder(no_out.getBorder(),noO_border));
            no_out.setAlignmentX(Component.CENTER_ALIGNMENT);
            outPane.add(no_out);
        }

        pane.add(outPane);

        // Buttons Section
        JButton button3 = new JButton("<< Back to Category");
        button3.setActionCommand("back");
        button3.addActionListener(this);
        JButton button4 = new JButton("Home");
        button4.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) { 
            frame.dispose();
            // System.exit(0);
            Home.createAndShowGUI();
          } 
        });
        JButton button5 = new JButton("Run Script");
        button5.setActionCommand("run");
        button5.addActionListener(this);
        
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPane.add(button3);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(button4);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(button5);

        buttonPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border buttonBorder = BorderFactory.createEmptyBorder(10,0,10,0);
        buttonPane.setBorder(BorderFactory.createCompoundBorder(buttonPane.getBorder(),buttonBorder));
        buttonPane.setMinimumSize(new Dimension(900, 100));
        buttonPane.setPreferredSize(new Dimension(900, 100));
        // buttonPane.setMaximumSize(new Dimension(1200, 200));
        pane.add(buttonPane);
    }

    private void runScript(List<String> ops){
        ScriptRunner sr = new ScriptRunner();
        sr.runScript(this.script.getCommand(), ops);
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("Something was clicked" + e.getActionCommand());
        if (e.getActionCommand().equals("run")){
            System.out.println("here too");
            getFormOptions();
            if (!this.script.isRunnable()){
                Option mis = this.script.findMissingReqOption();
                System.out.println("Missing required option: " + mis.getLabel());
                String mismes = "<html><div style='text-align: center;'>Missing required option '" + mis.getLabel() + "'. <br><br>Please complete and try again.</html>";
                JOptionPane.showMessageDialog(this.frame, mismes);
            }
            else {
                this.frame.dispose();
                System.out.println(this.script.getCommandLineString());
                runScript(this.script.getOptionsStringList());
            }
        }
        else if (e.getActionCommand().equals("back")){
            this.frame.dispose();
            this.prev_screen.setVisible(true);
        }
        else if (e.getActionCommand().equals("out")){
            Option o_op = this.script.findOption("-o");
            JFileChooser fc_o = new JFileChooser();
            fc_o.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int f_select_o = fc_o.showDialog(prnt, "Select");
            if (f_select_o == JFileChooser.APPROVE_OPTION){
                File sel_o = fc_o.getSelectedFile();
                if (o_op.getNumFiles() != 1){
                    // multiple files
                    // JLabel lbl_o = (JLabel)this.r_op_buttons.get(index);
                    if (outPath.getText().equals(""))
                        outPath.setText(sel_o.getName());
                    else
                        outPath.setText(outPath.getText() + "," + sel_o.getName());
                }
                else {
                    // single file
                    outPath.setText(sel_o.getName());
                    // ((JLabel)this.r_op_buttons.get(index)).setText(sel.getName());
                    o_op.setPath(sel_o.getAbsolutePath());
                    // this.script.getReqOptions().get(index).setPath(sel.getAbsolutePath());
                    System.out.println("Set label to: " + sel_o.getName());
                    System.out.println("Set path to: " + sel_o.getAbsolutePath());
                }
            }
        }
        else {
            System.out.println("It was a file button");
            String[] call = e.getActionCommand().split("-");
            int index = Integer.parseInt(call[1]);
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int f_select = fc.showDialog(prnt, "Select");
            if (f_select == JFileChooser.APPROVE_OPTION){
                File sel = fc.getSelectedFile();
                if (call[0].equals("R")){
                    // required option
                    List<Option> r_ops = this.script.getReqOptions();
                    // System.out.println("---->>>> " + r_ops.get(index).getFlag() + " " + r_ops.get(index).getNumFiles());
                    if (r_ops.get(index).getNumFiles() == 1){
                        // single file
                        ((JLabel)this.r_op_buttons.get(index)).setText(sel.getName());
                        this.script.getReqOptions().get(index).setPath(sel.getAbsolutePath());
                        System.out.println("Set label to: " + sel.getName());
                        System.out.println("Set path to: " + sel.getAbsolutePath());
                    }
                    else {
                        System.out.println("Multiple files");
                        int fileIndex = Integer.parseInt(call[2]);
                        System.out.println("File Index **** " + fileIndex);
                        // multiple files
                        JLabel lbl = (JLabel)this.r_op_buttons.get(index);
                        r_ops.get(index).addFile(fileIndex, sel.getAbsolutePath());
                        if (lbl.getText().equals("")){
                            lbl.setText(sel.getName());
                        }
                        else {
                            lbl.setText(lbl.getText() + "," + sel.getName());
                        }
                    }
                }
                else {
                    // extra option
                    List<Option> e_ops = this.script.getExtraOptions();
                    // System.out.println("---->>>> " + r_ops.get(index).getFlag() + " " + r_ops.get(index).getNumFiles());
                    if (e_ops.get(index).getNumFiles() == 1){
                        // single file
                        ((JLabel)this.e_op_buttons.get(index)).setText(sel.getName());
                        this.script.getExtraOptions().get(index).setPath(sel.getAbsolutePath());
                        System.out.println("Set label to: " + sel.getName());
                        System.out.println("Set path to: " + sel.getAbsolutePath());
                    }
                    else {
                        System.out.println("Multiple files");
                        int fileIndex = Integer.parseInt(call[2]);
                        // multiple files
                        JLabel lbl = (JLabel)this.e_op_buttons.get(index);
                        e_ops.get(index).addFile(fileIndex, sel.getAbsolutePath());
                        if (lbl.getText().equals("")){
                            lbl.setText(sel.getName());
                        }
                        else {
                            lbl.setText(lbl.getText() + "," + sel.getName());
                        }
                    }
                }
                // System.out.println("File selected: " + path);
            }
           
        }

    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    protected void createAndShowGUI() {
        
        //Create and set up the window.
        this.frame = new JFrame("Script Form");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(900,1000);

        //Set up the content pane.
        Container pane = this.frame.getContentPane();
        this.prnt = pane;
        // JPanel container = new JPanel();
        // container.setMaximumSize(new Dimension(900, 700));
        // BorderLayout bl = pane.getLayout();
        // bl.setHgap(2);
        // bl.getVgap(1);
        // JScrollPane scroll = new JScrollPane();
        // this.frame.setContentPane(scroll);
        addComponentsToPane(pane, this.frame);
        // pane.add(scroll);
        // this.frame.setContentPane(scroll);
        // this.frame.add(scroll);
        //Use the content pane's default BorderLayout. No need for
        // setLayout(new BorderLayout());
        //Display the window.
        // this.frame.pack();
        this.frame.setVisible(true);
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
        ScriptForm me = new ScriptForm(Categories.ADD_QIIME_LABELS, "Add Qiime Labels", null);
        me.createAndShowGUI();
    }

}