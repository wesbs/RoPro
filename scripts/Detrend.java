package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class Detrend extends Script {
	public static String title = "Dentrend";
	public static String b_desc = "Detrend Principal Coordinates";

	public Detrend() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/detrend.html";
		this.c_name = SCRIPTS_PATH + "detrend.py";
		this.l_desc = "Ordination plots (e.g. principal coordinates analysis) of samples that lay along a naturally occurring gradient (e.g. depth, time, pH) often exhibit a curved shape known as the “arch” or “horseshoe” effect. This can cause samples near the endpoints of the gradient to appear closer to one another than would be expected. This script will attempt to remove any (compounded) quadratic curvature in a set of 2D coordinates. If requested, it will also report an evaluation of the association of the transformed coordinates with a known gradient.";
		this.output_desc = "Output is detrended PCoA matrices.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Path to Table", "-i", Option.PATH, "Path to read PCoA/PCA/ordination table"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(4);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to output directory [default: .]"));
		this.e_options.add(new Option("Metadata File", "-m", Option.PATH, "Path to metadata file [default: None]"));
		this.e_options.add(new Option("Couln Header", "-c", Option.INPUT, "Column header for gradient variable in metadata table [default: None]"));
		this.e_options.add(new Option("Suppress Prerotate", "-r", Option.NOARG, "Suppress pre-rotation of the coordinates for optimal detrending; not pre-rotating assumes that the curvature is symmetrical across the vertical axis [default: False]"));
	
	}
}