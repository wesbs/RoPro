package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MergeMappingFiles extends Script {
	public static String title = "Merge Mapping Files";
	public static String b_desc = "Merge mapping files";

	public MergeMappingFiles() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/merge_mapping_files.html";
		this.c_name = SCRIPTS_PATH + "merge_mapping_files.py";
		this.l_desc = "This script provides a convenient interface for merging mapping files which contain data on different samples.";
		this.output_desc = "The result of this script is a merged mapping file (tab-delimited).";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Mapping Files", "-m", Option.PATH, 0, "The input mapping files in a comma-separated list"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The input mapping files in a comma-separated list"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		this.e_options.add(new Option("Fill Missing Data", "-n", Option.INPUT, "Value to represent missing data (i.e., when all fields are not defined in all mapping files) [default: no_data]"));
		this.e_options.add(new Option("Case Insensitive?", "--case_insensitive", Option.NOARG, "If present the headers will be merged case insensitivly and transformed to upper case [default: False]"));
	
	}
}