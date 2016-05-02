package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class SortOTUTable extends Script {
	public static String title = "Sort OTU Table";
	public static String b_desc = "Script for sorting the sample IDs in an OTU table based on a specified value in a mapping file.";

	public SortOTUTable() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/sort_otu_table.html";
		this.c_name = SCRIPTS_PATH + "sort_otu_table.py";
		this.l_desc = "No Description";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "Input OTU table filepath in BIOM format."));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output OTU table filepath."));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Mapping File", "-m", Option.PATH, "Input metadata mapping filepath. [default: None]"));
		this.e_options.add(new Option("Sort Field", "-s", Option.INPUT, "Category to sort OTU table by. [default: None]"));
		this.e_options.add(new Option("Sorted Sample File", "-l", Option.PATH, "Sorted sample id filepath [default: None]"));
	
	}
}