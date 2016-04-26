package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ObsMetaCore extends Script {
	public static String title = "Observation Metadata Core";
	public static String b_desc = "Correlation between observation abundances and continuous-valued metadata";

	public ObsMetaCore() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/observation_metadata_correlation.html";
		this.c_name = SCRIPTS_PATH + "observation_metadata_correlation.py";
		this.l_desc = "This script calculates correlations between feature (aka observation) abundances (relative or absolute) and numeric metadata. Several methods are provided to allow the user to correlate features to sample metadata values including Spearman’s Rho, Pearson, Kendall’s Tau, and the C or checkerboard score. References for these methods are numerous, but good descriptions may be found in ‘Biometry’ by Sokal and Rolhf. A brief description of the available tests follows:<br><br>Pearson score: The Pearson score, aka Pearson’s Product Moment correlation, is a scaled measure of the degree to which two sequences of numbers co-vary. For ‘correlated’ sequences, Pearson > 0, and for ‘anticorrelated’ sequences Pearson < 0 (uncorrelated implies Pearson = 0). Pearson is a paramateric and linear measure of correlation.<br>Spearman’s Rho: The Spearman correlation is a non-paramateric measure of correlation between two sequences of numbers. Spearman correlation is appropriate for data where the values of the observations are not necessarily accurate, but for which their relative magnitudes are (see Biometry for more details).<br>Kendall’s Tau: Kendall’s Tau is an alternative method of calculating correlation between two sequences of numbers. It is slower and less widely utilized than Spearman or Pearson scores.<br>Cscore: The c-score or ‘checkerboard score’ is a measure of covariation between two sequences that is derived from traditional ecology (Stone and Roberts. 1990, Oecologia 85:74-79).<br>Raw correlation statistics alone reflect only the degree of association between two sequences of numbers or vectors. Assigning a likelihood to these score via a p-value can be done with several methods depending on the particular assumptions that are used. This script allows four methods for calculating p-values:<br><br>Bootrapping: Bootstrapping is the most robust, but slowest procedure for calculating the p-value of a given correlation score. Bootstrapping takes the input sequences, shuffles the order of one, and then recomputes the correlation score. The p-value is then the number of times (out of the given number of permutations) that the score of the permuted sequence pair was more extreme than the observed pair. Bootstrapping is good when the underlying properties of the distributions are unknown.<br>Parametric t distribution: the traditional method for calculating the significance of a correlation score, this method assumes that the scores are normally distributed and computes a t statistic for each correlation score in conjunction with the length of the sequences being correlated.<br>Fisher Z transform: Fisher’s Z transform is a way to make the distribution of correlation scores (especially when there are many highly correlated scores) look more normal. It is not to be confused with Fisher’s transformation for the combination of p-values.<br>Kendall’s Tau: for the Kendall’s Tau calculation, the specific Kendall’s Tau p-value is provided.<br>Notes:<br><br>The only supported metric for p-value assignment with the C-score is bootstrapping. For more information on the C-score, read Stone and Roberts 1990 Oecologea paper 85: 74-79. If you don’t pass pval_assignment_method=’bootstrapped’ while you have -s cscore, the script will raise an error.<br>Assigning p-values to Kendall’s Tau scores with the bootstrapping method is very slow.";
		this.output_desc = "The output will be a tab-delimited file with the following headers. Each row will record the values calculated for a given feature:<br>Feature ID: ID of the features being correlated. These are the observation IDs in the BIOM table.<br>Test stat.: the value of the test statistic for the given test.<br>pval: the raw p-value returned by the given test.<br>pval_fdr: the p-value corrected by the Benjamini-Hochberg FDR procedure for multiple comparisons.<br>pval_bon: the p-value corrected by the Bonferroni procedure for multiple comparisons.<br>[metadata]: this column will be present only if the BIOM table contained metadata information for your features. For example, if these are OTUs, and taxonomy is present in the BIOM table, this column will contain OTU taxonomy and will be named ‘taxonomy’.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(4);
		this.r_options.add(new Option("BIOM Table", "-i", Option.PATH, "Path to input BIOM table"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to the output file to be created"));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "Path to metadata mapping file"));
		this.r_options.add(new Option("Category", "-c", Option.INPUT, "Name of the category in the metadata mapping file over which to run the analysis"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(4);
		List<String> selects = new ArrayList<String>();
		selects.add("spearman");
		selects.add("pearson");
		selects.add("kendall");
		selects.add("cscore");
		this.e_options.add(new Option("Correlation Mathod", "-s", Option.SELECT, selects, 0, "Correlation method to use. Choices are: spearman, pearson, kendall, cscore [default: spearman]"));
		selects = new ArrayList<String>();
		selects.add("fisher_z_transform");
		selects.add("parametric_t_distribution");
		selects.add("bootstrapped");
		selects.add("kendall");
		this.e_options.add(new Option("P-Value Method", "--pval_assignment_method", Option.SELECT, selects, 0, "P-value method to use. Choices are: fisher_z_transform, parametric_t_distribution, bootstrapped, kendall [default: fisher_z_transform]"));
		this.e_options.add(new Option("Metadata Key", "--metadata_key", Option.INPUT, "Key to extract metadata from BIOM table. [default: taxonomy]"));
		this.e_options.add(new Option("Num of Permutations", "--permutations", Option.NUM, "Number of permutations to use for bootstrapped p-value calculations. [default: 1000]"));
	
	}
}