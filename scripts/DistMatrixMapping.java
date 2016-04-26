package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class DistMatrixMapping extends Script {
	public static String title = "Distance Matrix Mapping";
	public static String b_desc = "Calculate the pairwise dissimilarity on one column of a mappping file";

	public DistMatrixMapping() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/distance_matrix_from_mapping.html";
		this.c_name = SCRIPTS_PATH + "distance_matrix_from_mapping.py";
		this.l_desc = "The input for this script is a mapping file and the name of a column, it has to be numeric, from which a distance matrix will be created. The output of this script is a distance matrix containing a dissimilarity value for each pairwise comparison.<br><br>As this is a univariate procedure only one metric is supported: d = c-b.";
		this.output_desc = "The output of distance_matrix_from_mapping.py is a file containing a distance matrix between rows corresponding to a pair of columns in a mapping file.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Mapping Filepath", "-i", Option.PATH, "Mapping filepath."));
		this.r_options.add(new Option("Column", "-c", Option.INPUT, "String containing the name of the column in the mapping file, e.g. ‘DOB’. If you pass two colums separated by a comma (e.g. ‘Latitude,Longitud’) the script will calculate the Vincenty formula (WGS-84) for distance between two Latitude/Longitude points."));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Output path to store the distance matrix. [default=map_distance_matrix.txt]"));
	
	}
}