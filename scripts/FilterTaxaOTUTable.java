package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class FilterTaxaOTUTable extends Script {
	public static String title = "Filter Taxa from OTU Table";
	public static String b_desc = "Filter taxa from an OTU table";

	public FilterTaxaOTUTable() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/filter_taxa_from_otu_table.html";
		this.c_name = SCRIPTS_PATH + "filter_taxa_from_otu_table.py";
		this.l_desc = "This scripts filters an OTU table based on taxonomic metadata. It can be applied for positive filtering (i.e., keeping only certain taxa), negative filtering (i.e., discarding only certain taxa), or both at the same time.";
		this.output_desc = "No Description.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "The input otu table filepath"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output otu table filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Posititve Taxa", "-p", Option.INPUT, "Comma-separated list of taxa to retain [default: None; retain all taxa]"));
		this.e_options.add(new Option("Negative Taxa", "-n", Option.INPUT, "Comma-separated list of taxa to discard [default: None; retain all taxa]"));
		this.e_options.add(new Option("Metadata Field", "--metadata_field", Option.INPUT, "Observation metadata identifier to filter based on [default: taxonomy]"));
	
	}
}