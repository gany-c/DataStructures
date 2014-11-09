package string;

public class StringReverse{

public static String reverse(String input)
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
 
  StringBuilder out = new StringBuilder();
  
  for(int i=0;i<holder.length;i++)
  {
     out = out.append(holder[i]);
    //reccomended string buffer 
   }
  return out.toString();
 }
}

public static void main(String[] args){
	String sentence = "The quick brown fox jumped over the lazy dog";
	System.out.println(reverse(sentence));
	
	System.out.println(reverse("Defibrilator"));
	
	System.out.println(reverse("Pounce Menacing"));
	
	System.out.println(reverse("Long          Pause"));
}


}
