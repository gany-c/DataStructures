package misc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumUtilBox {
	
	// We have a list of numbers, and we want to find if any two of them sum to 0. return: boolean
	// Example: [0, 2, 3, 4, 5]
	/*
	 * 
	 * 1. What happens when the target sum is zero? 
	 * then it becomes necessary to distinguish between one zero and two 0s in the list
	 * 
	 * 2. What if the input list is Sorted? 
	 * The time will still be linear, but space can be saved - won't need the hashset
	 * ---Have 2 pointers one at each end and collapse them until you find a mutual inverse
	 * ---You can eliminate all negatives and all positives
	 * --- Will you use Binary search to advance to the next position?
	 * 
	 * 3. What if you want to check the sum of 3 numbers?
	 * --- Add binary sums to HashSet and Check for Sum-3rd number being in the hashset
	 * --- How will you avoid using the same number here? 
	 * i.e. both as 3rd number and as one of the binary sum numbers
	 * ---- Use a multivalued map in addition to the set
	 * ---- i.e. e.g. [Key=SUM, Values=[{pair1},{pair2}...]
	 * --	EVEN BETTER, INVOKE THE 2 SUM RECURSIVELY - FOR EACH NUMBER
	 * ---- PARAMETERS WILL BE, TARGET-SUM - NUMBER & REMAINING NUMBERS IN THE LIST.
	 * 
	 -66 -5 4 6 10 11 52 66 
	 
	 Ex: [-3, 0, 1, 1, 2]
	      
	 Hashset: {(-3, 0), (0, 1), (1, 2), (1, 3), (2, 4)}
	 
	 1, 1, -2 
	 1, -2
	*/
	public boolean isZeroSumPresent(List<Integer> input) throws Exception{

	// check if the list is null, should be at least 2 
	 if(input ==null || input.size() <=1)
	     throw new Exception("Invalid list, please give a list of at least 2 numbers");
	     
	//empty hashset     
	Set<Integer> numSet = new HashSet<>();
	int zeroCount = 0;

	//filling up the hashset
	for(Integer i: input)
	{
	    if(i ==0)
	    {
	        zeroCount++;
	        if(zeroCount > 1)
	            return true;
	     }
	    else     
	        numSet.add(i);
	}

	//for each number,
	for(Integer i:input){

	    //check if the negative inverse of the number is available
	    // in the set
	    // if yes return true
	    if(numSet.contains(0-i)){
	        return true;
	    }    
	}

	return false;

	}     
	     
	// follow-up #1: check for 3 numbers. return boolean
	 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
