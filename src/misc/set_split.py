# Question: https://www.evernote.com/l/AsC9X6UlAW9PJqz5UTi8H_d-yU99wQnXAbU
  
#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'subsetA' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts INTEGER_ARRAY arr as parameter.
#
"""
[3, 7, 5, 5]

[5, 7] = A
[3, 5] =B

Union = [3, 5, 7]
intersection [5]

"""

 

def subsetA(arr):
    # Write your code here
    if not arr:
        return arr

    sorted_arr = sorted(arr)
    output = []
    output_sum = 0
    original_sum = sum(sorted_arr)
    
    while len(sorted_arr) > 0:
        last_elem = sorted_arr[-1]
        output.insert(0, last_elem)
        sorted_arr = sorted_arr[0: -1]
        
        output_sum += last_elem
        original_sum -= last_elem
        
        if output_sum > original_sum:
           break
        
    return output       
  

print(subsetA([3, 7, 5, 6, 2]))   
print(subsetA([3]))
print(subsetA([9, 2, 30, 4, 51, 6, 7, 8]))

"""
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr_count = int(input().strip())

    arr = []

    for _ in range(arr_count):
        arr_item = int(input().strip())
        arr.append(arr_item)

    result = subsetA(arr)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
 """  
  
