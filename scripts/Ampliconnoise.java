package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class Ampliconnoise extends Script {
		public static String title = "AmpliconNoise";
		public static String b_desc = "Run AmpliconNoise";

	public Ampliconnoise() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/ampliconnoise.html";
		this.c_name = SCRIPTS_PATH + "ampliconnoise.py";
		this.l_desc = "The steps performed by this script are:<br><br>1.Split input sff.txt file into one file per sample<br>2.Run scripts required for PyroNoise<br>3.Run scripts required for SeqNoise<br>4.Run scripts requred for Perseus (chimera removal)<br>5.Merge output files into one file similar to the output of split_libraries.py<br>This script produces a denoised fasta sequence file such as: >PC.355_41 CATGCTGCCTC... ... >PC.636_23 CATGCTGCCTC... ..<br><br>Additionally, the intermediate results of the ampliconnoise pipeline are written to an output directory.<br><br>Ampliconnoise must be installed and correctly configured, and parallelized steps will be called with mpirun, not qiime’s start_parallel_jobs_torque.py script.";
		this.output_desc = "a fasta file of sequences, with labels as:’>sample1_0’ , ‘>sample1_1’ ...";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "The mapping filepath"));
		this.r_options.add(new Option("SFF File", "-i", Option.PATH, "Sff.txt filepath"));
		this.r_options.add(new Option("Output File", "-o", Option.PATH, "The output file"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(11);
		this.e_options.add(new Option("Num of Processes", "-n", Option.NUM, "Number of processes to use for mpi steps. Default: 2"));
		this.e_options.add(new Option("Alpha Value", "--chimera_alpha", Option.NUM, "Alpha value to Class.pl used for chimera removal Default: -3.8228"));
		this.e_options.add(new Option("Beta Value", "--chimera_beta", Option.NUM, "Beta value to Class.pl used for chimera removal Default: 0.62"));
		this.e_options.add(new Option("Seqnoise", "--seqnoise_resolution", Option.NUM, "-s parameter passed to seqnoise. Default is 25.0 for titanium, 30.0 for flx"));
		this.e_options.add(new Option("Intermediate Output", "-d", Option.PATH, "Directory for ampliconnoise intermediate results. Default is output_filepath_dir"));
		this.e_options.add(new Option("Parameter File", "-p", Option.PATH, "Path to the parameter file, which specifies changes to the default behavior. See http://www.qiime.org/documentation/file_formats.html#qiime-parameters. [if omitted, default values will be used]"));
		this.e_options.add(new Option("Force Overwrite?", "-f", Option.NOARG, "Force overwrite of existing output directory (note: existing files in output_dir will not be removed) [default: False]"));
		this.e_options.add(new Option("Print Commands?", "-w", Option.NOARG, "Print the commands but don’t call them – useful for debugging [default: False]"));
		this.e_options.add(new Option("Omit Perseus?", "--suppress_perseus", Option.NOARG, "Omit perseus from ampliconnoise workflow"));
		List<String> selects = new ArrayList<String>();
		selects.add("titanium");
		selects.add("flx");
		this.e_options.add(new Option("Sequencing Technology", "--platform", Option.SELECT, selects, 1, "Sequencing technology, options are ‘titanium’,’flx’. [default: flx]"));
		this.e_options.add(new Option("Truncation Length", "--truncate_len", Option.NUM, "Specify a truncation length for ampliconnoise. Note that is this is not specified, the truncate length is chosen by the –platform option (220 for FLX, 400 for Titanium) [default: None]"));
	
	}
}