package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelMultipleRarefactions extends Script {
	public static String title = "Parallel Multiple Rarefactions";
	public static String b_desc = "Parallel multiple file rarefaction";

	public ParallelMultipleRarefactions() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_multiple_rarefactions.html";
		this.c_name = SCRIPTS_PATH + "parallel_multiple_rarefactions.py";
		this.l_desc = "This script performs like the multiple_rarefactions.py script, but is intended to make use of multicore/multiprocessor environments to perform analyses in parallel.";
		this.output_desc = "The result of parallel_multiple_rarefactions.py consists of a number of files, which depend on the minimum/maximum number of sequences per samples, steps and iterations. The files have the same otu table format as the input otu_table.biom, and are named in the following way: rarefaction_100_0.txt, where “100” corresponds to the sequences per sample and “0” for the iteration.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(4);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "Input filepath, (the otu table) [REQUIRED]"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Write output rarefied otu tables here makes dir if it doesn’t exist [REQUIRED]"));
		this.r_options.add(new Option("Min Sequences", "-m", Option.NUM, "Min seqs/sample [REQUIRED]"));
		this.r_options.add(new Option("Max Sequences", "-x", Option.NUM, "Max seqs/sample (inclusive) [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(12);
		this.e_options.add(new Option("Iterations", "-n", Option.NUM, "Num iterations at each seqs/sample level [default: 10]"));
		this.e_options.add(new Option("Suppress Lineage?", "--suppress_lineages_included", Option.NOARG, "Exclude taxonomic (lineage) information for each OTU."));
		this.e_options.add(new Option("Step Size", "-s", Option.NUM, "Levels: min, min+step... for level <= max [default: 1]"));
		this.e_options.add(new Option("Subsample Multinomial?", "--subsample_multinomial", Option.NOARG, "Subsample using subsampling with replacement [default: False]"));
		this.e_options.add(new Option("Retain Temporary Files?", "-R", Option.NOARG, "Retain temporary files after runs complete (useful for debugging) [default: False]"));
		this.e_options.add(new Option("Suppress Submit Jobs?", "-S", Option.NOARG, "Only split input and write commands file - don’t submit jobs [default: False]"));
		this.e_options.add(new Option("Poll Directly?", "-T", Option.NOARG, "Poll directly for job completion rather than running poller as a separate job. If -T is specified this script will not return until all jobs have completed. [default: False]"));
		this.e_options.add(new Option("Cluster Jobs Script", "-U", Option.PATH, "Path to cluster jobs script (defined in qiime_config) [default: start_parallel_jobs.py]"));
		this.e_options.add(new Option("Suppress Polling?", "-W", Option.NOARG, "Suppress polling of jobs and merging of results upon completion [default: False]"));
		this.e_options.add(new Option("Job Prefix", "-X", Option.INPUT, "Job prefix [default: descriptive prefix + random chars]"));
		this.e_options.add(new Option("Seconds to Sleep", "-Z", Option.NUM, "Number of seconds to sleep between checks for run completion when polling runs [default: 1]"));
		this.e_options.add(new Option("Jobs to Start", "-O", Option.NUM, "Number of jobs to start [default: 1]"));
	
	}
}