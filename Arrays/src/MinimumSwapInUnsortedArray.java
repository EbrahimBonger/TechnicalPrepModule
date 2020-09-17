public class MinimumSwapInUnsortedArray {
    // Reference: https://www.youtube.com/watch?v=9ppe_NxRriU
    public static void main(String[] args){
        int[] arr = {
                2, 31, 1, 38, 29, 5, 44, 6, 12, 18, 39, 9, 48, 49, 13, 11, 7, 27, 14, 33, 50, 21, 46, 23, 15, 26, 8, 47, 40, 3, 32, 22, 34, 42, 16, 41, 24, 10, 4, 28, 36, 30, 37, 35, 20, 17, 45, 43, 25, 19
        };
        //System.out.println(arr.length);
        minimumSwaps(arr);
    }

    static int minimumSwaps(int[] arr) {
        int minV = arr[0];
        int minIdx = 0;
        int swaps = 0;
        int n = arr.length;
        for(int i=1; i<n; i++){
            if(arr[i] < minV){
                minV = arr[i];
                minIdx = i;
            }
        }

        if(minIdx != 0){
            int temp = arr[minIdx];
            arr[minIdx] = arr[0];
            arr[0] = temp;
            swaps++;
        }
        for(int c=1; c<n-1; c++){
            int p = arr[c] - arr[0];
            while(arr[p] != arr[c]){
                int temp = arr[p];
                arr[p] = arr[c];
                arr[c] = temp;
                swaps++;
                p = arr[c] - arr[0];
            }
            c = p;
        }
        System.out.println("Minimum swaps : " + swaps);

        return swaps;

    }

}
