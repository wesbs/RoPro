package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class UnweightFASTA extends Script {
	public static String title = "Unweight FASTA";
	public static String b_desc = "Transform fasta files with abundance weighting into unweighted";

	public UnweightFASTA() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/unweight_fasta.html";
		this.c_name = SCRIPTS_PATH + "unweight_fasta.py";
		this.l_desc = "E.g. makes 3 fasta records from a weighted input fasta file containing the following record: >goodsample1_12_3 bc_val=20 AATGCTTGTCACATCGATGC";
		this.output_desc = "a .fasta file";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "The input fasta file"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "The output fasta filepath"));
		this.r_options.add(new Option("Label", "-l", Option.INPUT, "Sequence label used for all records. fasta label lines will look like: >label_423"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(0);
		// this.e_options.add(new Option());
	
	}
}