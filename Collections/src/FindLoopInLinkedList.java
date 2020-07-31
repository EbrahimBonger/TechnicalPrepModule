import java.util.*;

class FindLoopInLinkedList {
    /** reference:
     *             https://www.algoexpert.io/questions/Find%20Loop
     *             https://www.youtube.com/watch?v=LUm2ABqAs1w&t=19s
     *             https://www.youtube.com/watch?v=zbozWoMgKW0
    // **/
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
        createLoop();
        //show();
        LinkedList loop = findLoop(head);
        System.out.println("Loop origin: " + loop.value);
        //show();



    }
    public static LinkedList findLoop(LinkedList head) {
        /** Write your code here.
        // iterate the first pointer to every one another node
        // iterate the second pointer to every two another node
        // Eventually the pointers will point to the same node
        **/
        LinkedList first = head.next;
        LinkedList second = head.next.next;
        while(first != second){
            first = first.next;
            second = second.next.next;
        }
        /**
        // the above while loop will create a mathematical proof
        // the distance from the node where the two pointers meet to the origin of the loop node
        // is equal to the distance from the head node to the origin of the loop
        // then set either one of the node to iterate from the head and the other node to iterate from where it's pointing from
        // eventually, the will meet at the origin of the loop according to the mathematical proof
        // the return first and second pointer
        ***/
        first = head;
        while(first != second){
            first = first.next;
            second = second.next;
        }
        return first;
    }
    public static void createLoop(){
        LinkedList loopOrigin = head.next.next.next.next;
        if (head != null){
            LinkedList ptr = head;
            while (ptr.next != null){
                //System.out.print(ptr.value+ " ");
                ptr = ptr.next;
            }
            ptr.next = loopOrigin;
            return;
        }
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
