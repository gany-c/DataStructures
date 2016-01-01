package tree;

import base.TreeNode;


public class BinarySearchTree {
	/*
	 * 1. create instance variables for 
	 * header, rank, rankCrossed and target.
	 */
	 
	private TreeNode header = new TreeNode();
	
	
	int rank = 0;
	boolean rankCrossed = false;
	int target = 0;
	
	/**
	 * RANK = (Number of elements in the tree which are smaller than the given element) 
	 * 1. Check if the header node or its right child is null,
	 * 1.a. then it is an empty tree, return.
	 * 2. Initialize the values for target, rank and rankCrossed
	 * 3. call the recursive getRank function.
	 * 
	 * 1. This function follows the Inorder paradigm
	 * 2. Make a recursive call to the left child.
	 * 3. Check if rank has been crossed; if yes, then return.
	 * 4. Check if the parameter value is lesser than target value, 
	 * 4.1. if yes increment the rank and make a recursive call to the right child if it is not null
	 * 4.2. if the rank hasn't been crossed and if the current parameter value is greater or equal to target value
	 * 4.2.1. set the rank crossed as true and return.
	 * 
	 */
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
	
	/**
	 * 1. if the header is null or its right is null return 
	 * 2. initialize the count to 1, the targetCount to the input paramter and result to min value.
	 * 3. Call the recursive overloaded method with the header's right.
	 * 
	 * 1. Follow the inorder paradigm
	 * 2.  if the left is not null, invoke the same method on the left child.
	 * 3. if count so far, is still lesser than target
	 * 3.1. increment the count
	 * 3.2. if the right sub child is not null, recursively invoke it..
	 * 4. if count has arrived at the target, 
	 * 4.1. set the result to be the current node's value.
	 * 4.2. increment the count -- this indicates that the target has been found to the lower nodes.
	 * 5. Else - count has gone past -- target has been found in a lower node -- return without doing anything.
	 * 
	 * @param i
	 * @return
	 */
	
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

	/**
	 * 1. As usual, check the header and its right node for being null. Else call the recursive search function.
	 * 
	 * 1. if the input node's value and the supplied value are the same, return true.
	 * 2. Else if the input node's value is less than parameter value
	 * 2.1. If the right side is null then return false
	 * 2.2. else recursively invovke the function on the right child.
	 * 3. Else
	 * 3.1. If the left child is null 
	 * 3.2. return false
	 * 3.3. recursively invoke the function on the left side.
	 * @param value
	 * @return
	 */
	public boolean search(int value){
		
		//can start searching from the right of the header
		if(this.header == null || this.header.getRight()==null)		
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

	/**
	 * 1. Invoke the recursive insertion function with the header node - same as invoking on its right.
	 * 
	 * 1. if passed in value is lesser than the current node, 
	 * 1.1. Check if the left node is null
	 * 1.2. if yes, then create a node for the value and set left as this node
	 * 1.3. else, make a recursive call to the left child.
	 * 
	 * 2. Else (Departure from not inserting duplicates as shown below)
	 * 2.1. check if the node's right is null
	 * 2.2. if yes, then create a node for the value and set it on the node's right.
	 * 2.3. else make a recursive call for the node's right.
	 * @param value
	 */
	public void insert(int value){
		insertNode(header,value);
		//Can start at the header because all nodes will be 
		// greater and hence to its right
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
	
	/**
	 * 1. If the tree's header or it's right is null return.
	 * 2. Locate the tree's parent and 
	 * 2.1. create a variable for this node being left or right child
	 * 2.2. create variables for the parent and target nodes.
	 * 3. If the target node is a leaf - then set null as the parent's new descendant 
	 * The side is based on the boolean variable 2.1.
	 * 3.1. If the target node has both branches
	 * 3.2. Find the left most node on the right side. -= LEFT END
	 * 3.3. Make the left child of target, the left child of LEFT END
	 * 3.4. Make the right child of target, the child of parent node based on the variable 2.1.
	 * 4. If the target has just one child, left or right
	 * 4.1. Make the child the descendant of the parent.
	 *
	 * @param target
	 */
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
	 * 1. Create the inorder traversal and check if order is violated
	 * 2. Don't do the mistake of just checking the immediate children
	 * 
	 * 1. Create instance variables for Inorder ancestor and order being violated.
	 * 2. Check if the header or its right child is null, else invoke the recursive function
	 * 
	 * 1. Invoke the self function on the left child if it is not null.
	 * 2. When it returns check if the global order violation variable is set, if yes return
	 * 2.1. Else, compare the global value with the current node value, if there is a violation return.
	 * 2.2. Else, record the current node value as the global value and invoke on the right child of current node.
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
