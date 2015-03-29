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
		
		if((end-start)==1)
		{
			if(input[end] > input[start])
				swap(input,start,end);
			return start;
		}
		
		int i = start+1, j = end;
		
		while(i<j){
			
			//2nd condition needed for indexes
			while(input[i]<input[start]&&(i<j))
				i++;
			
			while(input[j] >= input[start] && (i<j))
				j--;
			
			if(i < j)
				swap(input,i,j);
			
		}
		
		if(input[start] > input[i-1])
			swap(input,start,i-1);
		
		return i-1;

		
		
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

	}

}
