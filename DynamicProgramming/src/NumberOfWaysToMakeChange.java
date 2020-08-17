import java.util.*;

class NumberOfWaysToMakeChange {
    /**
     * Reference: https://www.algoexpert.io/questions/Number%20Of%20Ways%20To%20Make%20Change
     * **/
    public static void main(String[] args){
        int[] denoms = {1, 5, 10, 25};
        int targetAmount = 10;
        numberOfWaysToMakeChange(targetAmount, denoms);
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        if(n==0){return 1;}
        // create array the size of target number n inclusive(n+1)
        int[] ways = new int[n+1];

        /** initialize the first idx of ways always 1,
         * because there always one way to make change,
         * which is not to make any change**/
        ways[0] = 1;

        /**
         * Iterate through each denominator for n amount of times in a nested loop
         * The formula in the inner loop will calculate the number of ways for a given
         * target and denoms values and store the maximum number of ways at the index n (targeted value)
         * and return the value stored at index n at the end of the iteration
         * **/
        for(int denom : denoms){
            for(int amount=1; amount<=n; amount++){
                if(denom <= amount){
                    ways[amount] += ways[amount - denom];
                }
            }
        }
        System.out.println("The number of ways to make change is: " + ways[n]);
        return ways[n];
    }
}
