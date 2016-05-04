package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;


public class Script {
	public static String SCRIPTS_PATH = null;

	public static String title;							// name of script
	protected String link;							// link to script webpage
	protected String c_name;						// command entered to run script
	public static String b_desc;						// short description
	protected String l_desc;						// long description
	protected String output_desc;				// description of output files
	protected List<Option> r_options;		// list of required options
	protected List<Option> e_options;		// list of extra options

	public Script() {}

	// public Script(String title, String c_name, List<Option> required){
	// 	this.title = title;
	// 	this.c_name = c_name;
	// 	this.r_options = required;
	// }

	public Script(String title, String c_name, String b_desc, List<Option> required){
		this.title = title;
		this.c_name = c_name;
		this.b_desc = b_desc;
		this.r_options = required;
	}

	// public Script(String title, String c_name, String b_desc, String l_desc, List<Option> required){
	// 		this.title = title;
	// 		this.c_name = c_name;
	// 		this.b_desc = b_desc;
	// 		this.l_desc = l_desc;
	// 		this.r_options = required;
	// }

	// public Script(String title, String c_name, String b_desc, String l_desc, String o_desc, List<Option> required){
	// 		this.title = title;
	// 		this.c_name = c_name;
	// 		this.b_desc = b_desc;
	// 		this.l_desc = l_desc;
	// 		this.output_desc = o_desc;
	// 		this.r_options = required;
	// }	

	// public Script(String title, String c_name, String b_desc, String l_desc, String o_desc, List<Option> required, List<Option> optional){
	// 		this.title = title;
	// 		this.c_name = c_name;
	// 		this.b_desc = b_desc;
	// 		this.l_desc = l_desc;
	// 		this.output_desc = o_desc;
	// 		this.r_options = required;
	// 		this.e_options = optional;
	// }	

	public static void setScriptPath(String path){
		SCRIPTS_PATH = path;
	}

	// returns the script title
	public String getTitle(){
		return this.title;
	}

	// returns the link
	public String getLink(){
		return this.link;
	}

	// returns the script command name
	public String getCommand(){
		return this.c_name;
	}

	// returns the script short decription
	public String getBriefDesc(){
		return this.b_desc;
	}

	// returns the script long description
	public String getLongDesc(){
		return this.l_desc;
	}

	// returns the script output description
	public String getOutputDesc(){
		return this.output_desc;
	}

	// returns the script's required options as a list of options
	public List<Option> getReqOptions(){
		return this.r_options;
	}

	// returns the script's extra options as a list of options
	public List<Option> getExtraOptions(){
		return this.e_options;
	}

	// returns all of the script's options (required and extra) as a list of options
	public List<Option> getAllOptions(){
		List<Option> all = new ArrayList<Option>();
		all.addAll(this.r_options);
		if (this.e_options != null)
			all.addAll(this.e_options);
		return all;
	}

	// makes sure all req options are turned on
	public boolean isRunnable(){
		boolean ret = true;
		for (int i = 0; i < this.r_options.size(); i++){
			if (!this.r_options.get(i).isRunnable()){
				ret = false;
				break;
			}
		}
		return ret;
	}

	public Option findMissingReqOption(){
		Option op = null;
		for (int i = 0; i < this.r_options.size(); i++){
			if (!this.r_options.get(i).isRunnable()){
				op = this.r_options.get(i);
				break;
			}
		}
		return op;
	}

	// returns all of the script's options as a string
	// of the format "<flag1> <arg1> <flag2> <arg2> ..."
	public String getAllOptionsString(){
		StringBuilder options = new StringBuilder();
		int i = 0;

		for (i = 0; i < this.r_options.size(); i++){
			if (this.r_options.get(i).isRunnable()){
				options.append(this.r_options.get(i).optionString());
				options.append(" ");
			}
			else{
				System.out.println(this.r_options.get(i).getLabel() + " is not runnable" + (this.r_options.get(i).getOn() ? " but is on" : " and is turned off"));
			}
		}

		if (this.e_options != null){
			for (i = 0; i < this.e_options.size(); i++){
				if (this.e_options.get(i).isRunnable()){
					options.append(this.e_options.get(i).optionString());
					options.append(" ");
				}
				else{
					System.out.println(this.e_options.get(i).getLabel() + " is not runnable" + (this.e_options.get(i).getOn() ? " but is on" : " and is turned off"));
				}
			}
		}
		return options.toString();
	}

	// returns all of the script's options as a list of string
	// of the format "<flag1> <arg1> <flag2> <arg2> ..."
	public List<String> getOptionsStringList(){
		List<String> options = new ArrayList<String>();
		int i = 0;

		for (i = 0; i < this.r_options.size(); i++){
			if (this.r_options.get(i).isRunnable()){
				options.add(this.r_options.get(i).optionString());
			}
			else{
				System.out.println(this.r_options.get(i).getLabel() + " is not runnable" + (this.r_options.get(i).getOn() ? " but is on" : " and is turned off"));
			}
		}

		if (this.e_options != null){
			for (i = 0; i < this.e_options.size(); i++){
				if (this.e_options.get(i).isRunnable()){
					options.add(this.e_options.get(i).optionString());
				}
				else{
					System.out.println(this.e_options.get(i).getLabel() + " is not runnable" + (this.e_options.get(i).getOn() ? " but is on" : " and is turned off"));
				}
			}
		}
		return options;
	}

	// returns the script's required options as a string
	// of the format "<flag1> <arg1> <flag2> <arg2> ..."
	public String getReqOptionsString(){
		StringBuilder options = new StringBuilder();
		int i = 0;

		for (i = 0; i < this.r_options.size(); i++){
			if (this.r_options.get(i).isRunnable()){
				options.append(this.r_options.get(i).optionString());
				options.append(" ");
			}
			else{
				System.out.println(this.r_options.get(i).getLabel() + " is not runnable");
			}
		}

		return options.toString();
	}

	// returns the script's extra options as a string
	// of the format "<flag1> <arg1> <flag2> <arg2> ..."
	public String getExtraOptionsString(){
		StringBuilder options = new StringBuilder();
		int i = 0;

		for (i = 0; i < this.e_options.size(); i++){
			if (this.e_options.get(i).isRunnable()){
				options.append(this.e_options.get(i).optionString());
				options.append(" ");
			}
			else{
				System.out.println(this.e_options.get(i).getLabel() + " is not runnable");
			}
		}

		return options.toString();
	}

	// returns a list of all options that are runnable
	public List<Option> getRunningOptions(){
		List<Option> ops = new ArrayList<Option>();
		int i = 0;

		for (i = 0; i < this.r_options.size(); i++){
			if (this.r_options.get(i).isRunnable()){
				ops.add(this.r_options.get(i));
			}
			else{
				System.out.println(this.r_options.get(i).getLabel() + " is not runnable" + (this.r_options.get(i).getOn() ? " but is on" : " and is turned off"));
			}
		}

		if (this.e_options != null){
			for (i = 0; i < this.e_options.size(); i++){
				if (this.e_options.get(i).isRunnable()){
					ops.add(this.e_options.get(i));
				}
				else{
					System.out.println(this.e_options.get(i).getLabel() + " is not runnable" + (this.e_options.get(i).getOn() ? " but is on" : " and is turned off"));
				}
			}
		}
		return ops;
	}

	// returns the script's full command line string
	// of the format "<command> <flag1> <arg1> <flag2> <arg2> ..."
	public String getCommandLineString(){
		StringBuilder line = new StringBuilder();
		line.append(this.c_name);
		line.append(" " + getAllOptionsString());
		return line.toString();
	}

	// returns the option in the script with the matching flag
	// if not in script's options, returns null
	public Option findOption(String flag){
		Option found = null;
		List<Option> ops = this.getAllOptions();
		for (int i = 0; i < ops.size(); i++){
			if (ops.get(i).getFlag().equals(flag)){
				found = ops.get(i);
				break;
			}
		}
		return found;
	}

	// public static void main(String args[]){
	// 	// List<String> ss = new ArrayList<String>();
	// 	// ss.add("Elephant");
	// 	// ss.add("Dog");
	// 	// ss.add("Horse");
	// 	// List<Option> ops = new ArrayList<Option>();
	// 	// Option op1 = new Option("-i", 2, "Fasting_Example.sff");
	// 	// ops.add(op1);
	// 	// Option op2 = new Option("-o", 2, "test_output/");
	// 	// ops.add(op2);
	// 	// Option op3 = new Option("-n", 1, 20);
	// 	// ops.add(op3);
	// 	// Option op4 = new Option("-S", 0, ss);
	// 	// op4.setSelected(2);
	// 	// ops.add(op4);
	// 	// Option op5 = new Option("-N", 1);
	// 	// ops.add(op5);

	// 	// Script test = new Script("Process SFF file", "scripts/scripts/process_sff.py", "create some files from an sff file", ops);
	// 	AlignSeqs test = new AlignSeqs();
	// 	System.out.println(test.getTitle());
	// 	System.out.println(test.getCommand());
	// 	System.out.println(test.getBriefDesc());
	// 	System.out.println(test.getReqOptionsString());
	// 	System.out.println(test.getCommandLineString());
	// 	System.out.println("-----------------------------\n\n\n");

	// 	List<Option> ops = test.getReqOptions();
	// 	ops.get(0).setPath("Fasting_Example.fna");
	// 	System.out.println("Size: " + ops.size());
	// 	System.out.println("*************");

	// 	// ScriptRunner.runScript(test.getCommand());
	// 	// ScriptRunner.runScript("pwd");
	// 	ScriptRunner.runScript(test.getCommand(), test.getRunningOptions());
	// }

}