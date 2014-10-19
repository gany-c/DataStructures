package misc;

import java.util.Iterator;


public class WordUtils {
	
	public static java.util.List findCompound(String[] inputWords) throws RuntimeException
	{
		if(inputWords==null||inputWords.length==0)
			return null;
		
		java.util.List output = new java.util.ArrayList();
		java.util.HashMap countMap = new java.util.HashMap();
		
		
		for(int curPos=0;curPos<inputWords.length;curPos++)
		{
			String curWord = (String)inputWords[curPos];			
			
			for(int i=0;i<inputWords.length;i++)
			{
				String compareWord = (String)inputWords[i];
				if(compareWord==null||i==curPos)
					continue;
				
				if(compareWord.indexOf(curWord)>-1)
				{
					Integer count = (Integer)countMap.get(compareWord);
					
					if(count==null)
						countMap.put(compareWord,new Integer(1));
					else
						countMap.put(compareWord,new Integer(count.intValue()+1));					
					
				}
			}		
			
		}
		
		java.util.Set keySet = countMap.keySet();
		Iterator it = keySet.iterator();
		
		while(it.hasNext())
		{
			String key = (String)it.next();
			Integer value = (Integer)countMap.get(key);
			
			if(value!=null&&value.intValue()>1)
				output.add(key);
		}
		
		return output;
	}
	
	public static void main(String[] args)
	{
		findCompound(null);
	}

}
