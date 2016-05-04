package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class TRFLPtoOTU extends Script {
	public static String title = "TRFLP File to OTU Table";
	public static String b_desc = "Convert TRFLP text file to an OTU table";

	public TRFLPtoOTU() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/trflp_file_to_otu_table.html";
		this.c_name = SCRIPTS_PATH + "trflp_file_to_otu_table.py";
		this.l_desc = "The input for this script is a TRLFP text file. The output of this script is an OTU table text file that can be use with QIIME for further analysis";
		this.output_desc = "No Descriptoion";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("TRFLP File", "-i", Option.PATH, "Input path: TRFLP text file"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output file: OTU table"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(0);
		// this.e_options.add(new Option());
	
	}
}