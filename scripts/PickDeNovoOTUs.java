package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class PickDeNovoOTUs extends Script {
	public static String title = "Pick De Noco OTUs";
	public static String b_desc = "A workflow for de novo OTU picking, taxonomy assignment, phylogenetic tree construction, and OTU table construction.";

	public PickDeNovoOTUs() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/pick_de_novo_otus.html";
		this.c_name = SCRIPTS_PATH + "pick_de_novo_otus.py";
		this.l_desc = "This script takes a sequence file and performs all processing steps through building the OTU table.";
		this.output_desc = "This script will produce an OTU mapping file (pick_otus.py), a representative set of sequences (FASTA file from pick_rep_set.py), a sequence alignment file (FASTA file from align_seqs.py), taxonomy assignment file (from assign_taxonomy.py), a filtered sequence alignment (from filter_alignment.py), a phylogenetic tree (Newick file from make_phylogeny.py) and a biom-formatted OTU table (from make_otu_table.py).";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "The input fasta file [REQUIRED]"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output directory [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(5);
		this.e_options.add(new Option("Parameter File", "-p", Option.PATH, "Path to the parameter file, which specifies changes to the default behavior. See http://www.qiime.org/documentation/file_formats.html#qiime-parameters . [if omitted, default values will be used]"));
		this.e_options.add(new Option("Force Overwrite?", "-f", Option.NOARG, "Force overwrite of existing output directory (note: existing files in output_dir will not be removed) [default: None]"));
		this.e_options.add(new Option("Print Only?", "-w", Option.NOARG, "Print the commands but don’t call them – useful for debugging [default: False]"));
		this.e_options.add(new Option("Parallel?", "-a", Option.NOARG, "Run in parallel where available [default: False]"));
		this.e_options.add(new Option("Jobs to Start", "-O", Option.NUM, "Number of jobs to start [default: 1]"));
	
	}
}