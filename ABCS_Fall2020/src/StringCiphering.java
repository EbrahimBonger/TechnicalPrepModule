
import com.sun.tools.javac.Main;

import java.util.*;
// Add any extra import statements you may need here


class StringCiphering {
    private static int test_case_number;

    // Add any helper functions you may need here


    static String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        //System.out.println(input + " " + rotationFactor);
        if(rotationFactor == 0){return input;}
        char[] letter = input.toCharArray();
        int capital_letter_offset =  rotationFactor%26;
        int small_letter_offset =  rotationFactor%26;
        int int_offset = rotationFactor%10;
        for(int i=0; i<input.length(); i++){
            int capital_x = letter[i] -65;
            int small_x = letter[i] -97;
            int num = letter[i]-'0';


            if(small_letter_offset != 0 && small_x >= 0 && small_x <= 25){
                int y =  (small_x + small_letter_offset)%26;
                y = y + 97;
                letter[i] = (char) y;
            }
            else if(capital_letter_offset != 0 && capital_x >= 0 && capital_x <= 25){
                int y =  (capital_x + small_letter_offset)%26;
                y = y + 65;
                letter[i] = (char) y;
            }
            else if(int_offset != 0 &&  num >= 0 && num <= 9){

                int y = (  num + int_offset) % 10;

                letter[i] = Integer.toString(y).charAt(0);
            }
        }

        input = new String(letter);
        return input;

    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    //int test_case_number = 1;
    static void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    static void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public static void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        //new Main().run();
        run();
    }
}