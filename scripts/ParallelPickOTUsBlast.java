package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelPickOTUsBlast extends Script {
	public static String title = "Parallel Pick OTUs using BLAST";
	public static String b_desc = "Parallel pick otus using BLAST";

	public ParallelPickOTUsBlast() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_pick_otus_blast.html";
		this.c_name = SCRIPTS_PATH + "parallel_pick_otus_blast.py";
		this.l_desc = "This script performs like the pick_otus.py script, but is intended to make use of multicore/multiprocessor environments to perform analyses in parallel.";
		this.output_desc = "The output consists of two files (i.e. seqs_otus.txt and seqs_otus.log). The .txt file is composed of tab-delimited lines, where the first field on each line corresponds to an (arbitrary) cluster identifier, and the remaining fields correspond to sequence identifiers assigned to that cluster. Sequence identifiers correspond to those provided in the input FASTA file. The resulting .log file contains a list of parameters passed to this script along with the output location of the resulting .txt file.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "Full path to input_fasta_fp"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to store output files"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(13);
		this.e_options.add(new Option("Max E-Value", "-e", Option.NUM, "Max E-value [default: 1e-10]"));
		this.e_options.add(new Option("Similarity", "-s", Option.NUM, "Sequence similarity threshold [default: 0.97]"));
		this.e_options.add(new Option("Template Alignment", "-r", Option.PATH, "Full path to template alignment [default: None]"));
		this.e_options.add(new Option("Blast Database", "-b", Option.PATH, "Full path to template alignment [default: None]"));
		this.e_options.add(new Option("Min Aligned Percent", "--min_aligned_percent", Option.NUM, "Minimum percent of query sequence that can be aligned to consider a hit, expressed as a fraction between 0 and 1 (BLAST OTU picker only) [default: 0.5]"));
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