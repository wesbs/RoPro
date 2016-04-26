package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class DissimilarityMatrixStats extends Script {
	public static String title = "Dissimilarity Matrix Stats";
	public static String b_desc = "Calculate mean, median and standard deviation from a set of distance matrices";

	public DissimilarityMatrixStats() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/dissimilarity_mtx_stats.html";
		this.c_name = SCRIPTS_PATH + "dissimilarity_mtx_stats.py";
		this.l_desc = "This script reads in all (dis)similarity matrices from an input directory (input_dir), then calculates and writes the mean, median, standdard deviation (stdev) to an output folder.<br><br>The input_dir must contain only (dis)similarity matrices, and only those you wish to perform statistical analyses on.";
		this.output_desc = "The outputs are in distance matrix format, where each value is the mean, median, or stdev of that element in all the input distance matrices.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input", "-i", Option.PATH, "Path to input directory"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to input directory"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(0);
		// this.e_options.add(new Option());
	
	}
}