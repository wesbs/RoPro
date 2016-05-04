package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class SubsampleFASTA extends Script {
	public static String title = "Subsample FASTA";
	public static String b_desc = "Randomly subsample sequences from a given fasta file";

	public SubsampleFASTA() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/subsample_fasta.html";
		this.c_name = SCRIPTS_PATH + "subsample_fasta.py";
		this.l_desc = "Subsample the seqs.fna file, randomly select 5% of the sequences:";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "Path to the input fasta file"));
		this.r_options.add(new Option("Percentage", "-p", Option.NUM, "Specify the percentage (as a fraction between 0 and 1) of sequences to subsample"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "The output filepath"));
	
	}
}