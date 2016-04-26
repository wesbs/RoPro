package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class CollapseSamples extends Script {
	public static String title = "Collapse Samples";
	public static String b_desc = "Collapse samples in a BIOM table and mapping file.";

	public CollapseSamples() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/collapse_samples.html";
		this.c_name = SCRIPTS_PATH + "collapse_samples.py";
		this.l_desc = "Collapse samples in a BIOM table and mapping file. Values in the BIOM table are collapsed in one of several different ways; see the available options for –collapse_mode. Values in the mapping file are collapsed by grouping the values if they differ for the grouped samples, and by providing the single value if they don’t differ for the grouped samples.";
		this.output_desc = "A collapsed mapping file and BIOM table will be generated at the requested paths.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(5);
		this.r_options.add(new Option("Biom Table", "-b", Option.PATH, "The biom table containing the samples to be collapsed"));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "The sample metdata mapping file"));
		this.r_options.add(new Option("Output Biom Table", "--output_biom_fp", Option.PATH, "Path where collapsed biom table should be written"));
		this.r_options.add(new Option("Output Mapping File", "--output_mapping_fp", Option.PATH, "Path where collapsed mapping file should be written"));
		this.r_options.add(new Option("Fields to Collapse", "--collapse_fields", Option.INPUT, "Comma-separated list of fields to collapse on"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		List<String> selects = new ArrayList<String>(5);
		selects.add("mean");
		selects.add("sum");
		selects.add("median");
		selects.add("first");
		selects.add("random");
		this.e_options.add(new Option("Collapse Mode", "--collaspse_mode", Option.SELECT, selects, 1, "The mechanism for collapsing counts within groups; valid options are: mean, sum, random, median, first. [default: sum]"));
		this.e_options.add(new Option("Normalize", "--normalize", Option.NOARG, "Normalize observation counts to relative abundances, so the counts within each sample sum to 1.0. [default: False]"));
	}
}