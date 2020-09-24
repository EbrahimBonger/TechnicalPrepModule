import java.util.*;

public class QueueTest {
    public static void main(String[] args){

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        HashSet<Character> set = new HashSet<Character>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        int[] a = new int []{1,2,3,4};

        Arrays.sort(a);

        //map
        //maxHeap
        //minHeap
        set.add('S');
        set.add('T');
        set.add('Q');
        set.add('E');
        set.add('N');
        set.add('G');
        set.add('T');
        set.add('Q');
        set.add('S');
        set.add('E');





        System.out.print(" "+set + " SIZE: " + set.size());



        int n = set.size(), r = 3, comb, per;
        per = factorial(n) / factorial(n-r);
        System.out.println("\nPermutation: " + per);
        comb = factorial(n) / (factorial(r) * factorial(n-r));
        System.out.println("Combination: " + comb);
    }

    static int factorial(int n) {
        int fact = 1;
        int i = 1;
        while(i <= n) {
            fact *= i;
            i++;
        }
        return fact;
    }
}
