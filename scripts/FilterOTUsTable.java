package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class FilterOTUsTable extends Script {
	public static String title = "Filter OTUs from OTU Table";
	public static String b_desc = "Filter OTUs from an OTU table based on their observation counts or identifier.";

	public FilterOTUsTable() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/filter_otus_from_otu_table.html";
		this.c_name = SCRIPTS_PATH + "filter_otus_from_otu_table.py";
		this.l_desc = "No Description.";
		this.output_desc = "No Description.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "The input otu table filepath in biom format"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output filepath in biom format"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(7);
		this.e_options.add(new Option("Negate IDs?", "--negate_ids_to_exclude", Option.NOARG, "Keep OTUs in otu_ids_to_exclude_fp rather than discard them [default:False]"));
		this.e_options.add(new Option("Min Count", "-n", Option.NUM, "The minimum total observation count of an otu for that otu to be retained [default: 0]"));
		this.e_options.add(new Option("Min Count Fraction", "--min_count_fraction", Option.NUM, "Fraction of the total observation (sequence) count to apply as the minimum total observation count of an otu for that otu to be retained. this is a fraction, not percent, so if you want to filter to 1%, you specify 0.01. [default: 0]"));
		this.e_options.add(new Option("Max Count", "-x", Option.NUM, "The maximum total observation count of an otu for that otu to be retained [default: infinity]"));
		this.e_options.add(new Option("Min Samples", "-s", Option.NUM, "The maximum total observation count of an otu for that otu to be retained [default: infinity]"));
		this.e_options.add(new Option("Max Samples", "-y", Option.NUM, "The maximum number of samples an OTU must be observed in for that otu to be retained [default: infinity]"));
		this.e_options.add(new Option("OTU IDs", "-e", Option.PATH, "File containing list of OTU ids to exclude: can be a text file with one id per line, a text file where id is the first value in a tab-separated line, or can be a fasta file (extension must be .fna or .fasta) [default: None]"));
	
	}
}