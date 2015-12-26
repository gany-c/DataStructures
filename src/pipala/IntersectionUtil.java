package pipala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given 2 lists of numbers, how will you find the intersection
 */
public class IntersectionUtil {
	
	public List<Integer> commons(List<Integer> one, List<Integer> two){
		
		List<Integer> output = new ArrayList<Integer>();
		
		if(one ==null || two == null || one.size() ==0||two.size() == 0)
			return output;
		
		Set<Integer> commonSet = new HashSet<Integer>();
		
		for(Integer in:one){
			
			commonSet.add(in);
		}
		
		for(Integer in:two){
			
			if(commonSet.contains(in))
				output.add(in);
		}
		
		return output;
	}
	
	public static void main(String[] args){
		
		IntersectionUtil util = new IntersectionUtil();
		
		List<Integer> one = Arrays.asList(3,5,6,7,84534,78,34);
		List<Integer> two = Arrays.asList(475632,5813,657,93,9,7,34);
		
		List<Integer> output = util.commons(one, two);
		
		System.out.println(output);
		
	}

}
