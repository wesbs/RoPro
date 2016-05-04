package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class TrimSFFPrimers extends Script {
	public static String title = "Trim SFF Primers";
	public static String b_desc = "Trim sff primers";

	public TrimSFFPrimers() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/trim_sff_primers.html";
		this.c_name = SCRIPTS_PATH + "trim_sff_primers.py";
		this.l_desc = "Finds the technical read regions for each library, and resets the left trim.";
		this.output_desc = "This script replaces the original sff files with the trimmed versions.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Library Directory", "-l", Option.PATH, "The directory containing per-library sff files"));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "Path to the input mapping file describing the libraries"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(4);
		this.e_options.add(new Option("SFF File Binary", "-p", Option.PATH, "Path to sfffile binary [default: sfffile]"));
		this.e_options.add(new Option("SFF Info Binary", "-q", Option.PATH, "Path to sffinfo binary [default: sffinfo]"));
		this.e_options.add(new Option("Use SFF Tools?", "--use_sfftools", Option.NOARG, "Use external sffinfo and sfffile programs instead of equivalent Python implementation."));
		this.e_options.add(new Option("Debug?", "--debug", Option.NOARG, "Print command-line output for debugging [default: False]"));
	
	}
}