package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class FilterFASTA extends Script {
	public static String title = "Filter FASTA File";
	public static String b_desc = "This script can be applied to remove sequences from a fasta or fastq file based on input criteria.";

	public FilterFASTA() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/filter_fasta.html";
		this.c_name = SCRIPTS_PATH + "filter_fasta.py";
		this.l_desc = "No Description";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input FASTA File", "-f", Option.PATH, "Path to the input fasta file"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output fasta filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(9);
		this.e_options.add(new Option("OTU Map", "-m", Option.PATH, "An OTU map where sequences ids are those which should be retained."));
		this.e_options.add(new Option("Sequence IDs", "-s", Option.PATH, "A list of sequence identifiers (or tab-delimited lines with a seq identifier in the first field) which should be retained."));
		this.e_options.add(new Option("BIOM File", "-b", Option.PATH, "A biom file where otu identifiers should be retained."));
		this.e_options.add(new Option("Subject FASTA", "-a", Option.PATH, "A fasta file where the seq ids should be retained."));
		this.e_options.add(new Option("Sequence Prefix", "-p", Option.INPUT, "Keep seqs where seq_id starts with this prefix."));
		this.e_options.add(new Option("Sample ID File", "--sample_id_fp", Option.PATH, "Keep seqs where seq_id starts with a sample id listed in this file. Must be newline delimited and may not contain a header."));
		this.e_options.add(new Option("Negate?", "-n", Option.NOARG, "Discard passed seq ids rather than keep passed seq ids. [default: False]"));
		this.e_options.add(new Option("Mapping File", "--mapping_fp", Option.PATH, "Mapping file path (for use with –valid_states). [default: None]"));
		this.e_options.add(new Option("Valid States", "--valid_states", Option.INPUT, "Description of sample ids to retain (for use with –mapping_fp). [default: None]"));
	
	}
}
