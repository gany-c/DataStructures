package salesforce;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/***
 * 
 * @author Ramanan
 * 
 * I think a trie based approach will be better
 * 
 * 1. Construct the trie based on Dictionairy words
 * 1.a. head node and then at each level left for. right for dash.
 * 1.b. when a path arrives to an end, store the word at the node.
 *  
 * While traversing move to each child based on input word. 
 * If you reach a node and run out of symbols
 * if there are any words stored at that node return them
 * 
 * if there is nothing stored, return the nearest stored word.
 * each time you encounter a stored word reset a counter to 0.
 * each time you move to a child without stored word increment it by 1
 * if you have come to an node with end of symbols, you can search the descendants until 
 * your height becomes more than the count.
 * 
 * May be some more cases.
 *
 */

class DictEnt  implements Comparable<DictEnt>{

		private String humanWord;
		private String morseWord;
		private BigInteger wordVal;
		

		
		public String getHumanWord() {
			return humanWord;
		}

		public void setHumanWord(String humanWord) {
			this.humanWord = humanWord;
		}

		public BigInteger getWordVal() {
			return wordVal;
		}

		DictEnt(String input,Map<Character,String> charMap){
			
			if(input==null||input.trim().isEmpty())
				return;
			
			humanWord = input;
			
			if(charMap == null || charMap.isEmpty())
				return;
			
			char[] humArray = input.toCharArray();
			StringBuilder builder = new StringBuilder();
			
			
			for(Character c:humArray){
				String morseAlphabet = charMap.get(c);
				builder.append(morseAlphabet);
			}
			
			morseWord = builder.toString();
			wordVal = new BigInteger(builder.reverse().toString().replaceAll(" ","").replaceAll("\\.", "1").replaceAll("-", "2"));
			
		}

		@Override
		public String toString() {
			return "DictEnt [humanWord=" + humanWord + ", morseWord="
					+ morseWord + ", wordVal=" + wordVal + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((wordVal == null) ? 0 : wordVal.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DictEnt other = (DictEnt) obj;
			if (wordVal == null) {
				if (other.wordVal != null)
					return false;
			} else if (!wordVal.equals(other.wordVal))
				return false;
			return true;
		}

		@Override
		public int compareTo(DictEnt o) {
			return this.wordVal.compareTo(o.wordVal);
		}
		
		
	
}


public class MorseCodeParser {
	

	private Map<Character,String> charMap = new HashMap<>();
	private List<String> rawDict = new ArrayList<>();
	private List<String> input = new ArrayList<>();
	private List<DictEnt> dict = new ArrayList<>();
	private Map<BigInteger,Integer> wordValCountMap = new HashMap<>();
	
	private void init(String path){
		
		BufferedReader br = null;
		int readState = 0;
		 
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(path));
 
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				
				if(sCurrentLine==null||sCurrentLine.trim().isEmpty())
				{
					continue;
				}
				if(sCurrentLine.trim().equals("*"))
				{
					readState++;					
				}
				else if(readState ==0){
					String[] tokens = sCurrentLine.trim().split(" ");
					
					if(tokens[0]==null || tokens[0].trim().length() !=1 ||
							tokens[1]==null || tokens[1].trim().isEmpty())
					{
						System.out.println("malformed input: "+sCurrentLine);
						continue;
					}
					
					charMap.put(tokens[0].charAt(0), tokens[1]);
				}
				else if(readState ==1){
					rawDict.add(sCurrentLine.trim());
				}
				else
				{
					input.add(sCurrentLine.trim());
				}
					
			}
			
			if(this.rawDict!=null && this.rawDict.size() >0)
			{
			 
				 for(String word:this.rawDict){
					DictEnt dictEnt = new DictEnt(word,this.charMap); 
					this.dict.add(dictEnt);
					
					if(this.wordValCountMap.get(dictEnt.getWordVal())==null)
						this.wordValCountMap.put(dictEnt.getWordVal(), 1);
					else
					{
						Integer count = this.wordValCountMap.get(dictEnt.getWordVal());
						this.wordValCountMap.put(dictEnt.getWordVal(),count++);
					}
				 }
				 
				 Collections.sort(this.dict);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	private List<String> processMorse() {
		
		if(this.input==null||this.input.isEmpty()||this.dict.isEmpty())		
			return null;
		
		 List<String> output = new ArrayList<>();
		 
		 for(String morse:input){
			 
			 String matchWord = binSearch(morse,0,dict.size()-1);
			 
			 if(matchWord == null)
				 continue;
			 
			 if(matchWord.endsWith("?"))
				 output.add(matchWord);
			 else
			 {
				 BigInteger wordVal = getWordVal(morse);
				 
				 if(this.wordValCountMap.get(wordVal)>1)
					 output.add(matchWord+"!");
				 else
					 output.add(matchWord);
			 }
		 }
		 
		 return output;
	}	
	
	private BigInteger getWordVal(String morse){
		
		return new BigInteger(new StringBuilder(morse).reverse().toString().replaceAll(" ","").replaceAll("\\.", "1").replaceAll("-", "2"));
		
	}

	/**
	 *
	 * @param morse
	 * @param start
	 * @param end
	 * @return
	 */
	private String binSearch(String morse,int start, int end) {
		
//		System.out.println(" binSearch: morse =  *"+morse+"* "+start+" "+end);
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		BigInteger wordVal = getWordVal(morse);
		BigInteger startWordVal = this.dict.get(start).getWordVal();
		BigInteger endWordVal = this.dict.get(end).getWordVal();
		
		if(start == end)
		{
			if(wordVal.equals(startWordVal))
				return this.dict.get(start).getHumanWord();
			else
				return this.dict.get(start).getHumanWord()+"?";
		}
		else if(startWordVal.compareTo(wordVal)>0)
		{
			System.out.println("word lesser than start");
			return this.dict.get(start).getHumanWord()+"?";
		}	
		else if(endWordVal.compareTo(wordVal)<0)
		{	System.out.println("word greater than end");
			return this.dict.get(end).getHumanWord()+"?";
		}
		else if(end - start ==1){
			
			if(wordVal.equals(startWordVal))
				return this.dict.get(start).getHumanWord();
			else if(wordVal.equals(endWordVal)) 
				return this.dict.get(end).getHumanWord();
			else
			{
				BigInteger startDiff = wordVal.subtract(startWordVal);
				BigInteger endDiff = endWordVal.subtract(wordVal);
				
				//The ! will be added by map examintation
				if(startDiff.equals(endDiff)){
					return this.dict.get(start).getHumanWord();
				}					 
				else if(startDiff.compareTo(endDiff) <0)
					return this.dict.get(start).getHumanWord()+"?";
				else 
					return this.dict.get(end).getHumanWord()+"?";
					
			}
		}
		else
		{
			
			int mid = (start + end)/2;
			//System.out.println("mid = "+mid);
			
			BigInteger midWordWal = this.dict.get(mid).getWordVal();
			
			if(midWordWal.equals(wordVal))
				return this.dict.get(mid).getHumanWord();
			else if(midWordWal.compareTo(wordVal) < 0)
				return binSearch(morse,mid,end);
			else
				return binSearch(morse,start,mid);
		}
		
		
	}

	public static void main(String[] args) {
		
		MorseCodeParser parser = new MorseCodeParser();
		parser.init("/Users/Ramanan/Desktop/input.txt");
		
		System.out.println(parser.charMap.size());
		System.out.println(parser.rawDict.size());
		System.out.println(parser.input.size());		
		System.out.println(parser.dict.size());
		System.out.println(parser.dict);
		System.out.println(parser.wordValCountMap);
		
		List<String> output = parser.processMorse();
		
		System.out.print(output);
		
		
	}



}
