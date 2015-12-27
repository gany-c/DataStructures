package pipala.tree;


public class CharNode{

private char value;
private CharNode left;
private CharNode right;

public char getValue(){
return value;
}

public void setValue(char value){
this.value = value;
}

public CharNode getLeft(){
return left;
}

public CharNode getRight(){
return right;
}

public void setLeft(CharNode node){
this.left = node;
}

public void setRight(CharNode node){
this.right = node;
}
}



