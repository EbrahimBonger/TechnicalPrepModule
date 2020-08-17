import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class GridPathFinder {
    /**
     *
     * Book: Cracking The Coding Interview
     * Page: 344
     * Reference: https://www.youtube.com/watch?v=P8Xa2BitN3I&t=35s
     *            https://www.youtube.com/watch?v=W9F8fDQj7Ok
     * (Watch the videos 'til the end)
     * **/
    public static void main(String[] args){

        System.out.println("Un-Memoize Solution: ");
        int[][] UnMemoizeMaze = new int[5][5];

        // obstacles
        UnMemoizeMaze[0][2] = -1;
        UnMemoizeMaze[1][0] = -1;
        UnMemoizeMaze[2][2] = -1;
        UnMemoizeMaze[3][4] = -1;
        UnMemoizeMaze[4][0] = -1;

        show(UnMemoizeMaze);
        ArrayList<Point> pathOne = findPathWithOutMemoization(UnMemoizeMaze);
        /** The path is , technically, the stack frame of the recursive call, because we start finding the path from the bottom right corner and trace back to the origin 0,0
         then, we able to stack the path from start due to the stack data structure LIFO policy
         **/
        System.out.print("UnMemoize Path: ");
        for(Point p : pathOne){
            System.out.print(p.x + "," + p.y + " : ");
        }
        System.out.println();
        show(UnMemoizeMaze);

        System.out.println("Memoize Solution: ");

        int[][] memoizeMaze = new int[5][5];

        // obstacles
        memoizeMaze[0][2] = -1;
        memoizeMaze[1][0] = -1;
        memoizeMaze[2][2] = -1;
        memoizeMaze[3][4] = -1;
        memoizeMaze[4][0] = -1;

        show(UnMemoizeMaze);
        ArrayList<Point> pathTwo = findPathWithMemoization(memoizeMaze);
        /** The path is , technically, the stack frame of the recursive call, because we start finding the path from the bottom right corner and trace back to the origin 0,0
         then, we able to stack the path from start due to the stack data structure LIFO policy
         **/
        System.out.print("Memoize Path: ");
        for(Point p : pathTwo){
            System.out.print(p.x + "," + p.y + " : ");
        }
        System.out.println();
        show(memoizeMaze);
    }

    public static ArrayList<Point> findPathWithOutMemoization(int[][] maze){
        // top left corner at idx 0,0 is where the robot start
        // bottom right corner at idx row-1,column-1 is where the robot finish
        // the cell where the robot can intersect is denoted as 0
        // the cell where the robot cannot intersect is denoted as -1
        // to move to right add 1 to the column
        // to move to down add 1 to the row
        // the robot itself is denoted as 1

        if(maze == null || maze.length == 0){return null;}
        ArrayList<Point> path = new ArrayList<Point>();
        if(isValidPathWithOutMemoization(maze, maze.length-1, maze[0].length-1, path)){

            return path;
        }
        return null;
    }
    public static boolean isValidPathWithOutMemoization(int[][] maze, int row, int col, ArrayList<Point> path){
        if(row < 0 || col < 0 || maze[row][col] == -1){
            return false;
        }
        boolean isOrigin = (row == 0) && (col == 0);

        if(isOrigin || isValidPathWithOutMemoization(maze, row-1, col, path) || isValidPathWithOutMemoization(maze, row, col-1, path)){
            maze[row][col] = 1;
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    public static ArrayList<Point> findPathWithMemoization(int[][] maze){
        // top left corner at idx 0,0 is where the robot start
        // bottom right corner at idx row-1,column-1 is where the robot finish
        // the cell where the robot can intersect is denoted as 0
        // the cell where the robot cannot intersect is denoted as -1
        // to move to right add 1 to the column
        // to move to down add 1 to the row
        // the robot itself is denoted as 1

        if(maze == null || maze.length == 0){return null;}
        ArrayList<Point> path = new ArrayList<Point>();
        HashSet<Point> failedPoints = new HashSet<Point>();
        if(isValidPathWithMemoization(maze, maze.length-1, maze[0].length-1, path, failedPoints)){

            return path;
        }
        return null;
    }
    public static boolean isValidPathWithMemoization(int[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints){
        if(row < 0 || col < 0 || maze[row][col] == -1){
            return false;
        }
        boolean isOrigin = (row == 0) && (col == 0);

        if(isOrigin || isValidPathWithMemoization(maze, row-1, col, path, failedPoints) || isValidPathWithMemoization(maze, row, col-1, path, failedPoints)){
            maze[row][col] = 1;
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        Point p = new Point(row, col);
        failedPoints.add(p);
        return false;
    }

    public static void show(int[][] maze){
        int r = maze.length;
        int c = maze[0].length;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}
