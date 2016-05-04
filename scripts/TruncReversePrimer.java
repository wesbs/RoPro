package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class TruncReversePrimer extends Script {
	public static String title = "Truncate Reverse Primer";
	public static String b_desc = "Takes a demultiplexed fasta file, finds a specified reverse primer sequence, and truncates this primer and subsequent sequences following the reverse primer.";

	public TruncReversePrimer() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/truncate_reverse_primer.html";
		this.c_name = SCRIPTS_PATH + "truncate_reverse_primer.py";
		this.l_desc = "Takes input mapping file and fasta sequences which have already have been demultiplexed (via split_libraries.py, denoise_wrapper.py, ampliconnoise.py, etc.) with fasta labels that are in QIIME format, i.e., SampleID_#. This script will use the SampleID and a mapping file with a ReversePrimer column to find the reverse primer by local alignment and remove this and any subsequent sequence in a filtered output fasta file.";
		this.output_desc = "Truncated version of the input fasta file (based on input name with ‘seqs_rev_primer_truncated’ appended) will be generated in the output directory, along with a .log file.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("FASTA File", "-f", Option.PATH, "Fasta file. Needs to have fasta labels in proper demultiplexed format."));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "Mapping filepath. ReversePrimer field required. Reverse primers need to be in 5’->3’ orientation."));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Output directory. Will be created if does not exist. [default: .]"));
		List<String> selects = new ArrayList<String>();
		selects.add("truncate_only");
		selects.add("truncate_remove");
		this.e_options.add(new Option("Truncate Option", "-z", Option.SELECT, selects, 0, "Truncation option. The default option, “truncate_only” will try to find the reverse primer to truncate, and if not found, will write the sequence unchanged. If set to “truncate_remove”, sequences where the reverse primer is not found will not be written. [default: truncate_only]"));
		this.e_options.add(new Option("Primer Mismatches", "-M", Option.NUM, "Number of mismatches allowed in the reverse primer. [default: 2]"));
	
	}
}