"""
1. Merge and sum 2 time series range lists e.g. Input = [(0, 0), (3, 1), (7, 3), (10, 1)], [ (0, 0), (5, 3), (12, 2) ]. 
Output = [(0, 0), (3, 1), (5, 4), (7, 6), (10, 4), (12, 3)]
Solution: 

state variables = last y values of series 1, series 2, and the current sum
while(input-1 is not empty or input-2 is not empty){
  a. pop the smaller x value of the 2 lists - if both are equal take the Y value of both
  b. Check the Y value difference
  c. create (x - value, current sum + (Y value difference)). Push to output

  handle the tail case of the single longer list
}

2. Print and Delete the leaves of a tree until only head remains:
Solution - post order traversal - 

public void postOrderTraversal(TreeNode n){

if(n==null)
 return;
 
 postOrderTraversal(n.left)
 n.left = null;
 
 postOrderTraversal(n.right)
 n.right = null;
 
 print(n.val)
 }
 
 3. Given a string with markers %xyz%, replace the markers based on a dictionary.
 The dictionary can be nested i.e. values can have references to other keys in %--%.
 The input can have multiple markers
 
 4. Given a matrix with 0s representing background and 1s representing the foreground, return a matrix where the foreground's border is marked.
 Soln: Same as island size, but the recursive addition is not required. Just traverse the matrix.
 """
