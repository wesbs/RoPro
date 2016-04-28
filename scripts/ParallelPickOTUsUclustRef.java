package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelPickOTUsUclustRef extends Script {
	public static String title = "Parallel Pick OTUs using Uclust Reference";
	public static String b_desc = "Parallel pick otus using uclust_ref";

	public ParallelPickOTUsUclustRef() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_pick_otus_uclust_ref.html";
		this.c_name = SCRIPTS_PATH + "parallel_pick_otus_uclust_ref.py";
		this.l_desc = "This script works like the pick_otus.py script, but is intended to make use of multicore/multiprocessor environments to perform analyses in parallel.";
		this.output_desc = "The output consists of two files (i.e. seqs_otus.txt and seqs_otus.log). The .txt file is composed of tab-delimited lines, where the first field on each line corresponds to an OTU identifier which is the reference sequence identifier, and the remaining fields correspond to sequence identifiers assigned to that OTU. The resulting .log file contains a list of parameters passed to this script along with the output location of the resulting .txt file.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "Full path to input_fasta_fp"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to store output files"));
		this.r_options.add(new Option("Refernece Collection", "-r", Option.PATH, "Full path to reference collection"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(20);
		this.e_options.add(new Option("Similarity", "-s", Option.NUM, "Sequence similarity threshold [default: 0.97]"));
		this.e_options.add(new Option("Reverse Strand MAtching?", "-z", Option.NOARG, "Enable reverse strand matching for uclust otu picking, will double the amount of memory used. [default: False]"));
		this.e_options.add(new Option("Optimal Uclust?", "-A", Option.NOARG, "Pass the –optimal flag to uclust for uclust otu picking. [default: False]"));
		this.e_options.add(new Option("Exact Uclust?", "-e", Option.NOARG, "Pass the –exact flag to uclust for uclust otu picking. [default: False]"));
		this.e_options.add(new Option("Max Accepts", "--max_accepts", Option.NUM, "Max_accepts value to uclust and uclust_ref [default: 1]"));
		this.e_options.add(new Option("Max Rejects", "--max_rejects", Option.NUM, "Max_rejects value to uclust and uclust_ref [default: 8]"));
		this.e_options.add(new Option("Stepwords Value", "--stepwords", Option.NUM, "Stepwords value to uclust and uclust_ref [default: 8]"));
		this.e_options.add(new Option("Word Length", "--word_length", Option.NUM, "W value to uclust and uclust_ref [default: 8]"));
		this.e_options.add(new Option("Stable Sort?", "--uclust_stable_sort", Option.NOARG, true, "Deprecated: stable sort enabled by default, pass –uclust_suppress_stable_sort to disable [default: True]"));
		this.e_options.add(new Option("Suppress Stable Sort?", "--suppress_uclust_stable_sort", Option.NOARG, "Don’t pass –stable-sort to uclust [default: False]"));
		this.e_options.add(new Option("Save UC Files?", "-d", Option.NOARG, true, "Enable preservation of intermediate uclust (.uc) files that are used to generate clusters via uclust. [default: True]"));
		this.e_options.add(new Option("OTU Identifier Prefix", "--denovo_otu_id_prefix", Option.INPUT, "OTU identifier prefix (string) for the de novo uclust OTU picker [default: None, OTU ids are ascending integers]"));
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