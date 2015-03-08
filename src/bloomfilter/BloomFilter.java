package bloomfilter;

import java.util.Arrays;

public class BloomFilter {
	
	private int[] store = new int[64];
	
	private int[] getBinaryArray(int input){
		
		String binString = Integer.toBinaryString(input);
		
		
		int[] output = new int[64];
		
		for(int i= binString.length()-1;i>=0;i--)
		{
			
			output[i] = Integer.parseInt(""+binString.charAt(i));
		}
		
		return output;
	}
	
/*	private int hashFunction(int x, int i, int m){
		
		long a = x*x;
		
		System.out.println("a = "+a);
		
		long b = x*a;
		
		System.out.println("b = "+b);
		
		long c = a + b;
		
		System.out.println("c = "+c);
		
		long product = c * i;
		
		System.out.println("product = "+product);
		
		long out = product % m;
		
		System.out.println("out = "+out);
				
		
		return  (int)out;
	}*/
	
	
	private int hashFunction(int x, int i, int m){
		
		
		return (int)(Math.pow(x, i)) % m;
	}
	
	
	
	private int hashChain(int x, int m){
		
		int step1 = hashFunction(x,1,m);
		
		System.out.println("step1 = "+step1);
		
		int step2 = hashFunction(step1,2,m);
		
		System.out.println("step2 = "+step2);
		
		
		int step3 = hashFunction(step2,3,m);
		
		System.out.println("step3 = "+step3);
		
		return step3;
		
	}
	
	private void xor(int[] input){
		
		boolean alreadyPresent = true;
		
		for(int i=0;i<input.length;i++){
			
			if(input[i]==1 && store[i]==1)
				continue;
			else if(input[i]==1) 
			{
				alreadyPresent = false;
				store[i] =1;
			}
		}
		
		System.out.println("alreadyPresent = "+alreadyPresent);
	}
	
	public void storeVal(int input){
		
		int hashedVal = hashChain(input,64);
		
		int[] hashedArray = getBinaryArray(hashedVal);
		xor(hashedArray);
		System.out.println("-----------------------------------");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BloomFilter bf = new BloomFilter();
		
		bf.storeVal(1975);	
		bf.storeVal(1985);
		bf.storeVal(1995);
		bf.storeVal(2005);
		bf.storeVal(2015);
	
		for(int i=0;i<bf.store.length;i++){
			System.out.println(i+". "+bf.store[i]);
		}

	}

}
