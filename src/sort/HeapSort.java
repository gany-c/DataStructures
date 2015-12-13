package sort;

import java.util.Arrays;

/**
 * 
 * @author gchidam
 * 
 * very simple :)
 * 
 * HEAPSORT Problem: sorting an array in ascending order
 * 1. Organize the entire as a max heap - using heapify
 * 2. Until the heap boundary is at size 1
 * 2.1. swap the first element and the last element of the heap
 * 2.2. reduce the heap boundary by 1
 * 2.3. correct the heap property
 * 
 * HEAPIFY:
 * 
 * 	 *  1. Traverse the length of the array
	 *  1.1. at every element invoke the recursive bubbleUp method. 
	 *  2. recursive bubbleUp will be required over all nodes, because a single bubbleUp may cover all nodes but will compare immediate neighbors only
	 *  Thus heap property can be violated.
	 *  
	
 * BUBBLEUP:
 * 
 * * 1. Locate the element's parent index
	 * 2. if the parent is lesser that the current element, swap the elements and
	 * 2.1. Call the bubbleUp method recursively at the parent location.
	 * 
	 * 
 *  CORRECTHEAPDOWN: very simple :)
	 * 
	 * 1. Recursive top down method
	 * 2. Start at the index provided, if the children are outside the heap boundary break out
	 * 3. If both children violate the max-heap property, swap the parent with the bigger child and recurse at that index
	 * 4. Else swap the parent with the child that violates the max-heap property, if any and recurse there
 */
public class HeapSort {
	
	/**
	 * 
	 * @param input
	 * @return
	 * 
	 *  probably and O(n) solution exists, but this seems to be O(nlogn)
	 *  
	 *  1. Traverse the length of the array
	 *  1.1. at every element invoke the recursive bubbleUp method. 
	 *  
	 *  
	 *  recursive bubbleUp will be required over all nodes, because a single bubbleUp may cover all nodes but will compare immediate neighbors only
	 *  Thus heap property can be violated.
	 */
	
	int[] maxHeapify(int[] input){
		
		for(int i=0;i<input.length;i++){
			bubbleUp(input,i);
		}
		
		
		return input;
	}

	/**
	 * 1. Locate the element's parent index
	 * 2. if the parent is lesser that the current element, swap the elements and
	 * 2.1. Call the bubbleUp method recursively at the parent location.
	 * @param input
	 * @param i
	 */
	private void bubbleUp(int[] input, int i) {

		if(i==0)
			return;
		else 
		{
			int parent;
			
			if(i%2 == 1)
				parent = i/2;
			else
				parent = i/2 -1;
			
			
			
			if(input[parent] < input[i])
			{
				swap(input,parent,i);
				bubbleUp(input,parent);
			}
				
			
		}
		
	}

	private void swap(int[] input, int parent, int i) {
		
		int temp = input[parent];
		input[parent] = input[i];
		input[i] = temp;
		
	}
	/**
	 * 
	 * @param input
	 * @return
	 * 
	 * HEAPSORT Problem: sorting an array in ascending order
	 * 1. Organize the entire as a max heap - using heapify
	 * 2. Until the heap boundary is at size 1
	 * 2.1. swap the first element and the last element of the heap
	 * 2.2. reduce the heap boundary by 1
	 * 2.3. correct the heap property
	 */
	public int[] sort(int[] input){
		
		int[] heap = maxHeapify(input);
	
		for(int i = heap.length-1;i>0;i--){
			
			swap(heap,i,0);

			correctHeapDown(heap,0,i-1);

		}
		
		return input;
	}
	
	/**
	 * 
	 * @param input
	 * @param index
	 * @param end
	 * 
	 * very simple :)
	 * 
	 * 1. Recursive top down method
	 * 2. Start at the index provided, if the children are outside the heap boundary break out
	 * 3. If both children violate the max-heap property, swap the parent with the bigger child and recurse at that index
	 * 4. Else swap the parent with the child that violates the max-heap property, if any and recurse there
	
	 */
	private void correctHeapDown(int[] input, int index, int end) {
		
		int left = 2*index+1;
		int right = 2*index+2;
		
		if(left > end)
			return;
		else if(right > end)
		{
			if(input[index] < input[left])
			{
				swap(input,index,left);
				correctHeapDown(input,left,end);
			}
		}
		else
		{
			if(input[index] < input[left] && input[index] < input[right])
			{
				if(input[left] > input[right])
				{
					swap(input,index,left);
					correctHeapDown(input,left,end);					
				}
				else
				{
					swap(input,index,right);
					correctHeapDown(input,right,end);
				}
			}
			else if(input[index] < input[left])
			{
				swap(input,index,left);
				correctHeapDown(input,left,end);	
			}
			else if(input[index] < input[right])
			{
				swap(input,index,right);
				correctHeapDown(input,right,end);				
			}
		}

		
	}

	public static void main(String[] args){
		
		HeapSort sorter = new HeapSort();		

		
		System.out.println(Arrays.toString(sorter.sort(new int[]{1,2,3,5,66,7,89,78738,34387694,43734,187,16384,158475,77,29584,5494,498,99})));
		
		System.out.println(Arrays.toString(sorter.sort(new int[]{29584,5494,498,99,45723675,372357,5475,-33,44,7564120,88,11})));
		
	}

}
