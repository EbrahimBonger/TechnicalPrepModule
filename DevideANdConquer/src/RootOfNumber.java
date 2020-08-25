public class RootOfNumber {
    public static double root(double x, double n){
        if(x == 0){return 0;}
        double lowerBound = 0;
        double upperBound = x;
        double error = 0.001;
        double approximateRoot = 0;

        while (upperBound - lowerBound >= error){
            approximateRoot = (upperBound+lowerBound)/2;
            if(Math.pow(approximateRoot, n) == x){
                return approximateRoot;
            }else if(Math.pow(approximateRoot, n) > x){
                upperBound = approximateRoot;
            }else if(Math.pow(approximateRoot, n) < x){
                lowerBound = approximateRoot;
            }else {
                approximateRoot = (upperBound + lowerBound)/2;
            }
        }
        return approximateRoot;
    }

    public static void main(String[] args){
        double x = 7;
        double n = 3;
        double y = root(x,n);
        System.out.println("Root of " + x + " is: " + y);
    }
}
