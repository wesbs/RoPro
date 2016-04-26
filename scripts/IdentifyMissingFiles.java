package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class IdentifyMissingFiles extends Script {
	public static String title = "Identify Missing Files";
	public static String b_desc = "This script checks for the existence of expected files in parallel runs.";

	public IdentifyMissingFiles() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/identify_missing_files.html";
		this.c_name = SCRIPTS_PATH + "identify_missing_files.py";
		this.l_desc = "This script checks for the existence of expected files in parallel runs, and is useful for checking the status of a parallel run or for finding out what poller.py is waiting on in a possibly failed run.";
		this.output_desc = "This script does not create any output files.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Expect Files", "-e", Option.PATH, "The list of expected output files"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(0);
		// this.e_options.add(new Option());
	
	}
}