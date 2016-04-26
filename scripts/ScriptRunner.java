package scripts;

import java.lang.ProcessBuilder;
import java.lang.Process;
import java.util.*;
import java.io.*;

public class ScriptRunner{
	Script script;

	public ScriptRunner(){}

	/*
		This class contains the functions needed to run the scripts
		It has multiple calling options depending on how the command and arguemnt are passed in
	*/

	public static void runScript(String fullString){
		String s = "python " + fullString;
		// System.out.println(fullString);
		try {
			ProcessBuilder proc = new ProcessBuilder(s);
			Process p = proc.start();
			BufferedReader stdInput = new BufferedReader(new
                 InputStreamReader(p.getInputStream()));
			BufferedReader stdErr = new BufferedReader(new
                 InputStreamReader(p.getErrorStream()));
			while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
      while ((s = stdErr.readLine()) != null) {
                System.out.println(s);
            }
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// public static void runScript(String command, List<Option> options){
	// 	String s;
	// 	Option op;
	// 	List<String> cmds = new ArrayList<String>();
	// 	cmds.add("python");
	// 	cmds.add(command);
	// 	for (int i = 0; i < options.size(); i++){
	// 		op = options.get(i);
	// 		cmds.add(op.getFlag());
	// 		cmds.add(op.getArgument());
	// 	}
	// 	// System.out.println(fullString);
	// 	for (int i = 0; i < cmds.size(); i++)
	// 		System.out.println(cmds.get(i));
	// 	try {
	// 		ProcessBuilder proc = new ProcessBuilder(cmds);
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

	public static void runScript(String command, List<String> options){
		String s;
		Option op;
		// List<String> cmds = new ArrayList<String>();
		options.add(0, "python");
		// cmds.add(command);
		// for (int i = 0; i < options.size(); i++){
		// 	op = options.get(i);
		// 	cmds.add(op.getFlag());
		// 	cmds.add(op.getArgument());
		// }
		// System.out.println(fullString);
		// for (int i = 0; i < cmds.size(); i++)
		// 	System.out.println(cmds.get(i));
		try {
			ProcessBuilder proc = new ProcessBuilder(options);
			Process p = proc.start();
			BufferedReader stdInput = new BufferedReader(new
                 InputStreamReader(p.getInputStream()));
			BufferedReader stdErr = new BufferedReader(new
                 InputStreamReader(p.getErrorStream()));
			while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
      while ((s = stdErr.readLine()) != null) {
                System.out.println(s);
            }
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}