package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakeOTUTable extends Script {
	public static String title = "Make OTU Table";
	public static String b_desc = "Make OTU table";

	public MakeOTUTable() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_otu_table.html";
		this.c_name = SCRIPTS_PATH + "make_otu_table.py";
		this.l_desc = "The script make_otu_table.py tabulates the number of times an OTU is found in each sample, and adds the taxonomic predictions for each OTU in the last column if a taxonomy file is supplied.";
		this.output_desc = "The output of make_otu_table.py is a biom file, where the columns correspond to Samples and rows correspond to OTUs and the number of times a sample appears in a particular OTU.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("OTU Map", "-i", Option.PATH, "Path to the input OTU map (i.e., the output from pick_otus.py)"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output otu table in biom format (recommended extension: .biom)"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Taxonomy Assignment", "-t", Option.PATH, "Path to taxonomy assignment, containing the assignments of taxons to sequences (i.e., resulting txt file from assign_taxonomy.py) [default: None]"));
		this.e_options.add(new Option("Mapping File", "-m", Option.PATH, "The mapping filepath"));
		this.e_options.add(new Option("Excluded OTUs", "-e", Option.PATH, "Path to a file listing OTU identifiers that should not be included in the OTU table (e.g., the output of identify_chimeric_seqs.py) or a fasta file where seq ids should be excluded (e.g., failures fasta file from align_seqs.py)"));
	
	}
}