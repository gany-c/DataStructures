/*
Given a sentence, find all pairs of words whose counts sum to given target. 
Example - “I am solving this word count problem. I like this and I like other word games!” and target = 5 (I, word), (I, this), (I, like).

First pass - Word to Count map - ignore words with count greater than target

Second pass - traverse the map, and check if the counts sum up to the target 
*/

class StringPair{
    String first;
    String second;
}

class WordCount{
    String word;
    int count;
}

public List<StringPair> findPairCountSumsToTarget(String sentence, int target){
    
    if (target <=0 || sentence == null || sentence.isEmpty())
        return null;
        
        
   Map<String, Integer> countMap = getCountMap(sentence, target); 
   WordCount[] entryArray = new WordCount[countMap.size()];
   
   //copying to a list - copy to a hashset
   for (Entry<String, Integer> entry:  countMap.entrySet()) {
       WordCount wc = new WordCount();
       wc.word = entry.getKey();
       wc.count = entry.getValue();
   }
   //AFTER THOUGHT - you can include a  Map<int,List<String>> creation here
    //compare with that
   
   List<StringPair> output = new ArrayList<StringPair>();   
   
   if (entryArray.length <= 1)
      return output;  
   
   // n ^2 traversal - made better using a hashset
   for(int i = 0; i < entryArray.length - 1; i++){       
       for(int j = i +1; j < entryArray.length; j++){
           
           if(entryArray[i].count + entryArray[j].count == target){
               StringPair sp = new StringPair();
               sp.first = entryArray[i].word;
               sp.second = entryArray[j].word;
               output.add(sp);
           }
       }
   }  
   
   return output;  
}

private Map<String, Integer> getCountMap(String sentence, int target) {
    
    String[] words = new StringTokenizer(sentence, " ");
    Map<String, Integer> countMap = new HashMap<>();
    
    for (String word: words){
        //strip punctuation from word
        if (!countMap.containsKey(word)){
            countMap.put(word, 1);
        } else {
            int count = countMap.get(word);
            countMap.put(word, count++);
        }
    }
    
    return countMap;    
}
