package tree;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;

import base.IntWrapper;
import base.TreeNode;

/**
 * 
 * @author gchidam
 *
 * Huge class, see method level comments.
 */
public class StaticTree{

// The tree does not need a header over the root, because we are //dealing only with traversal functions, the root itself does not //change.
	
private TreeNode root = null;

public StaticTree(TreeNode node){
	this.root = node;
}

public StaticTree(int[] source){
	 
	this.root = createTree(source, 0);
}

/**
 * 
 * @param source
 * @param index
 * @return
 * 
 * create pointer based tree from array based tree
 */
private static TreeNode createTree(int[] source,int index)
{
  if((source==null)||(source.length==0))
	return null;
  else
  {
	TreeNode out = new TreeNode();
	out.setValue(source[index]);
	
	int leftIndex = 2*index+1;
	int rightIndex = leftIndex+1;

	if(leftIndex<source.length)
	{
		out.setLeft(createTree(source,leftIndex));
	}

	if(rightIndex<source.length)
	{
		out.setRight(createTree(source,rightIndex));
	}

	return out;
  } 
}

/**
 * 
 * @param input
 * 
 * Preorder traversal: print root value, then visit left, then visit right.
 */
 public static void preOrder(TreeNode input)
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
  * 
  * @param input
  * 
  * In order traversal: recursively visit left, print value, recursively visit right.
  */
 public static void inOrder(TreeNode input)
 {
	if(input == null)
		return;
	else
	{
		
		inOrder(input.getLeft());
		System.out.print(input.getValue()+", ");
		inOrder(input.getRight());
	}	
 }

 /**
  * 
  * @param input
  * 
  * Post order traversal: recursively visit left, recursively visit right, print value.
  */
public static void postOrder(TreeNode input)
 {
	if(input == null)
		return;
	else
	{
		
		postOrder(input.getLeft());
		postOrder(input.getRight());
		System.out.print(input.getValue()+", ");		
	}	
 } 

/**
 * Iterative PreOrder: 
 * 1. Create a stack
 * 2. Push the root into the stack
 * 3. While stack is not empty
 * 3.a. pop the element from the stack
 * 3.b. print its value
 * 3.c. if the right is not null, push it into the stack
 * 3.d. if the left is not null, push it on top of the right.
 */
public void iterativePreOrder()
{
	if(root == null)
		 return;
	else
	{
  	Stack<TreeNode> stack = new Stack<TreeNode>();
  	stack.push(root);
  	while(!stack.isEmpty())
  	{
 		TreeNode node = (TreeNode)stack.pop();

   			System.out.print(node.getValue()+", ");
   			
   			if(node.getRight()!=null)
   				stack.push(node.getRight()); 
   			
  			if(node.getLeft()!=null)
  				stack.push(node.getLeft());


 		
      }
	}
}

/**
 * Iterative In order
 * 1. Create a stack
 * 2. Push left nodes into the stack until you hit the left extreme.
 * 3. While the stack is not empty
 * 3.a. Pop the node and print it.
 * 3.b. if the node has a right child, push all it's left children into the stack.
 */
public void iterativeInOrder()
{
	if(root == null)
 		return;
	else
	{
		 Stack<TreeNode> stack = new Stack<TreeNode>();
	 	 pushLefts(stack,root);
	 	 while(!stack.isEmpty())
	 	 {
	 		TreeNode node = (TreeNode)stack.pop();
	
	   			System.out.print(node.getValue()+", ");
	  			if(node.getRight()!=null)
	 				 pushLefts(stack,node.getRight());
	 		
	  	}
	}
}

/**
 * Breadth first search
 * 
 * 1. create a Queue
 * 2. add the root into the queue
 * 3. while the queue is not empty
 * 3.a. poll the queue and get the first node out, print the value
 * 3.b. if left is not null, add it to the queue; if the right is not null, add it to the queue.
 * 
 * In general, BFS will finish the nodes of one level and then visit the next level, but cannot tell when it is transiting from a level to another..
 */
public void bFS(){
	
	System.out.println("\n Starting Breadth First Search");
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	q.add(this.root);
	
	while(!q.isEmpty()){
		
		TreeNode node = q.poll();
		System.out.print(node.getValue()+", ");

		if(node.getLeft()!=null)
			q.add(node.getLeft());		
		
		if(node.getRight()!=null)
			q.add(node.getRight());
				
	}
	
}

/**
 * Printing Levels:
 * 
 * 1. Do breadth first search with 2 queues
 * 2. Initialize 2 queues and add the root to the first queue
 * 3. while the first queue is not empty (actually, when no children have beeen added to the second queue)
 * 3.a. get the element out of the first queue, print its value
 * 3.b. if the left and right are available add them to the next queue
 * 3.c. if you have drained the first queue, add a line break, and set the second queue as the first.
 */
public void printLevels(){
	
	System.out.println("\n Printing tree levels");
	Queue<TreeNode> thisLevel = new LinkedList<TreeNode>();
	thisLevel.add(this.root);
	
	Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
	
	while (!thisLevel.isEmpty())//after iteration 1, it is actually a check on nextLevel
	{
		TreeNode node = thisLevel.poll();
		System.out.print(node.getValue()+", ");
		
		if(node.getLeft()!=null)
			nextLevel.add(node.getLeft());
		
		if(node.getRight()!=null)
			nextLevel.add(node.getRight());
		
		if(thisLevel.isEmpty())
		{
			System.out.println();
			thisLevel = nextLevel;
			nextLevel =  new LinkedList<TreeNode>();
		}
		
	}
	
}

/**
 * Depth First Search is identical to preorder
 * Below, you have iterative Preorder.
 */

public void dFS(){
	
	System.out.println("\n Starting Depth First Search");
	Stack<TreeNode> stack = new Stack<TreeNode>();
	stack.push(this.root);
	
	while(!stack.isEmpty()){
		
		TreeNode node = stack.pop();
		System.out.print(node.getValue()+", ");
		
		
		if(node.getRight()!=null)
			stack.push(node.getRight());
		
		if(node.getLeft()!=null)
			stack.push(node.getLeft());

		
	}
	
	
}

/**
 *  Print all paths to leaves:
 *  1. Start at the root with an empty path
 *  2. At each node, add the current value to the path, with a separator 
 *  3. Recursively, call this method for left child and/or right child 
 *  4. If neither, left or right is present, print the path and exit recursion
 */
public void printPathToLeaves(){
	if(this.root == null)
		return;
	else printPathToLeaves(this.root, "");
}

private void printPathToLeaves(TreeNode node,String path) {

	path = path + "-"+node.getValue();
	
	if(node.getLeft()==null && node.getRight()==null)
	{
		System.out.println(path);
		return;
	}
		
	if(node.getLeft()!=null)
		printPathToLeaves(node.getLeft(),path);
	
	if(node.getRight()!=null)
		printPathToLeaves(node.getRight(),path);
	
}

/**
 * Iterative post order: Excellently done
 * 
 * 1. Create an empty stack of nodes and an empty set of nodes.
 * 2. Push the root into the stack, and navigate to the left most 
 * 3. While stack is not empty
 * 3.a. Pop a node from the stack
 * 3.b. If this node is not contained in right explored and its right node is not null
 * 3.b.a push the node into the stack and push to the left most end of its right sub tree
 * 3.b.b mark the node as right explored.
 * 3.b. - else print the value at the node and continue recursion
 */
public void iterativePostOrder()
{
	if(root == null)
 		return;
	else
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();
 	    pushLefts(stack,root);
  		Set<TreeNode> rightExplored = new HashSet<TreeNode>();

 		while(!stack.isEmpty())
        {
			TreeNode node = (TreeNode)stack.pop();
 
			if((node.getRight()!=null)&&(!rightExplored.contains(node)))
			{
				stack.push(node);
         		pushLefts(stack,node.getRight());
				rightExplored.add(node);
   			}
			else
			{
				System.out.print(node.getValue()+", ");
			} 
	
			
        }
	}
}

private void pushLefts(Stack<TreeNode> stack, TreeNode node)
{
	while(node!=null)
	{
 		stack.push(node);
 		node = node.getLeft();
	} 
}

private boolean targetFound = false;
private int successor = Integer.MIN_VALUE;

/**
 * 
 * @param target
 * @return
 * 
 * 1. set 2 flags targetFound, successor; initialize them to false, null
 * 2. Recursively call the left sub child
 * 3. Next, if successor has been found return;
 * 3.b els if the target has been found mark the current value as successor and return
 * 3.c. if the current value equals the target, mark the target found flag
 * 4. If right is not null, recursively invoke right.
 */

public int  inorderSuccessor(int target){
	
	this.targetFound = false;
	this.successor = Integer.MIN_VALUE;
	
	if(this.root != null)
		inorderSuccessor(this.root,target);
	
	return this.successor;
 
}

private void inorderSuccessor(TreeNode input,int target)
{

	if(input.getLeft()!=null)
	{
		inorderSuccessor(input.getLeft(),target);

	}
	
	if(successor!=Integer.MIN_VALUE)
		return;	
	else if(this.targetFound){
		this.successor =  input.getValue();
		return;
	}	
	else 
	{	
		
		
		if(input.getValue()==target)
			this.targetFound = true;
		
		if(input.getRight()!=null)
			 inorderSuccessor(input.getRight(), target);

	}
}

/**
 * 
 * @return
 * 
 * Finding the max height - recursively call left and right height functions and return the max plus 1
 * if both left and right child are missing return 0; if only one is missing invoke on that alone.
 */
public int maxHeight(){
	return maxHeight(this.root);
}

private int maxHeight(TreeNode in){
	
	if(in.getLeft()==null&&in.getRight()==null)
		return 0;
	else if(in.getLeft()!=null&&in.getRight()!=null)
	{
		int leftHeight = maxHeight(in.getLeft());
		int rightHeight = maxHeight(in.getRight());
		
		if(leftHeight>rightHeight)
			return leftHeight +1;
		else 
			return rightHeight +1;
	}
	else if(in.getLeft()!=null)
	{
		return maxHeight(in.getLeft())+1;		
	}
	else
	{
		return maxHeight(in.getRight())+1;	
	}
}

/**
 * 
 * @param input
 * @return
 * 
 * Creating a mirror tree
 * 
 * 1. Clone the root node
 * 2. recursively call the mirror on the right subchild and set it to the left of the output
 * 3. recursively call the mirror on the left subchild and set it to the right of the output
 */
private TreeNode createMirror(TreeNode input){
	
	if(input==null)
		return null;
	else
	{
		TreeNode output = new TreeNode();
		output.setValue(input.getValue());
		
		output.setLeft(createMirror(input.getRight()));
		output.setRight(createMirror(input.getLeft()));
		
		return output;
	}
}

public StaticTree getMirror(){
	
	if(this.root == null)
		return null;
	else
	{
		return new StaticTree(createMirror(this.root));
	}
		
}

/**
 * Zig zag sort is similar to Print levels, 
 * But simply reversing the intermediate queue at every iteration alone won't help
 * Because, the code structure still explores left child and right child. 
 * So another boolean flag is needed to push right child and then left child.
 * 
 * TRY THE 2 STACKS APPROACH - SEEMED GOOD ON PEN AND PAPER
 */
public void zigZagStart(){

	Queue<TreeNode> start = new LinkedList<TreeNode>();
	start.add(root);
	StaticTree.zigZag(start,true);
}


private static void zigZag (Queue<TreeNode> q,boolean leftFirst){

	
	Stack<TreeNode> temp = new Stack<TreeNode>();
	
	
	while(!q.isEmpty())
	{
		TreeNode node = q.poll();
	
		System.out.println(node.getValue());	
	
		 if(node.getLeft() != null && leftFirst)
		     temp.push(node.getLeft());
	     
		 if(node.getRight()!=null);
	      temp.push(node.getRight());  
	      
	    if(node.getLeft() != null && !leftFirst)
	     temp.push(node.getLeft());   
	    
	    
	
	}
	
	if(!temp.isEmpty())
	{
		Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();
		 
		while(!temp.isEmpty()){
			nextQueue.add(temp.pop());
		}

		zigZag(nextQueue,!leftFirst);
	}
}

/**
 * Deep clone is also similar to pre order, clone the current node, call deep clone function on the left and right sub trees.
 */
public StaticTree clone(){
	
	StaticTree cloneTree = new StaticTree(deepClone(this.root));
	return cloneTree;
}

private void reset(TreeNode node) {


	node.setValue(0);
	
	if(node.getLeft()!=null)
		reset(node.getLeft());
	
	if(node.getRight()!=null)
		reset(node.getRight());
	

}


private TreeNode deepClone(TreeNode node) {

	TreeNode newNode = new TreeNode();
	newNode.setValue(node.getValue());
	
	if(node.getLeft()!=null)
		newNode.setLeft(deepClone(node.getLeft()));
	
	if(node.getRight()!=null)
		newNode.setRight(deepClone(node.getRight()));
	
	return newNode;
}

public static void main(String[] args){
	
	System.out.println("Hi----------");
	
	StaticTree tree = new StaticTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
	
	System.out.println("\n DFS----------");
	tree.dFS();
	System.out.println("\n BFS----------");
	tree.bFS();
	
	StaticTree tree2 = tree.clone();
	tree.reset(tree.root);
	System.out.println("\n after reset----------");
	tree.bFS();
	System.out.println("\n cloned tree----------");
	tree2.bFS();
	
	System.out.println("\n PreOrder ----------");
	StaticTree.preOrder(tree2.root);
	
	System.out.println("\n Iterative PreOrder ----------");
	tree2.iterativePreOrder();
	
	System.out.println("\n Inorder ----------");
	StaticTree.inOrder(tree2.root);
	
	System.out.println("\n Iterative Inorder ----------");
	tree2.iterativeInOrder();
	
	System.out.println("\n Post Order ----------");
	StaticTree.postOrder(tree2.root);	
	
	System.out.println("\n Iterative Post Order ----------");
	tree2.iterativePostOrder();	
	
	System.out.println("\n Inorder Successor of  ----------11");
	System.out.println(tree2.inorderSuccessor(11));	
	
	System.out.println("\n Inorder Successor of  ----------13");
	System.out.println(tree2.inorderSuccessor(13));	
	
	System.out.println("\n Inorder Successor of  ----------15");
	System.out.println(tree2.inorderSuccessor(15));
	
	System.out.println("\n Inorder Successor of  ----------14");
	System.out.println(tree2.inorderSuccessor(14));	
	
	StaticTree tree3 = tree2.getMirror();
	System.out.println("\n BFS of new tree  ----------");
	tree3.bFS();
	System.out.println("\n BFS of old tree  ----------");
	tree2.bFS();
	System.out.println("\n height of tree ----------");
	System.out.println(tree2.maxHeight());
	System.out.println("\n printing tree by levels ----------");
	tree2.printLevels();
	System.out.println("\n printing paths to leaves ----------");
	tree2.printPathToLeaves();
	
}




}