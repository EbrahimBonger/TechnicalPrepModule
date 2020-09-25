import java.util.*;

public class Yogurt {
    public static void main(String[] args){
        try (Scanner in = new Scanner(System.in)){
            int cases = in.nextInt();
            for(int t = 1; t<= cases; ++t){
                int n = in.nextInt();
                int k = in.nextInt();

                int[] a  = new int[n+1];

                for(int i=0; i<n; i++){
                    int ai = in.nextInt();
                    if(ai > n) ai = n;
                    a[ai]++;
                }

                int total  = 0;
                for(int i=n; i>0; i--){
                    int today = Math.min(k, a[i]);
                    total += today;
                    a[i-1] += a[i] - today;
                }
                System.out.println("Case #" + t + ": " + total);
            }
        }
    }
}