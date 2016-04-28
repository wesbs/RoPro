package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class PickOTUs extends Script {
	public static String title = "Pick OTUs";
	public static String b_desc = "OTU picking";

	public PickOTUs() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/pick_otus.html";
		this.c_name = SCRIPTS_PATH + "pick_otus.py";
		this.l_desc = "The OTU picking step assigns similar sequences to operational taxonomic units, or OTUs, by clustering sequences based on a user-defined similarity threshold. Sequences which are similar at or above the threshold level are taken to represent the presence of a taxonomic unit (e.g., a genus, when the similarity threshold is set at 0.94) in the sequence collection.<br><br>Currently, the following clustering methods have been implemented in QIIME:<br><br>1. cd-hit (Li & Godzik, 2006; Li, Jaroszewski, & Godzik, 2001), which applies a “longest-sequence-first list removal algorithm” to cluster sequences.<br>2. blast (Altschul, Gish, Miller, Myers, & Lipman, 1990), which compares and clusters each sequence against a reference database of sequences.<br>3. Mothur (Schloss et al., 2009), which requires an input file of aligned sequences. The input file of aligned sequences may be generated from an input file like the one described below by running align_seqs.py. For the Mothur method, the clustering algorithm may be specified as nearest-neighbor, furthest-neighbor, or average-neighbor. The default algorithm is furthest-neighbor.<br>4. prefix/suffix [Qiime team, unpublished], which will collapse sequences which are identical in their first and/or last bases (i.e., their prefix and/or suffix). The prefix and suffix lengths are provided by the user and default to 50 each.<br>5. Trie [Qiime team, unpublished], which collapsing identical sequences and sequences which are subsequences of other sequences.<br>6. uclust (Edgar, RC 2010), creates “seeds” of sequences which generate clusters based on percent identity.<br>7. uclust_ref (Edgar, RC 2010), as uclust, but takes a reference database to use as seeds. New clusters can be toggled on or off.<br>8. usearch (Edgar, RC 2010, version v5.2.236), creates “seeds” of sequences which generate clusters based on percent identity, filters low abundance clusters, performs de novo and reference based chimera detection.<br>9. usearch_ref (Edgar, RC 2010, version v5.2.236), as usearch, but takes a reference database to use as seeds. New clusters can be toggled on or off.<br>Quality filtering pipeline with usearch 5.X is described as usearch_qf “usearch quality filter”, described here: http://qiime.org/tutorials/usearch_quality_filter.html<br><br>8. usearch61 (Edgar, RC 2010, version v6.1.544), creates “seeds” of sequences which generate clusters based on percent identity.<br>9. usearch61_ref (Edgar, RC 2010, version v6.1.544), as usearch61, but takes a reference database to use as seeds. New clusters can be toggled on or off.<br>10. sumaclust (Mercier, C. et al., 2014, version 1.0), creates “seeds” of sequences which generate clusters based on similarity threshold.<br>11. sortmerna_v2 (Kopylova, E. et al., 2012), takes a reference database to use as seeds.<br>12. swarm (Mahe, F. et al., 2014), creates “seeds” of sequences which generate clusters based on a resolution threshold.<br>Chimera checking with usearch 6.X is implemented in identify_chimeric_seqs.py. Chimera checking should be done first with usearch 6.X, and the filtered resulting fasta file can then be clustered.<br><br>The primary inputs for pick_otus.py are:<br><br>1. A FASTA file containing sequences to be clustered<br>2. An OTU threshold (default is 0.97, roughly corresponding to species-level OTUs);<br>3. The method to be applied for clustering sequences into OTUs.<br>pick_otus.py takes a standard fasta file as input.";
		this.output_desc = "The output consists of two files (i.e. seqs_otus.txt and seqs_otus.log). The .txt file is composed of tab-delimited lines, where the first field on each line corresponds to an (arbitrary) cluster identifier, and the remaining fields correspond to sequence identifiers assigned to that cluster. Sequence identifiers correspond to those provided in the input FASTA file. Usearch (i.e. usearch quality filter) can additionally have log files for each intermediate call to usearch.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(1);
		this.r_options.add(new Option("Sequence File", "-i", Option.PATH, "Path to input sequences file"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(56);
		List<String> selects = new ArrayList<String>();
		selects.add("sortmerna");
		selects.add("mothur");
		selects.add("trie");
		selects.add("uclust_ref");
		selects.add("usearch");
		selects.add("usearch_ref");
		selects.add("blast");
		selects.add("usearch61");
		selects.add("usearch61_ref");
		selects.add("sumaclust");
		selects.add("swarm");
		selects.add("prefix_suffix");
		selects.add("cdhit");
		selects.add("uclust");
		this.e_options.add(new Option("Picking Method", "-m", Option.SELECT, selects, 13, "Method for picking OTUs. Valid choices are: sortmerna, mothur, trie, uclust_ref, usearch, usearch_ref, blast, usearch61, usearch61_ref, sumaclust, swarm, prefix_suffix, cdhit, uclust. The mothur method requires an input file of aligned sequences. usearch will enable the usearch quality filtering pipeline. [default: uclust]"));
		selects = new ArrayList<String>();
		selects.add("furthest");
		selects.add("nearest");
		selects.add("average");
		this.e_options.add(new Option("Clustering Algorithm", "-c", Option.SELECT, selects, 0, "Clustering algorithm for mothur otu picking method. Valid choices are: furthest, nearest, average. [default: furthest]"));
		this.e_options.add(new Option("Max CDHit Mem", "-M", Option.NUM, "Maximum available memory to cd-hit-est (via the program’s -M option) for cdhit OTU picking method (units of Mbyte) [default: 400]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Path to store result file [default: ./<OTU_METHOD>_picked_otus/]"));
		this.e_options.add(new Option("Reference File", "-r", Option.PATH, "Path to reference sequences to search against when using -m blast, -m sortmerna, -m uclust_ref, -m usearch_ref, or -m usearch61_ref [default: /Users/caporaso/.virtualenvs/qiime/lib/python2.7/site-packages/qiime_default_reference/gg_13_8_otus/rep_set/97_otus.fasta]"));
		this.e_options.add(new Option("Blast Database", "-b", Option.PATH, "Pre-existing database to blast against when using -m blast [default: None]"));
		this.e_options.add(new Option("Max E-Value", "-e", Option.NUM, "Max E-value when clustering with BLAST [default: 1e-10]"));
		this.e_options.add(new Option("Sortmerna Database", "--sortmerna_db", Option.PATH, "Pre-existing database to search against when using -m sortmerna [default: None]"));
		this.e_options.add(new Option("Max Sortmerna E-Value", "--sortmerna_e_value", Option.NUM, "Maximum E-value when clustering [default = 1]"));
		this.e_options.add(new Option("Sortmerna Coverage", "--sortmerna_coverage", Option.NUM, "Mininum percent query coverage (of an alignment) to consider a hit, expressed as a fraction between 0 and 1 [default: 0.97]"));
		this.e_options.add(new Option("Sortmerna Tabular?", "--sortmerna_tabular", Option.NOARG, "Output alignments in the Blast tabular format with two additional columns including the CIGAR string and the percent query coverage [default: False]"));
		this.e_options.add(new Option("Alignments Per Read", "--sortmerna_best_N_alignments", Option.NUM, "Must be set together with –sortmerna_tabular. This option specifies how many alignments per read will be written [default: 1]"));
		this.e_options.add(new Option("Sortmerna MAx Positions", "--sortmerna_max_pos", Option.NUM, "The maximum number of positions per seed to store in the indexed database [default: 10000]"));
		this.e_options.add(new Option("Min Aligned Percent", "--min_aligned_percent", Option.NUM., "Minimum percent of query sequence that can be aligned to consider a hit, expressed as a fraction between 0 and 1 (BLAST OTU picker only) [default: 0.5]"));
		this.e_options.add(new Option("Similarity", "-s", Option.NUM, "Sequence similarity threshold (for blast, cdhit, uclust, uclust_ref, usearch, usearch_ref, usearch61, usearch61_ref, sumaclust, and sortmerna) [default: 0.97]"));
		this.e_options.add(new Option("Sumaclust Exact?", "--sumaclust_exact", Option.NOARG, "A sequence is assigned to the best matching seed rather than the first matching seed passing the similarity threshold [default: False]"));
		this.e_options.add(new Option("Reference Length?", "--sumaclust_l", Option.NOARG, true, "Reference sequence length if the shortest [default: True]"));
		this.e_options.add(new Option("De Nove Prefix", "--denovo_otu_id_prefix", Option.INPUT, "OTU identifier prefix (string) for the de novo OTU pickers (sumaclust, swarm and uclust) [default: denovo, OTU ids are ascendingintegers]"));
		this.e_options.add(new Option("Swarm Resolution", "--swarm_resolution", Option.NUM, "Maximum number of differences allowed between two amplicons, meaning that two amplicons will be grouped if they have integer (or less) differences (see Swarm manual at https://github.com/torognes/swarm for more details). [default: 1]"));
		this.e_options.add(new Option("Trie Reverse?", "-q", Option.NOARG, "Reverse seqs before picking OTUs with the Trie OTU picker for suffix (rather than prefix) collapsing [default: False]"));
		this.e_options.add(new Option("Prefilter Length", "-n", Option.NUM, "Prefilter data so seqs with identical first prefix_prefilter_length are automatically grouped into a single OTU. This is useful for large sequence collections where OTU picking doesn’t scale well [default: None; 100 is a good value]"));
		this.e_options.add(new Option("Trie Prefilter?", "-t", Option.NOARG, "Prefilter data so seqs which are identical prefixes of a longer seq are automatically grouped into a single OTU; useful for large sequence collections where OTU picking doesn’t scale well [default: False]"));
		this.e_options.add(new Option("Prefix Length", "-p", Option.NUM, "Prefix length when using the prefix_suffix otu picker; WARNING: CURRENTLY DIFFERENT FROM prefix_prefilter_length (-n)! [default: 50]"));
		this.e_options.add(new Option("Suffix Length", "-u", Option.NUM, "Suffix length when using the prefix_suffix otu picker [default: 50]"));
		this.e_options.add(new Option("Reverse Strand Match?", "-z", Option.NOARG, "Enable reverse strand matching for uclust, uclust_ref, usearch, usearch_ref, usearch61, or usearch61_ref otu picking, will double the amount of memory used. [default: False]"));
		this.e_options.add(new Option("Suppress Presort?", "-D", Option.NOARG, "Suppress presorting of sequences by abundance when picking OTUs with uclust or uclust_ref [default: False]"));
		this.e_options.add(new Option("Optimal UClust?", "-A", Option.NOARG, "Pass the –optimal flag to uclust for uclust otu picking. [default: False]"));
		this.e_options.add(new Option("Exact UClust?", "-E", Option.NOARG, "Pass the –exact flag to uclust for uclust otu picking. [default: False]"));
		this.e_options.add(new Option("User Sort?", "-B", Option.NOARG, "Pass the –user_sort flag to uclust for uclust otu picking. [default: False]"));
		this.e_options.add(new Option("Suppress New Clusters?", "-C", Option.NOARG, "Suppress creation of new clusters using seqs that don’t match reference when using -m uclust_ref, -m usearch61_ref, or -m usearch_ref [default: False]"));
		this.e_options.add(new Option("Max Accepts", "--max_accepts", Option.NUM, "Max_accepts value to uclust and uclust_ref [default: 1]"));
		this.e_options.add(new Option("Max Rejects", "--max_rejects", Option.NUM, "Max_rejects value to uclust and uclust_ref [default: 8]"));
		this.e_options.add(new Option("Stepwords Value", "--stepwords", Option.NUM, "Stepwords value to uclust and uclust_ref [default: 8]"));
		this.e_options.add(new Option("Word Length", "--word_length", Option.NUM, "Word length value for uclust, uclust_ref, and usearch, usearch_ref, usearch61, and usearch61_ref. With default setting, will use the setting recommended by the method (uclust: 8, usearch: 64, usearch61: 8). int value can be supplied to override this setting. [default: default]"));
		this.e_options.add(new Option("Suppress UClust Stable Sort?", "--suppress_uclust_stable_sort", Option.NOARG, "Don’t pass –stable-sort to uclust [default: False]"));
		this.e_options.add(new Option("Suppress Prefilter Exact Match?", "--suppress_prefilter_exact_match", Option.NOARG, "Don’t collapse exact matches before calling sortmerna, sumaclust or uclust [default: False]"));
		this.e_options.add(new Option("Save UClust Files?", "-d", Option.NOARG, true, "Enable preservation of intermediate uclust (.uc) files that are used to generate clusters via uclust. Also enables preservation of all intermediate files created by usearch and usearch61. [default: True]"));
		this.e_options.add(new Option("Percent ID Error", "-j", Option.NUM, "Percent identity threshold for cluster error detection with usearch, expressed as a fraction between 0 and 1. [default: 0.97]"));
		this.e_options.add(new Option("Min Cluster Size", "-g", Option.NUM, "Minimum cluster size for size filtering with usearch. [default: 4]"));
		this.e_options.add(new Option("Abundance Skew", "-a", Option.NUM, "Abundance skew setting for de novo chimera detection with usearch. [default: 2.0]"));
		this.e_options.add(new Option("Reference Database", "-f", Option.PATH, "Reference database of fasta sequences for reference based chimera detection with usearch. [default: None]"));
		this.e_options.add(new Option("Percent ID Blast", "--perc_id_blast", Option.NUM, "Percent ID for mapping OTUs created by usearch back to original sequence IDs [default: 0.97]"));
		this.e_options.add(new Option("De Nove Chimera Detection?", "--de_novo_chimera_detection", Option.NOARG, "Deprecated: de novo chimera detection performed by default, pass –suppress_de_novo_chimera_detection to disable. [default: None]"));
		this.e_options.add(new Option("Suppress De Nove Chimera Detection?", "-k", Option.NOARG, "Suppress de novo chimera detection in usearch. [default: False]"));
		this.e_options.add(new Option("Reference Chimera Detection?", "--reference_chimera_detection", Option.NOARG, "Deprecated: Reference based chimera detection performed by default, pass –supress_reference_chimera_detection to disable [default: None]"));
		this.e_options.add(new Option("Suppress Reference Chimera Detection?", "-x", Option.NOARG, "Suppress reference based chimera detection in usearch. [default: False]"));
		this.e_options.add(new Option("Cluster Size Filtering?", "--cluster_size_filtering", Option.NOARG, "Deprecated, cluster size filtering enabled by default, pass –suppress_cluster_size_filtering to disable. [default: None]"));
		this.e_options.add(new Option("Suppress Cluster Size Filtering?", "-l", Option.NOARG, "Suppress cluster size filtering in usearch. [default: False]"));
		this.e_options.add(new Option("Remove USearch Logs?", "--remove_usearch_logs", Option.NOARG, "Disable creation of logs when usearch is called. Up to nine logs are created, depending on filtering steps enabled. [default: False]"));
		this.e_options.add(new Option("Dereplication of Full Sequence?", "--derep_fullseq", Option.NOARG, "Dereplication of full sequences, instead of subsequences. Faster than the default –derep_subseqs in usearch. [default: False]"));
		selects = new ArrayList<string>();
		selects.add("intersection");
		selects.add("union");
		this.e_options.add(new Option("Non Chimera Retention", "-F", Option.SELECT, selects, 1, "Selects subsets of sequences detected as non-chimeras to retain after de novo and reference based chimera detection. Options are intersection or union. union will retain sequences that are flagged as non-chimeric from either filter, while intersection will retain only those sequences that are flagged as non-chimeras from both detection methods. [default: union]"));
		this.e_options.add(new Option("Min Length", "--minlen", Option.NUM, "Minimum length of sequence allowed for usearch, usearch_ref, usearch61, and usearch61_ref. [default: 64]"));
		this.e_options.add(new Option("USearch Fast Cluster", "--usearch_fast_cluster", Option.NOARG, "Use fast clustering option for usearch or usearch61_ref with new clusters. –enable_rev_strand_match can not be enabled with this option, and the only valid option for usearch61_sort_method is ‘length’. This option uses more memory than the default option for de novo clustering. [default: False]"));
		selects = new ArrayList<String>();
		selects.add("abundance");
		selects.add("length");
		selects.add("None");
		this.e_options.add(new Option("USearch61 Sort Method", "--usearch61_sort_method", Option.SELECT, selects, 0, "Sorting method for usearch61 and usearch61_ref. Valid options are abundance, length, or None. If the –usearch_fast_cluster option is enabled, the only sorting method allowed in length. [default: abundance]"));
		this.e_options.add(new Option("Size Based Preference?", "--sizeorder", Option.NOARG, "Enable size based preference in clustering with usearch61. Requires that –usearch61_sort_method be abundance. [default: False]"));
		this.e_options.add(new Option("Num of Threads", "--threads", Option.NUM, "Specify number of threads (1 thread per core) to be used for usearch61, sortmerna, sumaclust and swarm commands that utilize multithreading. [default: 1]"));	
	}
}

// package scripts;

// import java.io.*;
// import java.lang.String;
// import java.util.*;

// public class BlastWrapper extends Script {
// 	public static String title = 
// 	public static String b_desc = 

// 	public BlastWrapper() {
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