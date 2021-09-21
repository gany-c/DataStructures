"""
# You are climbing a staircase. It takes n steps to reach the top.

# Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

# Example 1:

# Input: n = 2
# Output: 2
# Explanation: There are two ways to climb to the top.
# 1. 1 step + 1 step
# 2. 2 steps

# Example 2:

# Input: n = 3
# Output: 3
# Explanation: There are three ways to climb to the top.
# 1. 1 step + 1 step + 1 step
# 2. 1 step + 2 steps
# 3. 2 steps + 1 step

sol(4) = sol(3) + sol(2)

4 = 

1, 1, 1, 1 -1 
2, 1, 1, - 3
2, 2  - 1

What is the time complexity with and without memoization? You said exponention 2^n and linear - may be polynomial
"""
def get_number_distinct_ways(num_steps: int) -> int:
    print("invoked")
    if num_steps <= 0:
        return 0 
    elif num_steps == 1:
        return 1        
    elif num_steps == 2:
        return 2
    else:
        return get_number_distinct_ways(get_number_distinct_ways(num_steps-1)) + get_number_distinct_ways(get_number_distinct_ways(num_steps-2))
        
print(get_number_distinct_ways(5))      
