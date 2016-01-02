package geeksforgeeks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sudoku9x3Util {
	
	int [][] board = null;
	 
	public Sudoku9x3Util(int[][] initValues){
		
		this.board = new int[9][9];
		
		if (initValues == null || initValues.length == 0)
			return;
		
		for(int[] row:initValues){
			
			board[row[0]][row[1]] = row[2];
		}
	}
	
	public int[][] solve() throws Exception {
		
		boolean result = solve(0,0);
		
		if(result)
			return this.board;
		else 
			throw new Exception("Unable to solve");
	}

	private boolean solve(int row, int cell) {
		
		Set<Integer> remainingNum = getRemainingNumbers(row,cell);
		
		for(int cand: remainingNum){
			
			if(!cellValid(row,cell,cand))
				continue;
			else{
				board[row][cell] = cand;
				
				if(cell < board[row].length -1)
				{
					if(solve(row,cell+1))
						return true;
					else
						board[row][cell]  = 0;
				}
				else if(row < board.length -1)
				{
					if(solve(row+1,0))
						return true;
					else
						board[row][cell]  = 0;
				}
				else 
					return true;// valid item has been placed in the last cell in the board.
			}
		}
		
		return false;
	}

	private boolean cellValid(int row, int cell, int cand) {
		
		int rowStart = row/3;
		int cellStart = cell/3;
		
		for(int i = rowStart; i < rowStart +3; i++)
			for(int j = cellStart; j < cellStart +3; j++)
				if(board[i][j] == cand)
					return false;
		
		return true;
	}

	private Set<Integer> getRemainingNumbers(int row, int cell) {
		
		Set<Integer> output = new HashSet<Integer>();
		output.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
		
		//column delete
		for(int i =0; i < board.length;i++)
			output.remove(board[i][cell]);
		
		for(int i =0; i < board[row].length;i++)
			output.remove(board[row][i]);		
		
		return output;
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
	
	public static void main(String[] args){
		
	}

}
