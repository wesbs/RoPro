package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MultipleRarefactions extends Script {
	public static String title = "Multiple Rarefactions";
	public static String b_desc = "Perform multiple subsamplings/rarefactions on an otu table";

	public MultipleRarefactions() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/multiple_rarefactions.html";
		this.c_name = SCRIPTS_PATH + "multiple_rarefactions.py";
		this.l_desc = "To perform bootstrap, jackknife, and rarefaction analyses, the otu table must be subsampled (rarefied). This script rarefies, or subsamples, OTU tables. This does not provide curves of diversity by number of sequences in a sample. Rather it creates a series of subsampled OTU tables by random sampling (without replacement) of the input OTU table. Samples that have fewer sequences then the requested rarefaction depth for a given output otu table are omitted from those ouput otu tables. The pseudo-random number generator used for rarefaction by subsampling is NumPy’s default - an implementation of the Mersenne twister PRNG.";
		this.output_desc = "The result of multiple_rarefactions.py consists of a number of biom files, which depend on the minimum/maximum number of sequences per samples, steps and iterations. The files have the same otu table format as the input otu_table.biom, and are named in the following way: rarefaction_100_0.biom, where “100” corresponds to the sequences per sample and “0” the iteration.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(5);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "Input OTU table filepath."));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output directory."));
		this.r_options.add(new Option("Min Sequences", "-m", Option.NUM, "Minimum number of seqs/sample for rarefaction."));
		this.r_options.add(new Option("Max Sequences", "-x", Option.NUM, "Maximum number of seqs/sample (inclusive) for rarefaction."));
		this.r_options.add(new Option("Step Size", "-s", Option.NUM, "Size of each steps between the min/max of seqs/sample (e.g. min, min+step... for level <= max)."));

		// set up the extra options
		this.e_options = new ArrayList<Option>(4);
		this.e_options.add(new Option("Num of Iterations", "-n", Option.NUM, "The number of iterations at each step. [default: 10]"));
		this.e_options.add(new Option("Lineage Included?", "--lineage_included", Option.NOARG, "Retain taxonomic (lineage) information for each OTU. Note: this will only work if lineage information is in the input OTU table. [default: False]"));
		this.e_options.add(new Option("Keep Empty OTUs?", "-k", Option.NOARG, "Retain OTUs of all zeros, which are usually omitted from the output OTU tables. [default: False]"));
		this.e_options.add(new Option("Subsample Multinomial?", "--subsample_multinomial", Option.NOARG, "Subsample using subsampling with replacement [default: False]"));
	
	}
}