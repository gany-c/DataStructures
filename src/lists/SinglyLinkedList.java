package lists;

import base.ListNode;



public class SinglyLinkedList implements LinkedList<ListNode>{
	
	//create a header node
	private ListNode head = null;
	
	/*
	 * initialize the header node with the minimum value in the constructor
	 */
	public SinglyLinkedList(){
		this.head = new ListNode();
		this.head.setValue(Integer.MIN_VALUE);
	}
	
	/*
	 * (non-Javadoc)
	 * @see lists.LinkedList#add(int)
	 * 
	 * 1. with the given value, create a node
	 * 2. set the new node's next pointer as the header's next pointer.
	 * 3. set the header's next to point to this new node.
	 * 4. i.e. insert at the beginning/ 
	 * 
	 */
	@Override
	public void add(int  value) {
		
		ListNode next = this.head.getNext();
		ListNode node = new ListNode();
		node.setValue(value);
		
		
		this.head.setNext(node);
		node.setNext(next);
	
	}


	/**
	 * 1. Start traversal by setting a temporary variable at the head node.
	 * 2. while the next node is not null and the next node's value is not the same as the passed value
	 * 2.1. keep incrementing the pointer - so you stop before target or the list end.
	 * 3. If you have stopped before the target, set the next node's next as this node's next. 
	 * 3.1. If you have stopped before null, do nothing
	 */
	@Override
	public void delete(int value) {
		
		ListNode temp = this.head;
		
		while(temp.getNext()!=null && temp.getNext().getValue()!=value)
			temp = temp.getNext();
		
		if(temp.getNext()!=null)
			temp.setNext(temp.getNext().getNext());
	}



	//even after you move the node to the new list, the pointers may refer to old node lists
	//watch out for that, end nodes' next pointers should be explicitly set to null;
	/**
	 *  1. Create a new header node and give it the min value
	 *  2. traverse the old list
	 *  2.1. First save the node's next pointer
	 *  2.2. insert the node into place in the new list.
	 *  2.3. set the temp variable equal to the saved pointer.
	 */
	@Override
	public void sort() {
		
		ListNode newHead = new ListNode();
		newHead.setValue(Integer.MIN_VALUE);
		
		ListNode temp = this.head.getNext();

		while(temp!=null)
		{
			//save temp's next before it goes into the next list
			ListNode next = temp.getNext();
			
			insertIntoPlace(newHead,temp);
			temp = next;
		}
		
		this.head = newHead;
		
	}


	/**
	 * 1. If the header or the node passed in is null return.
	 * 2. Traverse from the new head until - the next node is null or the next node's value is greater than node's value.
	 * 3. Insert:- Set node's next from traversal variable's next, set traversal variable's next as node.
	 * 
	 * @param newHead
	 * @param node
	 */
	private void insertIntoPlace(ListNode newHead, ListNode node) {
		
		if(newHead == null || node == null)
			return;
		
		ListNode temp = newHead;
		
		while(temp.getNext()!=null && temp.getNext().getValue() <= node.getValue())
			temp = temp.getNext();
		
		node.setNext(temp.getNext());
		temp.setNext(node);
			
		
	}


	/**
	 * HAS-LOOPS:- The ideas is to have two counters, one fast and one slow and see if they catch up to one another.
	 * 
	 * 1. if the head or the head's next is null return false
	 * 2. Set a pointer called walk, which is next to head,
	 * 3. if walk's next is head return null or set it to a new pointer called run.
	 * 4. while true
	 * 4.1. if run and walk overlap or run is just behind walk, return true;
	 * 4.2. if run 's next is null or its next to next is null return false
	 * 4.3. advance run by 2 pointers and walk by 1 pointer.
	 */
	@Override
	public boolean hasLoops() {

		if(this.head == null||this.head.getNext() == null)
			return false;
		
		ListNode walk = head.getNext();
		
		if(walk.getNext() == null)
			return false;
		
		ListNode run = walk.getNext();
		
		while(true){
			
			if(run == walk || run.getNext() == walk)
				return true;
				
			if(run.getNext() == null || run.getNext().getNext() == null)
				return false;
			
			run = run.getNext().getNext();
			walk = walk.getNext();
			
		}
		
	}
	
	private void display(){
		
		System.out.println("List = ");
		
		ListNode temp = this.head.getNext();
		
		while(temp!=null)
		{
			System.out.print(temp.getValue()+", ");
			temp = temp.getNext();
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		list.display();
		
		list.add(22);
		list.add(1);
		list.add(7);
		
		list.display();
		
		list.add(100);
		list.add(350);
		list.add(2);
		
		list.display();
		list.delete(3);
		list.display();
		list.delete(2);
		
		System.out.println("--------below is before sorting-------");
		list.display();		
		list.sort();
		list.display();
		System.out.println("--------above is after sorting-------");
		
		System.out.println("has loops: "+list.hasLoops());		
		System.out.println("---------------------------------");
		
		list = new SinglyLinkedList();
		list.add(7);
		
		ListNode temp = list.head;
		
		while(temp.getNext()!=null)
			temp = temp.getNext();
		
		temp.setNext(temp);
		System.out.println("has loops: "+list.hasLoops());
		
		System.out.println("---------------------------------");
		
		list = new SinglyLinkedList();
		
		list.add(7);
		list.add(7);
		list.add(7);
		list.add(7);
		list.add(7);
		list.add(7);
		
		list.add(8);
		list.add(8);
		list.add(8);
		list.add(8);
		list.add(8);
		list.add(8);
		list.add(8);
		list.add(8);
		
		temp = list.head;
		
		while(temp.getNext().getValue()==8)
			temp = temp.getNext();
		
		ListNode mid = temp;
		
		while(temp.getNext()!=null)
			temp = temp.getNext();
		
		temp.setNext(mid);
		
		System.out.println("has loops: "+list.hasLoops());
		mid.setNext(null);
		System.out.println("has loops: "+list.hasLoops());

	}

}
