package scripts;

import java.lang.ProcessBuilder;
import java.lang.Process;
import java.lang.Thread;
import java.util.*;
import javax.swing.JTextArea;
import java.io.*;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;


public class ScriptRunner {
	private final JTextArea destination;
	private BufferedReader in;
	private BufferedReader out;

	public ScriptRunner(JTextArea dest){
		this.destination = dest;
	}

	// class Printer implements Runnable {
	// 	private BufferedReader stream;
	// 	private JTextArea dest;

	// 	public Printer(BufferedReader st, JTextArea dest){
	// 		this.stream = st;
	// 		this.dest = dest;
	// 	}

	// 	public void run(){
	// 		String s;
	// 		try {
	// 			while ((s = this.stream.readLine()) != null)
	// 				this.dest.append(s);
	// 		}
	// 		catch (IOException e){
	// 			System.out.println(e.getMessage());
	// 		}
	// 	}
	// }


	public void runScript(String command, List<Option> options){
		String s;
		Option op;
		StringBuilder sb = new StringBuilder("python");
		List<String> cmds = new ArrayList<String>();
		cmds.add("python");
		cmds.add(command);
		for (int i = 0; i < options.size(); i++){
			op = options.get(i);
			cmds.add(op.getFlag());
			if (op.getType() != Option.NOARG)
				cmds.add(op.getArgument());
		}
		// System.out.println(fullString);
		for (int i = 1; i < cmds.size(); i++)
			sb.append(" " + cmds.get(i));
		try {
			JTextArea ta = this.destination;

			EventQueue.invokeAndWait(new Runnable() {
          @Override
          public void run() {
    				ta.append("Command Line String:\n\n" + sb.toString() + "\n\n***************** SCRIPT STARTING *****************\n\n");
          }
	      });

			ProcessBuilder proc = new ProcessBuilder(cmds);
			Process p = proc.start();
			BufferedReader stdInput = new BufferedReader(new
                 InputStreamReader(p.getInputStream()));
			BufferedReader stdErr = new BufferedReader(new
                 InputStreamReader(p.getErrorStream()));


			while ((s = stdInput.readLine()) != null){
				String it = s;
				EventQueue.invokeAndWait(new Runnable() {
          @Override
          public void run() {
    				ta.append(it + "\n");
          }
	      });
			}

			while ((s = stdErr.readLine()) != null){
				String it2 = s;
				EventQueue.invokeAndWait(new Runnable() {
          @Override
          public void run() {
    				ta.append(it2 + "\n");
          }
	      });
			}

			// // start reading threads
			// new Thread(new Printer(stdInput, this.destination)).start(); 	// read standard out
			// new Thread(new Printer(stdErr, this.destination)).start();		// read standard error

      p.waitFor();	// wait for process to complete
      this.destination.append("\n\n***************** SCRIPT FINISHED ******************\n");
		}
		catch (IOException | InterruptedException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
	}
	/*
		This class contains the functions needed to run the scripts
		It has multiple calling options depending on how the command and arguemnt are passed in
	*/

	// public static void runScript(String fullString){
	// 	String s = "python " + fullString;
	// 	// System.out.println(fullString);
	// 	try {
	// 		ProcessBuilder proc = new ProcessBuilder(s);
	// 		Process p = proc.start();
	// 		BufferedReader stdInput = new BufferedReader(new
 //                 InputStreamReader(p.getInputStream()));
	// 		BufferedReader stdErr = new BufferedReader(new
 //                 InputStreamReader(p.getErrorStream()));
	// 		while ((s = stdInput.readLine()) != null) {
 //                System.out.println(s);
 //            }
 //      while ((s = stdErr.readLine()) != null) {
 //                System.out.println(s);
 //            }
	// 	}
	// 	catch (IOException e) {
	// 		System.out.println(e.getMessage());
	// 	}
	// }

	// public static void runScript(String command, List<String> options){
	// 	String s;
	// 	Option op;
	// 	// List<String> cmds = new ArrayList<String>();
	// 	options.add(0, "python");
	// 	// cmds.add(command);
	// 	// for (int i = 0; i < options.size(); i++){
	// 	// 	op = options.get(i);
	// 	// 	cmds.add(op.getFlag());
	// 	// 	cmds.add(op.getArgument());
	// 	// }
	// 	// System.out.println(fullString);
	// 	// for (int i = 0; i < cmds.size(); i++)
	// 	// 	System.out.println(cmds.get(i));
	// 	try {
	// 		ProcessBuilder proc = new ProcessBuilder(options);
	// 		Process p = proc.start();
	// 		BufferedReader stdInput = new BufferedReader(new
 //                 InputStreamReader(p.getInputStream()));
	// 		BufferedReader stdErr = new BufferedReader(new
 //                 InputStreamReader(p.getErrorStream()));
	// 		while ((s = stdInput.readLine()) != null) {
 //                System.out.println(s);
 //            }
 //      while ((s = stdErr.readLine()) != null) {
 //                System.out.println(s);
 //            }
	// 	}
	// 	catch (IOException e) {
	// 		System.out.println(e.getMessage());
	// 	}
	// }

}