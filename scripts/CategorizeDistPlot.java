package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class CategorizeDistPlot extends Script {
	public static String title = "Categorize Distance Scatterplot";
	public static String b_desc = "Create a categorized distance scatterplot representing average distances between samples, broken down by categories";

	public CategorizeDistPlot() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/categorized_dist_scatterplot.html";
		this.c_name = SCRIPTS_PATH + "categorized_dist_scatterplot.py";
		this.l_desc = "Create a figure representing average distances between samples, broken down by categories. I call it a ‘categorized distance scatterplot’. See script usage for more details. The mapping file specifies the relevant data - if you have e.g. ‘N/A’ values or samples you don’t want included, first use filter_samples_from_otu_table.py to remove unwanted samples from the mapping file, and thus the analysis. Note that the resulting plot will include only samples in both the mapping file AND the distance matrix.";
		this.output_desc = "a figure and the text dat for that figure";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(5);
		this.r_options.add(new Option("Input Mapping File", "-m", Option.PATH, "Mapping file"));
		this.r_options.add(new Option("Distance Matrix", "-d", Option.PATH, "Distance matrix"));
		this.r_options.add(new Option("Primary State", "-p", Option.INPUT, "Samples matching this state will be plotted. E.g.: AgeCategory:Child . See qiime’s filter_samples_from_otu_table.py for more syntax options"));
		this.r_options.add(new Option("Axis Category", "-a", Option.INPUT, "This will form the horizontal axis of the figure, e.g.: AgeYears . Must be numbers"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output figure, filename extention determines format. E.g.: “fig1.png” or similar. A “fig1.txt” or similar will also be created with the data underlying the figure"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		this.e_options.add(new Option("Color By", "-c", Option.INPUT, "Samples will first be separated by this column of the mapping file. They will be colored by this column of the mapping file, and all comparisons will be done only among samples with the same value in this column. e.g.: Country. You may omit -c, and the samples will not be separated"));
		this.e_options.add(new Option("Secondary State", "-s", Option.INPUT, "All samples matching the primary state will be compared to samples matcthing this secondary state. E.g.: AgeCategory:Adult"));
	
	}
}