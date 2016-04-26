package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class FilterSamplesOTUTable extends Script {
	public static String title = "Filter Samples from OTU Table";
	public static String b_desc = "Filters samples from an OTU table on the basis of the number of observations in that sample, or on the basis of sample metadata. Mapping file can also be filtered to the resulting set of sample ids.";

	public FilterSamplesOTUTable() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/filter_samples_from_otu_table.html";
		this.c_name = SCRIPTS_PATH + "filter_samples_from_otu_table.py";
		this.l_desc = "No Description.";
		this.output_desc = "No Description.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "The input otu table filepath in biom format"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output filepath in biom format"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(7);
		this.e_options.add(new Option("Mapping File", "-m", Option.PATH, "Path to the map file [default: None]"));
		this.e_options.add(new Option("Output Mapping File", "--output_mapping_fp", Option.PATH, "Path to write filtered mapping file [default: filtered mapping file is not written]"));
		this.e_options.add(new Option("Sample ID File", "--sample_id_fp", Option.PATH, "Path to file listing sample ids to keep. Valid formats for the file are: 1) any white space, newline, or tab delimited list of samples, 2) a mapping file with samples in the first column [default: None]"));
		this.e_options.add(new Option("Valid States", "-s", Option.INPUT, "String describing valid states (e.g. ‘Treatment:Fasting’) [default: None]"));
		this.e_options.add(new Option("Min Count", "-n", Option.NUM, "The minimum total observation count in a sample for that sample to be retained [default: 0]"));
		this.e_options.add(new Option("Max Count", "-x", Option.NUM, "The maximum total observation count in a sample for that sample to be retained [default: infinity]"));
		this.e_options.add(new Option("Negate Sample ID?", "", Option.NOARG, "Discard samples specified in –sample_id_fp instead of keeping them [default: False]"));
	
	}
}

// package scripts;

// import java.io.*;
// import java.lang.String;
// import java.util.*;

// public class BlastWrapper extends Script {
// 	public static String title = 
// 	public static String b_desc = 

// 	public BlastWrapper() {
// 		// set up script name, command, and descriptions
// 		this.link = 
// 		this.c_name = SCRIPTS_PATH + 
// 		this.l_desc = 
// 		this.output_desc = 

// 		// set up the required otpions
// 		this.r_options = new ArrayList<Option>();
// 		this.r_options.add(new Option());

// 		// set up the extra options
// 		this.e_options = new ArrayList<Option>();
// 		this.e_options.add(new Option());
	
// 	}
// }