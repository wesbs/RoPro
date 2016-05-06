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
import java.awt.Cursor;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

public class GetData {
    private JFrame frame;
    private String cat_type = "Function";
    private String cat = "Test";
    private int[] scripts = Categories.TEST_CAT;
    private static final String[] col_names = {"SRA ID(s)", "Description",  "MD5", "File Size", "HTTP", "FTP"};
    private static final String INTRO = "<html><div style='text-align: center;'>From this page you are able to get data to run scripts on from the Human Microbiome Project Website. Once the data is selected, you will be navigated to the data webpage and the data will automatically be downloaded to your default downloads folder. Both HTTP and FTP downloads are available.</html>";
    private static final String HBP_WEBSITE = "http://hmpdacc.org/";
    private static final int TITLE_FONT_SIZE = 15;
    private static final int SUBSCRIPT_FONT_SIZE = 10;
    private static final String[] SRA_IDS = {"SPR002395", "SRR040000 - SRR040999", "SRR041000 - SRR041999", "SRR042000 - SRR042999", "SRR043000 - SRR043999", "SRR044000 - SRR044999", "SRR045000 - SRR045999", "SRR046000 - SRR046999", "SRR047000 - SRR047999", "SRR048000 - SRR048999", "SRR049000 - SRR049999", "SRR050000 - SRR050999"};
    private static final String[] DATA_DESCS = {"16S Library Metadata", "16S Raw Reads", "16S Raw Reads", "16S Raw Reads", "16S Raw Reads", "16S Raw Reads", "16S Raw Reads", "16S Raw Reads", "16S Raw Reads", "16S Raw Reads", "16S Raw Reads", "16S Raw Reads"};
    private static final String[] FILE_SIZES = {"11.6 MB", "1.9 GB", "5.5 GB", "500.8 MB", "3.0 GB", "8.5 GB", "7.4 GB", "8.2 GB", "8.0 GB", "7.2 GB", "3.6 GB", "12.6 GB"};
    private static final String[] MD5S = {"0bac12126971b96f097b44969b072973", "d180bbd0714596bfd3fb52990c73d673", "ee760a8850c6b71c833c93b1a606de0e", "67b05acb3b460fefc9adc36c199a2438", "d44b6f26293a0874c85924836d379f0d", "a8011ffdd193409ae33751c64727ac07", "a8011ffdd193409ae33751c64727ac07", "9a70026ee50abbba373ed77e6163a2d0", "36e31498ae42111db8488ad99e8a8648", "209f30e6e7b3a81f036dcbedbd12a2e2", "654fa91bed1d53c2c67a38f95e1c3a55", "de835569c0479e74a1c65d43eaa9382f"};
    private static final String[] DOWN_LINKS_HTTP = {"http://downloads.hmpdacc.org/data/HMR16S/SRP002395_metadata_lmd.tar.gz", "http://downloads.hmpdacc.org/data/HMR16S/SRR040.tar.bz2", "http://downloads.hmpdacc.org/data/HMR16S/SRR041.tar.bz2", "http://downloads.hmpdacc.org/data/HMR16S/SRR042.tar.bz2", "http://downloads.hmpdacc.org/data/HMR16S/SRR043.tar.bz2", "http://downloads.hmpdacc.org/data/HMR16S/SRR044.tar.bz2", "http://downloads.hmpdacc.org/data/HMR16S/SRR045.tar.bz2", "http://downloads.hmpdacc.org/data/HMR16S/SRR046.tar.bz2", "http://downloads.hmpdacc.org/data/HMR16S/SRR047.tar.bz2", "http://downloads.hmpdacc.org/data/HMR16S/SRR048.tar.bz2", "http://downloads.hmpdacc.org/data/HMR16S/SRR049.tar.bz2", "http://downloads.hmpdacc.org/data/HMR16S/SRR050.tar.bz2"};
    private static final String[] DOWN_LINKS_FTP = {"ftp://public-ftp.hmpdacc.org/data/HMR16S/SRP002395_metadata_lmd.tar.gz", "ftp://public-ftp.hmpdacc.org/data/HMR16S/SRR040.tar.bz2", "ftp://public-ftp.hmpdacc.org/data/HMR16S/SRR041.tar.bz2", "ftp://public-ftp.hmpdacc.org/data/HMR16S/SRR042.tar.bz2", "ftp://public-ftp.hmpdacc.org/data/HMR16S/SRR043.tar.bz2", "ftp://public-ftp.hmpdacc.org/data/HMR16S/SRR044.tar.bz2", "ftp://public-ftp.hmpdacc.org/data/HMR16S/SRR045.tar.bz2", "ftp://public-ftp.hmpdacc.org/data/HMR16S/SRR046.tar.bz2", "ftp://public-ftp.hmpdacc.org/data/HMR16S/SRR047.tar.bz2", "ftp://public-ftp.hmpdacc.org/data/HMR16S/SRR048.tar.bz2", "ftp://public-ftp.hmpdacc.org/data/HMR16S/SRR049.tar.bz2", "ftp://public-ftp.hmpdacc.org/data/HMR16S/SRR050.tar.bz2"};
    private PrintWriter pw;

    public GetData(PrintWriter pw){
        this.cat = "All Scripts";
        this.pw = pw;
        this.scripts = Categories.getCategory(this.cat);
        this.createAndShowGUI();
    }

    private static void openPage(String link) {
        if (Desktop.isDesktopSupported()) {
          try {
            Desktop.getDesktop().browse(new URI(link));
          } catch (IOException e) { 
            e.printStackTrace();
          } catch (URISyntaxException e){
            e.printStackTrace();
          }
        } else { 
            System.out.print("Desktop is not supported");
         }
    }

    private void print(String s){
        this.pw.println(s);
    }

    private static String stripHTML(String s){
        return s.replaceAll("<html>", "").replaceAll("<div style='text-align: center;'>", "").replaceAll("</html>", "");
    }

    private void addTable(Container pane, JFrame frame){
        System.out.println("Rows: " + SRA_IDS.length);
        System.out.println("Columnds: " + col_names.length);

        // set up data table
        Object[][] tableData = new Object[SRA_IDS.length][col_names.length];
        for (int i = 0; i < SRA_IDS.length; i++){
            // String [] rowData = Categories.getData(scripts[i]);
            tableData[i][0] = SRA_IDS[i];
            tableData[i][1] = DATA_DESCS[i];
            tableData[i][2] = MD5S[i];
            tableData[i][3] = FILE_SIZES[i];
            tableData[i][4] = "Download";
            tableData[i][5] = "Download";
        }


        DefaultTableModel tableModel = new DefaultTableModel(tableData, col_names) {

           @Override
           public boolean isCellEditable(int row, int column) {
               //Only the fifth or sixth column
               return (column == 4 || column == 5 ? true : false);
           }
        };

        JTable scriptTable = new JTable(tableModel);
        Action downloadHTTP = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                // jf.setVisible(false);
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                System.out.println("Download Selected: HTTP " + table.getModel().getValueAt(modelRow, 0) + " " + modelRow);
                GetData.openPage(DOWN_LINKS_HTTP[modelRow]);
            }
        };
        Action downloadFTP = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                // jf.setVisible(false);
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                System.out.println("Download Selected: FTP " + table.getModel().getValueAt(modelRow, 0) + " " + modelRow);
                GetData.openPage(DOWN_LINKS_FTP[modelRow]);
            }
        };
        ButtonColumn http_col = new ButtonColumn(scriptTable, downloadHTTP, 4);
        ButtonColumn ftp_col = new ButtonColumn(scriptTable, downloadFTP, 5);
        scriptTable.getTableHeader().setReorderingAllowed(false);
        scriptTable.getTableHeader().setResizingAllowed(false);
        scriptTable.setRowHeight(50);
        TableColumnModel c_model = scriptTable.getColumnModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        c_model.getColumn(0).setPreferredWidth(200);
        c_model.getColumn(0).setMaxWidth(300);
        c_model.getColumn(1).setCellRenderer(centerRenderer);
        // c_model.getColumn(2).setPreferredWidth(200);
        // c_model.getColumn(2).setMaxWidth(300);
        // c_model.getColumn(3).setPreferredWidth(100);
        // c_model.getColumn(3).setMaxWidth(200);
        c_model.getColumn(2).setCellRenderer(centerRenderer);
        c_model.getColumn(3).setPreferredWidth(100);
        c_model.getColumn(3).setMaxWidth(200);        
        c_model.getColumn(3).setCellRenderer(centerRenderer);
        c_model.getColumn(4).setPreferredWidth(100);
        c_model.getColumn(4).setMaxWidth(200);
        c_model.getColumn(5).setPreferredWidth(100);
        c_model.getColumn(5).setMaxWidth(200);


        JScrollPane scrollP = new JScrollPane(scriptTable);
        Border sp_Border = BorderFactory.createEmptyBorder(20,20,2,20);
        scrollP.setBorder(BorderFactory.createCompoundBorder(scrollP.getBorder(),sp_Border));
        pane.add(scrollP);

    }
    
    public void addComponentsToPane(Container pane, JFrame frame) {

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        // // Welcome statement
        // JLabel label = new JLabel("Scripts By Function Test:");
        // label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, TITLE_FONT_SIZE));
        // label.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Border pBorder = BorderFactory.createEmptyBorder(20,0,2,0);
        // label.setBorder(BorderFactory.createCompoundBorder(label.getBorder(),pBorder));
        // pane.add(label);

        JLabel intro = new JLabel("<html>" + INTRO + "</html>");
        intro.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border introBorder = BorderFactory.createEmptyBorder(10,25,15,25);
        intro.setBorder(BorderFactory.createCompoundBorder(intro.getBorder(),introBorder));
        pane.add(intro);

        JLabel link = new JLabel("Human Microbiome Project");
        link.setCursor(new Cursor(Cursor.HAND_CURSOR));
        link.setAlignmentX(Component.CENTER_ALIGNMENT);
        link.setForeground(Color.BLUE);
        link.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                // System.out.println("Link Clicked");
                openPage(GetData.HBP_WEBSITE);
            }
        });
        Border pBorder = BorderFactory.createEmptyBorder(5,0,20,0);
        // Border introBorder2 = BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK);
        link.setBorder(BorderFactory.createCompoundBorder(link.getBorder(),pBorder));
        pane.add(link);

        addTable(pane, frame);

        // Scripts Button
        // JButton button3 = new JButton("<< Back to Categories");
        // button3.addActionListener(new ActionListener() { 
        //   public void actionPerformed(ActionEvent e) { 
        //     frame.dispose();
        //     // this.print("'Back to Categories' selected. Closing Script Selection.");
        //     SelectCat sc = new SelectCat(pw);
        //     // System.exit(0);
        //   } 
        // });

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
        JButton c_dir = new JButton("Close");
        c_dir.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) { 
            System.exit(0);
          } 
        });
        
        // Panel to hold both buttons
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        // buttonPane.add(button3);
        // buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
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
        this.frame = new JFrame("Get Data");
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