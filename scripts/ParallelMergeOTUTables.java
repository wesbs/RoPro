package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ParallelMergeOTUTables extends Script {
	public static String title = "Parallel Merge OTU Tables";
	public static String b_desc = "Parallel merge BIOM tables";

	public ParallelMergeOTUTables() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/parallel_merge_otu_tables.html";
		this.c_name = SCRIPTS_PATH + "parallel_merge_otu_tables.py";
		this.l_desc = "This script works like the merge_otu_tables.py script, but is intended to make use of multicore/multiprocessor environments to perform analyses in parallel.";
		this.output_desc = "The output consists of many files (i.e. merged_table.biom, merged_table.log and all intermediate merge tables). The .biom file contains the result of merging the individual BIOM tables. The resulting .log file contains a list of parameters passed to this script along with the output location of the resulting .txt file, the dependency hierarchy and runtime information for each individual merge.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("OTU Tables", "-i", Option.PATH, 0, "The otu tables in biom format (comma-separated)"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output otu table directory path"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Submit Torque?", "-C", Option.NOARG, "Submit to a torque cluster"));
		this.e_options.add(new Option("Seconds to Sleep", "-Z", Option.NUM, "Number of seconds to sleep between checks for run completion when polling runs [default: 1]"));
		this.e_options.add(new Option("Job Prefix", "-X", Option.INPUT, "Job prefix [default: descriptive prefix + random chars]"));
	
	}
}