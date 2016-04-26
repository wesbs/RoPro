package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class IdentifyPairedDiff extends Script {
	public static String title = "Identify Paired Differences";
	public static String b_desc = "Generate plots and stats to test for change in some data point(s) with a state change on a per-individual basis.";

	public IdentifyPairedDiff() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/identify_paired_differences.html";
		this.c_name = SCRIPTS_PATH + "identify_paired_differences.py";
		this.l_desc = "This script provides a framework for paired-difference testing (i.e., analysis of data generated under a pre/post experimental design). In a pre/post experimental design, individuals are sampled before and after some ‘treatment’. This code plots differences in values in the sample metadata (i.e., the mapping file) or observation counts in a BIOM table, and runs a (Bonferroni-corrected) one sample t-test on each sample metadata category or BIOM observation to determine if the mean of each distribution of pre/post differences differs from zero. If ‘None’ appears for the t score and p-values, this often means that the distribution of differences contained no variance, so the t-test could not be run. This can happen, for example, if the value passed for –valid_states is so restrictive that only a single sample is retained for analysis.";
		this.output_desc = "The output of this script is plots of pre/post differences and associated statistics.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(5);
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "The input metadata map filepath"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Directory where output files should be saved"));
		this.r_options.add(new Option("Column", "-t", Option.INPUT, "The mapping file column name to plot change over (usually has values like “pre-treatment” and “post-treatment”)"));
		this.r_options.add(new Option("State Values", "-x", Option.INPUT, "Ordered list of state values to test change over (defines direction of graphs, generally something like “pre-treatment,post-treatment”). currently limited to two states."));
		this.r_options.add(new Option("Identifier Column", "-c", Option.INPUT, "The mapping file column name containing each individual’s identifier (usually something like “personal_identifier”)"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(7);
		this.e_options.add(new Option("Y-Axis Min", "--ymin", Option.NUM, "Set the minimum y-value across plots [default: determined on a per-plot basis]"));
		this.e_options.add(new Option("Y-Axis Max", "--ymax", Option.NUM, "Set the maximum y-value across plots [default: determined on a per-plot basis]"));
		this.e_options.add(new Option("Metadata Categories", "--metadata_categories", Option.INPUT, "Ordered list of the mapping file column names to test for paired differences (usually something like “StreptococcusAbundance,Phylogenetic Diversity”) [default: None]"));
		this.e_options.add(new Option("Observation IDs", "--observation_ids", Option.INPUT, "Ordered list of the observation ids to test for paired differences if a biom table is provided (usually something like “otu1,otu2”) [default: compute paired differences for all observation ids]"));
		this.e_options.add(new Option("Biom Table", "-b", Option.PATH, "Path to biom table to use for computing paired differences [default: None]"));
		this.e_options.add(new Option("Valid States", "-s", Option.INPUT, "String describing samples that should be included based on their metadata (e.g. ‘TreatmentResponse:Improved’) [default: all samples are included in analysis]"));
		this.e_options.add(new Option("Line Color", "--line_color", Option.INPUT, "Color of lines in plots, useful if generating multiple plots in different runs of this script to overlay on top of one another. these can be specified as matplotlib color names, or as html hex strings [default: black]"));
	
	}
}