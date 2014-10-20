package lists;

import base.ListNode;

public class LinkedQueue{

ListNode exit = null;
ListNode enter = null;
	
public LinkedQueue(){
	
	exit = new ListNode();
	exit.setValue(Integer.MIN_VALUE);
	
	enter = new ListNode();
	enter.setValue(Integer.MIN_VALUE);
	enter.setNext(exit);
	
}



private void add(int value)
{
	ListNode newNode = new ListNode();
	newNode.setValue(value);
	
	ListNode startData = enter.getNext();
	startData.setNext(newNode);
	enter.setNext(newNode);
	//both the previously inserted node and the "enter" header will point to the new node.
	
}

private int get()
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

-- There are 2 headers - 1 at entry and 1 at exit.
-- In the beginning entry points to exit
-- As the queue grows, each newly inserted node is pointed to both by previous node and by entry header.
-- e.g. ENTRY -> 4 <- 3 <-2 <- 1 <- EXIT 

*/
public static void main(String[] args)
{
	
	LinkedQueue q = new LinkedQueue();

	q.get();
	
	q.add(23);
	q.add(1);
	q.add(4);
	
	q.display();
	
	System.out.println(q.get());
	
	q.display();
	
	q.add(30);
	q.add(0);
	q.add(41);
	
	q.display();
	
	System.out.println(q.get());
	
	q.display();
	
	q.get();
	q.get();
	q.get();
	q.get();
	q.get();
	q.get();
	
	q.display();
}



private void display() 
{

	
	if(exit.getNext() == null)
	{
		System.out.println("Q is empty return");
	}
	
	ListNode n = exit.getNext();
	
	while(n != null)
	{
		System.out.print(n.getValue()+", ");		
		n = n.getNext();		
	}
	
	System.out.println();
}

}