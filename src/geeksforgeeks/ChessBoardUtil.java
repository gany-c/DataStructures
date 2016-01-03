package geeksforgeeks;

/**
 * http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
 * PROBLEM CLASS:- BACKTRACKING
 * 
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
 * 
 * 1. Traverse the board, starting from the first row, and move to the other rows recursively
 * 2. In each row - check if a cell is a valid cell for placing the queen
 * 2.1. if not check the next cell
 * 2.2. if yes, mark it as a queen position
 * 2.2.1 Do a recursive check for the next rows from there
 * 2.2.2 if that succeeds, return true
 * 2.2.3 Else reset the position to 0
 * 
 * MISTAKES made - 
 * 1. Wrongly assumed both diagonals will be of same size and hence can be checked in one loop
 * 2. Counter  > and < typo
 * 3. Counter array.length and array.length -1 confusion.
 * 
 * @author Ramanan
 *
 */
public class ChessBoardUtil {
	
	public int[][] getNQueensBoard(int n) throws Exception{
		
		if(n<=0)
			throw new Exception("Invalid number of Queens, "+n);
		
		int[][] board = getEmptyBoard(n);
		
		boolean success = placeQueens(board, n, 0);
		
		if(!success)
			throw new Exception("Unable to place the queens in non attacking positions, "+n);
		else
			return board;
	}

	private boolean placeQueens(int[][] board, int numQueens, int index) {
		
		int[] row = board[index];
		
		for(int i = 0; i < row.length; i++){
			
			if(!valid(board,index,i))
				continue;
			else {
				
				board[index][i] = 1;
				
				if(index == board.length -1 || numQueens ==1)
					return true;
				else if (placeQueens(board,numQueens-1,index+1))
					return true;
				else{
					board[index][i] = 0 ;
					
				}
				
			}
		}
		
		return false;
	}

	private boolean valid(int[][] board, int rowIndex, int cellNum) {
		
		if(rowIndex == 0)
			return true;
		
		//Check the column
		for(int i = rowIndex; i >= 0; i--){
			
			if(board[i][cellNum] == 1)
				return false;
		}
		
		int i = rowIndex -1; int j= cellNum + 1;
		
		//check the diagnols - two separate loops are required because the diagnols will be most likely of different lengths.
		while( i >= 0 && j <= board.length -1 ){
			
			if(board[i][j] ==1)
				return false;
			
			i--;
			j++;
		}
		
		 i = rowIndex -1; int k = cellNum - 1;
		
		while( i >= 0 && k >=0){
			
			if(board[i][k] ==1)
				return false;
			
			i--;
			k--;
		}		
		
		return true;
	}

	private int[][] getEmptyBoard(int n) throws Exception {
		
		if(n <= 0)
			throw new Exception("invalid dimensions");
		
		int[][] out = new int[n][n];
		return out;
	}

	public static void main(String[] args) {
		System.out.println("\n Starting the N queens problem ");
		
		ChessBoardUtil boardUtil = new ChessBoardUtil();
		
		try 
		{
			int[][] output = boardUtil.getNQueensBoard(1);			
			display(output);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try 
		{
			int[][] output = boardUtil.getNQueensBoard(2);			
			display(output);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		try 
		{
			int[][] output = boardUtil.getNQueensBoard(3);			
			display(output);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}	
		
		try 
		{
			int[][] output = boardUtil.getNQueensBoard(4);			
			display(output);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}	
		
		try 
		{
			int[][] output = boardUtil.getNQueensBoard(5);			
			display(output);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}		
		
		try 
		{
			int[][] output = boardUtil.getNQueensBoard(8);			
			display(output);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}	

	}

	private static void display(int[][] output) {
		
		if(output == null || output.length ==0)
			return;
		
		System.out.println("\n ------------------------------ ");
		
		for(int[] line: output)
		{
			for(int cell:line)
				System.out.print(cell+", ");
			System.out.println();
		}
		
		System.out.println("\n ------------------------------ ");
		
	}

}
