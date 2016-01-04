package pipala;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *  How will you create a PeekIterator, which is a wrapper around a regular iterator.
 *  Apart from the hasNext() and next() method you have to implement a peek() method.
 *  
 * create 3 instance variables - 1 for iterator, next value in the list and boolean if the list is empty

 CONSTRUCTOR:
 	 * 1. Store the iterator as instance variable
	 * 2. store the first hasNext boolean return value in the instance variable
	 * 3. if that is true, get the first value from the iterator and store in an instance variable.
	 * 
 HAS-NEXT METHOD:
 	 return the boolean instance variable 
 	 
 PEEK METHOD:
 	 * 1. if the instance boolean variable is true return the stored value.
	 * 2. else throw an exception
 
 GET METHOD: 
 	 * 1. if the instance boolean variable is false throw an exception.
	 * 2. else, store the instance value in a temporary variable
	 * 2.1. update the instance value and variable using the iterator
	 * 2.2. return the temporary variable.

	NOTE: Don't use temp==null as a check in PEEK and GET. 
	That would fail if the iterator itself contains null as one of the values.

 * @author gchidam
 *
 * @param <T>
 */
public class PeekIterator<T> {
	
	// create 3 instance variables - 1 for iterator, next value in the list and boolean if the list is empty
	private Iterator<T> iterator;
	private T next = null;
	private boolean realHasNext = false;

	/**
	 * 1. Store the iterator as instance variable
	 * 2. store the first hasNext boolean return value in the instance variable
	 * 3. if that is true, get the first value from the iterator and store in an instance variable.
	 * 
	 * @param i
	 */
	public PeekIterator(Iterator<T> i){
		this.iterator = i;
		
		this.realHasNext = i.hasNext();
		
		if(i.hasNext())
			this.next = i.next();
	}
	
	/**
	 * return the boolean instance variable 
	 * @return
	 */
	public boolean hasNext(){
		return this.realHasNext;
	}

	/**
	 * 1. if the instance boolean variable is true return the stored value.
	 * 2. else throw an exception
	 */
	public T peek() throws Exception{
		if(this.realHasNext)
			return this.next;
		else
			throw new Exception("Out of elements");
	}
	
	/**
	 * 1. if the instance boolean variable is false throw an exception.
	 * 2. else, store the instance value in a temporary variable
	 * 2.1. update the instance value and variable using the iterator
	 * 2.2. return the temporary variable.
	 * @return
	 * @throws Exception
	 */
	public T get() throws Exception{
		
		if(this.realHasNext){
			this.realHasNext = iterator.hasNext();
			T temp = this.next;
			
			if(this.iterator.hasNext()){				
				this.next = iterator.next();				
			}
			else 
				this.next = null;
			
			return temp;
		}
		else
		{
			throw new Exception("Out of elements");
		}
	}
	
	public static void main(String[] args) {
		
		Set<Integer> numSet = new HashSet<Integer>();		
		PeekIterator<Integer> pi = new PeekIterator<Integer>(numSet.iterator());
		
		System.out.println("PeekIterator hasNext = "+pi.hasNext());
		
		try{
			pi.peek();
		}
		catch(Exception e){
			System.out.println("Exception with message = "+e.getMessage());
		}
		
		try{
			pi.get();
		}
		catch(Exception e){
			System.out.println("Exception with message = "+e.getMessage());
		}
		
		System.out.println("============== ");
		
		numSet = new HashSet<Integer>();
		numSet.add(3425);
		numSet.add(58465);
		numSet.add(9457);
		numSet.add(43535);
		
		pi = new PeekIterator<Integer>(numSet.iterator());	
		
		int count = 0;
		
		while(pi.hasNext() && count < 10){
			
			try {
				System.out.println(" peek = "+pi.peek()+", count = "+count++);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("============== ");
		
		while(pi.hasNext()){
			
			try {
				System.out.println(" peek = "+pi.peek());
				System.out.println(" get = "+pi.get());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("============== ");
		

	}

}
