/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

import static java.util.Collections.list;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */



// Given head, the head of a linked list, determine if the linked list has a cycle in it.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. Otherwise, return false.



// Example 1:
// 3 -> 2-> 3 -> 4 --|
//      |            |
//      -------------

class Solution{
     class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }

     }




    public static boolean detectCycle(Node head){

        HashMap<Node, Integer> map = new HashMap<Node, Integer>();
        Node pointer = head;

        while(pointer != null){
            if(map.containsKey(pointer)){
                return true;
            }else{
                map.put(pointer, pointer.data);
                pointer = pointer.next;
            }

        }

        return false;
    }

    public static void main(String[] args){

        Solution sol = new Solution();

        Node list = sol.new Node(3);
        Node list2 = sol.new Node(2);
        list.next = list2;
        Node list3 = sol.new Node(3);
        list2.next = list3;
        Node list4 = sol.new Node(4);
        list3.next = list4;
         //Create cycle
        //list4.next = list2;

        boolean check = detectCycle(list);
        System.out.println(check);

    }

}


