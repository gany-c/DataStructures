package lists;
import base.ListNode;


public class NonHeaderList implements LinkedList<ListNode>{
	
	ListNode start = null;
	
	
	
	
	
	public static void main(String[] args){
		
		NonHeaderList list = new NonHeaderList();
		ListNode newHead = new ListNode();
		
	}





	@Override
	public void add(int val) {
		ListNode newHead = new ListNode();
		newHead.setValue(val);
		newHead.setNext(this.start);
		this.start = newHead;
		
	}





	@Override
	public void delete(int value) {
		// The deletes become far simpler with a header
		//should be the case even in doubly linked list
		
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
	
}	
