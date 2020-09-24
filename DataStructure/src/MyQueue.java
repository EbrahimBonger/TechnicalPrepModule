import java.util.ArrayList;


public class MyQueue{

    /**
     * Reference: https://www.youtube.com/watch?v=fptlqsesjxY&t=315s
     * **/
    public static void main(String[] args){
        /**
         * Stack methods:
         *  Push
         *  Pop
         *  Peek
         *  Show
         *  Resize
         *  Size
         *  isEmpty
         * **/
        //MyQueue<Integer> queue =  new MyQueue<Integer>();

        enqueue(9);
        enqueue(8);
        dequeue();
        enqueue(7);
        peek();
        //size();
        show();
        enqueue(6);
        show();
        dequeue();
        show();
    }
    // initialize the array

    public static ArrayList<Integer> queue =  new ArrayList<Integer>();
    //public static int n = queue.size();
    public static int top = 0;
    public static void enqueue(int data){
        // check if the current array is full

        queue.add(data);
        //once the data has been added, increment the top to the next empty index
        //top++;
        System.out.println("Pushed: " + data);
    }
    public static int dequeue(){
        int data = -1;
        if(queue.isEmpty() != true){
            // before the pop, decrement the top to point at the right index subject to removal
            //top--;
            //data = queue.get(top);
            System.out.println("Popped: " + queue.get(0));
            queue.remove(0);
        }
        return data;
    }
    public static void peek(){
        System.out.println("Peeked: " + queue.get(0));
    }
    public static void show(){
        System.out.print("Show: ");
        for(int i=0; i<queue.size(); i++){
            System.out.print(queue.get(i) + " ");
        }
        System.out.println();
    }
//    public static int size(){
//        int n = queue.size();
//        System.out.println("Size: " + n);
//        return n;
//    }
//    public static boolean isEmpty(){
//        if(top == 0){
//            return true;
//        }else {
//            return false;
//        }

    //}

}
