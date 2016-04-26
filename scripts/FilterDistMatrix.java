package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class FilterDistMatrix extends Script {
	public static String title = "Filter Distance Matrix";
	public static String b_desc = "Filter a distance matrix to contain only a specified set of samples.";

	public FilterDistMatrix() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/filter_distance_matrix.html";
		this.c_name = SCRIPTS_PATH + "filter_distance_matrix.py";
		this.l_desc = "Remove samples from a distance matrix based on a mapping file or an otu table or a list of sample ids.";
		this.output_desc = "No Description.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input Distance Matrix", "-i", Option.PATH, "The input distance matrix"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to store the output distance matrix"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(5);
		this.e_options.add(new Option("Sample ID File", "--sample_id_fp", Option.PATH, "A list of sample identifiers (or tab-delimited lines with a sample identifier in the first field) which should be retained"));
		this.e_options.add(new Option("OTU Table", "-t", Option.PATH, "The otu table filepath"));
		this.e_options.add(new Option("Mapping File", "-m", Option.PATH, "Path to the mapping file"));
		this.e_options.add(new Option("Valid States", "-s", Option.INPUT, "String containing valid states, e.g. ‘STUDY_NAME:DOB’"));
		this.e_options.add(new Option("Negate?", "-n", Option.NOARG, "Discard specified samples (instead of keeping them) [default: False]"));
	
	}
}