package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class CollateAlpha extends Script {
	public static String title = "Collate Alpha";
	public static String b_desc = "Collate alpha diversity results";

	public CollateAlpha() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/collate_alpha.html";
		this.c_name = SCRIPTS_PATH + "collate_alpha.py";
		this.l_desc = "When performing batch analyses on the OTU table (e.g. rarefaction followed by alpha diversity), the result of alpha_diversity.py comprises many files, which need to be concatenated into a single file for generating rarefaction curves. This script joins those files. Input files are: each file represents one (rarefied) otu table each row in a file represents one sample each column in a file represents one diversity metric<br><br>Output files are: each file represents one diversity metric each row in a file represents one (rarefied) otu table each column in a file represents one sample<br><br>The input directory should contain only otu tables. The output directory should be empty or nonexistant and the example file is optional.<br><br>If you have a set of rarefied OTU tables, make sure the example file contains every sample present in the otu talbes. You should typically choose the file with the fewest sequences per sample, to avoid files with sparse samples omitted.";
		this.output_desc = "This script takes the resulting files from batch alpha diversity and collates them into (one file for each metric used).";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input File", "-i", Option.PATH, "Input path (a directory)"));
		this.r_options.add(new Option("Output File", "-o", Option.PATH, "Output path (a directory). will be created if needed"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Alpha Diversity File", "-e", Option.PATH, "Example alpha_diversity analysis file, containing all samples and all metrics to be included in the collated result[Default: chosen automatically (see usage string)]"));

	}
}