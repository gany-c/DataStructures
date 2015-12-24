package search;

public class SearchUtil {
	



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

	char findInsPoint(String sortedString, char x) throws Exception
	{
	
	    if(sortedString == null || sortedString.trim().isEmpty())
	     throw new Exception("invalid sorted string parameter");
	     
	     String input = sortedString.trim();
	     int index = getIndex(input,x,0,input.length() -1);
	     
	     if(index < 0 )
	         return input.charAt(0);
	     else
	         return input.charAt(index);          
	            
	}


	private int getIndex(String input, char x, int start, int end){

	    
	    int mid = (start + end)/2;
	    
	    if(input.charAt(mid)<=x){
	        
	        if(mid == end)
	            return -1;
	        else if (input.charAt(mid+1) > x)
	            return mid +1;
	        else{
	            return getIndex(input, x, mid +1,  end);        
	        }
	                    
	    } else { 
	    
	         if(mid ==start)
	             return 0;
	         else if ( input.charAt(mid -1) <= x)
	             return mid;
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
			
			System.out.println("-----------");
			
			String input2 = "cv";
			
			output = util.findInsPoint(input2, 'k');
			System.out.println(output);
			
			output = util.findInsPoint(input2, 'a');
			System.out.println(output);
			
			output = util.findInsPoint(input2, 'z');
			System.out.println(output);
			
			output = util.findInsPoint(input2, 'c');
			System.out.println(output);
			
			output = util.findInsPoint(input2, 'v');
			System.out.println(output);
			
			System.out.println("-----------");
			
			String input3 = "m";	
			
			output = util.findInsPoint(input3, 'k');
			System.out.println(output);
	
			output = util.findInsPoint(input3, 'z');
			System.out.println(output);
			
			output = util.findInsPoint(input3, 'm');
			System.out.println(output);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
