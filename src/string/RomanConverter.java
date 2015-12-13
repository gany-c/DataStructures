package string;

import java.util.Map;

/**
 * 
 * @author gchidam
 * 
 * idea is very simple, start at the end and keep adding if you see larger values, else subtract the value from the sum so far
 *
 * 1. Create a static map of characters to integers
 * 2. set a variable for the maximum encountered so far, set a variable for the sum
 * 3. traverse the string in reverse
 * 3.1. get the character and the its value from the map
 * 3.3. if the value is greater than the max value seen, add it to the sume and set it as the new max.
 * 3.4. Else, subtract if from the sum.
 */
public class RomanConverter {
	
	//Create a static map of characters to integers
	private static Map<Character,Integer> valueMap = new java.util.HashMap<Character,Integer>();
	
	static{
		{
			
			valueMap.put('M',1000);
			valueMap.put('D',500);
			valueMap.put('C',100);
			valueMap.put('L',50);
			valueMap.put('X',10);
			valueMap.put('V',5);
			valueMap.put('I',1);
		}
				
	}
	
	//idea is very simple
	//start at the end and keep adding if you see larger values, else subtract the value from the sum so far
	public static int getIndian(String s){
		
		//set a variable for the maximum encountered so far
		int max = 0;
		//set a variable for the sum
		int sum = 0;
	
		//traverse the string in reverse
		for(int i = s.length()-1;i>=0;i--)
		{
			//get the character and the its value from the map
			char c = s.charAt(i);			
			int value = valueMap.get(c);
			
			//if the value is greater than the max value seen
			//add it to the sume and set it as the new max.
			if(value>=max)
			{
				max = value;
				sum = sum + value;
			}
			else
			{
				//else subtract it from the sum.
				sum = sum-value;
			}
		}
		
		
		return sum;
		
	}


	
	public static String getRoman(int i){
		
	return null;
	}
	
	private static boolean isWellFormatted(String S){
		return false;
	}
	
	public static void main(String[] args){
		
		System.out.println(getIndian("IV"));
		System.out.println(getIndian("XVII"));
		System.out.println(getIndian("MCMLXXVII"));//1977
		System.out.println(getIndian("CL"));
		System.out.println(getIndian("CDC"));
	}

}
