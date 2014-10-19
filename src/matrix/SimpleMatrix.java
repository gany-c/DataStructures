package matrix;

public class SimpleMatrix {
	
	public static void main(String[] args){
		
		System.out.println("Hi");
		
		int[][] a = {{1,2,3},{4,5,6}};
		int[][] b = {{2},{8},{9}};
		
		SimpleMatrix sm = new SimpleMatrix();
		int[][] c = sm.matrixMultiply(a, b);
		
		for(int i =0; i < c.length; i++){
			
			int[] row = c[i];
			
			for(int j = 0;j < row.length;j++)
			{
				System.out.print(row[j]+" ");
			}
			
			System.out.println();
		}
	}
	
	public int[][] matrixMultiply(int[][] in1,int[][] in2){
		
		if(isDimValid(in1,in2))
		{
			
			int[][] output = new int[in1.length][in2[0].length];
			
			for(int i =0; i < in1.length; i++)
			{
				
				for(int j=0; j < in2[0].length; j++)
				{
					output[i][j] = 0;
					
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
