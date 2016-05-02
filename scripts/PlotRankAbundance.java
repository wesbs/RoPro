package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class PlotRankAbundance extends Script {
	public static String title = "Plot Rank Abundance Graph";
	public static String b_desc = "plot rank-abundance curve";

	public PlotRankAbundance() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/plot_rank_abundance_graph.html";
		this.c_name = SCRIPTS_PATH + "plot_rank_abundance_graph.py";
		this.l_desc = "Plot a set of rank-abundance graphs from an OTU table and a set of sample names. Multiple graphs will be plotted into the same figure, in order to allow for an easy comparison across samples.";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "Path to the input OTU table (i.e., the output from make_otu_table.py)"));
		this.r_options.add(new Option("Sample Name", "-s", Option.INPUT, "Name of the sample to plot. Use “*” to plot all."));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to store resulting figure file. File extension will be appended if not supplied (e.g.: rankfig -> rankfig.pdf). Additionally, a log file rankfig_log.txt will be created"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(5);
		this.e_options.add(new Option("Absolute Counts?", "-a", Option.NOARG, "Plot absolute abundance values instead of relative [default: False]"));
		this.e_options.add(new Option("No Legend?", "-n", Option.NOARG, "Do not draw a legend [default: False]"));
		this.e_options.add(new Option("X Linear Scale?", "-x", Option.NOARG, "Draw x axis in linear scale [default: False]"));
		this.e_options.add(new Option("Y Linear Scale", "-y", Option.NOARG, "Draw y axis in linear scale [default: False]"));
		List<String> selects = new ArrayList<String>();
		selects.add("pdf");
		selects.add("svg");
		selects.add("png");
		selects.add("eps");
		this.e_options.add(new Option("File Type", "-f", Option.SELECT, selects, 0, "Save plot using this image type. Choice of pdf, svg, png, eps [default: pdf]"));
	
	}
}