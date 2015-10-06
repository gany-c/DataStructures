package sort;

public class MergeUtil {
	
	public void inplaceMerge(int[] in,int bIndex){
		
	}
	
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

}
