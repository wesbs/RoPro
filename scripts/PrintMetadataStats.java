package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class PrintMetadataStats extends Script {
	public static String title = "Print Metadata Stats";
	public static String b_desc = "Count the number of samples associated to a category value";

	public PrintMetadataStats() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/print_metadata_stats.html";
		this.c_name = SCRIPTS_PATH + "print_metadata_stats.py";
		this.l_desc = "Sum up the number of samples with each category value and print this information.";
		this.output_desc = "Two columns, the first being the category value and the second being the count. Output is to standard out. If there are unspecified values, the output category is identified as *UNSPECIFIED*";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "The input metadata file"));
		this.r_options.add(new Option("Category", "-c", Option.INPUT, "The category to examine"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path where output will be written [default: print to screen]"));
	
	}
}