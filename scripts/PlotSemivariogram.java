package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class PlotSemivariogram extends Script {
	public static String title = "Plot Semivariogram";
	public static String b_desc = "Fits a model between two distance matrices and plots the result";

	public PlotSemivariogram() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/plot_semivariogram.html";
		this.c_name = SCRIPTS_PATH + "plot_semivariogram.py";
		this.l_desc = "Fits a spatial autocorrelation model between two matrices and plots the result. This script will work with two distance matrices but will ignore the 0s at the diagonal and the values that go to N/A. See distance_matrix_from_mapping.py.";
		this.output_desc = "The resulting output file consists of a pdf image containing the plot between the two distances matrices and the fitted model";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("X-Axis Distance Matrix", "-x", Option.PATH, "Path to distance matrix to be displayed in the x axis"));
		this.r_options.add(new Option("Y-Axis Distance Matrix", "-y", Option.PATH, "Path to distance matrix to be displayed in the y axis"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output path. directory for batch processing, filename for single file operation"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(18);
		this.e_options.add(new Option("Binning Ranges", "-b", Option.INPUT, "Binning ranges. Format: [increment,top_limit], when top_limit is -1=infinitum; you can specify several ranges using the same format, i.e. [2.5,10][50,-1] will set two bins, one from 0-10 using 2.5 size steps and from 10-inf using 50 size steps. Note that the binning is used to clean the plots (reduce number of points) but ignored to fit the model. [default: None]"));
		this.e_options.add(new Option("Ignore Missing Samples?", "--ignore_missing_samples", Option.NOARG, "This will overpass the error raised when the matrices have different sizes/samples"));
		this.e_options.add(new Option("X-Axis Max", "--x_max", Option.NUM, "X axis max limit [default: auto]"));
		this.e_options.add(new Option("X-Axis Min", "--x_min", Option.NUM, "X axis min limit [default: auto]"));
		this.e_options.add(new Option("Y-Axis Max", "--y_max", Option.NUM, "Y axis max limit [default: auto]"));
		this.e_options.add(new Option("Y-Axis Min", "--y_min", Option.NUM, "Y axis min limit [default: auto]"));
		this.e_options.add(new Option("X-Axis Label", "-X", Option.INPUT, "Label for the x axis [default: Distance Dissimilarity (m)]"));
		this.e_options.add(new Option("Y-Axis Label", "-Y", Option.INPUT, "Label for the y axis [default: Distance Dissimilarity (m)]"));
		this.e_options.add(new Option("Plot Title", "-t", Option.INPUT, "Title of the plot [default: Semivariogram]"));
		this.e_options.add(new Option("Dot Color", "--dot_color", Option.INPUT, "Dot color for plot, more info: http://matplotlib.sourceforge.net/api/pyplot_api.html [default: white]"));
		this.e_options.add(new Option("Dot Marker", "--dot_marker", Option.INPUT, "Dot color for plot, more info: http://matplotlib.sourceforge.net/api/pyplot_api.html [default: o]"));
		this.e_options.add(new Option("Line Color", "--line_color", Option.INPUT, "Line color for plot, more info: http://matplotlib.sourceforge.net/api/pyplot_api.html [default: blue]"));
		this.e_options.add(new Option("Dot Alpha", "--dot_alpha", Option.INPUT, "Alpha for dots, more info: http://matplotlib.sourceforge.net/api/pyplot_api.html [default: 1]"));
		this.e_options.add(new Option("Line Alpha", "--line_alpha", Option.INPUT, "Alpha for dots, more info: http://matplotlib.sourceforge.net/api/pyplot_api.html [default: 1]"));
		List<String> selects = new ArrayList<String>();
		selects.add("nugget");
		selects.add("exponential");
		selects.add("gaussian");
		selects.add("periodic");
		selects.add("linear");
		this.e_options.add(new Option("Model", "--model", Option.SELECT, selects, 1, "Model to be fitted to the data. Valid choices are:nugget, exponential, gaussian, periodic, linear. [default: exponential]"));
		this.e_options.add(new Option("Print Model?", "-p", Option.NOARG, "Print in the title of the plot the function of the fit. [default: False]"));
		this.e_options.add(new Option("Category", "-c", Option.INPUT, "Category to color each of the trajectories when you have multiple treatments [default: None]"));
		this.e_options.add(new Option("Mapping File", "-m", Option.PATH, "Metadata mapping file, only used when coloring by a category, a file with the legends and color coding will be created with the suffix legend [default: None]"));
	
	}
}