package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class FilterAlignment extends Script {
	public static String title = "Filter Alignment";
	public static String b_desc = "Filter sequence alignment by removing highly variable regions";

	public FilterAlignment() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/filter_alignment.html";
		this.c_name = SCRIPTS_PATH + "filter_alignment.py";
		this.l_desc = "This script should be applied to generate a useful tree when aligning against a template alignment (e.g., with PyNAST). This script will remove positions which are gaps in every sequence (common for PyNAST, as typical sequences cover only 200-400 bases, and they are being aligned against the full 16S gene). Additionally, the user can supply a lanemask file, that defines which positions should included when building the tree, and which should be ignored. Typically, this will differentiate between non-conserved positions, which are uninformative for tree building, and conserved positions which are informative for tree building. FILTERING ALIGNMENTS WHICH WERE BUILT WITH PYNAST AGAINST THE GREENGENES CORE SET ALIGNMENT SHOULD BE CONSIDERED AN ESSENTIAL STEP.";
		this.output_desc = "The output of filter_alignment.py consists of a single FASTA file, which ends with “pfiltered.fasta”, where the “p” stands for positional filtering of the columns.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Input FASTA", "-i", Option.PATH, "The input fasta file containing the alignment"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(7);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "The output directory [default: .]"));
		this.e_options.add(new Option("Lase Mask", "-m", Option.PATH, "Path to lane mask file [default: 16S alignment lane mask (Lane, D.J. 1991)]"));
		this.e_options.add(new Option("Suppress Lane Mask?", "-s", Option.NOARG, "Path to lane mask file [default: 16S alignment lane mask (Lane, D.J. 1991)]"));
		this.e_options.add(new Option("Allowed Gap", "-g", Option.NUM, "Gap filter threshold, filters positions which are gaps in > allowed_gap_frac of the sequences [default: 0.999999]"));
		this.e_options.add(new Option("Remove Outliers", "-r", Option.NOARG, "Remove seqs very dissimilar to the alignment consensus (see –threshold). [default: False]"));
		this.e_options.add(new Option("Threshold", "-t", Option.NUM, "With -r, remove seqs whose dissimilarity to the consensus sequence is approximately > x standard deviations above the mean of the sequences [default: 3.0]"));
		this.e_options.add(new Option("Entropy Threshold", "-e", Option.NUM, "Percent threshold for removing base positions with the highest entropy, expressed as a fraction between 0 and 1. For example, if 0.10 were specified, the top 10% most entropic base positions would be filtered. If this value is used, any lane mask supplied will be ignored. Entropy filtering occurs after gap filtering. [default: None]"));
	
	}
}