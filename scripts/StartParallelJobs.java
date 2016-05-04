package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class StartParallelJobs extends Script {
	public static String title = "Start Parallel Jobs";
	public static String b_desc = "Starts multiple jobs in parallel on multicore or multiprocessor systems.";

	public StartParallelJobs() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/start_parallel_jobs.html";
		this.c_name = SCRIPTS_PATH + "start_parallel_jobs.py";
		this.l_desc = "This script is designed to start multiple jobs in parallel on systems with no queueing system, for example a multiple processor or multiple core laptop/desktop machine. This also serves as an example ‘cluster_jobs’ which users can use as a template to define scripts to start parallel jobs in their environment.";
		this.output_desc = "No output is created.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(0);
		// this.r_options.add(new Option());

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		this.e_options.add(new Option("Make Jobs", "-m", Option.INPUT, "Make the job files [default: None]"));
		this.e_options.add(new Option("Submit Jobs", "-s", Option.INPUT, "Submit the job files [default: None]"));
	
	}
}