package misc;


import java.io.*;
import java.util.*;

/**
 * 
 * @author Ramanan
 * 
 * The final approach is the same as smallestAbsentNumber
 * 
 * Given an array of size N, if the numbers are contiguous 1 to N, 
 * then the solution = N +1;
 * 
 * If any larger number replaces any of the contigous numbers in the list, 
 * then the replaced number will become the solution.
 * 
 * So, regardless of the array's contents, 
 * it is enough to check from 1 to Length and report the first missing number.
 * 
 * Other approaches:-
 * 
 * 1. Sort and check for gap before the smallest, within the list, and then report the greater number. nlogn
 * 2. spatially infinite - array of size largest number initilaized to -1. 
 * Store values in the indexes = values. return the index of the first -1.
 * 3. put values max heap and keep finding the lowest number remaining, compare it with max heap's largest.
 *
 */
public class SmallestAbsentNumber2015 {

  
  private Set<Integer> getSetOfNumbers(int[] input){
    
    Set<Integer> output = new HashSet<Integer>();
    
    for(int i:input)
      output.add(i);
    
    return output;
  }
  
  public int findSmallestNotInList(int[] input){
    
    if(input == null || input.length == 0)
      return -1;
    
    Set<Integer> numSet = getSetOfNumbers(input);
    
    for(int i =1;i<=input.length;i++){
      if(!numSet.contains(i))
        return i;
    }
    
    return input.length + 1;
    
  }
  
  public static void main(String[] args) {
    
	  SmallestAbsentNumber2015 sol = new SmallestAbsentNumber2015();
    
    int[] a =  {2, 4, 5, 7,1, 13, 23};
    
    System.out.println("result = "+sol.findSmallestNotInList(a));
    
    int[] b = {10000, 254343,463434,24464, 1};
    
    System.out.println("result = "+sol.findSmallestNotInList(b));
    
    int[] c = {2,3,4,1};

    System.out.println("result = "+sol.findSmallestNotInList(c));
    
    int[] d = {2,3,4,1,7,8,6,5};

    System.out.println("result = "+sol.findSmallestNotInList(d));
    
    int[] e = {2};

    System.out.println("result = "+sol.findSmallestNotInList(e));
    
    int[] f = {1};

    System.out.println("result = "+sol.findSmallestNotInList(f));
  }
}


/* 
Your previous Plain Text content is preserved below:



This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

You can also change the default language your pads are created with
in your account settings: https://coderpad.io/profile

Enjoy your interview!

hi


// a = [2, 4, 5, 7,1, 13, 23]
// b = [10000, 254343,463434,24464, 1]




 */