package DS.matrix;

public class SimpleMatrix {
	
	public int[][] matrixMultiply(int[][] in1,int[][] in2){
		
		if(isDimValid(in1,in2))
		{
			
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
