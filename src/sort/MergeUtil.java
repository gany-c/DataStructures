package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author Ramanan
 * 
 */
public class MergeUtil {
	
	public void inplaceMerge(int[] in,int bIndex){
		
	}
	
	/**
	 * Mistakes were in cut-and-paste, used smallArray instead of bigArray and vice versa
	 * @param bigArray
	 * @param smallArray
	 */
	public void reverseMerge(int[] bigArray,int[] smallArray){
		
		if(bigArray==null||bigArray.length==0||smallArray==null||smallArray.length==0)
			return;
		
		int outPointer = bigArray.length-1;
		int inPointer1 = smallArray.length-1;
		
		int inPointer2 = outPointer - smallArray.length;
		
		while(inPointer1 >=0){
			
/*			System.out.println("Step : o "+outPointer+" i1 "+inPointer1+" i2 "+inPointer2);
			for(int i:bigArray)
			{
				System.out.print(i+", ");
			}
			System.out.println();*/

			
			if(inPointer1 < 0)
				bigArray[outPointer--] = bigArray[inPointer2--];
			else if(inPointer2 < 0)
				bigArray[outPointer--] = smallArray[inPointer1--];
			else if(smallArray[inPointer1] >= bigArray[inPointer2])
				bigArray[outPointer--] = smallArray[inPointer1--];
			else
				bigArray[outPointer--] = bigArray[inPointer2--];
			
			
		}
	}

	public static void main(String[] args) {
		
		MergeUtil mu = new MergeUtil();
		
		int[] in1 = {1,3,7,22,-1,-1,-1};
		int[] in2 = {2,6,21};
		
		mu.reverseMerge(in1, in2);
		
		for(int i:in1)
		{
			System.out.print(i+", ");
		}
		System.out.println("\n---------------");
		
		int[] in3 = {1,-1,-1,-1};
		
		mu.reverseMerge(in3, in2);
		
		for(int i:in3)
		{
			System.out.print(i+", ");
		}
		System.out.println("\n---------------");
		
		int[] in4 = {22,-1,-1,-1};
		
		mu.reverseMerge(in4, in2);
		
		for(int i:in4)
		{
			System.out.print(i+", ");
		}			
		

	}
	
	/*
	 * k way merge of k sorted lists
	 * 
	 * 1. First approach was to maintain K pointers, 1 per sub list and keep incrementing the smallest one you find.
	 * 2. This requires k comparison for each of the k *n items. So the complexity is O(k*k*n)
	 * 3. The way of getting rid of redundant comparisons would using a priority queue of size k
	 * 4. Keep removing from the elements from the priorty-queue=>output and replace it with an element from the sublist to which it belonged
	 * 5. What if you moved one from priority-queue to output and the corresponding list becomes empty? It is OK, doesn't have to be replaced
	 * the priority queue merely reduces in size. 
	 */
	public List<Integer> mergeAll(List<List<Integer>> lists)
	{
		if(lists==null || lists.size()==0)
		    return null;
		    
		PriorityQueue<Tuple> q = new PriorityQueue<Tuple>();
	
		int totalSize = init(lists, q);
	
		List<Integer> output = new ArrayList<Integer>();
	
		while(!q.isEmpty()){
	
		Tuple t = q.remove();// get the next element from queue
	
		if(t==null)
		    break;
	
		output.add(t.val);//add it to the output list
	
		if(lists.get(t.index).size()!=0){ // if the sublist is not empty
		    int newVal = lists.get(t.index).remove(0);// get the first element from the sublist
		    q.add(new Tuple(newVal,t.index));// add it to the queue
		}
		 
		if(output.size()==totalSize)
		    break;
		}
		
		return output;

	}

	public int init(List<List<Integer>> lists, PriorityQueue<Tuple> q){

	int totalSize = 0;
	int index =0;

	for(List<Integer> subList:lists){

		if(subList==null || subList.size()==0)
		 lists.remove(subList);//may have to use Index here, we can keep a counter
		 
		q.add(new Tuple(subList.get(0),index)); 
		totalSize = totalSize + subList.size();
		index++;
	}

	return totalSize;
 }

	class Tuple implements Comparable<Tuple>{
		
		public Tuple(int newVal, int index2) {
			this.val = newVal;
			this.index = index2;
		}
		public Integer val;
		public int index;
		@Override
		public int compareTo(Tuple o) {
			
			if(o==null)
				return 1;
			else
				return this.val - o.val;

		}
		
	}

	

}
