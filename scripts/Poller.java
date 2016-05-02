package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class Poller extends Script {
	public static String title = "Poller";
	public static String b_desc = "Poller for parallel QIIME scripts.";

	public Poller() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/poller.html";
		this.c_name = SCRIPTS_PATH + "poller.py";
		this.l_desc = "Script for polling parallel runs to check completion.";
		this.output_desc = "No output created.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("List of Files File", "-f", Option.PATH, "Path to file containing a list of files that must exist to declare a run complete [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(6);
		this.e_options.add(new Option("Complete Function", "-r", Option.INPUT, "Function which returns True when run is completed [default: qiime.parallel.poller.basic_check_run_complete_f]"));
		this.e_options.add(new Option("Post-Completion Function", "-p", Option.INPUT, "Function to be called when runs complete [default: qiime.parallel.poller.basic_process_run_results_f]"));
		this.e_options.add(new Option("Map File", "-m", Option.PATH, "Path to file containing a map of tmp filepaths which should be written to final output filepaths [default: None]"));
		this.e_options.add(new Option("Clean Up Function", "-c", Option.INPUT, "Function called after processing result [default: qiime.parallel.poller.basic_clean_up_f]"));
		this.e_options.add(new Option("Files to Clean Up", "-d", Option.PATH, 0, "List of files and directories to remove after run [default: None]"));
		this.e_options.add(new Option("Sleep Time", "-t", Option.NUM, "Time to wait between calls to status_callback_f (in seconds) [default: 3]"));
	
	}
}