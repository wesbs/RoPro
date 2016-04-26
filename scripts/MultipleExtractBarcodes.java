package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MultipleExtractBarcodes extends Script {
	public static String title = "Multiple Extract Barcodes";
	public static String b_desc = "Run extract_barcodes.py on multiple files.";

	public MultipleExtractBarcodes() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/multiple_extract_barcodes.html";
		this.c_name = SCRIPTS_PATH + "multiple_extract_barcodes.py";
		this.l_desc = "This script runs extract_barcodes.py on data that are already demultiplexed (split up according to sample, with one sample per file). The script supports the following types of input:<br><br>a directory containing many files, where each file is named on a per-sample basis<br>a directory containing many directories, where each directory is named on a per-sample basis<br>The script assumes that the leading/trailing characters before/after the read number indicator (see –read1_indicator) are matched between forward and reverse reads. For example:<br><br>S0_L001_R1_001.fastq.gz and S0_L001_R2_001.fastq.gz would be matched up reads<br>S0_L002_R1_00X.fastq.gz and S0_L002_R2_00X.fastq.gz would be matched up reads<br>The output directory used for each call to extract_barcodes.py uses the base name of the input read 1 fastq file (a single directory would be problematic since the output names for extract_barcodes.py can be the same for different calls). Use the parameter –include_input_dir_path to also include the input directory name in the output directory path, which may be preferable in the case of an input folder of folders, and –remove_filepath_in_name can be used in this case to prevent the input read 1 fastq file base name from being used as part of the output directory name.";
		this.output_desc = "The output of running extract_barcodes.py on many input files. See script description for more details.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input Directories", "-i", Option.PATH, 0, "Input directory of directories, or directory of paired fastq files."));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Base output directory to write output folders"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(9);
		this.e_options.add(new Option("Parameter File", "-p", Option.PATH, "Path to the parameter file, which specifies changes to the default behavior of extract_barcodes.py. See http://www.qiime.org/documentation/file_formats.html#qiime-parameters [default: extract_barcodes.py defaults will be used]"));
		this.e_options.add(new Option("Paired Data?", "--paired_data", Option.NOARG, "Turn this option on if paired data are to be used. The type of paired data for extract_barcodes.py should be specified with -p. Forward and reverse reads will be searched for via the –read1_indicator and –read2_indicator parameters [default: False]"));
		this.e_options.add(new Option("Read 1 Indicator", "--read1_indicator", Option.INPUT, "Substring to search for to indicate read 1 [default: _R1_]"));
		this.e_options.add(new Option("Read 2 Indicator", "--read2_indicator", Option.INPUT, "Substring to search for to indicate read 2 [default: _R2_]"));
		this.e_options.add(new Option("Leading Text", "--leading_text", Option.INPUT, "Leading text to add to each extract_barcodes.py command [default: no leading text added]"));
		this.e_options.add(new Option("Trailing Text", "--trailing_text", Option.INPUT, "Trailing text to add to each extract_barcodes.py command [default: no trailing text added]"));
		this.e_options.add(new Option("Include Path?", "--include_input_dir_path", Option.NOARG, "Include the input directory name in the output directory path. Useful in cases where the file names are repeated in input folders [default: False]"));
		this.e_options.add(new Option("Remove Filepath?", "--remove_filepath_in_name", Option.NOARG, "Disable inclusion of the input filename in the output directory names. Must use –include_input_dir_path if this option is enabled [default: False]"));
		this.e_options.add(new Option("Print Only?", "-w", Option.NOARG, "Print the commands but don’t call them – useful for debugging [default: False]"));
	
	}
}