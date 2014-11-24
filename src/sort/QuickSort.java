package sort;

public class QuickSort {
	
	public static void sort(int[] a, int lo, int hi)
	{
//		System.out.println("lo, hi = "+lo+", "+hi);
//		display(a);
		
		//if lo and hi are the same or lower
		//then no need to sort
		if(lo >= hi)
			return;
		else if(hi -lo ==1)
		{
			//if the set is just 2 items
			//then a simple swap will do
			if(a[lo] > a[hi])
				swap(a,lo,hi);
			return;
		}
		
		// set one counter at the highest element and one at the lowest
		int i=lo, j=hi;
		
		//set the first element as the pivot
		int pivotPos = i;
		int pivot=a[pivotPos];
		
		
		//start from the second element
		i++;
		
		//as long as the counters haven't crossed paths
		while (i<j)
		{
			//move the first counter until you see a bigger element or you have reached the end
			while (a[i]<=pivot && i < hi) 
				i++;
			
			//move the second counter backwards until you see a smaller element or have reached the beginning
			while (a[j]>=pivot && j > lo) 
				j--;
			
			// if candidates are found swap them
			// else the counters have crossed
			if (i<j)
			{
				swap(a,i,j);
				
				i++; j--;
			}

		}
		
		//if the final swap was done in a position beyond the pivot
		//move the pivot to that location (smaller elements exist until there)
		if(pivotPos < j)
			swap(a,pivotPos,j);
		
		//recursive calls
		if (lo<j) 
			sort(a, lo, j);
		if (i<hi) 
			sort(a, i, hi);
	}
	 
	 
	/**
	* @param startPoint
	* @param endPoint
	*/
	private static void swap(int[] input,int startPoint, int endPoint) 
	{
		int temp=input[startPoint];
		input[startPoint]=input[endPoint];
		input[endPoint]=temp;
	}
	
	public static void main(String[] argv)
	{
		int[] hi = new int[]{-22,123,63,85,231,23,44, 846, 1, -345,0, 84,1103,-33 };
		//even or odd size is one of the issues
		sort(hi,0,hi.length-1);
		display(hi);
		
		hi = new int[]{63,85,231,23,44, 846, 1, -3,0, 84,1103 };
		//even or odd size is one of the issues
		sort(hi,0,hi.length-1);
		display(hi);
		
		hi = new int[]{22,33,44,55,66, 77, 88, 99,100,111 };
		//even or odd size is one of the issues
		sort(hi,0,hi.length-1);
		display(hi);
	}
	
	public static void display(int[] hi)
	{
		System.out.println("\n---displaying---");
		for(int i=0;i<hi.length;i++)
			System.out.print(hi[i]+	" ");
	}

}
