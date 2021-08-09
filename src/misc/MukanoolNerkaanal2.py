"""



Question: Get range sum
You are given a binary search tree. Goal is to find sum of all elements in the tree which are in range [low, high].
Input: binary search tree, and range [low, high]
Example: Tree below, range [4, 7]. Output: 22
Explanation: 22 = 4+5+6+7
     6
    /   \
  4     10
 / \     / \
3  5    7  12

"""
# TODO - define Node class

class Node
 left: Node
 right: Node
 data: int
    

def get_range_sum(root: Node, min: int, max: int) -> output:int:
    if root == None or min > max:
        return
    
    sum = _get_range_sum(Node, min, max, 0)
    
    return sum


def _get_range_sum(root: Node, min: int, max: int, sum_so_far: int) -> output:int:
        
    sum = 0
    
    if root:
        sum = sum_so_far + _get_range_sum(root.left, min, max, sum_so_far)
        
        value = root.data
        
        if data >= min and data <= max:
            sum = sum + data
        
        if data <= max:
            sum = sum + _get_range_sum(root.right, min, max, sum)
            
    return sum        
        
"""  
Question: Find the next permutation
Given a number, you can rearrange the digits of that number to make a bigger number. Among all such permutations that are greater, one of them is the smallest, find that one.
Examples:
next_permutation(12) = 21
next_permutation(12389) = 12398
next_permutation(3472-2641) = 3472-4126



144 = 414

999999999 


digit_check = hashmap 


while(true)
  input = input + 1
   if digit_check(input) 
     return input
"""

def next_permutation(number: int) -> next_perm:int:
    
    permutations = _get_permutation_list(number)
    
    closest_perm = -1
    diff = int.max
    
    for permutation in permutations:
        if ( permutation - number) > 0 and (permutation - number) < diff:
            diff = permutation - number
            closest_perm = permutation.
        
    
def _get_permutation_list    

        
