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
Note that if the element is present in array, then it should not be in output, only the other closest elements are required.
 *
 */
public class ListUtil {
	
	public int[] findKClosest(int[] input, int num, int k){
		
		if(input == null||input.length==0)
			return null;
		
		if(k <= 0)
			return null;
		
		if(input.length <= k)
			return input;
		
		int[] bounds = binSearch(input,num);
		System.out.println("Done calculating bounds "+Arrays.toString(bounds));
		
		return kClosestFromBounds(input,bounds,num,k);
		
		
	}

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
		

		
		if(num < input[0])
			return new int[]{-1,0};
		
		if(num > input[input.length-1])
			return new int[]{input.length-1,input.length};		
		
		int[] bounds = new int[2];
		
		int start =0, end = input.length-1;
		
		int mid = (start + end)/2;
		
		while(start < end)
		{			
			mid = (start + end)/2;
						
			
			if(input[mid]==num||end-start ==1)
				break;
			else if(num < input[mid] )
				end = mid;
			else
				start = mid;
		}
		
		if(input[mid]==num)
		{
			bounds[0] = mid -1;
			bounds[1] = mid +1;
		}
		else if(input[mid] < num)
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
		
		output = lu.findKClosest(new int[] {12, 16, 22, 30, 35, 39, 42, 
	               45, 48, 50, 53, 55, 56}, 6, 4);
			
		System.out.println(Arrays.toString(output));
		
		output = lu.findKClosest(new int[] {12, 16, 22, 30, 35, 39, 42, 
	               45, 48, 50, 53, 55, 56}, 600, 7);
			
		System.out.println(Arrays.toString(output));		

	}

}
