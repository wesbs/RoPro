package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ComputeCoreMicrobiome extends Script {
	public static String title = "Compute Core Micrbiome";
	public static String b_desc = "Identify the core microbiome.";

	public ComputeCoreMicrobiome() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/compute_core_microbiome.html";
		this.c_name = SCRIPTS_PATH + "compute_core_microbiome.py";
		this.l_desc = "No Description";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input OTU Table", "-i", Option.PATH, "The input otu table in BIOM format"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Directory to store output data"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(6);
		this.e_options.add(new Option("Max Fraction", "--max_fraction_for_core", Option.NUM, "The max fractions of samples that an OTU must be observed in to be considered part of the core as a number in the range [0,1] [default: 1.0]"));
		this.e_options.add(new Option("Min Fraction", "--min_fraction_for_core", Option.NUM, "The min fractions of samples that an OTU must be observed in to be considered part of the core as a number in the range [0,1] [default: 0.5]"));
		this.e_options.add(new Option("Number of Fracitons", "--num_of_fractions_for_core_steps", Option.NUM, "The number of evenly sizes steps to take between min_fraction_for_core and max_fraction_for_core [default: 11]"));
		this.e_options.add(new Option("Metadata Category", "--otu_md", Option.INPUT, "The otu metadata category to write to the output file [defualt: taxonomy]"));
		this.e_options.add(new Option("Mapping File", "--mapping_fp", Option.PATH, "Mapping file path (for use with –valid_states) [default: None]"));
		this.e_options.add(new Option("Valid States", "--valid_states", Option.INPUT, "Mapping file path (for use with –valid_states) [default: None]"));
	}
}