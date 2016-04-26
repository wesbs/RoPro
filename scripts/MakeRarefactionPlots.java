package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakeRarefactionPlots extends Script {
	public static String title = "Make Rarefaction Plots";
	public static String b_desc = "Generate Rarefaction Plots";

	public MakeRarefactionPlots() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_rarefaction_plots.html";
		this.c_name = SCRIPTS_PATH + "make_rarefaction_plots.py";
		this.l_desc = "Once the batch alpha diversity files have been collated, you may want to compare the diversity using plots. Using the results from collate_alpha.py, you can plot the samples and or by category in the mapping file using this script.<br><br>This script creates an html file of rarefaction plots based on the supplied collated alpha-diversity files in a folder or a comma-separated list of files, by passing the “-i” option. Be aware that this script produces many images for the interactive html pages, so you may choose to not create these pages. The user may also supply optional arguments like an image type (-g), and a resolution (-d).";
		this.output_desc = "The result of this script produces a folder and within that folder there is a sub-folder containing image files. Within the main folder, there is an html file.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input Directory", "-i", Option.PATH, "Input directory containing results from collate_alpha.py. [REQUIRED]"));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "Input metadata mapping filepath. [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(13);
		this.e_options.add(new Option("Categories", "-b", Option.INPUT, "Comma-separated list categories metadata categories (column headers) to color by in the plots. The categories must match the name of a column header in the mapping file exactly. Multiple categories can be list by comma separating them without spaces. The user can also combine columns in the mapping file by separating the categories by “&&” without spaces. [default=color by all]"));
		this.e_options.add(new Option("Preference File", "-p", Option.PATH, "Input user-generated preferences filepath. NOTE: This is a file with a dictionary containing preferences for the analysis. [default: None]"));
		this.e_options.add(new Option("Background Color", "-k", Option.INPUT, "Background color to use in the plots[default: white]"));
		List<String> selects = new ArrayList<String>();
		selects.add("png");
		selects.add("svg");
		selects.add("pdf");
		this.e_options.add(new Option("Image Type", "-g", Option.SELECT, selects, 2, "Type of image to produce (i.e. png, svg, pdf). WARNING: Some formats may not properly open in your browser! [default: png]"));
		this.e_options.add(new Option("Resolution", "-d", Option.NUM, "Resolution of the plot. [default: 75]"));
		this.e_options.add(new Option("Y-Axis Max", "--ymax", Option.NUM, "Maximum y-value to be used for the plots. Allows for directly comparable rarefaction plots between analyses [default: None]"));
		this.e_options.add(new Option("Webpage?", "-w", Option.NOARG, true, "DEPRECATED: Suppress HTML output. [default: True]"));
		this.e_options.add(new Option("Suppress HTML?", "-s", Option.NOARG, "Suppress HTML output. [default: False]"));
		selects = new ArrayList<String>();
		selects.add("stddev");
		selects.add("stderr");
		this.e_options.add(new Option("Calculation", "-e", Option.SELECT, selects, 0, "Calculation to perform for generating error bars. Options are standard deviation (stddev) or standard error (stderr). [default: stddev]"));
		selects = new ArrayList<String>();
		selects.add("file_creation");
		selects.add("memory");
		this.e_options.add(new Option("Output Type", "--output_type", Option.SELECT, selects, 0, "Write the HTML output as one file, images embedded, or several. Options are “file_creation” and “memory”. [default: file_creation]"));
		this.e_options.add(new Option("Per Sample Plots?", "--generate_per_sample_plots", Option.NOARG, "Generate per sample plots for each of the metadata categories. This will allow you to show/hide samples from the plots but will require a longer processing time. In general, this option is useful only for small datasets. [default: False]"));
		this.e_options.add(new Option("Average Tables?", "--generate_average_tables", Option.NOARG, "Generate average tables of results. A summary of the metrics and alpha diversity measurements. [default: False]"));
	
	}
}