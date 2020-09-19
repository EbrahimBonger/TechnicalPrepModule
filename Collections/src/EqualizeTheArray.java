
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class EqualizeTheArray {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        int frq = 0;
        int n = arr.length;
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int a: arr){
            if(m.containsKey(a)){
                m.replace(a, m.get(a), m.get(a) +1);
                frq = Math.max(frq,m.get(a));
            }else{
                m.put(a, 1);
            }
        }
        System.out.println(frq);
        frq = frq == 0? n-1: n-frq;
        return frq;
    }



    public static void main(String[] args) {
        int[] t = {37, 32, 97, 35, 76, 62};
        int x = equalizeArray(t);
        System.out.println("e: " + x);
    }
}
