package Kahuna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * MISTAKE DONE HERE:- The apostrophe case was not handled e.g. Mom's 
 * 
 * @author gchidam
 * 
 * Write a program that reads a text file and outputs the palindromes that occur in the file as well as the number of occurrences for each palindrome.  
 * The output should be in order of the most frequent palindrome to the least frequent palindrome.  Palindromes that occur the same number of times should be ordered in lexicographic order. 
 *  A palindrome is any word, phrase, number, or other sequence of characters which reads the same backward or forward. 

Examples of palindromes: 121, radar, aa
Note that for the purposes of this assignment there is no difference between uppercase and lowercase, punctuation and special characters should be treated like word separators.
Sample input file:

A cat sat on the mat and did not peep for a single moment.  Mom’s phone rang and I ran to the door but Beeb went the radar at 101 miles an hour. 

Output:

a > 2
101 > 1
beeb > 1
did > 1
i > 1
mom > 1
peep > 1
radar > 1
 *
 */

class PalinHolder implements Comparable<PalinHolder>{
	
	private String word;
	private int count;
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int compareTo(PalinHolder o) {

		if(o == null)
			return 1;
		// this one is greater if o is null
		else if(o.count < this.count)
			return -1;
		//this one is smaller if count is greater (descending)
		else if(o.count > this.count)
			return 1;
		else
			return this.word.compareTo(o.word);
		
	}
	public PalinHolder(String word, int count) throws Exception {
		super();
		if(word == null)
			throw new Exception("word cannot be null");
		this.word = word;
		this.count = count;
	}
	public void printRecord() {
		
		System.out.println(this.word+" > "+this.count);
		
	}

	
	
	
}

public class PalindromeUtil {
	
	private void printPalindromeFrequency(List<String> input) throws Exception{
		
		if(input==null || input.size()==0)
			return;
		
		Map<String,Integer> countMap = new HashMap<String,Integer>();
		
		for(String word:input){
			if(word==null||word.trim().isEmpty())
				continue;
			
			
			
			String trimmed = furtherTrim(word);
			
			
			
			if(new StringBuilder(trimmed).reverse().toString().equalsIgnoreCase(trimmed))
			{
				Integer count = countMap.get(trimmed.toLowerCase());
				if (count == null) 
					countMap.put(trimmed.toLowerCase(),1);
				else 
					countMap.put(trimmed.toLowerCase(), count.intValue()+1);
			}
			
		}
		
		List<PalinHolder> holders = new ArrayList<PalinHolder>();
		
		for(Entry<String, Integer> entry:countMap.entrySet()){
			
			PalinHolder holder = new PalinHolder(entry.getKey(),entry.getValue());
			holders.add(holder);
		}
		
		Collections.sort(holders);
		
		for(PalinHolder holder: holders){
			holder.printRecord();
		}
		
	}
	
	private String furtherTrim(String word) {
		
		if(word == null || word.trim().length()==0) 
			return "";
		else
		{
			String trimmed = word.trim();
			
			if(trimmed.endsWith(".")||trimmed.endsWith(";")||trimmed.endsWith(",")){
				return trimmed.substring(0, trimmed.length()-1);
			}
			else if(trimmed.endsWith("'s")){
				return trimmed.substring(0,trimmed.length()-2);
			}
			else
				return trimmed;
		}
	}

	public static void prepPalindromes(String input){
		String[] inArray = input.split(" ");
		List<String> inList = Arrays.asList(inArray);
		
		PalindromeUtil util = new PalindromeUtil();
		try {
			util.printPalindromeFrequency(inList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			System.out.println("-----------------------------------------");
		}
	}

	public static void main(String[] args) {
		System.out.println("HI");
		String input = "A cat sat on the mat and did not peep for a single moment.  Mom's phone rang and I ran to the door but Beeb went the radar at 101 miles an hour.";
		prepPalindromes(input); 
		input = "Sore was I ere I saw Eros";
		prepPalindromes(input); 
		
		input = "Sore was I ere I saw Eros ahha";
		prepPalindromes(input); 
		
		input = "Sore was I ere I saw Eros ahha zzz zzz zzz";
		prepPalindromes(input); 
		
	}

}
