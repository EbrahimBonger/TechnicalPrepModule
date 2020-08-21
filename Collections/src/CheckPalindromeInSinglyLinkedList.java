import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/** Definition for singly-linked list.
 * Reference: https://leetcode.com/problems/palindrome-linked-list/submissions/
**/
 class ListNode {
      int val =1;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class CheckPalindromeInSinglyLinkedList {

    static ListNode head = new ListNode();
    public static void main(String[] args){
        add(1);
        add(1);
        add(1);
        add(1);
        add(1);
        add(1);
        add(0);
        show(head);
        System.out.print("\n Is palindrome? :" + brutForceApproach(head));

     }

     public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){return true;}
        return brutForceApproach(head);

    }
    public static void add(int value){

        if(head == null){
            head.val = value;
        }else {
            ListNode ptr = head;
            while (ptr.next != null){
                ptr = ptr.next;
            }
            //ListNode newNode;
            ptr.next = new ListNode(value);
            //newNode.val = value;
        }
    }
      public static void show(ListNode head){
        if(head != null){
            ListNode ptr = head;
            while (ptr != null){
                System.out.print(ptr.val + " --> ");
                ptr = ptr.next;
            }
            System.out.print("null");
        }
    }
    public static boolean brutForceApproach(ListNode head){

        ListNode firstPtr = head;
        ListNode secondPtr = head;
        int midCount = 0;
        int firstHalfCount = 0;
        int secondHalfCount = 0;
        Stack<ListNode> stack = new Stack<ListNode>();
        Queue<ListNode> q = new LinkedList<ListNode>();
        while(secondPtr != null){
            midCount+=1;
            secondPtr = secondPtr.next;
        }
        secondPtr = head;
        int mid = 1;
        while(mid <= midCount/2){
            mid = mid + 1;
            secondPtr = secondPtr.next;
        }
        if(midCount%2 !=0){
            mid = mid+1;
            secondPtr = secondPtr.next;
        }

        while(secondPtr != null){

            firstHalfCount += firstPtr.val;
            stack.push(secondPtr);
            q.add(firstPtr);
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;

        }
        while(stack.isEmpty() == false){
            ListNode topS = stack.pop();
            ListNode topQ = q.remove();
            if(topS.val != topQ.val){return false;}

        }

        return true;
    }
}