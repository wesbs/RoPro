package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class StartParallelJobsSlurm extends Script {
	public static String title = "Start Parallel Jobs Slurm";
	public static String b_desc = "Starts multiple jobs in parallel on slurm based multiprocessor systems.";

	public StartParallelJobsSlurm() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/start_parallel_jobs_slurm.html";
		this.c_name = SCRIPTS_PATH + "start_parallel_jobs_slurm.py";
		this.l_desc = "This script is designed to start multiple jobs in parallel on cluster systems with a slurm based scheduling system.";
		this.output_desc = "No output is created.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(0);
		// this.r_options.add(new Option());

		// set up the extra options
		this.e_options = new ArrayList<Option>(6);
		this.e_options.add(new Option("Make Jobs", "-m", Option.INPUT, "Make the job files [default: None]"));
		this.e_options.add(new Option("Submit Jobs", "-s", Option.INPUT, "Submit the job files [default: None]"));
		this.e_options.add(new Option("Queue Name", "-q", Option.INPUT, "The queue to submit jobs to [default: all.q]"));
		this.e_options.add(new Option("Megabytes Per CPU", "-K", Option.NUM, "Megabytes of memory to request per CPU [default: slurm’s default]"));
		this.e_options.add(new Option("Job Directory", "-j", Option.PATH, "Directory to store the jobs [default: jobs/]"));
		this.e_options.add(new Option("Time Limit", "-t", Option.INPUT, "Run time limit of the jobs in dd-hh:mm:ss format [default: slurm’s default]"));
	
	}
}