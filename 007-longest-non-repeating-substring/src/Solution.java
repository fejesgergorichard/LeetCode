/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

/*  We need to use a sliding window which is a Set of characters ranging from indexes i and j
    Basically, if we find a character that is not already in the set, we add it and increase the value of j.
    If we find a character that is already in there we delete the ith character and increment i until we get rid
    of the repeated character. Meanwhile we calculate the max length.
* */
import java.util.*;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, low = 0, high = 0;

        while (low < n && high < n) {
            if (!set.contains(s.charAt(high))) {
                set.add(s.charAt(high));
                high++;
                ans = Math.max(ans, high-low);
            }
            else {
                set.remove(s.charAt(low));
                low++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring("bbbbb");
        lengthOfLongestSubstring("pwwkew");
        lengthOfLongestSubstring(" ");
        lengthOfLongestSubstring("c");
        lengthOfLongestSubstring("au");
        lengthOfLongestSubstring("dvdf");
        lengthOfLongestSubstring("pwwkew");
        lengthOfLongestSubstring("aab");
    }
}