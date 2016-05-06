package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ProcessSFF extends Script {
	public static String title = "Process SFF";
	public static String b_desc = "Convert sff to FASTA and QUAL files";

	public ProcessSFF() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/process_sff.html";
		this.c_name = SCRIPTS_PATH + "process_sff.py";
		this.l_desc = "This script converts a directory of sff files into FASTA, QUAL and flowgram files.";
		this.output_desc = "This script results in FASTA and QUAL formatted files.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("SFF Directory/File", "-i", Option.PATH, "Input directory of sff files or a single sff filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(5);
		this.e_options.add(new Option("No Trim?", "--no_trim", Option.NOARG, "Do not trim sequence/qual (requires –use_sfftools option) [default: False]"));
		this.e_options.add(new Option("Make Flowgram?", "-f", Option.NOARG, "Generate a flowgram file. [default: False]"));
		this.e_options.add(new Option("Convert to FLX?", "-t", Option.NOARG, "Convert Titanium reads to FLX length. [default: False]"));
		this.e_options.add(new Option("Use SFF Tools?", "--use_sfftools", Option.NOARG, "Use the external programs sfffile and sffinfo for processing, instead of the equivalent python implementation"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Input directory of sff files [default: same as input dir]"));
	
	}
}