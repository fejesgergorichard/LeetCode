/*
Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
Return a lucky integer in the array. If there are multiple lucky integers return the largest of them.
If there is no lucky integer return -1.

Example 1:
Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.

Example 2:
Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.

Example 3:
Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.

Constraints:
1 <= arr.length <= 500
1 <= arr[i] <= 500

 */
class Solution {
    /** Finds lucky numbers in array */
    public int findLucky(int[] arr) {
        // we initialize an empty array of integers for 501 elements
        int[] numbers = new int[501];
        // for each element in the input array, we increment the value of the corresponding index in the numbers array
        // therefore if there are 2 number 2's in the arr, the value on the second index will become 2
        // (kinda like storing the values in a HashMap but the keys are the indices in the numbers array)
        for (int n : arr) {
            numbers[n]++;
        }
        // from top to bottom so the greatest number is returned
        for (int i = 500; i >= 1; i--) {
            if (i == numbers[i]) return i;
        }
        return -1;
    }
}