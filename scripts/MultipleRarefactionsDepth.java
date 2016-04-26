package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MultipleRarefactionsDepth extends Script {
	public static String title = "Multiple Rarefactions Even Depth";
	public static String b_desc = "Perform multiple rarefactions on a single otu table, at one depth of sequences/sample";

	public MultipleRarefactionsDepth() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/multiple_rarefactions_even_depth.html";
		this.c_name = SCRIPTS_PATH + "multiple_rarefactions_even_depth.py";
		this.l_desc = "To perform bootstrap, jackknife, and rarefaction analyses, the otu table must be subsampled (rarefied). This script rarefies, or subsamples, an OTU table. This does not provide curves of diversity by number of sequences in a sample. Rather it creates a subsampled OTU table by random sampling (without replacement) of the input OTU table. Samples that have fewer sequences then the requested rarefaction depth are omitted from the ouput otu tables. The pseudo-random number generator used for rarefaction by subsampling is NumPy’s default - an implementation of the Mersenne twister PRNG.";
		this.output_desc = "The results of this script consist of n subsampled OTU tables, written to the directory specified by -o. The file has the same otu table format as the input otu_table.biom. Note: if the output files would be empty, no files are written.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "Input otu table filepath"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Write output rarefied otu tables files to this dir (makes dir if it doesn’t exist)"));
		this.r_options.add(new Option("Depth", "-d", Option.NUM, "Sequences per sample to subsample"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Num of Iterations", "-n", Option.NUM, "Num iterations at each seqs/sample level [default: 10]"));
		this.e_options.add(new Option("Lineages Included?", "--lineages_included", Option.NOARG, "Output rarefied otu tables will include taxonomic (lineage) information for each otu, if present in input otu table [default: False]"));
		this.e_options.add(new Option("Keep Empty OTUs?", "-k", Option.NOARG, "Otus (rows) of all zeros are usually omitted from the output otu tables, with -k they will not be removed from the output files [default: False]"));
	
	}
}