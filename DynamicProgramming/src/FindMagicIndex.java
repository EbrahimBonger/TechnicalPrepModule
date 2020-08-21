public class FindMagicIndex {
    /**
     * Reference:
     * https://medium.com/@y.kononchuk/8-3-magic-index-872c44637c60
     * Cracking the Coding Interview
     * Page: 346
     * Magic Index: A magic index in an array A[ 0… n -1] is defined to be an index such that A[ i] = i.
     * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
     * FOLLOW UP: What if the values are not distinct?
     * **/

    public static void main(String[] args){
        int[] distinctValues = {-40, -20,-1, 1, 2, 3, 5, 7, 9, 12, 13};
        int[] noneDistinctValues = {-10, -5,2,2,2,3,4,5, 9, 12, 13};
        findMagicIndexInDistinctArray(distinctValues, 0, distinctValues.length-1);
        findMagicIndexInNoneDistinctArray(noneDistinctValues, 0, noneDistinctValues.length-1);
    }

    public static void findMagicIndexInDistinctArray(int[] A, int start, int end){
        if(start>end){
            System.out.println("The magic index does not exist!");
            return;
        }
        int mid = (start+end)/2;
        if(A[mid] == mid){
            System.out.println("The magic index in distinct Array is: " + mid);
        } else if(A[mid] > mid){
            // explore left
            findMagicIndexInDistinctArray(A, start, mid-1);
        }
        else {
            // explore right
            findMagicIndexInDistinctArray(A, mid+1, end);
        }

    }

    public static int findMagicIndexInNoneDistinctArray(int[] A, int start, int end){
        if(start>end){
            //System.out.println("The magic index does not exist!");
            return -1;
        }
        int mid = (start+end)/2;
        if(A[mid] == mid){
            System.out.println("The magic index in none-distinct Array is: " + mid);
        }
        int midValue = A[mid];
        int leftIdx = Math.min(mid-1, midValue);
        if(leftIdx>=0){
           return findMagicIndexInNoneDistinctArray(A, start, leftIdx);
        }

        int rightIdx = Math.max(mid+1, midValue);
        return findMagicIndexInNoneDistinctArray(A, rightIdx, end);
    }
}
