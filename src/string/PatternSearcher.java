package string;

public class PatternSearcher {
	
	public static boolean find(String pattern, String input)
	{
		if(pattern==null||pattern.isEmpty()||input==null||input.isEmpty()||pattern.length()>input.length())
			return false;
		else
		{
			
			//if both are of equal length the loop should run at least once.
			for(int i =0;i <=input.length()-pattern.length();i++){
				if(subString(pattern,0,input,i))
					return true;
			}
			
			return false;
		}
	}
	
	private static boolean subString(String pattern, int patIndex, String input, int inpIndex) {
		
		//System.out.println(pattern+" "+patIndex+" "+input+" "+inpIndex);

		if(pattern.charAt(patIndex)==input.charAt(inpIndex)||pattern.charAt(patIndex)=='?')
		{	
			if(patIndex == pattern.length()-1)
				return true;
			else
				return subString(pattern, patIndex+1, input, inpIndex+1);
		}
		else if(pattern.charAt(patIndex)=='*')
		{
			if(patIndex == pattern.length()-1)
				return true;
			else
			{
				int remainingPatLength = pattern.length() - patIndex;
				
				for(int i = inpIndex; i <= input.length() - remainingPatLength;i++)
					if(subString(pattern,patIndex+1,input,i))
						return true;
				
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	public static void main(String[] args){
		

		
		System.out.println(find("himan","himan"));
		System.out.println(find("man","himan"));
		System.out.println(find("mahi","himan"));
		System.out.println(find("himanhowareyou","himan"));
		System.out.println(find("himan","somethingandallhimanhowareyou"));
		System.out.println(find("h?man","somethingandallhimanhowareyou"));
		System.out.println(find("h?m?n","somethingandallhemonhowareyou"));
		System.out.println(find("s*llh","somethingandallhemonhowareyou"));
		System.out.println(find("s*z","somethingandallhemonhowareyou"));
		System.out.println(find("*how","somethingandallhemonhowareyou"));
		System.out.println(find("meth*how","somethingandallhemonhowareyou"));
		System.out.println(find("meth*i","somethingandallhemonhowareyou"));
		System.out.println(find("*","somethingandallhemonhowareyou"));
		System.out.println(find("??","somethingandallhemonhowareyou"));
	}
	 
	
}
