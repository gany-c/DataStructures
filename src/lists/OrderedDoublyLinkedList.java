package lists;

import base.DoubleNode;

/**
 * Pretty straightforward - just like any other list
 * @author Ramanan
 *
 */
public class OrderedDoublyLinkedList{

DoubleNode headerNode;
	
	
public OrderedDoublyLinkedList()
{
	headerNode = new DoubleNode();
	headerNode.setValue(Integer.MIN_VALUE);

}

/* Start at the dummy header node and check if the link to the next node needs to be broken */

public void insert(int value)
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


public void delete(int value)
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

public void display()
{
	DoubleNode curr = headerNode.getNext();
	System.out.println(" Start ");
	while(curr!=null)
	{
		System.out.print(" "+curr.getValue());
		curr = curr.getNext();
	}
	System.out.println("\n Stop ");
}



public static void main(String[] args)
{
	OrderedDoublyLinkedList oList = new OrderedDoublyLinkedList();
	
	oList.insert(300);
	oList.insert(342);
	oList.insert(33);
	oList.insert(789);
	oList.insert(1);
	oList.insert(5);
	oList.insert(3);
	oList.insert(210);
	oList.insert(100);
	
	oList.display();
	
	oList.delete(99);
	oList.delete(1);
	oList.delete(33);
	
	oList.display();
	
	oList.insert(-23);
	
	oList.display();
}
}