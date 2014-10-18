package DS.lists;

import DS.base.ListNode;

public class QueueNodes{

private ListNode createExit()
{
ListNode newNode = new ListNode();
newNode.setValue(Integer.MIN_VALUE);
return newNode;
}

private ListNode createEnter(ListNode exit)
{
ListNode newNode = new ListNode();
newNode.setValue(Integer.MIN_VALUE);
newNode.setNext(exit);
return newNode;
}

private void insert(ListNode enter,int value)
{
ListNode newNode = new ListNode();
newNode.setValue(value);

ListNode startData = enter.getNext();
startData.setNext(newNode);
enter.setNext(newNode);
}

private int remove(ListNode enter, ListNode exit)
{
 if(enter.getNext()==exit)
 { 	
   System.out.println("queue is empty");
   return Integer.MIN_VALUE;		
 }
 else
 {
   ListNode out = exit.getNext();
   exit.setNext(out.getNext());
   	
   if(exit.getNext()==null)
	enter.setNext(exit); 

   return out.getValue();
 }
}

/*

The linked list is built such that a node inserted earlier points to the node inserted after it.
There are 2 header nodes each with its own -ve Infinity.

1. exit point needs a header because it needs to update the pointer and return the value.
2. entry point could simply return the new head. 

But going back to exiting if there is no entry head, while deleting a lone valid node, both entry and exit will have to be updated. So inside the remove method, you'll end up updating the entry point locally. To avoid that you need a holder for the entry. Hence a  header node for entry.

*/
public static void main(String[] args)
{}

}