""" Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Constraints:
haystack and needle consist only of lowercase English characters.
 """

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # if the needle is empty or equal to the haystack
        if ((len(needle) == 0) or (haystack == needle)):
            return 0

        else:
            # iterate over the haystack - the length of the needle so we don't address indexes out of range
            for i in range(len(haystack)-len(needle)+1):
                # iterate over the needle
                for j in range(len(needle)):
                    # if any characters don't match, we break out of the loop
                    if (haystack[i+j] != needle[j]):
                        break
                    # if we went over the needle and did not escape, we found the index we're looking for
                    if (j == len(needle)-1):
                        return i
        # no solution: -1
        return -1
