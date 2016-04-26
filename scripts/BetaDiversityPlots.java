package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class BetaDiversityPlots extends Script {
		// will need these two for script selection screen without initializing object
		public static String title = "Beta Diversity through Plots";
		public static String b_desc = "A workflow script for computing beta diversity distance matrices and generating PCoA plots";

	public BetaDiversityPlots() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/beta_diversity_through_plots.html";
		this.c_name = SCRIPTS_PATH + "beta_diversity_through_plots.py";
		this.b_desc = "A workflow script for computing beta diversity distance matrices and generating PCoA plots";
		this.l_desc = "This script will perform beta diversity, principal coordinate analysis, and generate a preferences file along with 3D PCoA Plots.";
		this.output_desc = "This script results in a distance matrix (from beta_diversity.py), a principal coordinates file (from principal_coordinates.py), and folders containing the resulting PCoA plots (accessible through html files).";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Input BIOM Table", "-i", Option.PATH, "The input biom table [REQUIRED]"));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "Path to the mapping file [REQUIRED]"));
		this.r_options.add(new Option("Output Directoy", "-o", Option.PATH, "The output directory [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(9);
		this.e_options.add(new Option("Tree File", "-t", Option.PATH, "Path to the tree file [default: None; REQUIRED for phylogenetic measures]"));
		this.e_options.add(new Option("Parameter File", "-p", Option.PATH, "Path to the parameter file, which specifies changes to the default behavior. See http://www.qiime.org/documentation/file_formats.html#qiime-parameters . [if omitted, default values will be used]"));
		this.e_options.add(new Option("Color?", "--color_by_all_fields", Option.NOARG, "Plots will have coloring for all mapping fields [default: False; only include fields with greater than one value and fewer values than the number of samples]"));
		this.e_options.add(new Option("Force Overwrite?", "-f", Option.NOARG, "Force overwrite of existing output directory (note: existing files in output_dir will not be removed) [default: None]"));
		this.e_options.add(new Option("Print Commands?", "-w", Option.NOARG, "Print the commands but don’t call them – useful for debugging [default: False]"));
		this.e_options.add(new Option("Parallel?", "-a", Option.NOARG, "Run in parallel where available [default: False]"));
		this.e_options.add(new Option("Depth", "-d", Option.NUM, "Depth of coverage for even sampling [default: None]"));
		this.e_options.add(new Option("Disallow Emporer?", "--suppress_emperor_plots", Option.NOARG, "Do not generate emperor plots [default: False]"));
		this.e_options.add(new Option("Number of Jobs", "-O", Option.NUM, "Number of jobs to start. NOTE: you must also pass -a to run in parallel, this defines the number of jobs to be started if and only if -a is passed [default: 1]"));
	
	}
}

// package scripts;

// import java.io.*;
// import java.lang.String;
// import java.util.*;

// public class AlignSeqs extends Script {
	
// 	public AlignSeqs() {
// 		// set up script name, command, and descriptions
// 		this.title = 
// 		this.link = 
// 		this.c_name = "scripts/scripts/"
// 		this.b_desc = 
// 		this.l_desc = 
// 		this.output_desc = 

// 		// set up the required otpions
// 		this.r_options = new ArrayList<Option>();
// 		this.r_options.add(new Option());

// 		// set up the extra options
// 		this.e_options = new ArrayList<Option>();
// 		this.e_options.add(new Option()));
	
// 	}
// }