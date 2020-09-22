import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    // reference: https://www.youtube.com/watch?v=pVS3yhlzrlQ
    //  https://www.youtube.com/watch?v=hDhf04AJIRs
    static long arrayManipulation(int n, int[][] queries) {
        long[] T = new long[n+2];

        for(int i =0; i<queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            T[a] += k;
            T[b+1] -= k;
        }
        long max = getMax(T);
        return max;
    }

    private static long getMax(long[] T){
        long max = Integer.MIN_VALUE;
        for(int i=1; i<T.length; i++){
            T[i] = T[i] + T[i-1];
            max = Math.max(max, T[i]);
        }
        return max;
    }



    public static void main(String[] args)  {

        ArrayManipulation ds = new ArrayManipulation();
        int[][] queries = new int[3][3];
        queries[0][0] = 1;
        queries[0][1] = 2;
        queries[0][2] = 100;

        queries[1][0] = 2;
        queries[1][1] = 5;
        queries[1][2] = 100;

        queries[2][0] = 3;
        queries[2][1] = 4;
        queries[2][2] = 100;




        long x = arrayManipulation(10, queries);
        System.out.println("max: " + x);


    }
}
