package cloudera;

/**
 * 
 * @author Ramanan
 * -------------------

 * A matrix is split into islands, by a sea of zeroes :)
 * Find the island with the largest sum
 * 
 * 1. Create a boolean matrix of same dimensions - to say which pixel is visited.
 * -- alternative could be set it to 2.
 * 2. Traverse the original matrix, row by row, 
 * 2.1. if the pixel is not zero and it is not marked visited in the other matrix,
 * 2.2. Start a recursive function, for exploring
 * 2.2.1 it should add it's own value to the sum and recursively call all its neighboring pixels
 * 2.2. Once the sum is returned, compare it with the maximum sum recorded.
 * 
 * Note:- Even though the traversal goes from top to bottom, an upwards neighbor recursion is also 
 * necessary. Otherwise, will fail if the island is U shaped with right bar of the U shorter 
 *  than the left bar
 * *  
 * -------------------------------------- 
 * A more accurate version of this code is in the comments below.
 * The recursive function i.e. getSum is wrong in that it doesn't 
 * check upwards
 * 
 *  This will fail if the island is U shaped with right bar of the U shorter 
 *  than the left bar
 *  
 *  Uncommented code tries and fails with diagonal connections too
 *  Commented code has just non vertical and horizontal connections.
 *
 */
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



/* 



/**
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water



Q: count the number of islands
  
11110
11010
11000
00000

1 all the "1"s are connected

11000
11000
00100
00011

output: 3

  
 public int countNumIslands(int[][] input){
  
  if(input==null||input.lenght==0)
    return 0;
  
  int numIslands = 0;
  boolean[][] visited = new boolean[input.length][input[0].length];
  
  for(int i =0 ; i < input.length; i++)
  {
    for(int j =0; j < input[i].length;j++)
    {
      if(input[i][j]==0||visited[i][j])
        continue;
       
      numIslands++;
      
      exploreIsland(input,visited,i,j);
    } 
  }  
  
}

private void exploreIsland(int[][] input, boolean[][] visited,int i,int j){
  
  if(i<0||i>=input.length||j<0||j>=input[i].length)
    return;
  
  
  if(visited[i][j] = true||input[i][j]==0)
    return;
    
  visited[i][j] = true;
  
  exploreIsland(input,visited,i,j+1);//right cell
  exploreIsland(input,visited,i+1,j);//down cell
  exploreIsland(input,visited,i,j-1);//left cell, if we arrived at this cell from top
  exploreIsland(input,visited,i-1,j);//up cell, if we arrived from down
}
**/
