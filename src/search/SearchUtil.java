package search;

public class SearchUtil {
	
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


	/** 
	 * Return the smallest character that is strictly larger than the search character,
	 * otherwise return the first character in the string.
	 * @param sortedStr : sorted list of letters, sorted in ascending order.
	 * @param c : character for which we are searching.
	 * Given the following inputs we expect the corresponding output:
	 * ['c', 'f', 'j', 'p', 'v'], 'a' => 'c'
	 * ['c', 'f', 'j', 'p', 'v'], 'c' => 'f'
	 * ['c', 'f', 'j', 'p', 'v'], 'k' => 'p'
	 * ['c', 'f', 'j', 'p', 'v'], 'z' => 'c' // The wrap around case
	 * ['c', 'f', 'k'], 'f' => 'k'
	 * ['c', 'f', 'k'], 'c' => 'f'
	 * ['c', 'f', 'k'], 'd' => 'f'
	 * @throws Exception 
	 */
	// Java
	//cfk
	char findInsPoint(String sortedString, char x) throws Exception
	{
	// implementation goes here.
	    if(sortedString == null || sortedString.trim().isEmpty())
	     throw new Exception("invalid sorted string parameter");
	     
	     String input = sortedString.trim();
	     int index = getIndex(input,x,0,input.length() -1);
	     
	     if(index < 0 )
	         return input.charAt(0);
	     else
	         return input.charAt(index);          
	            
	}

	//cfk, d, 0, 2
	private int getIndex(String input, char x, int start, int end){

	    if(start==end){
	        //end, haven't found it, return the first element
	        if(start == input.length() -1)
	            return -1; 
	        else     
	            return start + 1;
	    }
	    
	    int mid = (start + end)/2;// 1
	    
	    if(input.charAt(mid)<=x){// f <= d 
	        
	        if(mid == input.length() -1)
	            return -1;
	        else if (input.charAt(mid+1) > x)
	            return mid +1;
	        else{
	            return getIndex(input, x, mid +1,  end);        
	        }
	                    
	    } else { // gets in here
	    
	         if(mid ==0)
	             return 0;
	         else if ( input.charAt(mid -1) <= x)// c < d 
	             return mid;// return 1
	         else{
	              return getIndex(input, x, start, mid -1);      
	         }   
	    }
	}	
	
	public static void main(String args[]){
		
		SearchUtil util = new SearchUtil();
		
		String input = "cfjpv";
		
		try {
			char output = util.findInsPoint(input, 'z');
			System.out.println(output);
			
			output = util.findInsPoint(input, 'k');
			System.out.println(output);
			
			output = util.findInsPoint(input, 'a');
			System.out.println(output);
			
			output = util.findInsPoint(input, 'c');
			System.out.println(output);
			
			output = util.findInsPoint(input, 'v');
			System.out.println(output);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
