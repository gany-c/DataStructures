package DS.string;

import DS.base.UtilityStack;

public class WordReverser{

private String removeTrailingSpaces(String input)
{
	if(input!=null)
		return input.trim();
	else
		return null;
}

private String removeStartingSpaces(String input)
{
	if(input==null)
		return null;
	else
	{
		int stringLength = input.length();
		int copyStart = 0;

		

		for(copyStart = 0;copyStart<stringLength;copyStart++)
		{
			if(input.charAt(copyStart)!=' ')
				break;
		}

		String output = "";
		for(int i = copyStart;i<stringLength;i++)
		{		
			output = output + input.charAt(i);
		}

		return output;	
		
	}
}

private UtilityStack getTokens(String input)
{
 if(input == null)
	return null;
 else
 {
   int stringLength = input.length();
   UtilityStack output = new UtilityStack();

   String token = "";
   for(int i =0;i<stringLength;i++)
   {
     if(token.charAt(i)!=' ')
     {
	token = token + ' ';
        
	if(i==stringLength-1)
	{
          output.push(token);
	  break;
        }
      } 
      else
     {
        output.push(token);
	token = "";

     }  
   } 
   return output;
 }
}



private String reverseWords(String input)
{

if(input==null){
	return null;
}

input = removeTrailingSpaces(input);
input = removeStartingSpaces(input);

UtilityStack stack = getTokens(input);
String output = "";

while(true)
{
  String token = (String)stack.pop();
  if(token == null)
  {
	break;
   }
  else
  {
    output = output + token +" ";
    
   }
}

if(output.equals(""))
	return null;
else
	return output.trim();

}
}