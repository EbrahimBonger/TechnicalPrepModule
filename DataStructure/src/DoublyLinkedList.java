public class DoublyLinkedList {
    /**
     * It has a property of:
     * **/
    public Node head;
    public Node tail;
    static class Node{
        public int value;
        public Node prev;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }
    /**
     * It has methods of:
     * **/

    public void setHead(Node node){}
    public void setTail(Node node){}
    public void insertBefore(Node node, Node nodeToInsert){}
    public void insertAfter(Node node, Node nodeToInsert){}
    public void insertAtPosition(int position, Node nodeToInsert){}
    public void remove(Node node){}
    public void removeNodesWithValues(int value){}
    public boolean containsNodeWithValue(int value){
        return false;
    }

}
