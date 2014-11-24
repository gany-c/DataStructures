package misc;

import java.util.HashSet;
import java.util.Set;

import base.DupSet;

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
					Set<DupSet> inner1 = findAllSumSets(pair.get(0));
					
					for(DupSet innerSet: inner1)
					{
//						System.out.println(pair.get(0)+": innerSet = "+innerSet);
						innerSet.add(pair.get(1));	
//						System.out.println(" innerSet, after combining = "+innerSet);
//						System.out.println(" innerSet, already exists = "+output.contains(innerSet));
//						System.out.println(" innerSet, map  = "+innerSet.getMap());
						output.add(innerSet);
					}
						
				}
				
				if(pair.get(1) >1)
				{
					Set<DupSet> inner1 = findAllSumSets(pair.get(1));
					
					for(DupSet innerSet: inner1)
					{
//						System.out.println(pair.get(1)+": innerSet = "+innerSet);
						innerSet.add(pair.get(0));		
//						System.out.println(" innerSet, after combining = "+innerSet);
//						System.out.println(" innerSet, already exists = "+output.contains(innerSet));
//						System.out.println(" innerSet, map  = "+innerSet.getMap());
						output.add(innerSet);
					}
						
				}
			}
			
			output.addAll(twoSets);
			
			return output;
			
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
