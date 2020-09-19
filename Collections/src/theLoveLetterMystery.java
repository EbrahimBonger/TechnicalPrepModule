
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class theLoveLetterMystery {

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s, char[] c) {

        //c = s.toCharArray();
        // abcd
        int minV = 0;
        int l = 0;
        int r = c.length-1;
        while (l < r){
            System.out.println("l: " + l + " r: " + r);
            if(c[l] < c[r]){
                int in = (int)c[r]-1;
                char ch = (char)in;
                c[r] = ch;
                minV++;
            } else if(c[l] > c[r]){
                int in = (int)c[l]-1;
                char ch = (char)in;
                c[l] = ch;
                minV++;
            }else if(c[l] == c[r]){
                l++;
                r--;
            }

        }
        return minV;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String t = "abcd";
        char[] c = t.toCharArray();
        int x = theLoveLetterMystery(t, c);
        System.out.println("X: " + x + " : " + c[2]);
    }
}
