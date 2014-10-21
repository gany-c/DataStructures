/**
 * Returns a^b, as the standard mathematical exponentiation function
 */
public double pow(double a, int b) {

    double output = 1;
    
    if(b == 0)
        return output;
    else
    {
        term  = a;
        if (b <0 )
            term = (1/a); 
              
         int newB = abs(b); 
         

  
          for(int i =0; i < newB; i++)
          {
              output = output * term;
          } 
  
    }    
        
 }       
        
/*        
    else if( b < 0)
    {
          int newB = b * (-1); // abs 
          for(int i =0; i < newB; i++)
          {
              output = output * (1/ a);
          }
         
         return output;       
    }    
    else
    {//
            int i = 1;
            double term = a;
            
            do
            {
                output = output * term;
                term = 2 * term; 
                i = 2 * i; 
            }
            while(i < b)
    
            return output;
    }

}
*/

public interface TwoSum {
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

   private List storeList = new ArrayList(); 


   void store(int input){

        storeList.add(input);


   }
   
   boolean test(int val){
   
   
       for(int i =0;i<storeList.size()-1;i++)
       {
             int val1 = storeList.get(i);
             
             for(int j =i+1;j<storeList.size();j++)
             {
                 if(val1 + storeList.get(j)) == val)
                     return true;
             }
        } 
        
        return false;
   }
}

--------------
public class Summer2 implements TwoSum{

   private List storeList = new ArrayList(); 
   
   private Set sumSet  = new HashSet();

   void store(int input){
   
        for(Integer i:storeList){
        
            sumSet.put(input + i);
        }

        storeList.add(input);
        


   }
   
   boolean test(int val){
   
      
        return sumSet.contains(val);
   }
}

--------------


public class Summer implements TwoSum{

   private List storeList = new ArrayList(); 
   
   private Set storeSet = new HashSet();

   void store(int input){

        storeList.add(input);
        storeSet.put(input);

   }
   
   boolean test(int val){
   
     for(int i = 0; i < storeList.size(); i++)
     {
         int diff = val - storeList.get(i);
         
         if(storeSet.contains(diff))
             return true;
     }
     
     return false;
   }
}
