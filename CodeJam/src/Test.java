import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Test{
    public static void main(String[] args){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = 6;
        int f = fib(n);
        printFebonachiRecursion(n);

        System.out.println("fib: " + f);

    }
    public static int fib(int n){
        if(n == 0){return 0;}
        if(n == 1){return 1;}

        return fib(n-1) + fib(n-2);
    }
    private static List<BigInteger> dict = new ArrayList<BigInteger>();
    public static void printFebonachiRecursion (int num){
        if (num==1){
            printFebonachiRecursion(num-1);
            System.out.printf("Term %d: %d%n",num,1);
            dict.add(BigInteger.ONE);
        }
        else if (num==0){
            System.out.printf("Term %d: %d%n",num,0);
            dict.add(BigInteger.ZERO);
        }
        else {
            printFebonachiRecursion(num-1);
            dict.add(dict.get(num-2).add(dict.get(num-1)));
            System.out.printf("Term %d: %d%n",num,dict.get(num));
        }
    }

}