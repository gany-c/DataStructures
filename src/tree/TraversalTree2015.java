package tree;

import java.util.HashMap;
import java.util.Map;

import base.TreeNode;

public class TraversalTree2015 {
	
	/**
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 * @throws Exception
	 * 
	 * THIS METHOD IS ESSENTIALLY SIZE BASED
	 *  -- CALCULATE THE NUMBER OF ELEMENTS IN THE LEFT AND RIGHT SUBTREE USING THE INORDER
	 *  -- SPLIT, THE PREORDER BASED ON THAT.
	 *  
	 *  YOU HAVE TO PASS FOUR INDEXES.
	 * 
	 * 1. if the preorder or inorder list is null or empty or they have a size discrepancy throw an exception.
	 * 2. Get a value to index map of the inorder positions.
	 * 3. Invoke the construct tree function with the preorder list, inorder map, 2 starts and ends for preorder and inorder.
	 * 
	 * FUNCTION - constructTree
	 * 1. create a node with value at preorder start.
	 * 2. if preorder start < end
	 * 2.1. get the inorder position of the preorder start i.e. root.
	 * 2.2. subtract from the inorder start to get size ## Shouldn't you add 1 here? 
	 * 	- No because, you don't want to include the root.
	 * 2.3. invoke the function recursively for the left side.
	 * 2.4. --- with preorder start +1, start + left tree size
	 * 2.5. --- and inoder start and inorder pos +1
	 * 3. If there are elements on the right side
	 * invoke the constructTree function recursively.
	 * 
	 * 
	 */
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
