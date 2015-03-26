package string;

import java.util.HashSet;
import java.util.Set;

public class StringUtil {
	
	public int indexOf(String main, String sub){
		
		if(main == null || sub ==null)
			return -1;

		else if(main.length() < sub.length())
			return -1;
		
		
		for(int i =0;i<=main.length()-sub.length();i++)
		{
			if(startsWith(main,sub,i))
				return i;
		}
		
		return -1;
		
	}

	private boolean startsWith(String main, String sub, int i) {
		
		if(main == null || sub ==null||i<0)		
			return false;
		else
		{
			for(int j=0;j<sub.length();j++){
				if(sub.charAt(j)!=main.charAt(j+i))
					return false;
			}
			
			return true;
		}
	}
	
	private Set<String> findAllPerm(String input){
		
		if(input==null||input.trim().isEmpty())
			return null;
		
		Set<String> output = new HashSet<String>();
		
		if(input.length() == 1)
		{
			output.add(input);
			return output;
		}
		else
		{
			for(int i =0;i<input.length();i++)
			{
				char c = input.charAt(i);
				
				String sub = null;
				
				if(i ==0)
				{
					sub = input.substring(1);
				}
				else if(i == input.length()-1)
				{
					sub = input.substring(0,input.length()-1);
				}
				else
				{
					sub = input.substring(0,i) + input.substring(i+1,input.length());
				}
				
				Set<String> subSet = findAllPerm(sub);
				
				for(String subOut:subSet)
				{
					output.add(""+c+subOut);
				}
				
				
			}
			
			return output;
		}
		
		
	}
	
	public static void main(String[] args){
		
		StringUtil util = new StringUtil();
		
/*		System.out.println(util.indexOf("Vatapi Ganapathy","Gana"));
		System.out.println(util.indexOf("Vatapi Ganapathy","Vatapi"));
		System.out.println(util.indexOf("Vatapi Ganapathy","arch"));*/
		
		Set<String> output = util.findAllPerm("a");
		
		for(String perm:output){
			System.out.println(perm);
		}
		
		System.out.println("--------------------------");
		
		output = util.findAllPerm("ab");
		
		for(String perm:output){
			System.out.println(perm);
		}
		
		System.out.println("--------------------------");
		
		output = util.findAllPerm("aa");
		
		for(String perm:output){
			System.out.println(perm);
		}
		
		System.out.println("--------------------------");
		
		output = util.findAllPerm("abc");
		
		for(String perm:output){
			System.out.println(perm);
		}
		
		System.out.println("--------------------------");
		
		 output = util.findAllPerm("Vatapi");
		
		for(String perm:output){
			System.out.println(perm);
		}
		
	}

}
