public class CountNumberOfSubsets {
    //static int idx = -1;
    public static int countNumberOfSubsets(int[] X, int soFar, int weight, int T, int idx){

        if( (soFar + X[idx])<= T && (soFar+weight) > T && idx < X.length){
            if(soFar == T){
                //System.out.println("soFar: " + soFar + " weight: " + weight + " idx: " + idx);
                //return;
            }
            System.out.println("Node: " + X[idx] + "  soFar: " + soFar + " weight: " + weight + " idx: " + idx);
            return countNumberOfSubsets(X, (soFar+X[idx]), (weight-X[idx]), T, idx+1) + countNumberOfSubsets(X, soFar, (weight-X[idx]), T, idx+1);
        }
        return -1;
    }


    public static void main(String[] args){
        int[] X = {5, 10, 12, 13, 15, 18};
        int n = X.length;
        int totalSum = 0;
//        for(int i=0; i<n; i++){
//            totalSum += X[i];
//            //System.out.println("totalSum: " + totalSum);
//        }
        countNumberOfSubsets(X, 0, 73, 30, 0);
        //System.out.println("Count: " + y);


    }
}
