package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelPickOTUsUsearch61Ref extends Script {
	public static String title = "Parallel Pick OTUs using USearch61 Reference";
	public static String b_desc = "Parallel pick otus using usearch_ref";

	public ParallelPickOTUsUsearch61Ref() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_pick_otus_usearch61_ref.html";
		this.c_name = SCRIPTS_PATH + "parallel_pick_otus_usearch61_ref.py";
		this.l_desc = "This script works like the pick_otus.py script, but is intended to make use of multicore/multiprocessor environments to perform analyses in parallel.";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "Full path to input_fasta_fp"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to store output files"));
		this.r_options.add(new Option("Reference Collection", "-r", Option.PATH, "Full path to reference collection"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(17);
		this.e_options.add(new Option("Similarity", "-s", Option.NUM, "Sequence similarity threshold [default: 0.97]"));
		this.e_options.add(new Option("Reverse Strand Matching?", "-z", Option.NOARG, "Enable reverse strand matching for uclust, uclust_ref, usearch, usearch_ref, usearch61, or usearch61_ref otu picking, will double the amount of memory used. [default: False]"));
		this.e_options.add(new Option("Max Accepts", "--max_accepts", Option.NUM, "Max_accepts value to uclust and uclust_ref [default: 1]"));
		this.e_options.add(new Option("Max Rejects", "--max_rejects", Option.NUM, "Max_rejects value to uclust and uclust_ref [default: 8]"));
		this.e_options.add(new Option("Word Length", "--word_length", Option.NUM, "W value to uclust and uclust_ref [default: 8]"));
		this.e_options.add(new Option("Min Length", "--minlen", Option.NUM, "Minimum length of sequence allowed for usearch, usearch_ref, usearch61, and usearch61_ref. [default: 64]"));
		this.e_options.add(new Option("Fast Cluster?", "--usearch_fast_cluster", Option.NOARG, "Use fast clustering option for usearch or usearch61_ref with new clusters. –enable_rev_strand_match can not be enabled with this option, and the only valid option for usearch61_sort_method is ‘length’. This option uses more memory than the default option for de novo clustering. [default: False]"));
		List<String> selects = new ArrayList<String>();
		selects.add("abundance");
		selects.add("length");
		selects.add("None");
		this.e_options.add(new Option("Sort Method", "--usearch61_sort_method", Option.SELECT, selects, 0, "Sorting method for usearch61 and usearch61_ref. Valid options are abundance, length, or None. If the –usearch_fast_cluster option is enabled, the only sorting method allowed in length. [default: abundance]"));
		this.e_options.add(new Option("Size Order?", "--sizeorder", Option.NOARG, "Enable size based preference in clustering with usearch61. Requires that –usearch61_sort_method be abundance. [default: False]"));
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