# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        
        if left == right:
           return head
        
        left_ptr = head
        prev_left = None
        
        if left > 1:
            for _ in range(1, left):
                prev_left = left_ptr
                left_ptr = left_ptr.next

                if left_ptr == None:
                    return head
         
           
        #This is the place to add while reversing
        static_new_last = add_point = left_ptr  
        
        # iterate to the next node in the list
        curr = left_ptr.next       
        
        for _ in range(left, right): 
            
            # marking the node after the curr node in old list
            next_ptr = curr.next
            
            # actual reversal here, attach the curr node to the front of the reversed list
            curr.next = add_point
            add_point = curr   
            
            #continue to traverse
            curr = next_ptr            
            
        
        # reversal is done, now the start of the new list needs to be attached to end of left - 1 
        if prev_left:
            prev_left.next = add_point
         
        # and end of new list needs to be attached to right + 1
        static_new_last.next = curr

        if left == 1:
            return add_point
        else:
            return head 
