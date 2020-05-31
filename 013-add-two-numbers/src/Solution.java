/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored
in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

import jdk.jfr.Unsigned;

import java.math.BigInteger;

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
    public static void main(String[] args) {
        /** test case: 342 + 465 = 708 */
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode solution = addTwoNumbers(l1, l2);
        System.out.print(solution.val + " ");
        solution = solution.next;
        System.out.print(solution.val + " ");
        solution = solution.next;
        System.out.print(solution.val + " ");

    }

    /** Elementary school-style addition (summing up the least significant digits and tracking the carry)  */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        // we will use the head node for operations and return dummyNode.next as the first node of the new list
        ListNode head = dummyNode;
        int l1Val, l2Val, sum, carry = 0;

        // while one of the lists continues we get their values (or 0 if we reached the end of one list)
        while (l1 != null || l2 != null) {
            l1Val = (l1 != null) ? l1.val : 0;
            l2Val = (l2 != null) ? l2.val : 0;
            // sum is the value of the two numbers plus the carry
            sum = l1Val + l2Val + carry;
            // carry is the digit that overflows the decimal place (e.g.: 6+7 = 13, carry is 1. the value in the decimal
            // place we're calculating will be 3. just as in elementary school (remember we're going from LSD to MSD)
            carry = sum / 10;
            // we assign a new node with the remainder of the sum divided by 10 (in the example above: 3)
            head.next = new ListNode(sum % 10);
            // proceed to the next node
            head = head.next;
            // if l1 or l2 aren't already the end nodes, proceed to the next ones
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // if the carry is not zero, we have one digit to go. add it
        if (carry > 0) head.next = new ListNode(carry);

        return dummyNode.next;
    }

    /** Using string manipulations. Uses little memory, but pretty slow (11 ms on leetcode) */
    public static ListNode addTwoNumbersStringy(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode head = dummyNode;
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        BigInteger l1Val = readLinkedList(l1);
        BigInteger l2Val = readLinkedList(l2);
        BigInteger sum = l1Val.add(l2Val);

        String sumString = sum.toString();
        StringBuilder sumBuilder = new StringBuilder(sumString);
        sumString = sumBuilder.reverse().toString();
        for (int i = 0; i < sumString.length(); i++) {
            head.val = Integer.parseInt(sumString.substring(i, i + 1));
            if (i != sumString.length() -1) {
                head.next = new ListNode();
                head = head.next;
            }
        }

        return dummyNode;
    }

    /** Iterates through a linked list digit-by-digit, reverses it and creates the corresponding integer */
    public static BigInteger readLinkedList (ListNode node) {
        if (node.next == null) return new BigInteger(Integer.toString(node.val));
        else {
            StringBuilder builder = new StringBuilder();

            while (true) {
                builder.append(node.val);
                if (node.next == null) break;
                else node = node.next;
            }

            // reverse the builder's content and parse it into an integer
            builder.reverse();
            BigInteger result = new BigInteger(builder.toString());
            return result;
        }
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}