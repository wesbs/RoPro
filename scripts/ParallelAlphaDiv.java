package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelAlphaDiv extends Script {
	public static String title = "Parallel Alpha Diversity";
	public static String b_desc = "Parallel alpha diversity";

	public ParallelAlphaDiv() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_alpha_diversity.html";
		this.c_name = SCRIPTS_PATH + "parallel_alpha_diversity.py";
		this.l_desc = "This script performs like the alpha_diversity.py script, but is intended to make use of multicore/multiprocessor environments to perform analyses in parallel.";
		this.output_desc = "The resulting output will be the same number of files as supplied by the user. The resulting files are tab-delimited text files, where the columns correspond to alpha diversity metrics and the rows correspond to samples and their calculated diversity measurements.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Input Path", "-i", Option.PATH, "Input path, must be directory [REQUIRED]"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output path, must be directory [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(10);
		this.e_options.add(new Option("Tree File", "-t", Option.PATH, "Path to newick tree file, required for phylogenetic metrics [default: None]"));
		this.e_options.add(new Option("Metrics", "-m", Option.INPUT, "Metrics to use, comma delimited"));
		this.e_options.add(new Option("Retain Temporary Files?", "-R", Option.NOARG, "Retain temporary files after runs complete (useful for debugging) [default: False]"));
		this.e_options.add(new Option("Suppress Submit Jobs?", "-S", Option.NOARG, "Only split input and write commands file - don’t submit jobs [default: False]"));
		this.e_options.add(new Option("Poll Directly?", "-T", Option.NOARG, "Poll directly for job completion rather than running poller as a separate job. If -T is specified this script will not return until all jobs have completed. [default: False]"));
		this.e_options.add(new Option("Cluster Jobs Script", "-U", Option.PATH, "Path to cluster jobs script (defined in qiime_config) [default: start_parallel_jobs.py]"));
		this.e_options.add(new Option("Suppress Polling?", "-W", Option.NOARG, "Suppress polling of jobs and merging of results upon completion [default: False]"));
		this.e_options.add(new Option("Job Prefix", "-X", Option.INPUT, "Job prefix [default: descriptive prefix + random chars]"));
		this.e_options.add(new Option("Seconds to Sleep", "-Z", Option.NUM, "Number of seconds to sleep between checks for run completion when polling runs [default: 1]"));
		this.e_options.add(new Option("Num of Jobs", "-O", Option.NUM, "Number of jobs to start [default: 1]"));
	
	}
}