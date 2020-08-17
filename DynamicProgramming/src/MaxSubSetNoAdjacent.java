class Program {


    public static void main(String[] args){
        int[] array = {75, 105, 120, 75, 90, 135};
        int[] emptyArray = {};
        MaxSubSetNoAdjacent(array);
        MaxSubSetNoAdjacent(emptyArray);
    }

    public static void MaxSubSetNoAdjacent(int[] array) {
        /** Reference: https://www.youtube.com/watch?v=UtGtF6nc35g
        			  https://www.youtube.com/watch?v=jhzpVBQi1g8
                    https://www.algoexpert.io/questions/Max%20Subset%20Sum%20No%20Adjacent

         The core concept of this algorithm is what is the best you can do so far between
         including and excluding index i
         **/

        if(array.length == 0){
            System.out.println("Empty");
            return;
        }
        // store the possible highest sum inclusive the current index
        int inclusive = array[0];

        // store the possible highest sum excluding the current index
        int exclusive = 0;

        //i run from 1 to n-1
        for(int i=1; i<array.length; i++){
            int temp = inclusive;
            inclusive = Math.max(inclusive, (exclusive + array[i]));
            exclusive = temp;
        }
        System.out.println("The Max sub-set is: " + inclusive);
    }
}
