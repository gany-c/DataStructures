package fb;

import java.util.Arrays;

enum State{
	STARTED,MIN_FOUND,MAX_FOUND,CANDIDATE_MIN_FOUND;
}

public class StockUtil {
	//actually ends up finding the best prices, not best days i.e. not the indexes
	public int[] findBestDays(int[] prices){
		
		if(prices==null||prices.length<=1)
			return null;
		
		int min = -1, max = -1,cand_min=-1;
		State state = State.STARTED;
		
		for(int i =0;i<prices.length;i++)
		{
			if(state == State.STARTED)
			{
				min = prices[i];
				state = State.MIN_FOUND;
			}
			else if(state == State.MIN_FOUND)
			{
				if(prices[i] < min)
					min = prices[i];
				else if(prices[i] > min)
				{
					max = prices[i];
					state = State.MAX_FOUND;
				}
			}
			else if(state == State.MAX_FOUND)
			{
				if(prices[i] > max)
					max = prices[i];
				else if(prices[i] < min)
				{
					state = State.CANDIDATE_MIN_FOUND;
					cand_min = prices[i];				
				}
			}
			else if(state == State.CANDIDATE_MIN_FOUND)
			{
				if(prices[i] < cand_min)
					cand_min = prices[i];
				else if(prices[i] > cand_min)
				{
					if((prices[i] - cand_min) >(max -min))
					{
						min = cand_min;
						max = prices[i];
						cand_min = -1;
						state = State.MAX_FOUND;
					}
				}
			}
			
		}
		
		
		if(state == state.CANDIDATE_MIN_FOUND ||state == state.MAX_FOUND)
		{
			int[] output = new int[2];
			output[0] = min;
			output[1] = max;
			return output;
		}
		else
		
		return null;
	}

	public static void main(String[] args) {
		
		StockUtil su = new StockUtil();
		
		int[] output = su.findBestDays(new int[]{7,253,89,135,90,153,34});
		
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
