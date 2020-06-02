/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
[−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the
reversed integer overflows.
 */

class Solution {
    // Integer's max value is   2147483647 <-- max value/10 is  214748364
    // min value is            -2147483648 <-- min value/10 is -214748364
    // If the current value of the solution is already bigger than the MAX_VALUE or MIN_VALUE then return 0
    // If the current value of the solution is the MIN/MAX value/10 and the pop is greater than 7 or smaller than -8,
    // the 32-bit int is going to overflow

    /** Popping the last digit off the number and multiplying the number by 10 until x runs out  */
    public int reverse(int x) {
        int solution = 0, pop;

        while (x != 0) {
            pop = x % 10;
            if ((solution > Integer.MAX_VALUE / 10) || solution == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            if ((solution < Integer.MIN_VALUE / 10) || solution == Integer.MIN_VALUE / 10 && pop < -8) return 0;
            solution = solution * 10 + pop;
            x /= 10;
        }
        return solution;
    }

    /** String manipulation version - fail */
    public int reverseViaString(int x) {
        int solution = 0;
        char[] strChars = Integer.toString(x).toCharArray();
        int n = strChars.length - 1;
        for (int i = n; i >= 0; i--) {
            int pop = (int) strChars[i] - 48;
            if ((solution > Integer.MAX_VALUE / 10) || solution == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            if ((solution < Integer.MIN_VALUE / 10) || solution == Integer.MIN_VALUE / 10 && pop < -8) return 0;
            solution = solution * 10 + pop;
        }

        return solution;
    }
}