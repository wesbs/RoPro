package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class CompareTrajectories extends Script {
	public static String title = "Compare Trjectories";
	public static String b_desc = "Run analysis of volatility using a variety of algorithms";

	public CompareTrajectories() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/compare_trajectories.html";
		this.c_name = SCRIPTS_PATH + "compare_trajectories.py";
		this.l_desc = "This script mainly allows performing analysis of volatility on time series data, but they can be applied to any data that contains a gradient. The methods available are RMS (either using ‘avg’ or ‘trajectory’); or the first difference (using ‘diff’), or ‘wdiff’ for a modified first difference algorithm. The trajectories are computed as follows. For ‘avg’ it calculates the average point within a group and then computes the norm of the distance of each sample from the averaged value. For ‘trajectory’ each component of the result trajectory is computed as taking the sorted list of samples in the group and taking the norm of the coordinates of the 2nd samples minus the 1st sample, 3rd sample minus 2nd sample and so on. For ‘diff’ it calculates the norm for all the time-points and then calculates the first difference for each resulting point. For ‘wdiff’, it calculates the norm for all the time-points and substracts the mean of the next number of elements, specified using the ‘–window_size’ parameters, and the current element.";
		this.output_desc = "This script generates two files in the output directory, ‘trajectories.txt’ and ‘trajectories_raw_values.txt’. The ‘trajectories.txt’ file includes the resulting statistics and a list of categories that did not passed the tests to run the analysis. The ‘trajectories_raw_values.txt’ file includes the resulting trajectory for each used category.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(4);
		this.r_options.add(new Option("Input Ordination Results", "-i", Option.PATH, "Input ordination results filepath"));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "Input metadata mapping filepath"));
		this.r_options.add(new Option("Categories", "-c", Option.INPUT, "Comma-separated list of category names of the mapping file to use to create the trajectories"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Name of the output directory to save the results"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(5);
		this.e_options.add(new Option("Sort By", "-s", Option.INPUT, "Category name of the mapping file to use to sort"));
		List<String> selects = new ArrayList<String>();
		selects.add("avg");
		selects.add("trajectory");
		selects.add("diff");
		selects.add("wdiff");
		this.e_options.add(new Option("Algorithm", "--algorithm", Option.SELECT, selects, 0, "The algorithm to use. Available methods: [‘avg’, ‘trajectory’, ‘diff’, ‘wdiff’]. [Default: avg]"));
		this.e_options.add(new Option("Number of Axes", "--axes", Option.NUM, "The number of axes to account while doing the trajectory specific calculations. We suggest using 3 because those are the ones being displayed in the plots but you could use any number between 1 and number of samples - 1. To use all of them pass 0. [default: 3]"));
		this.e_options.add(new Option("Weight by Vector", "-w", Option.NOARG, "Use -w when you want the output to be weighted by the space between samples in the –sort_by column, i. e. days between samples [default: False]"));
		this.e_options.add(new Option("Window Size", "--window_size", Option.NUM, "Use –window_size, when selecting the modified first difference (‘wdiff’) option for –algorithm. This integer determines the number of elements to be averaged per element subtraction, the resulting trajectory. [default: None]"));
	}
}