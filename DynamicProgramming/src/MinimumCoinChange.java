
import java.util.*;
/**
 * Reference: https://www.youtube.com/watch?v=Y0ZqKpToTic
 *            https://www.algoexpert.io/questions/Min%20Number%20Of%20Coins%20For%20Change
 * **/
class MinimumCoinChange {
    public static void main(String[] args){
        int[] array = {1,5,6,8};
        int target = 11;
        int minCoins = minNumberOfCoinsForChange(target, array);
        System.out.println("Min coin: " + minCoins);
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int[] numOfCoins = new int[n+1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);
        numOfCoins[0] = 0;
        int toCompare = 0;
        for(int denom : denoms){

            for(int amount=0; amount<numOfCoins.length; amount++){
                if(denom <= amount){
                    // this statement check if that particular amount has not been added any value

                    if(numOfCoins[amount-denom] == Integer.MAX_VALUE){
                        // then do not consider the extra +1 for later calculation since we were not updated yet
                        toCompare = numOfCoins[amount-denom];
                    }else{
                        toCompare = numOfCoins[amount-denom] + 1;
                    }

                    numOfCoins[amount] = Math.min(numOfCoins[amount], toCompare);
                }
            }
        }
        return numOfCoins[n] != Integer.MAX_VALUE ? numOfCoins[n] : -1;
    }
}
