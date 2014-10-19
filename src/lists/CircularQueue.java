package lists;

import base.IntWrapper;





public class CircularQueue{

private int[] createQueue(int n)
{

if(n<2)
	return null;
else 
{
int[] queue = new int[n];
return queue;
}

}

private int exit(int[] queue,base.IntWrapper enter,base.IntWrapper exit)
{

if(enter.getValue()==exit.getValue())
{
	System.out.println("Q is empty");
	return(Integer.MIN_VALUE);
}
else
{
	int out = queue[exit.getValue()];
	queue[exit.getValue()] = Integer.MIN_VALUE;
	
	int n = queue.length;
	exit.setValue(exit.getValue()+1%n); 

	return out;
}

}

private void enter(int[] queue,IntWrapper enter,IntWrapper exit,int insertVal)
{
 int n = queue.length;
 int next = enter.getValue()+1%n;

 if(next==exit.getValue())
 {
	System.out.println("Q is Full");
 }
 else
 {
	queue[next] = insertVal;
	enter.setValue(next);	
 }
}
}