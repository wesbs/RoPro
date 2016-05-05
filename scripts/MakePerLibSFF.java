package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakePerLibSFF extends Script {
	public static String title = "Make Per-Library SFF";
	public static String b_desc = "Make per-library sff files from ID lists";

	public MakePerLibSFF() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_per_library_sff.html";
		this.c_name = SCRIPTS_PATH + "make_per_library_sff.py";
		this.l_desc = "This script generates per-library sff files using a directory of text files, one per library, which list read ID’s to be included.<br><br>The ID list files should contain one read ID per line. If a line contains multiple words (separated by whitespace), then only the first word is used. A ‘>’ character is stripped from the beginning of the line, if present. Blank lines in the file are skipped.";
		this.output_desc = "The result of this script generates sff files for each library.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("SFF File", "-i", Option.PATH, "Input sff file (separate multiple files w/ comma)"));
		this.r_options.add(new Option("ID List", "-l", Option.PATH, "Directory containing ID list text files, one per library"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Binary SFF", "-p", Option.PATH, "Path to sfffile binary [default: use sfffile in $PATH]"));
		this.e_options.add(new Option("Use External SFF", "--use_sfftools", Option.PATH, "Use external sfffile program instead of equivalent Python routines."));
		this.e_options.add(new Option("Show Debug Output?", "--debug", Option.NOARG, "Print debugging output to stdout [default: False]"));
	
	}
}