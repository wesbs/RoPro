package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class EstimateObsRich extends Script {
	public static String title = "Estimate Observation Richness";
	public static String b_desc = "Estimates the observation (e.g., OTU) richness of samples in a BIOM table";

	public EstimateObsRich() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/estimate_observation_richness.html";
		this.c_name = SCRIPTS_PATH + "estimate_observation_richness.py";
		this.l_desc = "This script provides estimates of the observation (e.g., OTU) richness (i.e. number of observations) given a sampling depth (i.e. number of individuals/sequences per sample). Estimators are provided for both interpolation/rarefaction and extrapolation.<br><br>Interpolation/rarefaction applies when the richness is estimated for a smaller number of individuals than the original number of individuals in that sample. We refer to this original sampling depth as the “reference sampling depth” or “reference sample size”.<br><br>Extrapolation applies when the richness is estimated for a larger number of individuals than the reference sample size.<br><br>This script currently only provides a single unified estimation model for interpolation and extrapolation. This model is the individual-based multinomial model, which uses Chao1 to estimate the full richness of the sample. Please refer to Colwell et al. (2012) for more details; equations 4, 5, 9, 10, 15a, and 15b are used in this script.<br><br>For each interpolation/extrapolation point, the estimate, its unconditional standard error, and confidence interval are reported. The script currently only outputs this information to a table, which can be easily viewed in a program such as Excel. Other output formats, such as plots, may be added in the future.<br><br>If an estimate is reported as “N/A”, not enough information was present to compute an estimate. This can occur when extrapolating if a sample does not contain any singletons or doubletons, or if there is exactly one singleton and no doubletons. A singleton is defined as an observation with exactly one individual/sequence in the sample. A doubleton is defined as an observation with exactly two individuals/sequences in the sample.<br><br>IMPORTANT: If you use the results of this script in any published works, please be sure to cite the Colwell et al. (2012) paper, as well as QIIME (see http://qiime.org for details).<br><br>In addition to Colwell et al. (2012), the following resources were extremely useful while implementing and testing these estimators, so it is appropriate to also acknowledge them here:<br><br>Hsieh et al. (2013)<br>Shen et al. (2003)<br>Colwell (2013)<br>References:<br><br>Chao, A., N. J. Gotelli, T. C. Hsieh, E. L. Sander, K. H. Ma, R. K. Colwell, and A. M. Ellison 2013. Rarefaction and extrapolation with Hill numbers: a unified framework for sampling and estimation in biodiversity studies, Ecological Monographs (under revision).<br><br>Colwell, R. K. 2013. EstimateS: Statistical estimation of species richness and shared species from samples. Version 9. User’s Guide and application published at: http://purl.oclc.org/estimates.<br><br>Colwell, R. K., A. Chao, N. J. Gotelli, S. Y. Lin, C. X. Mao, R. L. Chazdon, and J. T. Longino. 2012. Models and estimators linking individual-based and sample-based rarefaction, extrapolation and comparison of assemblages. Journal of Plant Ecology 5:3-21.<br><br>Hsieh, T. C., K. H. Ma, and A. Chao. 2013. iNEXT online: interpolation and extrapolation (Version 1.0) [Software]. Available from http://chao.stat.nthu.edu.tw/inext/.<br><br>Shen T-J, Chao A, Lin C- F. Predicting the number of new species in further taxonomic sampling. Ecology 2003;84:798-804.";
		this.output_desc = "A single file containing tabular data in TSV format is created in the output directory. Other output formats may be added in the future.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input BIOM Table", "-i", Option.PATH, "Path to the input BIOM table (e.g., the output from make_otu_table.py). IMPORTANT: This table should contain observation counts (integers), NOT relative abundances (fractions)"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Path to the output directory"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(4);
		this.e_options.add(new Option("Min Indivisuals", "-m", Option.NUM, "The number of individuals (e.g. sequences) per sample to start performing estimations at [default: 1]"));
		this.e_options.add(new Option("Max Individuals", "-x", Option.NUM, "The number of individuals (e.g. sequences) per sample to stop performing estimations at. By default, the base sample size will be used, which is defined in Chao et al. (2013) as “double the smallest reference sample size or the maximum reference sample size, whichever is larger [default: base sample size]"));
		this.e_options.add(new Option("Steps", "-n", Option.NUM, "The number of steps to make between -m/–min and -x/–max. Increasing this number will result in smoother curves, but will also increase the amount of time needed to run the script. Note that the reference sample size for each sample will be included if it does not fall within the min/max/num_steps range [default: 10]"));
		this.e_options.add(new Option("Confidence Level", "-c", Option.NUM, "The confidence level of the unconditional confidence interval for each estimate. Must be a value between 0 and 1 (exclusive). For example, a 95% unconditional confidence interval would be 0.95 [default: 0.95]"));
	
	}
}