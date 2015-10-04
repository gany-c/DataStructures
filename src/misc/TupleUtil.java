package misc;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Ramanan
 * Given tuples that represent ranges, merge overlapping tuples.
 * [1,5] [2, 7] [8,13]
 * 
 */
public class TupleUtil {
	
	public static class Tuple implements Comparable<Tuple>{

		private int start = 0;
		
		private int end = 0;
		
		public Tuple(int s,int e){
			this.start =s;
			this.end =e;
		}
		
		/**
		 * The check is done assuming the tuples are sorted by start
		 * @param o
		 * @return
		 */
		public boolean isMergeable(Tuple o){
			
			if(o==null)
				return false;
			else if (this.end < o.start)
				return false;
			else 
				return true;
			  
		}

		/**
		 * Compare tuples by start
		 */
		@Override
		public int compareTo(Tuple o) {
			
			if(o==null)			
				return 1;
			else
				return this.start -o.start;
		}
		
		/**
		 * 
		 * @param t1
		 * @param t2
		 * @return
		 * @throws Exception
		 */
		public static Tuple merge(Tuple t1,Tuple t2) throws Exception{
			
			if(t1==null||t2==null||!t1.isMergeable(t2))
				throw new Exception("can't merge");
			else
			{
				int s = t1.start < t2.start?t1.start:t2.start;
				int e = t1.end > t2.end?t1.end:t2.end;
				
				return new Tuple(s,e);
			}
			
		}
		
		public void display(){
			System.out.println("["+start+", "+ end+"]");
		}

	}
	
	public List<Tuple> mergeOverlaps(List<Tuple> input) throws Exception{
		
		if (input == null || input.size() <=1)
			return input;
		
		Collections.sort(input);
		
/*		System.out.println("------------soreted results start");
		for(Tuple in:input)
			in.display();
		System.out.println("------------soreted results end");*/
		
		Stack<Tuple> stack = new Stack<Tuple>();
		stack.push(input.remove(0));
		
		while(!input.isEmpty()){
			
			Tuple r = input.remove(0);
			if(stack.peek().isMergeable(r))
			{
				Tuple l = stack.pop();
				Tuple merged = Tuple.merge(l, r);
				stack.push(merged);
			}
			else
				stack.push(r);
			
		}
		
		List<Tuple> output = new ArrayList<Tuple>();
		output.addAll(stack);
		return output;
		
	}

	public static void main(String[] args) {
		
		TupleUtil util = new TupleUtil();
		
		Tuple t1 = new Tuple(1,5);
		Tuple t2 = new Tuple(2,7);
		Tuple t3 = new Tuple(8,13);
		
		List<Tuple> input = new ArrayList<Tuple>();
		input.add(t1);
		input.add(t2);
		input.add(t3);		
		
		try 
		{
			List<Tuple> out = util.mergeOverlaps(input);
			for(Tuple o:out)
				o.display();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("_____________________________________________");
		input.add(t1);
		input.add(t2);
		input.add(t3);
		input.add(new Tuple (15,21));
		
		try 
		{
			List<Tuple> out = util.mergeOverlaps(input);
			for(Tuple o:out)
				o.display();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("_____________________________________________");
		input.add(t1);
		input.add(t2);
		input.add(t3);
		input.add(new Tuple (15,21));
		input.add(new Tuple (7,25));
		
		try 
		{
			List<Tuple> out = util.mergeOverlaps(input);
			for(Tuple o:out)
				o.display();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
