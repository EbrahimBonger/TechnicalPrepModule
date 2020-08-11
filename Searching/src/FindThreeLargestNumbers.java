public class FindThreeLargestNumbers {
    /**
     * Reference: https://www.algoexpert.io/questions/Find%20Three%20Largest%20Numbers
     * **/
    public static void main(String[] args){
        int[] array = {0, 1, 21, 0, 45, -100, 61, 71, 72, 73};
        int[] largestValues = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for(int a: array){
            returnLargest(largestValues, a);
        }
        for(int a: largestValues){
            System.out.print(a + " : ");
        }
    }
    public static void returnLargest(int[] largestValues, int temp){

        // case 1
        if(temp > largestValues[2]){
            largestValues[0] = largestValues[1];
            largestValues[1] = largestValues[2];
            largestValues[2] = temp;
            //System.out.println("1st: " +temp);
        }
        else if(temp > largestValues[1]){
            largestValues[0] = largestValues[1];
            largestValues[1] = temp;
            //System.out.println("2nd: " +temp);
        }
        else if(temp > largestValues[0]){
            largestValues[0] = temp;
            //System.out.println("3rd: " +temp);
        }

    }
}
