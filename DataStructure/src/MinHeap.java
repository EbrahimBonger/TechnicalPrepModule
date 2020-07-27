import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class MinHeap {
    /**
     * Reference: https://www.youtube.com/watch?v=t0Cq6tVNRBA&list=PL2veGun5Zfn3WRwsmc7RD1DpCI-ip7jRX
     *            https://www.youtube.com/watch?v=2fA1FdxNqiE
     *            https://www.youtube.com/watch?v=HI97KDV23Ig
     *
     * Complexity: https://www.youtube.com/watch?v=HI97KDV23Ig&t=618s
     * Time: O(n)
     * Space: O(logN)
     *
     * Attention!
     * Array[(i-1/2)] return parent node in the current sub-tree
     * Array[(2*i)+1] return left child node in the current sub-tree
     * Array[(2*i)+2] return right child node in the current sub-tree
     * The above mathematical proof works only for the array in which
     * the elements are stored starting from index 0
     * Find the leaf nodes interval in the tree is: from (n/2) to n
     * Finding the leaf nodes interval allows to Heapify the tree when the root node violate the max Heap data structure
     * Find the non-leaf node interval in the tree is: from 0 to (n/2)-1
     * Finding the non-leaf nodes interval allows to build a heap data structure from the scratch using un-heapify array
     * **/
    public static void main(String[] args){

        int[] arr = {48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41};
        /**
         * Convert int[] array to ArrayList
         * **/
        List<Integer> minHeap = Arrays.stream(arr).boxed().collect(Collectors.toList());



        System.out.print("Before:");
        for(Integer e: minHeap){
            System.out.print(e + " ");
        }

        /**
         * Test the methods here
         * **/
        BuildMinHeap(minHeap);
        insert(minHeap, 76);
        System.out.println("top: " + peak(minHeap));
        remove(minHeap);
        System.out.println("top: " + peak(minHeap));
        remove(minHeap);
        System.out.println("top: " + peak(minHeap));
        insert(minHeap, 87);

        System.out.print("After:");
        for(Integer e: minHeap){
            System.out.print(e + " ");
        }

    }

    public static List<Integer> BuildMinHeap(List<Integer> array){
        int heapSize = array.size();
        int numOfNonLeafNode = (heapSize/2)-1;
        //System.out.println("Size: " + numOfNonLeafNode);
        /**
         * The for loop has to run until 0 index to reach the root of the tree
         * **/
        for(int i=numOfNonLeafNode; i>=0; i--){
            siftDown(array, i);
        }
        return array;
    }

    /**
     * The parent node with left and/or right child pass as a parameter to
     * analyze weather the child node(s) is smaller than the parent, if so
     * it will re-arrange by swapping the values
     * **/
    public static void siftDown(List<Integer> array, int i){
        //System.out.println("lastIdx: " + i);
        int heapSize = array.size()-1;
        int left = (2*i) +1;
        int right = (2*i) +2;
        //System.out.println("Root: " + array.get(i) + " left: " + array.get(left) + " right: " + array.get(right));
        int smallest;
        /**
         * check weather the left child is larger than the parent
         * **/
        if(left <= heapSize && array.get(left) < array.get(i)){
            smallest = left;
        } else {smallest = i;}
        /**
         * check weather the right child is larger than the current smallest(parent or left child) node
         * **/
        if(right <= heapSize && array.get(right) < array.get(smallest)){
            smallest = right;
        }
        /**
         * Check weather the parent node at index i is the smallest
         * **/
        //System.out.println(smallest + " : " + i);
        if(smallest != i){
            /**
             * swap the
             * **/
            swap(array, smallest, i);
            /**
             * Attention!
             * Here the smallest parameter does not mean the index is where the smallest value located now,
             * instead, it indicates it is the index where the smallest value was stored before swapped,
             * now, it will recurse back determine weather it needs to be heapify or not
             * **/
            siftDown(array, smallest);
        }
    }

    /**
     * Step 1: swap the root node with the last node of the MinHeap
     * Step 2: remove the last index of the that currently has the value subjected to remove
     * Step 3: perform a sift-down operation until the current node satisfy the MinHeap property
     * **/
    public static void remove(List<Integer> array){
        /**
         * Check if the array is not empty
         * **/
        if(array.isEmpty() == false){
            int lastIdx = array.size()-1;
            /**
             * Take the root value and swap it with the value at the last index,
             * then
             * **/
            swap(array, 0, lastIdx);
            /**
             * Remove the value at the last index
             * **/
            array.remove(lastIdx);
        }
        /**
         * Then start sifting down from the root node until it satisfies the Heap property
         * **/
        siftDown(array, 0);
    }

    /**
     * Insert the value at the end of the list and use sift up method until the current value satisfies the Heap property
     * **/
    public static void insert(List<Integer> array, int value){
        /**
         * Step 1: add the coming value at the end (from left to right) of the Heap tree
         * Step 2: perform a sift-Up operation until the current node satisfy the MinHeap property
         * **/
        array.add(value);
        siftUp(array, array.size()-1);

    }

    /**
     * This method push the value that has been passed at the current index until it satisfies the Heap property
     * **/
    public static void siftUp(List<Integer> array, int currentIdx){
        /**
         * Calculate the parent's index respect to the current's index
         * **/
        int parent = (currentIdx -1)/2;
        while(currentIdx > 0 && array.get(currentIdx) < array.get(parent)){
            swap(array, currentIdx, parent);
            /**
             * Now, since the swapped node go up by one and placed to a position where it's parent was,
             * the previous parent position will become a new current index and
             * calculate the current index's parent from that position
             * **/
            currentIdx = parent;
            parent = (currentIdx-1)/2;
        }
    }

    /**
     * Return the top value if the list is not empty
     * **/
    public static int peak(List<Integer> array){
        int top = array.size()>0? array.get(0) : 0;
        return top;


    }

    public static void swap(List<Integer> array, int a, int b){
        Integer temp = array.get(a);
        array.set(a, array.get(b));
        array.set(b, temp);
    }
}
