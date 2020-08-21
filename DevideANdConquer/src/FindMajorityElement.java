import java.util.Arrays;
import java.util.HashMap;

public class  FindMajorityElement {
    /**
     * Reference: https://leetcode.com/problems/majority-element/submissions/
    **/
    public static void main(String[] args){
        int[] A = {7, 2, 7, 5,5, 6, 8, 3, 7, 4, 5, 9};
        int[] B = {7, 3, 2, 7, 7, 5, 8, 7, 7};

        System.out.println("\nIn brute force approach");
        // Time: O(n) Space: O(n)
        bruteForceApproach(A);
        bruteForceApproach(B);

        System.out.println("\nIn optimized approach");
        // Time: O(1); because it does not traverse through the array
        // Space: O(log(N)) if the library that imported used binary or merge sort
        divideAndConquerApproach(A);
        divideAndConquerApproach(B);

    }

    public static void divideAndConquerApproach(int[] nums) {
            int n = nums.length;
            int m = n/2;
            int mid;
            if(n%2 == 0){
                mid = m-1;
            } else{mid = m;}

            if(n==1) {
                System.out.println("The majority element is: " + nums[0]);
                return;
            }
            Arrays.sort(nums);

            // explore left side
            if(nums[0] == nums[mid]){
                System.out.println("The majority element is: " + nums[mid]);
                // explore right side
            } else if(nums[m] == nums[mid+(mid/2)]){
                System.out.println("The majority element is: " + nums[mid+1]);
                return;
            } else {
                System.out.println("The majority element does not exist!");
                return;
            }
        }

    public static void bruteForceApproach(int[] A){
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
         for(int a : A){
             if(map.containsKey(a)){
                 map.put(a, map.get(a) + 1);
                 if(map.get(a) > (n/2)){
                     System.out.println("The majority element is: " + a);
                     return;
                 }
             } else{
                 map.put(a, 1);
             }
         }
        System.out.println("The majority element does not exist!");
    }

    }

