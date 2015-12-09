package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathUtil {
	
	   

/**
 * 1. initialize output to 1
 * 2. if the power param is 0, return 1.
 * 3. initialize term variable to be base
 * 4. if power lesser than 0, set the term to be its own reciprocal
 * 5. get absolute value of the power
 * 6. in a loop from 1 to power variable multiple the output by the base.
 * 7. return output.	 
 *   
 * @param a
 * @param b
 * @return
 */
	   public static double pow(double a, int b) {
		    //initialize output to 1
		    double output = 1d;
		    
		    //if the power param is 0, return 1.
		    if(b == 0)
		        return output;
		    else
		    {
		    	//initialize term to be base
		        double term  = a;
		        
		        //if power lesser than 0, set the term to be its own reciprocal
		        if (b <0 )
		            term = (1/a); 
		          
		        // get the absolute value of the power
		         int newB = Math.abs(b); 
		
		         //for i ranging from 1 to absolute value, multiply output by term.
		          for(int i =0; i < newB; i++)
		          {
		              output = output * term;
		          } 
		  
		    }   
		    
		    
		    //return output.
		    return output;
		        
		 }
	   
	   /**
	    * 1. initialize output to be 1
	    * 2. if b equals 0, return 1 itself as output
	    * 3. if b equals 1, return the base
	    * 4. if b is less that 0 return the reciprocal of the result of a recursive call with the same base and a negative inversion of the power :)
	    * 5. if the power is even, make a recursive call with power by 2 and return the square of the result.
	    * 6. else do the same with the base multiplying the square.
	    * @param a
	    * @param b
	    * @return
	    */
	   public static double powWow(double a, int b){
		   
		   //initialize output to be 1
		   double output = 1d;
		   
		   if(b== 0)
		   {
			   //if b equals 0, return 1 itself as output
			   return output;
		   }
		   //if b equals 1, return the base
		   else if(b == 1)
			   return a;
		   else if(b <0)
		   {
			   //if b is less that 0 return the reciprocal of the result of a recursive call with the same base and a negative inversion of the power :)
			   return(1d/powWow(a,(-1)*b ));
		   }
		   else{
			   
			   //if the power is even, make a recursive call with power by 2 and return the square of the result.
			   if(b%2 == 0){
				   double root = powWow(a,b/2);
				   return root * root;
			   }
			   else
			   {
				   //else do the same with the base multiplying the square.
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
		   
		   //------------
		   
		   List<Integer> strangeSq = findAll6DigitNumSquareOfSumOf3digitHalves();
		   System.out.println("Comedy Squares are:-");
		   for(Integer sq:strangeSq)
		   {
			   System.out.print(sq+", ");
			   System.out.println();
		   }
		   
	   }
	   
	   
	   // Create a Map for memoization, it need not be refreshed because fibonacci numbers are constants.
	   private static Map<Integer,Integer> fibMap = new HashMap<Integer,Integer>();
	   
	   /**
	    * 1. Create a Map for memoization, it need not be refreshed because fibonacci numbers are constants.
	    * 2. if n is less than 1, return -1
	    * 3. if n equals 1 return 0, if n equals 1
	    * 4. Otherwise, check if the previous 2 fibonacci numbers are available in the map, use them if available otherwise make recursive calls
	    * 5. sum the 2 previous  numbers, add them and add to the map, and return as output.
	    * @param n
	    * @return
	    */
	   
	   public static int fib(int n){
		   
		   // if n is less than 1, return -1
		   if(n <1)
		   {
			   System.out.println("enter a value greater than 0");
			   return -1;

		   }

		   // if n equals 1 return 0, if n equals 1
		   if(n==1)
		       return 0;
		   else if(n==2)
		       return 1;
		   else {
			   
			   //Otherwise, check if the previous 2 fibonacci numbers are available in the map
			   // use them if available otherwise make recursive calls
			   Integer prev = fibMap.get(n-1);
			   if(prev == null)
				   prev = fib(n-1);
			 
			   Integer prevPrev = fibMap.get(n-2);
			   if(prevPrev == null)
				   prevPrev = fib(n-2);
			   
			   //sum the 2 previous  numbers
			   //add them and add to the map, and return as output.
			   int out = prev + prevPrev;
			   fibMap.put(n, out);	 
			   
			   return (out);
		   }
		   
	   }
	   
	   /**
	    * Simple for loop, with 2 
	    * @param n
	    * @return
	    */
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
	   

	   
	   /**
	    * FIND ALL 6 DIGIT NUMBERS WHICH ARE SQUARES OF THE SUMS OF THEIR 3 DIGIT HALVES
	    * 
	    * Naive approach: call isSquareOfSumOf3digitHalves for all numbers between 100,000
	    * and 1,000,000.
	    * 
	    * Another naive approach would be taking all possible 3 digit pairs - computing their
	    * sums and then their squares. This would again involve 2 nested loops -900 * 1000 times.
	    * 
	    * Better approach: All the sums have to boil down to 100 - 999, if their squares have to
	    * be 6 digit numbers.
	    * 
	    * Check isSquareOfSumOf3digitHalves only on their squares. i.e. on 100 to 999
	    * 
	    * Note: all 3 digit numbers can be candidate sums of the 6 digit pairs. Because the second pair can be 
	    * set to 000. e.g. 123,000 - 100,000 - 999,000
	    * 
	    */
	   public static List<Integer> findAll6DigitNumSquareOfSumOf3digitHalves(){
		   
		   //find all the 6 digit numbers which are squares
		    List<Integer> allSq = findAll6DigitSquares();
		    
		    List<Integer> output = new ArrayList<Integer>();
		    
		    //check if they follow the property 
		    for(Integer sq: allSq)
		    	if(isSquareOfSumOf3digitHalves(sq))
		    		output.add(sq);
		    
		    return output;
	   }
	   
	   private static boolean isSquareOfSumOf3digitHalves(int n){
		   
		   //if the number is not 6 digit, return false
		   if(n < 100000 || n >999999)
		  	   return false;
		   else			   
		   {
			  //divide by 1000 and take modulo 1000 to get the 2 terms
			   //add the them ad squater them
			  int term =  n/1000 + n%1000;
			  return n==term*term;
		   }
			  
	   }
	   
	   private static List<Integer> findAll6DigitSquares(){
		   List<Integer> output = new ArrayList<Integer>();
		   
		   for(int i=100; i<1000;i++)
			   output.add(i*i);
		   
		   return output;
	   }

}
