package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class NormalizeTable extends Script {
	public static String title = "Normalize Table";
	public static String b_desc = "Matrix normalization alternatives to rarefaction";

	public NormalizeTable() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/normalize_table.html";
		this.c_name = SCRIPTS_PATH + "normalize_table.py";
		this.l_desc = "To perform many downstream analyses after OTU picking (besides metagenomeSeq’s fitZIG and DESeq OTU differential abundance testing), the OTU matrix must be normalized to account for uneven column (sample) sums that are a result of most modern sequencing techniques. These methods attempt to correct for compositionality too. Rarefying throws away some data by rarefying to a constant sum and throwing away extremely low depth samples.<br><br>Even with these new normalization techniques, we would recommend throwing away low depth samples (e.g. less that 1000 sequences/sample). DESeq/DESeq2 outputs negative values for lower abundant OTUs as a result of its log transformation. For most ecologically useful metrics (e.g. UniFrac/Bray Curtis) this presents problems. No good solution exists at the moment for this issue. Note that one is added to the matrix to avoid log(0). It has been shown that clustering results can be highly dependent upon the choice of the pseudocount (e.g. should it be 0.01 instead of 1?), for more information read Costea, P. et al. (2014) “A fair comparison”, Nature Methods.<br><br>DESeq/DESeq2 can also have a very slow runtime, especially for larger datasets. In this script, we implement DESeq2’s variance stabilization technique. If you do use these alternatives to rarefying, we would recommend metagenomeSeq’s CSS (cumulative sum scaling) transformation for those metrics that are abundance-based. It is not recommended to use these new methods with presence/absence metrics, for example binary Jaccard or unweighted UniFrac.<br><br>For more on metagenomeSeq’s CSS, please see Paulson, JN, et al. ‘Differential abundance analysis for microbial marker-gene surveys’ Nature Methods 2013. For DESeq please see Anders S, Huber W. ‘Differential expression analysis for sequence count data.’ Genome Biology 2010. For DESeq2 please read Love, MI et al. ‘Moderated estimation of fold change and dispersion for RNA-Seq data with DESeq2,’ Genome Biology 2014. If you use these methods, please CITE the appropriate reference as well as QIIME. For any of these methods, clustering by sequence depth MUST BE CHECKED FOR as a confounding variable, e.g. by coloring by sequences/sample on a PCoA plot and testing for correlations between taxa abundances and sequencing depth with e.g. adonis in compare_categories.py, or observation_metadata_correlation.py.<br><br>Note: If the input BIOM table contains observation metadata (e.g., taxonomy metadata for each OTU), this metadata will not be included in the output normalized BIOM table when using DESeq2. When using CSS the taxonomy metadata will be included in the output normalized table but it may not be in the same format as the input table (e.g., “NA” will be added for missing taxonomic levels). This discrepancy occurs because the underlying R packages used to perform the normalization store taxonomy metadata in a different format.<br><br>As a workaround, the “biom add-metadata” command can be used to add the original observation metadata to the output normalized table if desired. For example, to include the original taxonomy metadata on the output normalized table, “biom add-metadata” can be used with the representative sequence taxonomic assignment file output by assign_taxonomy.py.";
		this.output_desc = "BIOM table with normalized counts.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(0);
		// this.r_options.add(new Option());

		// set up the extra options
		this.e_options = new ArrayList<Option>(6);
		this.e_options.add(new Option("BIOM File", "-i", Option.PATH, "Path to the input BIOM file (e.g., the output from OTU picking) or directory containing input BIOM files for batch processing [REQUIRED if not passing -l]"));
		this.e_options.add(new Option("Output", "-o", Option.PATH, "Output filename for single file operation, or output directory for batch processing [REQUIRED if not passing -l]"));
		this.e_options.add(new Option("Output Stats File", "-s", Option.PATH, "Output CSS statistics file. This will be a directory for batch processing, and a filename for single file operation [default: False]"));
		this.e_options.add(new Option("Replace Negative Numbers?", "-z", Option.NOARG, "Replace negative numbers produced by the DESeq normalization technique with zeros [default: False]"));
		List<String> selects = new ArrayList<String>();
		selects.add("CSS");
		selects.add("DESeq2");
		this.e_options.add(new Option("Algorithm", "-a", Option.SELECT, selects, 0, "Normalization algorithm to apply to input BIOM table(s). [default: CSS] Available options are: CSS, DESeq2"));
		this.e_options.add(new Option("Show Algorthms?", "-l", Option.NOARG, "Show available normalization algorithms and exit [default: False]"));
	
	}
}