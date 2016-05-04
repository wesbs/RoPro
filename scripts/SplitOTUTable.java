package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class SplitOTUTable extends Script {
	public static String title = "Split OTU Table";
	public static String b_desc = "Split a biom table into one table per combination of values found in the specified fields in the mapping file.";

	public SplitOTUTable() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/split_otu_table.html";
		this.c_name = SCRIPTS_PATH + "split_otu_table.py";
		this.l_desc = "This script splits a biom table based on the cartesian product of the values found in the mapping fields specified. It accepts any number of mapping fields to split on. As an example assume the following was your mapping file data:<br><br>SampleID Color Habitat Age S1 Red Stream 10 S2 Blue Stream 20 S3 Blue Lake 30 S4 Red Stream 30<br><br>If we wanted to split a corresponding biom table by the ‘Color’ and ‘Habitat’ fields simultanesouly, we would return 3 biom tables with the following samples corresponding to the following groups:<br><br>(S1, S4): (Red, Stream) (S2): (Blue, Stream) (S3): (Blue, Lake)<br><br>Combinations which would result in no samples – in our example (Red, Lake) – are excluded and do not produce (empty) biom tables. The script optionally produces split mapping files as well.<br><br>The naming convention for split files is (assuming two fields):<br><br>input_table.biom -> input_table__field1_value1_field2_value2__.biom input_mapping.txt -> input_mapping__field1_value1_field2_value2__.txt<br><br>So, from our example above:<br><br>input_table.biom -> (input_table__Color_Red_Habitat_Stream__.biom,<br>input_table__Color_Blue_Habitat_Stream__.biom, input_table__Color_Blue_Habitat_Lake__.biom)";
		this.output_desc = "No Description";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(4);
		this.r_options.add(new Option("BIOM Table", "-i", Option.PATH, "The input biom table file path."));
		this.r_options.add(new Option("Mapping File", "-m", Option.PATH, "The mapping file path."));
		this.r_options.add(new Option("Fields", "-f", Option.INPUT, "Mapping columns to split biom table on, comma separated."));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "File path to the output directory to be created."));

		// set up the extra options
		this.e_options = new ArrayList<Option>(1);
		this.e_options.add(new Option("Suppress Mapping File Output?", "--suppress_mapping_file_output", Option.NOARG, "Do not write out split mapping files."));
	
	}
}