package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class SingleRarefaction extends Script {
	public static String title = "Single Rarefaction";
	public static String b_desc = "Perform rarefaction on an otu table";

	public SingleRarefaction() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/single_rarefaction.html";
		this.c_name = SCRIPTS_PATH + "single_rarefaction.py";
		this.l_desc = "To perform bootstrap, jackknife, and rarefaction analyses, the otu table must be subsampled (rarefied). This script rarefies, or subsamples, an OTU table. This does not provide curves of diversity by number of sequences in a sample. Rather it creates a subsampled OTU table by random sampling (without replacement) of the input OTU table. Samples that have fewer sequences then the requested rarefaction depth are omitted from the ouput otu tables. The pseudo-random number generator used for rarefaction by subsampling is NumPy’s default - an implementation of the Mersenne twister PRNG.";
		this.output_desc = "The results of single_rarefaction.py consist of a single subsampled OTU table. The file has the same otu table format as the input otu_table.biom. note: if the output file would be empty, no file is written";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Input Table", "-i", Option.PATH, "Input OTU table filepath."));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output OTU table filepath."));
		this.r_options.add(new Option("Dpeth", "-d", Option.NUM, "Number of sequences to subsample per sample.Number of sequences to subsample per sample."));

		// set up the extra options
		this.e_options = new ArrayList<Option>(4);
		this.e_options.add(new Option("Lineages Included?", "--lineages_included", Option.NOARG, "Deprecated: lineages are now included by default. Pass –supress_lineages_included to prevent output OTU tables from including taxonomic (lineage) information for each OTU. Note: this will only work if lineage information is in the input OTU table."));
		this.e_options.add(new Option("Suppress Lineages Included?", "--suppress_lineages_included", Option.NOARG, "Exclude taxonomic (lineage) information for each OTU."));
		this.e_options.add(new Option("Keep Empty OTUs?", "-k", Option.NOARG, "Retain OTUs of all zeros, which are usually omitted from the output OTU tables. [default: False]"));
		this.e_options.add(new Option("Subsample Multinomial?", "--subsample_multinomial", Option.NOARG, "Subsample using subsampling with replacement [default: False]"));
	
	}
}