package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class SupervisedLearning extends Script {
	public static String title = "Supervised Learning";
	public static String b_desc = "Run supervised classification using OTUs as predictors and a mapping file category as class labels.";

	public SupervisedLearning() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/supervised_learning.html";
		this.c_name = SCRIPTS_PATH + "supervised_learning.py";
		this.l_desc = "This script trains a supervised classifier using OTUs (or other continuous input sample x observation data) as predictors, and a mapping file column containing discrete values as the class labels.<br><br>Outputs:<br>cv_probabilities.txt: the label probabilities for each of the given samples. (if available)<br>mislabeling.txt: A convenient presentation of cv_probabilities for mislabeling detection.<br>confusion_matrix.txt: confusion matrix for hold-out predictions.<br>summary.txt: a summary of the results, including the expected generalization error of the classifier<br>feature_importance_scores.txt: a list of discriminative OTUs with their associated importance scores (if available)<br>It is recommended that you remove low-depth samples and rare OTUs before running this script. This can drastically reduce the run-time, and in many circumstances will not hurt performance. It is also recommended to perform rarefaction to control for sampling effort before running this script. For example, to rarefy at depth 200, then remove OTUs present in < 10 samples run:<br><br>single_rarefaction.py -i otu_table.biom -d 200 -o otu_table_rarefied200.biom filter_otus_from_otu_table.py -i otu_table_rarefied200.biom -s 10 -o otu_table_rarefied200.present10.biom<br><br>For an overview of the application of supervised classification to microbiota, see PubMed ID 21039646.<br><br>This script also has the ability to collate the supervised learning results produced on an input directory. For example, in order to reduce any variation introduced through producing a rarefied OTU table, the user can run multiple_rarefactions_even_depth.py on the OTU table, and then pass that directory into supervised_learning.py. The user can then pass a -w collate_results filepath to produce a single results file that contains the average estimated generalization error of the classified, and the pooled standard deviation (for cv5 and cv10 errortypes).<br><br>This script requires that R be installed and in the search path. To install R visit: http://www.r-project.org/. Once R is installed, run R and excecute the command “install.packages(“randomForest”)”, then type q() to exit.";
		this.output_desc = "Outputs a ranking of features (e.g. OTUs) by importance, an estimation of the generalization error of the classifier, and the predicted class labels and posterior class probabilities according to the classifier.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(4);
		this.r_options.add(new Option("Input Data File", "-i", Option.PATH, "Input data file containing predictors (e.g. otu table) or a directory of otu tables"));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "File containing meta data (response variables)"));
		this.r_options.add(new Option("Category", "-c", Option.INPUT, "Name of meta data category to predict"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output directory"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(4);
		this.e_options.add(new Option("Force Overwrite?", "-f", Option.NOARG, "Force overwrite of existing output directory (note: existing files in output_dir will not be removed) [default: None]"));
		this.e_options.add(new Option("Num of Trees", "--ntree", Option.NUM, "Number of trees in forest (more is better but slower) [default: 500]"));
		List<String> selects = new ArrayList<String>();
		selects.add("oob");
		selects.add("loo");
		selects.add("cv5");
		selects.add("cv10");
		this.e_options.add(new Option("Error Type", "-e", Option.SELECT, selects, 0, "Type of error estimation. Valid choices are: oob, loo, cv5, cv10. oob: out-of-bag, fastest, only builds one classifier, use for quick estimates; cv5: 5-fold cross validation, provides mean and standard deviation of error, use for good estimates on very large data sets; cv10: 10-fold cross validation, provides mean and standard deviation of error, use for best estimates; loo: leave-one-out cross validation, use for small data sets (less than ~30-50 samples) [default oob]"));
		this.e_options.add(new Option("Collate Results File", "-w", Option.PATH, "When passing in a directory of OTU tables that are rarefied at an even depth, this option will collate the results into a single specified output file, averaging the estimated errors and standard deviations. [default: None]"));
	
	}
}