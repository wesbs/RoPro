package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class DenoiserPreprocess extends Script {
	public static String title = "Denoiser Preprocess";
	public static String b_desc = "Run phase of denoiser algorithm: prefix clustering";

	public DenoiserPreprocess() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/denoiser_preprocess.html";
		this.c_name = SCRIPTS_PATH + "denoiser_preprocess.py";
		this.l_desc = "The script denoiser_preprocess.py runs the first clustering phase which groups reads based on common prefixes.";
		this.output_desc = "prefix_dereplicated.sff.txt: human readable sff file containing the flowgram of the<br>cluster representative of each cluster.<br>prefix_dereplicated.fasta: Fasta file containing the cluster representative of each cluster.<br>prefix_mapping.txt: This file contains the actual clusters. The cluster centroid is given first,<br>the cluster members follw after the ‘:’.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Input Flowgram", "-i", Option.PATH, "Path to flowgram files (.sff.txt), comma separated"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(5);
		this.e_options.add(new Option("Input FASTA", "-f", Option.PATH, "Path to fasta input file [default: None]"));
		this.e_options.add(new Option("Squeeze?", "-s", Option.NOARG, "Use run-length encoding for prefix filtering [default: False]"));
		this.e_options.add(new Option("Log File", "-l", Option.PATH, "Path to log file [default: preprocess.log]"));
		this.e_options.add(new Option("Primer", "-p", Option.INPUT, "Primer sequence used for the amplification [default: CATGCTGCCTCCCGTAGGAGT]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to output directory [default: /tmp/]"));
	
	}
}