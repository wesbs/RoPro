package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class TreeCompare extends Script {
	public static String title = "Tree Compare";
	public static String b_desc = "Compare jackknifed/bootstrapped trees";

	public TreeCompare() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/tree_compare.html";
		this.c_name = SCRIPTS_PATH + "tree_compare.py";
		this.l_desc = "Compares jackknifed/bootstrapped trees (support trees) with a master tree constructed typically from the entire dataset (e.g: a resulting file from upgma_cluster.py) and outputs support for nodes.<br><br>if support trees do not have all tips that master has (e.g. because samples with few sequences were dropped during a jackknifing analysis), the output master tree will have only those tips included in all support trees<br><br>if support trees have tips that the master tree does not, those tips will be ignored (removed from the support tree during analysis)";
		this.output_desc = "The result of tree_compare.py contains the master tree, now with internal nodes uniquely named, a separate bootstrap/jackknife support file, listing the support for each internal node, and a jackknife_named_nodes.tre tree, where internal nodes are named with their support values from 0 to 1.0, for use with tree visualization software (e.g. FigTree).";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Master Tree", "-m", Option.PATH, "Master tree filepath"));
		this.r_options.add(new Option("Support Directory", "-s", Option.PATH, "Path to dir containing support trees"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output directory, writes three files here makes dir if it doesn’t exist"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(0);
		// this.e_options.add(new Option());
	
	}
}