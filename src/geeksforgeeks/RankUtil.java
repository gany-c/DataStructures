package geeksforgeeks;

import java.util.Arrays;

/**
 * 
 * @author Ramanan
 * http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
 * 
 * Given an array of unsorted numbers,
 * we need to find the k’th smallest element in the given array. 
 *  1. The naive approach would be to search k times - complexity would be k*n
 *  2. The better approach would be to use Quicksort partition - 
 *  it moves a pivot into it's correct position and ensures that all smaller elements are to the left and bigger elements are to the right.
 *  3. So, in a loop, keep running the partition
 *  3.1. if the partition pivots at K then return the pivotted element.
 *  3.2. if the partition pivoted at a place greater than K then set the pivot as the upper bound and repeat
 *  3.3. else, set the partition as the lower bound.
 *  
 *  QUICKSORT PIVOT
 *  
 *  1. Handle the special cases for the list being null, of size 1 and 2
 *  2. set 2 pointers, one after the start position and one at the end
 *  3. while the start pointer has not crossed the end pointer
 *  3.1. scroll to the very last element if possible, otherwise to the first greater-than-START element, i could go past j by 1
 *  3.2. in whatever the first counter hasn't explored go to the first smaller-than-START element
 *  3.3. if pointers haven't crossed yet swap them.
 *  
 *  4. when the loop ends, all lesser elements have been pushed to left of i and vice versa for the greater elements (except element 1)
 *  5. compare element with i-1 (i has stopped upon seeing the greater element, i-1 is smaller than start and should come before start) and swap if necessary.
 *
 */

public class RankUtil {
	
	private int partition(int[] input,int start, int end){
		
		//Handle the special cases for the list being null, of size 1 and 2
		if(input==null)
			return 0;
		
		if(end-start ==0)
			return start;	
		
		if(end-start ==1)
		{
			if(input[end] < input[start])
			{
				swap(input,start,end);
				return end;
			}
			else
				return start;
				
		}

		//set 2 pointers, one after the start position and one at the end
		int i = start+1, j = end;
		
		while(i<j){
			
			//scroll to the very last element if possible, otherwise to the first greater element
			//i could go past j by 1
			while((i<=j) && input[i]<=input[start])
				i++;
			
			//in whatever the first counter hasn't explored go to the first smaller element
			while( (i<j) &&input[j]>=input[start] )
				j--;
			
			//if greater and lesser pairs are found on the way swap them.
			if(i < j)
				swap(input,i,j);
			
		}
		
		//if the pivot position has a lesser element, swap
		if(input[start] > input[i-1])
			swap(input,start,i-1);
		
		return i-1;
	
		
	}
	/**
	 * k starts at 0 max, can be input.length -1
	 * @param input
	 * @param k
	 * @return
	 */
	public int findKthSmallest(int[] input, int k){
		
		if(input == null||input.length==0)
			return -1;
		
		if(k > input.length-1)
		{
			System.out.println("k starts at 0 max, can be input.length -1");
			return -1;
		}
		
		int start =0, end = input.length-1;
		
		// do in a loop
		while(true)
		{
			//do the quick sort partitioning, using the first element and get the final pivot position
			int rank = partition(input,start,end);
			
			System.out.println("Upon partitioning = "+Arrays.toString(input));
			System.out.println("privot pos = "+rank);
			
			//if the pivont rank equals k return;
			if(rank==k)
				return input[k];
			//else if the pivot rank is greater than k, i.e. you want 3rd smallest and the list has found the 5th smallest
			// set pivot rank as new end
			else if(rank > k)
				end = k;
			//else set the new start to be the pivot rank
			else
				start = k;
			
			
		}
		
	}
	

	private void swap(int[] input, int i, int j) {
		
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		
	}


	public static void main(String[] args) {
		
		RankUtil ru = new RankUtil();
		
		int[] input = new int[] {7, 10, 4, 3, 20, 15};
		int pivot = ru.partition(input, 0, 5);
		System.out.println(Arrays.toString(input));
		System.out.println("pivot = "+pivot);
		
		input = new int[] {1,2,3,4,5,6};
		pivot = ru.partition(input, 0, 5);
		System.out.println(Arrays.toString(input));
		System.out.println("pivot = "+pivot);
		
		input = new int[] {7,1,2,3,4,5,6,8};
		pivot = ru.partition(input, 0, 7);
		System.out.println(Arrays.toString(input));
		System.out.println("pivot = "+pivot);	
		
		System.out.println("=============================== ");
		
		input = new int[] {7, 10, 4, 3, 20, 15};
		int result = ru.findKthSmallest(input,3);
		System.out.println("1. 3rd smallest (index 0) = "+result);
		
		input = new int[] {1,2,3,4,5,6};
		result = ru.findKthSmallest(input,5);
		System.out.println("2. 5th smallest (index 0) = "+result);
		
		input = new int[] {7,1,2,3,4,5,6,8};
		result = ru.findKthSmallest(input,5);
		System.out.println("3. 5th smallest (index 0) = "+result);
		
		input = new int[] {1,2,3,4,5,6,7,8};
		result = ru.findKthSmallest(input,5);
		System.out.println("4. 5th smallest (index 0) = "+result);		
		
		input = new int[] {9,8,7,6,5,4,3,2,1,0};
		result = ru.findKthSmallest(input,0);
		System.out.println("5. 0th smallest (index 0) = "+result);	
		
		result = ru.findKthSmallest(input,9);
		System.out.println("6. 9th smallest (index 0) = "+result);	
		

	}

}
