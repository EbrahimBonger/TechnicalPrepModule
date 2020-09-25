
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class MaxSubArrayMaxSuSequenceCombined {

    // Complete the maxSubarray function below.



    private static int recursiveMaxSubSeq(int[] arr, int left, int right){
        int mid = (left + right)/2;
        if(right <= left){
            //System.out.println("Max Left: " + left + " " + mid );
            return Math.max( arr[left], arr[right]);
        }

        else{
            int l = recursiveMaxSubSeq(arr, left, mid);

            int r = recursiveMaxSubSeq(arr, mid+1, right);

            //System.out.println(" l r: " + l + " : " + r );

            return Math.max(Math.max(l, r), l+r);

        }

    }

    private static int maxSubArr(int[] arr, int soFarMax){
        // 1 -2
        soFarMax = 0;
        int runningSum = 0;
        if(arr[0] < 0){arr[0] = 0;}
        for(int a: arr){
            runningSum+=a;
            int runMax = Math.max(a, runningSum);
            soFarMax = Math.max(runMax, soFarMax);

        }
        System.out.println("soFarMax: " +soFarMax);
        return soFarMax;
    }
    private static int recursiveMaxSubArray(int[] arr, int n){
        int mid = n/2;
        if(n == 1){
            //System.out.println("Max Left: " + left + " " + mid );
            return arr[0];
        }


        int l = recursiveMaxSubArray(arr, mid);

        int r = recursiveMaxSubArray(arr,(n-mid) );

        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;

        //System.out.println(" l r: " + l + " : " + r );
        for(int i=mid; i<n; i++){
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }
        sum = 0;
        for(int i=(mid-1); i>=0; i--){
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }
        int ans = Math.max(l, r);
        return Math.max(ans, leftSum+rightSum);



    }
    public static int kadansApproach(int[] nums){
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
        //System.out.println("The sum of Max sub array is in Kadans approach: " + Max_So_Far + " stating at idx: " + start + " and ending at idx: " + end);
        return Max_So_Far;
    }



    private static int maxIncreasingSubSeq(int[] A){
        int n = A.length;
        int[] idx = new int[n];

        int maxSum = idx[0];
        maxSum = Math.max(A[0], maxSum);
        for(int i=1; i<n; i++){
            int j=0;
            if(A[i] > idx[j]){
            while(idx[j] > 0){
                idx[j+1] = A[i] + maxSum;
                j++;
            }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] t = {8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        //int[] t = {-10};
        //maxSubarray(t);
        int x = recursiveMaxSubSeq(t, 0, t.length-1);
        //int y = recursiveMaxSubArray(t, t.length-1);
        int z = kadansApproach(t);
        System.out.println("SubSeq: " + x + " SubArray: " + z);

    }
}
