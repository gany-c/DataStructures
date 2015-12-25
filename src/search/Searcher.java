package search;

public class Searcher {
	
	/** EASY
	 * given an array of sorted integers and a number, find the index where input number is positioned or where it needs to be inserted.
	 * 1. check for null conditions
	 * 2. check for the extremities
	 * 3. Start the recursive function
	 * 
	 * BINARY SEARCH has TWO VARIATIONS - 
	 * -- Search for a transition between 2 states - first faulty checkin or first strictly greater value
	 * -- Find index -- Return the index of a value or any valid place where it can be inserted
	 * 
	 * In the second case, Making the recursive with a mid +1 or mid -1 can take the target value outside the range
	 * e.g. { 1,5,9,13,17},8
	 * e.g. { 1,5,9,13,17},12
	 * 
	 * In the first case, we are comparing mid with its adjacent elements so it is OK 
	 * - here you can use mid +1 and mid -1 and break out, without making recursion ending code.
	 * 
	 * 3.1. If the element at mid is the same as what you were looking for, return mid
	 * 3.2. Check if start == mid. This can happen in 2 cases 
	 *  1. start and end are adjacent
	 *   - here the value is strictly greater than start, but less than or equal to end, 
	 *   - so return start +1 or mid +1 or end.
	 *  2. start and end overlap - 
	 *  depending on how the value at mid compares with the input value, return an index 1 greater or mid itself 
	 *  (will get pushed if a new value is inserted)
	 * @param list
	 * @param in
	 * @return
	 */
	public int search(int[] list, int in){
		
		if(list == null || list.length ==0)
			return -1;
		else if (in <= list[0])
			return 0;
		else if (in > list[list.length-1])
			return list.length;
		else 
			return binarySearch(list,in,0,list.length-1);
		
	}

	private int binarySearch(int[] list, int in, int start, int end) {

		int mid = (start + end)/2;
		
		if(in == list[mid])
			return mid;
		else{

			if(start == mid){
				
				System.out.println("-------------- start,mid,end = "+start+", "+mid+", "+end);
				
				if(list[mid] < in)
					return mid +1;
				else 
					return mid;
			}
			
			if(in < list[mid])
				return binarySearch(list,in,start,mid);
			else
				return binarySearch(list,in,mid,end);
		}
			

	}

	/**
	 * Making the recursive with a mid +1 or mid -1 can take the target value outside the range
	 * e.g. { 1,5,9,13,17},8
	 * e.g. { 1,5,9,13,17},12
	 * @param list
	 * @param in
	 * @param start
	 * @param end
	 * @return
	 */
	@Deprecated
	private int binarySearchWrong(int[] list, int in, int start, int end) {

		int mid = (start + end)/2;
		
		if(in == list[mid])
			return mid;
		else{

			if(start == mid){
				
				//System.out.println("------------ start,mid,end = "+start+", "+mid+", "+end);
				
				if(list[mid] < in)
					return mid +1;
				else 
					return mid;
			}
			
			if(in < list[mid])
				return binarySearchWrong(list,in,start,mid-1);
			else
				return binarySearchWrong(list,in,mid+1,end);
		}
			

	}
	
	public boolean isPresent(int[] input, int key){
		
		if(input == null || input.length ==0)
			return false;
		if(input[0] > key || input[input.length-1] < key)
			return false;
		else return binaryIsPresent(input, key, 0, input.length -1);
			
					
	}
	
	/** here +1, -1 is used despite not having adjacency comparisons
	 * The target value may go out of range of start and end.
	 * 
	 * But since we are just returning true or false, it is OK
	 * 
	 * @param input
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	private boolean binaryIsPresent(int[] input, int key, int start, int end) {
		
		int mid = (start + end )/2;
		 
		if(input[mid] == key)
			return true;
		else
		{
			if(start == mid)
				return input[end] == key;
			
			if(input[mid] < key)
				return binaryIsPresent(input,key, mid+1,end);
			else
				return binaryIsPresent(input,key, start,mid -1);
		}	    
		
	}

	public static void main(String[] args){
		
		Searcher s = new Searcher();
		
		System.out.println("{ 2,4,5,6,9,155},4 index = "+s.search(new int[]{ 2,4,5,6,9,155},4));
		System.out.println("{ 2,4,5,6,9,155},8 index = "+s.search(new int[]{ 2,4,5,6,9,155},8));
		System.out.println("{ 2,4,5,6,9,155},1 index = "+s.search(new int[]{ 2,4,5,6,9,155},1));
		System.out.println("{ 2,4,5,6,9,155},256 index = "+s.search(new int[]{ 2,4,5,6,9,155},256));
		System.out.println("{ 155},256 index = "+s.search(new int[]{ 155},256));
		System.out.println("{ 155},65 index = "+s.search(new int[]{ 155},65));
		System.out.println("{ 2,155},65 index = "+s.search(new int[]{ 2,155},65));
		System.out.println("{ 2,155},256 index = "+s.search(new int[]{ 2,155},256));
		System.out.println("{ 21,32,155},22 index = "+s.search(new int[]{ 21,32,155},22));
		System.out.println("{ 2,4,5,6,9,155,159},4 index = "+s.search(new int[]{ 2,4,5,6,9,155,159},4));
		System.out.println("{ 2,4,5,6,9,155,159},11 index = "+s.search(new int[]{ 2,4,5,6,9,155,159},11));
		System.out.println("{ 1,5,9},8 index = "+s.search(new int[]{ 1,5,9},8));
		System.out.println("{ 1,5,9,13,17},12 index = "+s.search(new int[]{ 1,5,9,13,17},12));
		System.out.println("{ 1,5,9,13,17},8 index = "+s.search(new int[]{ 1,5,9,13,17},8));
		
		System.out.println("=================================");
		
		System.out.println("{ 2,4,5,6,9,155},4 index = "+s.isPresent(new int[]{ 2,4,5,6,9,155},4));
		System.out.println("{ 2,4,5,6,9,155},8 index = "+s.isPresent(new int[]{ 2,4,5,6,9,155},8));
		System.out.println("{ 2,4,5,6,9,155},1 index = "+s.isPresent(new int[]{ 2,4,5,6,9,155},1));
		System.out.println("{ 2,4,5,6,9,155},256 index = "+s.isPresent(new int[]{ 2,4,5,6,9,155},256));
		System.out.println("{ 155},256 index = "+s.isPresent(new int[]{ 155},256));
		System.out.println("{ 155},65 index = "+s.isPresent(new int[]{ 155},65));
		System.out.println("{ 2,155},65 index = "+s.isPresent(new int[]{ 2,155},65));
		System.out.println("{ 2,155},256 index = "+s.isPresent(new int[]{ 2,155},256));
		System.out.println("{ 21,32,155},22 index = "+s.isPresent(new int[]{ 21,32,155},22));
		System.out.println("{ 2,4,5,6,9,155,159},4 index = "+s.isPresent(new int[]{ 2,4,5,6,9,155,159},4));
		System.out.println("{ 2,4,5,6,9,155,159},11 index = "+s.isPresent(new int[]{ 2,4,5,6,9,155,159},11));
		System.out.println("{ 1,5,9},8 index = "+s.isPresent(new int[]{ 1,5,9},8));
		System.out.println("{ 1,5,9,13,17},12 index = "+s.isPresent(new int[]{ 1,5,9,13,17},12));
		System.out.println("{ 1,5,9,13,17},8 index = "+s.isPresent(new int[]{ 1,5,9,13,17},8));

	}

}
