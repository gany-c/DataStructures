package misc;

import java.util.Set;
import java.util.TreeSet;

public class FactorUtil {
	
	public Set<Integer> findAllFactors(int input){
		
		if(input <= 0)
			return null;
		else if(input == 1)
		{
			Set<Integer> out = new TreeSet<Integer>();
			out.add(1);
			return out;
		}
		else 
		{
			Set<Integer> out = new TreeSet<Integer>();
			
			for(int i =1;i <= input/2;i++)
			{
				if(input%i == 0)
				{
					out.add(i);
					out.add(input/i);
				}
					
				
			}
			
			return out;
		}
		
		
	}
	
	public Set<Integer> findPrimeFactors(int input){
		
		//DEBUG: System.out.println("input = "+input);
		
		if(input <= 0)
			return null;
		else if(input == 1)
		{
			Set<Integer> out = new TreeSet<Integer>();
			out.add(1);
			return out;
		}
		else if(input ==2)
		{
			Set<Integer> out = new TreeSet<Integer>();
			out.add(1);
			out.add(2);
			return out;
		}
		else
		{
			Set<Integer> out = new TreeSet<Integer>();
			
			
			for(int i =2; i <= input;i++)
			{
				if(out.contains(i))
					continue;
				
				if(input%i == 0)
				{
					out.add(i);
					out.addAll(findPrimeFactors(input/i));
					return out;
				}
			}
			
			return out;
		}
		
	}

	public static void main(String[] args) {
		
		FactorUtil u = new FactorUtil();
		System.out.println(u.findAllFactors(2));
		System.out.println(u.findAllFactors(5));
		System.out.println(u.findAllFactors(366));
		System.out.println(u.findAllFactors(360));
		System.out.println(u.findAllFactors(213));
		
		System.out.println("---------Prime Factors-----------");
		
		System.out.println(u.findPrimeFactors(2));
		System.out.println(u.findPrimeFactors(5));
		System.out.println(u.findPrimeFactors(366));
		System.out.println(u.findPrimeFactors(360));
		System.out.println(u.findPrimeFactors(213));
		System.out.println(u.findPrimeFactors(Integer.MAX_VALUE));
		System.out.println(u.findPrimeFactors(214748364));
		
		

	}

}
