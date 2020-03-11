// A Java Class which implements a Graph using Generics.
// The following graph implementation is based of the solution from:
// https://www.geeksforgeeks.org/implementing-generic-graph-in-java/
// It was extended by some utility functions and weighted edges.

import java.util.*;
import org.javatuples.Pair;

public class Graph<A,B> {
	// A HashMap is used to store the nodes as keys and their adjacency list as values.
	// The adjacency list consists of pairs.
	// First value of a pair is a node, which can be of any datatype A. 
	// Second value is an edge property of datatype B. 
    private Map<A, List< Pair<A,B> > > map = new HashMap<>(); 
  
    // Adds a new node to the graph 
    public void addNode(A s) 
    { 
        map.put(s, new LinkedList< Pair<A,B> >()); 
    }
  
    // Adds an edge from source to destination and assigns an edge property 
    public void addEdge(A source, 
                        A destination, 
                        B edgeProperty,
                        boolean bidirectional) 
    { 
        if (!map.containsKey(source)) 
            this.addNode(source); 
  
        if (!map.containsKey(destination)) 
            this.addNode(destination); 
  
        this.map.get(source).add(new Pair<A, B>(destination, edgeProperty)); 
        if (bidirectional == true) { 
            this.map.get(destination).add(new Pair<A, B>(source, edgeProperty)); 
        } 
    } 
  
    // Gives the amount of nodes 
    public void getNodesCount() 
    { 
        System.out.println("The graph has "
                           + this.map.keySet().size() 
                           + " nodes"); 
    } 
  
    // Prints the amount of edges 
    public void getEdgesCount(boolean bidirection) 
    { 
        int count = 0; 
        for (A n: map.keySet()) { 
            count += this.map.get(n).size(); 
        } 
        if (bidirection == true) { 
            count = count / 2; 
        } 
        System.out.println("The graph has "
                           + count 
                           + " edges."); 
    } 
  
    // Prints out whether a node is present or not. 
    public void hasNode(A s) 
    { 
        if (this.map.containsKey(s)) { 
            System.out.println("The graph contains "
                               + s + " as a node."); 
        } 
        else { 
            System.out.println("The graph does not contain "
                               + s + " as a node."); 
        } 
    } 
  
    // Prints out whether an edge is present or not. 
    public void hasEdge(A s, A d) 
    { 
        if (this.map.get(s).contains(d)) { 
            System.out.println("The graph has an edge between "
                               + s + " and " + d + "."); 
        } 
        else { 
            System.out.println("The graph has no edge between "
                               + s + " and " + d + "."); 
        } 
    }
    
    //Returns all the nodes of the graph in a set
    public Set<A> getAllNodes(){
    	return this.map.keySet();
    }
    
    // Traverse graph - returns a set of adjacent nodes
    public HashSet<A> traverse(A s) {
    	HashSet<A> ret = new HashSet<A>();
    	for(Pair<A, B> p: this.map.get(s)) {
    		ret.add(p.getValue0());
    	}
    	return ret;
    }
    
    // Traverse graph with edge filter - returns a set of adjacent nodes filtered by the edge property
    public HashSet<A> traverse(A s, B edgeProperty) {
    	HashSet<A> ret = new HashSet<A>();
    	for(Pair<A, B> p: this.map.get(s)) {
    		if(p.getValue1() == edgeProperty)
    			ret.add(p.getValue0());
    	}
    	return ret;
    }
  
    // Returns the adjancency list of each node as string. 
    @Override
    public String toString() 
    { 
        StringBuilder builder = new StringBuilder(); 
  
        for (A n : map.keySet()) { 
            builder.append("\n" + n.toString() + "\n"); 
            for (Pair<A,B> p : map.get(n)) { 
                builder.append("- " + p.getValue1().toString() + " -> " + p.getValue0().toString() + "\n"); 
            }  
        } 
  
        return (builder.toString());
    } 
}
