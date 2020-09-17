public class CountNumberOfSubsets {
    public static int countNumberOfSubsets(int[] X, int k, int idx, int T, int totalSum, int count){
        int n = X.length;


        while(idx <n){

            //System.out.println("k k: " + k + " :: " + X[idx] + " totalSum: " + totalSum + " idx: " + idx);
            if(k  <= T ){
                System.out.println("Left k: " + k + " :: " + X[idx] + " totalSum: " + totalSum + " idx: " + idx);
                //idx = idx+1;
                //k += X[idx];
                //System.out.println("k after: " + k + " totalSum: " + totalSum + " idx: " + idx);
                return countNumberOfSubsets(X, k+X[idx], idx+1, T, totalSum - X[idx], count);
            }
            if(k == T){
                System.out.println("CC: " + k  + " = " + T );
                count = count + 1;
            }
            if(k + totalSum > T){
                System.out.println("Right k: " + (k-X[idx-1]) + " totalSum: " + totalSum + " idx: " + idx);
                //idx = idx+1;

                return countNumberOfSubsets(X, X[idx], idx,  T, totalSum - X[idx], count);
            }

        }



        return count;
    }


    public static void main(String[] args){
        int[] X = {2,2,3,4,5,8};
        int n = X.length;
        int totalSum = 0;
        for(int i=0; i<n; i++){
            totalSum += X[i];
            //System.out.println("totalSum: " + totalSum);
        }
        int y = countNumberOfSubsets(X, 0, 0, 8, totalSum, 0);
        System.out.println("Count: " + y);


    }
}
