package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakeOTUHeatmap extends Script {
	public static String title = "Make OTU Heatmap";
	public static String b_desc = "Plot heatmap of OTU table";

	public MakeOTUHeatmap() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_otu_heatmap.html";
		this.c_name = SCRIPTS_PATH + "make_otu_heatmap.py";
		this.l_desc = "This script visualizes an OTU table as a heatmap where each row corresponds to an OTU and each column corresponds to a sample. The higher the relative abundance of an OTU in a sample, the more intense the color at the corresponsing position in the heatmap. By default, the OTUs (rows) will be clustered by UPGMA hierarchical clustering, and the samples (columns) will be presented in the order in which they appear in the OTU table. Alternatively, the user may supply a tree to sort the OTUs (rows) or samples (columns), or both. The user may also pass in a mapping file for sorting samples. If the user passes in a mapping file and a metadata category, samples (columns) will be grouped by category value and subsequently clustered within each group.";
		this.output_desc = "A single output file is created containing the heatmap of the OTU table (a PDF file by default).";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "Path to the input OTU table (i.e., the output from make_otu_table.py)"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(15);
		this.e_options.add(new Option("Tree File", "-t", Option.PATH, "Tree file to be used for sorting OTUs in the heatmap"));
		this.e_options.add(new Option("Mapping File", "-m", Option.PATH, "Metadata mapping file to be used for sorting Samples in the heatmap."));
		this.e_options.add(new Option("Category", "-c", Option.INPUT, "Metadata category for sorting samples. Samples will be clustered within each category level using euclidean UPGMA."));
		this.e_options.add(new Option("Sample Tree", "-s", Option.PATH, "Tree file to be used for sorting samples (e.g, output from upgma_cluster.py). If both this and the sample mapping file are provided, the mapping file is ignored."));
		List<String> selects = new ArrayList<String>();
		selects.add("png");
		selects.add("svg");
		selects.add("pdf");
		this.e_options.add(new Option("Image Type", "-g", Option.SELECT, selects, 2, "Type of image to produce (i.e. png, svg, pdf) [default: pdf]"));
		this.e_options.add(new Option("No Log Transform?", "--no_log_transform", Option.NOARG, "Data will not be log-transformed. Without this option, all zeros will be set to a small value (default is 1/2 the smallest non-zero entry). Data will be translated to be non-negative after log transform, and num_otu_hits will be set to 0."));
		this.e_options.add(new Option("Suppress Row Clustering?", "--suppress_row_clustering", Option.NOARG, "No UPGMA clustering of OTUs (rows) is performed. If –otu_tree is provided, this flag is ignored."));
		this.e_options.add(new Option("Suppress Column Clustering?", "--suppress_column_clustering", Option.NOARG, "No UPGMA clustering of Samples (columns) is performed. If –map_fname is provided, this flag is ignored."));
		this.e_options.add(new Option("Normalize Samples?", "--absolute_abundance", Option.NOARG, "Do not normalize samples to sum to 1 [default: False]"));
		this.e_options.add(new Option("Color Scheme", "--color_scheme", Option.INPUT, "Color scheme for figure. see http://matplotlib.org/examples/color/colormaps_reference.html for choices [default: YlGn]"));
		this.e_options.add(new Option("Width", "--width", Option.NUM, "Width of the figure in inches [default: 5]"));
		this.e_options.add(new Option("Height", "--height", Option.NUM, "Height of the figure in inches [default: 5]"));
		this.e_options.add(new Option("Resolution", "--dpi", Option.NUM, "Resolution of the figure in dots per inch [default: value of savefig.dpi in matplotlibrc file]"));
		this.e_options.add(new Option("Observation Category", "--obs_md_category", Option.INPUT, "Observation metadata category to plot [default: taxonomy]"));
		this.e_options.add(new Option("Observatio Level", "--obs_md_level", Option.NUM, "The level of observation metadata to plot for hierarchical metadata [default: lowest level]"));
	
	}
}