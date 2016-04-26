package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakePhylogeny extends Script {
	public static String title = "Make Phylogeny";
	public static String b_desc = "Make Phylogeny";

	public MakePhylogeny() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_phylogeny.html";
		this.c_name = SCRIPTS_PATH + "make_phylogeny.py";
		this.l_desc = "Many downstream analyses require that the phylogenetic tree relating the OTUs in a study be present. The script make_phylogeny.py produces this tree from a multiple sequence alignment. Trees are constructed with a set of sequences representative of the OTUs, by default using FastTree (Price, Dehal, & Arkin, 2009).";
		this.output_desc = "The result of make_phylogeny.py consists of a newick formatted tree file (.tre) and optionally a log file. The tree file is formatted using the Newick format and this file can be viewed using most tree visualization tools, such as TopiaryTool, FigTree, etc.<br><br>The tips of the tree are the first word from the input sequences from the fasta file, e.g.: ‘>101 PC.481_71 RC:1..220’ is represented in the tree as ‘101’.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("FASTA Alignment", "-i", Option.PATH, "Path to read input fasta alignment, only first word in defline will be considered"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(4);
		List<String> selects = new ArrayList<String>();
		selects.add("clustalw");
		selects.add("raxml_v730");
		selects.add("muscle");
		selects.add("fasttree");
		selects.add("clearcut");
		this.e_options.add(new Option("Tree Method", "-t", Option.SELECT, selects, 3, "Method for tree building. Valid choices are: clustalw, raxml_v730, muscle, fasttree, clearcut [default: fasttree]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to store result file [default: <input_sequences_filename>.tre]"));
		this.e_options.add(new Option("Log File", "-l", Option.PATH, "Path to store log file [default: No log file created.]"));
		selects = new ArrayList<String>();
		selects.add("midpoint");
		selects.add("tree_method_default");
		this.e_options.add(new Option("Root Method", "-r", Option.SELECT, selects, 1, "Method for choosing root of phylo tree Valid choices are: midpoint, tree_method_default [default: tree_method_default]"));
	
	}
}