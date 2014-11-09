package string;

import java.util.Stack;



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

public static void main(String[] args){
	
	String sentence = "The quick brown fox jumped over the lazy dog";
	System.out.println(reverseWords(sentence));
	
	System.out.println(reverseWords("Defibrilator"));
	
	System.out.println(reverseWords("Pounce Menacing"));
	
	System.out.println(reverseWords("Long          Pause"));
	
}

}