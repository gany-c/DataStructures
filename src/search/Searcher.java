package search;

public class Searcher {
	
	/**
	 * given an array of sorted integers and a number, find the index where input number is positioned or where it needs to be inserted.
	 * 1. check for null conditions
	 * 2. check for the extremities
	 * 3. Start the recursive function
	 * 
	 * 3.1. If the element at mid is the same as what you were looking for, return mid
	 * 3.2. Check if start == mid. This can happen in 2 cases 
	 *  1. start and end are adjacent - here the value is strictly greater than start, but less than or equal to end, so return start +1 or mid +1 or end.
	 *  2. start and end overlap - depending on how the value at mid compares with the input value, return an index 1 greater or mid itself (will get pushed if a new value is inserted)
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
				
				System.out.println("start,mid,end = "+start+", "+mid+", "+end);
				
				if(list[mid] < in)
					return mid +1;
				else 
					return mid;
			}
			
			if(in < list[mid])
				return binarySearch(list,in,start,mid-1);
			else
				return binarySearch(list,in,mid+1,end);
		}
			

	}
	
	public static void main(String[] args){
		
		Searcher s = new Searcher();
		
		System.out.println("index = "+s.search(new int[]{ 2,4,5,6,9,155},4));
		System.out.println("index = "+s.search(new int[]{ 2,4,5,6,9,155},8));
		System.out.println("index = "+s.search(new int[]{ 2,4,5,6,9,155},1));
		System.out.println("index = "+s.search(new int[]{ 2,4,5,6,9,155},256));
		System.out.println("index = "+s.search(new int[]{ 155},256));
		System.out.println("index = "+s.search(new int[]{ 155},65));
		System.out.println("index = "+s.search(new int[]{ 2,155},65));
		System.out.println("index = "+s.search(new int[]{ 2,155},256));
		System.out.println("index = "+s.search(new int[]{ 21,32,155},22));
		System.out.println("index = "+s.search(new int[]{ 2,4,5,6,9,155,159},4));
		System.out.println("index = "+s.search(new int[]{ 2,4,5,6,9,155,159},11));
		System.out.println("index = "+s.search(new int[]{ 1,5,9},8));
		/**
		 * 	index = 1
			index = 4
			index = 0
			index = 6
			index = 1
			index = 0
			index = 1
			index = 2
			index = 1
		 */
	}

}
