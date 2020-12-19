import java.util.*;

class Triplets {

    /* arr[]  ---> Input Array 
    data[] ---> Temporary array to store current combination 
    start & end ---> Staring and Ending indexes in arr[] 
    index  ---> Current index in data[] 
    r ---> Size of a combination to be printed */
    static long count = 0;
    static void combinationUtil(List<Integer> arr, int data[], int start, int end, int index, int r, long t)
    {
        // Current combination is ready to be printed, print it
        int sum = 0;
        if (index == r)
        {
            for (int j=0; j<r; j++)
                sum+=data[j];
            if(sum<= t){

                count++;
            }
            return;
        }

        // replace index with all possible elements. The condition 
        // "end-i+1 >= r-index" makes sure that including one element 
        // at index will make a combination with remaining elements 
        // at remaining positions 
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr.get(i);
            combinationUtil(arr, data, i+1, end, index+1, r, t);
        }
    }



    // The main function that prints all combinations of size r 
    // in arr[] of size n. This function mainly uses combinationUtil() 
    static long triplets(long t, List<Integer> d){
        Collections.sort(d);
        long binaryCount = 0;
        for(int i=0; i<d.size()-2; i++){
            int left = i+1;
            int right = d.size()-1;
            while (left<right){
                long sum = d.get(i) + d.get(left)+ d.get(right);
                if(sum<= t){
                    binaryCount++;
                    right--;


                }else if(sum > t){
                        right--;
                }else{
                    left++;
                }
            }
        }
        return binaryCount;
    }

    static boolean find3Numbers(List<Integer> d,
                                int arr_size, long t)
    {
        // Fix the first element as A[i]
        for (int i = 0; i < arr_size - 2; i++) {

            // Find pair in subarray A[i+1..n-1]
            // with sum equal to sum - A[i]
            HashSet<Integer> s = new HashSet<Integer>();
            long curr_sum = t - d.get(i);
            for (int j = i + 1; j < arr_size; j++)
            {
                if (s.contains(curr_sum - d.get(j)))
                {
//                    System.out.printf("Triplet is %d,
//                            %d, %d", A[i],
//                    A[j], curr_sum - A[j]);
                    return true;
                }
                s.add(d.get(j));
            }
        }

        // If we reach here, then no triplet was found
        return false;
    }
    static long binarySearch(List<Integer> d, int idx, int left, int right, long binaryCount, long t){

        while (left < right){
            if (d.get(idx) + d.get(left)+ d.get(right) <= t) {
                binaryCount++;
            }
            //left++;
            right--;
            }
        return binaryCount;
    }



    static long countTriplets(List<Long> arr, long r){
        Map<Long,Long> v2 = new HashMap<>();
        Map<Long,Long> v3 = new HashMap<>();
        Long count = 0L;
        for (Long k:arr) {
            count+=v3.get(k)==null?0:v3.get(k);
            if (v2.get(k)!=null) v3.compute(k*r,(key,value)->value!=null?value+v2.get(k):v2.get(k));
            v2.compute(k*r,(key,value)->value==null?1:value+1);
        }
        return count;
    }

    /*Driver function to check for above function*/
    public static void main (String[] args) {
        int arr[] = {1,2,3,4,5};
        int[] R = new int[3];

        List<Integer> d = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++){
            d.add(arr[i]);
        }
        int r = 3;
        long t = 8;
        long c = 0;
        int n = arr.length;
        combinations2(d, 3, 0, R, t, c);
        //printCombination(d, n, r, t);
        //System.out.println(count);
        //long x = triplets(t, d);
        //System.out.println(x);
    }
    static void combinations2(List<Integer> d, int len, int startPosition, int[] result, long t, long c){
        int sum = 0;
        if (len == 0){

            for(Integer i: result){
                sum+=i;
            }
            if(sum<=t){
                System.out.println(Arrays.toString(result));
                c++;
            }
            return;
        }
        for (int i = startPosition; i <= d.size()-len; i++){
            result[result.length - len] = d.get(i);
            combinations2(d, len-1, i+1, result, t, c);
        }
    }
}