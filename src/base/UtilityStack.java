package DS.base;

import java.util.ArrayList;

public class UtilityStack{

private ArrayList stack = null;

public Object pop()
{
  if(stack.size()==0)
  {
    System.out.println("Stack Empty");
    return null;
  }  
  else
  {	
    Object out = stack.get(stack.size()-1);
    stack.remove(stack.size()-1);
    return out;
  }
}

public void push(Object insertObj)
{
stack.add(insertObj);

}

 public UtilityStack()
 {
   stack = new ArrayList();
 }

public static void main(String args[])
{
UtilityStack stack = new UtilityStack();
System.out.println(stack);

}

}