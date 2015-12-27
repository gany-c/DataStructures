package lists;
import base.ListNode;


public class NonHeaderList implements LinkedList<ListNode>{
	/**
	 * In java both the linked list implementation with and without headers, 
	 * will have a reference as an instance variable.
	 * 
	 * When there is no header, it points to data directly
	 * When there is a header it points to a node with dummy data.
	 */
	ListNode start = null;
	
	/*
	 * stack like addition
	 * (non-Javadoc)
	 * @see lists.LinkedList#add(int)
	 */
	@Override
	public void add(int val) {
		
		ListNode newHead = new ListNode();
		newHead.setValue(val);
		newHead.setNext(this.start);
		
		this.start = newHead;
	}


 /*
  * delete requires keeping track of the previous node.
  * so, while traversing, it is easier to do the check ahead rather than doing it on the current node.
  * 
  * if the header is not available, the above check is done after a check on the first node.
  * (Even though an internal pointer is available, it points directly to a data node)
  * 
  * if a header is available this first check is not required.
  * 
  * In a doubly linked list, the header is again not required but another if-clause is required.
  */
	@Override
	public void delete(int value) {

		
		if(this.start==null)
			return;
		else if(this.start.getValue() == value)
		{
			this.start = this.start.getNext();
			return;
		}
		
		ListNode temp = start;
		
		
		while(temp.getNext()!=null)
		{
			if(temp.getNext().getValue()==value)
			{
				temp.setNext(temp.getNext().getNext());
				break;
			}
			
			temp = temp.getNext();
		}
		
		
		
	}


	@Override
	public void sort() {
		// Needn't be done
		
	}


	@Override
	public boolean hasLoops() {
		// TODO Needn't be done
		return false;
	}
	
	public static void main(String[] args){
		
		NonHeaderList list = new NonHeaderList();
		
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



	private void display() {
		System.out.println("List = ");
		
		ListNode temp = this.start;
		
		while(temp!=null)
		{
			System.out.print(temp.getValue()+", ");
			temp = temp.getNext();
		}
		
		System.out.println();
		
	}	
	
}	
