package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private char data;
	private List<Node> edges = new ArrayList<Node>();
	
	public Node(char data) {
		this.data = data;
	}
	
	public char getData() {
		return data;
	}
	
	public void setData(char data) {
		this.data = data;
	}
	
	public List<Node> getEdges() {
		return edges;
	}
	
	public void setEdges(Node edge) {
		this.edges.add(edge);
	}

}
