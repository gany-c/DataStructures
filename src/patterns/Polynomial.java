package patterns;

import java.util.HashMap;
import java.util.Map;

public class Polynomial {
	
	// A polynomial is represented as a map of 
	// coefficients = keys, exponent powers as values
	private Map<Integer,Float> termMap;
	
	public void print(){
		
		System.out.println("Polynomial ==");
		
		StringBuilder output = new StringBuilder();
		for(Integer key: termMap.keySet())
			output.append(getTermString(key,termMap.get(key))+" + ");
		
		System.out.println(output.toString());
		
	}
	
	private String getTermString(Integer exp, Float coeff) {
		// TODO Auto-generated method stub
		return ""+coeff+"*x^"+exp;
	}

	private Polynomial( Map<Integer,Float> termMap){
		
		this.termMap = termMap;
		
	}
	

	
	public Polynomial add(Polynomial other){
		
		Builder pBuilder = new Builder();
		
		for(int exp:this.termMap.keySet()){
			pBuilder.put(exp, termMap.get(exp));
			
		}
		
		for(int exp:other.termMap.keySet()){
			pBuilder.put(exp, other.termMap.get(exp));
			
		}		
		return pBuilder.build();
		
	}
	
	private static Map<Integer,Float> mapCopy(Map<Integer,Float> input){
		
		Map<Integer,Float> output = new HashMap<Integer,Float>();
		
		for(Integer key:input.keySet())
			output.put(key, input.get(key));
		
		return output;
		
	}
	
	public static class Builder{
		private Map<Integer,Float> builderMap =  new HashMap<Integer,Float>();
		
		public Builder put(int exp, float base){
			
			Float oldBase = builderMap.get(exp);
			if(oldBase==null)
				builderMap.put(exp, base);
			else
				builderMap.put(exp, base+oldBase);
			
			return this;
			
		}
		
		public Polynomial build(){
			return new Polynomial(mapCopy(builderMap));
			
		}
		

	}

}
