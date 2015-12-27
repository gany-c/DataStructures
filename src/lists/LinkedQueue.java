package lists;

import base.ListNode;

/** EASY
 * 1. Have 2 header nodes entry and exit
 * 2. exit will point to the 1st node to be removed 
 * 2.1. which in turn will point to the next node and so on.
 * 3. the last node will have null as next; and both entry and its ancestor will point to it.
 * 
 * 4. When the queue is empty, exit will point to null and entry will point to exit.
 * 
 * 
 * @author gchidam
 *
 */
public class LinkedQueue{

//initialize two variables for entry and exit.	
ListNode exit = null;
ListNode enter = null;

/**
 * 1. initialize the exit and entry pointers to nodes with min value
 * 2. Get the entry node to point to exit.
 */
public LinkedQueue(){
	
	exit = new ListNode();
	exit.setValue(Integer.MIN_VALUE);
	
	enter = new ListNode();
	enter.setValue(Integer.MIN_VALUE);
	enter.setNext(exit);
	
}

/**
 * 1. create a new node and set the value to passed parameter.
 * 2. get the node pointed to by enter = startData
 * 3. Get start-data's nest and  enter's next to point to the new node.
 * @param value
 */

private void add(int value)
{
	ListNode newNode = new ListNode();
	newNode.setValue(value);
	
	ListNode startData = enter.getNext();
	startData.setNext(newNode);
	enter.setNext(newNode);
	//both the previously inserted node and the "enter" header will point to the new node.
	
}

/**
 *  1. if enter's next points to exit, the queue is already empty, so return.
 *  2. Get the node pointed to by the exit header's next = out, set exit's next to be the out node's next
 *  3. Now, if the exit's next is pointing to null, then the queue is empty, get enter's next to point to exit.
 * @return
 */
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