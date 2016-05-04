package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class SplitOTUTableTax extends Script {
	public static String title = "Split OTU Table by Taxonomy";
	public static String b_desc = "Script to split a single OTU table into multiple tables based on the taxonomy at some user-specified depth.";

	public SplitOTUTableTax() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/split_otu_table_by_taxonomy.html";
		this.c_name = SCRIPTS_PATH + "split_otu_table_by_taxonomy.py";
		this.l_desc = "No Description";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "The input otu table in BIOM format"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output directory"));
		this.r_options.add(new Option("Level", "-l", Option.NUM, "The taxonomic level to split at"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		this.e_options.add(new Option("Metadata Key", "--md_identifier", Option.INPUT, "The relevant observation metadat key [default: taxonomy]"));
		this.e_options.add(new Option("Metadata as String", "--", Option.INPUT, "Metadata is included as string [default: metadata is included as list]"));
	
	}
}