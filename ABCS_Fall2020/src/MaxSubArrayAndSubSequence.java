import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxSubArrayAndSubSequence {

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {
        int[] result = new int[2];
        int maxSubSeq = -1;
        int maxSubArr = -1;




        result[0] = maxSubArr(arr, maxSubArr) > 0?maxSubArr(arr, maxSubArr): maxSubArr;
        result[1] = maxSubSeq(arr, maxSubSeq) > 0?maxSubSeq(arr, maxSubSeq): maxSubSeq;
        System.out.println(maxSubArr + " " + maxSubSeq);
        return result;
    }
    private static int maxSubSeq(int[] arr, int value){
        for(int a: arr){
            if(a > 0){
                value = value < 0? 0: value;
                value+=a;
            }
        }
        return value;
    }

    private static int maxSubArr(int[] arr, int soFarMax){
        soFarMax = 0;
        int runningSum = 0;
        for(int a: arr){
            runningSum+=a;
            int runMax = Math.max(a, runningSum);
            soFarMax = Math.max(runMax, soFarMax);
        }
        return soFarMax;
    }


    public static void main(String[] args) {

    }
}
