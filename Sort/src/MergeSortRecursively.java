import java.util.Arrays;

public class MergeSortRecursively {
    /**
     * Reference: https://www.youtube.com/watch?v=TzeBrDU-JaY
     *          : https://www.geeksforgeeks.org/merge-sort/
     * **/
    public static void main(String[] args){
        int[] array = {5,8,3,9,6,5,2};
        int n  = array.length;
        int m = n/2;
        mergeSort(array);
        int[] leftHalf = Arrays.copyOfRange(array, 0, m);
        int[] rightHalf = Arrays.copyOfRange(array, m, n);

        System.out.println("\nLeft Half: ");
        for (int a: leftHalf){
            System.out.print(a + " : ");
        }

        System.out.println("\nRight Half: ");
        for (int a: rightHalf){
            System.out.print(a + " : ");
        }

        merge(array, leftHalf, rightHalf);
        System.out.println("\nAfter Right & Left Half merged: ");
        for (int a: array){
            System.out.print(a + " : ");
        }
    }

    private  static void mergeSort(int[] array){
        int n = array.length;
        int m = n/2;
        if(n<2){return; }
        /**Create Left and Right arrays**/
        int[] lArr = new int[m];
        int[] rArr = new int[n-m];
        /**Copy the value into the new arrays from the original array**/
        for(int i=0; i<lArr.length; i++){
            lArr[i] = array[i];
        }
        for(int j=0; j<rArr.length; j++){
            rArr[j] = array[m+j];
        }
        mergeSort(lArr);
        mergeSort(rArr);

        merge(array, lArr, rArr);
    }

    private static void merge(int[] array, int[] left, int[] right){
        int x = 0;
        int i=0, j=0, k=0;
        while(i<left.length && j<right.length){
            if(left[i]<= right[j]){
                array[k] = left[i];
                i++;
            } else{
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i<left.length){
            array[k] = left[i];
            k++;
            i++;
        }
        while (j<right.length){
            array[k] = right[j];
            k++;
            j++;
        }
    }
}
