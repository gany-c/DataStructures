package string;

import java.util.Map;

public class RomanConverter {
	
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
		
		int max = 0;
		int sum = 0;
	
		for(int i = s.length()-1;i>=0;i--)
		{
			char c = s.charAt(i);			
			int value = valueMap.get(c);
			
			if(value>=max)
			{
				max = value;
				sum = sum + value;
			}
			else
			{
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
