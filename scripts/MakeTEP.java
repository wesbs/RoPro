package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakeTEP extends Script {
	public static String title = "Make TEP File";
	public static String b_desc = "Makes TopiaryExplorer project file";

	public MakeTEP() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_tep.html";
		this.c_name = SCRIPTS_PATH + "make_tep.py";
		this.l_desc = "This script makes a TopiaryExplorer project file (.tep) and a jnlp file with the data location preloaded.<br><br>WARNING: The jnlp file relies on an absolute path, if you move the .tep file, the generated jnlp will no longer work. However, you can still open the .tep file from your normal TopiaryExplorer install.";
		this.output_desc = "The result of this script is written to a .tep file and a .jnlp file, both with the name supplied by -o";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "Path to the input OTU table (i.e., the output from make_otu_table.py)"));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "The mapping filepath"));
		this.r_options.add(new Option("Tree File", "-t", Option.PATH, "Path to tree"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(4);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to the output directory"));
		this.e_options.add(new Option("Preference File", "-p", Option.PATH, "Path to prefs file"));
		this.e_options.add(new Option("Web Flag", "-w", Option.NOARG, "Web codebase jnlp flag [default: False]"));
		this.e_options.add(new Option("TEP URL", "-u", Option.INPUT, "Url path for the tep file. Note: when passing this flag, it will overwrite the supplied OTU table, Mapping and Tree files.;"));
	
	}
}