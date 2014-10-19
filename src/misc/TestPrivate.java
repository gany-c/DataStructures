package misc;


public class TestPrivate {

	/**
	 * @param args
	 */
	private void sayHi(){System.out.println("Hi");}
	
	public static void testTheHi()
	{	
		TestPrivate tp = new TestPrivate();
		tp.sayHi();
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testTheHi();

	}

}
