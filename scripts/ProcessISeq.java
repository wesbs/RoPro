package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ProcessISeq extends Script {
	public static String title = "Process iSeq";
	public static String b_desc = "Given a directory of per-swath qseq files, this script generates a single fastq per lane.";

	public ProcessISeq() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/process_iseq.html";
		this.c_name = SCRIPTS_PATH + "process_iseq.py";
		this.l_desc = "No Description";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Input Files", "-i", Option.PATH, 0, "The input filepaths (either iseq or gzipped iseq format; comma-separated if more than one). See Processing Illumina Data tutorial for a description of the iseq file type."));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output directory"));
		this.r_options.add(new Option("Bardcode Length", "-b", Option.NUM, "Length of the barcode"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		this.e_options.add(new Option("Bardcode in Header?", "--barcode_in_header", Option.NOARG, "Pass if barcode is in the header index field (rather than at the beginning of the sequence)"));
		this.e_options.add(new Option("Default Score", "--barcode_qual_c", Option.INPUT, "If no barcode quality string is available, score each base with this quality [default: b]"));
	
	}
}