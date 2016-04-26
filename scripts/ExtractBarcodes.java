package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ExtractBarcodes extends Script {
	public static String title = "Extract Barcodes";
	public static String b_desc = "This script is designed to format fastq sequence and barcode data so they are compatible with split_libraries_fastq.py (see http://qiime.org/tutorials/processing_illumina_data.html).";

	public ExtractBarcodes() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/extract_barcodes.html";
		this.c_name = SCRIPTS_PATH + "extract_barcodes.py";
		this.l_desc = "A variety of data formats are possible, depending upon how one utilized sequencing primers, designed primer constructs (e.g., partial barcodes on each end of the read), or processed the data (e.g., barcodes were put into the sequence labels rather than the reads). See various input examples below.";
		this.output_desc = "In the output directory, there will be fastq files (barcode file, and one or two reads files)";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Input FASTQ", "-f", Option.PATH, "Input fastq filepath. This file is considered read 1."));

		// set up the extra options
		this.e_options = new ArrayList<Option>(12);
		this.e_options.add(new Option("Input FASTQ 2", "-r", Option.PATH, "Input fastq filepath. This file is considered read 2. [default: None]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Directory prefix for output files [default: .]"));
		List<String> selects = new ArrayList<String>();
		selects.add("barcode_single_end");
		selects.add("barcode_paired_end");
		selects.add("barcode_paired_stitched");
		selects.add("barcode_in_label");
		this.e_options.add(new Option("Input Type", "-c", Option.SELECT, selects, 0, "Specify the input type. barcode_single_end: Input is a single fastq file, that starts with the barcode sequence. barcode_paired_end: Input is a pair of fastq files (–fastq1 and –fastq2) that each begin with a barcode sequence. The barcode for fastq1 will be written first, followed by the barcode from fastq2. barcode_paired_stitched: Input is a single fastq file that has barcodes at the beginning and end. The barcode from the beginning of the read will be written first followed by the barcode from the end of the read, unless the order is switched with –switch_bc_order. barcode_in_label: Input is a one (–fastq1) or two (–fastq2) fastq files with the barcode written in the labels. [default: barcode_single_end]"));
		this.e_options.add(new Option("Base Pairs Length", "-l", Option.NUM, "Specify the length, in base pairs, of barcode 1. This applies to the –fastq1 file and all options specified by –input_type [default: 6]"));
		this.e_options.add(new Option("Base Pairs Length 2", "-L", Option.NUM, "Specify the length, in base pairs, of barcode 2. This applies to the –fastq2 file and options “barcode_paired_end”, “barcode_paired_stitched”, and “barcode_in_label” for the –input_type [default: 6]"));
		this.e_options.add(new Option("Reverse 1?", "--rev_comp_bc1", Option.NOARG, "Reverse complement barcode 1 before writing [default: False]"));
		this.e_options.add(new Option("Reverse 2?", "--rev_comp_bc2", Option.NOARG, "Reverse complement barcode 2 before writing [default: False]"));
		this.e_options.add(new Option("Character Delineator", "-s", Option.INPUT, "Character in fastq label that should immediately precede the barcode sequence. The length of the barcode is specified by the –bc1_len (and optionally –bc2_len if paired end files are used) parameter. [default: :]"));
		this.e_options.add(new Option("Switch Barcode Order?", "--switch_bc_order", Option.NOARG, "Reverse barcode order written when using the -c barcode_paired_stitched option. [default: False]"));
		this.e_options.add(new Option("Mapping File", "-m", Option.PATH, "Filepath of mapping file. NOTE: Must contain a header line indicating SampleID in the first column and BarcodeSequence in the second, LinkerPrimerSequence in the third and a ReversePrimer column before the final Description column. Needed for –attempt_read_orientation option. [default: None]"));
		this.e_options.add(new Option("Attempt Read Reorientatiton", "--attempt_read_reorientation", Option.NOARG, "Will attempt to search for the forward and reverse primer in the read and adjust the sequence orientation to match the orientation of the forward primer. An exact match for the forward and reverse complemented versions of the primers are tested for, and sequences are reverse complemented, if necessary, before writing. Sequences without an exact match are written to a separate output fastq file, labeled as _no_primer_match.fastq. [default: False]"));
		this.e_options.add(new Option("Disable Header Match", "-d", Option.NOARG, "Enable this option to suppress header matching between input fastq files.[default: False]"));
	
	}
}