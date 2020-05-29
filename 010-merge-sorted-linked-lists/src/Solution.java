/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Recursive solution
class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        // If one of the lists is empty, we just return the other one (assumably not empty)
        if (A == null) return B;
        if (B == null) return A;

        // If the value in A node is the smaller one, we return A and we choose A's next node by comparing it to B
        if (A.val < B.val) {
            A.next = mergeTwoLists(A.next, B);
            return A;
        }
        else {
            B.next = mergeTwoLists(A, B.next);
            return B;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}