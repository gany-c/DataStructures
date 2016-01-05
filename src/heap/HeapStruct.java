package heap;

/**
 * 
 * @author Ramanan
 * 
 * Heaps are implemented here
 * https://github.com/gany-c/Algos/blob/master/src/Assign6/MinHeap.java
 * https://github.com/gany-c/Algos/blob/master/src/Assign6/MaxHeap.java
 * 
 * A min-heap is a binary tree where the root always has a lower value than both children.
 * It is implemented using an array where the left and right child are at 2i+1 and 2i+2
 * 
 * EXTRACTION:
 * 
 * 1. return the topmost element
 * 2. decrement the index
 * 3. take bottom-most element and put it on top.
 * 4. correct the heap property downwards. - correctDown()
 * 
 * correctDown()
 * 1. check if the root has children, otherwise return
 * 2. if it has a left child alone, swap with the left child if root is smaller.
 * 3. if it has both children, find the smaller of the two and swap with it. make a recursive call
 * 
 * INSERTION:
 * 
 * 1. insert at the array's end;
 * 2. correct the heap upwards.
 * 3. update the array end pointer. - bubbleUp()
 * 
 *  bubbleUp()
 * 1. if you have reached the top, exit
 * 2. Otherwise get the index of the parent, based on the current index being even or odd
 * 3. Swap the parent and current if parent is larger than the current and continue recursively.
 */
public class HeapStruct {

}
