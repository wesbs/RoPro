package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ValidateMappingFile extends Script {
	public static String title = "Validate Mapping File";
	public static String b_desc = "Checks user’s metadata mapping file for required data, valid format";

	public ValidateMappingFile() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/validate_mapping_file.html";
		this.c_name = SCRIPTS_PATH + "validate_mapping_file.py";
		this.l_desc = "Specifically, we check that:<br><br>The BarcodeSequence, LinkerPrimerSequences, and ReversePrimer fields<br>have valid IUPAC DNA characters, and BarcodeSequence characters are non-degenerate (error)<br><br>The SampleID, BarcodeSequence, LinkerPrimerSequence, and Description<br>headers are present. (error)<br><br>There are not duplicate header fields (error)<br><br>There are not duplicate barcodes (error)<br><br>Barcodes are of the same length. Suppressed when<br>variable_len_barcode flag is passed (warning)<br><br>The headers do not contain invalid characters (alphanumeric and<br>underscore only) (warning)<br>The data fields do not contain invalid characters (alphanumeric,<br>underscore, space, and +-%./:,; characters) (warning)<br><br>SampleID fields are MIENS compliant (only alphanumeric<br>and . characters). (warning)<br><br>There are no duplicates when the primer and variable length<br>barcodes are appended (error)<br><br>There are no duplicates when barcodes and added demultiplex<br>fields (-j option) are combined (error)<br><br>Data fields are not found beyond the Description column (warning)<br><br>Details about the metadata mapping file format can be found here: http://www.qiime.org/documentation/file_formats.html#metadata-mapping-files<br><br>Errors and warnings are saved to a log file. Errors can be caused by problems with the headers, invalid characters in barcodes or primers, or by duplications in SampleIDs or barcodes.<br><br>Warnings can arise from invalid characters and variable length barcodes that are not specified with the –variable_len_barcode. Warnings will contain a reference to the cell (row,column) that the warning arose from.<br><br>In addition to the log file, a “corrected_mapping” file will be created. Any invalid characters will be replaced with ‘.’ characters in the SampleID fields (to enforce MIENS compliance) and text in other data fields will be replaced with the character specified by the -c parameter, which is an underscore “_” by default.<br><br>A html file will be created as well, which will show locations of warnings and errors, highlighted in yellow and red respectively. If no errors or warnings were present the file will display a message saying such. Header errors can mask other errors, so these should be corrected first.<br><br>If pooled primers are used, separate with a comma. For instance, a pooled set of three 27f primers (used to increase taxonomic coverage) could be specified in the LinkerPrimerSequence fields as such: AGGGTTCGATTCTGGCTCAG,AGAGTTTGATCCTGGCTTAG,AGAATTTGATCTTGGTTCAG";
		this.output_desc = "A log file, html file, and corrected_mapping.txt file will be written to the current output directory.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "Metadata mapping filepath"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(8);
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Required output directory for log file, corrected mapping file, and html file. [default: ./]"));
		this.e_options.add(new Option("Verbose?", "-v", Option.NOARG, "Enable printing information to standard out [default: True]"));
		this.e_options.add(new Option("Character Replace", "-c", Option.INPUT, "Changes the default character used to replace invalid characters found in the mapping file. Must be a valid character (alphanumeric, period, or underscore).[default: _]"));
		this.e_options.add(new Option("Not Barcoded?", "-b", Option.NOARG, "Use -b if barcodes are not present. BarcodeSequence header still required. [default: False]"));
		this.e_options.add(new Option("Varibale Length Barcodes?", "-B", Option.NOARG, "Use -B if variable length barcodes are present to suppress warnings about barcodes of unequal length. [default: False]"));
		this.e_options.add(new Option("Disable Primer Check?", "-p", Option.NOARG, "Use -p to disable checks for primers. LinkerPrimerSequence header still required. [default: False]"));
		this.e_options.add(new Option("Added Demultiplex Field", "-j", Option.INPUT, "Use -j to add a field to use in the mapping file as additional demultiplexing (can be used with or without barcodes). All combinations of barcodes/primers and the these fields must be unique. The fields must contain values that can be parsed from the fasta labels such as “plate=R_2008_12_09”. In this case, “plate” would be the column header and “R_2008_12_09” would be the field data (minus quotes) in the mapping file. To use the run prefix from the fasta label, such as “>FLP3FBN01ELBSX”, where “FLP3FBN01” is generated from the run ID, use “-j run_prefix” and set the run prefix to be used as the data under the column header “run_prefix”. [default: None]"));
		this.e_options.add(new Option("Suppress HTML?", "-s", Option.NOARG, "Use -s to disable html file generation, can be useful for extremely large mapping files. [default: False]"));
	
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