package DS.lists;

import DS.base.ListNode;

public class SortedLinkedList{

private ListNode initList(){

ListNode headerNode = new ListNode();
headerNode.setValue(Integer.MIN_VALUE);
headerNode.setNext(null);


return headerNode;
}
/*
Insert before current node when it exceeds in value or becomes null.
*/
private void insertNode(ListNode headerNode, int value)
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

private void deleteNode(ListNode headerNode,int value)
{
	ListNode prev = headerNode;
	ListNode curr = headerNode.getNext();

	while(true)
	{

		if(curr==null)
		{
			System.out.println("\n Value not found");
			break;
		}
		else if(curr.getValue()==value)
		{
			prev.setNext(curr.getNext()); 			
		}

		prev = prev.getNext();
		curr = curr.getNext();	

	}


}

private void displayList(ListNode headerNode)
{
	System.out.println("\n Starting list display");
	ListNode curr = headerNode.getNext();
	
	while(curr!=null)
	{
		System.out.println(" "+curr.getValue());
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

}

}