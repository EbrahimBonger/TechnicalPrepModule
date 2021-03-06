import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Making_Anagram {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0){
            return s1.length() + s2.length();
        }
        int[] alphabet = new int[26];
        int del = 0;
        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            int a = (int)c - 97;

            alphabet[a] = alphabet[a] +1;
            del++;
            System.out.println(a + " char " + c + " freq: " + alphabet[a] + " del: " + del);
        }

        for(int i=0; i<s2.length(); i++){
            char c = s2.charAt(i);
            int a = (int)c - 97;
            if(alphabet[a] > 0){
                alphabet[a] = alphabet[a] - 1;
                del--;
            } else if(alphabet[a] == 0){
                del++;
            }
        }

        return del;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
