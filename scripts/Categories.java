package scripts;

import java.util.*;



public class Categories {
	// count of all scripts
	private static final int TOTAL_SCRIPTS = 151;

	// types of categories
	public static final int INPUT = 0;
	public static final int OUTPUT = 1;
	public static final int FUNCTION = 2;

	// list of all scripts
	public static final int ADD_ALPHA_TO_MAPPING = 1;
	public static final int ADD_QIIME_LABELS = 2;
	public static final int ADJUST_SEQ_ORIENT = 3;
	public static final int ALIGN_SEQS = 4;
	public static final int ALPHA_DIVERSITY = 5;
	public static final int ALPHA_RAREFACTION = 6;
	public static final int AMPLICONNOISE = 7;
	public static final int ASSIGN_TAX = 8;
	public static final int BETA_DIVERSITY = 9;
	public static final int BETA_DIVERSITY_PLOTS = 10;
	public static final int BETA_SIGNIFICANCE = 11;
	public static final int BLAST_WRAPPER = 12;
	public static final int CATEGORIZE_DIST_PLOT = 13;
	public static final int CLEAN_RAXML_TREE = 14;
	public static final int CLUSTER_QUALITY = 15;
	public static final int COLLAPSE_SAMPLES = 16;
	public static final int COLLATE_ALPHA = 17;
	public static final int COMPARE_ALPHA_DIVERSITY = 18;
	public static final int COMPARE_CATEGORIES = 19;
	public static final int COMPARE_DIST_MATRICIES = 20;
	public static final int COMPARE_TAXA_SUMMARIES = 21;
	public static final int COMPARE_TRAJECTORIES = 22;
	public static final int COMPUTE_CORE_MICROBIOME = 23;
	public static final int COMPUTE_TAX_RATIOS = 24;
	public static final int COND_UNCOVERED_PROB = 25;
	public static final int CONSENSUS_TREE = 26;
	public static final int CONVERT_FASTA = 27;
	public static final int CORE_DIVERSITY_ANALYSIS = 28;
	public static final int COUNT_SEQS = 29;
	public static final int CYTOSCAPE_USAGE = 30;
	public static final int DEMULTIPLEX_FASTA = 31;
	public static final int DENOISE_WRAPPER = 32;
	public static final int DENOISER = 33;
	public static final int DENOISER_PREPROCESS = 34;
	public static final int DENOISE_WORKER = 35;
	public static final int DETREND = 36;
	public static final int DIFF_ABUNDANCE = 37;
	public static final int DISS_MATRIX_STATS = 38;
	public static final int DIST_MATRIX_FROM_MAP = 39;
	public static final int ESTIMATE_OBS_RICHNESS = 40;
	public static final int EXCLUDE_SEQ_BY_BLAST = 41;
	public static final int EXTRACT_BARCODES = 42;
	public static final int EXTRACT_READS_INTERLEAVED = 43;
	public static final int EXTRACT_SEQ_SAMPLE = 44;
	public static final int FILTER_ALIGN = 45;
	public static final int FILTER_DIST_MATRIX = 46;
	public static final int FILTER_FASTA = 47;
	public static final int FILTER_OTUS_SAMPLE = 48;
	public static final int FILTER_OTUS_OTU_TABLE = 49;
	public static final int FILTER_SAMPLES_OTU_TABLE = 50;

	public static final int FILTER_TAXA_OTU_TABLE = 51;
	public static final int FILTER_TREE = 52;
	public static final int FIX_ARB_FASTA = 53;
	public static final int GROUP_SIG = 54;
	public static final int IDENTIFY_CHEM_SEQS = 55;
	public static final int IDENTIFY_MISSING_FILES = 56;
	public static final int IDENTIFY_PAIRED_DIFF = 57;
	public static final int INFLATE_DENOISER_OUTPUT = 58;
	public static final int JACKKNIFED_BETA_DIVERSITY = 59;
	public static final int JOINED_PAIRED_ENDS = 60;
	public static final int LOAD_REMOTE_MAP_FILE = 61;
	public static final int MAKE_2D_PLOTS = 62;
	public static final int MAKE_BIPARTITE_NET = 63;
	public static final int MAKE_BOOTSTRAPPED_TREE = 64;
	public static final int MAKE_DIST_BOXPLOTS = 65;
	public static final int MAKE_DIST_COMP_PLOTS = 66;
	public static final int MAKE_FASTQ = 67;
	public static final int MAKE_LIBRARY_ID_LIST = 68;
	public static final int MAKE_OTU_HEATMAP = 69;
	public static final int MAKE_OTU_NET = 70;
	public static final int MAKE_OTU_TABLE = 71;
	public static final int MAKE_PER_LIBRARY_SFF = 72;
	public static final int MAKE_PHYLOGENY = 73;
	public static final int MAKE_PREF_FILE = 74;
	public static final int MAKE_QIIME_PYTHON_FILE = 75;
	public static final int MAKE_RAREFACTION_PLOTS = 76;
	public static final int MAKE_TEP = 77;
	public static final int MAP_READS_TO_REF = 78;
	public static final int MERGE_MAP_FILES = 79;
	public static final int MERGE_OTU_MAPS = 80;
	public static final int MERGE_OTU_TABLES = 81;
	public static final int MULTIPLE_EXTRACT_BARCODES = 82;
	public static final int MULTIPLE_JOIN_PAIRED_ENDS = 83;
	public static final int MULTIPLE_RAREFACTIONS = 84;
	public static final int MULTIPLE_RAREFACTION_DEPTH = 85;
	public static final int MULTIPLE_SPLIT_LIB_FASTQ = 86;
	public static final int NEIGHBOR_JOINING = 87;
	public static final int NMDS = 88;
	public static final int NORMALIZE_TABLE = 89;
	public static final int OBSERVATION_METADATA_CORR = 90;
	public static final int PARALLEL_ALIGN_SEQS_PYNAST = 91;
	public static final int PARALLEL_ALPHA_DIVERSITY = 92;
	public static final int PARALLEL_ASSIGN_TAX_BLAST = 93;
	public static final int PARALLEL_ASSIGN_TAX_RDP = 94;
	public static final int PARALLEL_ASSIGN_TAX_UCLUST = 95;
	public static final int PARALLEL_BETA_DIVERSITY = 96;
	public static final int PARALLEL_BLAST = 97;
	public static final int PARALLEL_IDENTIFY_CHEM_SEQS = 98;
	public static final int PARALLEL_MAP_READS_REF = 99;
	public static final int PARALLEL_MERGE_OTU_TABLES = 100;

	public static final int PARALLEL_MULTIPLE_RAREFACTIONS = 101;
	public static final int PARALLEL_PICK_OTUS_BLAST = 102;
	public static final int PARALLEL_PICK_OTUS_SORTMERNA = 103;
	public static final int PARALLEL_PICK_OTUS_TRIE = 104;
	public static final int PARALLEL_PICK_OTUS_UCLUST_REF = 105;
	public static final int PARALLEL_PICK_OTUS_USEARCH_REF = 106;
	public static final int PICK_CLOSED_REF_OTUS = 107;
	public static final int PICK_DE_NOVO_OTUS = 108;
	public static final int PICK_OPEN_REF_OTUS = 109;
	public static final int PICK_OTUS = 110;
	public static final int PICK_REP_SET = 111;
	public static final int PLOT_RANK_ABUND_GRAPH = 112;
	public static final int PLOT_SEMIVARIOGRAM = 113;
	public static final int PLOT_TAXA_SUMMARY = 114;
	public static final int POLLER = 115;
	public static final int PRINCIPAL_COORDINATES = 116;
	public static final int PRINT_METADATA_STATS = 117;
	public static final int PRINT_QIIME_CONFIG = 118;
	public static final int PROCESS_ISEQ = 119;
	public static final int PROCESS_QSEQ = 120;
	public static final int PROCESS_SFF = 121;
	public static final int QUALITY_SCORES_PLOT = 122;
	public static final int RELATEDNESS = 123;
	public static final int SHARED_PHYLOTYPES = 124;
	public static final int SIMSAM = 125;
	public static final int SINGLE_RAREFACTIONS = 126;
	public static final int SORT_OTU_TABLE = 127;
	public static final int SPLIT_LIBRARIES = 128;
	public static final int SPLIT_LIBRARIES_FASTQ = 129;
	public static final int SPLIT_LIBRARIES_LEA_SEQ = 130;
	public static final int SPLIT_OTU_TABLE = 131;
	public static final int SPLIT_OTU_TABLE_TAX = 132;
	public static final int SPLIT_SEQ_SAMPLE = 133;
	public static final int START_PARALLEL_JOBS = 134;
	public static final int START_PARALLEL_JOBS_SC = 135;
	public static final int START_PARALLEL_JOBS_SLURM = 136;
	public static final int START_PARALLEL_JOBS_TORQUE = 137;
	public static final int SUBSAMPLE_FASTA = 138;
	public static final int SUMMARIZE_TAXA = 139;
	public static final int SUMMARIZE_TAXA_PLOTS = 140;
	public static final int SUPERVISED_LEARNING = 141;
	public static final int TRANSFORM_COORDINATE_MATRICIES = 142;
	public static final int TREE_COMPARE = 143;
	public static final int TRFLP_TO_OTU = 144;
	public static final int TRIM_SFF_PRIMERS = 145;
	public static final int TRUNC_FASTA_QUAL = 146;
	public static final int TRUNC_REVERSE_PRIMER = 147;
	public static final int UNWEIGHT_FASTA = 148;
	public static final int UPGMA_CLUSTER = 149;
	public static final int VALIDATE_DEMULTIPLEX_FASTA = 150;
	public static final int VALIDATE_MAP_FILE = 151;


	/*
			Category Names for button on category selection screen
	*/

	// File input Categories
	public static final String[] INPUT_CAT_NAMES = {
		"FASTA File",
		"OTU Table",
		"Mapping File",
		"Distance Matrix",
		"BIOM File",
		"Tree File",
		"SFF File",
		"FASTQ File",
		"Other",
	};

	// File Output Categories
	public static final String[] OUTPUT_CAT_NAMES = {
		"FASTA File",
		"OTU Table",
		"Mapping File",
		"Distance Matrix",
		"BIOM File",
		"Tree File",
		"Stats File",
		"Plots",
		"Other",
	};

	// Script Function Categories
	public static final String[] FUNC_CAT_NAMES = {
		"Filter Files",
		"Run Parallel Scripts",
		"Rarefactions",
		"Pick OTUs",
		"Demultiplexing",
		"Assign Taxonomy",
		"Alpha/Beta Diversity",
		"Create Plots",
		"Other",
	};

	public static final int[] TEST_CAT = {
		ADD_ALPHA_TO_MAPPING,
		ADD_QIIME_LABELS,
		ADJUST_SEQ_ORIENT,
		ALIGN_SEQS,
		ALPHA_DIVERSITY,
		ALPHA_RAREFACTION,
		AMPLICONNOISE,
		ASSIGN_TAX,
		BETA_DIVERSITY,
		BETA_DIVERSITY_PLOTS,
		BETA_SIGNIFICANCE,
		BLAST_WRAPPER,
		CATEGORIZE_DIST_PLOT
	};

	/*
	*	INPUT FILE CATEGORIES
	*/

	// FASTA FILE
	public static final int[] FASTA_INPUT = {
		ADD_QIIME_LABELS,
		ADJUST_SEQ_ORIENT,
		ALIGN_SEQS,
		ASSIGN_TAX,
		BLAST_WRAPPER,
		CONVERT_FASTA,
		COUNT_SEQS,
		DEMULTIPLEX_FASTA,
		DENOISE_WRAPPER,
		DENOISER_PREPROCESS,
		EXCLUDE_SEQ_BY_BLAST,
		EXTRACT_SEQ_SAMPLE,
		FILTER_ALIGN,
		FILTER_FASTA,
		FILTER_OTUS_SAMPLE,
		FIX_ARB_FASTA,
		IDENTIFY_CHEM_SEQS,
		INFLATE_DENOISER_OUTPUT,
		MAKE_FASTQ,
		MAKE_LIBRARY_ID_LIST,
		MAKE_PHYLOGENY,
		PARALLEL_ALIGN_SEQS_PYNAST,
		PARALLEL_ASSIGN_TAX_BLAST,
		PARALLEL_ASSIGN_TAX_RDP,
		PARALLEL_ASSIGN_TAX_UCLUST,
		PARALLEL_BLAST,
		PARALLEL_IDENTIFY_CHEM_SEQS,
		PARALLEL_PICK_OTUS_BLAST,
		PARALLEL_PICK_OTUS_SORTMERNA,
		PARALLEL_PICK_OTUS_TRIE,
		PARALLEL_PICK_OTUS_UCLUST_REF,
		PARALLEL_PICK_OTUS_USEARCH_REF,
		PICK_DE_NOVO_OTUS,
		PICK_OTUS,
		PICK_REP_SET,
		SPLIT_SEQ_SAMPLE,
		SUBSAMPLE_FASTA,
		TRUNC_FASTA_QUAL,
		TRUNC_REVERSE_PRIMER,
		UNWEIGHT_FASTA,
		VALIDATE_DEMULTIPLEX_FASTA
	};

	// OTU Table FILe
	public static final int[] OTU_TABLE_INPUT = {
		ALPHA_DIVERSITY,
		ALPHA_RAREFACTION,
		BETA_DIVERSITY,
		BETA_SIGNIFICANCE,
		COLLATE_ALPHA,
		COMPUTE_CORE_MICROBIOME,
		COND_UNCOVERED_PROB,
		FILTER_DIST_MATRIX,
		FILTER_OTUS_OTU_TABLE,
		FILTER_SAMPLES_OTU_TABLE,
		FILTER_TAXA_OTU_TABLE,
		GROUP_SIG,
		JACKKNIFED_BETA_DIVERSITY,
		MAKE_LIBRARY_ID_LIST,
		MAKE_OTU_HEATMAP,
		MAKE_OTU_NET,
		MAKE_OTU_TABLE,
		MAKE_TEP,
		MERGE_OTU_TABLES,
		MULTIPLE_RAREFACTIONS,
		MULTIPLE_RAREFACTION_DEPTH,
		PARALLEL_BETA_DIVERSITY,
		PARALLEL_MERGE_OTU_TABLES,
		PARALLEL_MULTIPLE_RAREFACTIONS,
		PLOT_RANK_ABUND_GRAPH,
		SHARED_PHYLOTYPES,
		SIMSAM,
		SINGLE_RAREFACTIONS,
		SORT_OTU_TABLE,
		SPLIT_OTU_TABLE,
		SPLIT_OTU_TABLE_TAX,
		SUMMARIZE_TAXA,
		SUMMARIZE_TAXA_PLOTS
	};

	// MAPPING FILE
	public static final int[] MAP_FILE_INPUT = {
		ADD_ALPHA_TO_MAPPING,
		ADD_QIIME_LABELS,
		ALPHA_RAREFACTION,
		AMPLICONNOISE,
		BETA_DIVERSITY_PLOTS,
		CATEGORIZE_DIST_PLOT,
		CLUSTER_QUALITY,
		COLLAPSE_SAMPLES,
		COMPARE_ALPHA_DIVERSITY,
		COMPARE_CATEGORIES,
		COMPARE_TRAJECTORIES,
		CORE_DIVERSITY_ANALYSIS,
		DEMULTIPLEX_FASTA,
		DIFF_ABUNDANCE,
		DIST_MATRIX_FROM_MAP,
		EXTRACT_BARCODES,
		EXTRACT_SEQ_SAMPLE,
		FILTER_DIST_MATRIX,
		FILTER_FASTA,
		FILTER_OTUS_SAMPLE,
		GROUP_SIG,
		IDENTIFY_PAIRED_DIFF,
		JACKKNIFED_BETA_DIVERSITY,
		MAKE_2D_PLOTS,
		MAKE_BIPARTITE_NET,
		MAKE_DIST_BOXPLOTS,
		MAKE_DIST_COMP_PLOTS,
		MAKE_OTU_HEATMAP,
		MAKE_OTU_NET,
		MAKE_PREF_FILE,
		MAKE_TEP,
		MERGE_MAP_FILES,
		MERGE_OTU_TABLES,
		OBSERVATION_METADATA_CORR,
		PARALLEL_ASSIGN_TAX_RDP,
		PARALLEL_ASSIGN_TAX_UCLUST,
		PRINT_METADATA_STATS,
		SPLIT_LIBRARIES,
		SPLIT_LIBRARIES_FASTQ,
		SPLIT_LIBRARIES_LEA_SEQ,
		SPLIT_OTU_TABLE,
		SUMMARIZE_TAXA,
		SUMMARIZE_TAXA_PLOTS,
		SUPERVISED_LEARNING,
		TRIM_SFF_PRIMERS,
		TRUNC_REVERSE_PRIMER,
		VALIDATE_DEMULTIPLEX_FASTA,
		VALIDATE_MAP_FILE
	};

	public static final int[] DIST_MATRIX_INPUT = {
		CATEGORIZE_DIST_PLOT,
		CLUSTER_QUALITY,
		COMPARE_CATEGORIES,
		COMPARE_DIST_MATRICIES,
		FILTER_DIST_MATRIX,
		MAKE_DIST_BOXPLOTS,
		MAKE_DIST_COMP_PLOTS,
		NEIGHBOR_JOINING,
		NMDS,
		PLOT_SEMIVARIOGRAM,
		PRINCIPAL_COORDINATES
	};

	// FASTQ FILE
	public static final int[] FASTQ_FILE_INPUT = {
		CONVERT_FASTA,
		EXTRACT_BARCODES,
		EXTRACT_READS_INTERLEAVED,
		JOINED_PAIRED_ENDS,
		MAKE_FASTQ,
		MULTIPLE_EXTRACT_BARCODES,
		MULTIPLE_JOIN_PAIRED_ENDS,
		MULTIPLE_SPLIT_LIB_FASTQ,
		SPLIT_LIBRARIES,
		SPLIT_LIBRARIES_FASTQ,
		SPLIT_LIBRARIES_LEA_SEQ
	};

	// BIOM FILE
	public static final int[] BIOM_FILE_INPUT = {
		CATEGORIZE_DIST_PLOT,
		CLUSTER_QUALITY,
		COMPARE_CATEGORIES,
		COMPARE_DIST_MATRICIES,
		FILTER_DIST_MATRIX,
		MAKE_DIST_BOXPLOTS,
		MAKE_DIST_COMP_PLOTS,
		NEIGHBOR_JOINING,
		NMDS,
		PLOT_SEMIVARIOGRAM,
		PRINCIPAL_COORDINATES
	};

	// TREE FILE
	public static final int[] TREE_FILE_INPUT = {
		BETA_SIGNIFICANCE,
		CLEAN_RAXML_TREE,
		CONSENSUS_TREE,
		FILTER_TREE,
		JACKKNIFED_BETA_DIVERSITY,
		MAKE_BOOTSTRAPPED_TREE,
		MAKE_OTU_HEATMAP,
		MAKE_TEP,
		PARALLEL_BETA_DIVERSITY,
		RELATEDNESS,
		SIMSAM,
		VALIDATE_DEMULTIPLEX_FASTA,
		TREE_COMPARE
	};

	// SFF FILE
	public static final int[] SFF_FILE_INPUT = {
		AMPLICONNOISE,
		DENOISE_WRAPPER,
		DENOISER,
		DENOISER_PREPROCESS,
		MAKE_PER_LIBRARY_SFF,
		PROCESS_SFF,
		TRIM_SFF_PRIMERS
	};


	/*
			OUTPUT FILE CATEGORIES
	*/

	// FASTA FILE
	public static final int[] FASTA_FILE_OUTPUT = {
		ADD_QIIME_LABELS,
		ADJUST_SEQ_ORIENT,
		ALIGN_SEQS,
		AMPLICONNOISE,
		CONVERT_FASTA,
		DEMULTIPLEX_FASTA,
		DENOISE_WRAPPER,
		DENOISER,
		DENOISER_PREPROCESS,
		EXCLUDE_SEQ_BY_BLAST,
		EXTRACT_SEQ_SAMPLE,
		FILTER_ALIGN,
		FILTER_OTUS_SAMPLE,
		IDENTIFY_CHEM_SEQS,
		INFLATE_DENOISER_OUTPUT,
		PARALLEL_ALIGN_SEQS_PYNAST,
		PICK_DE_NOVO_OTUS,
		PICK_REP_SET,
		PROCESS_SFF,
		SPLIT_LIBRARIES_LEA_SEQ,
		SPLIT_SEQ_SAMPLE,
		SUBSAMPLE_FASTA,
		TRUNC_FASTA_QUAL,
		TRUNC_REVERSE_PRIMER,
		UNWEIGHT_FASTA
	};

	// OTU TABLE FILE
	public static final int[] OTU_TABLE_OUTPUT = {
		COLLATE_ALPHA,
		DIFF_ABUNDANCE,
		FILTER_OTUS_SAMPLE,
		FILTER_OTUS_OTU_TABLE,
		FILTER_SAMPLES_OTU_TABLE,
		FILTER_TAXA_OTU_TABLE,
		JACKKNIFED_BETA_DIVERSITY,
		MAKE_OTU_TABLE,
		MERGE_OTU_MAPS,
		MERGE_OTU_TABLES,
		PARALLEL_MERGE_OTU_TABLES,
		PARALLEL_MULTIPLE_RAREFACTIONS,
		PICK_CLOSED_REF_OTUS,
		PICK_DE_NOVO_OTUS,
		SHARED_PHYLOTYPES,
		SIMSAM,
		SINGLE_RAREFACTIONS,
		SORT_OTU_TABLE,
		SPLIT_OTU_TABLE,
		SPLIT_OTU_TABLE_TAX,
		TRFLP_TO_OTU
	};

	// PLOTS FILES
	public static final int[] 	PLOT_FILES_OUTPUT = {
		ALPHA_RAREFACTION,
		BETA_DIVERSITY_PLOTS,
		CATEGORIZE_DIST_PLOT,
		COMPARE_ALPHA_DIVERSITY,
		IDENTIFY_PAIRED_DIFF,
		MAKE_2D_PLOTS,
		MAKE_DIST_BOXPLOTS,
		MAKE_DIST_COMP_PLOTS,
		MAKE_RAREFACTION_PLOTS,
		PLOT_RANK_ABUND_GRAPH,
		PLOT_SEMIVARIOGRAM,
		PLOT_TAXA_SUMMARY,
		QUALITY_SCORES_PLOT,
		SUMMARIZE_TAXA_PLOTS
	};

	// BIOM FILE
	public static final int[] BIOM_FILE_OUTPUT = {
		COLLAPSE_SAMPLES,
		COMPUTE_CORE_MICROBIOME,
		FILTER_DIST_MATRIX,
		FILTER_SAMPLES_OTU_TABLE,
		MULTIPLE_RAREFACTIONS,
		MULTIPLE_RAREFACTION_DEPTH,
		NORMALIZE_TABLE		
	};

	// Distance Matrix File
	public static final int[] DIST_MATRIX_OUTPUT = {
		BETA_DIVERSITY,
		BETA_DIVERSITY_PLOTS,
		CATEGORIZE_DIST_PLOT,
		DIST_MATRIX_FROM_MAP,
		JACKKNIFED_BETA_DIVERSITY,
		PARALLEL_BETA_DIVERSITY
	};

	// Mapping File
	public static final int[] MAP_FILE_OUTPUT = {
		ADD_ALPHA_TO_MAPPING,
		ASSIGN_TAX,
		COLLAPSE_SAMPLES,
		COMPUTE_TAX_RATIOS,
		DENOISE_WRAPPER,
		DENOISER,
		DENOISER_PREPROCESS,
		FILTER_DIST_MATRIX,
		LOAD_REMOTE_MAP_FILE,
		MERGE_MAP_FILES,
		PARALLEL_ASSIGN_TAX_BLAST,
		PARALLEL_ASSIGN_TAX_RDP,
		PARALLEL_ASSIGN_TAX_UCLUST
	};

	// Stat Files
	public static final int[] STAT_FILE_OUTPUT = {
		COMPARE_ALPHA_DIVERSITY,
		COMPARE_CATEGORIES,
		COMPARE_DIST_MATRICIES,
		COMPARE_TAXA_SUMMARIES,
		COMPARE_TRAJECTORIES,
		COND_UNCOVERED_PROB,
		DEMULTIPLEX_FASTA,
		DISS_MATRIX_STATS,
		ESTIMATE_OBS_RICHNESS,
		GROUP_SIG,
		IDENTIFY_PAIRED_DIFF,
		OBSERVATION_METADATA_CORR
	};

	// Tree Files
	public static final int[] TREE_FILE_OUTPUT = {
		CLEAN_RAXML_TREE,
		CONSENSUS_TREE,
		FILTER_TREE,
		JACKKNIFED_BETA_DIVERSITY,
		MAKE_PHYLOGENY,
		NEIGHBOR_JOINING,
		TREE_COMPARE,
		UPGMA_CLUSTER
	};

	/*
			Script Function Categories
	*/

	// Filtering Files
	public static final int[] FILE_FILTERING_SCRIPTS = {
		FILTER_ALIGN,
		FILTER_DIST_MATRIX,
		FILTER_FASTA,
		FILTER_OTUS_SAMPLE,
		FILTER_OTUS_OTU_TABLE,
		FILTER_SAMPLES_OTU_TABLE,
		FILTER_TAXA_OTU_TABLE,
		FILTER_TREE
	};

	// Parallel Scripts
	public static final int[] PARALLEL_SCRIPTS = {
		PARALLEL_ALIGN_SEQS_PYNAST,
		PARALLEL_ALPHA_DIVERSITY,
		PARALLEL_ASSIGN_TAX_BLAST,
		PARALLEL_ASSIGN_TAX_RDP,
		PARALLEL_ASSIGN_TAX_UCLUST,
		PARALLEL_BETA_DIVERSITY,
		PARALLEL_BLAST,
		PARALLEL_IDENTIFY_CHEM_SEQS,
		PARALLEL_MAP_READS_REF,
		PARALLEL_MERGE_OTU_TABLES,
		PARALLEL_MULTIPLE_RAREFACTIONS,
		PARALLEL_PICK_OTUS_BLAST,
		PARALLEL_PICK_OTUS_SORTMERNA,
		PARALLEL_PICK_OTUS_TRIE,
		PARALLEL_PICK_OTUS_UCLUST_REF,
		PARALLEL_PICK_OTUS_USEARCH_REF,
		START_PARALLEL_JOBS,
		START_PARALLEL_JOBS_SC,
		START_PARALLEL_JOBS_SLURM,
		START_PARALLEL_JOBS_TORQUE
	};

	// rarefaction scripts
	public static final int[] RAREFACTION_SCRIPTS = {
		ALPHA_RAREFACTION,
		MAKE_LIBRARY_ID_LIST,
		MAKE_PER_LIBRARY_SFF,
		MAKE_RAREFACTION_PLOTS,
		MULTIPLE_RAREFACTIONS,
		MULTIPLE_RAREFACTION_DEPTH,
		MULTIPLE_SPLIT_LIB_FASTQ,
		PARALLEL_MULTIPLE_RAREFACTIONS,
		SINGLE_RAREFACTIONS,
		SPLIT_LIBRARIES,
		SPLIT_LIBRARIES_FASTQ,
		SPLIT_LIBRARIES_LEA_SEQ
	};

	// pick OTUs
	public static final int[] OTU_PICKING_SCRIPTS = {
		PARALLEL_PICK_OTUS_BLAST,
		PARALLEL_PICK_OTUS_SORTMERNA,
		PARALLEL_PICK_OTUS_TRIE,
		PARALLEL_PICK_OTUS_UCLUST_REF,
		PARALLEL_PICK_OTUS_USEARCH_REF,
		PICK_CLOSED_REF_OTUS,
		PICK_DE_NOVO_OTUS,
		PICK_OPEN_REF_OTUS,
		PICK_OTUS
	};

	// Demultiplexing Scripts
	public static final int[] DEMULTIPLEXING_SCRIPTS = {
		DEMULTIPLEX_FASTA,
		SPLIT_LIBRARIES,
		SPLIT_LIBRARIES_FASTQ,
		SPLIT_LIBRARIES_LEA_SEQ,
		TRUNC_REVERSE_PRIMER,
		VALIDATE_DEMULTIPLEX_FASTA
	};

	// Assign Taxonomy
	public static final int[] ASSIGN_TAX_SCRIPTS = {
		ASSIGN_TAX,
		COMPUTE_TAX_RATIOS,
		PARALLEL_ASSIGN_TAX_BLAST,
		PARALLEL_ASSIGN_TAX_RDP,
		PARALLEL_ASSIGN_TAX_UCLUST,
		PARALLEL_BLAST,
		PICK_DE_NOVO_OTUS,
		PLOT_TAXA_SUMMARY,
		SPLIT_OTU_TABLE_TAX,
		SUMMARIZE_TAXA,
		SUMMARIZE_TAXA_PLOTS
	};

	// alpha/beta diversity scripts
	public static final int[] ALPHA_BETA_DIV_SCRIPTS = {
		ADD_ALPHA_TO_MAPPING,
		ALPHA_DIVERSITY,
		BETA_DIVERSITY,
		BETA_DIVERSITY_PLOTS,
		COLLATE_ALPHA,
		CORE_DIVERSITY_ANALYSIS,
		PARALLEL_ALPHA_DIVERSITY,
		PARALLEL_BETA_DIVERSITY
	};

	// Plot creation scripts
	public static final int[] PLOT_CREATION_SCRIPTS = {
		ALPHA_RAREFACTION,
		BETA_DIVERSITY_PLOTS,
		CATEGORIZE_DIST_PLOT,
		IDENTIFY_PAIRED_DIFF,
		JACKKNIFED_BETA_DIVERSITY,
		MAKE_2D_PLOTS,
		MAKE_DIST_BOXPLOTS,
		MAKE_DIST_COMP_PLOTS,
		MAKE_OTU_HEATMAP,
		MAKE_RAREFACTION_PLOTS,
		PLOT_RANK_ABUND_GRAPH,
		PLOT_SEMIVARIOGRAM,
		SUMMARIZE_TAXA_PLOTS
	};

	// Workflow Scripts
	public static final int[] WORKFLOW_SCRIPTS = {
		ALPHA_RAREFACTION, 
		BETA_DIVERSITY_PLOTS, 
		CORE_DIVERSITY_ANALYSIS,
		JACKKNIFED_BETA_DIVERSITY, 
		PICK_DE_NOVO_OTUS
	};

	private static List<Integer> intArraytoList(int[] arr){
		List<Integer> ints = new ArrayList<Integer>(arr.length);
		for (int i = 0; i < arr.length; i++)
			ints.add(arr[i]);
		return ints;
	}

	private static int[] intListtoArray(List<Integer> intList){
		int[] arr = new int[intList.size()];
		for (int i = 0; i < intList.size(); i++){
			arr[i] = intList.get(i).intValue();
		}
		return arr;
	}

	private static int[] getOthers(int catType){
		List<Integer> include = new ArrayList<Integer>();
		List<Integer> others = new ArrayList<Integer>();
		switch(catType){
			case INPUT:
				include.addAll(intArraytoList(FASTA_INPUT));
				include.addAll(intArraytoList(OTU_TABLE_INPUT));
				include.addAll(intArraytoList(MAP_FILE_INPUT));
				include.addAll(intArraytoList(DIST_MATRIX_INPUT));
				include.addAll(intArraytoList(BIOM_FILE_INPUT));
				include.addAll(intArraytoList(TREE_FILE_INPUT));
				include.addAll(intArraytoList(SFF_FILE_INPUT));
				include.addAll(intArraytoList(FASTQ_FILE_INPUT));
				break;
			case OUTPUT:
				include.addAll(intArraytoList(FASTA_FILE_OUTPUT));
				include.addAll(intArraytoList(OTU_TABLE_OUTPUT));
				include.addAll(intArraytoList(MAP_FILE_OUTPUT));
				include.addAll(intArraytoList(DIST_MATRIX_OUTPUT));
				include.addAll(intArraytoList(BIOM_FILE_OUTPUT));
				include.addAll(intArraytoList(TREE_FILE_OUTPUT));
				include.addAll(intArraytoList(STAT_FILE_OUTPUT));
				include.addAll(intArraytoList(PLOT_FILES_OUTPUT));
				break;
			case FUNCTION:
				include.addAll(intArraytoList(FILE_FILTERING_SCRIPTS));
				include.addAll(intArraytoList(PARALLEL_SCRIPTS));
				include.addAll(intArraytoList(RAREFACTION_SCRIPTS));
				include.addAll(intArraytoList(OTU_PICKING_SCRIPTS));
				include.addAll(intArraytoList(DEMULTIPLEXING_SCRIPTS));
				include.addAll(intArraytoList(ASSIGN_TAX_SCRIPTS));
				include.addAll(intArraytoList(ALPHA_BETA_DIV_SCRIPTS));
				include.addAll(intArraytoList(PLOT_CREATION_SCRIPTS));
				break;
		}
		for (int i = 1; i < TOTAL_SCRIPTS + 1; i++){
			if (!include.contains(i+1)) // scripts start at value 1 (not 0)
				others.add(i);
		}
		return intListtoArray(others);
	}

	private static int[] getAllScripts(){
		int[] all = new int[TOTAL_SCRIPTS];
		for (int i = 0; i < all.length; i++)
			all[i] = i + 1; // scripts start at 1
		return all;
	}

	public static int[] getCategory(String catName){
		int[] ret = {0};
		if (catName.equals("Input FASTA File"))
			ret = FASTA_INPUT;
		else if (catName.equals("Input OTU Table"))
			ret = OTU_TABLE_INPUT;
		else if (catName.equals("Input Mapping File"))
			ret = MAP_FILE_INPUT;
		else if (catName.equals("Input Distance Matrix"))
			ret = DIST_MATRIX_INPUT;
		else if (catName.equals("Input BIOM File"))
			ret = BIOM_FILE_INPUT;
		else if (catName.equals("Input Tree File"))
			ret = TREE_FILE_INPUT;
		else if (catName.equals("Input SFF File"))
			ret = SFF_FILE_INPUT;
		else if (catName.equals("Input FASTQ File"))
			ret = FASTQ_FILE_INPUT;
		else if (catName.equals("Input Other"))
			ret = getOthers(INPUT);
		else if (catName.equals("Output FASTA File"))
			ret = FASTA_FILE_OUTPUT;
		else if (catName.equals("Output OTU Table"))
			ret = OTU_TABLE_OUTPUT;
		else if (catName.equals("Output Mapping File"))
			ret = MAP_FILE_OUTPUT;
		else if (catName.equals("Output Distance Matrix"))
			ret = DIST_MATRIX_OUTPUT;
		else if (catName.equals("Output BIOM File"))
			ret = BIOM_FILE_OUTPUT;
		else if (catName.equals("Output Tree File"))
			ret = TREE_FILE_OUTPUT;
		else if (catName.equals("Output Stats File"))
			ret = STAT_FILE_OUTPUT;
		else if (catName.equals("Output Plots"))
			ret = PLOT_FILES_OUTPUT;
		else if (catName.equals("Output Other"))
			ret = getOthers(OUTPUT);
		else if (catName.equals("Func Filter Files"))
			ret = FILE_FILTERING_SCRIPTS;
		else if (catName.equals("Func Run Parallel Scripts"))
			ret = PARALLEL_SCRIPTS;
		else if (catName.equals("Func Rarefactions"))
			ret = RAREFACTION_SCRIPTS;
		else if (catName.equals("Func Pick OTUs"))
			ret = OTU_PICKING_SCRIPTS;
		else if (catName.equals("Func Demultiplexing"))
			ret = DEMULTIPLEXING_SCRIPTS;
		else if (catName.equals("Func Assign Taxonomy"))
			ret = ASSIGN_TAX_SCRIPTS;
		else if (catName.equals("Func Alpha/Beta Diversity"))
			ret = ALPHA_BETA_DIV_SCRIPTS;
		else if (catName.equals("Func Create Plots"))
			ret = PLOT_CREATION_SCRIPTS;
		else if (catName.equals("Func Other"))
			ret = getOthers(FUNCTION);
		else if (catName.equals("Workflow"))
			ret = WORKFLOW_SCRIPTS;
		else if (catName.equals("All Scripts"))
			ret = getAllScripts();

		return ret;
		
	}

	public static String[] getData(int script){
		String[] ret = new String[2];
		switch (script){
			case ADD_ALPHA_TO_MAPPING:
				ret[0] = AddAlphaToMapping.title;
				ret[1] = AddAlphaToMapping.b_desc;
				break;
			case ADD_QIIME_LABELS:
				ret[0] = AddQiimeLabels.title;
				ret[1] = AddQiimeLabels.b_desc;
				break;
			case ADJUST_SEQ_ORIENT:
				ret[0] = AdjustSeqOrient.title;
				ret[1] = AdjustSeqOrient.b_desc;
				break;
			case ALIGN_SEQS:
				ret[0] = AlignSeqs.title;
				ret[1] = AlignSeqs.b_desc;
				break;
			case ALPHA_DIVERSITY:
				ret[0] = AlphaDiversity.title;
				ret[1] = AlphaDiversity.b_desc;
				break;
			case ALPHA_RAREFACTION:
				ret[0] = AlphaRarefaction.title;
				ret[1] = AlphaRarefaction.b_desc;
				break;
			case AMPLICONNOISE:
				ret[0] = Ampliconnoise.title;
				ret[1] = Ampliconnoise.b_desc;
				break;
			case ASSIGN_TAX:
				ret[0] = AssignTax.title;
				ret[1] = AssignTax.b_desc;
				break;
			case BETA_DIVERSITY:
				ret[0] = BetaDiversity.title;
				ret[1] = BetaDiversity.b_desc;
				break;
			case BETA_DIVERSITY_PLOTS:
				ret[0] = BetaDiversityPlots.title;
				ret[1] = BetaDiversityPlots.b_desc;
				break;
			case BETA_SIGNIFICANCE:
				ret[0] = BetaSignificance.title;
				ret[1] = BetaSignificance.b_desc;
				break;
			case BLAST_WRAPPER:
				ret[0] = BlastWrapper.title;
				ret[1] = BlastWrapper.b_desc;
				break;
			case CATEGORIZE_DIST_PLOT:
				ret[0] = CategorizeDistPlot.title;
				ret[1] = CategorizeDistPlot.b_desc;
				break;
			case CLEAN_RAXML_TREE:
				ret[0] = CleanRaxmlTree.title;
				ret[1] = CleanRaxmlTree.b_desc;
				break;
			case CLUSTER_QUALITY:
				ret[0] = ClusterQuality.title;
				ret[1] = ClusterQuality.b_desc;
				break;
			case COLLAPSE_SAMPLES:
				ret[0] = CollapseSamples.title;
				ret[1] = CollapseSamples.b_desc;
				break;
			case COLLATE_ALPHA:
				ret[0] = CollateAlpha.title;
				ret[1] = CollateAlpha.b_desc;
				break;
			case COMPARE_ALPHA_DIVERSITY:
				ret[0] = CompareAlphaDiversity.title;
				ret[1] = CompareAlphaDiversity.b_desc;
				break;
			case COMPARE_CATEGORIES:
				ret[0] = CompareCategories.title;
				ret[1] = CompareCategories.b_desc;
				break;
			case COMPARE_DIST_MATRICIES:
				ret[0] = CompareDistMatricies.title;
				ret[1] = CompareDistMatricies.b_desc;
				break;
			case COMPARE_TAXA_SUMMARIES:
				ret[0] = CompareTaxaSummary.title;
				ret[1] = CompareTaxaSummary.b_desc;
				break;
			case COMPARE_TRAJECTORIES:
				ret[0] = CompareTrajectories.title;
				ret[1] = CompareTrajectories.b_desc;
				break;
			case COMPUTE_CORE_MICROBIOME:
				ret[0] = ComputeCoreMicrobiome.title;
				ret[1] = ComputeCoreMicrobiome.b_desc;
				break;
			case COMPUTE_TAX_RATIOS:
				ret[0] = ComputeTaxRatios.title;
				ret[1] = ComputeTaxRatios.b_desc;
				break;
			case COND_UNCOVERED_PROB:
				ret[0] = CondUncoveredProb.title;
				ret[1] = CondUncoveredProb.b_desc;
				break;
			case CONSENSUS_TREE:
				ret[0] = ConsensusTree.title;
				ret[1] = ConsensusTree.b_desc;
				break;
			case CONVERT_FASTA:
				ret[0] = ConvertFASTA.title;
				ret[1] = ConvertFASTA.b_desc;
				break;
			case CORE_DIVERSITY_ANALYSIS:
				ret[0] = CoreDiversityAnalysis.title;
				ret[1] = CoreDiversityAnalysis.b_desc;
				break;
			case COUNT_SEQS:
				ret[0] = CountSeqs.title;
				ret[1] = CountSeqs.b_desc;
				break;
			case DEMULTIPLEX_FASTA:
				ret[0] = DemultiplexFASTA.title;
				ret[1] = DemultiplexFASTA.b_desc;
				break;
			case DENOISER:
				ret[0] = Denoiser.title;
				ret[1] = Denoiser.b_desc;
				break;
			case DENOISER_PREPROCESS:
				ret[0] = DenoiserPreprocess.title;
				ret[1] = DenoiserPreprocess.b_desc;
				break;
			case DENOISE_WORKER:
				ret[0] = DenoiserWorker.title;
				ret[1] = DenoiserWorker.b_desc;
				break;
			case DENOISE_WRAPPER:
				ret[0] = DenoiseWrapper.title;
				ret[1] = DenoiseWrapper.b_desc;
				break;
			case DETREND:
				ret[0] = Detrend.title;
				ret[1] = Detrend.b_desc;
				break;
			case DIFF_ABUNDANCE:
				ret[0] = DifferentialAbundance.title;
				ret[1] = DifferentialAbundance.b_desc;
				break;
			case DISS_MATRIX_STATS:
				ret[0] = DissimilarityMatrixStats.title;
				ret[1] = DissimilarityMatrixStats.b_desc;
				break;
			case DIST_MATRIX_FROM_MAP:
				ret[0] = DistMatrixMapping.title;
				ret[1] = DistMatrixMapping.b_desc;
				break;
			case ESTIMATE_OBS_RICHNESS:
				ret[0] = EstimateObsRich.title;
				ret[1] = EstimateObsRich.b_desc;
				break;
			case EXCLUDE_SEQ_BY_BLAST:
				ret[0] = ExcludeSeqsByBlast.title;
				ret[1] = ExcludeSeqsByBlast.b_desc;
				break;
			case EXTRACT_BARCODES:
				ret[0] = ExtractBarcodes.title;
				ret[1] = ExtractBarcodes.b_desc;
				break;
			case EXTRACT_READS_INTERLEAVED:
				ret[0] = ExtractReadsInterleaved.title;
				ret[1] = ExtractReadsInterleaved.b_desc;
				break;
			case EXTRACT_SEQ_SAMPLE:
				ret[0] = ExtractSeqsSampleID.title;
				ret[1] = ExtractSeqsSampleID.b_desc;
				break;
			case FILTER_ALIGN:
				ret[0] = FilterAlignment.title;
				ret[1] = FilterAlignment.b_desc;
				break;
			case FILTER_DIST_MATRIX:
				ret[0] = FilterDistMatrix.title;
				ret[1] = FilterDistMatrix.b_desc;
				break;
			case FILTER_FASTA:
				ret[0] = FilterFASTA.title;
				ret[1] = FilterFASTA.b_desc;
				break;
			case FILTER_OTUS_SAMPLE:
				ret[0] = FilterOTUsSample.title;
				ret[1] = FilterOTUsSample.b_desc;
				break;
			case FILTER_OTUS_OTU_TABLE:
				ret[0] = FilterOTUsTable.title;
				ret[1] = FilterOTUsTable.b_desc;
				break;
			case FILTER_SAMPLES_OTU_TABLE:
				ret[0] = FilterSamplesOTUTable.title;
				ret[1] = FilterSamplesOTUTable.b_desc;
				break;
			case FILTER_TAXA_OTU_TABLE:
				ret[0] = FilterTaxaOTUTable.title;
				ret[1] = FilterTaxaOTUTable.b_desc;
				break;
			case FILTER_TREE:
				ret[0] = FilterTree.title;
				ret[1] = FilterTree.b_desc;
				break;
			case FIX_ARB_FASTA:
				ret[0] = FixARBFASTA.title;
				ret[1] = FixARBFASTA.b_desc;
				break;
			case GROUP_SIG:
				ret[0] = GroupSig.title;
				ret[1] = GroupSig.b_desc;
				break;
			case IDENTIFY_CHEM_SEQS:
				ret[0] = IdentifyChemericSeqs.title;
				ret[1] = IdentifyChemericSeqs.b_desc;
				break;
			case IDENTIFY_MISSING_FILES:
				ret[0] = IdentifyMissingFiles.title;
				ret[1] = IdentifyMissingFiles.b_desc;
				break;
			case IDENTIFY_PAIRED_DIFF:
				ret[0] = IdentifyPairedDiff.title;
				ret[1] = IdentifyPairedDiff.b_desc;
				break;
			case INFLATE_DENOISER_OUTPUT:
				ret[0] = InflateDenoiserOutput.title;
				ret[1] = InflateDenoiserOutput.b_desc;
				break;
			case JACKKNIFED_BETA_DIVERSITY:
				ret[0] = JackknifedBetaDiv.title;
				ret[1] = JackknifedBetaDiv.b_desc;
				break;
			case JOINED_PAIRED_ENDS:
				ret[0] = JoinPairedEnds.title;
				ret[1] = JoinPairedEnds.b_desc;
				break;
			case LOAD_REMOTE_MAP_FILE:
				ret[0] = LoadRemoteMapping.title;
				ret[1] = LoadRemoteMapping.b_desc;
				break;
			case MAKE_2D_PLOTS:
				ret[0] = Make2DPlots.title;
				ret[1] = Make2DPlots.b_desc;
				break;
			case MAKE_BIPARTITE_NET:
				ret[0] = MakeBipartiteNetwork.title;
				ret[1] = MakeBipartiteNetwork.b_desc;
				break;
			case MAKE_BOOTSTRAPPED_TREE:
				ret[0] = MakeBootstrappedTree.title;
				ret[1] = MakeBootstrappedTree.b_desc;
				break;
			case MAKE_DIST_BOXPLOTS:
				ret[0] = MakeDistBoxplots.title;
				ret[1] = MakeDistBoxplots.b_desc;
				break;
			case MAKE_DIST_COMP_PLOTS:
				ret[0] = MakeDistCompPlots.title;
				ret[1] = MakeDistCompPlots.b_desc;
				break;
			case MAKE_FASTQ:
				ret[0] = MakeFASTQ.title;
				ret[1] = MakeFASTQ.b_desc;
				break;
			case MAKE_LIBRARY_ID_LIST:
				ret[0] = MakeLibraryIDList.title;
				ret[1] = MakeLibraryIDList.b_desc;
				break;
			case MAKE_OTU_HEATMAP:
				ret[0] = MakeOTUHeatmap.title;
				ret[1] = MakeOTUHeatmap.b_desc;
				break;
			case MAKE_OTU_NET:
				ret[0] = MakeOTUNetwork.title;
				ret[1] = MakeOTUNetwork.b_desc;
				break;
			case MAKE_OTU_TABLE:
				ret[0] = MakeOTUTable.title;
				ret[1] = MakeOTUTable.b_desc;
				break;
			case MAKE_PER_LIBRARY_SFF:
				ret[0] = MakePerLibSFF.title;
				ret[1] = MakePerLibSFF.b_desc;
				break;
			case MAKE_PHYLOGENY:
				ret[0] = MakePhylogeny.title;
				ret[1] = MakePhylogeny.b_desc;
				break;
			case MAKE_PREF_FILE:
				ret[0] = MakePreference.title;
				ret[1] = MakePreference.b_desc;
				break;
			case MAKE_QIIME_PYTHON_FILE:
				ret[0] = MakeQiimePython.title;
				ret[1] = MakeQiimePython.b_desc;
				break;
			case MAKE_RAREFACTION_PLOTS:
				ret[0] = MakeRarefactionPlots.title;
				ret[1] = MakeRarefactionPlots.b_desc;
				break;
			case MAKE_TEP:
				ret[0] = MakeTEP.title;
				ret[1] = MakeTEP.b_desc;
				break;
			case MAP_READS_TO_REF:
				ret[0] = MapReadsToRef.title;
				ret[1] = MapReadsToRef.b_desc;
				break;
			case MERGE_MAP_FILES:
				ret[0] = MergeMappingFiles.title;
				ret[1] = MergeMappingFiles.b_desc;
				break;
			case MERGE_OTU_MAPS:
				ret[0] = MergeOTUMaps.title;
				ret[1] = MergeOTUMaps.b_desc;
				break;
			case MERGE_OTU_TABLES:
				ret[0] = MergeOTUTables.title;
				ret[1] = MergeOTUTables.b_desc;
				break;
			case MULTIPLE_EXTRACT_BARCODES:
				ret[0] = MultipleExtractBarcodes.title;
				ret[1] = MultipleExtractBarcodes.b_desc;
				break;
			case MULTIPLE_JOIN_PAIRED_ENDS:
				ret[0] = MultipleJoinPairedEnds.title;
				ret[1] = MultipleJoinPairedEnds.b_desc;
				break;
			case MULTIPLE_RAREFACTIONS:
				ret[0] = MultipleRarefactions.title;
				ret[1] = MultipleRarefactions.b_desc;
				break;
			case MULTIPLE_RAREFACTION_DEPTH:
				ret[0] = MultipleRarefactionsDepth.title;
				ret[1] = MultipleRarefactionsDepth.b_desc;
				break;
			case MULTIPLE_SPLIT_LIB_FASTQ:
				ret[0] = MultipleSplitLibFASTQ.title;
				ret[1] = MultipleSplitLibFASTQ.b_desc;
				break;
			case NEIGHBOR_JOINING:
				ret[0] = NeighborJoining.title;
				ret[1] = NeighborJoining.b_desc;
				break;
			case NMDS:
				ret[0] = NoMDS.title;
				ret[1] = NoMDS.b_desc;
				break;
			case NORMALIZE_TABLE:
				ret[0] = NormalizeTable.title;
				ret[1] = NormalizeTable.b_desc;
				break;
			case OBSERVATION_METADATA_CORR:
				ret[0] = ObsMetaCore.title;
				ret[1] = ObsMetaCore.b_desc;
				break;
			case PARALLEL_ALPHA_DIVERSITY:
				ret[0] = ParallelAlphaDiv.title;
				ret[1] = ParallelAlphaDiv.b_desc;
				break;
			case PARALLEL_ALIGN_SEQS_PYNAST:
				ret[0] = ParallelAlignSeqsPynast.title;
				ret[1] = ParallelAlignSeqsPynast.b_desc;
				break;
			case PARALLEL_ASSIGN_TAX_BLAST:
				ret[0] = ParallelAssignTaxBlast.title;
				ret[1] = ParallelAssignTaxBlast.b_desc;
				break;
			case PARALLEL_ASSIGN_TAX_RDP:
				ret[0] = ParallelAssignTaxRDP.title;
				ret[1] = ParallelAssignTaxRDP.b_desc;
				break;
			case PARALLEL_ASSIGN_TAX_UCLUST:
				ret[0] = ParallelAssignTaxUclust.title;
				ret[1] = ParallelAssignTaxUclust.b_desc;
				break;
			case PARALLEL_BETA_DIVERSITY:
				ret[0] = ParallelBetaDiversity.title;
				ret[1] = ParallelBetaDiversity.b_desc;
				break;
			case PARALLEL_BLAST:
				ret[0] = ParallelBlast.title;
				ret[1] = ParallelBlast.b_desc;
				break;
			case PARALLEL_IDENTIFY_CHEM_SEQS:
				ret[0] = ParallelIdentifyChemSeqs.title;
				ret[1] = ParallelIdentifyChemSeqs.b_desc;
				break;
			case PARALLEL_MAP_READS_REF:
				ret[0] = ParallelMapReadsToRef.title;
				ret[1] = ParallelMapReadsToRef.b_desc;
				break;
			case PARALLEL_MERGE_OTU_TABLES:
				ret[0] = ParallelMergeOTUTables.title;
				ret[1] = ParallelMergeOTUTables.b_desc;
				break;
			case PARALLEL_MULTIPLE_RAREFACTIONS:
				ret[0] = ParallelMultipleRarefactions.title;
				ret[1] = ParallelMultipleRarefactions.b_desc;
				break;
			case PARALLEL_PICK_OTUS_BLAST:
				ret[0] = ParallelPickOTUsBlast.title;
				ret[1] = ParallelPickOTUsBlast.b_desc;
				break;
			case PARALLEL_PICK_OTUS_SORTMERNA:
				ret[0] = ParallelPickOTUsSortmerna.title;
				ret[1] = ParallelPickOTUsSortmerna.b_desc;
				break;
			case PARALLEL_PICK_OTUS_TRIE:
				ret[0] = ParallelPickOTUsTrie.title;
				ret[1] = ParallelPickOTUsTrie.b_desc;
				break;
			case PARALLEL_PICK_OTUS_UCLUST_REF:
				ret[0] = ParallelPickOTUsUclustRef.title;
				ret[1] = ParallelPickOTUsUclustRef.b_desc;
				break;
			case PARALLEL_PICK_OTUS_USEARCH_REF:
				ret[0] = ParallelPickOTUsUsearch61Ref.title;
				ret[1] = ParallelPickOTUsUsearch61Ref.b_desc;
				break;
			case PICK_CLOSED_REF_OTUS:
				ret[0] = PickClosedRefOTUs.title;
				ret[1] = PickClosedRefOTUs.b_desc;
				break;
			case PICK_DE_NOVO_OTUS:
				ret[0] = PickDeNovoOTUs.title;
				ret[1] = PickDeNovoOTUs.b_desc;
				break;
			case PICK_OPEN_REF_OTUS:
				ret[0] = PickOpenRefOTUs.title;
				ret[1] = PickOpenRefOTUs.b_desc;
				break;
			case PICK_OTUS:
				ret[0] = PickOTUs.title;
				ret[1] = PickOTUs.b_desc;
				break;
			case PICK_REP_SET:
				ret[0] = PickRepSet.title;
				ret[1] = PickRepSet.b_desc;
				break;
			case PLOT_RANK_ABUND_GRAPH:
				ret[0] = PlotRankAbundance.title;
				ret[1] = PlotRankAbundance.b_desc;
				break;
			case PLOT_SEMIVARIOGRAM:
				ret[0] = PlotSemivariogram.title;
				ret[1] = PlotSemivariogram.b_desc;
				break;
			case PLOT_TAXA_SUMMARY:
				ret[0] = PlotTaxaSummary.title;
				ret[1] = PlotTaxaSummary.b_desc;
				break;
			case POLLER:
				ret[0] = Poller.title;
				ret[1] = Poller.b_desc;
				break;
			case PRINCIPAL_COORDINATES:
				ret[0] = PrincipalCoordinates.title;
				ret[1] = PrincipalCoordinates.b_desc;
				break;
			case PRINT_METADATA_STATS:
				ret[0] = PrintMetadataStats.title;
				ret[1] = PrintMetadataStats.b_desc;
				break;
			case PRINT_QIIME_CONFIG:
				ret[0] = PrintQiimeConfig.title;
				ret[1] = PrintQiimeConfig.b_desc;
				break;
			case PROCESS_ISEQ:
				ret[0] = ProcessISeq.title;
				ret[1] = ProcessISeq.b_desc;
				break;
			case PROCESS_QSEQ:
				ret[0] = ProcessQSeq.title;
				ret[1] = ProcessQSeq.b_desc;
				break;
			case PROCESS_SFF:
				ret[0] = ProcessSFF.title;
				ret[1] = ProcessSFF.b_desc;
				break;
			case QUALITY_SCORES_PLOT:
				ret[0] = QualityScoresPlot.title;
				ret[1] = QualityScoresPlot.b_desc;
				break;
			case RELATEDNESS:
				ret[0] = Relatedness.title;
				ret[1] = Relatedness.b_desc;
				break;
			case SHARED_PHYLOTYPES:
				ret[0] = SharedPhylotypes.title;
				ret[1] = SharedPhylotypes.b_desc;
				break;
			case SIMSAM:
				ret[0] = Simsam.title;
				ret[1] = Simsam.b_desc;
				break;
			case SINGLE_RAREFACTIONS:
				ret[0] = SingleRarefaction.title;
				ret[1] = SingleRarefaction.b_desc;
				break;
			case SORT_OTU_TABLE:
				ret[0] = SortOTUTable.title;
				ret[1] = SortOTUTable.b_desc;
				break;
			case SPLIT_LIBRARIES:
				ret[0] = SplitLibraries.title;
				ret[1] = SplitLibraries.b_desc;
				break;
			case SPLIT_LIBRARIES_FASTQ:
				ret[0] = SplitLibrariesFASTQ.title;
				ret[1] = SplitLibrariesFASTQ.b_desc;
				break;
			case SPLIT_LIBRARIES_LEA_SEQ:
				ret[0] = SplitLibrariesLea.title;
				ret[1] = SplitLibrariesLea.b_desc;
				break;
		}
		return ret;
	}

	public static Script getScript(int scriptNum){
		Script ret = null;
		switch (scriptNum){
			case ADD_ALPHA_TO_MAPPING:
				ret = new AddAlphaToMapping();
				break;
			case ADD_QIIME_LABELS:
				ret = new AddQiimeLabels();
				break;
			case ADJUST_SEQ_ORIENT:
				ret = new AdjustSeqOrient();
				break;
			case ALIGN_SEQS:
				ret = new AlignSeqs();
				break;
			case ALPHA_DIVERSITY:
				ret = new AlphaDiversity();
				break;
			case ALPHA_RAREFACTION:
				ret = new AlphaRarefaction();
				break;
			case AMPLICONNOISE:
				ret = new Ampliconnoise();
				break;
			case ASSIGN_TAX:
				ret = new AssignTax();
				break;
			case BETA_DIVERSITY:
				ret = new BetaDiversity();
				break;
			case BETA_DIVERSITY_PLOTS:
				ret = new BetaDiversityPlots();
				break;
			case BETA_SIGNIFICANCE:
				ret = new BetaSignificance();
				break;
			case BLAST_WRAPPER:
				ret = new BlastWrapper();
				break;
			case CATEGORIZE_DIST_PLOT:
				ret = new CategorizeDistPlot();
				break;
			case CLEAN_RAXML_TREE:
				ret = new CleanRaxmlTree();
				break;
			case CLUSTER_QUALITY:
				ret = new ClusterQuality();
				break;
			case COLLAPSE_SAMPLES:
				ret = new CollapseSamples();
				break;
			case COLLATE_ALPHA:
				ret = new CollateAlpha();
				break;
			case COMPARE_ALPHA_DIVERSITY:
				ret = new CompareAlphaDiversity();
				break;
			case COMPARE_CATEGORIES:
				ret = new CompareCategories();
				break;
			case COMPARE_DIST_MATRICIES:
				ret = new CompareDistMatricies();
				break;
			case COMPARE_TAXA_SUMMARIES:
				ret = new CompareTaxaSummary();
				break;
			case COMPARE_TRAJECTORIES:
				ret = new CompareTrajectories();
				break;
			case COMPUTE_CORE_MICROBIOME:
				ret = new ComputeCoreMicrobiome();
				break;
			case COMPUTE_TAX_RATIOS:
				ret = new ComputeTaxRatios();
				break;
			case COND_UNCOVERED_PROB:
				ret = new CondUncoveredProb();
				break;
			case CONSENSUS_TREE:
				ret = new ConsensusTree();
				break;
			case CONVERT_FASTA:
				ret = new ConvertFASTA();
				break;
			case CORE_DIVERSITY_ANALYSIS:
				ret = new CoreDiversityAnalysis();
				break;
			case COUNT_SEQS:
				ret = new CountSeqs();
				break;
			case DEMULTIPLEX_FASTA:
				ret = new DemultiplexFASTA();
				break;
			case DENOISER:
				ret = new Denoiser();
				break;
			case DENOISER_PREPROCESS:
				ret = new DenoiserPreprocess();
				break;
			case DENOISE_WORKER:
				ret = new DenoiserWorker();
				break;
			case DENOISE_WRAPPER:
				ret = new DenoiseWrapper();
				break;
			case DETREND:
				ret = new Detrend();
				break;
			case DIFF_ABUNDANCE:
				ret = new DifferentialAbundance();
				break;
			case DISS_MATRIX_STATS:
				ret = new DissimilarityMatrixStats();
				break;
			case DIST_MATRIX_FROM_MAP:
				ret = new DistMatrixMapping();
				break;
			case ESTIMATE_OBS_RICHNESS:
				ret = new EstimateObsRich();
				break;
			case EXCLUDE_SEQ_BY_BLAST:
				ret = new ExcludeSeqsByBlast();
				break;
			case EXTRACT_BARCODES:
				ret = new ExtractBarcodes();
				break;
			case EXTRACT_READS_INTERLEAVED:
				ret = new ExtractReadsInterleaved();
				break;
			case EXTRACT_SEQ_SAMPLE:
				ret = new ExtractSeqsSampleID();
				break;
			case FILTER_ALIGN:
				ret = new FilterAlignment();
				break;
			case FILTER_DIST_MATRIX:
				ret = new FilterDistMatrix();
				break;
			case FILTER_FASTA:
				ret = new FilterFASTA();
				break;
			case FILTER_OTUS_SAMPLE:
				ret = new FilterOTUsSample();
				break;
			case FILTER_OTUS_OTU_TABLE:
				ret = new FilterOTUsTable();
				break;
			case FILTER_SAMPLES_OTU_TABLE:
				ret = new FilterSamplesOTUTable();
				break;
			case FILTER_TAXA_OTU_TABLE:
				ret = new FilterTaxaOTUTable();
				break;
			case FILTER_TREE:
				ret = new FilterTree();
				break;
			case FIX_ARB_FASTA:
				ret = new FixARBFASTA();
				break;
			case GROUP_SIG:
				ret = new GroupSig();
				break;
			case IDENTIFY_CHEM_SEQS:
				ret = new IdentifyChemericSeqs();
				break;
			case IDENTIFY_MISSING_FILES:
				ret = new IdentifyMissingFiles();
				break;
			case IDENTIFY_PAIRED_DIFF:
				ret = new IdentifyPairedDiff();
				break;
			case INFLATE_DENOISER_OUTPUT:
				ret = new InflateDenoiserOutput();
				break;
			case JACKKNIFED_BETA_DIVERSITY:
				ret = new JackknifedBetaDiv();
				break;
			case JOINED_PAIRED_ENDS:
				ret = new JoinPairedEnds();
				break;
			case LOAD_REMOTE_MAP_FILE:
				ret = new LoadRemoteMapping();
				break;
			case MAKE_2D_PLOTS:
				ret = new Make2DPlots();
				break;
			case MAKE_BIPARTITE_NET:
				ret = new MakeBipartiteNetwork();
				break;
			case MAKE_BOOTSTRAPPED_TREE:
				ret = new MakeBootstrappedTree();
				break;
			case MAKE_DIST_BOXPLOTS:
				ret = new MakeDistBoxplots();
				break;
			case MAKE_DIST_COMP_PLOTS:
				ret = new MakeDistCompPlots();
				break;
			case MAKE_FASTQ:
				ret = new MakeFASTQ();
				break;
			case MAKE_LIBRARY_ID_LIST:
				ret = new MakeLibraryIDList();
				break;
			case MAKE_OTU_HEATMAP:
				ret = new MakeOTUHeatmap();
				break;
			case MAKE_OTU_NET:
				ret = new MakeOTUNetwork();
				break;
			case MAKE_OTU_TABLE:
				ret = new MakeOTUTable();
				break;
			case MAKE_PER_LIBRARY_SFF:
				ret = new MakePerLibSFF();
				break;
			case MAKE_PHYLOGENY:
				ret = new MakePhylogeny();
				break;
			case MAKE_PREF_FILE:
				ret = new MakePreference();
				break;
			case MAKE_QIIME_PYTHON_FILE:
				ret = new MakeQiimePython();
				break;
			case MAKE_RAREFACTION_PLOTS:
				ret = new MakeRarefactionPlots();
				break;
			case MAKE_TEP:
				ret = new MakeTEP();
				break;
			case MAP_READS_TO_REF:
				ret = new MapReadsToRef();
				break;
			case MERGE_MAP_FILES:
				ret = new MergeMappingFiles();
				break;
			case MERGE_OTU_MAPS:
				ret = new MergeOTUMaps();
				break;
			case MERGE_OTU_TABLES:
				ret = new MergeOTUTables();
				break;
			case MULTIPLE_EXTRACT_BARCODES:
				ret = new MultipleExtractBarcodes();
				break;
			case MULTIPLE_JOIN_PAIRED_ENDS:
				ret = new MultipleJoinPairedEnds();
				break;
			case MULTIPLE_RAREFACTIONS:
				ret = new MultipleRarefactions();
				break;
			case MULTIPLE_RAREFACTION_DEPTH:
				ret = new MultipleRarefactionsDepth();
				break;
			case MULTIPLE_SPLIT_LIB_FASTQ:
				ret = new MultipleSplitLibFASTQ();
				break;
			case NEIGHBOR_JOINING:
				ret = new NeighborJoining();
				break;
			case NMDS:
				ret = new NoMDS();
				break;
			case NORMALIZE_TABLE:
				ret = new NormalizeTable();
				break;
			case OBSERVATION_METADATA_CORR:
				ret = new ObsMetaCore();
				break;
			case PARALLEL_ALPHA_DIVERSITY:
				ret = new ParallelAlphaDiv();
				break;
			case PARALLEL_ALIGN_SEQS_PYNAST:
				ret = new ParallelAlignSeqsPynast();
				break;
			case PARALLEL_ASSIGN_TAX_BLAST:
				ret = new ParallelAssignTaxBlast();
				break;
			case PARALLEL_ASSIGN_TAX_RDP:
				ret = new ParallelAssignTaxRDP();
				break;
			case PARALLEL_ASSIGN_TAX_UCLUST:
				ret = new ParallelAssignTaxUclust();
				break;
			case PARALLEL_BETA_DIVERSITY:
				ret = new ParallelBetaDiversity();
				break;
			case PARALLEL_BLAST:
				ret = new ParallelBlast();
				break;
			case PARALLEL_IDENTIFY_CHEM_SEQS:
				ret = new ParallelIdentifyChemSeqs();
				break;
			case PARALLEL_MAP_READS_REF:
				ret = new ParallelMapReadsToRef();
				break;
			case PARALLEL_MERGE_OTU_TABLES:
				ret = new ParallelMergeOTUTables();
				break;
			case PARALLEL_MULTIPLE_RAREFACTIONS:
				ret = new ParallelMultipleRarefactions();
				break;
			case PARALLEL_PICK_OTUS_BLAST:
				ret = new ParallelPickOTUsBlast();
				break;
			case PARALLEL_PICK_OTUS_SORTMERNA:
				ret = new ParallelPickOTUsSortmerna();
				break;
			case PARALLEL_PICK_OTUS_TRIE:
				ret = new ParallelPickOTUsTrie();
				break;
			case PARALLEL_PICK_OTUS_UCLUST_REF:
				ret = new ParallelPickOTUsUclustRef();
				break;
			case PARALLEL_PICK_OTUS_USEARCH_REF:
				ret = new ParallelPickOTUsUsearch61Ref();
				break;
			case PICK_CLOSED_REF_OTUS:
				ret = new PickClosedRefOTUs();
				break;
			case PICK_DE_NOVO_OTUS:
				ret = new PickDeNovoOTUs();
				break;
			case PICK_OPEN_REF_OTUS:
				ret = new PickOpenRefOTUs();
				break;
			case PICK_OTUS:
				ret = new PickOTUs();
				break;
			case PICK_REP_SET:
				ret = new PickRepSet();
				break;
			case PLOT_RANK_ABUND_GRAPH:
				ret = new PlotRankAbundance();
				break;
			case PLOT_SEMIVARIOGRAM:
				ret = new PlotSemivariogram();
				break;
			case PLOT_TAXA_SUMMARY:
				ret = new PlotTaxaSummary();
				break;
			case POLLER:
				ret = new Poller();
				break;
			case PRINCIPAL_COORDINATES:
				ret = new PrincipalCoordinates();
				break;
			case PRINT_METADATA_STATS:
				ret = new PrintMetadataStats();
				break;
			case PRINT_QIIME_CONFIG:
				ret = new PrintQiimeConfig();
				break;
			case PROCESS_ISEQ:
				ret = new ProcessISeq();
				break;
			case PROCESS_QSEQ:
				ret = new ProcessQSeq();
				break;
			case SINGLE_RAREFACTIONS:
				ret = new SingleRarefaction();
				break;
			case PROCESS_SFF:
				ret = new ProcessSFF();
				break;
			case QUALITY_SCORES_PLOT:
				ret = new QualityScoresPlot();
				break;
			case RELATEDNESS:
				ret = new Relatedness();
				break;
			case SHARED_PHYLOTYPES:
				ret = new SharedPhylotypes();
				break;
			case SIMSAM:
				ret = new Simsam();
				break;
			case SORT_OTU_TABLE:
				ret = new SortOTUTable();
				break;
			case SPLIT_LIBRARIES:
				ret = new SplitLibraries();
				break;
			case SPLIT_LIBRARIES_FASTQ:
				ret = new SplitLibrariesFASTQ();
				break;
			case SPLIT_LIBRARIES_LEA_SEQ:
				ret = new SplitLibrariesLea();
				break;
		}
		return ret;
	}
}