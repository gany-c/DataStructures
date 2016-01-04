package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


class AnagramComparator implements Comparator<String>{
	
	private int getSortVal(String s1){

        char[] c1 = s1.toCharArray();        
        Arrays.sort(c1);
		
        int sum = 0;
        int pos = 1;
        
        for(Character c:c1){
        	
        	sum = sum + c.charValue() * pos;
        	pos = pos * 41;
        }
        
        return sum;
	}



	@Override
	public int compare(String s1, String s2) {
		

        if(getSortVal(s1) == getSortVal(s2))        
        	return 0;
        else if (getSortVal(s1) > getSortVal(s2)) 
        	return -1;
        else
        	return 1;
	}
	
}

public class WordUtils {
	
	/**
	 * PROBLEM: - FIND THE COMPOUND WORDS
	 * i.e. given a set of words - find words that contain other words in the list
	 * BETTER APPROACH - 
	 * 1. if input is null or less than 2 return null
	 * 2. Descending Sort the words by length - Use the Compator (not comparable interface)
	 * Collections.sort(input,new MyComparator());
	 * 3. Create an empty HashSet of words.
	 * 4. Create 2 nested loops
	 * In each inner loop check if the starting word holds any of the subsequent words using indexOf
	 * If yes, add to the hashset
	 * 4.1 move the outer loop.
	 * 
	 * 
	 * @param inputWords
	 * @return
	 * @throws RuntimeException
	 */
	public static List<String> findCompound(String[] inputWords) throws RuntimeException
	{
		//if the input list is null return null
		if(inputWords==null||inputWords.length==0)
			return null;
		
		// create an empty list of string 
		List<String> output = new ArrayList<String>();
		
		//create and 
		HashMap<String,Integer> countMap = new HashMap<String,Integer>();
		
		
		for(int curPos=0;curPos<inputWords.length;curPos++)
		{
			String curWord = (String)inputWords[curPos];			
			
			for(int i=0;i<inputWords.length;i++)
			{
				String compareWord = (String)inputWords[i];
				if(compareWord==null||i==curPos)
					continue;
				
				if(compareWord.indexOf(curWord)>-1)
				{
					Integer count = (Integer)countMap.get(compareWord);
					
					if(count==null)
						countMap.put(compareWord,new Integer(1));
					else
						countMap.put(compareWord,new Integer(count.intValue()+1));					
					
				}
			}		
			
		}
		
		Set<String> keySet = countMap.keySet();
		Iterator<String> it = keySet.iterator();
		
		while(it.hasNext())
		{
			String key = (String)it.next();
			Integer value = (Integer)countMap.get(key);
			
			if(value!=null&&value.intValue()>1)
				output.add(key);
		}
		
		return output;
	}
	
	/*
	 * 1. If either string is null return false
	 * 2. if their lengths don't match return false
	 * 
	 * 3. convert both strings to character arrays.
	 * 4. sort both arrays
	 * 5. convert them back to strrings.
	 * 6. Check if they are eaual.
	 */
	public static boolean isAnagram(String s1, String s2){

        // Early termination check, if strings are of unequal lengths,
        // then they cannot be anagrams
        if ( s1.length() != s2.length() ) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String sc1 = new String(c1);
        String sc2 = new String(c2);
        return sc1.equals(sc2);
	}
	
	public static List<String> anagramSort(List<String> input)
	{
		 Collections.sort(input,new AnagramComparator());
		 return input;
	}
	
	public static void main(String[] args)
	{
		//findCompound(null);
		System.out.println(isAnagram("dog","god"));
		System.out.println(isAnagram("smile","miles"));
		System.out.println(isAnagram("reverse","reserve"));
		System.out.println(isAnagram("what","when"));
		
		System.out.println("--------------");
		
		List<String> input = new ArrayList<String>();
		input.add("dog");
		input.add("smile");
		input.add("reverse");
		input.add("what");
		
		input.add("god");
		input.add("miles");
		input.add("reserve");
		input.add("when");	
		
		List<String> output = anagramSort(input);
		
		for(String term:output)
		{
			System.out.print(term+", ");
			
		}
		System.out.println();
	}

}
