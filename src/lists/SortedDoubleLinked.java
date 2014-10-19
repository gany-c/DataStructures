package lists;

import base.DoubleNode;

public class SortedDoubleLinked{


private DoubleNode createList()
{
DoubleNode headerNode = new DoubleNode();
headerNode.setValue(Integer.MIN_VALUE);
return headerNode;
}

/* Start at the dummy header node and check if the link to the next node needs to be broken */

private void insertNode(DoubleNode headerNode, int value)
{

	DoubleNode newNode = new DoubleNode();
	newNode.setValue(value);
	
	DoubleNode curr = headerNode;

	while(true)
	{
	 DoubleNode succ = curr.getNext();
	 
	 if(succ==null)
	 {
		curr.setNext(newNode);
		newNode.setPrev(curr);
		newNode.setNext(null);	

		break;
	 }
	 else if(succ.getValue()>value)
	 {
		curr.setNext(newNode);
		newNode.setPrev(curr);

		newNode.setNext(succ);
		succ.setPrev(newNode);
		
		break;
	 }
	 else
		curr = curr.getNext();	
	}
}


private void deleteNode(DoubleNode headerNode, int value)
{

	DoubleNode curr = headerNode.getNext();
	
	while(true)
	{
		if(curr==null)
		{
		 System.out.println("Value not found");
		 break;	
		}
		else if(curr.getValue()==value)
		{
		  DoubleNode prev = curr.getPrev();
		  DoubleNode next = curr.getNext();
			
		  prev.setNext(next);
		  if(next!=null)
			next.setPrev(prev);

		   break;	
		}
		else
		  curr = curr.getNext();
	}
}

public void displayList(DoubleNode headerNode)
{
	DoubleNode curr = headerNode.getNext();
	System.out.println(" Start ");
	while(curr!=null)
	{
		System.out.print(" "+curr.getValue());
	}
	System.out.println(" Stop ");
}
/*
See comments for single List 
*/

public static void main(String[] args)
{}
}