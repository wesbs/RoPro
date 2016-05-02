package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class SplitLibrariesLea extends Script {
	public static String title = "Split Libraries LEA Sequences";
	public static String b_desc = "Demultiplexes Low-Error Amplicon Sequencing (LEA-Seq) data";

	public SplitLibrariesLea() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/split_libraries_lea_seq.html";
		this.c_name = SCRIPTS_PATH + "split_libraries_lea_seq.py";
		this.l_desc = "Implements Low-Error Amplicon Sequencing (LEA-Seq) method, described in:<br><br>Faith, Jeremiah J., et al. The long-term stability of the human gut microbiota.Science 341.6141 (2013).<br><br>This method is based on redundant sequencing of a set of linear PCR template extensions of 16S rRNA genes. The oligonucleotide primer that is used for PCR template extensions is labeled with a random barcode 5’ to the universal 16S rRNA primer sequence. This PCR pool is then amplified with exponential PCR, using primers that specifically amplify only the linear PCR molecules. An index primer is added to the amplicons along with a primer specific for each sample. This exponential PCR pool is then sequenced redundantly (20x coverage). The resulting sequences are separated by sample, using the index sequence. The amplicon sequences within each sample are separated by the random barcodes. The large number of reads for each barcode helps to create an error-corrected consensus sequence for the initial template molecule.";
		this.output_desc = "The split_libraries_lea_seq.py generates: A fasta file called seqs.fna which contains error corrected consensus sequence for the template DNA";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("FASTQ Files", "-i", Option.PATH, 2, "The forward and reverse sequence read fastq files (comma-separated)"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Directory to store output files"));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "Metadata mapping file"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(11);
		this.e_options.add(new Option("Barcode Type", "-b", Option.INPUT, "The type of barcode used. This can be an integer, e.g. 6 for length 6 barcodes, or golay_12 for golay error-correcting barcodes. Error correction will only be applied for golay_12 barcodes [default: golay_12]"));
		this.e_options.add(new Option("Max Barcode Errors", "--max_barcode_errors", Option.NUM, "Maximum number of errors in barcode [default: 1.5]"));
		this.e_options.add(new Option("Min Consensus", "--min_consensus", Option.NUM, "Threshold for consensus score: the minimum score allowable at any position in sequence. where the score is calulated as: occurence of base in consensus sequence/ total sequences[default: 6.6]"));
		this.e_options.add(new Option("Max CLuster Ratio", "--max_cluster_ratio", Option.NUM, "Threshold for cluster ratio: the maximum allowable cluster ratio above which you need to find the consensus sequence for the given sequences.[default: 2.5]"));
		this.e_options.add(new Option("Max Difference", "--min_difference_in_bcs", Option.NUM, "Threshold for selecting unique barcodes: Barcodes that are more similar to each other than this value will be discarded.[default: 0.86]"));
		this.e_options.add(new Option("Forward Length", "--fwd_length", Option.NUM, "Removes phasing from forward readby truncating it to standard length for the region[default: 64]"));
		this.e_options.add(new Option("Reverse Length", "--rev_length", Option.NUM, "Removes phasing from reverse readby truncating it to standard length for the region[default: 77]"));
		this.e_options.add(new Option("Min Difference in Clusters", "--min_difference_in_clusters", Option.NUM, "The percent identity threshold while using uclust to cluster sequence reads, which is helpfulin measuring quality of sequencing.[default: 0.98]"));
		this.e_options.add(new Option("Min Reads per Random Barcode", "--min_reads_per_random_bc", Option.NUM, "Minimum number of reads per randombarcode, attempts to remove random barcodes that are sequencing errors of true barcodesmight be useful in saving memory and time[default: 1]"));
		this.e_options.add(new Option("Header Barcode Album", "--header_barcode_column", Option.INPUT, "Header of barcode column[default: BarcodeSequence]"));
		this.e_options.add(new Option("Reverse Primer Columns", "--reverse_primer_column", Option.INPUT, "Header of reverse primer column[default: ReversePrimer]"));
	
	}
}


// package scripts;

// import java.io.*;
// import java.lang.String;
// import java.util.*;

// public class ProcessQSeq extends Script {
// 	public static String title = 
// 	public static String b_desc = 

// 	public ProcessQSeq() {
// 		// set up script name, command, and descriptions
// 		this.link = 
// 		this.c_name = SCRIPTS_PATH + 
// 		this.l_desc = 
// 		this.output_desc = 

// 		// set up the required otpions
// 		this.r_options = new ArrayList<Option>();
// 		this.r_options.add(new Option());

// 		// set up the extra options
// 		this.e_options = new ArrayList<Option>();
// 		this.e_options.add(new Option());
	
// 	}
// }