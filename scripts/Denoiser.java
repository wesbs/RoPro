package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class Denoiser extends Script {
	public static String title = "Denoiser";
	public static String b_desc = "Remove noise from 454 sequencing data";

	public Denoiser() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/denoiser.html";
		this.c_name = SCRIPTS_PATH + "denoiser.py";
		this.l_desc = "The denoiser removes sequencing noise characteristic to pyrosequencing by flowgram clustering. For a detailed explanation of the underlying algorithm see (Reeder and Knight, Nature Methods 7(9), 2010).";
		this.output_desc = "centroids.fasta: The cluster representatives of each cluster<br><br>singletons.fasta: contains all unclustered reads<br><br>denoiser_mapping.txt: This file contains the actual clusters. The cluster centroid is given first,<br>the cluster members follow after the ‘:’.<br><br>checkpoints/ : directory with checkpoints<br><br>Note that the centroids and singleton files are disjoint. For most downstream analyses one wants to cat the two files.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Input Files", "-i", Option.PATH, 0, "Path to flowgram files (.sff.txt), comma separated"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(18);
		this.e_options.add(new Option("FASTA Input", "-f", Option.PATH, "Path to fasta input file. Reads not in the fasta file are filtered out before denoising. File format is as produced by split_libraries.py [default: None]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to output directory [default: random dir in ./]"));
		this.e_options.add(new Option("Cluster?", "-c", Option.NOARG, "Use cluster/multiple CPUs for flowgram alignments [default: False]"));
		this.e_options.add(new Option("Preprocess File", "-p", Option.PATH, "Do not do preprocessing (phase I),instead use already preprocessed data in PREPROCESS_FP"));
		this.e_options.add(new Option("Checkpoint", "--checkpoint_fp", Option.PATH, "Resume denoising from checkpoint. Be careful when changing parameters for a resumed run. Requires -p option. [default: None]"));
		this.e_options.add(new Option("Squeeze?", "-s", Option.NOARG, "Use run-length encoding for prefix filtering in phase I [default: False]"));
		this.e_options.add(new Option("Slpit?", "-S", Option.NOARG, "Split input into per library sets and denoise separately [default: False]"));
		this.e_options.add(new Option("Overwrite?", "--force", Option.NOARG, "Force overwrite of existing directory [default: False]"));
		this.e_options.add(new Option("Primer", "--primer", Option.INPUT, "Primer sequence [default: CATGCTGCCTCCCGTAGGAGT]"));
		this.e_options.add(new Option("Num of CPUs", "-n", Option.NUM, "Number of cpus, requires -c [default: 1]"));
		this.e_options.add(new Option("Max Iterations", "-m", Option.NUM, "Maximal number of iterations in phase II. None means unlimited iterations [default: None]"));
		this.e_options.add(new Option("Bail Out", "-b", Option.NUM, "Stop clustering in phase II with clusters smaller or equal than BAILde [default: 1]"));
		this.e_options.add(new Option("Percent ID", "--percent_id", Option.NUM, "Sequence similarity clustering threshold, expressed as a fraction between 0 and 1 [default: 0.97]"));
		this.e_options.add(new Option("Low Cut Off", "--low_vut_off", Option.NUM, "Low clustering threshold for phase II [default: 3.75]"));
		this.e_options.add(new Option("High Cut Off", "--high_vut_off", Option.NUM, "High clustering threshold for phase III [default: 4.5]"));
		this.e_options.add(new Option("Low Memory?", "--low_memory", Option.NOARG, "Use slower, low memory method [default: False]"));
		this.e_options.add(new Option("Error Profile", "-e", Option.PATH, "Path to error profile [default= <qiime-install-path>/qiime/support_files/denoiser/Data/FLX_error_profile.dat]"));
		this.e_options.add(new Option("Titanium", "--titanium", Option.NOARG, "Shortcut for -e <qiime-install-path>/qiime/support_files/denoiser/Data//Titanium_error_profile.dat –low_cut_off=4 –high_cut_off=5 . Warning: overwrites all previous cut-off values [DEFAULT: False]"));
	
	}
}