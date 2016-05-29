package fb;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ParenthesesUtil {
	
	/*
	Welcome to Facebook!

	This is just a simple shared plaintext pad, with no execution capabilities.

	When you know what language you'd like to use for your interview,
	simply choose it from the dropdown in the top bar.

	Enjoy your interview!

	(((( unbalanced -> ""
	(()) balanced (a+(c+d)+e) -> (())
	(())) unbalanced -> (())
	()()) -> ()() or (())

	question: given a sesquence of parentheses, delete as few symbols as possible to make it balanced. Returning one solution is fine

	)()() -> ()()


	1. if you encounter closing brace first, ignore it
	2. if you encounter an opening brace, then you push it into the stack
	3. if you encounter a closing brace, then you can pop, and add both to output.

	----> ))(()) 

	stack - position 2
	stack - position 3
	substring - 3,4 =()
	sub string - 6,6

	()()

	()

	(())))))() -> (())()




	public String balanceParantheses(String input){
	  
	  if(input==null||input.trim().length()==0)
	    return null;
	  
	  String fullOutputString = "";
	  String outString = "";
	  
	  Stack<Integer> openingPositionStack = new Stack<Integer>();
	  
	  for(int i = 0; i < input.length();i++){

	    
	    if(input.charAt(i)=='('){
	      openingPositionStack.push(i);
	      continue;
	    }  
	    
	    if(input.charAt(i)==')')
	    {
	      if(openingPositionStack.isEmpty())
	        continue;
	      
	      int start = openingPositionStack.pop();
	      outString = input.subString(start,i+1); //java subString index end has +1
	      // instead of creating a whole substring I can just update the start and end indexes.
	      
	      if(openingPositionStack.isEmpty()){
	        
	        //create the substring here and add it to my buffer
	        fullOutputString = fullOutputString + outString;
	        outString = "";
	      }
	      
	    }  
	      
	    
	  }
	  
	  return fullOutputString;
	  
	  
	}
	
	GOAL : GIVEN A STRING CONSISTING OF ( AND ) IN ANY ORDER, 
	DELETE AS LITTLE AS POSSIBLE TO CREATE A BALANCED STRING	
	
	YOUR METHOD: don't know if this will work
	-- CREATE ZONES OR STARTING INDEXES OF VALID AREAS 
	-- STORE THESE IN A STACK 
	-- MERGE THE ZONES AS MUCH AS POSSIBLE
	-- Make the new string with valid zones
	
	SHREYANSH'S METHOD: WORKS
	
	-- RECORD THE UNBALANCED PARENTHESES, AND DELETE THEM
	-- WHEN YOU SEE A LEFT PARENTHESES, RECORD IN THE STACK
	-- WHEN YOU SEE A RIGHT PARENTHESES, POP IT FROM THE STACK
	------IF THERE IS NOTHING TO POP, RECORD IT IN ANOTHER STACK
	--- DELETE WHATEVER REMAINS IN THE STACK
		
	*/
	
	public String balanceParentheses(String input){
		
		if(input ==null || input.trim().length() ==0)
			return null;
		
		Stack<Integer> lpStack = new Stack<Integer>();
		Set<Integer> rpSet = new HashSet<Integer>();
		
		identifyUnbalancedPositions(input, lpStack, rpSet);
		String output = removeUnbalancedPositions(input, lpStack, rpSet);
		
		return output;
		
	}
	
	private String removeUnbalancedPositions(String input, Stack<Integer> lpStack, Set<Integer> rpSet) {
		
		while(!lpStack.empty())
			rpSet.add(lpStack.pop());
		
		StringBuilder builder = new StringBuilder();
		
		for(int i =0;i <input.length();i++)
			if(!rpSet.contains(i))
				builder.append(input.charAt(i));
		
		return builder.toString();
	}

	private void identifyUnbalancedPositions(String input, Stack<Integer> lpStack, Set<Integer> rpSet) {
		
		for(int i = 0; i < input.length(); i++){
			
			if(input.charAt(i)=='(')
				lpStack.push(i);
			else if(input.charAt(i)==')')
			{
				if(lpStack.empty())
					rpSet.add(i);
				else
					lpStack.pop();
			}
		}
		
	}

	public static void main(String[] args) {
		
		ParenthesesUtil pUtil = new ParenthesesUtil();
		

		System.out.println("Balanced result = "+pUtil.balanceParentheses("(((("));
		System.out.println("Balanced result = "+pUtil.balanceParentheses("(())"));
		System.out.println("Balanced result = "+pUtil.balanceParentheses("(()))"));
		System.out.println("Balanced result = "+pUtil.balanceParentheses("()())"));
		System.out.println("Balanced result = "+pUtil.balanceParentheses("(())))))()"));
	}

}
