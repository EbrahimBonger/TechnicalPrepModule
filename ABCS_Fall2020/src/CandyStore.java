import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class CandyStore {

    // Complete the solve function below.
    public static int solve(int n, int k) {

        int x = matrixMaker(n, k);
        return x;
    }

    public static int matrixMaker(int n, int k){
        int[][] Matrix = new int[n][k];
        Arrays.fill(Matrix[0],1);
        for(int i=0; i<n; i++){
            Matrix[i][0] = i+1;
            System.out.println("..: " + Matrix[i][0] + " : " + Matrix[0][1]);
        }


        for(int row=1; row<n; row++){
            for(int col=1; col<k; col++){
                Matrix[row][col] = Matrix[row-1][col] + Matrix[row][col-1];
            }
        }

        return Matrix[n-1][k-1];

    }



    public static void main(String[] args) throws IOException {
        int x = solve(2,3);
        System.out.println("Result: " + x);
    }
}
