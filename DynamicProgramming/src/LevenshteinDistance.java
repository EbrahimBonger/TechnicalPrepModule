import java.util.*;

class LevenshteinDistance{
    
    public static void main(String[] args){
        int minimumEdit =  levenshteinDistance("abc", "yabd");
        System.out.println("Minimum number of edit operation: " + minimumEdit);
    }
    
    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int rowSize = ch1.length;
        int colSize = ch2.length;
        if(rowSize < 1){return colSize;}

        int [][] A = new int[rowSize+1][colSize+1];
        int fillRow = 0;
        int fillCol = 0;

        while(fillRow <= rowSize || fillCol <= colSize){
            if(fillRow <= rowSize){
                A[fillRow][0] = fillRow;
                fillRow++;
            }
            if(fillCol <= colSize){
                A[0][fillCol] = fillCol;
                fillCol++;
            }
        }
        //System.out.print("\n " + fillRow + " : " + fillCol);

        for(int row = 1; row<A.length; row++){

            for(int col = 1; col<A[0].length; col++){
                if(ch1[row-1] == ch2[col-1]){
                    A[row][col]  = A[row-1][col-1];
                } else if(ch1[row-1] != ch2[col-1]){
                    //System.out.print("\n Comp: " + ch1[row-1] + " : " + ch2[col-1]);
                    int tempMin = Math.min(A[row-1][col], A[row][col-1]);
                    A[row][col]  = 1 + Math.min(tempMin, A[row-1][col-1]);
                }
            }
        }

        return A[A.length-1][A[0].length-1];
    }
}


