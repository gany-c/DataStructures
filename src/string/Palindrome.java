package string;

public class Palindrome {
	
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

	public static void main(String[] args) {
	
		Palindrome p  = new Palindrome();
		System.out.println(p.isPalindrome("malayalam"));
		System.out.println(p.isPalindrome("tamil"));
		
		System.out.println(p.isPalindrome("able was I ere I saw elba"));
		
	}

}
