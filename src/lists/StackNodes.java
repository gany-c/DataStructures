package DS.lists;

import DS.base.ListNode;

public class StackNodes{

/*
The header node with dummy data is necessary because a lack of it will require the pop method to return both the popped value
and the updated header.
*/


private ListNode createStack()
{
 ListNode top = new ListNode();
 top.setValue(Integer.MIN_VALUE);
 top.setNext(null);

 return top;
}

private void push(ListNode top,int value)
{
ListNode newNode = new ListNode();
newNode.setValue(value);

newNode.setNext(top.getNext());
top.setNext(newNode);

}

private int pop(ListNode top)
{
	ListNode out = top.getNext();
	if(out==null)
	{
	System.out.println("Stack Empty");
	return Integer.MIN_VALUE;
	}
	else
	{
	 top.setNext(out.getNext());
	 return out.getValue();	
	}
}

public static void main(String[] args)
{
}


}