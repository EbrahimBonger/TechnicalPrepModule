import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class Abbreviation {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        // step 1 convert b to char array and map it to HashMap as a character
        String res = b;
        char[] bb = b.toCharArray();
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        for(char c: bb){
            m.put(c, 0);
        }
        //String s = a;
        int n = a.length();
        for(int i=n-1; i>=0; i--){
            char temp = a.charAt(i);
            char lCase = a.charAt(i);
            int x = lCase - 32;
            if(Character.isLowerCase(lCase)){
                lCase = (char)x;
            }
            if(!( m.containsKey(a.charAt(i)) || m.containsKey(lCase) ) && Character.isLowerCase(a.charAt(i))){
                //a = a.replace(temp.toString(),"");
                System.out.println("To remove: "  + a.charAt(i) + "  " + a + " : " + n);
                a = charRemoveAt(a, i);
                n = a.length();

            }


        }
        System.out.println(" CC: " + a);
        if(a.length() != b.length()){
            System.out.println("NOO");
            return "NO";
        }

        for(int i=0; i<a.length(); i++){
            char temp = a.charAt(i);
            char lCase = a.charAt(i);
            int x = lCase - 32;
            if(Character.isLowerCase(lCase)){
                lCase = (char)x;
            }
            if(res.charAt(i) != lCase && res.charAt(i) != temp){
                System.out.println("NO");
                return "NO";
            }
        }
        //System.out.println(a);
        // step 2 check if a's each char wheather exist in the map
        // when you check; consider the offset between capital and small letters
        // if is not Capital letter and does not exist, the delete it
        // step 3 compare a and b length, if the are not equal return NO
        // step 4 convert a to char array
        // step 5 check and and b simeltinously at their adjecent index
        // again, consider the offset between capital and small letters

        System.out.println("YES");
        return "YES";

    }
    public static String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }

    public static void main(String[] args) throws IOException {
        String a = "LLZOSYAMQRMBTZXTQMQcKGLR";
        String b = "LLZOSYAMBTZXMQKLR";




        abbreviation(a, b);
    }
}
