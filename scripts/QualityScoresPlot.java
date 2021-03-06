package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class QualityScoresPlot extends Script {
	public static String title = "Quality Scores Plot";
	public static String b_desc = "Generates histograms of sequence quality scores and number of nucleotides recorded at a particular index";

	public QualityScoresPlot() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/quality_scores_plot.html";
		this.c_name = SCRIPTS_PATH + "quality_scores_plot.py";
		this.l_desc = "Two plots are generated by this module. The first shows line plots indicating the average and standard deviations for the quality scores of the input quality score file, starting with the first nucleotide and ending with the the final nucleotide of the largest sequence.<br><br>A second histogram shows a line plot with the nucleotide count for each position, so that one may easily visualize how sequence length drops off.<br><br>A dotted line shows the cut-off point for a score to be acceptable (default is 25).<br><br>A text file logging the average, standard deviation, and base count for each base position is also generated. These three sections are comma separated.<br><br>The truncate_fasta_qual_files.py module can be used to create truncated versions of the input fasta and quality score files. By using this module to assess the beginning of poor quality base calls, one can determine the base position to begin truncating sequences at.";
		this.output_desc = "A .pdf file with the two plots will be created in the output directory";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Quality Score File", "-q", Option.PATH, "Quality score file used to generate histogram data."));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Output", "-o", Option.PATH,"Output directory. Will be created if does not exist. [default: .]"));
		this.e_options.add(new Option("Min Score", "-s", Option.NUM, "Minimum quality score to be considered acceptable. Used to draw dotted line on histogram for easy visualization of poor quality scores. [default: 25]"));
		this.e_options.add(new Option("Verbose?", "-v", Option.NOARG, "Turn on this flag to disable verbose output. [default: True]"));
	
	}
}