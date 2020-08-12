class SearchingPairOfIndexesInSortedMatrix {
    /**
     * Reference: https://www.algoexpert.io/questions/Search%20In%20Sorted%20Matrix
     * **/
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
        };

        // testing searchInSortedMatrix method
        int targetExist = 44;
        int targetDoesNotExist = 43;
        searchInSortedMatrix(matrix, targetExist);
        System.out.println();
        searchInSortedMatrix(matrix, targetDoesNotExist);

    }
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Write your code here.
        int[] result = new int[] {-1, -1};
        int row = 0;
        int column = matrix[0].length-1;
        while(row < matrix.length && column >= 0){
            // look up if the right corner of the matrix is equal to the targeted value
            if(matrix[row][column] == target){
                result[0] = row;
                result[1] = column;
                System.out.print("Targeted value : " + target + " exist at row: " + row + " and column: " + column );
                return result;
            }
            // avoid the column by decrementing from searching if the given value at this column is greater that the targeted value
            if(matrix[row][column] > target){
                column = column -1;
            }
            // avoid the row by incrementing the row from searching if the given value at this row is greater that the targeted value
            else if(matrix[row][column] < target){
                row = row + 1;
            }
            // finally, it will navigate the targeted value if exist to

        }
        //otherwise, return -1, -1
        System.out.print("Targeted value: " + target +  " does not exist in the matrix!");
        return result;
    }
}
