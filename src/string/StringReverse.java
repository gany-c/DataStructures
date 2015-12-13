package string;

public class StringReverse{

public static String reverse(String input)
{
 if(input==null)
	return null;
 else
 {

 
  StringBuilder out = new StringBuilder();
  
  for(int i=input.length()-1;i>=0;i--)
  {
     out = out.append(input.charAt(i));
    
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
