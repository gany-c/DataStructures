package fb;

import java.util.Arrays;


/**
 * this is just a period's data
you have to find out the best days to buy and sell in retrospect, but do it linear time
 * @author Ramanan
 *
 */
public class StockUtil {
	
	private enum State{
		STARTED,MIN_FOUND,MAX_FOUND,CANDIDATE_MIN_FOUND;
	}
	
	private static class Tuple{
		int price = -1;
		int index = -1;
		@Override
		public String toString() {
			return "Tuple [price=" + price + ", index=" + index + "]";
		}

		
	}
	
	//actually ends up finding the best prices, not best days i.e. not the indexes
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

	}

}
