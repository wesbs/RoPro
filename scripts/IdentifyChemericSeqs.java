package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class IdentifyChemericSeqs extends Script {
	public static String title = "Identify Chemeric Sequences";
	public static String b_desc = "Identify chimeric sequences in input FASTA file";

	public IdentifyChemericSeqs() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/identify_chimeric_seqs.html";
		this.c_name = SCRIPTS_PATH + "identify_chimeric_seqs.py";
		this.l_desc = "A FASTA file of sequences, can be screened to remove chimeras (sequences generated due to the PCR amplification of multiple templates or parent sequences). QIIME currently includes a taxonomy-assignment-based approach, blast_fragments, for identifying sequences as chimeric and the ChimeraSlayer algorithm.<br><br>1. Blast_fragments approach:<br>The reference sequences (-r) and id-to-taxonomy map (-t) provided are the same format as those provided to assign_taxonomy.py. The reference sequences are in fasta format, and the id-to-taxonomy map contains tab-separated lines where the first field is a sequence identifier, and the second field is the taxonomy separated by semi-colons (e.g., Archaea;Euryarchaeota;Methanobacteriales;Methanobacterium). The reference collection should be derived from a chimera-checked database (such as the full greengenes database), and filtered to contain only sequences at, for example, a maximum of 97% sequence identity.<br><br>2. ChimeraSlayer:<br>ChimeraSlayer uses BLAST to identify potential chimera parents and computes the optimal branching alignment of the query against two parents. We suggest to use the pynast aligned representative sequences as input.<br><br>3. usearch61:<br>usearch61 performs both de novo (abundance based) chimera and reference based detection. Unlike the other two chimera checking software, unclustered sequences should be used as input rather than a representative sequence set, as these sequences need to be clustered to get abundance data. The results can be taken as the union or intersection of all input sequences not flagged as chimeras. For details, see: http://drive5.com/usearch/usearch_docs.html";
		this.output_desc = "The result of identify_chimeric_seqs.py is a text file that identifies which sequences are chimeric.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("FASTA File", "-i", Option.PATH, "Path to the input fasta file"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(28);
		this.e_options.add(new Option("Taxonomy File", "-t", Option.PATH, "Path to tab-delimited file mapping sequences to assigned taxonomy. Each assigned taxonomy is provided as a comma-separated list. [default: None; REQUIRED when method is blast_fragments]"));
		this.e_options.add(new Option("Referreced Sequences", "-r", Option.PATH, "Path to reference sequences (used to build a blast db when method blast_fragments or reference database for usearch61). [default: None; REQUIRED when method blast_fragments if no blast_db is provided, suppress requirement for usearch61 with –suppress_usearch61_ref;]"));
		this.e_options.add(new Option("Aligned Sequences", "-a", Option.PATH, "Path to (Py)Nast aligned reference sequences. REQUIRED when method ChimeraSlayer [default: None]"));
		this.e_options.add(new Option("Blast Database", "-b", Option.PATH, "Database to blast against. Must provide either –blast_db or –reference_seqs_fp when method is blast_fragments [default: None]"));
		List<String> selects = new ArrayList<String>();
		selects.add("blast_fragments");
		selects.add("ChimeraSlayer");
		selects.add("usearch61");
		this.e_options.add(new Option("Detection Method", "-m", Option.SELECT, selects, 1, "Chimera detection method. Choices: blast_fragments or ChimeraSlayer or usearch61. [default:ChimeraSlayer]"));
		this.e_options.add(new Option("Fragments", "-n", Option.NUM, "Number of fragments to split sequences into (i.e., number of expected breakpoints + 1) [default: 3]"));
		this.e_options.add(new Option("Depth", "-d", Option.NUM, "Number of taxonomic divisions to consider when comparing taxonomy assignments [default: 4]"));
		this.e_options.add(new Option("Max E-Value", "-e", Option.INPUT, "Max e-value to assign taxonomy [default: 1e-30]"));
		this.e_options.add(new Option("Min Divergence Ratio", "-M", Option.NUM, "Min divergence ratio (passed to ChimeraSlayer). If set to None uses ChimeraSlayer default value. [default: None]"));
		this.e_options.add(new Option("Keep Intermediates?", "-k", Option.NOARG, "Keep intermediate files, useful for debugging [default: False]"));
		this.e_options.add(new Option("Suppress USearch61 Intermediates?", "--suppress_usearch61_intermediates", Option.NOARG, "Use to suppress retention of usearch intermediate files/logs.[default: False]"));
		this.e_options.add(new Option("Suppress USearch61 Reference?", "--suppress_usearch61_ref", Option.NOARG, "Use to suppress reference based chimera detection with usearch61 [default: False]"));
		this.e_options.add(new Option("Suppress USearch61 De Novo?", "--suppress_usearch61_denovo", Option.NOARG, "Use to suppress de novo based chimera detection with usearch61 [default: False]"));
		this.e_options.add(new Option("Split by Sample ID", "--split_by_sampleid", Option.NOARG, "Enable to split sequences by initial SampleID, requires that fasta be in demultiplexed format, e.g., >Sample.1_0, >Sample.2_1, >Sample.1_2, with the initial string before first underscore matching SampleIDs. If not in this format, could cause unexpected errors. [default: False]"));
		selects = new ArrayList<String>();
		selects.add("intersection");
		selects.add("union");
		this.e_options.add(new Option("Non-Chemeric Retention", "--non_chimeras_retention", Option.SELECT, selects, 1, "Usearch61 only - selects subsets of sequences detected as non-chimeras to retain after de novo and reference based chimera detection. Options are intersection or union. union will retain sequences that are flagged as non-chimeric from either filter, while intersection will retain only those sequences that are flagged as non-chimeras from both detection methods. [default: union]"));
		this.e_options.add(new Option("Min Score", "--usearch61_minh", Option.NUM, "Minimum score (h). Increasing this value tends to reduce the number of false positives and decrease sensitivity.[default: 0.28]"));
		this.e_options.add(new Option("USearch61 XN", "--usearch61_xn", Option.NUM, "Weight of ‘no’ vote. Increasing this value tends to the number of false positives (and also sensitivity). Must be > 1.[default: 8.0]"));
		this.e_options.add(new Option("USearch61 DN", "--usearch61_dn", Option.NUM, "Pseudo-count prior for ‘no’ votes. (n). Increasing this value tends to the number of false positives (and also sensitivity). Must be > 0.[default: 1.4]"));
		this.e_options.add(new Option("USearch61 Min Diffs", "--usearch61_mindiffs", Option.NUM, "Minimum number of diffs in a segment. Increasing this value tends to reduce the number of false positives while reducing sensitivity to very low-divergence chimeras. Must be > 0.[default: 3]"));
		this.e_options.add(new Option("USearch61 Min Divergence", "--usearch61_mindiv", Option.NUM, "Minimum divergence, i.e. 100% - identity between the query and closest reference database sequence. Expressed as a percentage, so the default is 0.8, which allows chimeras that are up to 99.2% similar to a reference sequence. This value is chosen to improve sensitivity to very low-divergence chimeras. Must be > 0.[default: 0.8]"));
		this.e_options.add(new Option("USearch61 Abundance Skew", "--usearch61_abundance_skew", Option.NUM, "Abundance skew setting for de novo chimera detection with usearch61. Must be > 0. [default: 2.0]"));
		this.e_options.add(new Option("USearch61 Identity Threshold", "--percent_id_usearch61", Option.NUM, "Percent identity threshold for clustering with usearch61, expressed as a fraction between 0 and 1. [default: 0.97]"));
		this.e_options.add(new Option("Min Length", "--minlen", Option.NUM, "Minimum length of sequence allowed for usearch61 [default: 64]"));
		this.e_options.add(new Option("Word Length", "--word_length", Option.NUM, "Word length value for usearch61. [default: 8]"));
		this.e_options.add(new Option("Max Accepts", "--max_accepts", Option.NUM, "Max_accepts value to usearch61. [default: 1]"));
		this.e_options.add(new Option("Max Rejects", "--max_rejects", Option.NUM, "Max_rejects value for usearch61. [default: 8]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to store output, output filepath in the case of blast_fragments and ChimeraSlayer, or directory in case of usearch61 [default: derived from input_seqs_fp]"));
		this.e_options.add(new Option("Threads", "--threads", Option.NUM, "Specify number of threads per core to be used for usearch61 commands that utilize multithreading. By default, will calculate the number of cores to utilize so a single thread will be used per CPU. Specify a fractional number, e.g. 1.0 for 1 thread per core, or 0.5 for a single thread on a two core CPU. Only applies to usearch61. [default: one_per_cpu]"));
	
	}
}