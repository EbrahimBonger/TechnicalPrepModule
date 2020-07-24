public class QuickSortRecursively {
/**
 * Time: Worst: O(N^2)
 *      Best: O(NLog(N))
 *      Average: O(NLog(N)) see Wikipedia for more explanation
 * Space: O(log(N))
 * **/
    public static void main(String[] args){
        int[] arr = {8, 5, 2, 9, 5, 6, 3};
        quickSort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] array, int start, int end){
        if(start >= end){return;}
        /**
         * pivotIndex: indicates where the left and right side of the array has to be partitioned.
         * Even though the whole array might not be sorted yet, but if sorted the array respected
         * to the value at the index pivotIndex.
         * As this process repeated, ultimately the the array will be fully sorted.
         * **/
        int pivotIndex = partition(array, start, end);

        quickSort(array, start, pivotIndex-1);
        quickSort(array, pivotIndex+1, end);

    }

    public static int partition(int[] array, int start, int end){
        /**
         * pivotIndex is the the index of the start of the current sub-array
         * **/
        int pivotIndex = start;
        /**
         * pivotValue is the the last value of current sub-array
         * **/
        int pivotValue = array[end];
        /**
         * Iterate through the array and compare every
         * current index against the pivot value
         * **/
        for(int i=start; i<end; i++){
            /**
             * Whenever the value index at 'i' is less than the pivot value,
             * swap the element index at pivotIndex
             * with the element at index 'i' and increment the pivotIndex
             * **/
            if(array[i] < pivotValue){
                /**
                 * Pay attention what's happening here!
                 * **/
                swap(array,i, pivotIndex);
                pivotIndex++;
            }
        }
        /**
         * Finally, Swap the pivotValue that was used to compare the element against
         * with the value at the index pivotIndex
         * **/
        swap(array, pivotIndex, end);
        return pivotIndex;
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

