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
 * Calculate the 2 sum pairs and if any of the pair items is greater than 2, 
 * recursively calculate for that item
 * 
 */

public class SumUtil {
	
	public Set<DupSet> findAllSumSets(int n){
		
		if(n <2)
			return null;
		else if (n==2)
		{
			DupSet inner = new DupSet();
			inner.add(1);
			inner.add(1);
			Set<DupSet> outer = new HashSet<DupSet>();
			outer.add(inner);
			return outer;
		}
		else
		{
			Set<DupSet> twoSets = getAllTwoSets(n);
			
			Set<DupSet> output = new HashSet<DupSet>();
			
			for(DupSet pair:twoSets)
			{
				if(pair.get(0) >1)
				{
					combineWithInnerPartitions(pair.get(0),pair.get(1),output);
						
				}
				
				if(pair.get(1) >1)
				{
					combineWithInnerPartitions(pair.get(1),pair.get(0),output);
						
				}
			}
			
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

		
		if(n <2)
			return null;
		else if (n==2)
		{
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
