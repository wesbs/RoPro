package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class PickRepSet extends Script {
	public static String title = "Pick Representative Set";
	public static String b_desc = "Pick representative set of sequences";

	public PickRepSet() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/pick_rep_set.html";
		this.c_name = SCRIPTS_PATH + "pick_rep_set.py";
		this.l_desc = "After picking OTUs, you can then pick a representative set of sequences. For each OTU, you will end up with one sequence that can be used in subsequent analyses.";
		this.output_desc = "The output from pick_rep_set.py is a single FASTA file containing one sequence per OTU. The FASTA header lines will be the OTU identifier (from here on used as the unique sequence identifier) followed by a space, followed by the sequence identifier originally associated with the representative sequence. The name of the output FASTA file will be <input_sequences_filepath>_rep_set.fasta by default, or can be specified via the “-o” parameter.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Mapping File", "-i", Option.PATH, "Path to input otu mapping file [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(6);
		this.e_options.add(new Option("FASTA File", "-f", Option.PATH, "Path to input fasta file [REQUIRED if not picking against a reference set; default: None]"));
		List<String> selects = new ArrayList<String>();
		selects.add("random");
		selects.add("longest");
		selects.add("most_abundant");
		selects.add("first");
		this.e_options.add(new Option("Method", "-m", Option.SELECT, selects, 3, "Method for picking representative sets. Valid choices are random, longest, most_abundant, first [default: first (first chooses cluster seed when picking otus with uclust)]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to store result file [default: <input_sequences_filepath>_rep_set.fasta]"));
		this.e_options.add(new Option("Log File", "-l", Option.PATH, "Path to store log file [default: No log file created.]"));
		selects = new ArrayList<String>();
		selects.add("otu");
		selects.add("seq_id");
		this.e_options.add(new Option("Sort By", "-s", Option.SELECT, selects, 0, "Sort by otu or seq_id [default: otu]"));
		this.e_options.add(new Option("Reference Sequences", "-r", Option.PATH, "Collection of preferred representative sequences [default: None]"));
	
	}
}