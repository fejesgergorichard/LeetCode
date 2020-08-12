""" Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note: All given inputs are in lowercase letters a-z. """


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return ''

        prefix = strs[0]
        leng = 99999

        # get the minimum length
        for s in strs:
            leng = min(leng, len(s))

        maxleng = leng

        # iterate over each string until there is no matching character and update the maxleng variable
        for s in strs:
            for i in range(leng):
                if prefix[i] != s[i]:
                    maxleng = min(maxleng, i)
                    break

        # extract the longest common prefix
        if maxleng == 0:
            prefix = ''
        else:
            prefix = strs[0][0 : maxleng]

        return prefix