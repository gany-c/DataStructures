package fb;

import java.util.Arrays;


/**
 * this is just a period's data
you have to find out the best days to buy and sell in retrospect, but do it linear time

 * @author Ramanan
 * 
 * one n^2 approach is to compare all differences
 * it can be improved with a recursive approach but that would still be n^2
 *
 */
public class StockUtil {
	
	/**
	 * 
	 * @author gchidam
	 * 
	 * Keep track of 4 states as you traverse the list
	 *
	 */
	private enum State{
		STARTED,MIN_FOUND,MAX_FOUND,CANDIDATE_MIN_FOUND;
	}
	
	/**
	 * 
	 * @author gchidam
	 *
	 * create a tuple class to store the index and price
	 */
	private static class Tuple{
		int price = -1;
		int index = -1;
		@Override
		public String toString() {
			return "Tuple [price=" + price + ", index=" + index + "]";
		}

		
	}
	
	/**
	 *  1. when you start take the first value as the minimum value.
	 *  2. if you are descending a slope that is finding values that are
	 *     lower than the minimum, keep resetting the minimum.
	 *  3. If a value greater than the minimum is found, then mark it as maximum.
	 *  4. For the remainder of the loop if, greater maxima are found, reset the maximum
	 *  5. Only other thing which needs to be marked is a lower minimum being found, 
	 *     5.1. Mark it as candidate minimum
	 *     5.2. Candidate minimum will be reset as a minimum if a maximum with greater difference can be found.
	 *     5.3. Candidate minimum will be reset if lower mimima can be found.
	 * @param prices
	 * @return
	 */
	public Tuple[] findBestDays(int[] prices){
		
		if(prices==null||prices.length<=1)
			return null;
		
		Tuple min = new Tuple(), max = new Tuple(),cand_min = new Tuple();
		State state = State.STARTED;
		
		for(int i =0;i<prices.length;i++)
		{
			if(state == State.STARTED)
			{
				min.price = prices[i];
				min.index = i;
				state = State.MIN_FOUND;
			}
			else if(state == State.MIN_FOUND)
			{
				if(prices[i] < min.price)
				{	
					min.price = prices[i];
					min.index = i;
				}	
				else if(prices[i] > min.price)
				{
					max.price = prices[i];
					max.index =i;
					state = State.MAX_FOUND;
				}
			}
			else if(state == State.MAX_FOUND)
			{
				if(prices[i] > max.price)
				{	
					max.price = prices[i];
					max.index = i;
				}	
				else if(prices[i] < min.price)
				{
					state = State.CANDIDATE_MIN_FOUND;
					cand_min.price = prices[i];	
					cand_min.index = i;
				}
			}
			else if(state == State.CANDIDATE_MIN_FOUND)
			{
				if(prices[i] < cand_min.price)
				{	
					cand_min.price = prices[i];
					cand_min.index = i;
				}	
				else if(prices[i] > cand_min.price)
				{
					if((prices[i] - cand_min.price) >(max.price -min.price))
					{
						min = cand_min;
						max.price = prices[i];
						max.index = i;
						cand_min = new Tuple();
						state = State.MAX_FOUND;
					}
				}
			}
			
		}
		
		
		if(state == State.CANDIDATE_MIN_FOUND ||state == State.MAX_FOUND)
		{
			Tuple[] output = new Tuple[2];
			output[0] = min;
			output[1] = max;
			return output;
		}
		else		
			return null;
	}

	public static void main(String[] args) {
		
		StockUtil su = new StockUtil();
		
		Tuple[] output = su.findBestDays(new int[]{7,253,89,135,90,153,34});
		
		System.out.println(Arrays.toString(output));
		
		output = su.findBestDays(new int[]{79,25,89,135,90,153,34});
		
		System.out.println(Arrays.toString(output));
		
		output = su.findBestDays(new int[]{1,0});
		
		System.out.println(Arrays.toString(output));	
		
		output = su.findBestDays(new int[]{1,0,9});
		
		System.out.println(Arrays.toString(output));	
		
		output = su.findBestDays(new int[]{1,10,9,0,5,11});
		
		System.out.println(Arrays.toString(output));	
		
		output = su.findBestDays(new int[]{2,10,9,1,0,5,11});
		
		System.out.println(Arrays.toString(output));		

	}

}
