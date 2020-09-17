
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class AlteringCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int del = 0;
        //AAAA
        for(int i=0; i<n; i++){
            int p = i+1;
            while(p <= n-1 && ch[i] == ch[p]){
                p = p+1;
                del++;
                System.out.println("p: " + p + " size: " + n);
            }
             if(p >= n-1){
                 i=n;
             }else{
                 i = p-1 == 1? i: p-1;
             }

        }
        return del;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = "AAAA";
        int x = alternatingCharacters(s);
        System.out.println("Deletion: " + x);
    }
}
