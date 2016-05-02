package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class PlotTaxaSummary extends Script {
	public static String title = "Plot Taxa Summary";
	public static String b_desc = "Make taxaonomy summary charts based on taxonomy assignment";

	public PlotTaxaSummary() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/plot_taxa_summary.html";
		this.c_name = SCRIPTS_PATH + "plot_taxa_summary.py";
		this.l_desc = "This script automates the construction of pie, bar and area charts showing the breakdown of taxonomy by given levels. The script creates an html file for each chart type for easy visualization. It uses the taxonomy or category counts from summarize_taxa.py for combined samples by level (-i) and user specified labels for each file passed in (-l). Output will be written to the user specified folder (-o) the, where the default is the current working directory. The user can also specify the number of categories displayed for within a single pie chart, where the rest are grouped together as the ‘other category’ using the (-n) option, default is 20.";
		this.output_desc = "The script generates an output folder, which contains several files. For each pie chart there is a png and a pdf file. The best way to view all of the pie charts is by opening up the file taxonomy_summary_pie_chart.html.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Taxa Files", "-i", Option.PATH, 0, "Input comma-separated list of summarized taxa filepaths (i.e results from summarize_taxa.py) [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(15);
		this.e_options.add(new Option("Labels", "-l", Option.INPUT, "Comma-separated list of taxonomic levels (e.g. Phylum,Class,Order) [default=None]"));
		this.e_options.add(new Option("Max Categories", "-n", Option.NUM, "The maximum number of taxonomies to show in each pie chart. All additional taxonomies are grouped into an “other” category. NOTE: this functionality only applies to the pie charts. [default: 20]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Output directory"));
		this.e_options.add(new Option("Color By", "-b", Option.INPUT, "This is the categories to color by in the plots from the metadata mapping file. The categories must match the name of a column header in the mapping file exactly and multiple categories can be list by comma separating them without spaces. [default=None]"));
		this.e_options.add(new Option("Preference File", "-p", Option.PATH, "Input user-generated preferences filepath. NOTE: This is a file with a dictionary containing preferences for the analysis. The key taxonomy_coloring is used for the coloring. [default: None]"));
		this.e_options.add(new Option("Background Color", "-k", Option.INPUT, "This is the background color to use in the plots (black or white) [default: white]"));
		this.e_options.add(new Option("Plot Resolution", "-d", Option.NUM, "This is the resolution of the plot. [default: 80]"));
		this.e_options.add(new Option("X-Axis Width", "-x", Option.NUM, "This is the width of the x-axis to use in the plots. [default: 12]"));
		this.e_options.add(new Option("Y-Axis Height", "-y", Option.NUM, "This is the height of the y-axis to use in the plots. [default: 6]"));
		this.e_options.add(new Option("Bar Width", "-w", Option.NUM, "This the width of the bars in the bar graph and should be a number between 0 and 1. NOTE: this only applies to the bar charts. [default: 0.75]"));
		List<String> selects = new ArrayList<String>();
		selects.add("pdf");
		selects.add("svg");
		selects.add("png");
		this.e_options.add(new Option("File Type", "-t", Option.SELECT, selects, 0, "This is the type of image to produce (i.e. pdf,svg,png). [default: pdf]"));
		this.e_options.add(new Option("Chart Type", "-c", Option.INPUT, "This is the type of chart to plot (i.e. pie, bar or area). The user has the ability to plot multiple types, by using a comma-separated list (e.g. area,pie) [default: area,bar]"));
		this.e_options.add(new Option("Resize Nth Label", "-r", Option.NUM, "Make every nth label larger than the other lables. This is for large area and bar charts where the font on the x-axis is small. This requires an integer value greater than 0. [default: 0]"));
		this.e_options.add(new Option("Include HTML Legend?", "-s", Option.NOARG, "Include HTML legend. If present, the writing of the legend in the html page is included. [default: False]"));
		selects = new ArrayList<String>();
		selects.add("numeric");
		selects.add("categorical");
		this.e_options.add(new Option("Label Type", "-a", Option.SELECT, selects, 1, "Label type (“numeric” or “categorical”). If the label type is defined as numeric, the x-axis will be scaled accordingly. Otherwise the x-values will treated categorically and be evenly spaced [default: categorical]."));
	
	}
}