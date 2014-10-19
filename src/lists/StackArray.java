package lists;

import base.IntWrapper;

public class StackArray{

private int[] createStack(int size, IntWrapper top)
{
 if((size<1)||(top==null))
 {
	return null; 
 }
  else
 {
   top.setValue(-1);
   return(new int[size]);
 }
}


//wrapper is needed to hold top, otherwise the function will have toreturn two values
//new top and popped value. 

private int pop(int[] stack, IntWrapper top)
{
  if((top.getValue()<0)||(stack==null))
  {
    System.out.println("Stack is empty");
    return Integer.MIN_VALUE;
  }
  else
  {
   int out = stack[top.getValue()];
   top.setValue(top.getValue()-1);
   return out;   
  }
}

//this function could just retun the updated top, but you already have a wrapper, 
//so use it.
private void push(int[] stack, IntWrapper top, int newVal)
{
   if((stack==null)||(top.getValue()>=stack.length-1))
   {
     System.out.println("No space to insert");
   } 
   else 
   {
	int newTop = top.getValue()+1;
	stack[newTop] = newVal;
	top.setValue(newTop);

   }
}

} 