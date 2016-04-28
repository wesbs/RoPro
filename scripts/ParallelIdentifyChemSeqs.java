package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelIdentifyChemSeqs extends Script {
	public static String title = "Parallel Identify Chermeric Sequences";
	public static String b_desc = "Parallel chimera detection";

	public ParallelIdentifyChemSeqs() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_identify_chimeric_seqs.html";
		this.c_name = SCRIPTS_PATH + "parallel_identify_chimeric_seqs.py";
		this.l_desc = "This script works like the identify_chimeric_seqs.py script, but is intended to make use of multicore/multiprocessor environments to perform analyses in parallel.";
		this.output_desc = "The result of parallel_identify_chimeric_seqs.py is a text file that identifies which sequences are chimeric.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Input FASTA File", "-i", Option.PATH, "Path to the input fasta file"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(18);
		this.e_options.add(new Option("Aligned Reference Sequences", "-a", Option.PATH, "Path to (Py)Nast aligned reference sequences. REQUIRED when method ChimeraSlayer [default: /Users/caporaso/.virtualenvs/qiime/lib/python2.7/site-packages/qiime_default_reference/gg_13_8_otus/rep_set_aligned/`85_otus.py <./85_otus.html>`_nast.fasta]"));
		this.e_options.add(new Option("Taxonomy File", "-t", Option.PATH, "Path to tab-delimited file mapping sequences to assigned taxonomy. Each assigned taxonomy is provided as a comma-separated list. [default: None; REQUIRED when method is blast_fragments]"));
		this.e_options.add(new Option("Reference Sequences", "-r", Option.PATH, "Path to reference sequences (used to build a blast db when method blast_fragments). [default: None; REQUIRED when method blast_fragments if no blast_db is provided;]"));
		this.e_options.add(new Option("Blast Database", "-b", Option.PATH, "Database to blast against. Must provide either –blast_db or –reference_seqs_fp when method is blast_fragments [default: None]"));
		Lis<String> selects = new ArrayList<String>();
		selects.add("blast_fragments");
		selects.add("ChimeraSlayer");
		this.e_options.add(new Option("Detection Method", "-m", Option.SELECT, selects, 1, "Chimera detection method. Choices: blast_fragments or ChimeraSlayer. [default:ChimeraSlayer]"));
		this.e_options.add(new Option("Num of Fragments", "n", Option.NUM, "Number of fragments to split sequences into (i.e., number of expected breakpoints + 1) [default: 3]"));
		this.e_options.add(new Option("Taxonomy Depth", "-d", Option.NUM, "Number of taxonomic divisions to consider when comparing taxonomy assignments [default: 4]"));
		this.e_options.add(new Option("Max E-Value", "-e", Option.NUM, "Max e-value to assign taxonomy [default: 1e-30]"));
		this.e_options.add(new Option("Min Divergence Ratio", "--min_div_ratio", Option.NUM, "Min divergence ratio (passed to ChimeraSlayer). If set to None uses ChimeraSlayer default value. [default: None]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to store output [default: derived from input_seqs_fp]"));
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