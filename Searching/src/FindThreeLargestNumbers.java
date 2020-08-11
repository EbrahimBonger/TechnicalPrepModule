public class FindThreeLargestNumbers {
    /**
     * Reference: https://www.algoexpert.io/questions/Find%20Three%20Largest%20Numbers
     * **/
    public static void main(String[] args){
        int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        findThreeLargestNumbers(array);
    }
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int[] largestValues = new int[3];
        //System.out.println(largestValues[0]);
        for(int i=0; i<array.length; i++){
            int temp = array[i];
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
        for(int a: largestValues){
            System.out.print(": " + a);
        }
        return largestValues;
    }
}
