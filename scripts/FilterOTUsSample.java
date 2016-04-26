package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class FilterOTUsSample extends Script {
	public static String title = "Filter OTUs by Sample ID";
	public static String b_desc = "Filter OTU mapping file and sequences by SampleIDs";

	public FilterOTUsSample() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/filter_otus_by_sample.html";
		this.c_name = SCRIPTS_PATH + "filter_otus_by_sample.py";
		this.l_desc = "This filter allows for the removal of sequences and OTUs containing user-specified Sample IDs, for instance, the removal of negative control samples. This script identifies OTUs containing the specified Sample IDs and removes its corresponding sequence from the sequence collection.";
		this.output_desc = "As a result a new OTU and sequence file is generated and written to a randomly generated folder where the name of the folder starts with “filter_by_otus” Also included in the folder, is another FASTA file containing the removed sequences, leaving the user with 3 files.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("OTU Map", "-i", Option.PATH, "Path to the input OTU map (i.e., the output from pick_otus.py)"));
		this.r_options.add(new Option("Input FASTA File", "-f", Option.PATH, "Path to the input fasta file"));
		this.r_options.add(new Option("Sample IDs", "-s", Option.INPUT, "This is a list of sample ids, which should be removed from the OTU file"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to the output directory"));
	
	}
}