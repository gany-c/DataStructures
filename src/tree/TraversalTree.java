package DS.tree;

import java.util.HashMap;

import DS.base.TreeNode;

public class TraversalTree {
	
	private static TreeNode createTree(int[] preorder,int[] inorder,int start, int end)
	{
		HashMap preorderPosMap = getPosMap(preorder);
		
		return createTree(preorderPosMap,inorder,start, end);
	}

	private static TreeNode createTree(HashMap preorderPosMap, int[] inorder,
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

	private static int lowestPreOrderPos(HashMap preorderPosMap, int[] inorder,int start, int end) {
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

	private static HashMap getPosMap(int[] preorder) {
		
		HashMap posMap = new HashMap();
		
		for(int i=0;i<preorder.length;i++)
		{
			posMap.put(preorder[i], i);
			
		}
		
		return posMap ;
	}

}
