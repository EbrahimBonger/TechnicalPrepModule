
import java.util.*;

import static java.util.stream.Collectors.joining;

class CrackingPassword {

    /*
     * Complete the 'passwordCracker' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY passwords
     *  2. STRING loginAttempt
     *
     * https://www.hackerrank.com/challenges/password-cracker/problem?isFullScreen=false
     * reference: https://www.youtube.com/watch?v=HUohDiEFdFc&t=190s
     */

    public static String passwordCracker(List<String> passwords, String loginAttempt) {
        // Write your code here
        if(passwords.size() == 0 || loginAttempt.length() == 0){return " ";}
        String str = recursiveFunc(passwords, loginAttempt, 0, "");
        return str = str.contains("WRONG PASSWORD")?"WRONG PASSWORD":str.substring(0, (str.length()-1));
    }


    public static String concat(String s1, String s2)
    {
        return s1 + s2;
    }
    public static String recursiveFunc(List<String> passwords, String loginAttempt, int i, String str){

        if(i == loginAttempt.length()){return str;}

        for(String p: passwords){


            if(loginAttempt.length() >= p.length() && loginAttempt.substring(i, p.length()).contains(p)){
                concat(str, p);

                String updatedtr = loginAttempt.substring(p.length(), loginAttempt.length());
                return recursiveFunc(passwords, updatedtr, 0, concat(str, p) + " ");
            }
        }
        return "WRONG PASSWORD";
    }

    public static String[] GetStringArray(ArrayList<String> arr)
    {

        // declaration and initialise String Array
        String str[] = new String[arr.size()];

        // ArrayList to Array Conversion
        for (int j = 0; j < arr.size(); j++) {

            // Assign each value to String array
            str[j] = arr.get(j);
        }
        //String[] str = GetStringArray(pass);
        return str;
    }




    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int max = 0;
        int count = 0;
        // 1 2 2 3 1 2
        // 4 6 5 3 3 1
        for(int i=0; i<a.size()-2; i++){
            int x = a.get(i) - a.get(i+1);
            int y = a.get(i) - a.get(i+2);
            System.out.println("x: " + x + " abs: " + Math.abs(x));
            if(Math.abs(x) <= 1 || Math.abs(y) <= 1){
                count++;
                max = Math.max(max, count);
            }else{
                count = 0;
            }
        }
        return max+1;
    }

    public static void main(String[] args) {
        ArrayList<String> pass = new ArrayList<String>();
        pass.add("because");
        pass.add("can");
        pass.add("do");
        pass.add("must");
        pass.add("we");
        pass.add("what");

        String[] st = pass.toArray(new String[0]);

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(6);
        list.add(5);
        list.add(3);
        list.add(3);
        list.add(1);

        //int[] ar = new int[]{4, 6, 5, 3, 3, 1};

        //System.out.println("pick: " + pickingNumbers(list));



        String str = "wedowhatwemustbecausewecan";
        String result = passwordCracker(pass, str);
        System.out.println("\nresult: " + result);

    }

}

