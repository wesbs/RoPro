package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelPickOTUsSortmerna extends Script {
	public static String title = "Parallel Pick OTUs using Sortmerna";
	public static String b_desc = "Parallel pick otus using SortMeRNA";

	public ParallelPickOTUsSortmerna() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_pick_otus_sortmerna.html";
		this.c_name = SCRIPTS_PATH + "parallel_pick_otus_sortmerna.py";
		this.l_desc = "This script works like the pick_otus.py script, but is intended to make use of multicore/multiprocessor environments to perform analyses in parallel.";
		this.output_desc = "The output consists of two files (i.e. seqs_otus.txt and seqs_otus.log). The .txt file is composed of tab-delimited lines, where the first field on each line corresponds to an OTU identifier which is the reference sequence identifier, and the remaining fields correspond to sequence identifiers assigned to that OTU. The resulting .log file contains a list of parameters passed to this script along with the output location of the resulting .txt file.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "Path to input fasta file."));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Directory where output should be written."));
		this.r_options.add(new Option("reference File", "-r", Option.PATH, "Path to reference fasta file."));

		// set up the extra options
		this.e_options = new ArrayList<Option>(16);
		this.e_options.add(new Option("Similarity", "-s", Option.NUM, "Sequence similarity threshold [default: 0.97]"));
		this.e_options.add(new Option("Sortmerna Database", "--sortmerna_db", Option.PATH, "Pre-existing database to search against when using -m sortmerna [default: None]"));
		this.e_options.add(new Option("Max E-Value", "--sortmerna_e_value", Option.NUM, "Maximum E-value when clustering [default = 1]"));
		this.e_options.add(new Option("Min Percent", "--sortmerna_coverage", Option.NUM, "Mininum percent query coverage (of an alignment) to consider a hit, expressed as a fraction between 0 and 1 [default: 0.97]"));
		this.e_options.add(new Option("Tabular?", "--sortmerna_tabular", Option.NOARG, "Output alignments in the Blast-like tabular format with two additional columns including the CIGAR string and the percent query coverage [default: False]"));
		this.e_options.add(new Option("Alignments Per Read", "--sortmerna_best_N_alignments", Option.NUM, "Must be set together with –sortmerna_tabular. This option specifies how many alignments per read will be written [default: 1]"));
		this.e_options.add(new Option("Max Positions", "--sortmerna_max_pos", Option.NUM, "The maximum number of positions per seed to store in the indexed database [default: 10000]"));
		this.e_options.add(new Option("Num of Threads", "--threads", Option.NUM, "Specify the number of threads to use per job. Use –jobs_to_start to specify the number of jobs.[default: 1]"));
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