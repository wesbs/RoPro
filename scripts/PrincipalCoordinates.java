package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class PrincipalCoordinates extends Script {
	public static String title = "Principal Coordinates";
	public static String b_desc = "Principal Coordinates Analysis (PCoA)";

	public PrincipalCoordinates() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/principal_coordinates.html";
		this.c_name = SCRIPTS_PATH + "principal_coordinates.py";
		this.l_desc = "Principal Coordinate Analysis (PCoA) is commonly used to compare groups of samples based on phylogenetic or count-based distance metrics (see section on beta_diversity.py).";
		this.output_desc = "The resulting output file consists of the principal coordinate (PC) axes (columns) for each sample (rows). Pairs of PCs can then be graphed to view the relationships between samples. The bottom of the output file contains the eigenvalues and % variation explained for each PC. For more information of the file format, check the OrdinationResults class in the scikit-bio package (http://scikit-bio.org/)";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Distance Matrix Directory/File", "-i", Option.PATH, "Path to the input distance matrix file(s) (i.e., the output from beta_diversity.py). Is a directory for batch processing and a filename for a single file operation."));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output path. directory for batch processing, filename for single file operation"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(0);
		// this.e_options.add(new Option());
	
	}
}