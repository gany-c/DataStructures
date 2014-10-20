package lists;


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