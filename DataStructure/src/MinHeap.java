public class MinHeap {
    /**
     * Reference: https://www.youtube.com/watch?v=t0Cq6tVNRBA&list=PL2veGun5Zfn3WRwsmc7RD1DpCI-ip7jRX
     *            https://www.youtube.com/watch?v=2fA1FdxNqiE
     *            https://www.youtube.com/watch?v=HI97KDV23Ig
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
        //int[] arr = {1, 14, 10, 2, 4, 9, 3};
        int[] arr = {9, 6, 5, 0, 8, 2, 1, 3};
        System.out.print("Before:");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        MinHeapify(arr, 0);
        BuildMinHeap(arr);
        System.out.print("After:");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    /**
     * The parent node with left and/or right child pass as a parameter to
     * analyze weather the child node(s) is smaller than the parent, if so
     * it will re-arrange by swapping the values
     * **/
    public static void MinHeapify(int[] array, int i){

        int heapSize = array.length-1;
        int left = (2*i)+1;
        int right = (2*i) +2;
        int smallest;
        /**
         * check weather the left child is larger than the parent
         * **/
        if(left <= heapSize && array[left] < array[i]){
            smallest = left;
        } else {smallest = i;}
        /**
         * check weather the right child is larger than the current smallest(parent or left child) node
         * **/
        if(right <= heapSize && array[right] < array[smallest]){
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
            MinHeapify(array, smallest);
        }
    }

    public static int[] BuildMinHeap(int[] array){
        int heapSize = array.length;
        int numOfNonLeafNode = (heapSize/2)-1;
        /**
         * The for llop has to run until 0 index to reach the root of the tree
         * **/
        for(int i=numOfNonLeafNode; i>=0; i--){
            MinHeapify(array, i);
        }
        return array;
    }

    public static void swap(int[] array, int a, int b){
        /**
         * The arguments are passed by reference not by value
         **/
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
