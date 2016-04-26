package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class BlastWrapper extends Script {
	public static String title = "Blast Wrapper";
	public static String b_desc = "Blast Interface";

	public BlastWrapper() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/blast_wrapper.html";
		this.c_name = SCRIPTS_PATH + "blast_wrapper.py";
		this.l_desc = "This script is a functionally-limited interface to the qiime.util.qiime_blast_seqs function, primarily useful for testing purposes. Once that function has been integrated into qiime as the primary blast interface it will move to PyCogent. An expanded version of this command line interface may replace the script functionality of cogent.app.blast at that point.";
		this.output_desc = "This is a utility program, which returns BLAST results.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input FASTA File", "-i", Option.PATH, "Path to the input fasta file"));
		this.r_options.add(new Option("Blast Database", "-r", Option.PATH, "Path to blast database as a fasta file"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Sequences per Call", "-n", Option.NUM, "Number of sequences passed to each blast call - useful for very large sequence collections [default: 1000]"));
	}
}