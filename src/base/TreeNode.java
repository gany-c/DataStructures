package base;


public class TreeNode{

private int value;
private TreeNode left;
private TreeNode right;

public int getValue(){
return value;
}

public void setValue(int value){
this.value = value;
}

public TreeNode getLeft(){
return left;
}

public TreeNode getRight(){
return right;
}

public void setLeft(TreeNode node){
this.left = node;
}

public void setRight(TreeNode node){
this.right = node;
}
}



