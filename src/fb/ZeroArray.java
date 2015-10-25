package fb;

import java.util.Arrays;

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
public class ZeroArray {
	
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
		
		System.out.println(Arrays.toString(input));
		
		input = new int[]{0,1};
		za.pushZeroesToEnd(input);
		
		System.out.println(Arrays.toString(input));
		
		input = new int[]{0,1,0,4,5,2,56,78,0,0,1};
		za.pushZeroesToEnd(input);
		
		System.out.println(Arrays.toString(input));		
		
		input = new int[]{78, 1, 1, 4, 5, 2, 56, 0, 0, 0, 0};
		za.pushZeroesToEnd(input);
		
		System.out.println(Arrays.toString(input));		
		
		input = new int[]{ 0, 0, 0, 0,1};
		za.pushZeroesToEnd(input);
		
		System.out.println(Arrays.toString(input));	
		
		input = new int[]{1, 0,1, 0,1, 0, 1,0,1};
		za.pushZeroesToEnd(input);
		
		System.out.println(Arrays.toString(input));	
		
		input = new int[]{1,2,1,3,1,0,1,4,1};
		za.pushZeroesToEnd(input);
		
		System.out.println(Arrays.toString(input));		
		
		input = new int[]{ 0, 0, 0, 0, 78, 1, 1, 4, 5, 2, 56};
		za.pushZeroesToEnd(input);
		
		System.out.println(Arrays.toString(input));		

	}

}
