package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class BetaSignificance extends Script {
		public static String title = "Beta Significance";
		public static String b_desc = "This script runs any of a set of common tests to determine if a sample is statistically significantly different from another sample";
	
	public BetaSignificance() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/beta_significance.html";
		this.c_name = SCRIPTS_PATH + "beta_significance.py";
		this.l_desc = "The tests are conducted on each pair of samples present in the input otu table. See the unifrac tutorial online for more details (http://unifrac.colorado.edu/)";
		this.output_desc = "The script outputs a tab delimited text file with each pair of samples and a p value representing the probability that a random sample/sequence assignment will result in more dissimilar samples than the actual pair of samples.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(4);
		this.r_options.add(new Option("Input OTU Table", "-i", Option.PATH, "Input otu table in biom format"));
		this.r_options.add(new Option("Output Path", "-o", Option.PATH, "Output results path"));
		List<String> selects = new ArrayList<String>(4);
		selects.add("unweighted_unifrac");
		selects.add("weighted_unifrac");
		selects.add("weighted_normalized_unifrac");
		selects.add("p-test");
		this.r_options.add(new Option("Significance Test", "-s", Option.SELECT, selects, "Significance test to use, options are ‘unweighted_unifrac’, ‘weighted_unifrac’, ‘weighted_normalized_unifrac’, or ‘p-test’"));
		this.r_options.add(new Option("Input Tree File", "-t", Option.PATH, "Path to newick tree file"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		this.e_options.add(new Option("Number of Randomizations", "-n", Option.NUM, "Number of monte carlo randomizations [default: 100]"));
		selects = new ArrayList<String>(3);
		selects.add("all_together");
		selects.add("each_pair");
		selects.add("each_sample");
		this.e_options.add(new Option("Significance Test", "-k", Option.SELECT, selects, 1, "Type of significance test to perform, options are ‘all_together’, ‘each_pair’ or ‘each_sample’. [default: each_pair]"));
	}
}