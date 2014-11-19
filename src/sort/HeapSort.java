package sort;

import java.util.Arrays;

public class HeapSort {
	
	/**
	 * 
	 * @param input
	 * @return
	 * 
	 *  probably and O(n) solution exists, but this seems to be O(nlogn)
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
	 * 1. sorting in ascending order
	 * 2. create a max heap
	 * 3. swap the first element and the last element
	 * 4. reduce the heap end by 1
	 * 5. correct the heap
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
	 * just correct within the heap boundry
	 * and swap with greater of the two children
	 * if both of them are greater than the parent.
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
			else
			{
				swap(input,index,right);
				correctHeapDown(input,right,end);				
			}
		}

		
	}

	public static void main(String[] args){
		
		HeapSort sorter = new HeapSort();
		

		
		System.out.println(Arrays.toString(sorter.sort(new int[]{1,2,3,5,66,7,89,78738,34387694,43734,187,16384,158475,77,29584,5494,498,99})));
		
	}

}
