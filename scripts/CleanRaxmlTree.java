package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class CleanRaxmlTree extends Script {
	public static String title = "Clean Raxml Parsimony Tree"; 
	public static String b_desc = "Remove duplicate tips from Raxml Tree";

	public CleanRaxmlTree() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/clean_raxml_parsimony_tree.html";
		this.c_name = SCRIPTS_PATH + "clean_raxml_parsimony_tree.py";
		this.l_desc = "This script allows the user to remove specific duplicate tips from a Raxml tree.";
		this.output_desc = "No Output Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Input Tree", "-i", Option.PATH, "The input raxml parsimony tree"));
		this.r_options.add(new Option("Tips to Keep", "-t", Option.INPUT, "The input tips to score and retain (comma-separated list)"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		List<String> selects = new ArrayList<String>(2);
		selects.add("depth");
		selects.add("numtips");
		this.e_options.add(new Option("Scoring Method", "-s", Option.SELECT, selects, 0, "The scoring method either depth or numtips [default: depth]"));
	}
}