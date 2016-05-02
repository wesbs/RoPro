package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class SplitLibrariesFASTQ extends Script {
	public static String title = "Split Libraries FASTQ";
	public static String b_desc = "This script performs demultiplexing of Fastq sequence data where barcodes and sequences are contained in two separate fastq files (common on Illumina runs).";

	public SplitLibrariesFASTQ() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/split_libraries_fastq.html";
		this.c_name = SCRIPTS_PATH + "split_libraries_fastq.py";
		this.l_desc = "No Description";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("FASTQ File(s)", "-i", Option.PATH, 0, "The sequence read fastq files (comma-separated if more than one)"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Directory to store output files"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(18);
		this.e_options.add(new Option("Mapping File(s)", "-m", Option.PATH, 0, "Metadata mapping files (comma-separated if more than one) [default: None]"));
		this.e_options.add(new Option("Barcode Read File(s)", "-b", Option.PATH, 0, "The barcode read fastq files (comma-separated if more than one) [default: None]"));
		this.e_options.add(new Option("Record QUAL Scores?", "--store_qual_scores", Option.NOARG, "Store qual strings in .qual files [default: False]"));
		this.e_options.add(new Option("Sample IDs", "--sample_ids", Option.INPUT, "Comma-separated list of samples ids to be applied to all sequences, must be one per input file path (used when data is not multiplexed) [default: None]"));
		this.e_options.add(new Option("Store Demultiplexed FASTQ", "--store_demultiplexed_fastq", Option.NOARG, "Write demultiplexed fastq files [default: False]"));
		this.e_options.add(new Option("Retain Unassigned Reads?", "--retain_unassigned_reads", Option.NOARG, "Retain sequences which are Unassigned in the output sequence file[default: False]"));
		this.e_options.add(new Option("Max Bad Run Length", "-r", Option.NUM, "Max number of consecutive low quality base calls allowed before truncating a read [default: 3]"));
		this.e_options.add(new Option("Min Per Length Fraction", "-p", Option.NUM, "Min number of consecutive high quality base calls to include a read (per single end read) as a fraction of the input read length [default: 0.75]"));
		this.e_options.add(new Option("Sequence Max", "-n", Option.NUM, "Maximum number of N characters allowed in a sequence to retain it – this is applied after quality trimming, and is total over combined paired end reads if applicable [default: 0]"));
		this.e_options.add(new Option("Start Sequence ID", "-s", Option.NUM, "Start seq_ids as ascending integers beginning with start_seq_id [default: 0]"));
		this.e_options.add(new Option("Reverse Complement Barcodes?", "--rev_comp_barcode", Option.NOARG, "Reverse complement barcode reads before lookup [default: False]"));
		this.e_options.add(new Option("Reverse Complement Mapping Barcodes?", "--rev_comp_mapping_barcodes", Option.NOARG, "Reverse complement barcode in mapping before lookup (useful if barcodes in mapping file are reverse complements of golay codes) [default: False]"));
		this.e_options.add(new Option("Reverse Complement Sequence?", "--rev_comp", Option.NOARG, "Reverse complement sequence before writing to output file (useful for reverse-orientation reads) [default: False]"));
		this.e_options.add(new Option("Phred Qulaity Threshold", "-q", Option.NUM, "The maximum unacceptable Phred quality score (e.g., for Q20 and better, specify -q 19) [default: 3]"));
		this.e_options.add(new Option("Last Bad Quality Char?", "--last_bad_quality_char", Option.NOARG, "DEPRECATED: use -q instead. This method of setting is not robust to different versions of CASAVA."));
		this.e_options.add(new Option("Barcode Type", "--barcode_type", Option.INPUT, "The type of barcode used. This can be an integer, e.g. for length 6 barcodes, or “golay_12” for golay error-correcting barcodes. Error correction will only be applied for “golay_12” barcodes. If data is not barcoded, pass “not-barcoded”. [default: golay_12]"));
		this.e_options.add(new Option("Max Barcode Errors", "--max_barcode_errors", Option.NUM, "Maximum number of errors in barcode [default: 1.5]"));
		this.e_options.add(new Option("Phred Offset", "--phred_offset", Option.NUM, "The ascii offset to use when decoding phred scores (either 33 or 64). Warning: in most cases you don’t need to pass this value [default: determined automatically]"));
	
	}
}