package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author gchidam
 * 
 * PROBLEM: Given a Set of strings as a dictionary and an input String, check if the sentence is composed of words in the string.
 *
 * 1. if the sentence is null or empty or if the dictionary is null return false
 * 2. start from the first character in the input, and keep building larger substrings from the start
 * 2.1. if the dictionary doesn't contain the substring, continue i.e. build a larget prefix
 * 2.2. if there is a match with a dictionary word, 
 * 2.2.1. if you have reached the end of the input, return true
 * 2.2.2. Otherwise make a recursive for the rest of the string and the dictionary.
 */
public class SentenceUtil {
	
	public boolean isValidSentence(String sentence, Set<String> dictionary){
		
		//if the sentence is null or empty or if the dictionary is null return false
		if(sentence == null || sentence.trim().isEmpty() || dictionary==null)
			return false;
		else
		{
			//start from the first character in the input
			// and keep building larger substrings from the start
			for(int i =1;i <=sentence.length();i++)
			{
				/**
				 * substring works such that
				 * 
				 * beginIndex = first char in substring
				 * endIndex = first char not in substring i.e. end +1
				 */
				String prefix  = sentence.substring(0, i);
				
				
				// if the dictionary doesn't contain the substring, continue
				if(!dictionary.contains(prefix))
					continue;
				else
				{
					//else, if you've reached the end of input return true
					if(i == sentence.length())
						return true;
					//else, make a recursive call from the next point to the rest of input
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
