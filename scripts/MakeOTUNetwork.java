package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class MakeOTUNetwork extends Script {
	public static String title = "Make OTU Network";
	public static String b_desc = "Make an OTU network and calculate statistics";

	public MakeOTUNetwork() {
		// set up script name, command, and descriptions
		this.link = "http://qiime.org/scripts/make_otu_network.html";
		this.c_name = SCRIPTS_PATH + "make_otu_network.py";
		this.l_desc = "This script generates the otu network files to be passed into cytoscape and statistics for those networks. It uses the OTU fileand the user metadata mapping file.<br><br>Network-based analysis is used to display and analyze how OTUs are partitioned between samples. This is a powerful way to display visually large and highly complex datasets in such a way that similarities and differences between samples are emphasized. The visual output of this analysis is a clustering of samples according to their shared OTUs - samples that share more OTUs cluster closer together. The degree to which samples cluster is based on the number of OTUs shared between samples (when OTUs are found in more than one sample) and this is weighted according to the number of sequences within an OTU. In the network diagram, there are two kinds of “nodes” represented, OTU-nodes and sample-nodes. These are shown with symbols such as filled circles and filled squares. If an OTU is found within a sample, the two nodes are connected with a line (an “edge”). (OTUs found only in one sample are given a second, distinct OTU-node shape.) The nodes and edges can then be colored to emphasize certain aspects of the data. For instance, in the initial application of this analysis in a microbial ecology study, the gut bacteria of a variety of mammals was surveyed, and the network diagrams were colored according to the diets of the animals, which highlighted the clustering of hosts by diet category (herbivores, carnivores, omnivores). In a meta-analysis of bacterial surveys across habitat types, the networks were colored in such a way that the phylogenetic classification of the OTUs was highlighted: this revealed the dominance of shared Firmicutes in vertebrate gut samples versus a much higher diversity of phyla represented amongst the OTUs shared by environmental samples.<br><br>Not just pretty pictures: the connections within the network are analyzed statistically to provide support for the clustering patterns displayed in the network. A G-test for independence is used to test whether sample-nodes within categories (such as diet group for the animal example used above) are more connected within than a group than expected by chance. Each pair of samples is classified according to whether its members shared at least one OTU, and whether they share a category. Pairs are then tested for independence in these categories (this asks whether pairs that share a category also are equally likely to share an OTU). This statistical test can also provide support for an apparent lack of clustering when it appears that a parameter is not contributing to the clustering.<br><br>This OTU-based approach to comparisons between samples provides a counterpoint to the tree-based PCoA graphs derived from the UniFrac analyses. In most studies, the two approaches reveal the same patterns. They can reveal different aspects of the data, however. The network analysis can provide phylogenetic information in a visual manner, whereas PCoA-UniFrac clustering can reveal subclusters that may be obscured in the network. The PCs can be pulled out individually and regressed against other metadata; the network analysis can provide a visual display of shared versus unique OTUs. Thus, together these tools can be used to draw attention to disparate aspects of a dataset, as desired by the author.<br><br>In more technical language: OTUs and samples are designated as two types of nodes in a bipartite network in which OTU-nodes are connected via edges to sample-nodes in which their sequences are found. Edge weights are defined as the number of sequences in an OTU. To cluster the OTUs and samples in the network, a stochastic spring-embedded algorithm is used, where nodes act like physical objects that repel each other, and connections act a springs with a spring constant and a resting length: the nodes are organized in a way that minimized forces in the network. These algorithms are implemented in Cytoscape (Shannon et al., 2003).";
		this.output_desc = "The result of make_otu_network.py consists of a folder which contains edge and node files to be loaded into cytoscape along with props files labeled by category, which can used for coloring.";

		// set up the required otpions
		this.r_options = new ArrayList<Option>(3);
		this.r_options.add(new Option("OTU Table", "-i", Option.PATH, "Name of otu table file in biom format [REQUIRED]"));
		this.r_options.add(new Option("Map File", "-m", Option.PATH, "Name of input map file [REQUIRED]"));
		this.r_options.add(new Option("Output", "-o", Option.PATH, "Output directory for all analyses [REQUIRED]"));

		// set up the extra options
		this.e_options = new ArrayList<Option>(3);
		this.e_options.add(new Option("Categories", "-b", Option.INPUT, "This is the categories to color by in the plots from the user-generated mapping file. The categories must match the name of a column header in the mapping file exactly and multiple categories can be list by comma separating them without spaces. The user can also combine columns in the mapping file by separating the categories by “&&” without spaces [default=None]"));
		this.e_options.add(new Option("Preference File", "-p", Option.PATH, "This is the user-generated preferences file. NOTE: This is a file with a dictionary containing preferences for the analysis [default: None]"));
		this.e_options.add(new Option("Background Color", "-k", Option.INPUT, "This is the background color to use in the plots. [default: None]"));
	
	}
}