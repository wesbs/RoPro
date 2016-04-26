package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ExtractSeqsSampleID extends Script {
	public static String title = "Extract Sequences by Sample ID";
	public static String b_desc = "Extract sequences based on the SampleID";

	public ExtractSeqsSampleID() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/extract_seqs_by_sample_id.html";
		this.c_name = SCRIPTS_PATH + "extract_seqs_by_sample_id.py";
		this.l_desc = "This script creates a fasta file which will contain only sequences that ARE associated with a set of sample IDs, OR all sequences that are NOT associated with a set of sample IDs (-n)";
		this.output_desc = "The script produces a fasta file containing containing only the specified SampleIDs.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input FASTA", "-i", Option.PATH, "Path to the input fasta file"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output fasta file"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Negate?", "-n", Option.NOARG, "Negate the sample ID list (i.e., output sample ids not passed via -s) [default: False]"));
		this.e_options.add(new Option("Sample IDs", "-s", Option.INPUT, "Comma-separated sample_ids to include in output fasta file (or exclude if –negate), or string describing mapping file states defining sample ids (mapping_fp must be provided for the latter)"));
		this.e_options.add(new Option("Mapping File", "-m", Option.PATH, "The mapping filepath"));
	
	}
}