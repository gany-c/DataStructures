package lists;

/**
 *  1. ARRAYS: Stack doesn't need to be circular, only the queue needs to be
 *  2. There is only one counter for the top and it moves in opposite directions for adding and removing.
 *  3. CONSTRUCTOR: initialize the array to the given size and set the pointer to -1 to indicate it is empty.
 *  4. POP: If the counter is lesser than 0, the stack is empty - return
 *  4.1. get the value pointed by the counter, decrement the counter and return the value.
 *  5. PUSH: If the counter is equal or greater than the last index, there is no more space, return
 *  5.1. Increment the counter and add the value at the counter index in the array.
 * @author gchidam
 *
 */
public class StackArray{
	
private String[] container = null;	
private int top = -1;

public  StackArray(int size)
{
 if(size<1)
 {

 }
  else
 {
   top = -1;
  container = new String[size];
 }
}


//wrapper is needed to hold top, otherwise the function will have toreturn two values
//new top and popped value. 

public String pop()
{
  if((top<0)||(container==null))
  {
    System.out.println("Stack is empty");
    return null;
  }
  else
  {
   String out = container[top];
   container[top] = null;
   top--;
   return out;   
  }
}

//this function could just retun the updated top, but you already have a wrapper, 
//so use it.
public void push(String newVal)
{
   if((container==null)||(top>=container.length-1))
   {
     System.out.println("No space to insert");
   } 
   else 
   {
	top++;
	container[top] = newVal;
	

   }
}

public void display(){
	
	for(String item:container){
		System.out.print(item+", ");
	}
	System.out.println("-- top = "+this.top);
	
}

public static void main(String[] args)
{
	
	StackArray q = new StackArray(5);

	
	q.pop();
	
	q.push("a");
	q.push("b");
	q.push("c");
	
	q.display();
	
	System.out.println("pop -------"+q.pop());
	
	q.display();
	
	q.push("d");
	q.push("e");
	q.push("f");
	
	q.display();
	
	System.out.println("pop -------"+q.pop());
	q.push("g");

	
	q.display();
	
}

} 