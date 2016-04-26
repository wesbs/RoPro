package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class CompareTaxaSummary extends Script {
	public static String title = "Compare Taxa Summary Files";
	public static String b_desc = "Compares taxa summary files";

	public CompareTaxaSummary() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/compare_taxa_summaries.html";
		this.c_name = SCRIPTS_PATH + "compare_taxa_summaries.py";
		this.l_desc = "This script compares two taxa summary files by computing the correlation coefficient between pairs of samples. This is useful, for example, if you want to compare the taxonomic composition of mock communities that were assigned using different taxonomy assigners in order to see if they are correlated or not. Another example use-case is to compare the taxonomic composition of several mock community replicate samples to a single expected, or known, sample community.<br><br>This script is also useful for sorting and filling taxa summary files so that each sample has the same taxa listed in the same order (with missing taxa reporting an abundance of zero). The sorted and filled taxa summary files can then be passed to a script, such as plot_taxa_summary.py, to visually compare the differences using the same taxa coloring scheme.<br><br>For more information and examples pertaining to this script, please refer to the accompanying tutorial, which can be found at http://qiime.org/tutorials/taxa_summary_comparison.html.";
		this.output_desc = "The script will always output at least three files to the specified output directory. Two files will be the sorted and filled versions of the input taxa summary files, which can then be used in plot_taxa_summary.py to visualize the differences in taxonomic composition. These files will be named based on the basename of the input files. If the input files’ basenames are the same, the output files will have ‘0’ and ‘1’ appended to their names to keep the filenames unique. The first input taxa summary file will have ‘0’ in its filename and the second input taxa summary file will have ‘1’ in its filename.<br><br>The third output file will contain the results of the overall comparison of the input taxa summary files using the specified sample pairings. The correlation coefficient, parametric p-value, nonparametric p-value, and a confidence interval for the correlation coefficient will be included.<br><br>If --perform_detailed_comparisons is specified, the fourth output file is a tab-separated file containing the correlation coefficients that were computed between each of the paired samples. Each line will contain the sample IDs of the samples that were compared, followed by the correlation coefficient that was computed, followed by the parametric and nonparametric p-values (uncorrrected and Bonferroni-corrected) and a confidence interval for the correlation coefficient.<br><br>The output files will contain comments at the top explaining the types of tests that were performed.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Input Taxa Summary", "-i", Option.PATH, 2, "The two input taxa summary filepaths, comma-separated. These will usually be the files that are output by summarize_taxa.py. These taxa summary files do not need to have the same taxa in the same order, as the script will make them compatible before comparing them"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to the output directory"));
		List<String> selects = new ArrayList<String>();
		selects.add("paired");
		selects.add("expected");
		this.r_options.add(new Option("Comparison Mode", "-m", Option.SELECT, "The type of comparison to perform. Valid choices: paired or expected. “paired” will compare each sample in the taxa summary files that match based on sample ID, or that match given a sample ID map (see the –sample_id_map_fp option for more information). “expected” will compare each sample in the first taxa summary file to an expected sample (contained in the second taxa summary file). If “expected”, the second taxa summary file must contain only a single sample that all other samples will be compared to (unless the –expected_sample_id option is provided)"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(7);
		selects = new ArrayList<String>();
		selects.add("pearson");
		selects.add("spearman");
		this.e_options.add(new Option("Correlation Type", "-c", Option.SELECT, selects, 1, "The type of correlation coefficient to compute. Valid choices: pearson or spearman [default: pearson]"));
		selects = new ArrayList<String>();
		selects.add("high");
		selects.add("low");
		selects.add("two-sided");
		this.e_options.add(new Option("Tail Type", "-t", Option.SELECT, selects, 2, "The type of tail test to compute when calculating the p-values. “high” specifies a one-tailed test for values greater than the observed correlation coefficient (positive association), while “low” specifies a one-tailed test for values less than the observed correlation coefficient (negative association). “two-sided” specifies a two-tailed test for values greater in magnitude than the observed correlation coefficient. Valid choices: low or high or two-sided [default: two-sided]"));
		this.e_options.add(new Option("Number of Permutations", "-n", Option.NUM, "The number of permutations to perform when calculating the nonparametric p-value. Must be an integer greater than or equal to zero. If zero, the nonparametric test of significance will not be performed and the nonparametric p-value will be reported as “N/A” [default: 999]"));
		this.e_options.add(new Option("Confidence Level", "-c", Option.NUM, "The confidence level of the correlation coefficient confidence interval. Must be a value between 0 and 1 (exclusive). For example, a 95% confidence interval would be 0.95 [default: 0.95]"));
		this.e_options.add(new Option("Map of Sample IDs", "-s", Option.PATH, "Map of original sample IDs to new sample IDs. Use this to match up sample IDs that should be compared between the two taxa summary files. Each line should contain an original sample ID, a tab, and the new sample ID. All original sample IDs from the two input taxa summary files must be mapped. This option only applies if the comparison mode is “paired”. If not provided, only sample IDs that exist in both taxa summary files will be compared [default: None]"));
		this.e_options.add(new Option("Expected Sample ID", "-e", Option.PATH, "The sample ID in the second “expected” taxa summary file to compare all samples to. This option only applies if the comparison mode is “expected”. If not provided, the second taxa summary file must have only one sample [default: None]"));
		this.e_options.add(new Option("Perform Detailed Comparisons", "--perform_detailed_comparisons", Option.NOARG, "Perform a comparison for each sample pair in addition to the single overall comparison. The results will include the Bonferroni-corrected p-values in addition to the original p-values [default: False]"));	
	}
}