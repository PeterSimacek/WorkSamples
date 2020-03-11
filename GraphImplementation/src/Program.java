
public class Program {

	public static void main(String[] args) {
		
		// The following example represents a labeled property graph. 
		// It is realized by creating an instance of the generic graph with the datatype LabeledPropertyPodes. 
		// Instances of the class LabeledPropertyNode have a name, a label and a set of properties.
		Graph<LabeledPropertyNode,String> filmLandscape = new Graph<LabeledPropertyNode,String>();
		
		// Lets create some nodes that are labeled as film
		LabeledPropertyNode kong = new LabeledPropertyNode("King Kong", "Film", "Genre", "Adventure", "Runtime", "201", "Oscars", "4");
		LabeledPropertyNode lotr1 = new LabeledPropertyNode("The Lord of the Rings 1", "Film", "Genre", "Fantasy", "Runtime", "210", "Oscars", "4");
		LabeledPropertyNode hobbit1 = new LabeledPropertyNode("The Hobbit 1", "Film", "Genre", "Fantasy", "Runtime", "182", "Oscars", "3");
		LabeledPropertyNode pirates1 = new LabeledPropertyNode("Pirates of the Caribbean", "Film", "Genre", "Adventure", "Runtime", "123", "Oscars", "4");
		LabeledPropertyNode braindead = new LabeledPropertyNode("Braindead", "Film", "Genre", "Horror", "Runtime", "104", "Oscars", "0");
		
		// Two nodes labeled as actor
		LabeledPropertyNode oBloom = new LabeledPropertyNode("Orlando Bloom", "Actor");
		LabeledPropertyNode aSerkis = new LabeledPropertyNode("Andy Serkis", "Actor");
		
		// A node labeled as director
		LabeledPropertyNode pJAckson = new LabeledPropertyNode("Peter Jackson", "Director");
	
		// Connect the graph with two types of edges: "directed by" and "starring"
		filmLandscape.addEdge(kong, pJAckson, "directed by", false);
		filmLandscape.addEdge(lotr1, pJAckson, "directed by", false);
		filmLandscape.addEdge(hobbit1, pJAckson, "directed by", false);
		filmLandscape.addEdge(braindead, pJAckson, "directed by", false);
		filmLandscape.addEdge(lotr1, oBloom, "starring", false);
		filmLandscape.addEdge(lotr1, aSerkis, "starring", false);
		filmLandscape.addEdge(hobbit1, oBloom, "starring", false);
		filmLandscape.addEdge(hobbit1, aSerkis, "starring", false);
		filmLandscape.addEdge(kong, aSerkis, "starring", false);
		filmLandscape.addEdge(pirates1, oBloom, "starring", false);
		
		// Print adjacency list representation of graph
		System.out.println("Adjacency lists of every node in the graph:\n" + filmLandscape.toString() + "\n");
		
		// Print all nodes of the graph
		System.out.println("All nodes of the graph:");
		System.out.println(filmLandscape.getAllNodes().toString());
		
		// Streaming service user Hanna loves films of the fantasy genre and she likes the actor Andy Serkis.
		// Lets find some film recommendations for her:
		System.out.println("\nFantasy Films with Andi Serkis:");
		for(LabeledPropertyNode n: filmLandscape.getAllNodes()) {
			if(n.hasLabel("Film")) {
				if(n.hasProperty("Genre", "Fantasy")) {
					for(LabeledPropertyNode n2: filmLandscape.traverse(n, "starring")) {
						if(n2.getName() == "Andy Serkis") {
							System.out.print(n.toString() + ", ");
						}
					}
				}
			}
		}
	}

}
