package lists;

/**
 * 
 * @author gchidam
 * 
 * 1. There are two pointers for adding members and removing members to the queue.
 * 1.a. They both move in the same direction.
 * 2. The queue will always have one empty space to distinguish between emptiness and fullness
 * EXIT POINTS - Where to delete
 * ENTER POINTS - where to insert, they will be the same if the entire array is occupied,
 * 
 * 1. Need a string array and 2 counters as instance variables.
 * 2. CONSTRUCTOR: if the size of the queue is less than 2 quit
 * 2.a. initialize the array of the given size and initialize the counters to be 0 each.
 * 
 * GET: if enter == exit return, the queue is empty.
 * 1. Else, store the value at exit = out.
 * 2. update the value at exit to be null
 * 3. move exit forward, but with mod function.
 * 
 * ADD: Enter is the place where the next element should be added.
 * 1. Calculate next, this is the place where enter will point to after insertion.
 * 2. Now, if next and exit are the same - don't insert, return.
 * 3. else add the new element at enter location; update enter to next.
 *
 */
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
	//http://stackoverflow.com/questions/25944351/full-empty-buffer-distinction-in-circular-queue
	
	q.get();
	
	q.add("a");
	q.add("b");
	q.add("c");
	
	q.display();
	
	System.out.println(q.get());
	
	q.display();
	
	q.add("d");
	q.add("e");
	q.display();
	q.add("f");//won't be written
	
	q.display();
	
	System.out.println(q.get());
	q.add("g");

	
	q.display();
	
}

}