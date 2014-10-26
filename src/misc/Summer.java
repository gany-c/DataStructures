package misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
      
        


interface TwoSum {
    /**
     * Stores @param input in an internal data structure.
     */
    void store(int input);
 
    /**
     * Returns true if there is any pair of numbers in the internal data structure which
     * have sum @param val, and false otherwise.
     * For example, if the numbers 1, -2, 3, and 6 had been stored,
     * the method should return true for 4, -1, and 9, but false for 10, 5, and 0
     */
    boolean test(int val);
}






public class Summer implements TwoSum{

   private List<Integer> storeList = new ArrayList<Integer>(); 
   
   private Set<Integer> storeSet = new HashSet<Integer>();

   public void store(int input){

        storeList.add(input);
        storeSet.add(input);

   }
   
   public boolean test(int val)
   {
   
     for(int i = 0; i < storeList.size(); i++)
     {
         int diff = val - storeList.get(i);
         
         if(storeSet.contains(diff))
             return true;
     }
     
     return false;
   }
   
   public static void main(String[] args){
	   
	   Summer summer = new Summer();
	   
	   summer.store(1);
	   summer.store(-2);
	   summer.store(3);
	   summer.store(6);
	   
	   System.out.println(summer.test(4));
	   System.out.println(summer.test(-1));
	   System.out.println(summer.test(9));
	   
	   System.out.println(summer.test(10));
	   System.out.println(summer.test(5));
	   System.out.println(summer.test(0));
   }
 
}
