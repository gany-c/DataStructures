package string;

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
	 fox - 3

	public class WordDistanceFinder {

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
	         
	         if(indexOne == null || indexOne.isEmpty()|| indexTwo == null || indextTwo.isEmpty())
	             return -1;
	         else if (indexOne.size() == 1 && indexTwo.size() ==1){
	           return Math.abs(indexOne.get(0) - indexTwo.get(0));       
	         } 
	         else if ( indexOne.size() == 1 || indexTwo.size() ==1 ){
	         // binary search and return the difference in the index
	        }
	        else {// two lists of sorted numbers - goal is to find the shortes difference between them.
	        
	        // brute force where you compare each number of the list with the other
	        // I'm guessing - mergesort's merge, but retain the list information and get the shortest gap
	        
	        }
	    }
	}



	 */	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
