public class GridPathFinder {
    /**
     * Reference: https://www.youtube.com/watch?v=P8Xa2BitN3I&t=35s
     *            https://www.youtube.com/watch?v=W9F8fDQj7Ok
     * (Watch the videos 'til the end)
     * **/
    static int[][] grid = new int[5][5];
    public static void main(String[] args){

        int rN = grid.length-1;
        int cN = grid[0].length-1;

        grid[0][0] = 1;
        grid[0][1] = -1;
        grid[0][3] = -1;
        grid[1][1] = -1;
        grid[2][2] = -1;
        grid[2][4] = -1;
        grid[3][1] = -1;
        //grid[4][2] = -1;
        //grid[rN][cN] = 2;



        show(grid);
        findPath(grid, 0, 0, 1);
        System.out.println("/////////////////");
        show(grid);

    }

    public static void findPath(int[][] grid, int down, int right, int robot){
        // top left corner at idx 0,0 is where the robot start
        // bottom right corner at idx row-1,column-1 is where the robot finish
        // the cell where the robot can intersect is denoted as 0
        // the cell where the robot cannot intersect is denoted as -1
        // to move to right add 1 to the column
        // to move to down add 1 to the row
        // the robot itself is denoted as 1

        int wall = -1;
        int rN = grid.length-1;
        int cN = grid[0].length-1;

        // base case
        if(right < cN && grid[down][right+1] != wall){
            grid[down][right+1] = 1;
            findPath(grid, down, right+1, robot);
        } else if(down < rN && grid[down+1][right] != wall){
            grid[down+1][right] = 1;
            findPath(grid, down+1, right, robot);
        }

        if(grid[down][right] == wall){
            return;
        }






    }

    public static void goRight(int col){col = col+1;}
    public static void goDown(int row){row = row+1;}
    public static void show(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
