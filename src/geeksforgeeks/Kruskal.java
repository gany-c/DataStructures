package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Queue;



/**
 * Kruskal starts as a set of disjointed forests (could be)
 * and then merges together.
 * @author Ramanan
 *
 */

public class Kruskal {
	
	public Set<Edge> minSpanTree(List<Node> in){
		
		if(in==null||in.isEmpty())
			return null;
		
		Set<Edge> output = new HashSet<Edge>();
		List<Node> nodesOnly = getNodesOnly(in);
		
		Set<Edge> sortedEdges = getSortedEdges(in);
		
		
		
		System.out.println("sorted set of Edges = "+Arrays.toString(sortedEdges.toArray()));
		
		for(Edge edge:sortedEdges)
		{
			System.out.println("edge used = "+edge);
			
			
			addEdge(nodesOnly,edge);
			output.add(edge);
			
			boolean cyclic = isCyclic(output);
			
			System.out.println("cycle created = "+cyclic);
			
			if(cyclic)
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
		
	private void addEdge(List<Node> currentMST, Edge edge) {
		
		System.out.println("size of currentMST =  "+currentMST.size());
		
		for(Node nodeIn:currentMST){
			
			if(nodeIn.equals(edge.v1))
			{
				nodeIn.edges.add(edge);
				edge.v1 = nodeIn;
				System.out.println("Edge "+edge+" added as V1 to Node "+nodeIn);
			}
			
			if(nodeIn.equals(edge.v2))
			{
				nodeIn.edges.add(edge);
				edge.v2 = nodeIn;
				System.out.println("Edge "+edge+" added as V2 to Node "+nodeIn);
			}			
				
		}
		
	}
	
	/**
	 * check all the disjointed graphs
	 * @param input
	 * @return
	 */
	private boolean isCyclic(Set<Edge> input) {
		
		List<Node> nList= getExpNodes(input);
		System.out.println("nodes in the current spanning tree = "+Arrays.toString(nList.toArray()));
		
		
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


	/**
	 * Check one disjointed graph from its root
	 * @param root
	 * @param traverseList
	 * @return
	 */
	private boolean isCyclic(Node root, List<Node> traverseList) {
		
		System.out.println("root for cyclic check = "+root);
		
		Set<Edge> visitedEdges = new HashSet<Edge>();
		Queue<Node> candidNodes = new LinkedList<Node>();
		
		candidNodes.add(root);
		
		while(!candidNodes.isEmpty())
		{			
			Node node = candidNodes.poll();
			
			System.out.println("1. Node traversed for cyclic check = "+node);
			traverseList.add(node);	// Each time a node is pulled out of the queue
			//you add it to traverse list
			
			for(Edge e:node.edges)
			{
				System.out.println("2. "+node+"'s edge being traversed = "+e);
				
				//seeing an older node over the same edge is not a cycle
				if(visitedEdges.contains(e))
					continue;
				else
				{
					System.out.println("3. "+e+" has not been seen before");
					
					visitedEdges.add(e);
					Node nextNode = null;
					
					if(e.v1.equals(node))
						nextNode = e.v2;
					else
						nextNode = e.v1;
					
					System.out.println("4.  next node = "+nextNode);
					
					/**
					 * Check these conditions properly
					 */
					if(traverseList.contains(nextNode)||candidNodes.contains(nextNode))
					{	
						System.out.println(nextNode+" found in the already explored list "+Arrays.toString(traverseList.toArray()));
						return true;
					}	
					else
					{
						System.out.println(nextNode+" not found in the already explored list "+Arrays.toString(traverseList.toArray()));
						candidNodes.add(nextNode);
					}
									
				}			
				
			}			
			
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
			out.add(newN);
		}
		
		return out;
	}

	private Set<Edge> getSortedEdges(List<Node> in) {
		
		Set<Edge> output = new TreeSet<Edge>();
		
		for(Node inNode:in){
			
			for(Edge e:inNode.edges)
			{
				output.add(e.clone());
			}
			
		}
		
		return output;
	}
	
	private static List<Node> setupData(){
		
		Node node1 = new Node();
		node1.id = 100;
		
		Node node2 = new Node();
		node2.id = 200;
		
		Node node3 = new Node();
		node3.id = 300;
		
		Edge e1 = new Edge();
		e1.weight = 1;
		e1.v1 = node1;
		e1.v2 = node2;
		
		Edge e2 = new Edge();
		e2.weight =2;
		e2.v1 = node2;
		e2.v2 = node3;
		
		Edge e3 = new Edge();
		e3.weight =3;
		e3.v1 = node3;
		e3.v2 = node1;		
		
		node1.edges.add(e1);
		node1.edges.add(e3);
		
		node2.edges.add(e1);
		node2.edges.add(e2);
		
		node3.edges.add(e2);
		node3.edges.add(e3);
		
		List<Node> output = new ArrayList<Node>();
		output.add(node1);
		output.add(node2); 
		output.add(node3);
		
		return output;
		
	}

	public static void main(String[] args) {
		
		Kruskal k = new Kruskal();
		
		List<Node> input = setupData();
		
		Set<Edge> out = k.minSpanTree(input);
		
		System.out.println("-----------");
		for(Edge e:out){
			
			System.out.print(e.weight+"  ");
		}
		System.out.println("-----------");
		
		

	}

}
