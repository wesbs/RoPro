package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class Relatedness extends Script {
	public static String title = "Relatedness";
	public static String b_desc = "Calculate NRI (net relatedness index) and NTI (nearest taxon index) using the formulas from Phylocom 4.2/3.41 and Webb 2002.";

	public Relatedness() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/relatedness.html";
		this.c_name = SCRIPTS_PATH + "relatedness.py";
		this.l_desc = "This script calculates NRI and NTI from a path to a Newick formatted tree and a path to a comma separated list of ids in that tree that form the group whose NRI/NTI you want to test. The tree is not required to have distances. If none are found script will use the number of nodes (self inclusive) as their distance from one another. NRI and NTI are calculated as described in the Phylocom manual (which is a slightly modified version of that found in Webb 2002, and Webb 2000). The Phylocom manual is freely available on the web and Webb 2002 can be found in the Annual Review of Ecology and Systematics: Phylogenies and Community Ecology Webb 2002.";
		this.output_desc = "Outputs a value for specified tests";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Tree File", "-t", Option.PATH, "The tree filepath"));
		this.r_options.add(new Option("Taxa File", "-g", Option.PATH, "Taxa list filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Num of Iterations", "-i", Option.NUM, "Number of iterations to use for sampling tips without replacement (null model 2 community sampling, see http://bodegaphylo.wikispot.org/Community_Phylogenetics [default: 1000]"));
		this.e_options.add(new Option("Methods", "-m", Option.INPUT, "Comma-separated list of metrics to calculate. [default: nri,nti]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path where output will be written [default: print to screen]"));
	
	}
}