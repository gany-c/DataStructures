package string;

public class Amazon {

}
/**
- You're given a text file of white space delimited words
- Words may be separated by one or more white spaces
- You're asked to compute the following:

- The total number of words in the file
- The frequency of each word
- The top-K most frequently occurring words in the file

- Caveat: You may not use String.split(), Pattern, StringTokenizer, StringBuffer, StringBuilder, etc to split a line of text, i.e., parse the text on your own.


/**
1. I have method to read the file and create a string variable
2. Read each line, use the String.charAt() == ' ' split the word,

2.1 if you encounter a whitespace
2.1.1 if you have a temporary variable of some length - break the word, reset the temporary variable
2.1.2 if your temporary variable is of 0 length, ignore the whitespace


class ReadOutput {
    
    int numberOfWords = 0;
    java.util.Map<String, Integer> frequency;
    List<String> topK;
    }
    
    class WordFrequency implements Comparable<WordFrequency>{
        
    }    
    
    public ReadOutput processFile(String fileName, int k){
        
        if(k <= 0)
              throw new Exception("Invalid argument for K");
        
       if(fileName == null || fileName.length() == 0)
           throw new Exception("Invalid file name");
           
        Queue topK = new PriorityQueue<>(K) //size   
           
       Iterator<String> lines= getLines(fileName);
       
       Map frequencyMap = new HashMap<String,Integer>();
       
       while(lines.hasNext()){
           
           String line  = line.next();
           List<String> words =  line.getTokens();
       
           for(String word:words){
               
               if(frequencyMap.get(word == null)
                   frequencyMap.put(word, 1);
                else
                    frequencyMap.put(word, frequencyMap.get(word)++);   
           }    // for loop                     
       } // while loop
       
       int totalWordCount == 0;
       for(Value<String, Integer> value: frequencyMap.valueSet()){
           
           totalWordCount = totalWordCount + value.getValue();
           
           WordFrequency wf= getWordFrequency(value);
           
           if(wf.compareTo(topK.peek())
           {
               topK.add(wf);
               topK.poll();
            }   
   
       }    
       
       ReadOutput output = getOutput(totalWordCount, frequencyMap, topK);
  }
  
  private ReadOutput getOutPut(int totalWordCount, .....){
  
  }
  private Iterator<String> getLines(String fileName){
      
     


BufferedReader reader = new BufferedReader(new StringReader(<string>));
String line = reader.readLine();
  
      
   }   
*/
