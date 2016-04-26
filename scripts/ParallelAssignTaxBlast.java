package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelAssignTaxBlast extends Script {
	public static String title = "Parallel Assign Taxonomy using Blast";
	public static String b_desc = "Parallel taxonomy assignment using BLAST";

	public ParallelAssignTaxBlast() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_assign_taxonomy_blast.html";
		this.c_name = SCRIPTS_PATH + "parallel_assign_taxonomy_blast.py";
		this.l_desc = "This script performs like the assign_taxonomy.py script, but is intended to make use of multicore/multiprocessor environments to perform analyses in parallel.";
		this.output_desc = "Mapping of sequence identifiers to taxonomy and quality scores.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "Path to the input fasta file"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to the output directory"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(13);
		this.e_options.add(new Option("Reference Sequence File", "-r", Option.PATH, "Ref seqs to blast against. Must provide either –blast_db or –reference_seqs_db for assignment with blast [default: /Users/caporaso/.virtualenvs/qiime/lib/python2.7/site-packages/qiime_default_reference/gg_13_8_otus/rep_set/97_otus.fasta]"));
		this.e_options.add(new Option("Database", "-b", Option.PATH, "Database to blast against [default: created on-the-fly from template_alignment]"));
		this.e_options.add(new Option("Max E-Value", "-e", Option.NUM, "Maximum e-value to record an assignment, only used for blast method [default: 0.001]"));
		this.e_options.add(new Option("Blastmat File", "-B", Option.PATH, "Full path to directory containing blastmat file [default: None]"));
		this.e_options.add(new Option("Num of Jobs", "-O", Option.NUM, "Number of jobs to start [default: 1]"));
		this.e_options.add(new Option("Retain Temporary Files?", "-R", Option.NOARG, "Retain temporary files after runs complete (useful for debugging) [default: False]"));
		this.e_options.add(new Option("Suppress Submit Jobs?", "-S", Option.NOARG, "Only split input and write commands file - don’t submit jobs [default: False]"));
		this.e_options.add(new Option("Poll Directly?", "-T", Option.NOARG, "Poll directly for job completion rather than running poller as a separate job. If -T is specified this script will not return until all jobs have completed. [default: False]"));
		this.e_options.add(new Option("Cluster Jobs Script", "-U", Option.PATH, "Path to cluster jobs script (defined in qiime_config) [default: start_parallel_jobs.py]"));
		this.e_options.add(new Option("Suppress Polling?", "-W", Option.NOARG, "Suppress polling of jobs and merging of results upon completion [default: False]"));
		this.e_options.add(new Option("Job Prefix", "-X", Option.INPUT, "Job prefix [default: descriptive prefix + random chars]"));
		this.e_options.add(new Option("Seconds to Sleep", "-Z", Option.NUM, "Number of seconds to sleep between checks for run completion when polling runs [default: 1]"));
		this.e_options.add(new Option("Mapping File", "-t", Option.PATH, "Full path to id_to_taxonomy mapping file [default: /Users/caporaso/.virtualenvs/qiime/lib/python2.7/site-packages/qiime_default_reference/gg_13_8_otus/taxonomy/97_otu_taxonomy.txt]"));
	
	}
}



// package scripts;

// import java.io.*;
// import java.lang.String;
// import java.util.*;

// public class BlastWrapper extends Script {
// 	public static String title = 
// 	public static String b_desc = 

// 	public BlastWrapper() {
// 		// set up script name, command, and descriptions
// 		this.link = 
// 		this.c_name = SCRIPTS_PATH + 
// 		this.l_desc = 
// 		this.output_desc = 

// 		// set up the required otpions
// 		this.r_options = new ArrayList<Option>();
// 		this.r_options.add(new Option());

// 		// set up the extra options
// 		this.e_options = new ArrayList<Option>();
// 		this.e_options.add(new Option());
	
// 	}
// }