package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ConvertFASTA extends Script {
	public static String title = "Convert FASTA and QUAL to FASTQ";
	public static String b_desc = "From a FASTA file and a matching QUAL file, generates a FASTQ file. From FASTQ file generates FASTA file and matching QUAL file.";

	public ConvertFASTA() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/convert_fastaqual_fastq.html";
		this.c_name = SCRIPTS_PATH + "convert_fastaqual_fastq.py";
		this.l_desc = "From a FASTA file and a matching QUAL file, generates a FASTQ file. A minimal FASTQ file omits the redundant sequence label on the quality scores; the quality scores for a sequence are assumed to follow immediately after the sequence with which they are associated. The output FASTQ file will be generated in the specified output directory with the same name as the input FASTA file, suffixed with ‘.fastq’. A FASTQ file will be split into FASTA and QUAL files, and generated in the designated output directory.";
		this.output_desc = "Outputs a complete or minimal FASTQ file, which omits the redundant sequence label on the quality scores, or splits FASTQ file into matching FASTA/QUAL files.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Input File", "-f", Option.PATH, "Input FASTA or FASTQ file."));

		// set up the extra options
		this.e_options = new ArrayList<Option>(7);
		this.e_options.add(new Option("Input QUAL File", "-q", Option.PATH, "Required input QUAL file if converting to FASTQ."));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Output directory. Will be created if does not exist. [default: .]"));
		List<String> selects = new ArrayList<String>();
		selects.add("fastaqual_to_fastq");
		selects.add("fastq_to_fastaqual");
		this.e_options.add(new Option("Conversion Type", "-c", Option.SELECT, selects, 0, "Type of conversion: fastaqual_to_fastq or fastq_to_fastaqual [default: fastaqual_to_fastq]"));
		this.e_options.add(new Option("ASCII Increment", "-a", Option.NUM, "The number to add (subtract if coverting from FASTQ) to the quality score to get the ASCII character (or numeric quality score). [default: 33]"));
		this.e_options.add(new Option("Full FASTA Headers", "-F", Option.NOARG, "Include full FASTA headers in output file(s) (as opposed to merely the sequence label). [default: False]"));
		this.e_options.add(new Option("Full FASTQ", "-b", Option.NOARG, "Include identifiers on quality lines in the FASTQ file (those beginning with a “+”). Irrelevant when converting from FASTQ. [default=False]"));
		this.e_options.add(new Option("Multiple Output", "-m", Option.NOARG, "Create multiple FASTQ files, one for each sample, or create multiple matching FASTA/QUAL for each sample. [default=False]"));
	
	}
}