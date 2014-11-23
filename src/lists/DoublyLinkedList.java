package lists;

import base.DoubleNode;


public class DoublyLinkedList implements LinkedList<DoubleNode> {
	
	private DoubleNode head = null;
	
	public void display(){
		
		DoubleNode temp = head.getNext();
		
		System.out.println("-------");
		while(temp!=null)
		{
			System.out.print(temp.getValue()+", ");
			
			if(temp.getNext()!=null)
				temp = temp.getNext();
			else
				break;
		}
		System.out.println();
		
		while(temp!=head && temp!=null)
		{
			System.out.print(temp.getValue()+", ");
			temp = temp.getPrev();
		}
		
		System.out.println("\n--------------");
		
	}
	
	
	public DoublyLinkedList(){
		 head = new DoubleNode();
		 head.setValue(Integer.MIN_VALUE);
	}

	public static void main(String[] args) {
		
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.display();
		
		list.add(1);
		list.add(84);
		list.add(23);
		
		list.display();
		
		list.add(283);
		list.add(2220);
		list.add(56);
		
		list.display();
		
		list.delete(56);
		list.delete(283);
		list.display();
		
		list.add(1103);
		list.add(114);
		System.out.println("\n----done adding 1103,114---------");
		list.display();
		
		list.sort();
		System.out.println("\n----done sorting---------");
		list.display();
		
		list.add(89);
		list.add(93);
		System.out.println("\n----done adding 89,93---------");
		
		list.display();
		
		System.out.println("------------- Starting loop tests--------");
		
		list = new DoublyLinkedList();
		list.add(7);
		
		DoubleNode temp = list.head;
		
		while(temp.getNext()!=null)
			temp = temp.getNext();
		
		temp.setNext(temp);
		System.out.println("has loops: "+list.hasLoops());
		
		System.out.println("--------------Single self loop done---------");
		
		list = new DoublyLinkedList();
		
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
		
		DoubleNode mid = temp;
		
		while(temp.getNext()!=null)
			temp = temp.getNext();
		
		temp.setNext(mid);
		
		System.out.println("has loops: "+list.hasLoops());
		mid.setNext(null);
		System.out.println("has loops: "+list.hasLoops());
		
		

	}

	@Override
	public void add(int value) {
		
		DoubleNode node = new DoubleNode();
		node.setValue(value);
		
		DoubleNode first = head.getNext();
		
		head.setNext(node);
		node.setPrev(head);
		
		if(first!=null)
		{
			first.setPrev(node);
			node.setNext(first);
		}
		
		
	}

	@Override
	public void delete(int value) {
		
		DoubleNode temp = head.getNext();
		
		while(temp!=null && temp.getValue()!=value)
			temp = temp.getNext();
		
		if(temp == null)
			return;
		else if(temp.getNext() == null)
			temp.getPrev().setNext(null);
		else
		{
			DoubleNode prev = temp.getPrev();
			DoubleNode next = temp.getNext();
			
			prev.setNext(next);
			next.setPrev(prev);
		}
		
	}

	@Override
	//even after you move the node to the new list, the pointers may refer to old node lists
	//watch out for that, end nodes' next pointers should be explicitly set to null;
	public void sort() {
		
		DoubleNode temp = head.getNext();
		
		if(temp == null)
			return;
		
		DoubleNode newHead = new DoubleNode();
		newHead.setValue(Integer.MIN_VALUE);
		
		while(temp!=null)
		{
			// don't refer to old list, save reference here itself
			DoubleNode next = temp.getNext();
			
			insertByOrder(newHead,temp);
	
			temp = next;
				
		}

		
		this.head = newHead;
		
	}

	private void insertByOrder(DoubleNode newHead, DoubleNode in) {
		
		DoubleNode temp = newHead;

		
		while(temp.getNext()!=null && temp.getNext().getValue() <= in.getValue())
			temp = temp.getNext();
	
		
		DoubleNode next = temp.getNext();
		
		temp.setNext(in);
		in.setPrev(temp);
		
		in.setNext(next);
		
		if(next != null)
		{			
			next.setPrev(in);
		}
		
		
		
	}


	@Override
	public boolean hasLoops() {
		
		if(head.getNext() == null)
			return false;
		
		DoubleNode walk = head.getNext();
		
		DoubleNode run = walk.getNext();
		if(run == null)
			return false;
		
		while(true){
			
			
			if (run == walk || run.getNext() == walk)
				return true;
			
			if(run.getNext() == null || run.getNext().getNext() == null)
				return false;
			else
				run = run.getNext().getNext();
			

			walk = walk.getNext();
			

		}
		

	}

}
