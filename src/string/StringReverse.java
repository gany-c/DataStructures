package DS.string;

public class StringReverse{

private String reverse(String input)
{
 if(input==null)
	return null;
 else
 {
  char[] holder = new char[input.length()];

  for(int i=0;i<input.length();i++)
  { 
    holder[i] = input.charAt(i);
    
   }

  int start =0;
  int end = input.length()-1;

  while(start<end)
  {
    char temp = holder[start];
    holder[start] = holder[end];
    holder[end] = temp;

    start++;
    end--;
  }
 
  String out = "";
  
  for(int i=0;i<holder.length;i++)
  {
     out = out + holder[i];
    //reccomended string buffer 
   }
  return out;
 }
}


}
