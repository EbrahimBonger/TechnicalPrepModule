
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class HighestValuePalindrome {

    // Complete the highestValuePalindrome function below.
    // reference: https://www.youtube.com/watch?v=jFjkMADcpsI
    static String highestValuePalindrome(String s, int n, int k) {
        StringBuilder ss = new StringBuilder(s);
        int l = 0;
        int r = s.length()-1;
        int[] a = new int[n];
        while(l<=r){
            if(ss.charAt(l) != ss.charAt(r)){
                if(ss.charAt(l) > ss.charAt(r)){
                    ss.setCharAt(r, ss.charAt(l));
                    a[r] = 1;
                }else{
                    ss.setCharAt(l, ss.charAt(r));
                    a[l] = 1;
                }
                k--;
            }
            l++;
            r--;
        }
        if(k<0){return "-1";}
        l = 0;
        r = s.length()-1;

        while (l<=r){
            if(l == r && k>=1){
                ss.setCharAt(l, '9');
                break;
            }
            if(ss.charAt(l) < '9'){
                if(a[l] == 0 && a[r] == 0 && k>=2){
                    ss.setCharAt(l, '9');
                    ss.setCharAt(r, '9');
                    k-=2;
                } if( (a[l] == 1 || a[r] == 1) && k>=1){
                    ss.setCharAt(l, '9');
                    ss.setCharAt(r, '9');
                    k--;
                }
            }
            l++;
            r--;
        }

        String x = ss.toString();
        //System.out.println("SS: " + ss + " k: " + k);
        return x;
        //return x = k>=0? ss.toString():"-1";
    }


    public static void main(String[] args) {
        String s = "1";
        String t = highestValuePalindrome(s, 0, 2);
        System.out.println("T: " + t);

    }
}
