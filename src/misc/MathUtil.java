package misc;

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
		   
	   }

}
