package javaTrial;

/*
 * Byte values can be directly created from String
 * Using the parseByte with radix or by using the string constructor
 * which is radix 10 by default.
 */
public class ByteTrial {
	
	public static void main(String[] args){
		
		Byte b = Byte.parseByte("110",2);
		
		System.out.println(b);
		
		b = Byte.parseByte("1110",2);
		
		System.out.println(b);
		
		b = Byte.parseByte("11110",2);
		
		System.out.println(b);
		
		b = Byte.parseByte("111110",2);
		
		System.out.println(b);
		
		b = Byte.parseByte("1111110",2);
		
		System.out.println(b);	
		
		b = Byte.parseByte("1111111",2);
		
		System.out.println(b);	
		
		try{
		b = Byte.parseByte("11111110",2);		
		System.out.println(b);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		try{
		b = Byte.parseByte("34",2);		
		System.out.println(b);
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
		
		Byte bb = new Byte("127");
		System.out.println(bb);	
	}

}

