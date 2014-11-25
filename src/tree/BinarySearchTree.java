package tree;

import base.TreeNode;


public class BinarySearchTree {
	
	private TreeNode header = new TreeNode();
	
	
	int rank = 0;
	boolean rankCrossed = false;
	int target = 0;
	
	public int getRank(int input){

		if(this.header ==null || this.header.getRight() == null)
			return Integer.MIN_VALUE;
		
		this.target = input;
		this.rank = 0;
		this.rankCrossed = false;
		
		getRank(this.header.getRight());
		
		return this.rank;
		
	}
	
	
	private void getRank(TreeNode node) {
		
		if(node.getLeft()!=null)
			getRank(node.getLeft());
		
		if(this.rankCrossed)
			return;
		
		if(node.getValue() < this.target)
		{
			this.rank++;
			
			if(node.getRight() != null)
				getRank(node.getRight());
		}
		
		else if (node.getValue() >= this.target)
		{
			this.rankCrossed = true;
			return;
		}
		
	}


	private int count = 0;
	private int targetCount = 0;
	private int result = Integer.MIN_VALUE;
	
	public  int findIthSmallest(int i){
		
		if(this.header ==null || this.header.getRight() == null)
			return Integer.MIN_VALUE;
		
		this.count = 1;
		this.targetCount = i;
		this.result = Integer.MIN_VALUE;
		
		findIthSmallest(this.header.getRight());
		
		return this.result;
	}

	
	private void findIthSmallest(TreeNode node) {
		
		if(node.getLeft() != null)
			findIthSmallest(node.getLeft());
		
		if(this.count < this.targetCount)
		{
			this.count++;
			if(node.getRight()!=null)
				findIthSmallest(node.getRight());
		}
		else if(this.count == this.targetCount)
		{
			this.result = node.getValue();
			this.count++;
			return;
		}
		else
			return;
		
	}


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
			//shouldn't this be return false?
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
	
	int inorderPrev = Integer.MIN_VALUE;
	boolean orderViolated = false;
	/**
	 * Create the inorder traversal and check if order is violated
	 * @return
	 */
	public boolean isValid(){
 
		if(this.header == null||this.header.getRight()==null)
			return true;
		
		inorderPrev = Integer.MIN_VALUE;
		orderViolated = false;
		
		isValid(this.header.getRight());
		
		return !orderViolated;
		
	}
	
	private void isValid(TreeNode node) {
		
		if(node.getLeft()!=null)
			isValid(node.getLeft());

		if(orderViolated)
			return;
		
		if(inorderPrev > node.getValue())
		{
			orderViolated =true;
			return;
		}
		else 
			inorderPrev = node.getValue();
		
		if(node.getRight()!=null)
			isValid(node.getRight());
		
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
		
		System.out.println("\n BST properties preserved? = "+bst.isValid());
		
		TreeNode wrongNode = new TreeNode();
		wrongNode.setValue(0);
		
		TreeNode temp = bst.header;
		
		while(temp.getRight()!=null)
			temp = temp.getRight();
		
		temp.setRight(wrongNode);
		
		System.out.println("\n BST properties preserved? = "+bst.isValid());
		
		temp.setRight(null);
		System.out.println("\n 1st smallest number = "+bst.findIthSmallest(1));
		System.out.println("\n 4st smallest number = "+bst.findIthSmallest(4));
		bst.insert(5);
		System.out.println("\n 1st smallest number = "+bst.findIthSmallest(1));
		bst.preOrder();
		
		System.out.println("\n Rank of 6 = "+bst.getRank(6));
		System.out.println("\n Rank of 22 = "+bst.getRank(22));
		
		System.out.println("\n Rank of 1000 = "+bst.getRank(1000));
		System.out.println("\n Rank of 4 = "+bst.getRank(4));
		
		
		
	}
}
