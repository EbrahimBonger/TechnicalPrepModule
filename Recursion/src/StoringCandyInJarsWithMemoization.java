import java.util.HashMap;

class StoringCandyInJarsWithMemoization {

    /*
     * Complete the 'findNumJars' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER count
     *  2. INTEGER capacity
     */

    public static int findNumJars(int count, int capacity) {
        // Write your code here
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        int x = count/2;
        int y = count%2 == 0? x:x+1;

        if(capacity >= count){
            return 1;
        }
        if(memo.containsKey(count)){
            return memo.get(count);
        }else{
            int z = findNumJars(x, capacity) + findNumJars(y, capacity);
            memo.put(count, z);
            return z;

        }




    }




    public static void main(String[] args) {
        int jarCapacity = 2;
        int numOfCandy = 10;
        int result = findNumJars(numOfCandy, jarCapacity);
        System.out.println("Result: " + result);
    }
}
