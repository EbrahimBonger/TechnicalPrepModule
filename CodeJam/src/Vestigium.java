import java.util.*;
import java.io.*;

public class Vestigium{
    public static void main(String[] args){
        int[][] validVestigium = {
                {1, 4, 7, 12, 15},
                {2, 5, 19, 31, 32},
                {3, 8, 24, 33, 35},
                {40, 41, 42, 44, 45},
                {99, 100, 103, 119, 128},
        };

        int[][] invalidVestigium = {
                {1, 4, 7, 12, 15},
                {2, 5, 24, 31, 32},
                {3, 8, 24, 33, 35},
                {40, 41, 42, 42, 45},
                {99, 100, 103, 42, 128},
        };
        // test checkVestigium method
        checkVestigium(validVestigium);
        System.out.println();
        checkVestigium(invalidVestigium);
    }

    public static void checkVestigium(int[][] matrix){
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
        System.out.print("Diagonal sum: " + sum + " repeated row: " + repeatRow + " and repeated col: " + repeatCol);
    }

}