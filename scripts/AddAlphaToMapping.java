package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class AddAlphaToMapping extends Script {
		public static String title = "Add Alpha To Mapping File";
		public static String b_desc = "Add alpha diversity data to a metadata mapping file";
	
	public AddAlphaToMapping() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/add_alpha_to_mapping_file.html";
		this.c_name = SCRIPTS_PATH + "add_alpha_to_mapping_file.py";
		this.l_desc = "Add alpha diversity data to a mapping file for use with other QIIME scripts, i. e. make_emperor. The resulting mapping file will contain three new columns per metric in the alpha diversity data; the first column being the raw value, the second being a normalized raw value and the third one a label classifying the bin where this value fits based on the normalized value.";
		this.output_desc = "The result of running this script is a metadata mapping file that will include 3 new columns per alpha diversity metric included in the alpha diversity file. For example, with an alpha diversity file with only PD_whole_tree, the new columns will PD_whole_tree_alpha, PD_whole_tree_normalized and PD_whole_tree_bin.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Aplha File", "-i", Option.PATH, "Alpha diversity data with one or multiple metrics i. e. the output of alpha_diversity.py. This can also be a comma-separated list of collated alpha diversity file paths i. e. the output of collate_alpha.py, when using collated alpha diversity data the –depth option is required"));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "Mapping file to modify by adding the alpha diversity data"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(6);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Filepath for the modified mapping file [default: mapping_file_with_alpha.txt]"));
		this.e_options.add(new Option("Number of Bins", "-b", Option.NUM, "Number of bins [default: 4]."));
		this.e_options.add(new Option("Bin Prefix", "-x", Option.INPUT, "Bin prefix name for the sample identifiers that exist in the mapping file (mapping_fp) but not in the alpha diversity file (alpha_fp) [default: N/A]."));
		List<String> selects = new ArrayList<String>();
		selects.add("equal");
		selects.add("quantile");
		this.e_options.add(new Option("Binning Method", "--binning_method", Option.SELECT, selects, 0, "Select the method name to create the bins, the options are ‘equal’ and ‘quantile’. Both methods work over the normalized alpha diversity values. On the one hand ‘equal’ will assign the bins on equally spaced limits, depending on the value of –number_of_bins i. e. if you select 4 the limits will be [0.25, 0.50, 0.75]. On the other hand ‘quantile’ will select the limits based on the –number_of_bins i. e. the limits will be the quartiles if 4 is selected [default: equal]."));
		this.e_options.add(new Option("Rarefaction Depth", "--depth", Option.NUM, "Select the rarefaction depth to use when the alpha_fps refers to collated alpha diversity file(s) i. e. the output of collate_alpha.py. All the iterations contained at this depth will be averaged to form a single mean value [default: highest depth available]."));
		this.e_options.add(new Option("Collated Input", "--collated_input", Option.NOARG, "Use to specify that the -i option is composed of collated alpha diversity data."));
	}
}