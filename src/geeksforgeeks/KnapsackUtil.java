package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

class Item{
	int value;
	int weight;
	
	@Override
	public String toString() {
		return "Item [value=" + value + ", weight=" + weight + "]";
	}
	
	public Item(int value, int weight){
		
		this.value = value;
		this.weight = weight;
	}
	
	
}

/**
 * PROBLEM CLASS: Dynamic programming or Overlapping sub problems
 * 
 * PRINCIPLE - Each and every item is either there in the final solution or it is not there
 * 
 * Item absent = Solution for remaining items , same threshold
 * Item present = Solution for (remaining items , (threshold - weight of items )) + value of items
 * 
 * Choose the greater of the two.
 * 
 * 1. if the input sack is null or empty or if the permitted weight is less than or equal to 0
 * 1.2. return null;
 * 2. if the sack size is 1, return an empty sack if the item's weight is greater than the threshold
 * 2.2. else return the input.
 * 3. Else
 * 3.1. Remove the first items from the sack
 * 3.2.  if it's weight is greater than the threshold, return what is best for the rest of the sack
 * 3.3. . Invoke the function recursively for
				//1. This threshold and remaining items
				//2. This threshold - weight of item, and remaining items.
 * 3.3.1 Add the value of the item  to the second result. 
 * 4. return the greater of the two
 * 
 * 
 * MISTAKE MADE:
 * 
 * 1. The knapsack function is not idempotent
 * 2. It changes the state of the input array.
 * 3. So, don't call it multiple times expecting the same result, call it and store the results in a temporary array.
 */
public class KnapsackUtil {
	
	public List<Item> getBestValueSack(List<Item> input, int tw){
		
		// if the input sack is null or empty or if the permitted weight is less than or equal to 0
		// return null;
		if(input == null || input.size() == 0 || tw <= 0)
			return null;
		else if (input.size() == 1){
		// if the sack size is 1, return an empty sack if the item's weight is greater than the threshold
		// else return the input.	

				if(input.get(0).weight > tw)
					return new ArrayList<Item>();
				else
					return input;
			
		}
		else{
			// Remove the first item from the sack
			Item i = input.remove(0);
			
			//if it's weight is greater than the threshold, 
			//return what is best for the rest of the sack
			if(i.weight > tw)
				return getBestValueSack(input,tw);
			else{
				
				//Else, you create 2 empty lists, and add the remaining items there
				List<Item> param1 = new ArrayList<Item>();
				param1.addAll(input);
				
				List<Item> param2 = new ArrayList<Item>();
				param2.addAll(input);
				
				//Invoke the function recursively for
				//1. This threshold and remaining items
				//2. This threshold - weight of item, and remaining items.
				List<Item> out1 = getBestValueSack(param1,tw);
				List<Item> out2 = getBestValueSack(param2,tw -i.weight);
				
				//Check if value of 1 is greater than
				// value of 2 + item's value
				// if yes, return 1 i.e. the remaining items
				// else retun 2 + this item
				
				if(valueOf(out1) > i.value + valueOf(out2))
					return out1;
				else{
					
					out2.add(i);
					return out2;
				}
					
			}
		}
		
	}

	private int valueOf(List<Item> sack) {
		int sum  = 0;
		
		for(Item i : sack)
			sum = sum + i.value;
		
		return sum;
	}

	public static void main(String[] args) {


		KnapsackUtil util = new KnapsackUtil();
		List<Item> input = new ArrayList<Item>();
		
		input.add(new Item(2,3));
		input.add(new Item(2,3));
		input.add(new Item(5,2));

		
		List<Item> output = util.getBestValueSack(input, 7);
		
		System.out.println(output);
		System.out.println("--------------------------------");
		
		input = new ArrayList<Item>();
		input.add(new Item(60,10));
		input.add(new Item(100,20));
		input.add(new Item(120,30));
		
		 output = util.getBestValueSack(input, 7);
		 System.out.println(output);
		 System.out.println("--------------------------------");
		 
		input = new ArrayList<Item>();
		input.add(new Item(60,10));
		input.add(new Item(100,20));
		input.add(new Item(120,30));
		
		 output = util.getBestValueSack(input, 50);
		 System.out.println(output);
		 System.out.println("--------------------------------");
	}
	
	

}
