class Test{
    public static void main(String[] args){
        int[] arr = {
                2, 31, 1, 38, 29, 5, 44, 6, 12, 18, 39, 9, 48, 49, 13, 11, 7, 27, 14, 33, 50, 21, 46, 23, 15, 26, 8, 47, 40, 3, 32, 22, 34, 42, 16, 41, 24, 10, 4, 28, 36, 30, 37, 35, 20, 17, 45, 43, 25, 19
        };
        //System.out.print(arr.length);
        minimumSwaps(arr);
    }

    static int minimumSwaps(int[] arr) {
        int[] newArr = new int[arr.length];
        int i = 0;
        int minSwap = 0;
        while(i+1 == arr[i]){
            i++;
            if(i+1 == arr.length){return 0;}
        }

        while(i+1 != arr[i]){
            int temp = arr[arr[i]-1];
            arr[arr[i]-1] = arr[i];
            newArr[arr[i]-1] = arr[i];
            arr[i] = temp;
            minSwap++;
        }

        for(int a: newArr){
            System.out.print(": " + a);
            if(a==0){minSwap++;}
        }
        System.out.println("Min swap: " + minSwap);
        return minSwap;
    }

}