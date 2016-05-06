package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelBlast extends Script {
	public static String title = "Parallel Blast";
	public static String b_desc = "Parallel BLAST";

	public ParallelBlast() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_blast.html";
		this.c_name = SCRIPTS_PATH + "parallel_blast.py";
		this.l_desc = "This script for performing blast while making use of multicore/multiprocessor environments to perform analyses in parallel.";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input Path", "-i", Option.PATH, "Path of sequences to use as queries [REQUIRED]"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path of sequences to use as queries [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(15);
		this.e_options.add(new Option("Disable Low Complexity Filter?", "-c", Option.NOARG, "Disable filtering of low-complexity sequences (i.e., -F F is passed to blast) [default: False]"));
		this.e_options.add(new Option("E-Value", "-e", Option.NUM, "E-value threshold for blasts [default: 1e-30]"));
		this.e_options.add(new Option("Num of Hits", "-n", Option.NUM, "Number of hits per query for blast results [default: 1]"));
		this.e_options.add(new Option("Word Size", "-w", Option.NUM, "Word size for blast searches [default: 30]"));
		this.e_options.add(new Option("Blastmat File", "-a", Option.PATH, "Full path to directory containing blastmat file [default: None]"));
		this.e_options.add(new Option("Reference Sequences", "-r", Option.PATH, "Path to fasta sequences to search against. Required if -b is not provided."));
		this.e_options.add(new Option("BLAST Database", "-b", Option.PATH, "Name of pre-formatted BLAST database. Required if -r is not provided."));
		this.e_options.add(new Option("Jobs to Start", "-O", Option.NUM, "Number of jobs to start [default: 1]"));
		this.e_options.add(new Option("Retain Temporary Files?", "-R", Option.NOARG, "Retain temporary files after runs complete (useful for debugging) [default: False]"));
		this.e_options.add(new Option("Suppress Submit Jobs?", "-S", Option.NOARG, "Only split input and write commands file - don’t submit jobs [default: False]"));
		this.e_options.add(new Option("Poll Directly?", "-T", Option.NOARG, "Poll directly for job completion rather than running poller as a separate job. If -T is specified this script will not return until all jobs have completed. [default: False]"));
		this.e_options.add(new Option("Cluster Jobs Script", "-U", Option.PATH, "Path to cluster jobs script (defined in qiime_config) [default: start_parallel_jobs.py]"));
		this.e_options.add(new Option("Suppress Polling?", "-W", Option.NOARG, "Suppress polling of jobs and merging of results upon completion [default: False]"));
		this.e_options.add(new Option("Job Prefix", "-X", Option.INPUT, "Job prefix [default: descriptive prefix + random chars]"));
		this.e_options.add(new Option("Seconds to Sleep", "-Z", Option.NUM, "Number of seconds to sleep between checks for run completion when polling runs [default: 1]"));
	
	}
}