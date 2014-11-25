package sort;

public class MergeSort {
	
	public void sort(int[] input)
	{
		sortFunction(input,0,input.length-1);
	}

	private void sortFunction(int[] input, int start, int end) {
		
		if(start<end)
		{
			int midPos = (start+end)/2;
			sortFunction(input,start,midPos);
			sortFunction(input,midPos+1,end);
			merge(input,start,midPos,end);
		}
		
	}

	private void merge(int[] input, int start, int midPos, int end) {
		
		int[] temp = new int[end-start+1];
		
		for(int i=0;i<temp.length;i++)
			temp[i] = input[start+i];
		
		int i = 0;//setting i =0 is equivalent to subtracting start from start
		int j = midPos+1-start;//so, subtract start from midpos also.
		int tempos =start;
		
		while(i<=midPos-start&&j<=temp.length-1)
		{
			
			//System.out.println(i+" "+midPos+" "+j+" "+end);
			
			if(temp[i]<=temp[j])
				input[tempos++] = temp[i++];
			else
				input[tempos++] = temp[j++];			
			
		}
		
		while(i<=midPos-start)
			input[tempos++] = temp[i++];
		
		
	}
	
	public static void display(int[] hi)
	{
		System.out.println("\n---displaying---");
		for(int i=0;i<hi.length;i++)
			System.out.print(hi[i]+	" ");
	}
	
	public static void main(String args[])
	{
		int[] random = new int[]{100,99,63, 42,56,77,0,-1};
		
		MergeSort sorter = new MergeSort();
		sorter.sort(random);
		
		display(random);
		
		int[] hi = new int[]{-22,123,63,85,231,23,44, 846, 1, -345,0, 84,1103,-33 };
		//even or odd size is one of the issues
		sorter.sort(hi);
		display(hi);
		
		hi = new int[]{63,85,231,23,44, 846, 1, -3,0, 84,1103 };
		//even or odd size is one of the issues
		sorter.sort(hi);
		display(hi);
		
		hi = new int[]{22,33,44,55,66, 77, 88, 99,100,111 };
		//even or odd size is one of the issues
		sorter.sort(hi);
		display(hi);
	}

}
