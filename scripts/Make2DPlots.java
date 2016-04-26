package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class Make2DPlots extends Script {
	public static String title = "Make 2D Plots";
	public static String b_desc = "Make 2D PCoA Plots";

	public Make2DPlots() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_2d_plots.html";
		this.c_name = SCRIPTS_PATH + "make_2d_plots.py";
		this.l_desc = "This script generates 2D PCoA plots using the principal coordinates file generated by performing beta diversity measures of an OTU table.";
		this.output_desc = "This script generates an output folder, which contains several files. To best view the 2D plots, it is recommended that the user views the _pcoa_2D.html file.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Corrdinate File", "-i", Option.PATH, "Input principal coordinates filepath (i.e., resulting file from principal_coordinates.py). Alternatively, a directory containing multiple principal coordinates files for jackknifed PCoA results."));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "Input metadata mapping filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(9);
		this.e_options.add(new Option("Color By", "-b", Option.INPUT, "Comma-separated list categories metadata categories (column headers) to color by in the plots. The categories must match the name of a column header in the mapping file exactly. Multiple categories can be list by comma separating them without spaces. The user can also combine columns in the mapping file by separating the categories by “&&” without spaces. [default=color by all]"));
		this.e_options.add(new Option("Preference Path", "-p", Option.PATH, "Input user-generated preferences filepath. NOTE: This is a file with a dictionary containing preferences for the analysis. [default: None]"));
		this.e_options.add(new Option("Background Color", "-k", Option.INPUT, "Background color to use in the plots. [default: white]"));
		this.e_options.add(new Option("Ellipsoid Opacity", "--ellipsoid_opacity", Option.NUM, "Used only when plotting ellipsoids for jackknifed beta diversity (i.e. using a directory of coord files instead of a single coord file). The valid range is between 0-1. 0 produces completely transparent (invisible) ellipsoids and 1 produces completely opaque ellipsoids. [default=0.33]"));
		List<String> selects = new ArrayList<String>();
		selects.add("IQR");
		selects.add("sdev");
		this.e_options.add(new Option("Ellipsoid Method", "--ellipsoid_method", Option.SELECT, selects, 0, "Used only when plotting ellipsoids for jackknifed beta diversity (i.e. using a directory of coord files instead of a single coord file). Valid values are “IQR” and “sdev”. [default=IQR]"));
		this.e_options.add(new Option("Master PCoA", "--master_pcoa", Option.INPUT, "Used only when plotting ellipsoids for jackknifed beta diversity (i.e. using a directory of coord files instead of a single coord file). These coordinates will be the center of each ellipisoid. [default: None; arbitrarily chosen PC matrix will define the center point]"));
		this.e_options.add(new Option("Scree?", "--scree", Option.NOARG, "Generate the scree plot [default: False]"));
		this.e_options.add(new Option("Percent Variation Below 1?", "--pct_variation_below_one", Option.NOARG, "Allow the percent variation explained by the axes to be below one. The default behaivor is to multiply by 100 all values if PC1 is < 1.0 [default: False]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to the output directory"));
	
	}
}