package lists;

import base.ListNode;



public class SinglyLinkedList implements LinkedList<ListNode>{
	
	private ListNode head = null;
	
	public SinglyLinkedList(){
		this.head = new ListNode();
		this.head.setValue(Integer.MIN_VALUE);
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
		list.display();
		list.sort();
		list.display();
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



	@Override
	public void add(int  value) {
		
		ListNode next = this.head.getNext();
		ListNode node = new ListNode();
		node.setValue(value);
		
		
		this.head.setNext(node);
		node.setNext(next);
	
	}



	@Override
	public void delete(int value) {
		
		ListNode temp = this.head;
		
		while(temp.getNext()!=null && temp.getNext().getValue()!=value)
			temp = temp.getNext();
		
		if(temp.getNext()!=null)
			temp.setNext(temp.getNext().getNext());
	}



	@Override
	public void sort() {
		
		ListNode temp = this.head.getNext();
		
		ListNode newHead = new ListNode();
		newHead.setValue(Integer.MIN_VALUE);

		while(temp!=null)
		{
			//save temp's next before it goes into the next list
			ListNode next = temp.getNext();
			
			insertIntoPlace(newHead,temp);
			temp = next;
		}
		
		this.head = newHead;
		
	}



	private void insertIntoPlace(ListNode newHead, ListNode node) {
		
		if(newHead == null || node == null)
			return;
		
		ListNode temp = newHead;
		
		while(temp.getNext()!=null && temp.getNext().getValue() <= node.getValue())
			temp = temp.getNext();
		
		node.setNext(temp.getNext());
		temp.setNext(node);
			
		
	}



	@Override
	public boolean hasLoops() {

		if(this.head.getNext() == null)
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

}
