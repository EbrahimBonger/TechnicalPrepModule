class MaxSumSubArray {
    /** Reference: https://www.youtube.com/watch?v=86CQq3pKSUw
     *             https://www.youtube.com/watch?v=hPWJNoaI7t8
     *             https://leetcode.com/problems/maximum-subarray/submissions/
    **/

    public static void main(String[] args){
        //int[] array = {-1,3,4,-5,9,-2};
        //int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        int[] array = {-2,-3,-1};
        //int [] array = {-2,1};
        kadansApproach(array);
        int n = array.length;
        int mid = n/2;
        int leftMaxSub = divideAndConcurApproach(array, array[mid-1], Integer.MIN_VALUE, mid-1, 0);
        System.out.println("Left Max-Sub array is: " + leftMaxSub);
        int rightMaxSub = divideAndConcurApproach(array, array[mid], Integer.MIN_VALUE, mid, n-1);
        System.out.println("Right Max-Sub array is: " + rightMaxSub);

        computeThreeValues(leftMaxSub, rightMaxSub);

    }
    // Time: O(n)
    public static void kadansApproach(int[] nums){
        int start = 0;
        int end = 0;
        int search = 0;
        int Max_So_Far = nums[0];
        int Max_End_Here = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            Max_End_Here+= nums[i];
            if(Max_So_Far < Max_End_Here){
                Max_So_Far = Max_End_Here;
                start = search;
                end = i;
            }
            if(Max_End_Here < 0){
                Max_End_Here = 0;
                // new search pointer reset at position next current i
                search = i+1;
            }
        }
        System.out.println("The sum of Max sub array is in Kadans approach: " + Max_So_Far + " stating at idx: " + start + " and ending at idx: " + end);
    }

    // The are some edge cases left to be handheld Time: O(logN)
    public static int divideAndConcurApproach(int[] arr, int runningSum , int maxSub, int start, int end){
        int mid = arr.length/2;
        // -2,1,-3,4,-1,2,1,-5,4 :failed
        // -1,3,4,-5,9,-2   :failed
        // -2,-3,-1 :failed
        // -2 1 :failed

        if(runningSum<0){
            //maxSub = arr[start];
            //runningSum =0;
            runningSum  = arr[start] >= 0 ? arr[start] : 0;
            //runningSum+=arr[start];
        }
        maxSub  = Integer.MIN_VALUE == maxSub ? arr[start] : maxSub;
        if(start==end){
            //maxSub  = Integer.MIN_VALUE == maxSub ? arr[start] : maxSub;
            return maxSub;
        }

        if(start<mid){
            start = start-1;
        }else {start = start+1;}

        runningSum+=arr[start];
        maxSub = Math.max(runningSum, maxSub);


        return divideAndConcurApproach(arr, runningSum, maxSub, start, end);
    }

    public static void computeThreeValues(int leftMaxSub, int rightMaxSub){
        int leftOrRightMax = Math.max(leftMaxSub, rightMaxSub);
        int totalMaxSum = Math.max(leftOrRightMax, leftMaxSub + rightMaxSub);
        System.out.println("Total Max-Sub array is in divide and Concur approach: " + totalMaxSum);
    }
}