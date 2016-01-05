package tree;

import java.util.HashMap;
import java.util.Map;

import base.TreeNode;

/**
 * 
 * @author Ramanan
 * 
 * 1. Given the preorder and inorder traversals of a tree, reconstruct it.
 * 
 * 1. Create a map of the preorder elements to their indices
 * 2. Call the recursive  create tree function with
 * 2.1. the newly created map
 * 2.2. the inorder list and 0 and list length as start and end.
 * 
 *  createTree FUNCTION:- 
 * 1. Within the start and end limits supplied, find the element with the lowest preorder position
 * 1.a This is the inorder position of the element with the lowest preorder postion.
 * 2. Create a node with the value at this position.
 * 3. If this  inorder-position is greater than start, recursively invoke this function for the left child node.
 * 4. If the inorder-position is lesser than end, recursively invoke this function for the right child.
 * 
 * FUNCTION lowestPreOrderPos:-
 * 
 * 1. Create 2 variables, one for the inorder index and second for minimum preorder value.
 * 2. Traverse the inorder list from start to end, inclusive.
 * 2.1. Get the element and the index and get's preorder position
 * 2.2. If the preorder index is lesser than stored one, update both the inorder and preorder min indices.
 * 3. return the stored inorder index.
 *
 */
public class TraversalTree {
	
	public static TreeNode createTree(int[] preorder,int[] inorder)
	{
		Map<Integer,Integer> preorderPosMap = getPosMap(preorder);
		
		return createTree(preorderPosMap,inorder,0, inorder.length-1);
	}

	private static TreeNode createTree(Map<Integer,Integer> preorderPosMap, int[] inorder,
			int start, int end) {
		
		int rootLocation = lowestPreOrderPos(preorderPosMap,inorder,start,end);
		
		TreeNode root = createNode(inorder[rootLocation]);
		
		if(start<rootLocation)
			root.setLeft(createTree(preorderPosMap,inorder,start, rootLocation-1));
		
		if(rootLocation<end)
			root.setRight(createTree(preorderPosMap,inorder,rootLocation+1, end));
		
		
		
		return root;
	}

	private static TreeNode createNode(int i) {
		
		TreeNode node = new TreeNode();
		node.setValue(i);
		
		return node;
	}

	private static int lowestPreOrderPos(Map<Integer,Integer> preorderPosMap, int[] inorder,int start, int end) {
		int min = Integer.MAX_VALUE;
		int minpos = -1;
		
		for(int i=start;i<=end;i++)
		{
			int preOrderPosition = (Integer)preorderPosMap.get(inorder[i]);//auto-boxing
			
			if(preOrderPosition<min)
			{
				min = preOrderPosition;
				minpos = i;
			}
		}
		
		return minpos;
	}

	private static Map<Integer,Integer> getPosMap(int[] preorder) {
		
		Map<Integer,Integer> posMap = new HashMap<Integer,Integer>();
		
		for(int i=0;i<preorder.length;i++)
		{
			posMap.put(preorder[i], i);
			
		}
		
		return posMap ;
	}
	
	public static void main(String[] args){
		
		int[] inorderList = new int[]{8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15};
		int[] preorderList = new int[]{1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 13, 7, 14, 15};
		
		TreeNode node = createTree(preorderList,inorderList);
		
		StaticTree tree = new StaticTree(node);
		tree.bFS();
		
	}

}
