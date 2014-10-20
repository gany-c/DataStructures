package lists;

import base.IntWrapper;


public class CircularQueue{
	
 String[] queue = null;
 int enter =0;
 int exit = 0;
	
	
public CircularQueue(int n){
	
	if(n<2)
	{
		System.out.println("Cannot create a queue smaller than 2 items");
		return;
	}		
	else 
	{
		queue = new String[n];
		this.enter = 0;
		this.exit = 0;
	}
	
}


public String get()
{

	if(enter==exit)
	{
		System.out.println("Q is empty");
		return null;
	}
	else
	{
		String out = queue[exit];
		queue[exit] = null;
		
		int n = queue.length;
		exit = (exit +1)%n;
		// both and add and get pointers move in the same direction
		//exit pointer doesn't move backward for deletion.
		return out;
	}

}

public void add(String insertVal)
{
	 int n = queue.length;
	 int next = (enter+1)%n;
	
	 if(next==exit)
	 {
		System.out.println("Q is Full");
	 }
	 else
	 {
		queue[enter] = insertVal;
		enter=next;	
	 }
}

public void display(){
	
	for(String item:queue){
		System.out.print(item+", ");
	}
	System.out.println("-- Enter = "+this.enter+", Exit = "+this.exit);
	
}

public static void main(String[] args)
{
	
	CircularQueue q = new CircularQueue(5);
	//can write only 4 items - 1 buffer space is needed to differentiate between
	//empty and full.
	
	q.get();
	
	q.add("a");
	q.add("b");
	q.add("c");
	
	q.display();
	
	System.out.println(q.get());
	
	q.display();
	
	q.add("d");
	q.add("e");
	q.add("f");//won't be written
	
	q.display();
	
	System.out.println(q.get());
	q.add("g");

	
	q.display();
	
}

}