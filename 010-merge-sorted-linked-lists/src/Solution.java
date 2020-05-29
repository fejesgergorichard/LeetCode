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


/* Merge two sorted linked lists and return it as a new sorted list.
The new list should be made by splicing together the nodes of the first two lists.

Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

/** Recursive solution */
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

/** Iterative solution */
class Solution2 {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;

        while (true) {
            // If one of the lists is empty, we just strap on the other one and we're done
            if (A == null) {
                tail.next = B;
                break;
            }
            if (B == null){
                tail.next = A;
                break;
            }

            // If the value in A node is the smaller one, we assign A as the next node and advance A by one node
            if (A.val < B.val) {
                tail.next = A;
                A = A.next;
            } else {
                tail.next = B;
                B = B.next;
            }

            // We advance the tail to become the last assigned node
            tail = tail.next;
        }
        // dummyNode was set equal to the tail outside of the loop, so dummyNode is the parent of the tail node
        return dummyNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}