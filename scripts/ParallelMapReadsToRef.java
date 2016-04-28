package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelMapReadsToRef extends Script {
	public static String title = "Parallel Map Reads to Reference"; 
	public static String b_desc = "No Description";

	public ParallelMapReadsToRef() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_map_reads_to_reference.html";
		this.c_name = SCRIPTS_PATH + "parallel_map_reads_to_reference.py";
		this.l_desc = "No Description";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Sequences File", "-i", Option.PATH, "Path to input sequences file"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Directory to store results"));
		this.r_options.add(new Option("Reference Sequences", "-r", Option.PATH, "Path to reference sequences"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(17);
		this.e_options.add(new Option("Observation Metadata", "-t", Option.PATH, "Path to observation metadata (e.g., taxonomy, EC, etc) [default: None]"));
		List<String> selects = new ArrayList<String>();
		selects.add("usearch");
		selects.add("blat");
		selects.add("bwa-short");
		this.e_options.add(new Option("OTU Picking Method", "-m", Option.SELECT, selects, 0, "Method for picking OTUs. Valid choices are: usearch blat bwa-short. [default: usearch]"));
		this.e_options.add(new Option("Max E-Value", "-e", Option.NUM, "Max e-value to consider a match [default: 1e-10]"));
		this.e_options.add(new Option("Min Percent ID", "-s", Option.NUM, "Min percent id to consider a match, expressed as a fraction between 0 and 1 [default: 0.75]"));
		this.e_options.add(new Option("MaxDiff", "--max_diff", Option.NUM, "MaxDiff to consider a match (applicable for -m bwa) – see the aln section of “man bwa” for details [default (defined by bwa): 0.04]"));
		this.e_options.add(new Option("Query Percent", "--queryalnfract", Option.NUM, "Min percent of the query seq that must match to consider a match, expressed as a fraction between 0 and 1 (usearch only) [default: 0.35]"));
		this.e_options.add(new Option("Reference Percent", "--targetalnfract", Option.NUM, "Min percent of the target/reference seq that must match to consider a match, expressed as a fraction between 0 and 1 (usearch only) [default: 0.0]"));
		this.e_options.add(new Option("Max Accepts", "--max_accepts", Option.NUM, "Max_accepts value (usearch only) [default: 1]"));
		this.e_options.add(new Option("Max Rejects", "--max_rejects", Option.NUM, "Max_rejects value to (usearch only) [default: 32]"));
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