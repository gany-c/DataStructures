package patterns;

public class PolynomialClient {

	public static void main(String[] args) {
		
		Polynomial p = new Polynomial.Builder().put(1,2).put(2,2).build();
		p.print();
		
		Polynomial p2 = new Polynomial.Builder().put(3,1).put(2,1).build();
		
		Polynomial p3 = p2.add(p);
		p3.print();

	}

}
