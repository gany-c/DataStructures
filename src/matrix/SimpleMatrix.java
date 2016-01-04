package matrix;

public class SimpleMatrix {
	
	public static void main(String[] args){
		
		System.out.println("Hi");
		
		int[][] a = {{1,2,3},{4,5,6}};
		int[][] b = {{2},{8},{9}};
	
		SimpleMatrix sm = new SimpleMatrix();
		int[][] c = sm.matrixMultiply(a, b);
		
		display(c);
		
		int[][] d = {{1,2,3},{4,5,6},{1,1,2}};
		
		int[][] result = sm.matrixMultiply(a, d);
		
		display(result);
		
		/**
		 * Hi
--------------------------
45 
102 
--------------------------
12 15 21 
30 39 54 
		 */
	}
	
	public static void display(int[][] c){
		
		System.out.println("--------------------------");
		for(int i =0; i < c.length; i++)
		{
			
			int[] row = c[i];
			
			for(int j = 0;j < row.length;j++)
			{
				System.out.print(row[j]+" ");
			}
			
			System.out.println();
		}
		
	}
	
	/**
	 * MATRIX MULTIPICATION
	 * 
	 * 1. INVOLVES 3 NESTED LOOPS.
	 * 2. THE FIRST 2 LOOPS ARE FOR visiting each cell of the output matrix.
	 * 3. THE THRID LOOP IS TO do the sum or products of input 1's row and input's column
	 * @param in1
	 * @param in2
	 * @return
	 */
	public int[][] matrixMultiply(int[][] in1,int[][] in2){
		
		//check if dimensions are valid
		if(isDimValid(in1,in2))
		{
			//create an empty matrix of size = num rows of first, num columns of second
			int[][] output = new int[in1.length][in2[0].length];
			
			//for each row
			for(int i =0; i < output.length; i++)
			{
				//for each column
				for(int j=0; j < output[0].length; j++)
				{
					//initialize an element
					output[i][j] = 0;
					
					//sum the products of row i + column j
					for(int k=0;k<in2.length;k++)
					{
						output[i][j] += in1[i][k] * in2[k][j];
					}
					
					
				}
				
			}
			
			return output;
		}
		else
		{
			return null;
		}
		
		
	}

	private boolean isDimValid(int[][] in1, int[][] in2) {

		if(in1==null||in2==null||in1.length==0||in2.length==0) 
			return false;
		else
		{
			int rowLength = in1[0].length;
			
			if(rowLength==0)
			{
				return false;
			}
			else
			{
				if(rowLength == in2.length)
					return true;
				else
					return false;
			}
		}
	}

}
