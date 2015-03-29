package geeksforgeeks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import java.util.Queue;





public class Kruskal {
	
	public Set<Edge> minSpanTree(List<Node> in){
		
		if(in==null||in.isEmpty())
			return null;
		
		Set<Edge> output = new HashSet<Edge>();
		List<Node> nodesOnly = getNodesOnly(in);
		
		Set<Edge> sortedEdges = getSortedEdges(in);
		
		for(Edge edge:sortedEdges)
		{
			output.add(edge);
			addEdge(nodesOnly,edge);
			
			if(isCyclic(output))
			{
				output.remove(edge);
				removeEdge(nodesOnly,edge);
			}
		
		}
	
		return output;
	}

	private void removeEdge(List<Node> nodesOnly, Edge edge) {
		
		for(Node nodeIn:nodesOnly){
			
			if(nodeIn.equals(edge.v1)||nodeIn.equals(edge.v2))
				nodeIn.edges.remove(edge);
		}
		
	}	
		
	private void addEdge(List<Node> nodesOnly, Edge edge) {
		for(Node nodeIn:nodesOnly){
			
			if(nodeIn.equals(edge.v1)||nodeIn.equals(edge.v2))
				nodeIn.edges.add(edge);
		}
		
	}
	
			


	private boolean isCyclic(Set<Edge> input) {
		
		List<Node> nList= getExpNodes(input);
		
		while(!nList.isEmpty())
		{
			
			Node node = nList.get(0);
			List<Node> traverseList = new ArrayList<Node>();
			
			
			if(isCyclic(node,traverseList))
				return true;
			else
			{
				nList.removeAll(traverseList);
			}
	
			
		}
	
		return false;
	}



	private boolean isCyclic(Node root, List<Node> traverseList) {
		
		Set<Edge> visitedEdges = new HashSet<Edge>();
		Queue<Node> candidNodes = new LinkedList<Node>();
		
		candidNodes.add(root);
		
		while(!candidNodes.isEmpty()){
			
			Node node = candidNodes.poll();
			
			for(Edge e:node.edges)
			{
				if(visitedEdges.contains(e))
					continue;
				else
				{
					visitedEdges.add(e);
					Node nextNode = null;
					
					if(e.v1.equals(node))
						nextNode = e.v2;
					else
						nextNode = e.v1;
					
					if(traverseList.contains(nextNode))
						return true;
					else
						candidNodes.add(nextNode);
			
				}	
				
				
			}
			
			traverseList.add(node);
	
		}
		
		
		return false;
	}

	private List<Node> getExpNodes(Set<Edge> input) {
		
		Set<Node> expNodes = new HashSet<Node>();
		
		for(Edge e:input){
			expNodes.add(e.v1);
			expNodes.add(e.v2);
		}
		
		List<Node> output = new ArrayList<Node>();
		output.addAll(expNodes);
		
		return output;
	}

	private List<Node> getNodesOnly(List<Node> in) {
		
		List<Node> out = new ArrayList<Node>();
		
		for(Node node:in){
			
			Node newN = new Node();
			newN.id = node.id;
		}
		
		return out;
	}

	private Set<Edge> getSortedEdges(List<Node> in) {
		
		Set<Edge> output = new TreeSet<Edge>();
		
		for(Node inNode:in){
			
			output.addAll(inNode.edges);
			
		}
		
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
