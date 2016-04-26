package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class AdjustSeqOrient extends Script {
		public static String title = "Adjust Sequence Orientation";
		public static String b_desc = "Get the reverse complement of all sequences";
	
	public AdjustSeqOrient() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/adjust_seq_orientation.html";
		this.c_name = SCRIPTS_PATH + "adjust_seq_orientation.py";
		this.l_desc = "Write the reverse complement of all seqs in seqs.fasta (-i) to seqs_rc.fasta (default, change output_fp with -o). Each sequence description line will have ‘ RC’ appended to the end of it (default, leave sequence description lines untouched by passing -r):";
		this.output_desc = "No Description."; 

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Input FASTA File", "-i", Option.PATH, "Path to the input fasta file"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "The output filepath"));
		this.e_options.add(new Option("Leave Description Untouched?", "-r", Option.NOARG, "Leave seq description lines untouched [default: append ” RC” to seq description lines]"));
	
	}
}

