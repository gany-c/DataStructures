package matrix;

public class SimpleMatrix {
	
	public static void main(String[] args){
		
		System.out.println("Hi");
	}
	
	public int[][] matrixMultiply(int[][] in1,int[][] in2){
		
		if(isDimValid(in1,in2))
		{
			
			int[][] output = new int[in1.length][in2[0].length];
			
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
