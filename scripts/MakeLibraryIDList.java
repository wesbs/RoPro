package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakeLibraryIDList extends Script {
	public static String title = "Make Library ID List";
	public static String b_desc = "Make library id lists";

	public MakeLibraryIDList() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_library_id_lists.html";
		this.c_name = SCRIPTS_PATH + "make_library_id_lists.py";
		this.l_desc = "Makes a list of the ids corresponding to each library represented in the input fasta file. Assumes that the libraries are the output of split_libraries.py and that they contain the 454 read id for each sequence as is standard in the split_libraries.py output. Produces a separate file for each library.";
		this.output_desc = "This script produces a separate file for each library.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "The path to a FASTA file containing input sequences"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(5);
		this.e_options.add(new Option("Screened Rep File", "-s", Option.PATH, "The path to a FASTA file containing screened representative seqs[DEFAULT: None]"));
		this.e_options.add(new Option("OTU File", "-u", Option.PATH, "The path to an OTU file mapping OTUs onto rep seqs[DEFAULT: None]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "The base directory to save results (one file per library)."));
		this.e_options.add(new Option("Field", "-f", Option.NUM, "Index of space-delimited field to read id from [DEFAULT: 1]"));
		this.e_options.add(new Option("Show Debug Output?", "--debug", Option.NOARG, "Show debug output."));
	
	}
}