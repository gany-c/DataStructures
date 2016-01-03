package fb;

import java.util.Arrays;


public class ZeroArray {
	
	/**
	 * QUICKSORT PARTITION:- without moving the pivot.
	 * 
     *  1. if the input is null or the list size is lesser than 2 return;
	 *  2. set up 2 counters, i at the start and j at the end.
	 *  3. While i is lesser than j, do
	 *  3.1. while i is lesser than the end and while input[i] is not 0, keep incrementing the i
	 *  3.2. i will either go out of the loop or stop at a 0
	 *  3.3. While j is greater than i and input[j] is zero, keep decrement i.e. no need to swap pre-existing zeroes at the end.
	 *  3.4. If you have stopped at a legitimate 0 - non zero combination, swap them and move the counts.
	 *  3- Again, if the counts have gone past each other, break out
	 * 
	 * 
	 * 
	 * MISTAKES MADE:- When a logic and an index bounds check are together in a check
	 * Make sure, you have the bound check in front of logical check
	 * Otherwise there is no point
	 * 
	 */
	public void pushZeroesToEndQSP(int[] input){
		
		if(input == null || input.length <=1)
			return;
		
		int i = 0;
		int j = input.length -1;
		
		while(i < j){
			
			 while( i < input.length && input[i] != 0 )
				i++;
			 
			 while(j >i && input[j] ==0 )
				 j--;
			 
			 if(i < j)
			 {
				 swap(input,i,j);
				 i++;
				 j--;
			 }
		}
	}
	
	/**
	 * Given an array of integers, push the zeroes to the end
	 * 
	 * 1. if input = null or has nothing in it, return.
	 * 2. find the number of zeroes, if the aren't any return.
	 * 3. create 2 pointers - 1 at the start of the array and the second where the zeroes are supposed to start.
	 * 4. second one should be set at input.length - number of zeroes
	 * 5. In a loop
	 * 5.a. move the first pointer to the first zero
	 * 5.b. if it has crossed into the zero section, return; this can happen when the zeros are already in the end.
	 * 5.c. Move the second pointer to the first non zero location, a length check here may not be necessary because 5.b. takes care of it
	 * 5.d. Do a swap of the integers at the pointers.
	 */	
	public void pushZeroesToEnd(int[] input){
		
		//if input = null or has nothing in it, return.
		if(input==null||input.length<=1)
			return;
		
		//find the number of zeroes
		int numZeroes = findNumZeroes(input); 
		
		// if there aren't any return
		if(numZeroes ==0||numZeroes==input.length)
			return;
		
		//set the pointer at array length - zero length.
		int zStart = input.length - numZeroes;
		
		//set one counter at the start of the array, the second at where zeroes are supposed to start.
		int i = 0; int j = zStart;
		
		while(true)
		{
			//move the first pointer to the first zero
			while(input[i]!=0)
				i++;
			
			//if it has crossed into the zero section, return
			// this can happen when the zeros are already in the end.
			if(i >= zStart)
				return;
			
			//move the zero pointer to the first non zero place
			//check for length before reaching into the array
			// length check may not be necessary because, we are
			// already breaking out
			while(/* j<input.length && */input[j]==0)
				j++;
			
// 			may not need this			
//			if(j >= input.length)
//				return;

			//swap the numbers at the pointer locations
			swap(input,i,j);
		}
	}

	private void swap(int[] input, int i, int j) {
		
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		
	}

	private int findNumZeroes(int[] input) {
		
		int count = 0;
		
		for(int i:input)
			if(i==0)
				count++;
			
		return count;
	}

	public static void main(String[] args) {
		
		ZeroArray za = new ZeroArray();
		
		int[] input = {1,0};
		za.pushZeroesToEnd(input);
		
		System.out.println("Old method result = "+Arrays.toString(input));
		
		input = new int[]{1,0};
		za.pushZeroesToEndQSP(input);
		
		System.out.println("New method result = "+Arrays.toString(input));
		
		input = new int[]{0,1};
		za.pushZeroesToEnd(input);
		
		System.out.println("Old method result = "+Arrays.toString(input));
		
		input = new int[]{0,1};
		za.pushZeroesToEndQSP(input);
		
		System.out.println("New method result = "+Arrays.toString(input));		
		
		input = new int[]{0,1,0,4,5,2,56,78,0,0,1};
		za.pushZeroesToEnd(input);
		
		System.out.println("Old method result = "+Arrays.toString(input));	
		
		input = new int[]{0,1,0,4,5,2,56,78,0,0,1};
		za.pushZeroesToEndQSP(input);
		
		System.out.println("New method result = "+Arrays.toString(input));		
		
		input = new int[]{78, 1, 1, 4, 5, 2, 56, 0, 0, 0, 0};
		za.pushZeroesToEnd(input);
		
		System.out.println("Old method result = "+Arrays.toString(input));	
		
		input = new int[]{78, 1, 1, 4, 5, 2, 56, 0, 0, 0, 0};
		za.pushZeroesToEndQSP(input);
		
		System.out.println("New method result = "+Arrays.toString(input));			
		
		input = new int[]{ 0, 0, 0, 0,1};
		za.pushZeroesToEnd(input);
		
		System.out.println("Old method result = "+Arrays.toString(input));	
		
		input = new int[]{ 0, 0, 0, 0,1};
		za.pushZeroesToEndQSP(input);
		
		System.out.println("New method result = "+Arrays.toString(input));
		
		input = new int[]{ 0, 0, 0, 0};
		za.pushZeroesToEnd(input);
		
		System.out.println("Old method result = "+Arrays.toString(input));	
		
		input = new int[]{ 0, 0, 0, 0};
		za.pushZeroesToEndQSP(input);
		
		System.out.println("New method result = "+Arrays.toString(input));			
		
		input = new int[]{1, 0,1, 0,1, 0, 1,0,1};
		za.pushZeroesToEnd(input);
		
		System.out.println("Old method result = "+Arrays.toString(input));	
		
		input = new int[]{ 1, 0,1, 0,1, 0, 1,0,1};
		za.pushZeroesToEndQSP(input);
		
		System.out.println("New method result = "+Arrays.toString(input));			
		
		input = new int[]{1,2,1,3,1,0,1,4,1};
		za.pushZeroesToEnd(input);
		
		System.out.println("Old method result = "+Arrays.toString(input));		
		
		input = new int[]{ 1,2,1,3,1,0,1,4,1};
		za.pushZeroesToEndQSP(input);
		
		System.out.println("New method result = "+Arrays.toString(input));	
		
		input = new int[]{ 0, 0, 0, 0, 78, 1, 1, 4, 5, 2, 56};
		za.pushZeroesToEnd(input);
		
		System.out.println("Old method result = "+Arrays.toString(input));	
		
		input = new int[]{ 0, 0, 0, 0, 78, 1, 1, 4, 5, 2, 56};
		za.pushZeroesToEndQSP(input);
		
		System.out.println("New method result = "+Arrays.toString(input));	
		
		input = new int[]{ 10, 20, 30, 40};
		za.pushZeroesToEnd(input);
		
		System.out.println("Old method result = "+Arrays.toString(input));	
		
		input = new int[]{10, 20, 30, 40};
		za.pushZeroesToEndQSP(input);
		
		System.out.println("New method result = "+Arrays.toString(input));
	}

}
