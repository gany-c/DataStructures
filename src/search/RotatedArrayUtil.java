package search;

public class RotatedArrayUtil {
	
	public int rotatedSearch(int[] input, int target){
		
		if(input == null || input.length==0)
			return -1;
		else return rotatedSearch(input, target, 0, input.length-1);
		
	}

	private int rotatedSearch(int[] input, int target, int start, int end) {

		if(start > end)
			return -1;
		
		if(start == end)
			if(input[start]==target)
				return start;
			else
				return -1;
		
		if(input[start] < input[end])
			return binSearch(input,target,start,end);
		
		if(input[start] > target && input[end] < target)
			return -1;
		
		int mid = (start + end)/2;
		
		if(input[mid]==target)
			return mid;
		else{
			 
			int output = rotatedSearch(input,target,start,mid-1);
			if(output < 0)
				output = rotatedSearch(input,target,mid+1,end);
			
			return output;
		}
		

	}
	
	private int binSearch(int[] input, int target, int start, int end) {
		
		if(start > end)
			return -1;
		
		if(start == end)
			if(input[start]==target)
				return start;
			else
				return -1;
		
		if(target < input[start] || target > input[end])
			return -1;
		
		int mid = (start + end)/2;
		 
		if(input[mid]==target)
			return mid;
		else if (input[mid] < target)
			return binSearch(input, target, mid+1,end);
		else 
			return binSearch(input, target, start, mid-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
