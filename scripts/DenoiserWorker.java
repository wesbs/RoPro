package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class DenoiserWorker extends Script {
	public static String title = "Denoise Worker";
	public static String b_desc = "Start a denoiser worker process";

	public DenoiserWorker() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/denoiser_worker.html";
		this.c_name = SCRIPTS_PATH + "denoiser_worker.py";
		this.l_desc = "The workers are automatically started by the denoiser.py script. You usually never need to use this script yourself.<br><br>A worker waits for data and does flowgram alignments once it gets it.";
		this.output_desc = "Denoise worker writes a log file if verbose flag is set.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Inpput File", "-f", Option.PATH, "Path used as prefix for worker data files[REQUIRED]"));
		this.r_options.add(new Option("Port", "-p", Option.NUM, "Server port [REQUIRED]"));
		this.r_options.add(new Option("Server Address", "-s", Option.INPUT, "Server address[REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		this.e_options.add(new Option("Error Profile", "-e", Option.PATH, "Path to error profile [DEFAULT: /Users/caporaso/Dropbox/code/Qiime/qiime/support_files/denoiser/Data/FLX_error_profile.dat]"));
		this.e_options.add(new Option("Container", "-c", Option.NUM, "Round counter to start this worker with [default: 0]"));
	
	}
}