package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class CountSeqs extends Script {
	public static String title = "Count Sequences";
	public static String b_desc = "Nod Description";

	public CountSeqs() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/count_seqs.html";
		this.c_name = SCRIPTS_PATH + "count_seqs.py";
		this.l_desc = "No Description";
		this.output_desc = "Count the sequences in a fasta file and write results to stdout.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Input FASTA File", "-i", Option.PATH, 0, "The input filepaths (comma-separated)"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "The output filepath [default: write to stdout]"));
		this.e_options.add(new Option("Suppress Errors", "--suppress_errors", Option.NOARG, "Suppress warnings about missing files [default: False]"));
	
	}
}