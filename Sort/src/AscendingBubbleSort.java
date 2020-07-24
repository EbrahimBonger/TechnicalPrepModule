import java.lang.reflect.Array;
import java.util.*;
/**
 * Space: O(1)
 * Time: O(n^2) worst case scenario / O(n) if the array is already sorted
 * **/
public class AscendingBubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 9, 5, 6, 3};
        bubbleSort(arr);
        for(int a: arr){
            System.out.print(a + " ");
        }
    }

    public static int[] bubbleSort(int[] array){
        int currLength = array.length-1;
        while (currLength > 0){
            for(int i=0; i<currLength; i++){
                if(array[i] > array[i+1]){
                    swap(array, i, i+1);

                }
            }
            currLength--;
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
