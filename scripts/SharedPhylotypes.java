package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class SharedPhylotypes extends Script {
	public static String title = "Shared Phylotypes";
	public static String b_desc = "Compute shared OTUs between all pairs of samples";

	public SharedPhylotypes() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/shared_phylotypes.html";
		this.c_name = SCRIPTS_PATH + "shared_phylotypes.py";
		this.l_desc = "This script computes from an OTU table a matrix with the number of shared phylotypes between all pairs of samples.";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "Path to the input OTU table in biom format or a directory containing OTU tables"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Reference Sample", "-r", Option.INPUT, "Name of reference sample to which all pairs of samples should be compared [default: None]"));
	
	}
}