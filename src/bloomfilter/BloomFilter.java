package bloomfilter;

import java.util.Arrays;

public class BloomFilter {
	
	private int[] store = new int[32];
	


	private int hashFunction(int xint, int i, int m){
		
		long x = xint;
		
		long result = ((x*x +x*x*x)*i) % m;
		System.out.println("result = "+result);
		
		return (int)result;
	}	
	
	private int hashFunction2(int x, int i, int m){
		
		
		return (int)(Math.pow(x, i)) % m;
	}

	
	public void storeVal(int input){
		
		int bit1 = hashFunction(input, 1, 32);
		int bit2 = hashFunction(input,2, 32);
		int bit3 = hashFunction(input,3,32);
		
		if(this.store[bit1] == 1 && this.store[bit2] == 1 && this.store[bit3] == 1)
		{
			System.out.println(input + "already present");
		}
		
		this.store[bit1] = 1;
		this.store[bit2] = 1;
		this.store[bit3] = 1;
		
		System.out.println("-----------------------------------");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BloomFilter bf = new BloomFilter();
		
		bf.storeVal(2013);	
		bf.storeVal(2010);
		bf.storeVal(2007);
		//2013, 2010, 2007, 2004, 2001, 1998
		bf.storeVal(2004);
//		bf.storeVal(2001);
//		bf.storeVal(1998);

	
		for(int i=0;i<bf.store.length;i++){
			System.out.println(i+". "+bf.store[i]);
		}

	}

}
