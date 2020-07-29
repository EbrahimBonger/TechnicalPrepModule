class DoublyLinkedList {
    /**
     * It has a property of:
     * **/
    //public DoublyLinkedList(Node list){}
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
    public void insert(int value){
        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
            tail = newNode;
            //setHead(newNode);
        } else {
            Node ptr = head;
            while (ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = newNode;
            newNode.prev = ptr;
            tail = newNode;


        }
    }
    public void setHead(Node node){
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        insertBefore(head, node);


    }
    public void setTail(Node node){
        if(tail == null){
            setHead(node);
            return;
        }
        //System.out.println("New tail: " + node.value + " : " + tail.value);
        insertAfter(tail, node);

    }
    public void insertBefore(Node node, Node nodeToInsert){
        if(nodeToInsert == head && nodeToInsert == tail){return;}
        Node ptr = head;
        while (ptr.value != node.value){
            ptr = ptr.next;
        }


        //check if the pointer is pointing to the head
        if(ptr.prev == null){
            ptr.prev = nodeToInsert;
            nodeToInsert.next = ptr;
            head = nodeToInsert;
            return;
        }
        // ptr is pointing to node
        ptr.prev.next = nodeToInsert;
        nodeToInsert.prev = ptr.prev;
        nodeToInsert.next = ptr;
        ptr.prev = nodeToInsert;

    }
    public void insertAfter(Node node, Node nodeToInsert){
        if(nodeToInsert == head && nodeToInsert == tail){return;}
        Node ptr = head;


        while (ptr.value != node.value){
            ptr = ptr.next;
        }

        // check if the pointer is pointing at the last node(tail)
        if(ptr.next == null){
            //ptr = nodeToInsert;
            ptr.next = nodeToInsert;
            nodeToInsert.prev = ptr;
            //ptr.prev = ptr;
            tail = nodeToInsert;
            return;
        }

        ptr.next.prev = nodeToInsert;
        nodeToInsert.next = ptr.next;
        nodeToInsert.prev = ptr;
        ptr.next = nodeToInsert;
    }
    public void insertAtPosition(int position, Node nodeToInsert){
        int count = 1;
        if(count == position){
            setHead(nodeToInsert);
            return;
        }

        Node ptr = head;
        while (count != position){
            ptr = ptr.next;
            count++;
        }
        // now position and count are equal
        ptr.prev.next = nodeToInsert;
        nodeToInsert.prev = ptr.prev;
        nodeToInsert.next = ptr;
        ptr.prev = nodeToInsert;

    }
    /**
     * remove the node from the list
     * **/
    public void remove(Node node){
        if(node == head){ head = head.next;}
        if(node == tail){ tail = tail.prev;}
        removeNodesWithBindings(node);

    }
    public void removeNodesWithBindings(Node node){
        if(node.prev != null){ node.prev.next = node.next;}
        if(node.next != null){ node.next.prev = node.prev;}
        node.next = null;
        node.prev = null;
    }
    /**
     * remove every node(s) from the list with a parameter value
     * **/
    public void removeNodesWithValues(int value){
        // need two pointers one to iterate through the list and
        // the other one to set to the node subjected to removal
        Node ptr = head;
        while (ptr != null){
            Node toRemove = ptr;
            ptr = ptr.next;
            // check the value
            if(toRemove.value == value){
                remove(toRemove);
            }

        }
    }
    public boolean containsNodeWithValue(int value){
        Node ptr = head;
        while(ptr != null){

            if(ptr.value == value){
                System.out.println("True");
                return true;
            }
            ptr = ptr.next;
        }
        System.out.println("False");
        return false;
    }
    public void showForward(){
        Node ptr = head;
        while (ptr != null){
            System.out.print(ptr.value + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    public void showBackward(){
        Node start = head;
        while (start.next != null){
            start = start.next;
        }
        //Node ptr = tail;
        while (start != null){
            System.out.print(start.value + " ");
            start = start.prev;
        }
        System.out.println();
    }




    public static void main(String[] args) {

        // Create a DoublyLinked list
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        // print the initial list
        list.showForward();
        list.showBackward();
        System.out.println();

        // testing the methods
        list.setHead(new Node(4));
        list.setTail(new Node(6));
        list.insertBefore(new Node(6), new Node(3));
        list.insertAfter(new Node(6), new Node(3));
        list.insertAtPosition(1, new Node(3));
        list.removeNodesWithValues(3);
        //list.remove(new Node(2));
        list.containsNodeWithValue(5);


        // print the current list
        list.showForward();
        list.showBackward();

//        list.insertAtPosition(3, new Node(9));
//        list.insertBefore(new Node(1), new Node(9));
//        list.insertAfter(new Node(5), new Node(8));
//        list.setHead(new Node(7));
//        list.setTail(new Node(6));
//        list.removeNodesWithValues(9);
//        list.showForward();
//        list.showBackward();
//        System.out.println("head: " + list.head.value);
//        System.out.println("tail: " + list.tail.value);
//        list.containsNodeWithValue(3);
    }

}
