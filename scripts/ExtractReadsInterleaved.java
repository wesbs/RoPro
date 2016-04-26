package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ExtractReadsInterleaved extends Script {
	public static String title = "Extract Reads from Interleaved File";
	public static String b_desc = "Extract reads from an interleaved file.";

	public ExtractReadsInterleaved() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/extract_reads_from_interleaved_file.html";
		this.c_name = SCRIPTS_PATH + "extract_reads_from_interleaved_file.py";
		this.l_desc = "This script takes an interleaved file, like the ones produced by JGI, and outputs a forward and reverse fastq file with the corresponding reads in each file.";
		this.output_desc = "A new folder with two fastq files: forward_reads.fastq and reverse_reads.fastq";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input FASTQ", "-i", Option.PATH, "Path to input forward reads in FASTQ format."));
		this.r_options.add(new Option("Outpur", "-o", Option.PATH, "Directory to store result files"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		this.e_options.add(new Option("Forward Reads", "--forward_read_identifier", Option.INPUT, "This is the string identifying the forward reads. [default: 1:N:0]."));
		this.e_options.add(new Option("Reverse Reads", "--reverse_read_identifier", Option.INPUT, "This is the string identifying the reverse reads. [default: 2:N:0]."));
	
	}
}