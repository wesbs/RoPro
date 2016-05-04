package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class StartParallelJobsTorque extends Script {
	public static String title = "Start Parallel Jobs Torque";
	public static String b_desc = "Starts multiple jobs in parallel on torque/qsub based multiprocessor systems.";

	public StartParallelJobsTorque() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/start_parallel_jobs_torque.html";
		this.c_name = SCRIPTS_PATH + "start_parallel_jobs_torque.py";
		this.l_desc = "This script is designed to start multiple jobs in parallel on cluster systems with a torque/qsub based scheduling system.";
		this.output_desc = "No output is created.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(0);
		// this.r_options.add(new Option());

		// set up the extra options
		this.e_options = new ArrayList<Option>(7);
		this.e_options.add(new Option("Make Jobs", "-m", Option.INPUT, "Make the job files [default: None]"));
		this.e_options.add(new Option("Submit Jobs", "-s", Option.INPUT, "Submit the job files [default: None]"));
		this.e_options.add(new Option("Queue Name", "-q", Option.INPUT, "The queue to submit jobs to [default: all.q]"));
		this.e_options.add(new Option("Job Directory", "-j", Option.PATH, "Directory to store the jobs [default: jobs/]"));
		this.e_options.add(new Option("Max Time", "-w", Option.NUM, "Maximum time in hours the job will run for [default: 72]"));
		this.e_options.add(new Option("Num of CPUs", "-c", Option.NUM, "Number of CPUs to use [default:1]"));
		this.e_options.add(new Option("Num of Nodes", "-n", Option.NUM, "Number of nodes to use [default:1]"));
	
	}
}