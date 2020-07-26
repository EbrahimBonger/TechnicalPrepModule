import java.util.List;

public class HeapSort {

    /**
     * Step 1: Build a max heap on the current array
     * step 2: Swap the current maxvalue at index 0 with the current last index
     * **/
    public static void main(String[] args){
        int[] arr = {8, 5, 2, 9, 5, 6, 3};
        heapSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void heapSort(int[] array){
        int n = array.length-1;
        for(int i=n; i>=0; i--){
            buildHeap(array, i);
            swap(array, 0, i);
        }
    }

    public static int[] buildHeap(int[] array, int currEndIdx) {
        // Write your code here.
        int n = currEndIdx;
        // Calculate the last parent, left and right node
        int currentParent = (n-1)/2;
        for(int i=currentParent; i>=0; i--){
            siftDown(i, currEndIdx, array);
        }

        return array;
    }

    public static void siftDown(int currParentIdx, int endIdx, int[] heap) {
        // Write your code here.
        int left = (currParentIdx*2)+1;
        while(left<= endIdx){
            int right = currParentIdx * 2 + 2 <= endIdx ?(currParentIdx *2)+2: -1;
            // endIdx helps to control the boundary in the array

            int largest;
            //  first compare left and right child
            if(right != -1 && heap[right] > heap[left]){
                largest = right;
            } else{
                largest = left;
            }

            if(heap[largest] > heap[currParentIdx]){
                swap(heap, largest, currParentIdx);
                // the index where the smallest value founded will be the next value to determine in while loop
                currParentIdx = largest;
                left = currParentIdx * 2+1;
            } else {
                // the current parent is the smallest compare ot its left and/or right child
                return;
            }
        }



    }


    public static void swap(int[] array, int a, int b){
        // the arguments are passed by reference not by value
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
