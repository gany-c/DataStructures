package misc;

public class NumberUtil {
	
	public double sqrt(double number, double precision){
		
		if(number <0)
			throw new IllegalArgumentException("Give a value greater than 0:"+number);
		
		if(number==0 ||number ==1)
			return number;
		else
		{
			double start =0, mid =0, end = number;
			double midSq =0;
			
			while (end - start> precision)
			{
				mid = (start+end)/2;
				
				midSq = mid * mid;
				
				if(midSq == number)
					return midSq;
				else if(midSq < number)
					start = mid;
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
	}

}
