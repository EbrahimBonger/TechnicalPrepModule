

import java.util.*;

class ShiftedBinarySearch {
    /**
     * Reference: https://www.algoexpert.io/questions/Shifted%20Binary%20Search
     * **/

    public static void main(String[] args){
        int[] array = {61, 71, 72, 73, 0, 1, 21, 33, 45, 45};
        int target = 33;
        int idx = shiftedBinarySearch(array, target);
        System.out.println("The targeted value: " + target + " is located at Idx: " + idx);
    }

    public static int shiftedBinarySearch(int[] array, int target) {
        // Write your code here.
        int[] shiftedIdx = returnShiftedIdx(array, target);
        int start = shiftedIdx[0];
        int end = shiftedIdx[1];
        int searchResult = binarySearch(array, start, end, target);
        return searchResult;
    }
    public static int binarySearch(int[] array,int start, int end, int target) {
        // Write your code here.
        return returnTargetIdx(array, start, end, target);
    }
    public static int returnTargetIdx(int[] arr, int start, int end, int target){
        if(start > end){return -1;}
        int mid = (start+end)/2;
        if(arr[mid] == target){
            return mid;
        }
        else if(target > arr[mid]){
            //explore the right side
            return returnTargetIdx(arr, mid+1, end, target);
        } else {
            return returnTargetIdx(arr, start, mid-1, target);
        }
    }
    public static int[] returnShiftedIdx(int[] array, int target){
        int n = array.length;
        for(int i=1; i<n; i++){
            if(array[i-1] > array[i]){
                if(array[0] <= target && array[i-1] >= target){
                    // explore left half
                    return new int[] {0, i-1};
                }else if(array[i] <= target && array[n-1] >= target){
                    // explore right half
                    return new int[] {i, n-1};

                }

            } else if(array[(n-1)-i] < array[n-i]){
                if(array[n-1] >= target && array[(n-1)-i] <= target){
                    // explore right half
                    return new int[] {(n-1)-i, n-1};
                }else if(array[0] <= target && array[(n-2)-i] >= target){
                    // explore left half
                    return new int[] {0, (n-2)-i};

                }

            }
        }
        // explore the whole array
        return new int[] {0, array.length-1};
    }

}
