package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class FixARBFASTA extends Script {
	public static String title = "Fix ARB FASTA File";
	public static String b_desc = "Reformat ARB FASTA files";

	public FixARBFASTA() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/fix_arb_fasta.html";
		this.c_name = SCRIPTS_PATH + "fix_arb_fasta.py";
		this.l_desc = "This script fixes ARB FASTA formatting by repairing incorrect line break chararcters, stripping spaces and replacing ”.” with “-” characters.";
		this.output_desc = "The reformatted sequences are written to stdout or to the file path provided with -o.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("FASTA File", "-f", Option.PATH, "Path to the input fasta file"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path where output will be written [default: print to screen]"));
	
	}
}