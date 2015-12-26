package tree;

import java.util.HashMap;
import java.util.Map;

import base.TreeNode;

public class TraversalTree2015 {
	
	public TreeNode constructTree(int[] preorder,int[] inorder) throws Exception{
		
		if(preorder == null || inorder == null || preorder.length ==0 || inorder.length != preorder.length)
			throw new Exception("Invalid traversal lists passed in");
		
		Map<Integer,Integer> inorderMap = getValue2IndexMap(inorder);
		
		return constructTree(preorder,inorderMap,0,preorder.length-1,0,preorder.length-1);
	}

	private TreeNode constructTree(int[] preorder, Map<Integer, Integer> inorderMap, int pStart, int pEnd, int iStart, int iEnd) throws InterruptedException {
		

		
		TreeNode root = new TreeNode();
		root.setValue(preorder[pStart]);
		
		if(pStart < pEnd)
		{
			int inorderPos = inorderMap.get(preorder[pStart]);		
			int leftTreeSize = inorderPos - iStart;			
			
			root.setLeft(constructTree(preorder,inorderMap,pStart + 1, pStart + leftTreeSize,iStart,inorderPos -1));
			
			if(pStart + leftTreeSize < pEnd){
				root.setRight(constructTree(preorder,inorderMap,pStart + leftTreeSize + 1, pEnd,inorderPos +1, iEnd));
			}
		}
		
		return root;
	}

	private Map<Integer, Integer> getValue2IndexMap(int[] inorder) {
		
		Map<Integer,Integer> output = new HashMap<Integer,Integer>();
		
		for(int i =0;i<inorder.length;i++){
			output.put(inorder[i], i);
		}
		
		return output;
	}

	public static void main(String[] args) {
		
		int[] inorderList = new int[]{8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15};
		int[] preorderList = new int[]{1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 13, 7, 14, 15};
		
		TraversalTree2015 util = new TraversalTree2015(); 

		try 
		{
			TreeNode node = util.constructTree(preorderList,inorderList);
			StaticTree tree = new StaticTree(node);
			tree.bFS();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
