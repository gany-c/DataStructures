package misc;

public class NumberUtil {
	
	/**
	 * Find the square root of a number passed in as a double type, with a second parameter precision.
	 * 
	 * Solution: Do through binary search
	 * 
	 * 1. if the number is less than 0, throw an exception.
	 * 2. if the number is the same as 0 or 1 return the same number.
	 * 3. else begin a typical binary search, set start =0, end = number
	 * 4. do while end -start is greater than precision.
	 * 4.1. get average.
	 * 4.2. calculate the product of the average.
	 * 4.3. if the product equals the number, return the average.
	 * 4.4. if you fall lesser than the number, set start to mid
	 * 4.5. else set end to mid
	 * @param number
	 * @param precision
	 * @return
	 */
	public double sqrt(double number, double precision){
		
		//if the number is less than 0, throw an exception.
		if(number <0)
			throw new IllegalArgumentException("Give a value greater than 0:"+number);
		//if the number is the same as 0 or 1 return the same number.
		if(number==0 ||number ==1)
			return number;
		else if (number >0 && number <1){
			return 1/(sqrt((1/number),precision));
		}
		else
		{
			//else begin a typical binary search
			//set start =0, end = number
			double start =0, mid =0, end = number;
			double midSq =0;
			
			//do while end -start is greater than precision.
			while (end - start> precision)
			{
				// get average.
				mid = (start+end)/2;
				
				//calculate the product of the average.
				midSq = mid * mid;
				
				//if the product equals the number, return the average.
				if(midSq == number)
					return mid;
				//if you fall lesser than the number, set start to mid
				else if(midSq < number)
					start = mid;
				//else set end to mid
				else
					end = mid;
			
			}
			
			return mid;
			
		}
	
		
	}
	
	public static void main(String[] args){
		 
		NumberUtil nu = new NumberUtil();
		double root2 = nu.sqrt(2, 0.00001);
		
		System.out.println("root of 2 = "+root2);
		
		root2 = nu.sqrt(0.25, 0.00001);
			
		System.out.println("root of 0.25 = "+root2);
	}

}
