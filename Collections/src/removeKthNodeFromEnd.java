import java.util.*;

class removeKthNodeFromEnd {
    public static LinkedList head;
    public static void main(String[] args){
       head = new LinkedList(0);
       head.insert(1);
        head.insert(2);
        head.insert(3);
        head.insert(4);
        head.insert(5);
        head.insert(6);
        head.insert(7);
        head.insert(8);
        head.insert(9);
        System.out.print("Before: ");
        show();
        removeKthNodeFromEnd(head, 10);
        System.out.println();
        System.out.print("After: ");
        show();



    }
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        // shift the second node to kth places
        int counter = 1;
        LinkedList secondPtr = head;
        LinkedList firstPtr = head;
        while(counter <= k){
            secondPtr = secondPtr.next;
            counter++;
        }
        // if the secondPtr hit null
        //it means the kth value than needs to be removed is the head
        if(secondPtr == null){
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        //otherwise, start iterating both ptr simultaneously by maintaining the kth value a part
        while(secondPtr.next != null){
            secondPtr = secondPtr.next;
            firstPtr = firstPtr.next;
        }
        // now the first ptr is placed right before the node that needs to be removed
        firstPtr.next = firstPtr.next.next;
    }
    public static void show(){
        if (head != null){
            LinkedList ptr = head;
            while (ptr != null){
                System.out.print(ptr.value+ " ");
                ptr = ptr.next;
            }
        }
    }
    static class LinkedList {
        public int value;
        //public LinkedList head = null;
        public LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
        public void insert(int value){
            LinkedList newNode = new LinkedList(value);
            if(head == null){
                head = newNode;
            } else{
                LinkedList ptr = head;
                while (ptr.next != null){
                    ptr = ptr.next;
                }
                ptr.next = newNode;
            }
        }
    }
}
