package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ComputeTaxRatios extends Script {
	public static String title = "Compute Taxonomy Ratios";
	public static String b_desc = "Compute the log ratio abundance of specified taxonomic groups.";

	public ComputeTaxRatios() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/compute_taxonomy_ratios.html";
		this.c_name = SCRIPTS_PATH + "compute_taxonomy_ratios.py";
		this.l_desc = "Compute the log ratio abundance of specified taxonomic groups. This method is based on the microbial dysbiosis index described in Gevers et al. 2014: http://www.ncbi.nlm.nih.gov/pubmed/24629344";
		this.output_desc = "By default, a minimal QIIME mapping file is created containing two columns: SampleID and the index. If -m is provided, the information in that mapping file is merged into the default output mapping file.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(0);
		// this.r_options.add(new Option());

		// set up the extra options
		this.e_options = new ArrayList<Option>(9);
		this.e_options.add(new Option("Input BIOM Table", "-i", Option.PATH, "The input BIOM table [REQUIRED if not passing -s]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to where the output will be written; this will be a new sample metadata mapping file [REQUIRED if not passing -s]"));
		this.e_options.add(new Option("Numerator Abundances", "--increased", Option.INPUT, "Comma-separated list of taxa whose abundances are included in the numerator of the ratio [REQUIRED if not passing -s or -e]"));
		this.e_options.add(new Option("Denominator Abundances", "--decreased", Option.INPUT, "Comma-separated list of taxa whose abundances are included in the denominator of the ratio [REQUIRED if not passing -s or -e]"));
		List<String> selects = new ArrayList<String>();
		selects.add("md");
		this.e_options.add(new Option("Existing Index", "-e", Option.SELECT, selects, 0, "Apply an existing index. Options are: md [REQUIRED if not passing -s or –increased and –decreased]"));
		this.e_options.add(new Option("Column Name", "-n", Option.INPUT, "Column name for the index in the output file [default: ‘index’, or value passed as -e if provided]"));
		this.e_options.add(new Option("Mapping File", "-m", Option.PATH, "A mapping file containing data that should be included in the output file [default: no additional mapping file data is included in output]"));
		this.e_options.add(new Option("Metadata Key", "-k", Option.INPUT, "Metadata key to use for computing index [default: taxonomy]"));
		this.e_options.add(new Option("Show Indicies", "-s", Option.NOARG, "List known indices and exit [default: False]"));
	}
}