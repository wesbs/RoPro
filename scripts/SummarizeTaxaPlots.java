package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class SummarizeTaxaPlots extends Script {
	public static String title = "Summarize Taxa Through Plots";
	public static String b_desc = "A workflow script for performing taxonomy summaries and plots";

	public SummarizeTaxaPlots() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/summarize_taxa_through_plots.html";
		this.c_name = SCRIPTS_PATH + "summarize_taxa_through_plots.py";
		this.l_desc = "The steps performed by this script are: Summarize OTU by Category (optional, pass -c); Summarize Taxonomy; and Plot Taxonomy Summary";
		this.output_desc = "The results of this script is a folder (specified by -o) containing taxonomy summary files (at different levels) and a folder containing taxonomy summary plots. Additionally, if a mapping_catgory is supplied there will be a summarized OTU table. The primary interface for this output are the OUTPUT_DIR/taxa_summary_plots/*html files which are interactive plots that can be opened in a web browser (see the mouse-overs for interactivity).";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "The input otu table [REQUIRED]"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output directory [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(6);
		this.e_options.add(new Option("Parameter File", "-p", Option.PATH, "Path to the parameter file, which specifies changes to the default behavior. See http://www.qiime.org/documentation/file_formats.html#qiime-parameters. [if omitted, default values will be used]"));
		this.e_options.add(new Option("Mapping File", "-m", Option.PATH, "Path to the mapping file [REQUIRED if passing -c]"));
		this.e_options.add(new Option("Force Overwrite?", "-f", Option.NOARG, "Force overwrite of existing output directory (note: existing files in output_dir will not be removed) [default: None]"));
		this.e_options.add(new Option("Print Only?", "-w", Option.NOARG, "Print the commands but don’t call them – useful for debugging [default: False]"));
		this.e_options.add(new Option("Mapping Category", "-c", Option.INPUT, "Summarize OTU table using this category. [default: None]"));
		this.e_options.add(new Option("Sort OTU Table?", "-s", Option.NOARG, "Sort the OTU Table [default: False]"));
	
	}
}