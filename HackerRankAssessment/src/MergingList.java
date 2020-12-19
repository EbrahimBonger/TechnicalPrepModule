import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class MergingList {

    public static void main(String args[]){
        System.out.print("main Test");
    }
    /*
     * Complete the 'mergeArrays' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
        // Write your code here
        ArrayList<Integer> resultant = new ArrayList<Integer>();
        if(a.size() == 0 && b.size() > 0){return b;}
        if(b.size() == 0 && a.size() > 0){return a;}
        int a_count = 0;
        int b_count = 0;

        while(a_count < a.size() && b_count < b.size()){
            if(a.get(a_count) == b.get(b_count)){
                resultant.add(a.get(a_count));
                resultant.add(b.get(b_count));
                a_count++;
                b_count++;
            }
            else if(a.get(a_count) < b.get(b_count)){
                resultant.add(a.get(a_count));
                a_count++;
            }
            else {
                //if(b.get(b_count) < a.get(a_count))
                resultant.add(b.get(b_count));
                b_count++;
            }
        }
        if(a_count < a.size()){
            for(int i=a_count; i<a.size(); i++){
                resultant.add(a.get(i));
            }
        }
        if(b_count < b.size()){
            for(int i=b_count; i<b.size(); i++){
                resultant.add(b.get(i));
            }
        }

        return resultant;
    }

}

