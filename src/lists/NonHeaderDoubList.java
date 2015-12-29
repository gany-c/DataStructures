package lists;

import base.DoubleNode;
import base.ListNode;

/**
 *  1. The add method is the same as singly linked list, just add at the beginning.
 *  2. Delete is the same as any non header list, if the PREV is null
 *  2.a. it is the first node
 *  2.b. then update the start pointer to the next node.
 *  2.c. in any case just do connect the prev node to the next node.
 * @author Ramanan
 *
 */
public class NonHeaderDoubList implements LinkedList<DoubleNode> {
	
	DoubleNode start = null;
	


	@Override
	public void add(int val) {
		
		DoubleNode dn = new DoubleNode();
		dn.setValue(val);
		
		dn.setNext(start);
		start = dn;
		
		if(dn.getNext()!=null)
			dn.getNext().setPrev(dn);
		
	}

	@Override
	public void delete(int value) {
		
		DoubleNode temp = start;
		
		while(temp != null)
		{
			if(temp.getValue()==value){
				
				if(temp.getPrev()==null){
					start = temp.getNext();
					
					if(start!=null)
						start.setPrev(null);
					
					break;
				}
				else
				{
					DoubleNode prev = temp.getPrev();
					prev.setNext(temp.getNext());
					
					if(temp.getNext()!=null){
						temp.getNext().setPrev(prev);
					}
				}
				
			}
			
			temp = temp.getNext();
		}
		
	}
	
	private void display() {
		System.out.println("List = ");
		
		DoubleNode temp = this.start;
		
		while(temp!=null)
		{
			System.out.print(temp.getValue()+", ");
			temp = temp.getNext();
		}
		
		System.out.println();
		
	}
	
	public static void main(String[] args){
		
		NonHeaderDoubList list = new NonHeaderDoubList();
		
		list.add(22);
		list.add(1);
		list.add(7);
		list.add(8);
		
		list.display();
		
		list.add(100);
		list.add(350);
		list.add(2);
		
		list.display();
		
		list.delete(3);
		
		list.display();
		
		list.delete(2);
		
		list.display();

		
	}		
	

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasLoops() {
		// TODO Auto-generated method stub
		return false;
	}

}
