package Graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BST {

	public static void main(String[] args) {
		
		Set<Character> visited = new HashSet<Character>();
		Stack<Node> helperStack = new Stack<Node>();
		
		/**
		 * Adding data to the graph
		 */
		Node ANode = new Node('A');
		Node BNode = new Node('B');
		Node CNode = new Node('C');
		Node DNode = new Node('D');
		Node GNode = new Node('G');
		Node HNode = new Node('H');
		Node RNode = new Node('R');
		Node KNode = new Node('K');
		
		addEdge(ANode, BNode);
		addEdge(ANode, HNode);
		
		addEdge(BNode, DNode);
		addEdge(BNode, CNode);
		
		addEdge(CNode, RNode);
		addEdge(CNode, KNode);
		
		addEdge(HNode, GNode);
		
		dfs(ANode, visited, helperStack);
		
	}
	
	public static void addEdge(Node u, Node w) {
		w.setEdges(u);
		u.setEdges(w);
	}

	public static void dfs(Node node, Set<Character> visited, Stack<Node> hstack) {
		hstack.push(node);
		visited.add(node.getData());
		System.out.print(node.getData() + " ");
		
		while(!hstack.isEmpty()) {
			List<Node> edges = hstack.peek().getEdges();
			
			int hasEdgesCounter = 0;
			for(int i = 0; i < edges.size(); i++) {
				if(!visited.contains(edges.get(i).getData())) {
					dfs(edges.get(i), visited, hstack);
				}
				else {
					hasEdgesCounter++;
				}
			}
			
			if(hasEdgesCounter == edges.size()) {
				if(!hstack.isEmpty())
					hstack.pop();
			}
			
		}
	}

}
