import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class RecursiveDigitSum {

    // Complete the superDigit function below.
    //static boolean done = false;
    static int superDigit(String n, int k) {
        if(n.length()>1){
            long sum = 0;
            for(int i=0; i<n.length(); i++){
                sum+= Character.getNumericValue(n.charAt(i));
            }
            return superDigit(Long.toString(sum*k), 1);
        }else{
            return k * Character.getNumericValue(n.charAt(0));
        }
    }
    private static char[] findSum(char[] A){

        if(A.length !=1){
            int Sum = 0;
            for(char c: A){
                Sum+= (c-'0');
            }
            char[] chars = ("" + Sum).toCharArray();
            System.out.print(" cl: " + chars.length);
            for(char c: chars){
                //System.out.print(" c: " + c);
            }
            return chars;
        }else{
            return A;
        }

    }




    public static void main(String[] args) {
        int x = superDigit("116", 1);

        System.out.print("x " + x);
    }
}
