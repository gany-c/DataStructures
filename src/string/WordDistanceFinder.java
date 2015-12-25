package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistanceFinder {
	
	/* This class will be given a list of words (such as might be tokenized
	 * from a paragraph of text), and will provide a method that takes two
	 * words and returns the shortest distance (in words) between those two
	 * words in the provided text.
	 * Example:
	 *   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick","the"));
	 *   assert(finder.distance("fox","the") == 3);
	 *   assert(finder.distance("quick", "fox") == 1);
	 *
	 * "quick" appears twice in the input. There are two possible distance values for "quick" and "fox":
	 *     (3 - 1) = 2 and (4 - 3) = 1.
	 * Since we have to return the shortest distance between the two words we return 1.
	 
	 the - 0
	 quick - 1,4
	 brown -2 
	 fox - 3 */



	    Map<String, List<Integer>> dict = new HashMap<String, List<Integer>>(); 

	    public WordDistanceFinder (List<String> words) {
	        
	        if(words == null || words.size() ==0)
	            return;
	         
	        int count = 0; 
	        for(String word: words){
	        
	         List<Integer> indices = dict.get(word);
	         
	         if(indices == null)
	             indices = new ArrayList<Integer>();
	             
	          indices.add(count++);
	          
	          dict.put(word, indices);      
	        
	        }
	    }
	    public int distance (String wordOne, String wordTwo) {
	        
	        if(wordOne == null || wordTwo == null)
	            return -1;
	        else if (wordOne.equals(wordTwo))
	            return 0;// or return the shortest gap
	        else{
	        
	         List<Integer> indexOne = dict.get(wordOne);
	         List<Integer> indexTwo = dict.get(wordTwo);
	         
	         if(indexOne == null || indexOne.isEmpty()|| indexTwo == null || indexTwo.isEmpty())
	             return -1;
	         else if (indexOne.size() == 1 && indexTwo.size() ==1){
	           return Math.abs(indexOne.get(0) - indexTwo.get(0));       
	         } 
	        else {
	        	
	        	int[] merged = negateAndMerge(indexOne,indexTwo);
	        	
	        	
	        	
	        	return findShortestGap(merged);
	        
	        }
	    }
	
	    }


	private int findShortestGap(int[] merged) {
			
		if(merged == null || merged.length <1)
			return -1;
		
		int minDistance = Integer.MAX_VALUE;
		
		for(int i = 0;i<merged.length-1;i++){
			
			int sum = merged[i] + merged[i+1];
			
			if(sum < merged[i] || sum < merged[i+1])
			{
				int distance = Math.abs(merged[i+1]) - Math.abs(merged[i]);
				
				if(distance < minDistance)
					minDistance = distance;
			}
			
		}
		
		return minDistance;
	}
	
	private int[] negateAndMerge(List<Integer> indexOne, List<Integer> indexTwo) {
			
			int[] output = new int[indexOne.size() + indexTwo.size()];
			
			int cOne = 0;
			int cTwo = 0;
			int k = 0;
			
			
			while(cOne < indexOne.size() && cTwo < indexTwo.size()){
				
				if(indexOne.get(cOne) < indexTwo.get(cTwo))
					output[k++] = indexOne.get(cOne++) + 1;
				else
					output[k++] = -1 * (indexTwo.get(cTwo++)+1);
			}
			
			while(cOne < indexOne.size()){				
				output[k++] = indexOne.get(cOne++) + 1; 				
			}
			
			while(cTwo < indexTwo.size()){				
				output[k++] = -1 * (indexTwo.get(cTwo++) + 1); 				
			}
			
			return output;
	}
	
	public static void main(String[] args) {
		

		WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick","the"));
		System.out.println(finder.distance("fox","the"));
		System.out.println(finder.distance("quick", "fox") );
		System.out.println(finder.distance("quick", "fox") );
	}

}
