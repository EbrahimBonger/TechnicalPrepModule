

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class Sherlock {

    // Complete the isValid function below.
    static String isValid(String s) {
        //i reference: https://www.youtube.com/watch?v=G5aK5CuvnSk
        char[] ch = s.toCharArray();
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        long sum = 0;
        for(char c: ch){
            if(m.containsKey(c)){
                int temp = m.get(c)+1;
                //sum = sum+1;
                m.replace(c, temp);
            }else{
                m.put(c, 1);
                //sum = sum+1;
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> m2 = new HashMap<Integer, Integer>();
        for ( Integer v : m.values()) {
            min = Math.min(min, v);
            max = Math.max(max, v);

            if(m2.containsKey(v)){

                m2.replace(v, m2.get(v)+1);
                System.out.println(v);
            }else{
                m2.put(v, 1);
                System.out.println(v);
            }
        }

        System.out.println("M size: " + m2.size() + " min: " + min + " max: " + max);
        if((max-min == 0) || (min == 1 && m2.get(min) == 1) && m2.size() < 3){
            return "YES";
        }else if((max-min) == 1 && (m2.get(max) == 1)){
            return "YES";
        }else{
            return "NO";
        }
    }



    public static void main(String[] args) throws IOException {
        System.out.println(isValid("xxxaabbccrry"));
    }
}
