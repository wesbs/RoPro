package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ClusterQuality extends Script {
	public static String title = "Cluster Quality";
	public static String b_desc = "compute the quality of a cluster";

	public ClusterQuality() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/cluster_quality.html";
		this.c_name = SCRIPTS_PATH + "cluster_quality.py";
		this.l_desc = "The input is a distance matrix (i.e. resulting file from beta_diversity.py).";
		this.output_desc = "The output is either a single number (with -s), or a more detailed output of the similarity between and within clusters.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Input Distance Matrix", "-i", Option.PATH, "Input distance matrix file"));
		this.r_options.add(new Option("Input Mapping File", "-m", Option.PATH, "Mapping file"));
		this.r_options.add(new Option("Cluster Column", "-c", Option.INPUT, "Column of mapping file delimiting clusters"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Output path, prints to stdout if omitted"));
		this.e_options.add(new Option("Print Only Ratios?", "-s", Option.NOARG, "Print only the ratio of mean dissimilarities between/within clusters instead of more detailed output"));
		List<String> selects = new ArrayList<String>(1);
		selects.add("ratio");
		this.e_options.add(new Option("Metric", "-m", Option.SELECT, selects, 0, "Choice of quality metric to apply. Currently only one option exists, the ratio of mean(distances between samples from different clusters) to mean(distances between samples from the same cluster) Default: ratio"));
	}
}