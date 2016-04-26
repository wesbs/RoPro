package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MapReadsToRef extends Script {
	public static String title = "Map REads to Refernece File";
	public static String b_desc = "Script for performing assignment of reads against a reference database";

	public MapReadsToRef() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/map_reads_to_reference.html";
		this.c_name = SCRIPTS_PATH + "map_reads_to_reference.py";
		this.l_desc = "No Description";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Sequences File", "-i", Option.PATH, "Path to input sequences file"));
		this.r_options.add(new Option("Reference Sequences", "-r", Option.PATH, "Path to reference sequences to search against [default: None]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(11);
		List<String> selects = new ArrayList<String>();
		selects.add("bwa-short");
		selects.add("usearch");
		selects.add("bwa-sw");
		selects.add("blat");
		selects.add("blat-nt");
		this.e_options.add(new Option("Assignment Method", "-m", Option.SELECT, selects, 1, "Method for picking OTUs. Valid choices are: bwa-short, usearch, bwa-sw, blat, blat-nt. [default: usearch]"));
		this.e_options.add(new Option("Observation Metadata", "-t", Option.PATH, "Path to observation metadata (e.g., taxonomy, EC, etc) [default: None]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to store result file [default: ./<METHOD>_mapped/]"));
		this.e_options.add(new Option("Max E-Value", "-e", Option.INPUT, "Max e-value to consider a match [default: 1e-10]"));
		this.e_options.add(new Option("Min Percent", "-s", Option.NUM, "Min percent id to consider a match, expressed as a fraction between 0 and 1 [default: 0.75]"));
		this.e_options.add(new Option("Genetic Code", "--genetic_code", Option.NUM, "ID of genetic code to use for DNA translations (please see http://www.ncbi.nlm.nih.gov/Taxonomy/Utils/wprintgc.cgi) Only valid with -m blat. [default: 11]"));
		this.e_options.add(new Option("Max Difference", "--max_diff", Option.NUM, "MaxDiff to consider a match (applicable for -m bwa-short) – see the aln section of “man bwa” for details [default (defined by bwa): 0.04]"));
		this.e_options.add(new Option("Min Query Sequences", "--queryalnfract", Option.NUM, "Min percent of the query seq that must match to consider a match, expressed as a fraction between 0 and 1 (usearch only) [default: 0.35]"));
		this.e_options.add(new Option("Min Target Sequence", "--targetalnfract", Option.NUM, "Min percent of the target/reference seq that must match to consider a match, expressed as a fraction between 0 and 1 (usearch only) [default: 0.0]"));
		this.e_options.add(new Option("Max Accepts", "--max_accepts", Option.NUM, "Max_accepts value (usearch only) [default: 1]"));
		this.e_options.add(new Option("Max Rejects", "--max_rejects", Option.NUM, "Max_rejects value to (usearch only) [default: 32]"));
	
	}
}