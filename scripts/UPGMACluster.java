package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class UPGMACluster extends Script {
	public static String title = "UPGMA Cluster";
	public static String b_desc = "Build a UPGMA tree comparing samples";

	public UPGMACluster() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/upgma_cluster.html";
		this.c_name = SCRIPTS_PATH + "upgma_cluster.py";
		this.l_desc = "In addition to using PCoA, it can be useful to cluster samples using UPGMA (Unweighted Pair Group Method with Arithmetic mean, also known as average linkage). As with PCoA, the input to this step is a distance matrix (i.e. resulting file from beta_diversity.py).";
		this.output_desc = "The output is a newick formatted tree compatible with most standard tree viewing programs. Batch processing is also available, allowing the analysis of an entire directory of distance matrices.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input Path", "-i", Option.PATH, "Input path. directory for batch processing, filename for single file operation"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output path. directory for batch processing, filename for single file operation"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(0);
		// this.e_options.add(new Option());
	
	}
}