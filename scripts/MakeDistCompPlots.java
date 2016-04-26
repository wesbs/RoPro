package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakeDistCompPlots extends Script {
	public static String title = "Make Distance Domparison Plots";
	public static String b_desc = "Creates plots comparing distances between sample groupings";

	public MakeDistCompPlots() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_distance_comparison_plots.html";
		this.c_name = SCRIPTS_PATH + "make_distance_comparison_plots.py";
		this.l_desc = "This script creates plots (bar charts, scatter plots, or box plots) that allow for the comparison between samples grouped at different field states of a mapping file field.<br><br>This script can work with any field in the mapping file, and it can compare any number of field states to all other field states within that field. This script may be especially useful for fields that represent a time series, because a plot can be generated showing the distances between samples at certain timepoints against all other timepoints.<br><br>For example, a time field might contain the values 1, 2, 3, 4, and 5, which label samples that are from day 1, day 2, day 3, and so on. This time field can be specified when the script is run, as well as the timepoint(s) to compare to every other timepoint. For example, two comparison groups might be timepoints 1 and 2. The resulting plot would contain timepoints for days 3, 4, and 5 along the x-axis, and at each of those timepoints, the distances between day 1 and that timepoint would be plotted, as well as the distances between day 2 and the timepoint.<br><br>The script also performs two-sample t-tests for all pairs of distributions to help determine which distributions are significantly different from each other.<br><br>Tip: the script tries its best to fit everything into the plot, but there are cases where plot elements may get cut off (e.g. if axis labels are extremely long), or things may appear squashed, cluttered, or too small (e.g. if there are many boxplots in one plot). Increasing the width and/or height of the plot (using –width and –height) usually fixes these problems.<br><br>For more information and examples pertaining to this script, please refer to the accompanying tutorial, which can be found at http://qiime.org/tutorials/creating_distance_comparison_plots.html.";
		this.output_desc = "An image of the plot is written to the specified output directory. The raw data used in the plots and the results of significance tests can optionally be written into tab-delimited files that are most easily viewed in a spreadsheet program such as Microsoft Excel.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(5);
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "The mapping filepath"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to the output directory"));
		this.r_options.add(new Option("Distance Matrix", "-d", Option.PATH, "Input distance matrix filepath (i.e. the result of beta_diversity.py). WARNING: Only symmetric, hollow distance matrices may be used as input. Asymmetric distance matrices, such as those obtained by the UniFrac Gain metric (i.e. beta_diversity.py -m unifrac_g), should not be used as input"));
		this.r_options.add(new Option("Field", "-f", Option.INPUT, "Field in the mapping file to make comparisons on"));
		this.r_options.add(new Option("Comparison Groups", "-c", Option.INPUT, "Comma-separated list of field states to compare to every other field state, where the list of field states should be in quotes (e.g. “FieldState1,FieldState2,FieldState3”)"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(16);
		List<String> selects = new ArrayList<String>();
		selects.add("bar");
		selects.add("scatter");
		selects.add("box");
		this.e_options.add(new Option("Plot Type", "-t", Option.SELECT, selects, 0, "Type of plot to produce (“bar” is bar chart, “scatter” is scatter plot, and “box” is box plot) [default: bar]"));
		selects = new ArrayList<String>();
		selects.add("png");
		selects.add("svg");
		selects.add("pdf");
		this.e_options.add(new Option("Image Type", "-g", Option.SELECT, selects, 2, "Type of image to produce (i.e. png, svg, pdf) [default: pdf]"));
		this.e_options.add(new Option("Save Raw Data?", "--save_raw_data", Option.NOARG, "Store raw data used to create plot in a tab-delimited file [default: False]"));
		this.e_options.add(new Option("Suppress Significance Tests", "--suppress_significance_tests", Option.NOARG, "Suppress performing signifance tests between each pair of distributions [default: False]"));
		this.e_options.add(new Option("Num of Permutations", "-n", Option.NUM, "The number of Monte Carlo permutations to perform when calculating the nonparametric p-value in the significance tests. Must be an integer greater than or equal to zero. If zero, the nonparametric p-value will not be calculated and will instead be reported as “N/A”. This option has no effect if –suppress_significance_tests is supplied [default: 0]"));
		selects = new ArrayList<String>();
		selects.add("low");
		selects.add("high");
		selects.add("two-sided");
		this.e_options.add(new Option("Tail Type", "--tail_type", Option.SELECT, selects, 2, "The type of tail test to compute when calculating the p-values in the significance tests. “high” specifies a one-tailed test for values greater than the observed t statistic, while “low” specifies a one-tailed test for values less than the observed t statistic. “two-sided” specifies a two-tailed test for values greater in magnitude than the observed t statistic. This option has no effect if –suppress_significance_tests is supplied. Valid choices: low or high or two-sided [default: two-sided]"));
		this.e_options.add(new Option("Width", "--width", Option.NUM, "Width of the output image in inches [default: 12]"));
		this.e_options.add(new Option("Height", "--height", Option.NUM, "Height of the output image in inches [default: 6]"));
		selects = new ArrayList<String>();
		selects.add("vertical");
		selects.add("horizontal");
		this.e_options.add(new Option("Orientation Type", "--", Option.SELECT, selects, 0, "Type of orientation for x-axis tick labels [default: vertical]"));
		selects = new ArrayList<String>();
		selects.add("numeric");
		selects.add("categorical");
		this.e_options.add(new Option("Label Type", "-a", Option.SELECT, selects, 1, "Label type (“numeric” or “categorical”). If the label type is defined as numeric, the x-axis will be scaled accordingly. Otherwise the x-values will treated categorically and will be evenly spaced [default: categorical]."));
		this.e_options.add(new Option("Y-Axis Min", "--y_min", Option.NUM, "The minimum y-axis value in the resulting plot. If “auto”, it is automatically calculated [default: 0]"));
		this.e_options.add(new Option("Y-Axis Max", "--y_max", Option.NUM, "The maximum y-axis value in the resulting plot. If “auto”, it is automatically calculated [default: 1]"));
		this.e_options.add(new Option("Transparent?", "--transparent", Option.NOARG, "Make output images transparent (useful for overlaying an image on top of a colored background ) [default: False]"));
		this.e_options.add(new Option("Whisker Length", "--whisker_length", Option.NUM, "If –plot_type is “box”, determines the length of the whiskers as a function of the IQR. For example, if 1.5, the whiskers extend to 1.5 * IQR. Anything outside of that range is seen as an outlier. If –plot_type is not “box”, this option is ignored [default: 1.5]"));
		selects = new ArrayList<String>();
		selects.add("stdv");
		selects.add("sem");
		this.e_options.add(new Option("Error Bar Type", "--error_bar_type", Option.SELECT, selects, 0, "If –plot_type is “bar”, determines the type of error bars to use. “stdv” is standard deviation and “sem” is the standard error of the mean. If –plot_type is not “bar”, this option is ignored [default: stdv]"));
		this.e_options.add(new Option("Distribution Width", "--distribution_width", Option.NUM, "Width (in plot units) of each individual distribution (e.g. each bar if the plot type is a bar chart, or the width of each box if the plot type is a boxplot) [default: auto]"));
	
	}
}