package goog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**

 * @author Ramanan
 * 
 * Your class should return an iterator that
 * 1. accepts a string as input
 * 2. treat each successive character as an increasing digit (duplicates allowed)
 * 3. return the next number in this number world
 * 
 * e.g. 
 * 
 * process(“bca”)
b
c
a
bb
bc
ba
cb
cc
ca
ab
ac
aa
bbb
…


process(“abc”)
a
b
c
aa
ab
ac
ba
bb
bc
ca
cb
cc
aaa
aab
aac//
…
aaaaaaaa
aaaaaaab//
aaaaaaac
aaaaaaba
aaaaaabb
aaaaaabc
aaaaaaca
aaaaaacb
aaaaaacc
aaaaabaa
..
bbbbbbba
 *
 */
public class PatternCreator {
	
	
	public Iterator<String> process(String input){
		
		if(input == null || input.trim().isEmpty())
			return null;
		
		final char[] rankList = getRanks(input);
		
		
		final int maxVal = input.length() -1;
		final char firstChar = input.charAt(0);
		
		 Iterator<String> output = new Iterator<String>()
		 {
			int[] placeValues = new int[]{0}; 
			char[] state = new char[]{firstChar};

			@Override
			public boolean hasNext() {
				
				return true;
			}

			@Override
			public String next() {
				
				String output = Arrays.toString(state);
				incrementState();
				return output;
			}

			private void incrementState() {
				
				//System.out.println("incrementState state.length -1= "+(state.length-1));
				incrementState(state.length-1);
				
			}

			private void incrementState(int index) {
				
				
				int digitVal = placeValues[index];
				
				if(digitVal < maxVal)
				{
					state[index] = rankList[digitVal +1];	
					placeValues[index] = placeValues[index]+1;
				}
				else if(index >0)
				{
					state[index] = firstChar;	
					placeValues[index] = 0;					
					incrementState(index -1);
					
				}
				else
				{
					int oldLength = state.length;
					state = new char[oldLength+1];
					placeValues = new  int[oldLength+1];
					
					for(int i =0;i<state.length;i++)
					{	
						state[i] = firstChar;	
						placeValues[i] = 0;
					}	
				}
				
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}



		 };
		 
		 return output;
	}



	private char[] getRanks(String input) {

		 char[] output = new char[input.length()];
		
		for(int i =0; i < input.length();i++)
			output[i] = input.charAt(i);
		
		return output;		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PatternCreator pc = new  PatternCreator();
		
		Iterator<String> it = pc.process("abc");
		
		int count =0;
		
		while(count < 50){
			
			String pattern = it.next();
			System.out.println(pattern);
			count++;
		}

	}

}

/*package goog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PatternCreator {
	
	
	public Iterator<String> process(String input){
		
		if(input == null || input.trim().isEmpty())
			return null;
		
		final Map<Integer,Character> rankMap = getRanks(input);
		final Map<Character,Integer> valMap = getValues(input);
		
		final int maxVal = input.length() -1;
		final char firstChar = input.charAt(0);
		
		 Iterator<String> output = new Iterator<String>()
		 {
			 
			 char[] state = new char[]{firstChar};

			@Override
			public boolean hasNext() {
				
				return true;
			}

			@Override
			public String next() {
				
				String output = Arrays.toString(state);
				incrementState();
				return output;
			}

			private void incrementState() {
				
				incrementState(state.length-1);
				
			}

			private void incrementState(int index) {
				
				char digit = state[index];
				int digitVal = valMap.get(digit);
				
				if(digitVal < maxVal)
				{
					state[index] = rankMap.get(digitVal +1);					
				}
				else if(index >0)
				{
					state[index] = firstChar;
					incrementState(index -1);
				}
				else
				{
					int oldLength = state.length;
					state = new char[oldLength+1];
					
					for(int i =0;i<state.length;i++)
						state[i] = firstChar;	
				}
				
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}



		 };
		 
		 return output;
	}

	private Map<Character, Integer> getValues(String input) {
		
		Map<Character, Integer> output = new HashMap<Character,Integer>();
		
		for(int i =0; i < input.length();i++)
			output.put(input.charAt(i), i);
		
		return output;
	}

	private Map<Integer, Character> getRanks(String input) {

		 Map<Integer, Character> output = new HashMap<Integer, Character>();
		
		for(int i =0; i < input.length();i++)
			output.put(i,input.charAt(i));
		
		return output;		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PatternCreator pc = new  PatternCreator();
		
		Iterator<String> it = pc.process("abc");
		
		int count =0;
		
		while(count < 40){
			
			String pattern = it.next();
			System.out.println(pattern);
			count++;
		}

	}

}*/

