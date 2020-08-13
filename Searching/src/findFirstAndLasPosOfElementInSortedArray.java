
class findFirstAndLasPosOfElementInSortedArray {
    /**
     * Reference: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
     *            https://www.youtube.com/watch?v=bU-q1OJ0KWw&t=321s
     *
     * **/
    public static void main(String[] args){
        int[] targetFound = {0, 1, 21, 33, 33, 45, 45, 61, 71, 72, 73};
        int[] targetNotFound = {0, 1, 21, 22, 40, 45, 45, 61, 71, 72, 73};
        int target = 33;
        //test searchRange method
        searchRange(targetFound, target);
        searchRange(targetNotFound, target);

    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStartIndex(nums, target);
        result[1] = findEndIndex(nums, target);
        System.out.println("Range: ( " + result[0] + " , " + result[1] + " )");
        return result;
    }

    public static int findStartIndex(int[] arr, int target){
        int idx = -1;
        int start = 0;
        int end = arr.length-1;
        // the loop will break at the start of the target position
        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid] >= target){
                end = mid-1;
            } else{
                start = mid+1;
            }
            // update the position of the targeted value
            if(arr[mid] == target){idx = mid;}
        }
        return idx;
    }

    public static int findEndIndex(int[] arr, int target){
        int idx = -1;
        int start = 0;
        int end = arr.length-1;
        // the loop will break at the end of the target position
        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid] <= target){
                start = mid+1;
            } else{
                end = mid-1;
            }
            // update the position of the targeted value
            if(arr[mid] == target){idx = mid;}
        }
        return idx;
    }
}