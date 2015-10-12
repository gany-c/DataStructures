package lists;

import base.DoubleNode;
import base.ListNode;

public class NonHeaderDoubList implements LinkedList<DoubleNode> {
	
	DoubleNode start = null;
	
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
