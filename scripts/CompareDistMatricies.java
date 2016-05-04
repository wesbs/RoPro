package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class CompareDistMatricies extends Script {
	public static String title = "Compare Distance Matricies";
	public static String b_desc = "Computes Mantel correlation tests between sets of distance matrices";

	public CompareDistMatricies() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/compare_distance_matrices.html";
		this.c_name = SCRIPTS_PATH + "compare_distance_matrices.py";
		this.l_desc = "This script compares two or more distance/dissimilarity matrices for correlation by providing the Mantel, partial Mantel, and Mantel correlogram matrix correlation tests.<br><br>The Mantel test will test the correlation between two matrices. The data often represents the “distance” between objects or samples.<br><br>The partial Mantel test is a first-order correlation analysis that utilizes three distance (dissimilarity) matrices. This test builds on the traditional Mantel test which is a procedure that tests the hypothesis that distances between the objects within a given matrix are linearly independent of the distances withing those same objects in a separate matrix. It builds on the traditional Mantel test by adding a third “control” matrix.<br><br>Mantel correlogram produces a plot of distance classes versus Mantel statistics. Briefly, an ecological distance matrix (e.g. UniFrac distance matrix) and a second distance matrix (e.g. spatial distances, pH distances, etc.) are provided. The second distance matrix has its distances split into a number of distance classes (the number of classes is determined by Sturge’s rule). A Mantel test is run over these distance classes versus the ecological distance matrix. The Mantel statistics obtained from each of these tests are then plotted in a correlogram. A filled-in point on the plot indicates that the Mantel statistic was statistically significant (you may provide what alpha to use).<br><br>For more information and examples pertaining to this script, please refer to the accompanying tutorial, which can be found at http://qiime.org/tutorials/distance_matrix_comparison.html.";
		this.output_desc = "Mantel: One file is created containing the Mantel ‘r’ statistic and p-value.<br><br>Partial Mantel: One file is created in the output directory, which contains the partial Mantel statistic and p-value.<br><br>Mantel Correlogram: Two files are created in the output directory: a text file containing information about the distance classes, their associated Mantel statistics and p-values, etc. and an image of the correlogram plot.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		List<String> selects = new ArrayList<String>(3);
		selects.add("mantel");
		selects.add("partial_mantel");
		selects.add("mantel_corr");
		this.r_options.add(new Option("Method", "--method", Option.SELECT, selects, "Matrix correlation method to use. Valid options: [mantel, partial_mantel, mantel_corr]"));
		this.r_options.add(new Option("Distance Matricies", "-i", Option.PATH, 0, "The input distance matrices, comma-separated. WARNING: Only symmetric, hollow distance matrices may be used as input. Asymmetric distance matrices, such as those obtained by the UniFrac Gain metric (i.e. beta_diversity.py -m unifrac_g), should not be used as input"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to the output directory"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(7);
		this.e_options.add(new Option("Number of Permutations", "-n", Option.NUM, "The number of permutations to perform when calculating the p-value [default: 100]"));
		this.e_options.add(new Option("Mapping File", "-s", Option.PATH, "Map of original sample ids to new sample ids [default: None]"));
		selects = new ArrayList<String>(3);
		selects.add("two-sided");
		selects.add("less");
		selects.add("greater");
		this.e_options.add(new Option("Tail Type", "-t", Option.SELECT, selects, 0, "The type of tail test to perform when calculating the p-value. Valid options: [two-sided, less, greater]. “two-sided” is a two-tailed test, while “less” tests for r statistics less than the observed r statistic, and “greater” tests for r statistics greater than the observed r statistic. Only applies when method is mantel [default: two-sided]"));
		this.e_options.add(new Option("Alpha Value", "-a", Option.NUM, "The value of alpha to use when denoting significance in the correlogram plot. Only applies when method is mantel_corr"));
		selects = new ArrayList<String>(3);
		selects.add("png");
		selects.add("svg");
		selects.add("pdf");
		this.e_options.add(new Option("Image Type", "-i", Option.SELECT, selects, 2, "The type of image to produce. Valid options: [png, svg, pdf]. Only applies when method is mantel_corr [default: pdf]"));
		this.e_options.add(new Option("Equal Distance Class?", "--variable_size_distance_classes", Option.NOARG, "If this option is supplied, each distance class will have an equal number of distances (i.e. pairwise comparisons), which may result in variable sizes of distance classes (i.e. each distance class may span a different range of distances). If this option is not supplied, each distance class will have the same width, but may contain varying numbers of pairwise distances in each class. This option can help maintain statistical power if there are large differences in the number of distances in each class. See Darcy et al. 2011 (PLoS ONE) for an example of this type of correlogram. Only applies when method is mantel_corr [default: False]"));
		this.e_options.add(new Option("Control Matrix", "-c", Option.PATH, "The control matrix. Only applies (and is required) when method is partial_mantel. [default: None]"));
	}
}

