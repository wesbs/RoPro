package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class LoadRemoteMapping extends Script {
	public static String title = "Load Remote Mapping File";
	public static String b_desc = "Downloads and saves a remote mapping file";

	public LoadRemoteMapping() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/load_remote_mapping_file.html";
		this.c_name = SCRIPTS_PATH + "load_remote_mapping_file.py";
		this.l_desc = "This script exports, downloads, and saves a mapping file that is stored remotely. Currently, the only type of remote mapping file that is supported is a Google Spreadsheet, though other methods of remote storage may be supported in the future.<br><br>For more information and examples pertaining to this script and remote mapping files in general, please refer to the accompanying tutorial, which can be found at http://qiime.org/tutorials/remote_mapping_files.html.";
		this.output_desc = "The script outputs a single file, which is the metadata mapping file obtained from the remote location (in QIIME-compatible format).";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Spreadsheet Key", "-k", Option.INPUT, "The spreadsheet key that will be used to identify the Google Spreadsheet to load. This is the part of the Google Spreadsheet URL that comes after ‘key=’. You may instead provide the entire URL and the key will be extracted from it. If you provide the entire URL, you may need to enclose it in single quotes"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Worksheet Name", "-w", Option.INPUT, "The name of the worksheet in the Google Spreadsheet that contains the mapping file. If the worksheet name contains spaces, please include quotes around the name. [default: the first worksheet in the Google Spreadsheet will be used]"));
	
	}
}