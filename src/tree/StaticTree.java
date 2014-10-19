package tree;

import java.util.HashSet;

import base.IntWrapper;
import base.TreeNode;
import base.UtilityStack;

public class StaticTree{

// The tree does not need a header over the root, because we are //dealing only with traversal functions, the root itself does not //change.

private TreeNode createTree(int[] source,int index)
{
  if((source==null)||(source.length==0))
	return null;
  else
  {
	TreeNode out = new TreeNode();
	out.setValue(source[index]);
	
	int leftIndex = 2*index;
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

 private void preOrder(TreeNode root)
 {
	if(root == null)
		return;
	else
	{
		System.out.println(root.getValue());
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}	
 } 

 private void inOrder(TreeNode root)
 {
	if(root == null)
		return;
	else
	{
		
		inOrder(root.getLeft());
		System.out.println(root.getValue());
		inOrder(root.getRight());
	}	
 }

private void postOrder(TreeNode root)
 {
	if(root == null)
		return;
	else
	{
		
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.println(root.getValue());		
	}	
 } 
 
private void IterativePreOrder(TreeNode root)
{
	if(root == null)
		 return;
	else
	{
  	UtilityStack stack = new UtilityStack();
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


private void IterativeInOrder(TreeNode root)
{
	if(root == null)
 		return;
	else
	{
 	 UtilityStack stack = new UtilityStack();
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

private void IterativePostOrder(TreeNode root)
{
	if(root == null)
 		return;
	else
	{
  		UtilityStack stack = new UtilityStack();
 	      pushLefts(stack,root);
  		HashSet rightExplored = new HashSet();

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

private void pushLefts(UtilityStack stack, TreeNode node)
{
	while(node!=null)
	{
 		stack.push(node);
 		node = node.getLeft();
	} 
}

private static TreeNode inorderSuccessor(TreeNode root, TreeNode target,IntWrapper status)
{
	if(root == null)
		return null;
	
	TreeNode output = null;
	if(root.getLeft()!=null)
	{
		output = inorderSuccessor(root.getLeft(), target,status);
		if(output!=null)
			return output;
	}
	
	if(status.getValue()==1)
		return root;
	else 
	{	
		if(root==target)
			status.setValue(1);
		
		if(root.getRight()!=null)
			return inorderSuccessor(root.getRight(), target,status);
		else
			return null;
	}
}

private static int maxHeight(TreeNode root){
	
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

static TreeNode createMirror(TreeNode root){
	
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




}