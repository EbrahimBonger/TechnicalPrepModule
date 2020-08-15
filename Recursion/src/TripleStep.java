import java.util.HashMap;

public class TripleStep {
    /**
     * Book: Cracking the coding interview 6th edition
     *
     * Problem: A child is running up a staircase with n steps and
     * can hop either 1 step, 2 step, and 3 steps at a time.
     *
     * Question: Implement a method to count how many possible
     * ways the child can run up the stairs.
     *
     * Hints: Page 662
     * #152: Approach this from the Top-Down.
     *       What is the very last hop the child made?
     * #178: If we knew the number of paths to each of the steps before step 100,
     *       could we compute the number of steps to 100
     * #217: We can compute the number of steps to 100 by the number of steps to 99, 98, and 97.
     *       this corresponds to the child hopping 1, 2, or 3 steps at the end.
     *       Do we add those or multiply them?
     *       That is: f(100) = f(99) + f(98) + f(97) or f(100) = f(99) * f(98) * f(97)
     * #262: What is the runtime of this, can you optimize it?
     * #359: Try memoization as a way to optimize an insufficient recursive algorithm.
     *
     * Solution: page#343
     *
     * Input: n = 1
     * Output: 1
     * There is only one way to climb 1 stair
     *
     * Input: n = 2
     * Output: 2
     * There are two ways: (1, 1) and (2)
     *
     * Input: n = 4
     * Output: 5
     * (1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2)
     * Reference: https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
     *            https://www.youtube.com/watch?v=Hr8HDhhSvZc
     *            https://www.youtube.com/watch?v=UxICsjrdlJA
     * Remark: The solution to this problem is similar to the Fibonacci series if the Max number of steps the
     *         child can hop is 2.
     *         Formula: f(n) = f(n-1) + f(n-2).
     *         If the Max number of steps the child can hop is 3, the modification will be
     *         Formula: f(n) = f(n-1) + f(n-2) + f(n-3) , and so on as the Max number is increased.
     * **/

    // Create a global cache to perform cache through Memoization

    public static void main(String[] args){
        int stairs = 5;
        int result = findWays(stairs);
        System.out.println("Ways of steps: " + result);
    }
    
    public static int findWays(int stairs){
        int cacheValue;
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        if (stairs < 0) {
            return 0;
        } else if(stairs == 0){
            return 1;
        }

        if(cache.containsKey(stairs)){
            // if the the stair value being already added, return the value
            cacheValue = cache.get(stairs);

        } else {
            // otherwise, calculate the value
            cacheValue = findWays(stairs-1) + findWays(stairs-2) + findWays(stairs-3);
            // then store to the map for o(1) time use
            cache.put(stairs, cacheValue);
        }
        return cacheValue;
    }
}
