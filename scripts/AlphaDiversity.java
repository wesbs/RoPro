package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class AlphaDiversity extends Script {
		public static String title = "Alpha Diversity";
		public static String b_desc = "Calculate alpha diversity on each sample in an otu table, using a variety of alpha diversity metrics";

	public AlphaDiversity() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/alpha_diversity.html";
		this.c_name = SCRIPTS_PATH + "alpha_diversity.py";
		this.l_desc = "This script calculates alpha diversity, or within-sample diversity, using an OTU table. The QIIME pipeline allows users to conveniently calculate more than two dozen different diversity metrics. The full list of available metrics is available by passing the -s option to this script.<br><br>Documentation of the metrics can be found at http://scikit-bio.org/docs/latest/generated/skbio.diversity.alpha.html. Every metric has different strengths and limitations - technical discussion of each metric is readily available online and in ecology textbooks, but is beyond the scope of this document.";
		this.output_desc = "The resulting file(s) is a tab-delimited text file, where the columns correspond to alpha diversity metrics and the rows correspond to samples and their calculated diversity measurements. When a folder is given as input (-i), the script processes every otu table file in the given folder, and creates a corresponding file in the output directory.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(0); // no required options

		// set up the extra options
		this.e_options = new ArrayList<Option>(5);
		this.e_options.add(new Option("Input OTU Table", "-i", Option.PATH, "Input OTU table filepath or input directory containing OTU tables for batch processing. [default: None]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Output filepath to store alpha diversity metric(s) for each sample in a tab-separated format or output directory when batch processing. [default: None]"));
		this.e_options.add(new Option("Aplha Metric", "-m", Option.LIST, "Alpha-diversity metric(s) to use. A comma-separated list should be provided when multiple metrics are specified. [default: PD_whole_tree,chao1,observed_otus]"));
		this.e_options.add(new Option("Show Metrics", "-s", Option.NOARG, "Show the available alpha-diversity metrics and exit."));
		this.e_options.add(new Option("Tree File", "-t", Option.PATH, "Input newick tree filepath. [default: None; REQUIRED for phylogenetic metrics]"));
	
	}
}
