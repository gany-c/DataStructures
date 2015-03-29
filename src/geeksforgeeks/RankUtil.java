package geeksforgeeks;

import java.util.Arrays;

/**
 * 
 * @author Ramanan
 * http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
 * 
 * Given an array and a number k where k is smaller than size of array, 
 * we need to find the k’th smallest element in the given array. 
 * 
 *
 */

public class RankUtil {
	
	private int partition(int[] input,int start, int end){
		
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

		
		int i = start+1, j = end;
		
		while(i<j){
			
			
			while((i<=j) && input[i]<=input[start])
				i++;
			
			while( (i<j) &&input[j]>=input[start] )
				j--;
			
			if(i < j)
				swap(input,i,j);
			
		}
		
		if(input[start] > input[i-1])
			swap(input,start,i-1);
		
		return i-1;
	
		
	}
	
	//k starts at 0 max, can be input.length -1
	public int findKthSmallest(int[] input, int k){
		
		if(input == null||input.length==0)
			return -1;
		
		if(k > input.length-1)
		{
			System.out.println("k starts at 0 max, can be input.length -1");
			return -1;
		}
		
		int start =0, end = input.length-1;
		
		while(true)
		{

			
			int rank = partition(input,start,end);
			
			System.out.println("Upon partitioning = "+Arrays.toString(input));
			System.out.println("privot pos = "+rank);
			
			if(rank==k)
				return input[k];
			else if(rank > k)
				end = k;
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
