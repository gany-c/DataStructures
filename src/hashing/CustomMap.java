/*
# Linkedin, how do you make it thread safe?
# hashmap
# V get(K)
# put(K, V)
# K, V are strings
*/

public Class Node{
 
  public String key;
  public String value;
  public Node next;
}  

public Class CustomMap{
  
  // Array of LinkedLists
  Node[] buckets
  int size  
    
  public CustomMap(int size){   
    buckets = new Node[size];
    this.size = size;
  }  
  
  public String get(String K){
    int index = getIndexByHash(K);
    Node node = this.buckets[index];
    String V = null
    
    //traverse linkedlist
    while(node!=null){
      if(K.equals(node.key)){
        V = node.value;
        break;
      } else {
        node = node.next; 
      }
    }
    
    return V;
  }
  
  public void insertIntoBucket(Node node, int index){
    
    Node head = buckets[index];
    Node last = null;
    
    while(head!=null){
      //if the key is already present, replace value
      if(head.key == node.key){
        head.value = node.value;
        return;
      } else {
        //traverse through the list
        last = head;
        head = head.next;
      }  
      
    }  
    
    //if key is not found
    if(last == null){
      //insert as first value in the empty bucket
      buckets[index] = node;
    } else {
      //insert the new value at the end
      last.next = node;
    }  
    
  }
  
  public void getIndexByHash(){
    
  }  
  
  public void put(String K, String V) throws Exception{
    
    if(K == null || V == null)
      throw Exception("Please pass non-null values for K and V");
    
    Node node = new node();
    node.key = K;
    node.value = V;
    
    index = getIndexByHash(K);
    insertIntoBucket(node, index);
  }  
  
}  
  
