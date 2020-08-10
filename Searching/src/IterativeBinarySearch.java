import java.util.*;

class IterativeBinarySearch {
    /**
     * Reference: https://www.youtube.com/watch?v=j5uXyPJ0Pew
     *            https://www.youtube.com/watch?v=atTOlifFGrg
     *            https://www.algoexpert.io/questions/Binary%20Search
     * **/
    public static void main(String[] args){
        int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 33;
        int idx = binarySearch(array, target);
        System.out.println("Idx: " + idx);
    }
    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        return returnTargetIdx(array, 0, array.length-1, target);
    }
    public static int returnTargetIdx(int[] arr, int start, int end, int target){
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==target) {return mid;}
            else if(arr[mid]> target){
                end = mid-1;
            }else if(arr[mid]<target){
                start = mid+1;
            }

        }


        return -1;

    }

}
