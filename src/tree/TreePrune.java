package DS.tree;

import DS.base.TreeNode;
import DS.base.UtilityStack;

public class TreePrune {
	
	//The tree needs a header over the root, because the root itself can change.
	//
	private static TreeNode createTree(int[] source,int index,boolean createHead)
	{
	  if((source==null)||(source.length==0))
		return null;
	  else
	  {
		  
		TreeNode out = new TreeNode();		  
		  
		if(!createHead)
			out.setValue(source[index]);
		else
		{	
			out.setValue(Integer.MIN_VALUE);
			out.setRight(new TreeNode());
			
			out = out.getRight();
			out.setValue(source[index]);
		}	
		
		int leftIndex = 2*index;
		int rightIndex = leftIndex+1;

		if(leftIndex<source.length)
		{
			out.setLeft(createTree(source,leftIndex,false));
		}

		if(rightIndex<source.length)
		{
			out.setRight(createTree(source,rightIndex,false));
		}

		return out;
	  } 
	}
	
	private static void insertNode(TreeNode root,int value)
	{
		if(value<root.getValue())
		{
			if(root.getLeft()==null)
				root.setLeft(createNode(value));
			else
			    insertNode(root.getLeft(),value);	
		}
		else
		{
			if(root.getRight()==null)
				root.setRight(createNode(value));
			else
			    insertNode(root.getRight(),value);	
			
		}
	}

	private static TreeNode createNode(int value) {
		
		TreeNode out = new TreeNode();
		out.setValue(value);
		return out;
	}
	
	private static void deleteNode(TreeNode root, TreeNode target)
	{
		TreeNode parent = locateParent(root,target);
		
		boolean leftSide = true;
		
		if(parent.getLeft()==target)
			leftSide = true;
		else
			leftSide = false;
		
		
		if(target.getLeft()==null&&target.getRight()==null)
		{			
			setDesc(parent,leftSide,null);
			return;
		}
		else if(target.getLeft()!=null&&target.getRight()!=null)
		{
			TreeNode leftBranch = target.getLeft();
			TreeNode leftExtremeOfRight = findLeftEnd(target.getRight());				
			leftExtremeOfRight.setLeft(leftBranch);				
			target.setLeft(null);
			
			setDesc(parent,leftSide,target.getRight());			
			
		}
		else if(target.getLeft()!=null)
		{
			TreeNode desc = target.getLeft();			
			setDesc(parent,leftSide,desc);
		}
		else if(target.getRight()!=null)
		{
			TreeNode desc = target.getRight();
			parent.setLeft(desc);
			setDesc(parent,leftSide,desc);
		}			
			
		
		
	}

	private static void setDesc(TreeNode parent, boolean leftSide,
			TreeNode desc) {
		
		if(leftSide)
			parent.setLeft(desc);
		else
			parent.setRight(desc);
		
	}

	private static TreeNode locateParent(TreeNode root, TreeNode target) {
		
		if(root==null)
			return null;
		else if(root.getLeft()==target||root.getRight()==target)
			return root;		
		else 
		{
			TreeNode output = locateParent(root.getLeft(),target);
			if(output!=null)
				return output;
			else
			{
				return locateParent(root.getRight(),target);
			}
		}
		
	}
	
	private static TreeNode findLeftEnd(TreeNode node)
	{
		while(node.getLeft()!=null)
		{	 		
	 		node = node.getLeft();
		} 
		return node;
	} 
}
