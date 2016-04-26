package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class JackknifedBetaDiv extends Script {
	public static String title = "Jackknifed Beta Diversity";
	public static String b_desc = "A workflow script for performing jackknifed UPGMA clustering and building jackknifed Emperor PCoA plots.";

	public JackknifedBetaDiv() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/jackknifed_beta_diversity.html";
		this.c_name = SCRIPTS_PATH + "jackknifed_beta_diversity.py";
		this.l_desc = "To directly measure the robustness of individual UPGMA clusters and clusters in PCoA plots, one can perform jackknifing (repeatedly resampling a subset of the available data from each sample).";
		this.output_desc = "This scripts results in several distance matrices (from beta_diversity.py), several rarefied OTU tables (from multiple_rarefactions_even_depth.py), several UPGMA trees (from upgma_cluster.py), a supporting file and newick tree with support values (from tree_compare.py), and Emperor PCoA plots.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(4);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "The input OTU table in biom format [REQUIRED]"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output directory [REQUIRED]"));
		this.r_options.add(new Option("Num of Sequences", "-e", Option.NUM, "Number of sequences to include in each jackknifed subset [REQUIRED]"));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "Path to the mapping file [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(7);
		this.e_options.add(new Option("Tree File", "-t", Option.PATH, "Path to the tree file [default: None; REQUIRED for phylogenetic measures]"));
		this.e_options.add(new Option("Parameter File", "-p", Option.PATH, "Path to the parameter file, which specifies changes to the default behavior. See http://www.qiime.org/documentation/file_formats.html#qiime-parameters . [if omitted, default values will be used]"));
		List<String> selects = new ArrayList<String>();
		selects.add("consensus");
		selects.add("full");
		this.e_options.add(new Option("Master Tree Method", "--master_tree", Option.SELECT, selects, 0, "Method for computing master trees in jackknife analysis. “consensus”: consensus of trees from jackknifed otu tables. “full”: tree generated from input (unsubsambled) otu table. [default: consensus]"));
		this.e_options.add(new Option("Force Overwrite?", "-f", Option.NOARG, "Force overwrite of existing output directory (note: existing files in output_dir will not be removed) [default: None]"));
		this.e_options.add(new Option("Print Only?", "-w", Option.NOARG, "Print the commands but don’t call them – useful for debugging [default: False]"));
		this.e_options.add(new Option("Parallel?", "-a", Option.NOARG, "Run in parallel where available [default: False]"));
		this.e_options.add(new Option("Num of Jobs", "-O", Option.NUM, "Number of jobs to start. NOTE: you must also pass -a to run in parallel, this defines the number of jobs to be started if and only if -a is passed [default: 1]"));
	
	}
}