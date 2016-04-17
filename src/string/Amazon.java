package string;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
- You're given a text file of white space delimited words
- Words may be separated by one or more white spaces
- You're asked to compute the following:

- The total number of words in the file
- The frequency of each word
- The top-K most frequently occurring words in the file

- Caveat: You may not use String.split(), Pattern, StringTokenizer, StringBuffer, StringBuilder, etc to split a line of text, i.e., parse the text on your own.

Solution:-

1. Reading from file
--- Can use latest 7 and 8 apis
--- Use try-with-resources
---Can use lambdas for further processing
2. Tokenizing
-- If String builder and buffer are not acceptabl
-- then 2 counters can be used, for the starting and ending of the token
-- You can check if the word is a separator
-- Make sure you handle the end of the line.
3. Word count
--- Simply add it to a map of word to counts
--- return the size of the map
4. Top K
--- At the end, loop through the contents of the map
--- create tuples for each key value and add it to a priority queue
--- If the priority queue exceeds K in size, remove from the front.
--- at the end you'll have the top K items but in reverse order


*/

public class Amazon {
	
	public void printWordFrequencyTopK(String fileName, int k) throws Exception{
		
		if(fileName==null||fileName.trim().isEmpty()||k <=0)
			throw new Exception("Invalid input");
		
		List<String> sentences = getSentences(fileName);
		Map<String,Integer> wordCountMap = new HashMap<>();
		
		
		for(String sentence:sentences){
			
			List<String> words = tokenize(sentence);
			
			for(String word: words){
				
				if(wordCountMap.containsKey(word))
					wordCountMap.put(word, wordCountMap.get(word)+1);
				else
					wordCountMap.put(word, 1);
				
			}
		}
		
		System.out.println("Number of words = "+wordCountMap.size());
		
		printTopK(wordCountMap,k);
	}

	private void printTopK(Map<String, Integer> wordCountMap, int k) {
		
		class Tuple implements Comparable<Tuple>{
			String word;
			int count;

			@Override
			public int compareTo(Tuple o) {
				if(o==null)
					return 1;
				else 
					return (this.count - o.count);
				
			}

			public Tuple(String word, int count) {
				super();
				this.word = word;
				this.count = count;
			}

			@Override
			public String toString() {
				return "Tuple [word=" + word + ", count=" + count + "]";
			}
									
		}
		
		PriorityQueue<Tuple> q  = new PriorityQueue<>();
		
		for(Entry<String, Integer> entry:wordCountMap.entrySet()){
			q.add(new Tuple(entry.getKey(),entry.getValue()));
			
			if(q.size() > k)
				q.poll();
		}
		
		System.out.println("Printing Top K values:");
		while(!q.isEmpty())
			System.out.println(q.poll()+", ");
		
		
	}

	private List<String> tokenize(String input) {
		
		if(input== null || input.trim().length()==0){
			return null;
		}
		
		List<String> output = new ArrayList<String>();
		
		boolean startFound=false;
		int i=0,stringStart =0;
		
		
		while(i<input.length()){
			
			if(input.charAt(i)==' '){
				
				if(!startFound){
					stringStart++;
					i++;
				}
				else{
					output.add(input.substring(stringStart,i).toLowerCase());
					i++;
					stringStart = i;
					startFound = false;
				}
			} else{
				
				if(!startFound){
					startFound = true;
					i++;
				}
				else{
					i++;
				}				
			}		
		}
		
		if(startFound){
			output.add(input.substring(stringStart,i).toLowerCase());
		}
		
		return output;
	}

	private List<String> getSentences(String fileName) throws IOException {

		List<String> output = Files.readAllLines(Paths.get(fileName), Charset.forName("US-ASCII"));
		return output;
		
	}
	
	public static void main(String[] args){
		
		Amazon amazon = new Amazon();
		try {
			amazon.printWordFrequencyTopK("/Users/Ramanan/Documents/workspace-sts-3.3.0.RELEASE/DataStructures/src/string/LoremIpsum.txt", 10);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}

