package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class AlphaRarefaction extends Script {
		public static String title = "Alpha Rarefaction";
		public static String b_desc = "A workflow script for performing alpha rarefaction";

	public AlphaRarefaction() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/alpha_rarefaction.html";
		this.c_name = SCRIPTS_PATH + "alpha_rarefaction.py";
		this.l_desc = "The steps performed by this script are: Generate rarefied OTU tables; compute alpha diversity metrics for each rarefied OTU table; collate alpha diversity results; and generate alpha rarefaction plots.";
		this.output_desc = "The primary interface for the results will be OUTPUT_DIR/alpha_rarefaction_plots/rarefaction_plots.html where OUTPUT_DIR is the value you specify with -o. You can open this in a web browser for interactive alpha rarefaction plots.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Input OTU Table", "-i", Option.PATH, "The input otu table [REQUIRED]"));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "Path to the mapping file [REQUIRED]"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output directory [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(10);
		this.e_options.add(new Option("Parameter File", "-p", Option.PATH, "Path to the parameter file, which specifies changes to the default behavior. See http://www.qiime.org/documentation/file_formats.html#qiime-parameters . [if omitted, default values will be used]"));
		this.e_options.add(new Option("Number of Steps", "-n", Option.NUM, "Number of steps (or rarefied OTU table sizes) to make between min and max counts [default: 10]"));
		this.e_options.add(new Option("Force Overwrite?", "-f", Option.NOARG, "Force overwrite of existing output directory (note: existing files in output_dir will not be removed) [default: None]"));
		this.e_options.add(new Option("Print Commands?", "-w", Option.NOARG, "Print the commands but don’t call them – useful for debugging [default: False]"));
		this.e_options.add(new Option("Run in Parallel?", "-p", Option.NOARG, "Run in parallel where available [default: False]"));
		this.e_options.add(new Option("Tree File", "-t", Option.PATH, "Path to the tree file [default: None; REQUIRED for phylogenetic measures]"));
		this.e_options.add(new Option("Min Rarefaction Depth", "--min_rare_depth", Option.NUM, "The lower limit of rarefaction depths [default: 10]"));
		this.e_options.add(new Option("Max Rarefaction Depth", "-e", Option.NUM, "The upper limit of rarefaction depths [default: median sequence/sample count]"));
		this.e_options.add(new Option("Number of Jobs", "-O", Option.NUM, "Number of jobs to start. NOTE: you must also pass -a to run in parallel, this defines the number of jobs to be started if and only if -a is passed [default: 1]"));
		this.e_options.add(new Option("Retain Files?", "--retain_intermediate_files", Option.NOARG, "Retain intermediate files: rarefied OTU tables (rarefaction) and alpha diversity results (alpha_div). By default these will be erased [default: False]"));
	
	}
}