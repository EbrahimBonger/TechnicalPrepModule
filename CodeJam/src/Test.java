import java.util.*;
import java.io.*;

public class Test{
    public static void main(String[] args){
        char e = '[';
        char f = '[';
        String s = "";
        System.out.print(s.length());

        if(e == f){
            System.out.print(true);
        }else{
            System.out.print(false);
        }

        try(Scanner in = new Scanner(System.in)){
            int cases = in.nextInt();
            int n = in.nextInt();
            int sum = 0;
            for(int t=0; t<cases; t++){

                int[][] matrix = new int[n][n];
                int count=1;
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        matrix[i][j] = count++;
                        System.out.print(matrix[i][j] + " : ");
                        if(i==j){sum+=matrix[i][j];}
                    }
                    System.out.println();
                }
                int k=0;
                int r = 0;
                int c = 0;
                checkVestigium(matrix, k, r, c);

                //System.out.print("k: " + k + " r: " + r + " c: " + c);
                //System.out.println();
            }

        }
    }

    public static void checkVestigium(int[][] matrix, int k, int r, int c){
        int n = matrix.length;
        int repeatRow = 0;
        int repeatCol = 0;
        int sum  = 0;


        HashMap<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> colMap = new HashMap<Integer, Integer>();

        for(int i=0; i<n; i++){
            boolean hasRowCheked = false;
            boolean hasColCheked = false;
            for(int j=0; j<n; j++ ){
                // check if the row has a repeated value
                if(i == j){
                    sum+= matrix[i][j];
                }
                if(rowMap.containsKey(matrix[i][j]) && hasRowCheked == false){
                    repeatRow++;
                    rowMap.clear();
                    hasRowCheked = true;
                } else{
                    rowMap.put(matrix[i][j], 1);
                }
                // check if the column has a repeated value
                if(colMap.containsKey(matrix[j][i]) && hasColCheked == false){
                    repeatCol++;
                    colMap.clear();
                    hasColCheked = true;
                }else{
                    colMap.put(matrix[j][i], 1);
                }
            }
            rowMap.clear();
            colMap.clear();
        }
        k = sum;
        r = repeatRow;
        c = repeatCol;
        System.out.print("k: " + sum + " r: " + repeatRow + " c: " + repeatCol);
        System.out.println();
    }

}