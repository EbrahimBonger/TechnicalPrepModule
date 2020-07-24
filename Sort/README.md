Bubble sort: Swap every next node that is less than (for ascending sort) or greater than (for descending sort) to the previous one starting index 0 at each iteration. On every successful iteration, the desired value will push to the rightest end unless it was already at the right most end.

Insertion sort: is a simple sorting algorithm that works the way we sort playing cards in our hands. 


Selection sort: The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two sub-array in a given array.
                
    1) The subarray which is already sorted.
    2) Remaining subarray which is unsorted.
                
In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted sub-array.

Quick sort: Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.
            
    Always pick first element as pivot.
    Always pick last element as pivot (implemented below)
    Pick a random element as pivot.
    Pick median as pivot.
    The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x. All this should be done in linear time. 