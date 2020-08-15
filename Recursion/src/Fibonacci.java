public class Fibonacci {
    public static void main(String[] args) {
        int f = fib(5);
        System.out.println("fib: " + f);
    }

    public static int fib(long n) {
        //count++;
        if (n == 1 || n == 2) {
            return 1;
        } else if (n <= 0) {
            System.out.println("Error: There is no term less than 1");
            return 0;
        } else {
            return (fib(n - 1) + fib(n - 2));
        }
    }
}