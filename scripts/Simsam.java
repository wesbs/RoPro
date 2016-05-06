package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class Simsam extends Script {
	public static String title = "Simsam";
	public static String b_desc = "Simulate samples for each sample in an OTU table, using a phylogenetic tree.";

	public Simsam() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/simsam.html";
		this.c_name = SCRIPTS_PATH + "simsam.py";
		this.l_desc = "This script makes n samples related to each sample in an input otu table An input OTU table with 3 samples and n=2 will result in an output OTU table with 6 samples total: 3 clusters of 2 related samples. To simulate each of the new samples, this script uses a sample in the input OTU table, and for each OTU in that sample the script traverses rootward on the tree a distance specified by ‘-d’ to a point x. It then randomly selects a tip that decends from x, (call that new tip ‘o2’), and reassigns all observations of the original OTU to the tip/OTU ‘o2’.";
		this.output_desc = "The output directory will contain an OTU table with samples named: ‘original_sample_0, original_sample_1 ...’<br><br>If a mapping file is provided via -m, an output mapping file containing the replicated sample IDs (with all other metadata columns copied over) will also be created.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(5);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "The input otu table"));
		this.r_options.add(new Option("Tree File", "-t", Option.PATH, "Tree file"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to the output directory"));
		this.r_options.add(new Option("Dissimilarity", "-d", Option.INPUT, "Dissimilarity between nodes up the tree, as a single value or comma-separated list of values"));
		this.r_options.add(new Option("Number of Samples", "-n", Option.INPUT, "Number of simulated samples per input sample, as a single value or comma-separated list of values"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Mapping File", "-m", Option.PATH, "The mapping filepath. If provided, an output mapping file containing the replicated sample IDs (with all other metadata columns copied over) will also be created [default: None]"));
	
	}
}

// package scripts;

// import java.io.*;
// import java.lang.String;
// import java.util.*;

// public class BlastWrapper extends Script {
// 	public static String title = 
// 	public static String b_desc = 

// 	public BlastWrapper() {
// 		// set up script name, command, and descriptions
// 		this.link = 
// 		this.c_name = SCRIPTS_PATH + 
// 		this.l_desc = 
// 		this.output_desc = 

// 		// set up the required otpions
// 		this.r_options = new ArrayList<Option>();
// 		this.r_options.add(new Option());

// 		// set up the extra options
// 		this.e_options = new ArrayList<Option>();
// 		this.e_options.add(new Option());
	
// 	}
// }