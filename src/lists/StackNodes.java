package lists;

import base.ListNode;

public class StackNodes{

/*
The header node with dummy data is necessary because a lack of it will require the pop method to return both the popped value
and the updated header.
*/
	ListNode top = null;

public StackNodes()
{
 top = new ListNode();
 top.setValue(Integer.MIN_VALUE);
 top.setNext(null);


}

public void push(int value)
{
ListNode newNode = new ListNode();
newNode.setValue(value);

newNode.setNext(top.getNext());
top.setNext(newNode);

}

public int pop()
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