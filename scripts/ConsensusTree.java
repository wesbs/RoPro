package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ConsensusTree extends Script {
	public static String title = "Consensus Tree";
	public static String b_desc = "This script outputs a majority consensus tree given a collection of input trees";

	public ConsensusTree() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/consensus_tree.html";
		this.c_name = SCRIPTS_PATH + "consensus_tree.py";
		this.l_desc = "No Description";
		this.output_desc = "The output is a newick formatted tree compatible with most standard tree viewing programs";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input", "-i", Option.PATH, "Input folder containing trees"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output consensus tree filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Strict", "-s", Option.NOARG, "Use only nodes occurring >50% of the time [default: False]"));
	
	}
}