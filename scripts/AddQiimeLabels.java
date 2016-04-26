package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class AddQiimeLabels extends Script {
		public static String title = "Add Qiime Labels";
		public static String b_desc = "Takes a directory, a metadata mapping file, and a column name that contains the fasta file names that SampleIDs are associated with, combines all files that have valid fasta extensions into a single fasta file, with valid QIIME fasta labels.";
	
	public AddQiimeLabels() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/add_qiime_labels.html";
		this.c_name = SCRIPTS_PATH + "add_qiime_labels.py";
		this.l_desc = "A metadata mapping file with SampleIDs and fasta file names (just the file name itself, not the full or relative filepath) is used to generate a combined fasta file with valid QIIME labels based upon the SampleIDs specified in the mapping file.<br>See: http://qiime.org/documentation/file_formats.html#metadata-mapping-files for details about the metadata file format.<br>Example mapping file: #SampleID BarcodeSequence LinkerPrimerSequence InputFileName Description Sample.1 AAAACCCCGGGG CTACATAATCGGRATT seqs1.fna sample.1 Sample.2 TTTTGGGGAAAA CTACATAATCGGRATT seqs2.fna sample.2<br>This script is to handle situations where fasta data comes already demultiplexed into a one fasta file per sample basis. Only alters the fasta label to add a QIIME compatible label at the beginning.<br>Example: With the metadata mapping file above, and an specified directory containing the files seqs1.fna and seqs2.fna, the first line from the seqs1.fna file might look like this: >FLP3FBN01ELBSX length=250 xy=1766_0111 region=1 run=R_2008_12_09_13_51_01_ AACAGATTAGACCAGATTAAGCCGAGATTTACCCGA<br>and in the output combined fasta file would be written like this >Sample.1_0 FLP3FBN01ELBSX length=250 xy=1766_0111 region=1 run=R_2008_12_09_13_51_01_ AACAGATTAGACCAGATTAAGCCGAGATTTACCCGA<br>No changes are made to the sequences.";
		this.output_desc = "A combined_seqs.fasta file will be created in the output directory, with the sequences assigned to the SampleID given in the metadata mapping file.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "SampleID to fasta file name mapping file filepath"));
		this.r_options.add(new Option("FASTA File(s)", "-i", Option.PATH, 2, "Directory of fasta files to combine and label."));
		this.r_options.add(new Option("Column", "-c", Option.INPUT, "Specify column used in metadata mapping file for fasta file names."));

		// set up the extra options
		this.e_options = new ArrayList<Option>(2);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Required output directory for log file and corrected mapping file, log file, and html file. [default: .]"));
		this.e_options.add(new Option("Starting Label", "-n", Option.NUM, "Specify the number to start enumerating sequence labels with. [default: 0]"));
	
	}
}