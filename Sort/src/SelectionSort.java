import java.lang.reflect.Array;
import java.util.*;
/**
 * Space O(1)/ Time O(N^2)
 * **/
public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {8, 5, 2, 9, 5, 6, 3};
        selection(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] selection(int[] array){
        int n = array.length;

        for(int i=0; i<n; i++){
            int ptr = i;
            int smallestIdx = i; // points to the smallest value in the unsorted array per iteration
            while(ptr < n){
                if(array[smallestIdx] > array[ptr]){
                    smallestIdx = ptr;
                }
                ptr++;
            }
            swap(array, i, smallestIdx);
        }
        return array;
    }

    public static void swap(int[] array, int a, int b){
        // the arguments are passed by reference not by value
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
