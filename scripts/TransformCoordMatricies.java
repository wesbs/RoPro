package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class TransformCoordMatricies extends Script {
	public static String title = "Transform Coordinate Matricies";
	public static String b_desc = "Transform two or more coordinate matrices";

	public TransformCoordMatricies() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/transform_coordinate_matrices.html";
		this.c_name = SCRIPTS_PATH + "transform_coordinate_matrices.py";
		this.l_desc = "This script transforms two or more coordinate matrices (e.g., the output of principal_coordinates.py) using procrustes analysis to minimize the distances between corresponding points. The first coordinate matrix provided is treated as the reference, and all other coordinate matrices are transformed to minimize distances to the reference points. Monte Carlo simulations can additionally be performed (-r random trials are run) to estimate the probability of seeing an M^2 value as extreme as the actual M^2.";
		this.output_desc = "Two transformed coordinate matrices corresponding to the two input coordinate matrices, and (if -r was specified) a text file summarizing the results of the Monte Carlo simulations.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Coordinate Matricies", "-i", Option.PATH, 0, "Comma-separated list of input coordinate matrices"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output directory"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(4);
		this.e_options.add(new Option("Random Trials", "-r", Option.NUM, "Number of random permutations of matrix2 to perform. [default: (no Monte Carlo analysis performed)]"));
		this.e_options.add(new Option("Num of Dimensions", "-d", Option.NUM, "Number of dimensions to include in output matrices [default: 3]"));
		this.e_options.add(new Option("Sample ID Maps", "-s", Option.PATH, 0, "If sample id maps are provided, there must be exactly one fewer files here than there are coordinate matrices (as each nth sample id map will provide the mapping from the first input coordinate matrix to the n+1th coordinate matrix) [default: None]"));
		this.e_options.add(new Option("Store Trial Detials?", "--store_trial_details", Option.NOARG, "Store PC matrices for individual trials [default: False]"));
	
	}
}