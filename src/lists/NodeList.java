package lists;

//This is the text editor interface. 
//Anything you type or change here will be seen by the other person in real time.
/*
Requirement:
Reverse every 3 elements as a group.
If the end of the list has elements which are not 3 long then leave them as is, do not swap.

Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8

Ouput: 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8

3, 2, 1, 6, 5, 4, 7, 8, 

Requirements: 1. no value swapping; 2. no extra space, only in-place swap

*/

class Node{
 int val;
 Node next;
}

//Header node is in the beginning
//value Integer.MIN_VALUE

public class NodeList{
 
 Node header = null;
 
public NodeList(){
   
   this.header = new Node();
   header.val = Integer.MIN_VALUE;
   
}  

public void init (int[] input){
   
   if (input == null || input.length == 0)
     return;
   
   Node curr = header;
     
   for(int i=0;i<input.length;i++){
       
       Node n = new Node();
       n.val = input[i];
       
       curr.next = n;
       curr = curr.next;
     
   }
   
   System.out.println("End of init"); 
}
 

public void swapEvery3rd(){
 
 Node start = header.next;
 
 while(start!=null){
     
     Node third = getThird(start);
     
     if(third==null)
         return;
     else{
         swapThird(start, header);
         //now start should be at third's place
         start = start.next; 
     } 
 }
 
}

private Node getThird(Node start){
 
 if(start == null)
     return null;
 
 Node nextNode = start.next;
 if(nextNode == null)
     return null;
 
 return nextNode.next;
 
}

/**
* Doesn't return anything.
* Assuming this method is called only after proper null checks
*/
private void swapThird(Node first, Node header){
 
 System.out.println("Value being swapped = "+first.val);
 
 Node curr = header;
 
 //iterate until you reach the node before first
 while(curr.next !=null && curr.next != first){
     curr = curr.next;
 }
 
 //get middle node
 Node second = first.next;
 
 //get third node
 Node third = second.next;
 //get successor to third node
 Node fourth = third.next;
 
 //make node befor first point to third
 curr.next = third;
 
 //make node after third = first's successor
 third.next = second;
 
 //insert first node in place
 second.next = first;
 first.next = fourth;
 
 
}   

private static void printList(Node header){
 
 if(header == null||header.next ==null)
     return;
 
 Node curr = header;
 
 System.out.println();
 while(curr.next != null){
     System.out.print(curr.next.val +", ");
     curr = curr.next;
 }    
 System.out.println();   
 
}

public static void main(String[] args){
 System.out.println("hi");
 
 NodeList nList = new NodeList();
 nList.init(new int[]{ 1,2,3,4,5,6,7,8 });
 printList(nList.header);
 
 nList.swapEvery3rd();
 printList(nList.header);
 
}
 
}
