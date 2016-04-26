package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class CondUncoveredProb extends Script {
	public static String title = "Conditional Uncovered Probability";
	public static String b_desc = "Calculate the conditional uncovered probability on each sample in an otu table.";

	public CondUncoveredProb() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/conditional_uncovered_probability.html";
		this.c_name = SCRIPTS_PATH + "conditional_uncovered_probability.py";
		this.l_desc = "This script calculates the conditional uncovered probability for each sample in an OTU table. It uses the methods introduced in Lladser, Gouet, and Reeder, “Extrapolation of Urn Models via Poissonization: Accurate Measurements of the Microbial Unknown” PLoS 2011.<br><br>Specifically, it computes a point estimate and a confidence interval using two different methods. Thus it can happen that the PE is actually outside of the CI.<br><br>We only provide the ability to generate 95% (alpha=0.95) CIs. The CIs are ULCL CIs; they provide an upper and lower bound, where the lower bound is conservative. The CIs are constructed using an upper-to-lower bound ratio of 10.<br><br>The CI method requires precomputed constants that depend on the lookahead. We only provide constants for r=3..25,30,40,50.";
		this.output_desc = "The resulting file(s) is a tab-delimited text file, where the columns correspond to estimates of the cond. uncovered probability and the rows correspond to samples. The output file is compatible with the alpha_diversity output files and thus could be tied into the rarefaction workflow.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(0);
		// this.r_options.add(new Option());

		// set up the extra options
		this.e_options = new ArrayList<Option>(5);
		this.e_options.add(new Option("Input OTU Table", "-i", Option.PATH, "Input OTU table filepath. [default: None]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Output filepath to store the predictions. [default: None]"));
		this.e_options.add(new Option("Look Ahead", "-r", Option.NUM, "Number of unobserved, new colors necessary for prediction. [default: 25]"));
		this.e_options.add(new Option("Metrics", "-m", Option.INPUT, "CUP metric(s) to use. A comma-separated list should be provided when multiple metrics are specified. [default: lladser_pe,lladser_ci]"));
		this.e_options.add(new Option("Show Metrics?", "-s", Option.NOARG, "Show the available CPU metrics and exit."));
	
	}
}


