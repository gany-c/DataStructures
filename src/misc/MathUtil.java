package misc;

public class MathUtil {
	
	   
	   /**
	    * Returns a^b, as the standard mathematical exponentiation function
	    */
	   
	   public double pow(double a, int b) {

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

}
