package misc;
import java.util.Set;
import java.util.HashSet;

/*

1. First approach: Start from 0 and keep checking if the number is there.

2. second approach: Sort the list and find the first break in it - i.e. two numbers that are not successors.

3. 3rd approach: create another array of size equal to the max number in the input array. Store each number in an index point of its value and scan for the nulls.

- Interviewer's insight: smallest absent number cannot be greater than the list size - this is because you can only fit (0 to list-size minus 1) smaller numbers in it

4. repeat 3 but ignore all numbers with value greater than list size.

5. init value as -1, find the smallest number in the list and see if it is just greater that init value by 1,
if not return (init +1) else recursively call for list and second minimum. - But this is same as 2.

6. Repeat 4, but in the same array. If the copying point holds another number smaller than k, then copy recursively.

*/

public class SmallestAbsentNumber{

	
	public static int find(int[] input)
	{
		if(input==null|| input.length == 0)
			return 0; 
	
		int smallest = Integer.MAX_VALUE;

		
		Set<Integer> numSet = new HashSet<Integer>();
		
		for(int i: input)
		{
			if(i < smallest)
				smallest = i;

				
			numSet.add(i);	
		}
		
		if(smallest != 1)
			return 1;
		else
		{
			int smallestMissing = Integer.MAX_VALUE;
		
			for(int i: input)
			{
				if(!numSet.contains(i+1))
				{
					if((i+1) < smallestMissing)
						smallestMissing = i +1;
				}
					
			
			}
			
			return smallestMissing;
		}	
		
	
	}


	public static void main(String[] args){
	
		System.out.println("Hi");
		
		System.out.println(find(new int[]{2,7,8,1,200,232,3}));
	}


}