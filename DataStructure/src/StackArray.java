import java.util.*;
public class StackArray {
    public static void main(String[] args){
        /**
         * Stack methods:
         *  Push
         *  Pop
         *  Peek
         *  Show
         *  Resize
         *  isEmpty
         * **/
        StackArray Stack = new StackArray();
        Stack.push(9);
        Stack.push(8);
        Stack.pop();
        Stack.push(7);
        Stack.peek();
        Stack.size();
        Stack.show();
        Stack.push(6);
    }
    // initialize the array
    public static int[] Stack = new int[2];
    public static int n = Stack.length;
    public static int top = 0;
    public static void push(int data){
        // check if the current array is full
        if(top == n){
            resize();
        }
        Stack[top] = data;
        //once the data has been added, increment the top to the next empty index
        top++;
    }
    public static int pop(){
        int data = -1;
        if(isEmpty() == false){
            // before the pop, decrement the top to point at the right index subject to removal
            top--;
            data = Stack[top];
            System.out.println("Pop: " + data);
            Stack[top] = 0;
        }
        return data;
    }
    public static void peek(){
        System.out.println("Top: " + Stack[top-1]);
    }
    public static void show(){
        System.out.print("Show: ");
        for(int i=0; i<top; i++){
            System.out.print(Stack[i] + " ");
        }
        System.out.println();
    }
    public static void resize(){
        int[] newArray = new int[n * 2];
        System.arraycopy(Stack, 0, newArray, 0, n);
        Stack = newArray;
        System.out.println("Resized: " + Stack.length);

    }
    public static void size(){
        int n = Stack.length;
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
