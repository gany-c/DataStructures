package pipala;

import java.util.ArrayList;
import java.util.List;

public class SerializeTree {
	
	private String convertToString(char a){
		
		int index = Character.getNumericValue(a) - 10;
		String binString = Integer.toBinaryString(index);
		
		while(binString.length() < 5){
			
			binString = "0"+binString;
		}
		
		return binString;
	}
	
	private byte serializeNode(CharNode c){
		
		
		StringBuffer out = new StringBuffer("0");
		
		if(c.getLeft()==null)
			out.append("0");
		else
			out.append("1");
		
		if(c.getRight()==null)
			out.append("0");
		else
			out.append("1");
		
		out.append(convertToString(c.getValue()));
		
		
		byte output = Byte.parseByte(out.toString(), 2);
		
		return output;
		
		
	}
	
	public List<Byte> serializeTree(CharNode head){
		
		if(head == null)
			return null;
		
		List<Byte> output = new ArrayList<Byte>();
		
		serializeTree(head,output);
		
		return output;
	}

	private void serializeTree(CharNode head, List<Byte> output) {
		
		output.add(serializeNode(head));
		
		if(head.getLeft()!=null)
			serializeTree(head.getLeft(),output);
		
		if(head.getRight()!=null)
			serializeTree(head.getRight(),output);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializeTree st = new SerializeTree();
		
		System.out.println(st.convertToString('a'));
		System.out.println(st.convertToString('b'));
		System.out.println(st.convertToString('z'));
	}

}
