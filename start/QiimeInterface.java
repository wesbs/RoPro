package start;

import java.io.*;
import java.lang.String;
import java.util.*;
import java.io.PrintWriter;


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

	public static void main(String[] args){
		QiimeInterface me = new QiimeInterface();
		me.start();
	}
}