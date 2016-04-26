package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class DenoiseWrapper extends Script {
	public static String title = "Denoise Wrapper";
	public static String b_desc = "Denoise a flowgram file";

	public DenoiseWrapper() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/denoise_wrapper.html";
		this.c_name = SCRIPTS_PATH + "denoise_wrapper.py";
		this.l_desc = "This script will denoise a flowgram file in .sff.txt format, which is the output of sffinfo.";
		this.output_desc = "This script results in a OTU like mapping file along with a sequence file of denoised (FASTA-format). Note that the sequences coming from denoising are no real OTUs, and have to be sent to pick_otus.py if the users wishes to have a defined similarity threshold.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Flowgram Files", "-i", Option.PATH, 0, "Path to flowgram files (.sff.txt), comma separated"));
		this.r_options.add(new Option("FASTA File", "-f", Option.PATH, "Path to fasta file from split_libraries.py"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(6);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to output directory [default: denoised_seqs/]"));
		this.e_options.add(new Option("Number of CPUs", "-n", Option.NUM, "Number of CPUs [default: 1]"));
		this.e_options.add(new Option("Overwrite?", "--force_overwrite", Option.NOARG, "Overwrite files in output directory [default: False]"));
		this.e_options.add(new Option("Name of Mapping File", "-m", Option.INPUT, "Name of mapping file, Has to contain field LinkerPrimerSequence. [REQUIRED unless –primer specified]"));
		this.e_options.add(new Option("Primer Sequence", "-p", Option.INPUT, "Primer sequence [REQUIRED unless –map_fname specified]"));
		this.e_options.add(new Option("Titanium?", "--titanium", Option.NOARG, "Select Titanium defaults for denoiser, otherwise use FLX defaults [default: False]"));
	
	}
}




