package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class FilterTree extends Script {
	public static String title = "Filter Tree";
	public static String b_desc = "This script prunes a tree based on a set of tip names";

	public FilterTree() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/filter_tree.html";
		this.c_name = SCRIPTS_PATH + "filter_tree.py";
		this.l_desc = "This script takes a tree and a list of OTU IDs (in one of several supported formats) and outputs a subtree retaining only the tips on the tree which are found in the inputted list of OTUs (or not found, if the –negate option is provided).";
		this.output_desc = "Output is a pruned tree in newick format.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input Tree", "-i", Option.PATH, "Input tree filepath"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output tree filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Negate?", "-n", Option.NOARG, "If negate is True will remove input tips/seqs, if negate is False, will retain input tips/seqs [default: False]"));
		this.e_options.add(new Option("Tips", "-t", Option.PATH, "A list of tips (one tip per line) or sequence identifiers (tab-delimited lines with a seq identifier in the first field) which should be retained [default: None]"));
		this.e_options.add(new Option("FASTA File", "-f", Option.PATH, "A fasta file where the seq ids should be retained [default: None]"));
	
	}
}