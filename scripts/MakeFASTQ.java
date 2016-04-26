package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakeFASTQ extends Script {
	public static String title = "Make FASTQ";
	public static String b_desc = "Make FASTQ file for ERA submission from paired FASTA and QUAL files";

	public MakeFASTQ() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_fastq.html";
		this.c_name = SCRIPTS_PATH + "make_fastq.py";
		this.l_desc = "The ERA currently requires a separate FASTQ file for each library, split by library id. This code takes the output from split_libraries.py and the corresponding QUAL files and produces ERA-compatible FASTQ files.";
		this.output_desc = "Matches QUAL info to FASTA entries by id, and writes FASTQ output to one file or to per-library files.<br><br>The FASTQ format for each record is as follows:<br><br>@seq_id [and optional description] seq as bases + [and optionally with repeat of seq_id and repeat line] qual scores as string of chr(33+qual)";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("FASTA File", "-f", Option.PATH, "Path to the input fasta file"));
		this.r_options.add(new Option("QUAL Files", "-q", Option.PATH, 0, "Names of QUAL files, comma-delimited"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to store results [default: <input_sequences_filename>.fastq]"));
		this.e_options.add(new Option("Split?", "-s", Option.NOARG, "Make separate file for each library [default:False]"));
	
	}
}