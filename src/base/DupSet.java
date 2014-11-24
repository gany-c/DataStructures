package base;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class DupSet {
	
	private List<Integer>  holder = new ArrayList<Integer>();
	
	@Override
	public int hashCode(){
		
		int sum = 0;
		
		for(int num:holder)
			sum+=num;
		
		return sum;
	}
	
	public TreeMap<Integer,Integer> getMap(){
		
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		
		for(int num:holder)
		{
			Integer val = map.get(num);
			
			// ++ operator doesn't work on Wrappers
			if(val != null)
				map.put(num,val+1);
			else
				map.put(num, 1);
		}
		
		return map;
		
	}
	
	@Override
	public boolean equals(Object o){
		
		TreeMap<Integer,Integer> thisMap = this.getMap();
		TreeMap<Integer,Integer> oMap = ((DupSet)o).getMap();		


		if(!(thisMap.size()== oMap.size()))
		{
			//System.out.println("different sizes"); 
			return false;
		}
			
		else if(!(thisMap.keySet().equals(oMap.keySet())))
		{
			//System.out.println("key sets not equal");
			return false;
		}
		else
		{
	
			
			for(Integer key:oMap.keySet())
			{
				if(oMap.get(key)!=thisMap.get(key))
					return false;
			}
			
			return true;
		}
		
	}
	
	public void add(int a){
		this.holder.add(a);
	}
	
	public int get(int index){
		if(index >= holder.size()||index < 0)
			return -1;
		else
			return holder.get(index);
	}

	@Override
	public String toString() {
		return "[" + holder + "]";
	}
	
	public static void main(String[] args){
		
		DupSet one = new DupSet();
		one.add(1);
		one.add(1);
		one.add(2);
		one.add(1);
		
		DupSet two = new DupSet();
		
		two.add(2);
		two.add(1);
		two.add(1);
		two.add(1);
		
		System.out.println(one.hashCode()+ " "+two.hashCode());
		
		System.out.println(one.equals(two));
		
	}
	
	

}
