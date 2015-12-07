package misc;

import java.util.Set;
import java.util.TreeSet;

public class FactorUtil {
	
	/**
	 * 
	 * @param input
	 * @return
	 * 
	 * 1. if input is 0 or lesser return null
	 * 2. if input is 1, return a set containing 1.
	 * 3. i Starting from 1 and until input/2
	 * 3.a. check if input is divisible by i
	 * 3.b. if yes, add divisor and quotient to the set
	 * 4. Use a tree set to print in order
	 */
	public Set<Integer> findAllFactors(int input){
		
		// if input is 0 or lesser return null
		if(input <= 0)
			return null;
		else if(input == 1)
		{//if input is 1, return a set containing 1.
			Set<Integer> out = new TreeSet<Integer>();
			
			return out;
		}
		else 
		{
			Set<Integer> out = new TreeSet<Integer>();
			
			//Starting from 1 and until input/2
			for(int i =1;i <= input/2;i++)
			{
				//check if input is divisible by i
				if(input%i == 0)
				{
					//if yes add divisor and quotient to the set
					if(i!=1)
						out.add(i);
					out.add(input/i);
				}
					
				
			}
			
			return out;
		}
		
		
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 * 
	 * 1. if input equals 0, 1 or 2 return special cases.
	 * 2. create empty output set
	 * 3. for i from 2 to the number
	 * 3.a. if output contains i, skip the loop
	 * 3.b. if i perfectly divides the input
	 * 3.c. add i to the output, recursively invoke it on the quotient
	 * 
	 */
	public Set<Integer> findPrimeFactors(int input){
		
		//DEBUG: System.out.println("input = "+input);
		//if input equals 0, 1 or 2 return special cases.
		if(input <= 0)
			return null;
		else if(input == 1)
		{
			Set<Integer> out = new TreeSet<Integer>();	
			return out;
		}
		else if(input ==2)
		{
			Set<Integer> out = new TreeSet<Integer>();			
			out.add(2);
			return out;
		}
		else
		{
			//create empty output set
			Set<Integer> out = new TreeSet<Integer>();
			
			//for i from 2 to the number
			for(int i =2; i <= input;i++)
			{
				//if output contains i, skip the loop
				if(out.contains(i))
					continue;
				
				//if i perfectly divides the input
				if(input%i == 0)
				{
					//add i to the output
					out.add(i);
					
					//recursively invoke it on the quotient
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
		System.out.println(u.findPrimeFactors(12));
		System.out.println(u.findPrimeFactors(30));
		System.out.println(u.findPrimeFactors(366));
		System.out.println(u.findPrimeFactors(360));
		System.out.println(u.findPrimeFactors(213));
		System.out.println(u.findPrimeFactors(144));		
		System.out.println(u.findPrimeFactors(214748364));
		System.out.println(u.findPrimeFactors(Integer.MAX_VALUE));
		
		

	}

}
