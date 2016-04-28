package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelAssignTaxUclust extends Script {
	public static String title = "Parallel Assign Taxonomy using Uclust"
	public static String b_desc = "Parallel taxonomy assignment using the uclust consensus taxonomy assignment";

	public ParallelAssignTaxUclust() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_assign_taxonomy_uclust.html";
		this.c_name = SCRIPTS_PATH + "parallel_assign_taxonomy_uclust.py";
		this.l_desc = "This script performs like the assign_taxonomy.py script, but is intended to make use of multicore/multiprocessor environments to perform analyses in parallel.";
		this.output_desc = "Mapping of sequence identifiers to taxonomy and quality information.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "Full path to fasta file containing query sequences [REQUIRED]"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to store output files [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(13);
		this.e_options.add(new Option("Mapping File", "-t", Option.PATH, "Full path to id_to_taxonomy mapping file [default: /Users/caporaso/.virtualenvs/qiime/lib/python2.7/site-packages/qiime_default_reference/gg_13_8_otus/taxonomy/97_otu_taxonomy.txt]"));
		this.e_options.add(new Option("Reference Sequence File", "-r", Option.PATH, "Ref seqs to search against. [default: /Users/caporaso/.virtualenvs/qiime/lib/python2.7/site-packages/qiime_default_reference/gg_13_8_otus/rep_set/97_otus.fasta]"));
		this.e_options.add(new Option("Min Fraction", "--min_consensus_fraction", Option.NUM, "Minimum fraction of database hits that must have a specific taxonomic assignment to assign that taxonomy to a query [default: 0.51]"));
		this.e_options.add(new Option("Similarity", "--similarity", Option.NUM, "Minimum percent similarity to consider a database match a hit, expressed as a fraction between 0 and 1 [default: 0.9]"));
		this.e_options.add(new Option("Max Accepts", "--uslcust_max_accepts", Option.NUM, "Number of database hits to consider when making an assignment [default: 3]"));
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

