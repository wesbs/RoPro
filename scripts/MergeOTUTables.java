package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MergeOTUTables extends Script {
	public static String title = "Merge OTU Tables";
	public static String b_desc = "Merge two or more OTU tables into a single OTU table.";

	public MergeOTUTables() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/merge_otu_tables.html";
		this.c_name = SCRIPTS_PATH + "merge_otu_tables.py";
		this.l_desc = "This script merges two or more OTU tables into a single OTU table. This is useful, for example, when you’ve created several reference-based OTU tables for different analyses and need to combine them for a larger analysis.<br><br>Requirements: It is also very important that your OTUs are consistent across the different OTU tables. For example, you cannot safely merge OTU tables from two independent de novo OTU picking runs. Finally, either all or none of the OTU tables can contain taxonomic information: you can’t merge some OTU tables with taxonomic data and some without taxonomic data.";
		this.output_desc = "No Description.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("OTU Tables", "-i", Option.PATH, 0, "The otu tables in biom format (comma-separated)"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output otu table filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(0);
		// this.e_options.add(new Option());
	
	}
}