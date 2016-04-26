package start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelloWorld{
	private JFrame frame;
	private JPanel panel;
	private JLabel label;
	private JLabel clicked;
	private JButton button;

	public HelloWorld() {}

	private void createandshowGUI(){
		frame = new JFrame("Opening");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		Container cont = frame.getContentPane();
		cont.setLayout(new GridLayout(8,8));

		panel = new JPanel(new FlowLayout());
		frame.add(panel);

		label = new JLabel("QIIME BITCHES!");
		// label.setAlignment(0);
		frame.getContentPane().add(label);

		clicked = new JLabel("");

		button = new JButton("Click here");
		button.setActionCommand("OK");
		button.addActionListener(new ButtonClickListener());
		cont.add(button);

		// frame.pack();
		frame.setVisible(true);
	}

	private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();  
         if( command.equals( "OK" ))
            clicked.setText("LESSGOOOOOO");
      }		
  }

	public static void main(String args[]){
		HelloWorld it = new HelloWorld();
		it.createandshowGUI();
	}


}