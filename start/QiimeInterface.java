package start;

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
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
import scripts.Script;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Formatter;



public class QiimeInterface {
	public PrintWriter pw;
	protected static final String LOG_FILE_PATH = "./log.txt";

	public QiimeInterface(){
		try {
			this.pw = new PrintWriter(LOG_FILE_PATH);
		}
		catch (FileNotFoundException e) {
			System.exit(0);
		}
	}

	public static void printEnv() throws FileNotFoundException{
		Formatter fm = new Formatter("env_jar_dc.txt");
		Map<String, String> env = System.getenv();
    for (String envName : env.keySet()) {
        fm.format("%s=%s%n", envName, env.get(envName));
    }
    fm.close();
	}

	public void start(){
		try {
			Home go = new Home(pw);
		}
		catch (Exception e){
			System.out.println("Heyyyyy");
			this.pw.print(e.getMessage());
			this.pw.close();
			System.exit(0);
		}
	}

	public static void main(String[] args) throws FileNotFoundException{
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

		QiimeInterface me = new QiimeInterface();
		// me.printEnv();
		me.start();
	}
}