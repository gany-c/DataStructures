package string;

public class PatternSearcher {
	
	public static boolean find(String pattern, String input,int patIndex,int inpIndex)
	{
		if(pattern.charAt(patIndex)=='?')
		{	
			
			return matchSingleChar(pattern,input,patIndex,inpIndex);
					
		}
		else if(pattern.charAt(patIndex)=='*')
		{
			if(patIndex==pattern.length()-1)
				return true;				
			else
			{
				
				if(inpIndex<input.length()-1)
				{
					boolean found = false;
					
					for(int i= inpIndex;i<input.length();i++)
						if(find(pattern,input,patIndex,inpIndex))
							found = true;
					
					return found;
				}
				else if(allStars(pattern,patIndex+1))
						return true;
				else			
						return false;			
			}		
		}
		else if(pattern.charAt(patIndex)!=input.charAt(inpIndex))
		{
			return false;
		}
		else
		{
			return matchSingleChar(pattern,input,patIndex,inpIndex);		
		}
		
	
	}
	


	private static boolean matchSingleChar(String pattern, String input,
			int patIndex, int inpIndex) 
	{

		
		if(patIndex==pattern.length()-1)
			return true;			
		else
		{
			if(inpIndex<input.length()-1)
			{
				return find(pattern,input,patIndex,inpIndex);
			}
			else if(allStars(pattern,patIndex+1))
					return true;
			else
					return false;		
		}	
		
		
	}



	private static boolean allStars(String pattern, int startPoint) {
		
		for(int i= startPoint;i<pattern.length();i++)
			if(pattern.charAt(i)!='*')
				return false;
		return true;
	}
	 
	
}
