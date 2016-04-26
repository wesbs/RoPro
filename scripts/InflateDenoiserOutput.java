package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class InflateDenoiserOutput extends Script {
	public static String title = "Inflate Denoiser Output";
	public static String b_desc = "Inflate denoiser results so they can be passed directly to OTU pickers.";

	public InflateDenoiserOutput() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/inflate_denoiser_output.html";
		this.c_name = SCRIPTS_PATH + "inflate_denoiser_output.py";
		this.l_desc = "Inflate denoiser results so they can be passed directly to pick_otus.py, parallel_pick_otus_uclust_ref.py, or pick_de_novo_otus.py. Note that the results of this script have not be abundance sorted, so they must be before being passed to the OTU picker. The uclust OTU pickers incorporate this abundance presorting by default.<br><br>The inflation process writes each centroid sequence n times, where n is the number of reads that cluster to that centroid, and writes each singleton once. Flowgram identifiers are mapped back to post-split_libraries identifiers in this process (i.e., identifiers in fasta fps).";
		this.output_desc = "No Description.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(5);
		this.r_options.add(new Option("Centroid FASTA Files", "-c", Option.PATH, 0, "The centroid fasta filepaths"));
		this.r_options.add(new Option("Singleton FASTA Files", "-s", Option.PATH, 0, "The singleton fasta filepaths"));
		this.r_options.add(new Option("Denoiser FASTA Files", "-f", Option.PATH, "The input (to denoiser) fasta filepaths"));
		this.r_options.add(new Option("Mapping Files", "-m", Option.PATH, "The denoiser map filepaths"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output fasta filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(0);
		// this.e_options.add(new Option());
	
	}
}