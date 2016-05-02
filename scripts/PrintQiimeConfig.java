package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class PrintQiimeConfig extends Script {
	public static String title = "Print Qiime Configuration";
	public static String b_desc = "Print and optionally test QIIME configuration details";

	public PrintQiimeConfig() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/print_qiime_config.html";
		this.c_name = SCRIPTS_PATH + "print_qiime_config.py";
		this.l_desc = "Print QIIME configuration details and optionally perform tests of the QIIME base or full install.";
		this.output_desc = "Prints QIIME configuration details to standard output.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(0);
		// this.r_options.add(new Option());

		// set up the extra options
		this.e_options = new ArrayList<Option>(4);
		this.e_options.add(new Option("Test?", "-t", Option.NOARG, "Test the QIIME install and configuration [default: False]"));
		this.e_options.add(new Option("Base Install?", "-b", Option.NOARG, "SUPPRESSHELP"));
		this.e_options.add(new Option("Full Install?", "-f", Option.NOARG, "If passed, report on dependencies required for the QIIME full install. To perform tests of the QIIME full install, you must also pass -t. [default: False]"));
		this.e_options.add(new Option("Haiku?", "--haiku", Option.NOARG, "SUPPRESSHELP"));
	
	}
}