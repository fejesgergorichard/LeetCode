/*
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list.

Example 1:
Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
*/


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
class Solution {
    public int getDecimalValue(ListNode head) {
        ArrayList<Integer> vals = new ArrayList<>();
        ListNode current = head;
        int result = 0;
        
        while (current != null) {
            vals.add(current.val);
            current = current.next;
        }
        
        int i = vals.size();
        for (int num : vals) {
            i--;
            if (num == 1) result += Math.pow(2,i);
        }
        
        return result;
        
    }
}