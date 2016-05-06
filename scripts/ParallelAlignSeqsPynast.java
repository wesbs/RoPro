package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelAlignSeqsPynast extends Script {
	public static String title = "Parallel Align Sequences using Pynast";
	public static String b_desc = "Parallel sequence alignment using PyNAST";

	public ParallelAlignSeqsPynast() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_align_seqs_pynast.html";
		this.c_name = SCRIPTS_PATH + "parallel_align_seqs_pynast.py";
		this.l_desc = "A wrapper for the align_seqs.py PyNAST option, intended to make use of multicore/multiprocessor environments to perform analyses in parallel.";
		this.output_desc = "This results in a multiple sequence alignment (FASTA-formatted).";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "Path to the input fasta file"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to the output directory"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(13);
		this.e_options.add(new Option("Template File", "-t", Option.PATH, "Filepath for template alignment [default: /Users/caporaso/.virtualenvs/qiime/lib/python2.7/site-packages/qiime_default_reference/gg_13_8_otus/rep_set_aligned/`85_otus.py <./85_otus.html>`_nast.fasta]"));
		this.e_options.add(new Option("Method", "-a", Option.INPUT, "Method to use for pairwise alignments [default: uclust]"));
		this.e_options.add(new Option("Database", "-d", Option.PATH, "Database to blast against [default: created on-the-fly from template_alignment]"));
		this.e_options.add(new Option("Min Length", "-e", Option.NUM, "Minimum sequence length to include in alignment [default: 75% of the median input sequence length]"));
		this.e_options.add(new Option("Min Percent", "-p", Option.NUM, "Minimum percent sequence identity to closest blast hit to include sequence in alignment, expressed as a real number between 0 and 100 [default: 75.0]"));
		this.e_options.add(new Option("Num of Jobs", "-O", Option.NUM, "Number of jobs to start [default: 1]"));
		this.e_options.add(new Option("Retain Temporary Files?", "-R", Option.NOARG, "Retain temporary files after runs complete (useful for debugging) [default: False]"));
		this.e_options.add(new Option("Suppress Submit Jobs?", "-S", Option.NOARG, "Only split input and write commands file - don’t submit jobs [default: False]"));
		this.e_options.add(new Option("Poll Directly?", "-T", Option.NOARG, "Poll directly for job completion rather than running poller as a separate job. If -T is specified this script will not return until all jobs have completed. [default: False]"));
		this.e_options.add(new Option("Cluster Jobs Script", "-U", Option.PATH, "Path to cluster jobs script (defined in qiime_config) [default: start_parallel_jobs.py]"));
		this.e_options.add(new Option("Suppress Polling?", "-W", Option.NOARG, "Suppress polling of jobs and merging of results upon completion [default: False]"));
		this.e_options.add(new Option("Job Prefix", "-X", Option.INPUT, "Job prefix [default: descriptive prefix + random chars]"));
		this.e_options.add(new Option("Seconds to Sleep", "-Z", Option.NUM, "Number of seconds to sleep between checks for run completion when polling runs [default: 1]"));
	
	}
}