package tree;

import base.TreeNode;


public class BinaryTree {
	
	TreeNode root;
	
	public BinaryTree(int[] source){
		
		this.root = null;
	}

	public void insert(int value){
		insertNode(root,value);
	}
	
	private void insertNode(TreeNode input,int value)
	{
		if(input == null)
		{
			this.root = createNode(value);
		}		
		else if(value<input.getValue())
		{
			if(input.getLeft()==null)
				input.setLeft(createNode(value));
			else
			    insertNode(input.getLeft(),value);	
		}
		else
		{
			if(input.getRight()==null)
				input.setRight(createNode(value));
			else
			    insertNode(input.getRight(),value);	
			
		}
	}

	private  TreeNode createNode(int value) {
		
		TreeNode out = new TreeNode();
		out.setValue(value);
		return out;
	}
	
	public  void delete(int target)
	{
		TreeNode parent = locateParent(root,target);
		
		boolean leftSide = true;
		TreeNode targetNode = null;
		
		if(parent.getLeft().getValue()==target)
		{
			leftSide = true;
			targetNode = parent.getLeft();
		}			
		else
		{	
			leftSide = false;
			targetNode = parent.getRight();
		}	
		
		
		if(targetNode.getLeft()==null&&targetNode.getRight()==null)
		{			
			setDesc(parent,leftSide,null);
			return;
		}
		else if(targetNode.getLeft()!=null&&targetNode.getRight()!=null)
		{
			TreeNode leftBranch = targetNode.getLeft();
			TreeNode leftExtremeOfRight = findLeftEnd(targetNode.getRight());				
			leftExtremeOfRight.setLeft(leftBranch);				
			targetNode.setLeft(null);
			
			setDesc(parent,leftSide,targetNode.getRight());			
			
		}
		else if(targetNode.getLeft()!=null)
		{
			TreeNode desc = targetNode.getLeft();			
			setDesc(parent,leftSide,desc);
		}
		else if(targetNode.getRight()!=null)
		{
			TreeNode desc = targetNode.getRight();
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

	private  TreeNode locateParent(TreeNode input,int target) {
		
		if(input==null)
			return null;
		else if(input.getLeft().getValue()==target||input.getRight().getValue()==target)
			return input;		
		else 
		{
			TreeNode output = locateParent(input.getLeft(),target);
			if(output!=null)
				return output;
			else
			{
				return locateParent(input.getRight(),target);
			}
		}
		
	}
	
	private  TreeNode findLeftEnd(TreeNode node)
	{
		while(node.getLeft()!=null)
		{	 		
	 		node = node.getLeft();
		} 
		return node;
	} 
}
