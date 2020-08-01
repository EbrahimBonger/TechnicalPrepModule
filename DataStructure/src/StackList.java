import java.util.*;

public class StackList {

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
        LinkedList<Integer> Stack =  new LinkedList<Integer>();
        push(9);
        push(8);
        pop();
        push(7);
        peek();
        size();
        show();
        push(6);
    }
    // initialize the array

    public static LinkedList<Integer> Stack =  new LinkedList<Integer>();
    public static int n = Stack.size();
    public static int top = 0;
    public static void push(int data){
        // check if the current array is full

        Stack.add(data);
        //once the data has been added, increment the top to the next empty index
        top++;
        System.out.println("Pushed: " + data);
    }
    public static int pop(){
        int data = -1;
        if(isEmpty() != true){
            // before the pop, decrement the top to point at the right index subject to removal
            top--;
            data = Stack.get(top);
            System.out.println("Popped: " + data);
            Stack.remove();
        }
        return data;
    }
    public static void peek(){
        System.out.println("Peeked: " + Stack.get(top-1));
    }
    public static void show(){
        System.out.print("Show: ");
        for(int i=0; i<top; i++){
            System.out.print(Stack.get(i) + " ");
        }
        System.out.println();
    }
    public static void size(){
        int n = Stack.size();
        System.out.println("Size: " + n);
    }
    public static boolean isEmpty(){
        if(top == 0){
            return true;
        }else {
            return false;
        }

    }

}
