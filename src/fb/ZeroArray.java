package fb;

import java.util.Arrays;

public class ZeroArray {
	
	public void pushZeroesToEnd(int[] input){
		
		if(input==null||input.length<=1)
			return;
		
		int numZeroes = findNumZeroes(input); 
		
		if(numZeroes ==0||numZeroes==input.length)
			return;
		
		int zStart = input.length - numZeroes;
		int i = 0; int j = zStart;
		
		while(true)
		{
			while(input[i]!=0)
				i++;
			
			if(i >= zStart)
				return;
			
			//check for length before reaching into the array
			while(/* j<input.length && */input[j]==0)
				j++;
			
// 			may not need this			
//			if(j >= input.length)
//				return;
			
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

	}

}
