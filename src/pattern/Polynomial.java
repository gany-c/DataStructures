package pattern;

import java.util.Map;

public class Polynomial {
	
	private Map<Integer,Float> termMap;
	
	private Polynomial(){
		
	}
	
	public PolynomialBuilder getBuilder(){
		return null;
		
	}
	
	public Polynomial add(Polynomial other){
		return other;
		
	}
	
	class PolynomialBuilder{
		private Map<Integer,Float> builderMap = null;
		
		public void put(int exp, float base){
			
		}
		
		public Polynomial build(){
			return null;
			
		}
	}

}
