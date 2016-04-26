package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakePreference extends Script {
	public static String title = "Make Preference";
	public static String b_desc = "Generate preferences file";

	public MakePreference() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_prefs_file.html";
		this.c_name = SCRIPTS_PATH + "make_prefs_file.py";
		this.l_desc = "This script generates a preferences (prefs) file, which can be passed to make_2d_plots.py. The prefs file allows for defining the monte_carlo distance, gradient coloring of continuous values in the 2D plots, the ball size scale for all the samples and the color of the arrow and the line of the arrow for the procrustes analysis. Currently there is only one color gradient: red to blue.";
		this.output_desc = "The result of this script is a text file, containing coloring preferences to be used by make_2d_plots.py.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "This is the metadata mapping file [default=None]"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(7);
		this.e_options.add(new Option("Headers to Use", "-b", Option.INPUT, "Mapping fields to use in prefs file [default: ALL]"));
		this.e_options.add(new Option("Background Color", "-k", Option.INPUT, "This is the backgroundcolor to use in the plots. [default: black]"));
		this.e_options.add(new Option("Distance", "-d", Option.NUM, "Monte carlo distanceto use for each sample header [default: 10]"));
		this.e_options.add(new Option("TAXA File", "-i", Option.PATH, "Summarized taxa file with samplecounts by taxonomy (resulting file from summarize_taxa.py)"));
		this.e_options.add(new Option("Scale Factor", "-s", Option.NUM, "Scale factor for the size of each ball in the plots [default: 1.0]"));
		this.e_options.add(new Option("Arrow Line Color", "-l", Option.INPUT, "Arrow line color forprocrustes analysis. [default: white]"));
		this.e_options.add(new Option("Arrow Head Color", "-a", Option.INPUT, "Arrow head color forprocrustes analysis. [default: red]"));
	
	}
}