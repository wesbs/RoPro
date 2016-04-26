package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakeBootstrappedTree extends Script {
	public static String title = "Make Bootstrapped Tree";
	public static String b_desc = "Make bootstrapped tree";

	public MakeBootstrappedTree() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_bootstrapped_tree.html";
		this.c_name = SCRIPTS_PATH + "make_bootstrapped_tree.py";
		this.l_desc = "This script takes a tree and bootstrap support file and creates a pdf, colored by bootstrap support.";
		this.output_desc = "The result of this script is a pdf file.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Master Tree", "-m", Option.PATH, "This is the path to the master tree"));
		this.r_options.add(new Option("Bootstrapped Support", "-s", Option.PATH, "This is the path to the bootstrap support file"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "This is the filename where the output should be written."));

		// set up the extra options
		this.e_options = new ArrayList<Option>(0);
		// this.e_options.add(new Option());
	
	}
}