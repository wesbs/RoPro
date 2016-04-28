package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class BlastWrapper extends Script {
	public static String title = "Parallel Pick OTUs using Trie";
	public static String b_desc = "Parallel pick otus using a trie";

	public BlastWrapper() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_pick_otus_trie.html";
		this.c_name = SCRIPTS_PATH + "parallel_pick_otus_trie.py";
		this.l_desc = "This script performs like the pick_otus.py script, but is intended to make use of multicore/multiprocessor environments to perform analyses in parallel. The script uses the first p bases of each read to sort all reads into separate buckets and then each buckets is processed separately. Note that in cases of amplicon sequencing we do not expect the buckets to be even sized, but rather a few buckets make up the majority of reads. Thus, not all combination of prefix length p and number of CPUS -O make sense. Good combinations for a small desktop multicore system would be -p 5 (default) and -O 4. For larger clusters, we suggest -p 10 and -O 20. Increasing -p to a value much larger than 10 will lead to lots of temporary files and many small jobs, so likely will not speed up the OTU picking. On the other hand, the max speed-up is bounded by the size of the largest buckets, so adding more cores will not always increase efficiency.";
		this.output_desc = "The output consists of two files (i.e. seqs_otus.txt and seqs_otus.log). The .txt file is composed of tab-delimited lines, where the first field on each line corresponds to an (arbitrary) cluster identifier, and the remaining fields correspond to sequence identifiers assigned to that cluster. Sequence identifiers correspond to those provided in the input FASTA file. The resulting .log file contains a list of parameters passed to this script along with the output location of the resulting .txt file.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "Full path to input_fasta_fp"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to store output files"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(9);
		this.e_options.add(new Option("Prefix Length", "-p", Option.NUM, "Prefix length used to split the input. Must be smaller than the shortest seq in input! [default: 5]"));
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