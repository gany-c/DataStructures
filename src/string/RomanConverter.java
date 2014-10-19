package string;

public class RomanConverter {
	
	private static java.util.HashMap valueMap = null;
	
	public static int getIndian(String s){
		
		int max = 0;
		int sum = 0;
		
		
		
		for(int i = s.length()-1;i>=0;i--)
		{
			char c = s.charAt(i);			
			int value = getValue(c);
			
			if(value>max)
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

	private static int getValue(char c) {
		
		if(valueMap==null)
		{
			valueMap = new java.util.HashMap();
			valueMap.put('M',1000);
			valueMap.put('D',500);
			valueMap.put('C',100);
			valueMap.put('L',50);
			valueMap.put('X',10);
			valueMap.put('V',5);
			valueMap.put('I',1);
		}
		
		return (Integer)valueMap.get(new Character(c));
		
		
	}
	
	public static String getRoman(int i){
		
	return null;
	}
	
	private static boolean formatCheck(String S){
		return false;
	}

}
