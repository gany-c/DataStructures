package string;

import java.util.HashSet;
import java.util.Set;

public class SentenceUtil {
	
	public boolean isValidSentence(String sentence, Set<String> dictionary){
		
		if(sentence == null || sentence.trim().isEmpty() || dictionary==null)
			return false;
		else
		{
			for(int i =1;i <=sentence.length();i++)
			{
				/**
				 * substring works such that
				 * 
				 * beginIndex = first char in substring
				 * endIndex = first char not in substring i.e. end +1
				 */
				String prefix  = sentence.substring(0, i);
				//System.out.println("prefix = "+prefix);
				
				if(!dictionary.contains(prefix))
					continue;
				else
				{
					if(i == sentence.length())
						return true;
					else if(isValidSentence(sentence.substring(i),dictionary))
						return true;
				}
				
			}
		}
		
		
		return false;
		
	}

	public static void main(String[] args) {
		
		SentenceUtil util = new SentenceUtil();
		
		String sentence = "bedbathbeyond";
		
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("bed");
		dictionary.add("bath");
		dictionary.add("beyond");
		
		System.out.println("isValid: "+util.isValidSentence(sentence, dictionary));
		
		dictionary = new HashSet<String>();
		dictionary.add("be");
		dictionary.add("bath");
		dictionary.add("beyond");
		
		System.out.println("isValid: "+util.isValidSentence(sentence, dictionary));
		
		dictionary = new HashSet<String>();
		dictionary.add("be");
		dictionary.add("bath");
		dictionary.add("beyond");
		dictionary.add("d");
		
		System.out.println("isValid: "+util.isValidSentence(sentence, dictionary));		
		
		
		

	}

}
