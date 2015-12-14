package pipala;

import java.util.List;

public class DeserializeTree {
	
	private String convertByteToString(byte s){
		
		return String.format("%8s", Integer.toBinaryString(s & 0xFF)).replace(' ', '0');
	}
	
	private boolean hasLeftChild(String s){
		return s.charAt(1) =='1';
	}
	
	private boolean hasRightChild(String s){
		return s.charAt(2) =='1';
	}
	
	private char getCharacter(String s){
		
		String sub = s.substring(3);
		int index = Integer.parseInt(sub, 2);
		int numValue = index +10;

		
		char ccc = Character.forDigit(numValue, 36);
	
		return ccc;
		
	}
	
	public CharNode getTree(List<Byte> list){
		
		if(list == null ||list.isEmpty())
			return null;
		
		Byte one = list.remove(0);
		String s  =convertByteToString(one);
		
		CharNode out = new CharNode();
		
		
		out.setValue(getCharacter(s));
		
		if(hasLeftChild(s))
			out.setLeft(getTree(list));
		
		if(hasRightChild(s))
			out.setRight(getTree(list));
		
		return out;
	}

}
