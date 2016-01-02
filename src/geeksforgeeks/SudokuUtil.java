package geeksforgeeks;


import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Ramanan
 * 
 * Problem class - Backtracking 
 * http://www.geeksforgeeks.org/backtracking-set-7-suduku/
 * 
 * High level algorithm is like this:-
 * 
 * 1. If the cell is prefilled skip
 * 2. start at the left corner
 * 2.1. Build a candidate set of numbers which don't violate the row, column or cell constraints
 * 2.2.1 for each candidate number, fill it at the current cell and check if you can solve the entire downstream - recursively
 * ----------If yes, you have a solution, return true;
 * ----------If no, you can reset the cell and fill it with the next candidate number.
 * 2.3. if you are out of candidate numbers, there is no solution; return false
 *
 * MISTAKES MADE:-
 * 1. In the cell boundry calculation, took the quotient itself as the lower bound,
 * --- should have taken quotient * cell size
 * 
 * 2. Forgot to skip over non-zero i.e. prefilled values.
 */
public class SudokuUtil {
	
	private int [][] board = null;
	private int boardSize = 0;
	private int cellSize = 0;
	
	public SudokuUtil(int boardSize, int cellSize, int[][] actualValues){
		
		
		this.board = actualValues;
		this.cellSize = cellSize;
		this.boardSize = boardSize;

	}
	
	 
	public SudokuUtil(int[][] initValues,int boardSize, int cellSize){
		
		this.board = new int[boardSize][boardSize];
		this.cellSize = cellSize;
		this.boardSize = boardSize;
		
		if (initValues == null || initValues.length == 0)
			return;
		
		for(int[] row:initValues){
			
			board[row[0]][row[1]] = row[2];
		}
		
		display(this.board);
	}
	
	public int[][] solve() throws Exception {
		
		boolean result = solveOrSkip(0,0);
		
		if(result)
			return this.board;
		else 
			throw new Exception("Unable to solve");
		
		
	}

	private boolean solveOrSkip(int row, int cell) {
		
/*		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		if(board[row][cell]==0)
			return solve(row,cell);
		else{
			if(cell < board[row].length -1){
				return solveOrSkip(row,cell+1);
			} else if(row < board.length -1){
				return solveOrSkip(row+1,0);
			}
			else
				return true;
		}
	}

	private boolean solve(int row, int cell) {
		
				
		Set<Integer> remainingNum = getRemainingNumbers(row,cell);
		//System.out.println("remaining numbers = "+remainingNum);
		
		for(int cand: remainingNum){
			
			if(!cellValid(row,cell,cand))
				continue;
			else{
				board[row][cell] = cand;
/*				System.out.println("adding at " +row+", "+cell);
				display(this.board);*/
				
				if(cell < board[row].length -1)
				{
					if(solveOrSkip(row,cell+1))
						return true;
					else{
						board[row][cell]  = 0;
/*						System.out.println("reset at " +row+", "+cell);
						display(this.board);*/
					}
						
				}
				else if(row < board.length -1)
				{
					if(solveOrSkip(row+1,0))
						return true;
					else{
						board[row][cell]  = 0;
/*						System.out.println("reset at " +row+", "+cell);
						display(this.board);*/
					}
						
				}
				else 
					return true;// valid item has been placed in the last cell in the board.
			}
		}
		
		return false;
	}

	private boolean cellValid(int row, int cell, int cand) {
		
		int rowNum = row/this.cellSize;
		int cellNum = cell/this.cellSize;
		
		for(int i = rowNum *this.cellSize; i < ( rowNum *this.cellSize) +cellSize; i++)
			for(int j = cellNum * this.cellSize; j < (cellNum * this.cellSize) +cellSize; j++)
				if(board[i][j] == cand)
					return false;
		
		return true;
	}

	private Set<Integer> getRemainingNumbers(int row, int cell) {
		
		Set<Integer> output = new HashSet<Integer>();
		
		for(int i =1;i<= this.boardSize;i++)
			output.add(i);
		
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
		
		int[][] initValues = {{0,2,7},
				{0,4,3},
				{0,6,8},
				{1,3,2},
				{1,5,5},
				{2,0,4},
				{2,3,9},
				{2,5,6},
				{2,8,1},
				{3,1,4},
				{3,2,3},
				{3,6,2},
				{3,7,1},
				{4,0,1},
				{4,8,5},
				{5,1,5},
				{5,2,8},
				{5,6,6},
				{5,7,7},
				{6,0,5},
				{6,3,1},
				{6,5,8},
				{6,8,9},
				{7,3,5},
				{7,5,3},
				{8,2,2},
				{8,4,9},
				{8,6,5}};
		
		
		SudokuUtil util = new SudokuUtil(initValues,9,3);
		
		try {
			int[][] out = util.solve();
			System.out.println("success");
			display(out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		 int[][] initValues2 = {{0,1,3},
				{0,2,4},
				{1,0,4},
				{1,3,2},
				{2,0,1},
				{2,3,3},
				{3,1,2},
				{3,2,1}
				
		};
		
		 util = new SudokuUtil(initValues2,4,2);
		
		try {
			int[][] out = util.solve();
			System.out.println("success");
			display(out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
