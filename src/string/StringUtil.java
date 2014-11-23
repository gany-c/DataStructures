package string;

public class StringUtil {
	
	public int indexOf(String main, String sub){
		
		if(main == null || sub ==null)
			return -1;

		else if(main.length() < sub.length())
			return -1;
		
		
		for(int i =0;i<=main.length()-sub.length();i++)
		{
			if(startsWith(main,sub,i))
				return i;
		}
		
		return -1;
		
	}

	private boolean startsWith(String main, String sub, int i) {
		
		if(main == null || sub ==null||i<0)		
			return false;
		else
		{
			for(int j=0;j<sub.length();j++){
				if(sub.charAt(j)!=main.charAt(j+i))
					return false;
			}
			
			return true;
		}
	}
	
	public static void main(String[] args){
		
		StringUtil util = new StringUtil();
		
		System.out.println(util.indexOf("Vatapi Ganapathy","Gana"));
		System.out.println(util.indexOf("Vatapi Ganapathy","Vatapi"));
		System.out.println(util.indexOf("Vatapi Ganapathy","arch"));
		
	}

}
