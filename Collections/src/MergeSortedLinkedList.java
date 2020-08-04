public class MergeSortedLinkedList {
    /**
     * Reference: https://www.youtube.com/watch?v=j_UNYW6Ap0k
     * Remark:
     *  It requires 3 pointers for this algorithm operation.
     *  P -> start from the head of a first linkedList
     *  q -> start from the head of a second linkedList
     *  s(sortingPtr) -> Initially points to a LinkedList with less value
     * **/
    public static LinkedList mergeLinkedList(LinkedList headOne, LinkedList headTwo){
        LinkedList sortingPtr = null;

        /**
         * this void helper method three pointers reference to the head of the LinkedLists to perform merge and return the new merged head
         * **/
        return returnNewHead(headOne, headTwo, sortingPtr);
    }
    public static LinkedList returnNewHead(LinkedList p, LinkedList q, LinkedList s){

        LinkedList newHead = null;
        /**check if either on of the list is null
         * **/
        if(p == null){return q;}
        if(q == null){return p;}
        /**
         * set the sorting pointer where to start and the head that will be returned
         * **/
        if(p.value < q.value){
            s = p;
            p = s.next;
            newHead = s;
        } else {
            s = q;
            q = s.next;
            newHead = s;
        }

        while (p != null && q != null){
            /** pointer s move to the LinkedList where currently merging performed **/
            if(p.value <= q.value){
                s.next = p;
                s = p;
                p = s.next;
            } else {
                s.next = q;
                s = q;
                q = s.next;
            }
        }
        /**Whichever pointer reaches null first will point to the other LinkedList**/
        if(p == null){s.next = q;}
        if(q == null){s.next = p;}
        return newHead;
    }

    public static void main(String[] args){
        LinkedList headOne = new LinkedList(2);
        headOne.insert(6, headOne);
        headOne.insert(7, headOne);
        headOne.insert(8, headOne);

        LinkedList headTwo = new LinkedList(1);
        headTwo.insert(3, headTwo);
        headTwo.insert(4, headTwo);
        headTwo.insert(5, headTwo);
        headTwo.insert(9, headTwo);
        headTwo.insert(10, headTwo);

        System.out.print("Before Merge: " );
        show(headOne);
        System.out.println();
        show(headTwo);

        System.out.println();
        System.out.println("After merge: " );
        LinkedList newHead = mergeLinkedList(headOne, headTwo);
        show(newHead);



    }
    public static void show(LinkedList head){
        LinkedList ptr = head;
        if (head != null){
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

        public static void insert(int value, LinkedList head){
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
