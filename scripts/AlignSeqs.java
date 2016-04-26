package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class AlignSeqs extends Script {
	public static String title = "Align Sequences";
	public static String b_desc = "Align sequences using a variety of alignment methods";
	
	public AlignSeqs() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/align_seqs.html";
		this.c_name = SCRIPTS_PATH + "align_seqs.py";
		this.l_desc = "This script aligns the sequences in a FASTA file to each other or to a template sequence alignment, depending on the method chosen. Currently, there are three methods which can be used by the user:<br>1.PyNAST (Caporaso et al., 2009) - The default alignment method is PyNAST, a python implementation of the NAST alignment algorithm. The NAST algorithm aligns each provided sequence (the “candidate” sequence) to the best-matching sequence in a pre-aligned database of sequences (the “template” sequence). Candidate sequences are not permitted to introduce new gap characters into the template database, so the algorithm introduces local mis-alignments to preserve the existing template sequence.<br>2.MUSCLE (Edgar, 2004) - MUSCLE is an alignment method which stands for MUltiple Sequence Comparison by Log-Expectation.<br>3.INFERNAL (Nawrocki, Kolbe, & Eddy, 2009) - Infernal (“INFERence of RNA ALignment”) is for an alignment method for using RNA structure and sequence similarities.";
		this.output_desc = "All aligners will output a fasta file containing the alignment and log file in the directory specified by --output_dir (default <alignment_method>_aligned). PyNAST additionally outputs a failures file, containing the sequences which failed to align. So the result of align_seqs.py will be up to three files, where the prefix of each file depends on the user supplied FASTA file:<br>1.”..._aligned.fasta” - This is a FASTA file containing all aligned sequences.<br>2.”..._failures.fasta” - This is a FASTA file containing all sequences which did not meet all the criteria specified. (PyNAST only)<br>3.”..._log.txt” - This is a log file containing information pertaining to the results obtained from a particular method (e.g. BLAST percent identity, etc.).";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Input FASTA File", "-i", Option.PATH, "Path to the input fasta file"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(8);
		List<String> selects = new ArrayList<String>();
		selects.add("pynast");
		selects.add("infernal");
		selects.add("clustalw");
		selects.add("muscle");
		selects.add("mafft");
		this.e_options.add(new Option("Aligning Method", "-m", Option.SELECT, selects, 0, "Method for aligning sequences. Valid choices are: pynast, infernal, clustalw, muscle, infernal, mafft [default: pynast]"));
		List<String> selects2 = new ArrayList<String>();
		selects2.add("muscle");
		selects2.add("pair_hmm");
		selects2.add("clustal");
		selects2.add("blast");
		selects2.add("uclust");
		selects2.add("mafft");
		this.e_options.add(new Option("Pairwaise Method", "-a", Option.SELECT, selects2, 4, "Method for performing pairwise alignment in PyNAST. Valid choices are muscle, pair_hmm, clustal, blast, uclust, mafft [default: uclust]"));
		this.e_options.add(new Option("Template Alignment", "-t", Option.PATH, "Filepath for template alignment [default: /Users/caporaso/.virtualenvs/qiime/lib/python2.7/site-packages/qiime_default_reference/gg_13_8_otus/rep_set_aligned/`85_otus.py <./85_otus.html>`_nast.fasta]"));
		this.e_options.add(new Option("Min Sequence Length", "-e", Option.NUM, "Minimum sequence length to include in alignment [default: 75% of the median input sequence length]"));
		this.e_options.add(new Option("Min Percent", "-p", Option.NUM, "Minimum percent sequence identity to closest blast hit to include sequence in alignment [default: 0.75]"));
		this.e_options.add(new Option("Database", "-d", Option.INPUT, "Database to blast against when -m pynast [default: created on-the-fly from template_alignment]"));
		this.e_options.add(new Option("Max Memory", "--muscle_max_memory", Option.NUM, "Maximum memory allocation for the muscle alignment method (MB) [default: 80% of available memory, as detected by MUSCLE]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to store result file [default: <ALIGNMENT_METHOD>_aligned]"));
	
	}
}