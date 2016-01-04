package geeksforgeeks;

import java.util.Arrays;

/**
 * 
 * @author Ramanan
 * 
 * 5. http://www.geeksforgeeks.org/find-k-closest-elements-given-value/
 * 
 * Given a sorted array arr[] and a value X, find the k closest elements to X in arr[]. 
Examples:

Input: K = 4, X = 35
       arr[] = {12, 16, 22, 30, 35, 39, 42, 
               45, 48, 50, 53, 55, 56}
Output: 30 39 42 45
Note that if the element is present in array, then it should not be in output, 
only the other closest elements are required.
 *
 * SOLUTION:-
 * 
 * 1. Do a binary search to find the indexes between which this number falls. 
 * 	2 bounds are required, even if an exact match is found.
 * 2. Set these as starting pointers and copy the numbers, 
 * 	move the pointer depending on which pointer's number is closer to the input number.
 * 3. Break when you hit k, watch out for the array ends.
 *
 */
public class ListUtil {
	
	public int[] findKClosest(int[] input, int num, int k){
		
		// usual null and emptiness check
		if(input == null||input.length==0)
			return null;
		
		// closest k should also be atleast 1
		if(k <= 0)
			return null;
		
		//if k is greater than input's length then return the input itself
		if(input.length <= k)
			return input;
		
		//get the indexes of the two numbers in between which the input number falls
		int[] bounds = binSearch(input,num);
		System.out.println("Done calculating bounds "+Arrays.toString(bounds));
		
		//find the k closest numbers from the bounds.
		return kClosestFromBounds(input,bounds,num,k);
		
		
	}

	/**
	 * Keep 2 pointers and move them depending on which one is closer to the input number
	 * take care of spilling out of the array's upper and lower bounds.
	 * @param input
	 * @param bounds
	 * @param num
	 * @param outSize
	 * @return
	 */
	private int[] kClosestFromBounds(int[] input, int[] bounds, int num, int outSize) {
		
		int[] output = new int[outSize];
		boolean leftHit = bounds[0] < 0;
		boolean rightHit = bounds[1] >= input.length;
		
		int k = 0;
		int i = bounds[0];
		int j = bounds[1];
		
		while(k < outSize){
			
			if(leftHit)
			{
				output[k++] = input[j++];
			}
			else if(rightHit)
			{
				output[k++] = input[i--];
			}
			else
			{
				if(Math.abs(num - input[i]) < Math.abs(num - input[j]))
				{
					output[k++] = input[i--];
					leftHit = i < 0;
				}
				else
				{
					output[k++] = input[j++];
					rightHit = j >= input.length;
				}
			}
			
			
		}
		
		
		return output;
	}

	private int[] binSearch(int[] input, int num) {		

		//if input number is smaller than the starting return -1 and 0
		if(num < input[0])
			return new int[]{-1,0};
		
		//if input number is larger than the ending return, last index and that +1
		if(num > input[input.length-1])
			return new int[]{input.length-1,input.length};		
		
		//create an empty bounds array.
		int[] bounds = new int[2];
		
		//Like any binary search, set start and end at the extremities
		int start =0, end = input.length-1;
		
		//set mid in the middle
		int mid = (start + end)/2;
		
		
		while(start < end)
		{			
			mid = (start + end)/2;
						
			//if an exact match is found or start - end = 1 break// otherwise typical binary search.
			if(input[mid]==num||end-start ==1)
				break;
			else if(num < input[mid] )
				end = mid;
			else
				start = mid;
		}
		
		//at the end of the loop, if an exact match is found, set the bounds on each side.
		if(input[mid]==num)
		{
			bounds[0] = mid -1;
			bounds[1] = mid +1;
		}
		else if(input[mid] > num)
		{
			bounds[0] = mid -1;
			bounds[1] = mid;
		}
		else
		{
			bounds[0] = mid;
			bounds[1] = mid +1;
		}
		
		return bounds;
	}

	public static void main(String[] args) {
		
		ListUtil lu = new ListUtil();
		int[] output = lu.findKClosest(new int[] {12, 16, 22, 30, 35, 39, 42, 
               45, 48, 50, 53, 55, 56}, 35, 4);
		
		System.out.println(Arrays.toString(output));
		
		
		output = lu.findKClosest(new int[] {12, 16, 22, 30, 35, 39, 42, 
	               45, 48, 50, 53, 55, 56}, 35, 9);
			
		System.out.println(Arrays.toString(output));
			
		output = lu.findKClosest(new int[] {12, 16, 22, 28, 30, 35, 39, 42, 
		               45, 48, 50, 53, 55, 56}, 33, 3);
				
		System.out.println(Arrays.toString(output));	
		
		output = lu.findKClosest(new int[] {12, 16, 22, 28, 30, 35, 39, 42, 
	               45, 48, 50, 53, 55, 56}, 31, 2);
			
		System.out.println(Arrays.toString(output));		
		
		output = lu.findKClosest(new int[] {12, 16, 22, 30, 35, 39, 42, 
	               45, 48, 50, 53, 55, 56}, 6, 4);
			
		System.out.println(Arrays.toString(output));
		
		output = lu.findKClosest(new int[] {12, 16, 22, 30, 35, 39, 42, 
	               45, 48, 50, 53, 55, 56}, 600, 7);
			
		System.out.println(Arrays.toString(output));		

	}

}
