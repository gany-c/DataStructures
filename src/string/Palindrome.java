package string;

public class Palindrome {
	
	/**
	 * http://www.careercup.com/question?id=6287528252407808
	 *
	 *A k-palindrome is a string which transforms into a palindrome on removing at most k characters. 
	 */
	
	public boolean isPalindrome(String input){
		
		
		if(input == null )
			return false;
		
		input = input.trim();
		
		if(input.length()==0||input.length()==1)
			return true;
		else
		{
			int i = 0;
			int j = input.length() - 1;
			
			
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
	
	
	public boolean isKPalindrome(String input, int k){
		
		if(input == null || k < 0)
			return false;
		else if(input.length() == 1)
			return true;
		else if(input.length() ==2)
		{
			if(input.charAt(0) == input.charAt(1))
				return true;
			else if(k > 0)
				return true;
			else 
				return false;
		}
		else
		{
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
		
		System.out.println("is K palindrome = "+p.isKPalindrome("malayalam",0));
		System.out.println("is K palindrome = "+p.isKPalindrome("malayalam",1));
		System.out.println("is K palindrome = "+p.isKPalindrome("valayalam",1));
		System.out.println("is K palindrome = "+p.isKPalindrome("valayalam",2));
		System.out.println("is K palindrome = "+p.isKPalindrome("emalayalam",1));
		System.out.println("is K palindrome = "+p.isKPalindrome("maeelayalam",1));
		System.out.println("is K palindrome = "+p.isKPalindrome("maeelayalam",2));
		System.out.println("is K palindrome = "+p.isKPalindrome("some",3));
		System.out.println("is K palindrome = "+p.isKPalindrome("some",2));
		
	}

}
