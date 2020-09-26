import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GreedyCandyDistribution {

    // Complete the candies function below.
    static long candies(int n, int[] arr)
    {
        int[] candies = new int[arr.length];

        candies[0] = 1;
        for(int i=1; i<arr.length; i++)
            if(arr[i-1] < arr[i])
                candies[i] = candies[i-1] + 1;
            else
                candies[i] = 1;


        long sumCandies = candies[arr.length-1];
        for(int i=arr.length-2; i>=0; i--)
        {
            if(arr[i] > arr[i+1])
                candies[i] = Math.max(candies[i+1] + 1, candies[i]);
            sumCandies += candies[i];
        }

        return sumCandies;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        // 2,4,2,6,1,7,8,9,2,1
        long x = candies(arr.length, arr);
        System.out.println("Total: " + x);
    }
}
