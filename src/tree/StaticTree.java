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
		System.out.println(input.getValue());
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
		System.out.println(input.getValue());
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
		System.out.println(input.getValue());		
	}	
 } 
 
public void IterativePreOrder()
{
	if(root == null)
		 return;
	else
	{
  	Stack<TreeNode> stack = new Stack<TreeNode>();
  	stack.push(root);
  	while(true)
  	{
 		TreeNode node = (TreeNode)stack.pop();
 
 		if(node==null)
 			 break;
 		else
 		{
   			System.out.println(node.getValue());
  			if(node.getLeft()!=null)
  				stack.push(node.getLeft());

   			if(node.getRight()!=null)
   				stack.push(node.getRight()); 
 		}
      }
	}
}


public void IterativeInOrder()
{
	if(root == null)
 		return;
	else
	{
	 Stack<TreeNode> stack = new Stack<TreeNode>();
 	 pushLefts(stack,root);
 	 while(true)
 	 {
 		TreeNode node = (TreeNode)stack.pop();
		 if(node==null)
  			break;
 		else
 		{
   			System.out.println(node.getValue());
  			if(node.getRight()!=null)
 				 pushLefts(stack,node.getRight());
 		}
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

public void IterativePostOrder()
{
	if(root == null)
 		return;
	else
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();
 	    pushLefts(stack,root);
  		Set<TreeNode> rightExplored = new HashSet<TreeNode>();

 		while(true)
            {
			TreeNode node = (TreeNode)stack.pop();
 			if(node==null)
  				break;
 			else
 			{   
   				if((node.getRight()!=null)&&(!rightExplored.contains(node)))
    				{
  					stack.push(node);
             			pushLefts(stack,node.getRight());
  					rightExplored.add(node);
           			}
   				else
    				{
  					System.out.println(node.getValue());
     				} 
    
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

public static TreeNode inorderSuccessor(TreeNode input, TreeNode target,IntWrapper status)
{
	if(input == null)
		return null;
	
	TreeNode output = null;
	if(input.getLeft()!=null)
	{
		output = inorderSuccessor(input.getLeft(), target,status);
		if(output!=null)
			return output;
	}
	
	if(status.getValue()==1)
		return input;
	else 
	{	
		if(input==target)
			status.setValue(1);
		
		if(input.getRight()!=null)
			return inorderSuccessor(input.getRight(), target,status);
		else
			return null;
	}
}

public static int maxHeight(TreeNode root){
	
	if(root.getLeft()==null&&root.getRight()==null)
		return 0;
	else if(root.getLeft()!=null&&root.getRight()!=null)
	{
		int leftHeight = maxHeight(root.getLeft());
		int rightHeight = maxHeight(root.getRight());
		
		if(leftHeight>rightHeight)
			return leftHeight +1;
		else 
			return rightHeight +1;
	}
	else if(root.getLeft()!=null)
	{
		return maxHeight(root.getLeft())+1;		
	}
	else
	{
		return maxHeight(root.getRight())+1;	
	}
}

public static TreeNode createMirror(TreeNode root){
	
	if(root==null)
		return null;
	else
	{
		TreeNode output = new TreeNode();
		output.setValue(root.getValue());
		
		output.setLeft(createMirror(root.getRight()));
		output.setRight(createMirror(root.getLeft()));
		
		return output;
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
public TreeNode clone(){
	return null;
}


public static void main(String[] args){
	
	System.out.println("Hi");
	
	StaticTree tree = new StaticTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
	tree.dFS();
	tree.bFS();
}




}