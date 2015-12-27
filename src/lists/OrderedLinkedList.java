package lists;

import base.ListNode;

public class OrderedLinkedList{
	
ListNode headerNode = null;

/**
 * Pretty much the same as what you have in plain linked list sort method.
 */
public OrderedLinkedList(){

	headerNode = new ListNode();
	headerNode.setValue(Integer.MIN_VALUE);
	headerNode.setNext(null);

}
/*
Insert before current node when it exceeds in value or becomes null.
*/
public void insert( int value)
{
	ListNode newNode = new ListNode();
	newNode.setValue(value);

	ListNode prev = headerNode;
	ListNode curr = headerNode.getNext();

	while(true)
	{

		if((curr==null)||(curr.getValue()>newNode.getValue()))
		{
			prev.setNext(newNode);
			newNode.setNext(curr);
			break;
		}
		
		prev = prev.getNext();
		curr = curr.getNext();	

	}


}

private void delete(int value)
{
	ListNode prev = headerNode;
	ListNode curr = headerNode.getNext();

	while(true)
	{

		if(curr==null)
		{
			System.out.println("\n Value not found = "+value);
			break;
		}
		else if(curr.getValue()==value)
		{
			prev.setNext(curr.getNext()); 
			break;
		}

		prev = prev.getNext();
		curr = curr.getNext();	

	}


}

private void display()
{
	System.out.println("\n Starting list display");
	ListNode curr = headerNode.getNext();
	
	while(curr!=null)
	{
		System.out.print(" "+curr.getValue());
		curr = curr.getNext();
	}

	System.out.println("\n end of list display");
}
/*
1. why use  a header node with Integer.MIN_VALUE, instead of just another pointer called head to the 1st regular data node?
Ans: Insertion and deletion may happen at the first node. latter approach will require the head being updated for that. Further, the methods will have to return a head because they can update only the local copy of the reference to head.(pointer of pointer in C).

2. Will the code break if several Integer.MIN_VALUE values have been inserted and a delete is called? i.e. by looking for the prev of head?
Ans: No, the delete starts with headerNode.getNext() anyway.

*/
public static void main(String[] args)
{
	OrderedLinkedList oList = new OrderedLinkedList();
	
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