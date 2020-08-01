public class ReverseLinkedList {


    public static LinkedList reverseLinkedList(LinkedList head) {
        // Write your code here.
        /**
         * Complexity:
         *  Time O(n)
         *  Space O(1)
         * Reference: https://www.algoexpert.io/questions/Reverse%20Linked%20List
         Step 1: Iterate through the LinkedList with a three pointers
         by manipulating three node at once at every step
         Step 2: The three variables have to point to three consecutive nodes in a LinkedList.
         Start by setting the "next" property of the second node to the first node.
         Then, set the first variable to the second node, and set the second varaible to the third node.
         Finally, set the third variable to the second variable's "next" property
         (at this point, the second variaale is the original third node).
         Repeat this process until you are at the tail of the LinkedList
         **/
        LinkedList p1 = null;
        LinkedList p2 = head;
        while(p2 != null){
            // store the reference of p2 at p3
            LinkedList p3 = p2.next;
            // then reverse the pointer of p2 to point to the node where located before it
            p2.next = p1;
            // now shift the p1 to the right and set it to where p2 assigned
            p1 = p2;
            // again shift the p2 to the right and set it to where p3 assigned
            p2 = p3;
            // repeat the above process until p2 hit null
        }
        // return p1 which eventually become the new head for the list
        return p1;
    }
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
        System.out.print("Before reversed: " );
        show();

        System.out.println();
        head = reverseLinkedList(head);
        System.out.println("After reversed: " );
        show();



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
