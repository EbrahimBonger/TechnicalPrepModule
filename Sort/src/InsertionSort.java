import java.lang.reflect.Array;
import java.util.*;
/**
 * Space O(1)/ Time O(N^2)
 * Reference: https://www.geeksforgeeks.org/insertion-sort/
 * **/
public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {8, 5, 2, 9, 5, 6, 3};
        insert(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] insert(int[] array){
        int n = array.length;
        for(int i=1; i<n; i++){
            int ptr = i;
            // ptr>0 must be checked first,
            // otherwise it will through  ArrayIndexOutOfBoundsException error
            while (ptr>0 && array[ptr] < array[ptr-1]){
                swap(array, ptr, ptr-1);
                ptr--;
            }
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
