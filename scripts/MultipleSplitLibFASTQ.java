package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MultipleSplitLibFASTQ extends Script {
	public static String title = "Multiple Split Libraries FASTQ";
	public static String b_desc = "Run split_libraries_fastq.py on multiple files.";

	public MultipleSplitLibFASTQ() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/multiple_split_libraries_fastq.html";
		this.c_name = SCRIPTS_PATH + "multiple_split_libraries_fastq.py";
		this.l_desc = "This script runs split_libraries_fastq.py on data that are already demultiplexed (split up according to sample, with one sample per file). The script supports the following types of input:<br><br>a directory containing many files, where each file is named on a per-sample basis (with different prefixes before the read number)<br>a directory containing many directories, where each directory is named on a per-sample basis<br>This script assumes that the leading characters before the read indicator (see –read_indicator) are matched between the read, barcode, and mapping files. For example, sample1_L001_R1_001.fastq.gz, sample1_L001_I1_001.fastq.gz, sample1_L001_mapping_001.txt would be matched up if “R1” is the read indicator, “I1” is the barcode indicator, and “mapping” is the mapping file indicator.";
		this.output_desc = "The output of running split_libraries_fastq.py on many input files. See script description for more details.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(2);
		this.r_options.add(new Option("Input Directory/File", "-i", Option.PATH, "Input directory of directories, or directory of paired fastq files."));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output directory to write split_libraries_fastq.py results"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(12);
		List<String> selects = new ArrayList<String>();
		selects.add("sampleid_by_file");
		selects.add("mapping_barcode_files");
		this.e_options.add(new Option("Demultiplexing Method", "-m", Option.SELECT, selects, 0, "Method for demultiplexing. Can either be “sampleid_by_file” or “mapping_barcode_files”. With the sampleid_by_file option, each fastq file (and/or directory name) will be used to generate the –sample_ids value passed to split_libraries_fastq.py. The mapping_barcode_files option will search for barcodes and mapping files that match the input read files [default: sampleid_by_file]"));
		this.e_options.add(new Option("Parameter File", "-p", Option.PATH, "Path to the parameter file, which specifies changes to the default behavior of extract_barcodes.py. See http://www.qiime.org/documentation/file_formats.html#qiime-parameters [default: extract_barcodes.py defaults will be used]"));
		this.e_options.add(new Option("Read Indicator", "--read_indicator", Option.INPUT, "Substring to search for to indicate read files [default: _R1_]"));
		this.e_options.add(new Option("Barcode Indicator", "--barcode_indicator", Option.INPUT, "Substring to search for to indicate barcode files [default: _I1_]"));
		this.e_options.add(new Option("Mapping Indicator", "--mapping_indicator", Option.INPUT, "Substring to search for to indicate mapping files [default: _mapping_]"));
		this.e_options.add(new Option("Mapping Extensions", "--mapping_extensions", Option.INPUT, "Comma-separated list of file extensions used to identify mapping files. Only applies when –demultiplexing_method is “mapping_barcode_files” [default: txt,tsv]"));
		this.e_options.add(new Option("Sample ID Indicator", "--sampleid_indicator", Option.INPUT, "Text in fastq filename before this value will be used as output sample ids [default: _]"));
		this.e_options.add(new Option("Include Input Path?", "--include_input_dir_path", Option.NOARG, "Include the input directory name in the output sample id name. Useful in cases where the file names are repeated in input folders [default: False]"));
		this.e_options.add(new Option("Remove Filepath?", "--remove_filepath_in_name", Option.NOARG, "Disable inclusion of the input filename in the output sample id names. Must use –include_input_dir_path if this option is enabled [default: False]"));
		this.e_options.add(new Option("Leading Text", "--leading_text", Option.INPUT, "Leading text to add to each split_libraries_fastq.py command [default: no leading text added]"));
		this.e_options.add(new Option("Trailing Text", "--trailing_text", Option.INPUT, "Trailing text to add to each split_libraries_fastq.py command [default: no trailing text added]"));
		this.e_options.add(new Option("Print Only?", "-w", Option.NOARG, "Print the commands but don’t call them – useful for debugging [default: False]"));
	
	}
}