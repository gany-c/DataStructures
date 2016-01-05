package string;

public class Palindrome {
	

	/**
	 * 1. if the input string is null, then return false
	 * 2. strip the input of all whitespaces
	 * 3. if what remains is of length 0 or 1, return true
	 * 4. set up two counters, one at the starting and one at the ending.
	
	 * 7. while they don't cross paths, compare the characters at the counters and move them in opposite directions
	 * 8. return false if the characters don't match.
	 * @param input
	 * @return
	 */
	public boolean isPalindrome(String input){
		
		//if the input string is null, then return false
		if(input == null )
			return false;
		
		//strip the input of all whitespaces
		input = input.trim();
		
		//if what remains is of length 0 or 1, return true
		if(input.length()==0||input.length()==1)
			return true;
		else
		{
			//set up two counters, one at the starting and one at the ending.
			int i = 0;
			int j = input.length() - 1;
			
			//while they don't cross paths, compare the characters at the counters and move them in opposite directions
			//return false if the characters don't match.
			while(i < j)
			{
				if(input.charAt(i)!=input.charAt(j))
					return false;
				i++;
				j--;
			}
			
			return true;
			
		}
	
		
	}
	
	/**
	 * EASY :)	
	 * http://www.careercup.com/question?id=6287528252407808
	 *
	 *A k-palindrome is a string which transforms into a palindrome on REMOVING at most k characters. 
	 *
	 * 1. if the input string is null or less than 0 return false
	 * 2. if the input length equals 1, return true
	 * 3. if the input length equals two, then return true if characters are equal or if 
	 * 		k is greater than 0, otherwise return false.
	 * 4. Else, Check recursively
	 * 5. Compare the first and last characters, if they are the same make a recursive call
	 *  with k the same and the start and end lopped off
	 * 5.a.  if they are not the same, make 2 recursive calls, each with one end lopped off and k decremented by 1
	 *  return true if either one of them returns true.
	 */		
	public boolean isKPalindrome(String input, int k){
		
		//if the input string is null or less than 0 return false
		if(input == null || k < 0)
			return false;
		//if the input length equals 1, return true
		else if(input.length() == 1)
			return true;
		else if(input.length() ==2)
		{
			//if the input length equals true, then return true if characters are equal or if 
			// k is greater than 0, otherwise return false.
			if(input.charAt(0) == input.charAt(1))
				return true;
			else if(k > 0)
				return true;
			else 
				return false;
		}
		else
		{
			//Check recursively
			//Compare the first and last characters, if they are the same make a recursive call
			// with k the same and the start and end lopped off
			// if they are not the same, make 2 recursive calls, each with one end lopped off and k decremented by 1
			// return true if either one of them returns true.
			if(input.charAt(0)==input.charAt(input.length()-1))
				return isKPalindrome(input.substring(1,input.length()-1),k);
			else
			{
				if(k<=0)
					return false;
				else
					return isKPalindrome(input.substring(0,input.length()-1),k-1) ||
							isKPalindrome(input.substring(1,input.length()),k-1);
			}
		}
		
		
	}

	public static void main(String[] args) {
	
		Palindrome p  = new Palindrome();
		System.out.println(p.isPalindrome("malayalam"));
		System.out.println(p.isPalindrome("tamil"));
		
		System.out.println(p.isPalindrome("able was I ere I saw elba"));
		
		System.out.println("malayalam,0 is K palindrome = "+p.isKPalindrome("malayalam",0));
		System.out.println("malayalam, 1 is K palindrome = "+p.isKPalindrome("malayalam",1));
		System.out.println("valayalam, 1 is K palindrome = "+p.isKPalindrome("valayalam",1));
		System.out.println("valayalam, 2 is K palindrome = "+p.isKPalindrome("valayalam",2));
		System.out.println("emalayalam, 1 is K palindrome = "+p.isKPalindrome("emalayalam",1));
		System.out.println("maeelayalam, 1 is K palindrome = "+p.isKPalindrome("maeelayalam",1));
		System.out.println("maeelayalam, 2 is K palindrome = "+p.isKPalindrome("maeelayalam",2));
		System.out.println("some,3 is K palindrome = "+p.isKPalindrome("some",3));
		System.out.println("some,2 is K palindrome = "+p.isKPalindrome("some",2));
		
	}

}
