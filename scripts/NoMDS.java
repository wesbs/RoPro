package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class NoMDS extends Script {
	public static String title = "NMDS";
	public static String b_desc = "Nonmetric Multidimensional Scaling (NMDS)";

	public NoMDS() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/nmds.html";
		this.c_name = SCRIPTS_PATH + "nmds.py";
		this.l_desc = "Nonmetric Multidimensional Scaling (NMDS) is commonly used to compare groups of samples based on phylogenetic or count-based distance metrics (see section on beta_diversity.py).";
		this.output_desc = "The resulting output file consists of the NMDS axes (columns) for each sample (rows). Pairs of NMDS axes can then be graphed to view the relationships between samples. The bottom of the output file contains the stress of the ordination.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Distance Matrix File/Directory", "-i", Option.PATH, "Path to the input distance matrix file(s) (i.e., the output from beta_diversity.py). Is a directory for batch processing and a filename for a single file operation."));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output path. directory for batch processing, filename for single file operation"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Dimensions", "-d", Option.NUM, "Number of dimensions of NMDS spacedefault: 3"));
	
	}
}