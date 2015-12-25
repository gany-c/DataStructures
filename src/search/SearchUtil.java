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
	 * 
	 * SOLUTION:-
	 * 1. Have a non recursive wrapper method which checks for 
	 * 1.a. input being null or empty
	 * 1.b. and falling out of the range i.e. lesser than minimum and larger than maximum
	 * 2. Then initiate the recursive method.
	 * 2.a. mid equals end, only if start and end are the same number.
	 * 2.b. mid can equal start both if start and end have merged and start is one lesser than end.
	 */

	char findInsPoint(String sortedString, char x) throws Exception
	{
	
	    if(sortedString == null )
	    	throw new Exception("invalid sorted string parameter");
	     
	     String input = sortedString.trim();
	     
	     if(input.isEmpty())
	    	 throw new Exception("invalid sorted string parameter");
	     else if((input.length()==1)||(input.charAt(0) > x)||(input.charAt(input.length() -1) <= x))
	    	 return input.charAt(0);
	     else{	    	 
		     int index = getIndex(input,x,0,input.length() -1);
		     return input.charAt(index);   	    	 
	     }
	     
       
	            
	}


	private int getIndex(String input, char x, int start, int end){

	    
	    int mid = (start + end)/2;
	    
	    if(input.charAt(mid)<=x){
	        
	    	if (input.charAt(mid+1) > x)
	            return mid +1;
	        else{
	            return getIndex(input, x, mid +1,  end);        
	        }
	                    
	    } else { 
	    
	    	if ( input.charAt(mid -1) <= x)
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
			System.out.println(input +","+'z'+ " = "+ output);
			
			output = util.findInsPoint(input, 'i');
			System.out.println(input +","+'i'+ " = "+ output);
			
			output = util.findInsPoint(input, 'k');
			System.out.println(input +","+'k'+ " = "+ output);
			
			output = util.findInsPoint(input, 'a');
			System.out.println(input +","+'a'+ " = "+ output);
			
			output = util.findInsPoint(input, 'c');
			System.out.println(input +","+'c'+ " = "+ output);
			
			output = util.findInsPoint(input, 'v');
			System.out.println(input +","+'v'+ " = "+ output);
			
			output = util.findInsPoint(input, 'h');
			System.out.println(input +","+'h'+ " = "+ output);
			
			output = util.findInsPoint(input, 'm');
			System.out.println(input +","+'m'+ " = "+ output);
			
			System.out.println("-----------");
			
			String input2 = "cv";
			
			output = util.findInsPoint(input2, 'k');
			System.out.println(input2 +","+'k'+ " = "+ output);
			
			output = util.findInsPoint(input2, 'a');
			System.out.println(input2 +","+'a'+ " = "+ output);
			
			output = util.findInsPoint(input2, 'z');
			System.out.println(input2 +","+'z'+ " = "+ output);
			
			output = util.findInsPoint(input2, 'c');
			System.out.println(input2 +","+'c'+ " = "+ output);
			
			output = util.findInsPoint(input2, 'v');
			System.out.println(input2 +","+'v'+ " = "+ output);
			
			System.out.println("-----------");
			
			String input3 = "m";	
			
			output = util.findInsPoint(input3, 'k');
			System.out.println(input3 +","+'k'+ " = "+ output);
	
			output = util.findInsPoint(input3, 'z');
			System.out.println(input3 +","+'z'+ " = "+ output);
			
			output = util.findInsPoint(input3, 'm');
			System.out.println(input3 +","+'m'+ " = "+ output);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
