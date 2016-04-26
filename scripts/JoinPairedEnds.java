package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class JoinPairedEnds extends Script {
	public static String title = "Join Paired Ends";
	public static String b_desc = "Joins paired-end Illumina reads.";

	public JoinPairedEnds() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/join_paired_ends.html";
		this.c_name = SCRIPTS_PATH + "join_paired_ends.py";
		this.l_desc = "This script takes forward and reverse Illumina reads and joins them using the method chosen. Will optionally create an updated index reads file containing index reads for the surviving joined paired end reads. If the option to write an updated index file is chosen, be sure that the order and header format of the index reads is the same as the order and header format of reads in the files that will be joined (this is the default for reads generated on the Illumina instruments).<br><br>Currently, there are two methods that can be selected by the user to join paired-end data:<br><br>1. fastq-join - Erik Aronesty, 2011. ea-utils : “Command-line tools for processing biological sequencing data” (http://code.google.com/p/ea-utils)<br>2. SeqPrep - (https://github.com/jstjohn/SeqPrep)";
		this.output_desc = "All paired-end joining software will return a joined / merged / assembled paired-end fastq file. Depending on the method chosen, additional files may be written to the user-specified output directory.<br><br>1. fastq-join will output fastq-formatted files as:<br>“*.join”: assembled / joined reads output<br>“*.un1”: unassembled / unjoined reads1 output<br>“*.un2”: unassembled / unjoined reads2 output<br>2. SeqPrep will output fastq-formatted gzipped files as:<br>“*_assembled.gz”: unassembled / unjoined reads1 output<br>“*_unassembled_R1.gz”: unassembled / unjoined reads1 output<br>“*_unassembled_R2.gz”: unassembled / unjoined reads2 output<br>3. If a barcode / index file is provided via the ‘-b’ option, an updated barcodes file will be output as:<br>”..._barcodes.fastq”: This barcode / index file must be used in conjunction with the joined paired-ends file as input to split_libraries_fastq.py. Except for missing reads that may result from failed merging of paired-ends, the index-reads and joined-reads must be in the same order.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Forward Reads File", "-f", Option.PATH, "Path to input forward reads in FASTQ format."));
		this.r_options.add(new Option("Reverse Reads File", "-r", Option.PATH, "Path to input reverse reads in FASTQ format."));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Directory to store result files"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(8);
		List<String> selects = new ArrayList<String>();
		selects.add("fastq-join");
		selects.add("SeqPrep");
		this.e_options.add(new Option("Join Method", "-m", Option.SELECT, selects, 0, "Method to use for joining paired-ends. Valid choices are: fastq-join, SeqPrep [default: fastq-join]"));
		this.e_options.add(new Option("Index Reads File", "-b", Option.PATH, "Path to the barcode / index reads in FASTQ format. Will be filtered based on surviving joined pairs."));
		this.e_options.add(new Option("Min Overlap", "-j", Option.NUM, "Applies to both fastq-join and SeqPrep methods. Minimum allowed overlap in base-pairs required to join pairs. If not set, progam defaults will be used. Must be an integer. [default: None]"));
		this.e_options.add(new Option("Percent MAx Difference", "-p", Option.NUM, "Only applies to fastq-join method, otherwise ignored. Maximum allowed % differences within region of overlap. If not set, progam defaults will be used. Must be an integer between 1-100 [default: None]"));
		this.e_options.add(new Option("Max ASCII Score", "-y", Option.INPUT, "Only applies to SeqPrep method, otherwise ignored. Maximum quality score / ascii code allowed to appear within joined pairs output. For more information, please see: http://en.wikipedia.org/wiki/FASTQ_format. [default: J]"));
		this.e_options.add(new Option("Min Fraction Match", "-n", Option.NUM, "Only applies to SeqPrep method, otherwise ignored. Minimum allowed fraction of matching bases required to join reads. Must be a float between 0-1. If not set, progam defaults will be used. [default: None]"));
		this.e_options.add(new Option("Max Good Mismatch", "-g", Option.NUM, "Only applies to SeqPrep method, otherwise ignored. Maximum mis-matched high quality bases allowed to join reads. Must be a float between 0-1. If not set, progam defaults will be used. [default: None]"));
		this.e_options.add(new Option("Phred 64?", "-6", Option.NOARG, "Only applies to SeqPrep method, otherwise ignored. Set if input reads are in phred+64 format. Output will always be phred+33. [default: False]"));
	
	}
}
