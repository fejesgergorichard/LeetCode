""" Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:
Input: 121
Output: true

Example 2:
Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:
Coud you solve it without converting the integer to a string? """


class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        strx = str(x)[::-1]
        i = 0
        for c in str(x):
            if c != strx[i]:
                return False
            i += 1
        
        return True