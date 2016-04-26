package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakeDistBoxplots extends Script {
	public static String title = "Make Distance Boxplots";
	public static String b_desc = "Creates boxplots to compare distances between categories";

	public MakeDistBoxplots() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_distance_boxplots.html";
		this.c_name = SCRIPTS_PATH + "make_distance_boxplots.py";
		this.l_desc = "This script creates boxplots that allow for the comparison between different categories found within the mapping file. The boxplots that are created compare distances within all samples of a field value, as well as between different field values. Individual within and between distances are also plotted.<br><br>The script also performs two-sample t-tests for all pairs of boxplots to help determine which boxplots (distributions) are significantly different.<br><br>Tip: the script tries its best to fit everything into the plot, but there are cases where plot elements may get cut off (e.g. if axis labels are extremely long), or things may appear squashed, cluttered, or too small (e.g. if there are many boxplots in one plot). Increasing the width and/or height of the plot (using –width and –height) usually fixes these problems.<br><br>For more information and examples pertaining to this script, please refer to the accompanying tutorial, which can be found at http://qiime.org/tutorials/creating_distance_comparison_plots.html.";
		this.output_desc = "Images of the plots are written to the specified output directory (one image per field). The raw data used in the plots and the results of significance tests can optionally be written into tab-delimited files (one file per field) that are most easily viewed in a spreadsheet program such as Microsoft Excel.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(4);
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "The mapping filepath"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to the output directory"));
		this.r_options.add(new Option("Distance Matrix", "-d", Option.PATH, "Input distance matrix filepath (i.e. the result of beta_diversity.py). WARNING: Only symmetric, hollow distance matrices may be used as input. Asymmetric distance matrices, such as those obtained by the UniFrac Gain metric (i.e. beta_diversity.py -m unifrac_g), should not be used as input"));
		this.r_options.add(new Option("Fields", "-f", Option.INPUT, "Comma-separated list of fields to compare, where the list of fields should be in quotes (e.g. “Field1,Field2,Field3”)"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(19);
		List<String> selects = new ArrayList<String>();
		selects.add("png");
		selects.add("svg");
		selects.add("pdf");
		this.e_options.add(new Option("Image Type", "-g", Option.SELECT, selects, 2, "Type of image to produce (i.e. png, svg, pdf) [default: pdf]"));
		this.e_options.add(new Option("Save Raw Data?", "--save_raw_data", Option.NOARG, "Store raw data used to create boxplots in tab-delimited files [default: False]"));
		this.e_options.add(new Option("Suppress All Within?", "--suppress_all_within", Option.NOARG, "Suppress plotting of “all within” boxplot [default: False]"));
		this.e_options.add(new Option("Suppress All Between?", "--suppress_all_between", Option.NOARG, "Suppress plotting of “all between” boxplot [default: False]"));
		this.e_options.add(new Option("Suppress Individual Within?", "--suppress_indiviual_within", Option.NOARG, "Suppress plotting of individual “within” boxplot(s) [default: False]"));
		this.e_options.add(new Option("Suppress Individual Between?", "--suppress_indiviual_between", Option.NOARG, "Suppress plotting of individual “between” boxplot(s) [default: False]"));
		this.e_options.add(new Option("Suppress SIgnificance Tests?", "--suppress_significance_tests", Option.NOARG, "Suppress performing signifance tests between each pair of boxplots [default: False]"));
		this.e_options.add(new Option("Num of Permutations", "-n", Option.NUM, "The number of Monte Carlo permutations to perform when calculating the nonparametric p-value in the significance tests. Must be an integer greater than or equal to zero. If zero, the nonparametric p-value will not be calculated and will instead be reported as “N/A”. This option has no effect if –suppress_significance_tests is supplied [default: 0]"));
		selects = new ArrayList<String>();
		selects.add("low");
		selects.add("high");
		selects.add("two-sided");
		this.e_options.add(new Option("Tail Type", "-t", Option.SELECT, selects, 2, "The type of tail test to compute when calculating the p-values in the significance tests. “high” specifies a one-tailed test for values greater than the observed t statistic, while “low” specifies a one-tailed test for values less than the observed t statistic. “two-sided” specifies a two-tailed test for values greater in magnitude than the observed t statistic. This option has no effect if –suppress_significance_tests is supplied. Valid choices: low or high or two-sided [default: two-sided]"));
		this.e_options.add(new Option("Y-Axis Min", "--y_min", Option.NUM, "The minimum y-axis value in the resulting plot. If “auto”, it is automatically calculated [default: 0]"));
		this.e_options.add(new Option("Y-Axis Max", "--y_max", Option.NUM, "The maximum y-axis value in the resulting plot. If “auto”, it is automatically calculated [default: 1]"));
		this.e_options.add(new Option("Width", "--width", Option.NUM, "Width of the output image in inches. If not provided, a “best guess” width will be used [default: auto]"));
		this.e_options.add(new Option("Height", "--height", Option.NUM, "Height of the output image in inches [default: 6]"));
		this.e_options.add(new Option("Transparent?", "--transparent", Option.NOARG, "Make output images transparent (useful for overlaying an image on top of a colored background) [default: False]"));
		this.e_options.add(new Option("Whisker Length", "--whisker_length", Option.NUM, "Length of the whiskers as a function of the IQR. For example, if 1.5, the whiskers extend to 1.5 * IQR. Anything outside of that range is seen as an outlier [default: 1.5]"));
		this.e_options.add(new Option("Box Width", "--box_width", Option.NUM, "Width of each box in plot units [default: 0.5]"));
		this.e_options.add(new Option("Box Color", "--box_color", Option.INPUT, "The color of the boxes. Can be any valid matplotlib color string, such as “black”, “magenta”, “blue”, etc. See http://matplotlib.sourceforge.net/api/colors_api.html for more examples of valid color strings that may be used. Will be ignored if –color_individual_within_by_field is supplied [default: same as plot background, which is white unless –transparent is enabled]"));
		this.e_options.add(new Option("Color Individual", "--color_individual_within_by_field", Option.INPUT, "Field in the the mapping file to color the individual “within” boxes by. A legend will be provided to match boxplot colors to field states. A one-to-one mapping must exist between the field to be colored and the field to color by, otherwise the coloring will be ambiguous. If this option is supplied, –box_color will be ignored. If –suppress_individual_within is supplied, this option will be ignored [default: None]"));
		this.e_options.add(new Option("Sort", "--sort", Option.INPUT, "If “median”, sort boxplots by increasing median. If “alphabetical”, sort boxplots alphabetically by their labels. If this option is not supplied (the default), boxplots will be grouped logically as follows: all within, all between, individual within, and individual between [default: None]"));
	
	}
}