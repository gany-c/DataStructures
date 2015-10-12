package bloomfilter;


/**
 * BloomFilter is a data structure for quick boolean lookups with a small chance of false positives
 * e.g. is a username lookup at the time of registration. Some false positives are allowed.
 * 
 * in the example below an integer is stored as 3 bits in a bit array. 
 * The position of the bits is determined by the hash function
 * 
 * the percentage of false postives can be tweaked by
 * 
 * 1. size of the bit array - just has to be large, needn't be prime
 * 2. the coefficients used in calculation of the hashes - have to be relatively large and prime
 * 2.a. 2 digit primes work better than 4 digit non primes.
 */
public class BloomFilter {
	
	private final int size = 88;
	private int[] store = new int[size];
	


	private int hashFunction(int xint, int i, int m){
		
		long x = xint;
		
		long result = ((x*x +x*x*x)*i) % m;
		//System.out.println("result = "+result);
		
		return (int)result;
	}	
	
/*	private int hashFunction2(int x, int i, int m){
		
		
		return (int)(Math.pow(x, i)) % m;
	}*/
	
	private int[] getBitIndex(int input){

//		int bit1 = hashFunction(input, 1607, size);
//		int bit2 = hashFunction(input,65521, size);
//		int bit3 = hashFunction(input,2213,size);   
		
		int bit1 = hashFunction(input, 53, size);
		int bit2 = hashFunction(input,59, size);
		int bit3 = hashFunction(input,61,size);   		
		
		int[] output = new int[3];
		output[0] = bit1;
		output[1] = bit2;
		output[2] = bit3;
		
		return output;
		
	}
	
	public boolean isPresent(int input){
		int[] indices = getBitIndex(input);
		
		if(this.store[indices[0]] == 1 && this.store[indices[1]] == 1 && this.store[indices[2]] == 1)
		{
			return true;
		}
		else
			return false;
	}

	
	public void storeVal(int input){
		

		
		if(isPresent(input))
		{
			return;
		}
		
		int[] indices = getBitIndex(input);
		
		this.store[indices[0]] = 1;
		this.store[indices[1]] = 1;
		this.store[indices[2]] = 1;
		
		//System.out.println("-----------------------------------");
		
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

	
/*		for(int i=0;i<bf.store.length;i++){
			System.out.println(i+". "+bf.store[i]);
		}*/
		
		System.out.println("2007 = "+bf.isPresent(2007));		
		System.out.println("2010 = "+bf.isPresent(2010));
		System.out.println("2013 = "+bf.isPresent(2013));
		System.out.println("2004 = "+bf.isPresent(2004));
		System.out.println("-----------------------------------");
		System.out.println("2014 = "+bf.isPresent(2014));
		System.out.println("2012 = "+bf.isPresent(2012));
		System.out.println("2011 = "+bf.isPresent(2011));
		System.out.println("2003 = "+bf.isPresent(2003));
		System.out.println("2002 = "+bf.isPresent(2002));

	}

}
