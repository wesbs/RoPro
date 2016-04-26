package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class BetaDiversity extends Script {

		public static String title = "Beta Diversity";
		public static String b_desc = "Calculate beta diversity (pairwise sample dissimilarity) on one or many otu tables";
	
	public BetaDiversity() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/beta_diversity.html";
		this.c_name = SCRIPTS_PATH + "beta_diversity.py";
		this.l_desc = "The input for this script is the OTU table containing the number of sequences observed in each OTU (rows) for each sample (columns). For more information pertaining to the OTU table refer to the documentation for make_otu_table. If the user would like phylogenetic beta diversity metrics using UniFrac, a phylogenetic tree must also be passed as input (see make_phylogeny.py). The output of this script is a distance matrix containing a dissimilarity value for each pairwise comparison.<br><br>A number of metrics are currently supported, including unweighted and weighted UniFrac (pass the -s option to see available metrics). In general, because unifrac uses phylogenetic information, one of the unifrac metrics is recommended, as results can be vastly more useful (Hamady & Knight, 2009). Quantitative measures (e.g. weighted unifrac) are ideally suited to revealing community differences that are due to changes in relative taxon abundance (e.g., when a particular set of taxa flourish because a limiting nutrient source becomes abundant). Qualitative measures (e.g. unweighted unifrac) are most informative when communities differ primarily by what can live in them (e.g., at high temperatures), in part because abundance information can obscure significant patterns of variation in which taxa are present (Lozupone et al., 2007). Most qualitative measures are referred to here e.g. “binary_jaccard”. Typically both weighted and unweighted unifrac are used.";
		this.output_desc = "Each file in the input directory should be an otu table, and the output of beta_diversity.py is a folder containing text files, each a distance matrix between samples corresponding to an input otu table.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(0);

		// set up the extra options
		this.e_options = new ArrayList<Option>(7);
		this.e_options.add(new Option("Input OTU Table", "-i", Option.PATH, "Input OTU table in biom format or input directory containing OTU tables in biom format for batch processing."));
		this.e_options.add(new Option("Rows", "-r", Option.INPUT, "Compute for only these rows of the distance matrix. User should pass a list of sample names (e.g. “s1,s3”) [default: None; full n x n matrix is generated]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Output directory. One will be created if it doesn’t exist."));
		this.e_options.add(new Option("Beta Metrics", "-m", Option.INPUT, "Beta-diversity metric(s) to use. A comma-separated list should be provided when multiple metrics are specified. [default: unweighted_unifrac,weighted_unifrac]"));
		this.e_options.add(new Option("Show Metrics?", "-s", Option.NOARG, "Show the available beta-diversity metrics and exit. Metrics starting with “binary...” specifies that a metric is qualitative, and considers only the presence or absence of each taxon [default: False]"));
		this.e_options.add(new Option("Tree File", "-t", Option.PATH, "Input newick tree filepath, which is required when phylogenetic metrics are specified. [default: None]"));
		this.e_options.add(new Option("Full Tree", "-f", Option.PATH, "By default, tips not corresponding to OTUs in the OTU table are removed from the tree for diversity calculations. Pass to skip this step if you’re already passing a minimal tree. Beware with “full_tree” metrics, as extra tips in the tree change the result"));
	
	}
}