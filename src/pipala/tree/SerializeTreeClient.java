package pipala.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import base.TreeNode;

public class SerializeTreeClient {
	
	static CharNode createTree(char[] source,int index)
	{
	  if((source==null)||(source.length==0))
		return null;
	  else
	  {
		CharNode out = new CharNode();
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
	
	private static void printLevels(CharNode root){
		
		System.out.println("\n Printing tree levels");
		Queue<CharNode> thisLevel = new LinkedList<CharNode>();
		thisLevel.add(root);
		
		Queue<CharNode> nextLevel = new LinkedList<CharNode>();
		
		while (!thisLevel.isEmpty())//after iteration 1, it is actually a check on nextLevel
		{
			CharNode node = thisLevel.poll();
			System.out.print(node.getValue()+", ");
			
			if(node.getLeft()!=null)
				nextLevel.add(node.getLeft());
			
			if(node.getRight()!=null)
				nextLevel.add(node.getRight());
			
			if(thisLevel.isEmpty())
			{
				System.out.println();
				thisLevel = nextLevel;
				nextLevel =  new LinkedList<CharNode>();
			}
			
		}
		
	}
	
	public static void main(String[] args){
		
		char[] source = {'a','b','c','d','e','f','g'};
		CharNode head = createTree(source,0);
		
		SerializeTree st = new SerializeTree();
		List<Byte> serialized = st.serializeTree(head);
		
		for(Byte s:serialized)
			System.out.println(String.format("%8s", Integer.toBinaryString(s & 0xFF)).replace(' ', '0'));
		
		DeserializeTree dst = new DeserializeTree();
		
		CharNode newHead = dst.getTree(serialized);
		
		printLevels(newHead);
		
	}

}
