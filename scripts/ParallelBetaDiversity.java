package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelBetaDiversity extends Script {
	public static String title = "Parallel Beta Diversity";
	public static String b_desc = "Parallel beta diversity";

	public ParallelBetaDiversity() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_beta_diversity.html";
		this.c_name = SCRIPTS_PATH + "parallel_beta_diversity.py";
		this.l_desc = "This script performs like the beta_diversity.py script, but is intended to make use of multicore/multiprocessor environments to perform analyses in parallel.";
		this.output_desc = "The output of parallel_beta_diversity.py is a folder containing text files, each a distance matrix between samples.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input Path", "-i", Option.PATH, "Input path, must be directory [REQUIRED]"));
		this.r_options.add(new Option("Output Path", "-o", Option.PATH, "Output path, must be directory [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(11);
		this.e_options.add(new Option("Metrics", "-m", Option.INPUT, "Beta-diversity metric(s) to use. A comma-separated list should be provided when multiple metrics are specified. [default: unweighted_unifrac,weighted_unifrac]"));
		this.e_options.add(new Option("Tree File", "-t", Option.PATH, "Path to newick tree file, required for phylogenetic metrics [default: None]"));
		this.e_options.add(new Option("Retain Temporary Files?", "-R", Option.NOARG, "Retain temporary files after runs complete (useful for debugging) [default: False]"));
		this.e_options.add(new Option("Suppress Submit Jobs?", "-S", Option.NOARG, "Only split input and write commands file - don’t submit jobs [default: False]"));
		this.e_options.add(new Option("Poll Directly?", "-T", Option.NOARG, "Poll directly for job completion rather than running poller as a separate job. If -T is specified this script will not return until all jobs have completed. [default: False]"));
		this.e_options.add(new Option("Cluster Jobs Script", "-U", Option.PATH, "Path to cluster jobs script (defined in qiime_config) [default: start_parallel_jobs.py]"));
		this.e_options.add(new Option("Suppress Polling?", "-W", Option.NOARG, "Suppress polling of jobs and merging of results upon completion [default: False]"));
		this.e_options.add(new Option("Job Prefix", "-X", Option.INPUT, "Job prefix [default: descriptive prefix + random chars]"));
		this.e_options.add(new Option("Seconds to Sleep", "-Z", Option.NUM, "Number of seconds to sleep between checks for run completion when polling runs [default: 1]"));
		this.e_options.add(new Option("Jobs to Start", "-O", Option.NUM, "Number of jobs to start [default: 1]"));
		this.e_options.add(new Option("Full Tree?", "-f", Option.NOARG, "By default, each job removes calls _fast_unifrac_setup to remove unused parts of the tree. pass -f if you already have a minimal tree, and this script will run faster"));
	
	}
}