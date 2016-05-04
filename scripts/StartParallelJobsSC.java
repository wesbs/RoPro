package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class StartParallelJobsSC extends Script {
	public static String title = "Start Parallel Jobs SC";
	public static String b_desc = "Starts parallel jobs on Sun GridEngine queueing systems.";

	public StartParallelJobsSC() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/start_parallel_jobs_sc.html";
		this.c_name = SCRIPTS_PATH + "start_parallel_jobs_sc.py";
		this.l_desc = "Starts multiple jobs in parallel on Sun GridEngine systems. This is designed to work with StarCluster EC2 instances, but may be applicable beyond there.";
		this.output_desc = "No output is created.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(0);
		// this.r_options.add(new Option());

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Make Jobs", "-m", Option.INPUT, "Make the job files [default: None]"));
		this.e_options.add(new Option("Submit Jobs", "-s", Option.INPUT, "Submit the job files [default: None]"));
		this.e_options.add(new Option("Queue Name", "-q", Option.INPUT, "The queue to submit jobs to [default: all.q]"));
	
	}
}