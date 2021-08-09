"""
--------------------------------
Given 2 integers represented as 2 arrays of single digit integers, 
add them together and output the result in the form of array of single digit integers. 

For example:
Input: [3, 4, 5] and [9, 4] (represent 345 and 94)
Output: [4, 3, 9] (represents 439)
--------------------------------
"""        
        
def add_integer_array(array_1: int[], array_2: int[]): int[]
    
        
    if !array_1 or !array_2:
        return    
        
    output = []    
    
    # 3rd param is for carry over
    # 4th param is for index from end
    # 5th param is the output
    traverse(array_1, array_2, 0, 0, output)
    
    return output


def traverse(array_1, array_2, carry_over, index, output)

    pos_1 = len(array_1 - 1) - index
    pos_2 = len(array_2 - 1) - index
    
    # handle -ve pos here
    first_digit = 0
    second_digit = 0
    

    if pos_1 >= 0:
       first_digit = array_1[pos_1]
    
    if pos_2 >=0:
        second_digit = array_2[pos_2]
    
    local_sum = first_digit + second_digit + carry_over
    
    
    digit = local_sum % 10
    new_carry = local_sum / 10
    
    output_pos = len(output -1) - index
    output[output_pos] = digit
    
    if (pos_1 < 0) && (pos_2 < 0) :       
        return
    else:    
        traverse(array_1, array_2, new_carry, index + 1, output)

        
        
        
        
        
"""
Given an input string where all spaces have been removed, and an English dictionary, insert spaces back into the string so that it contains all valid words.

Example:
1.Input: s = "cathat", wordDict = ["cat","hat"] Output: "cat hat"

2.Input: s = "applepenapple", wordDict = ["apple","pen"] Output: "apple pen apple"

3.Input: s = "catshat", wordDict = ["cat","hat"] Output: ""

4.Input: s = "catha", wordDict = ["cat","hat"] Output: ""

5.Input: s = "pencathat", wordDict = ["cat","hat"] Output: ""

6.Input: s = "pencathat", wordDict = ["cat","hat", "pen"] Output: "pen cat hat"

7.Input: s = "caterhat", wordDict = ["cat", "cater","hat"] Output: "cater hat"

8.Input: s = "caterhat", wordDict = ["cat", "cater","hat", "er"] Output: ["cater hat"], ["cat er hat"]
     
"""


def insert_spaces(sentence: str, wordDict: str[], OUtput = ""): output:str
        
    if (sentence == len 0):
        return
        
    match_words = []    
        
    for word in wordDict:
        if starts_with(sentence, word):
            match_words.append(append)
            
    if len(match_words) == 0:
       return ""
    else:
        
       for match_word in match_words:
          new_sent = remove_first( 
          #try if a solution emerges in any of the matchwords recursively
          insert_spaces(new_sent, wordDict, match_word    
              
        
        
