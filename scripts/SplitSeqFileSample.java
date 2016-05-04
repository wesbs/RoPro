package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class SplitSeqFileSample extends Script {
	public static String title = "Split Sequence File by Sample ID";
	public static String b_desc = "Split a single post-split_libraries.py fasta (or post-split_libraries_fastq.py fastq) file into per-sample files.";

	public SplitSeqFileSample() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/split_sequence_file_on_sample_ids.html";
		this.c_name = SCRIPTS_PATH + "split_sequence_file_on_sample_ids.py";
		this.l_desc = "Split a single post-split_libraries.py fasta (or post-split_libraries_fastq.py fastq) file into per-sample fasta files. This script requires that the sequences identitifers are in post-split_libraries.py format (i.e., SampleID_SeqID). A file will be created for each unique SampleID.";
		this.output_desc = "This script will produce an output directory with as many files as samples.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "The input fasta file to split"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output directory [default: None]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		this.e_options.add(new Option("Buffer Size", "--", Option.NUM, "The number of sequences to read into memory before writing to file (you usually won’t need to change this) [default: 500]"));
		List<String> selects = new ArrayList<String>();
		selects.add("fastq");
		selects.add("fasta");
		this.e_options.add(new Option("File Type", "--file_type", Option.SELECT, selects, 1, "Type of file. Either fasta or fastq"));
	
	}
}