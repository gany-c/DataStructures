package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 1. split the words into tokens
 * 2. put the tokens into a stack
 * 3. keep popping the stack and merging the tokens
 * 
 * 1. How to split into tokens?
 * 1.1. Start with an empty string buffer
 * 1.2. traverse the input string
 * 1.3. if you encounter non blank characters append to the buffer.
 * 1.4. else convert the buffer to string and add it to list of tokens
 * 1.4. reinitialize the buffer.
 */

public class WordReverser{

/*
 * writing the tokenizer is the key..
 */
private static Stack<String> getTokens(String input)
{
 if(input == null)
	return null;
 else
 {
   int stringLength = input.length();
   Stack<String> output = new Stack<String>();

   StringBuilder token = new StringBuilder();
   for(int i =0;i<stringLength;i++)
   {
     if(input.charAt(i)!=' ')
     {
      
    	token = token.append(input.charAt(i));
		if(i>=stringLength-1)
		{
		  if(!token.toString().isEmpty())	
			  output.push(token.toString());
          break;
        }
      } 
      else
      {
        output.push(token.toString());
        token = new StringBuilder();

     }  
   } 
   return output;
 }
}

private static List<String> tokenize(String input){
	
	if(input== null || input.trim().length()==0){
		return null;
	}
	
	List<String> output = new ArrayList<String>();
	
	boolean startFound=false;
	int i=0,stringStart =0;
	
	
	while(i<input.length()){
		
		if(input.charAt(i)==' '){
			
			if(!startFound){
				stringStart++;
				i++;
			}
			else{
				output.add(input.substring(stringStart,i));
				i++;
				stringStart = i;
				startFound = false;
			}
		} else{
			
			if(!startFound){
				startFound = true;
				i++;
			}
			else{
				i++;
			}				
		}		
	}
	
	if(startFound){
		output.add(input.substring(stringStart,i));
	}
	
	return output;
}



public static String reverseWords(String input)
{

	if(input==null)
	{
		return null;
	}
	
	input = input.trim();
	
	Stack<String> stack = getTokens(input);
	StringBuilder output = new StringBuilder();
	
	while(!stack.isEmpty())
	{
	  String token = (String)stack.pop();

	    output = output.append(token +" ");
	    

	}
	
	if(output.length() ==0)
		return null;
	else
		return output.toString();

}

private static void testTokenize(){
	String sentence = "The quick brown fox jumped over the lazy dog";
	System.out.println(tokenize(sentence));
	
	System.out.println(tokenize("Defibrilator"));
	
	System.out.println(tokenize("Pounce Menacing"));
	
	System.out.println(tokenize("Long          Pause"));
	
	System.out.println(tokenize(null));
	
	System.out.println(tokenize("       Long     Pause       "));
	
	System.out.println(tokenize(""));
	
	System.out.println(tokenize("a bc"));
}

private static void testReverseWords(){
	
	String sentence = "The quick brown fox jumped over the lazy dog";
	System.out.println(reverseWords(sentence));
	
	System.out.println(reverseWords("Defibrilator"));
	
	System.out.println(reverseWords("Pounce Menacing"));
	
	System.out.println(reverseWords("Long          Pause"));
	

}

public static void main(String[] args){
	
//testReverseWords();

testTokenize();
	
}

}