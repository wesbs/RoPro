package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ProcessQSeq extends Script {
	public static String title = "Process qSeq";
	public static String b_desc = "Given a directory of per-swath qseq files, this script generates a single fastq per lane.";

	public ProcessQSeq() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/process_qseq.html";
		this.c_name = SCRIPTS_PATH + "process_qseq.py";
		this.l_desc = "No Description";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Input", "-i", Option.PATH, "The input directory"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output directory"));
		this.r_options.add(new Option("Read Number", "-r", Option.NUM, "The read number to consider"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Lanes", "-l", Option.INPUT, "The lane numbers to consider, comma-separated [defaut: 1,2,3,4,5,6,7,8]"));
		this.e_options.add(new Option("Num of Bases", "-b", Option.NUM, "The number of bases to include (useful for slicing a barcode) [defaut: all]"));
		this.e_options.add(new Option("Ignore Pass Filter?", "--ignore_pass_filter", Option.NOARG, "Ignore the illumina pass filter [default:False; reads with 0 in pass filter field are discarded]"));
	
	}
}