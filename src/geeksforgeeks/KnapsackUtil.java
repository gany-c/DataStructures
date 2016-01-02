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

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 */
public class KnapsackUtil {
	
	public List<Item> getBestValueSack(List<Item> input, int tw){
		
		if(input == null || input.size() == 0 || tw <= 0)
			return null;
		else if (input.size() == 1){
			

				if(input.get(0).weight > tw)
					return new ArrayList<Item>();
				else
					return input;
			
		}
		else{
			Item i = input.remove(0);
			
			if(i.weight > tw)
				return getBestValueSack(input,tw);
			else{
				List<Item> param1 = new ArrayList<Item>();
				param1.addAll(input);
				
				List<Item> param2 = new ArrayList<Item>();
				param2.addAll(input);
				
				List<Item> out1 = getBestValueSack(input,tw);
				List<Item> out2 = getBestValueSack(input,tw -i.weight);
				
				
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
		
/*		input.add(new Item(2,3));
		input.add(new Item(2,3));
		input.add(new Item(5,2));

		
		List<Item> output = util.getBestValueSack(input, 7);
		
		System.out.println(output);
		
		input = new ArrayList<Item>();
		input.add(new Item(60,10));
		input.add(new Item(100,20));
		input.add(new Item(120,30));
		
		 output = util.getBestValueSack(input, 7);
		 System.out.println(output);
		 
		input = new ArrayList<Item>();*/
		input.add(new Item(60,10));
		input.add(new Item(100,20));
		input.add(new Item(120,30));
		
		List<Item> output = util.getBestValueSack(input, 50);
		 System.out.println(output);
	}
	
	

}
