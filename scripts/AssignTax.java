package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class AssignTax extends Script {
		public static String title = "Assign Taxonomy";
		public static String b_desc = "Assign taxonomy to each sequence";

	public AssignTax() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/assign_taxonomy.html";
		this.c_name = SCRIPTS_PATH + "assign_taxonomy.py";
		this.l_desc = "Contains code for assigning taxonomy, using several techniques.<br><br>Given a set of sequences, assign_taxonomy.py attempts to assign the taxonomy of each sequence. Currently the methods implemented are assignment with BLAST, the RDP classifier, RTAX, mothur, and uclust. The output of this step is an observation metadata mapping file of input sequence identifiers (1st column of output file) to taxonomy (2nd column) and quality score (3rd column). There may be method-specific information in subsequent columns.<br><br>Reference data sets and id-to-taxonomy maps for 16S rRNA sequences can be found in the Greengenes reference OTU builds. To get the latest build of the Greengenes OTUs (and other marker gene OTU collections), follow the “Resources” link from http://qiime.org. After downloading and unzipping you can use the following files as -r and -t, where <otus_dir> is the name of the new directory after unzipping the reference OTUs tgz file.<br><br>-r <otus_dir>/rep_set/97_otus.fasta -t <otus_dir>/taxonomy/97_otu_taxonomy.txt";
		this.output_desc = "The consensus taxonomy assignment implemented here is the most detailed lineage description shared by 90% or more of the sequences within the OTU (this level of agreement can be adjusted by the user). The full lineage information for each sequence is one of the output files of the analysis. In addition, a conflict file records cases in which a phylum-level taxonomy assignment disagreement exists within an OTU (such instances are rare and can reflect sequence misclassification within the greengenes database).";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Input FASTA file", "-i", Option.PATH, "Path to the input fasta file"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(24);
		this.e_options.add(new Option("ID to Tax", "-t", Option.PATH, "Path to tab-delimited file mapping sequences to assigned taxonomy. Each assigned taxonomy is provided as a semicolon-separated list. For assignment with rdp, each assigned taxonomy must be exactly 6 levels deep. [default: /Users/caporaso/.virtualenvs/qiime/lib/python2.7/site-packages/qiime_default_reference/gg_13_8_otus/taxonomy/97_otu_taxonomy.txt]"));
		this.e_options.add(new Option("Reference Sequences", "-r", Option.PATH, "Path to reference sequences. For assignment with blast, these are used to generate a blast database. For assignment with rdp, they are used as training sequences for the classifier. [default: /Users/caporaso/.virtualenvs/qiime/lib/python2.7/site-packages/qiime_default_reference/gg_13_8_otus/rep_set/97_otus.fasta]"));
		this.e_options.add(new Option("Training Data File", "-p", Option.PATH, "Path to ”.properties” file in pre-compiled training data for the RDP Classifier. This option is overridden by the -t and -r options. [default: None]"));
		this.e_options.add(new Option("First Read File", "--read_1_seqs_fp", Option.PATH, "Path to fasta file containing the first read from paired-end sequencing, prior to OTU clustering (used for RTAX only). [default: None]"));
		this.e_options.add(new Option("Second Read File", "--read_2_seqs_fp", Option.PATH, "Path to fasta file containing a second read from paired-end sequencing, prior to OTU clustering (used for RTAX only). [default: None]"));
		this.e_options.add(new Option("Allow Single?", "--single_ok", Option.NOARG, "When classifying paired ends, allow fallback to single-ended classification when the mate pair is lacking (used for RTAX only). [default: False]"));
		this.e_options.add(new Option("Disallow Fallback?", "--no_single_ok_generic", Option.NOARG, "When classifying paired ends, do not allow fallback to single-ended classification when the mate pair is overly generic (used for RTAX only). [default: False]"));
		this.e_options.add(new Option("Read ID Regex?", "--read_id_regex", Option.INPUT, "Used to parse the result of OTU clustering, to get the read_1_id for each clusterID. The clusterID itself is assumed to be the first field, and is not captured by the regex. (used for RTAX only). [default: S+s+(S+)]"));
		this.e_options.add(new Option("Amplicon ID Regex", "--amplicon_id_regex", Option.INPUT, "Used to parse the result of split_libraries, to get the ampliconID for each read_1_id. Two groups capture read_1_id and ampliconID, respectively. (used for RTAX only). [default: (S+)s+(S+?)/]"));
		this.e_options.add(new Option("Header ID Regex", "--header_id_regex", Option.INPUT, "Used to parse the result of split_libraries, to get the portion of the header that RTAX uses to match mate pairs. The default uses the amplicon ID, not including /1 or /3, as the primary key for the query sequences. Typically this regex will be the same as amplicon_id_regex, except that only the second group is captured. (used for RTAX only). [default: S+s+(S+?)/]"));
		List<String> selects = new ArrayList<String>(6);
		selects.add("rdp");
		selects.add("blast");
		selects.add("rtax");
		selects.add("mothur");
		selects.add("uclust");
		selects.add("sortmerna");
		this.e_options.add(new Option("Assignment Method", "-m", Option.SELECT, selects, 4, "Taxon assignment method, must be one of rdp, blast, rtax, mothur, uclust, sortmerna [default: uclust]"));
		this.e_options.add(new Option("Sortmerna Database", "--sortmerna_db", Option.INPUT, "Pre-existing database to search against when using sortmerna [default: None]"));
		this.e_options.add(new Option("E-Value", "--sortmerna_e_value", Option.NUM, "Maximum E-value when clustering [default = 1.0]"));
		this.e_options.add(new Option("Query Coverage", "--sortmerna_coverage", Option.NUM, "Mininum percent query coverage (of an alignment) to consider a hit, expressed as a fraction between 0 and 1 [default: 0.9]"));
		this.e_options.add(new Option("Best Alignments", "--sortmerna_best_N_alignments", Option.NUM, "This option specifies how many best alignments per read will be written [default: 5]"));
		this.e_options.add(new Option("Threads", "--sortmerna_threads", Option.NUM, "Specify number of threads to be used for sortmerna mapper which utilizes multithreading. [default: 1]"));
		this.e_options.add(new Option("Blast Database", "-b", Option.INPUT, "Database to blast against. Must provide either –blast_db or –reference_seqs_db for assignment with blast [default: None]"));
		this.e_options.add(new Option("Confidence", "-c", Option.NUM, "Minimum confidence to record an assignment, only used for rdp and mothur methods [default: 0.5]"));
		this.e_options.add(new Option("Min Consensus", "--min_consensus_fraction", Option.NUM, "Minimum fraction of database hits that must have a specific taxonomic assignment to assign that taxonomy to a query, only used for sortmerna and uclust methods [default: 0.51]"));
		this.e_options.add(new Option("Similarity", "--similarity", Option.NUM, "Minimum percent similarity (expressed as a fraction between 0 and 1) to consider a database match a hit, only used for sortmerna and uclust methods [default: 0.9]"));
		this.e_options.add(new Option("Max Accepts", "--uclust_max_accepts", Option.NUM, "Number of database hits to consider when making an assignment, only used for uclust method [default: 3]"));
		this.e_options.add(new Option("Max Memory", "--rdp_max_memory", Option.NUM, "Maximum memory allocation, in MB, for Java virtual machine when using the rdp method. Increase for large training sets [default: 4000]"));
		this.e_options.add(new Option("Max E-Value", "-e", Option.NUM, "Maximum e-value to record an assignment, only used for blast method [default: 0.001]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to store result file [default: <ASSIGNMENT_METHOD>_assigned_taxonomy]"));
	
	}
}