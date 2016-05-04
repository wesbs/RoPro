package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class TruncFASTAQUAL extends Script {
	public static String title = "Truncate FASTA and QUAL Files";
	public static String b_desc = "Generates filtered fasta and quality score files by truncating at the specified base position.";

	public TruncFASTAQUAL() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/truncate_fasta_qual_files.html";
		this.c_name = SCRIPTS_PATH + "truncate_fasta_qual_files.py";
		this.l_desc = "This module is designed to remove regions of poor quality in 454 sequence data. Drops in quality can be visualized with the quality_scores_plot.py module. The base position specified will be used as an index to truncate the sequence and quality scores, and all data at that base position and to the end of the sequence will be removed in the output filtered files.";
		this.output_desc = "Filtered versions of the input fasta and qual file (based on input name with ‘_filtered’ appended) will be generated in the output directory";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("FASTA File", "-f", Option.PATH, "Input fasta filepath to be truncated."));
		this.r_options.add(new Option("QUAL File", "-q", Option.PATH, "Input quality scores filepath to be truncated."));
		this.r_options.add(new Option("Base Position", "-b", Option.NUM, "Nucleotide position to truncate the fasta and quality score files at."));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Output directory. Will be created if does not exist. [default: .]"));
	
	}
}