package tree;

import base.TreeNode;


public class BinarySearchTree {
	
	TreeNode header = new TreeNode();

	
	public BinarySearchTree(){
		header.setValue(Integer.MIN_VALUE);
		//A header node above the root is needed because the root itself 
		// could be deleted
		// makes things simpler
	}
	
	
	public void preOrder(){
		System.out.println();
		preOrder(this.header.getRight());
	}
	
	 private  void preOrder(TreeNode input)
	 {
		if(input == null)
			return;
		else
		{
			System.out.print(input.getValue()+", ");
			preOrder(input.getLeft());
			preOrder(input.getRight());
		}
	 }	


	public void insert(int value){
		insertNode(header,value);
		//Can start at the header because all nodes will be 
		// greater and hence to its right
	}
	
	public boolean search(int value){
		
		//can start searching from the right of the header
		if(this.header.getRight()==null)		
			return false;
		else
			return search(this.header.getRight(),value);
	}
	
	private boolean search(TreeNode input, int value) {

		if(input.getValue()==value)
			return true;
		else if(input.getValue() < value)
		{
			if(input.getRight() == null)
				return false;
			else return search(input.getRight(), value);
		}
		else
		{
			if(input.getLeft() == null)
				return true;
			else return search(input.getLeft(),value);
		}
	}

	private void insertNode(TreeNode input,int value)
	{
		if(value<input.getValue())
		{
			if(input.getLeft()==null)
				input.setLeft(createNode(value));
			else
			    insertNode(input.getLeft(),value);	
		}
		else if(value>input.getValue())
		{
			if(input.getRight()==null)
				input.setRight(createNode(value));
			else
			    insertNode(input.getRight(),value);	
			
		}
		else
			return;
		//don't insert duplicates
	}

	private  TreeNode createNode(int value) {
		
		TreeNode out = new TreeNode();
		out.setValue(value);
		return out;
	}
	
	public  void delete(int target)
	{
		if(this.header.getRight() == null)
			return;

		System.out.println("deleting "+target);
		
		
		//The header itself could be the parent here
		//so we start from the header, not header.right()
		TreeNode parent = locateParent(this.header,target);
		if(parent == null)
			return;
		
		boolean leftSide = true;
		TreeNode targetNode = null;
		
		if(parent.getLeft()!=null&&parent.getLeft().getValue()==target)
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

	private TreeNode locateParent(TreeNode input,int target) {
		
		if(input==null)
			return null;
		else if((input.getLeft()!=null&&input.getLeft().getValue()==target)||
				(input.getRight()!=null&&input.getRight().getValue()==target))
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
	
	public static void main(String[] args){
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(3);
		bst.insert(100);
		bst.insert(11);
		
		
		bst.preOrder();
		
		bst.delete(50);
		
		System.out.println();
		
		bst.preOrder();
		
		bst.delete(3);
		System.out.println();
		
		bst.preOrder();
		
		System.out.println();
		System.out.println("Is 100 present = "+bst.search(100));
		
		
		System.out.println("Is 101 present = "+bst.search(101));
		
		bst.insert(11);
		bst.preOrder();
		
		bst.insert(7);
		bst.preOrder();
		
		bst.insert(105);
		bst.preOrder();
		
		
	}
}
