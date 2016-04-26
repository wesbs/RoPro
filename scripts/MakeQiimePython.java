package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakeQiimePython extends Script {
	public static String title = "Make Qiime Pythong File";
	public static String b_desc = "Create python file";

	public MakeQiimePython() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_qiime_py_file.html";
		this.c_name = SCRIPTS_PATH + "make_qiime_py_file";
		this.l_desc = "This is a script which will add headers and footers to new python files and make them executable.";
		this.output_desc = "The results of this script is either a python script, test, or library file, depending on the input parameters.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output filepaths"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(5);
		this.e_options.add(new Option("Script?", "-s", Option.NOARG, "Pass if creating a script to include option parsing framework [default:False]."));
		this.e_options.add(new Option("Test?", "-t", Option.NOARG, "Pass if creating a unit test file to include relevant information [default:False]."));
		this.e_options.add(new Option("Author Name", "-a", Option.INPUT, "The script author’s (probably you) name to be included the header variables. This will typically need to be enclosed in quotes to handle spaces. [default:AUTHOR_NAME]"));
		this.e_options.add(new Option("Author Email", "-e", Option.INPUT, "The script author’s (probably you) e-mail address to be included the header variables. [default:AUTHOR_EMAIL]"));
		this.e_options.add(new Option("Copyright", "-c", Option.INPUT, "The copyright information to be included in the header variables. [default:Copyright 2014, The QIIME Project]"));
	
	}
}