package tree;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;

import base.IntWrapper;
import base.TreeNode;


public class StaticTree{

// The tree does not need a header over the root, because we are //dealing only with traversal functions, the root itself does not //change.
	
private TreeNode root = null;

public StaticTree(TreeNode node){
	this.root = node;
}

public StaticTree(int[] source){
	 
	this.root = createTree(source, 0);
}

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
 * Excellently done
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

//deep clone
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
	
}




}