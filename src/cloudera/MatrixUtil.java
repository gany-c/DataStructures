package cloudera;

public class MatrixUtil {
	
	public int findSumOfLargestIsland(int[][] input){
		
		if(input==null||input.length==0||input[0]==null)
			return -1;
		else
		{
			boolean[][] visited = new boolean[input.length][input[0].length];
			int maxSum = 0;
			
			for(int i=0;i<input.length;i++)
			{
				if(input[i] == null)
					return -1;
			
				for(int j=0;j < input[i].length;j++)
				{
					if(visited[i][j]||input[i][j]==0)
						continue;
					else
					{	
						int sum =getSum(input,visited,i,j);
						if(sum > maxSum)
							maxSum = sum;
					}	
					
				}			
				
			}
			
			return maxSum;
		}
	}

	private int getSum(int[][] input, boolean[][] visited, int i, int j) {
		
		if(i<0||i>=input.length)
			return 0;
		
		if(j<0||j>=input[i].length)
			return 0;
		
		if(visited[i][j]||input[i][j]==0)
			return 0;
		
		visited[i][j] = true;
		
		return input[i][j] + getSum(input,visited,i,j+1) + getSum(input,visited,i+1,j-1)
				+ getSum(input,visited,i+1,j) + getSum(input,visited,i+1,j+1);
		
		
		
		
	}

	public static void main(String[] args) {
		
		MatrixUtil util = new MatrixUtil();
		
		int[][] input = {
				{0,2,0,0,0},
				{1,0,0,0,0},
				{2,0,0,0,4}
		};
		
		int maxSum = util.findSumOfLargestIsland(input);
		System.out.println("------------------------ maxSum = "+maxSum);
		
		
		int[][]  input2 = {
				{0,2,0,0,0},
				{1,0,0,0,0},
				{2,0,0,0,4},
				{0,0,0,0,2}
		};
		
		maxSum = util.findSumOfLargestIsland(input2);
		System.out.println("------------- maxSum = "+maxSum);
		
		int[][]  input3 = {
				{0,2,0,0,0},
				{1,0,0,0,0},
				{2,0,0,0,4},
				{0,0,0,0,2},
				{0,0,7,0,0},
		};
		
		maxSum = util.findSumOfLargestIsland(input3);
		System.out.println("------------- maxSum = "+maxSum);
		
				
	}

}
