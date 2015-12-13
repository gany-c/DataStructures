package misc;

import java.util.HashSet;
import java.util.Set;

import base.DupSet;

/**
 * 
 * @author Ramanan
 * 
 * QUESTION: find all the ways in which a number can be summed, Ramanujan's partitions :)
 * 
 * Find the pairs of numbers which sum up to the input
 * and if any of the pair members is greater than 2, 
 * recursively calculate for that item and combine the other number of the pair with all the sets found
 * 
 * 1. if n is less than 2, return null
 * 2. if n equals 2 return a set containing a single pair of 1 and 1
 * 3. Else, get all the pairs of Sums 
 * 3.1. for each pair
 * 3.1.1 if the first number is greater than 1, recursively call itself for the first number and append the second number to all the generated sets
 * 3.1.2 and vice versa
 * 3.2. Add the 2-sets and the recursively created sets to the output
 * 
 * FINDING 2 Pair sums:
 * 
 * 1. if n is less than 2, retrun 1
 * 2. if n exactly equals 2, return a pair of 1,1
 * 3. for i starting at 1 and up to n/2, create pairs of i and n -i
 * 
 */

public class SumUtil {
	
	public Set<DupSet> findAllSumSets(int n){
		
		//if n is less than 2, return null
		if(n <2)
			return null;
		else if (n==2)
		{
			//if n equals 2 return a set containing a single pair of 1 and 1
			DupSet inner = new DupSet();
			inner.add(1);
			inner.add(1);
			Set<DupSet> outer = new HashSet<DupSet>();
			outer.add(inner);
			return outer;
		}
		else
		{
			//else, get all the pairs of Sums 
			Set<DupSet> twoSets = getAllTwoSets(n);
			
			Set<DupSet> output = new HashSet<DupSet>();
			
			//for each pair
			for(DupSet pair:twoSets)
			{
				//if the first number is greater than 1, recursively call itself for the first number and append the second number to all the generated sets
				if(pair.get(0) >1)
				{
					combineWithInnerPartitions(pair.get(0),pair.get(1),output);
						
				}
				//and vice versa
				if(pair.get(1) >1)
				{
					combineWithInnerPartitions(pair.get(1),pair.get(0),output);
						
				}
			}
			
			//add the two sets also to the output.
			output.addAll(twoSets);
			
			return output;
			
		}
		
		
	}

	private void combineWithInnerPartitions(int firstNumber, int secondNumber, Set<DupSet> output) {

		Set<DupSet> inner = findAllSumSets(firstNumber);
		
		for(DupSet innerSet: inner)
		{

			innerSet.add(secondNumber);	

			output.add(innerSet);
		}
		
	}

	private Set<DupSet> getAllTwoSets(int n) {

		// if n is less than 2, retrun 1
		if(n <2)
			return null;
		else if (n==2)
		{// if n exactly equals 2, return a pair of 1,1
			DupSet inner = new DupSet();
			inner.add(1);
			inner.add(1);
			Set<DupSet> outer = new HashSet<DupSet>();
			outer.add(inner);
			return outer;
		}
		else
		{
			Set<DupSet> outer = new HashSet<DupSet>();
			
			//for i starting at 1 and up to n/2
			// create pairs of i and n-i.
			for(int i =1; i<=n/2;i++)
			{
				DupSet inner = new DupSet();
				inner.add(i);
				inner.add(n-i);
				outer.add(inner);
			}
			
			return outer;
			
		}
		
		
	}
	
	public static void main(String[] args){
		
		System.out.println("Hi      ----------------------------");
		SumUtil util = new SumUtil();
		
		Set<DupSet> twoSets = util.findAllSumSets(5);
		
		for(DupSet set:twoSets){
			System.out.println(set);
		}
		
		System.out.println("Hi      ----------------------------");
		
		Set<DupSet> sumSets = util.findAllSumSets(7);
		
		for(DupSet set:sumSets){
			System.out.println(set);
		}
		
		
		
	}

}
