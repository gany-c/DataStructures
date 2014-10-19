package sort;

public class QuickSort {
	
	public static void sort(int[] a, int lo, int hi)
	{
	int i=lo, j=hi;
	int pivotPos = (lo+hi)/2;
	int x=a[pivotPos];
	//pivot is placed at the center
	int numSwap =0;
	// all smaller to the left, all greater to the right
	while (i<j)
	{
		while (a[i]<x) 
			i++;
		while (a[j]>x) 
			j--;
		
		if (i<j)
		{
			swap(a,i,j);
			numSwap++;
			i++; j--;
		}
		else
			break;
	}
	if(numSwap==0)
		return;
	if (lo<j) 
		sort(a, lo, j);
	if (i<hi) 
		sort(a, i, hi);
	}
	 
	 
	/**
	* @param startPoint
	* @param endPoint
	*/
	private static void swap(int[] input,int startPoint, int endPoint) {
	int temp=input[startPoint];
	input[startPoint]=input[endPoint];
	input[endPoint]=temp;
	}
	public static void main(String[] argv)
	{
	int[] hi = new int[]{123,63,85,231};
	//even or odd size is one of the issues
	sort(hi,0,3);
	display(hi);
	}
	public static void display(int[] hi)
	{
	for(int i=0;i<hi.length;i++)
	System.out.print(hi[i]+
	" ");
	}

}
