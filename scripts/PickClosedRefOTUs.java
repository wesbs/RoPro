package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class PickClosedRefOTUs extends Script {
	public static String title = "Pick Closed Reference OTUs";
	public static String b_desc = "Closed-reference OTU picking/Shotgun UniFrac workflow.";

	public PickClosedRefOTUs() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/pick_closed_reference_otus.html";
		this.c_name = SCRIPTS_PATH + "pick_closed_reference_otus.py";
		this.l_desc = "This script picks OTUs using a closed reference and constructs an OTU table. Taxonomy is assigned using a pre-defined taxonomy map of reference sequence OTU to taxonomy. If full-length genomes are provided as the reference sequences, this script applies the Shotgun UniFrac method.<br><br>Note: If most or all of your sequences are failing to hit the reference, your sequences may be in the reverse orientation with respect to your reference database. To address this, you should add the following line to your parameters file (creating one, if necessary) and pass this file as -p:<br><br>pick_otus:enable_rev_strand_match True<br><br>Be aware that this doubles the amount of memory used.";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input Sequences", "-i", Option.PATH, "The input sequences"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output directory"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(9);
		this.e_options.add(new Option("Reference File", "-r", Option.PATH, "The reference sequences [default: /Users/caporaso/.virtualenvs/qiime/lib/python2.7/site-packages/qiime_default_reference/gg_13_8_otus/rep_set/97_otus.fasta]. NOTE: If you do not pass -r to this script, you will be using QIIME’s default reference sequences. In this case, QIIME will copy the corresponding reference tree to the output directory. This is the tree that should be used to perform phylogenetic diversity analyses (e.g., with core_diversity_analyses.py)."));
		this.e_options.add(new Option("Parameter File", "-p", Option.PATH, "Path to the parameter file, which specifies changes to the default behavior. See http://www.qiime.org/documentation/file_formats.html#qiime-parameters . [if omitted, default values will be used]"));
		this.e_options.add(new Option("Taxonomy Map", "-t", Option.PATH, "The taxonomy map [default: /Users/caporaso/.virtualenvs/qiime/lib/python2.7/site-packages/qiime_default_reference/gg_13_8_otus/taxonomy/97_otu_taxonomy.txt]"));
		this.e_options.add(new Option("Assing Taxonomy?", "-s", Option.NOARG, "Assign taxonomy to each sequence using assign_taxonomy.py (this will override –taxonomy_fp, if provided) [default: False]"));
		this.e_options.add(new Option("Force Overwrite?", "-f", Option.NOARG, "Force overwrite of existing output directory (note: existing files in output_dir will not be removed) [default: None]"));
		this.e_options.add(new Option("Print Only?", "-w", Option.NOARG, "Print the commands but don’t call them – useful for debugging [default: False]"));
		this.e_options.add(new Option("Parallel?", "-a", Option.NOARG, "Run in parallel where available [default: False]"));
		this.e_options.add(new Option("Jobs to Start", "-O", Option.NUM, "Number of jobs to start [default: 1]"));
		this.e_options.add(new Option("Suppress Taxonomy Assignment?", "--suppress_taxonomy_assignment", Option.NOARG, "Skip the taxonomy assignment step, resulting in an OTU table without taxonomy (this will override –taxonomy_fp and –assign_taxonomy, if provided) [default: False]"));
	
	}
}