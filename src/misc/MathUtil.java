package misc;

import java.util.List;

public class MathUtil {
	
	   
	   /**
	    * Returns a^b, as the standard mathematical exponentiation function
	    */
	   
	   public static double pow(double a, int b) {

		    double output = 1d;
		    
		    if(b == 0)
		        return output;
		    else
		    {
		        double term  = a;
		        if (b <0 )
		            term = (1/a); 
		              
		         int newB = Math.abs(b); 
		
		          for(int i =0; i < newB; i++)
		          {
		              output = output * term;
		          } 
		  
		    }   
		    
		    return output;
		        
		 }
	   
	   public static double powWow(double a, int b){
		   
		   double output = 1d;
		   
		   if(b== 0)
		   {
			   return output;
		   }
		   else if(b == 1)
			   return a;
		   else if(b <0)
		   {
			   return(1d/powWow(a,(-1)*b ));
		   }
		   else{
			   
			   if(b%2 == 0){
				   double root = powWow(a,b/2);
				   return root * root;
			   }
			   else
			   {
				   double root = powWow(a,b/2);
				   return root * root * a;
			   }
			   
		   }
	   }
	   
	   
	   public static void main(String[] args){
		   
		   System.out.println("Start");
		   
		   System.out.println(pow(2,9));
		   System.out.println(powWow(2,9));
		   
		   
		   System.out.println(pow(2,-3));
		   System.out.println(powWow(2,-3));
		   
		   System.out.println(pow(9,3));
		   System.out.println(powWow(9,3));
		   //--------------
		   System.out.println("Fib Start");
		   System.out.println(fib(4));
		   System.out.println(fibIterative(4));
		   
		   System.out.println(fib(13));
		   System.out.println(fibIterative(13));
		   System.out.println(fib(14));
		   System.out.println(fibIterative(14));
		   
		   
		   
	   }
	   
	   public static int fib(int n){
		   if(n <1)
		   {
			   System.out.println("enter a value greater than 0");
			   return -1;

		   }

		   if(n==1)
		       return 0;
		   else if(n==2)
		       return 1;
		   else return (fib(n-1)+fib(n-2));
		   
	   }
	   
	   public static int fibIterative(int n){
		   if(n <1)
		   {
			   System.out.print("Please enter a value greater than 0");
			   return 0;
		   }

		   if(n==1)
		       return 0;
		   else if(n==2)
		       return 1;
		    
		   int prev = 1; 
		   int prevprev = 0;  
		       
		   int sum = 0;
		       
		   for(int i =3; i <= n ;i++)
		   {    
		       sum = prev + prevprev;
		       prevprev = prev;
		      prev = sum;
		   }   
	   return sum;
		   
	   }
	   
	   public static List<Integer> findAll6DigitSquares(){
		   return null;
	   }
	   
	   public static List<Integer> findAll6DigitNumSquareOfSumOf3digitHalves(){
		    return null;
	   }
	   
	   public static boolean isSquareOfSumOf3digitHalves(int n){
		   return false;
	   }

}
