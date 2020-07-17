# Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

# Example 1:
# Input: "Hello"
# Output: "hello"
# Example 2:
# Input: "here"
# Output: "here"
# Example 3:
# Input: "LOVELY"
# Output: "lovely"
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #

class Solution:
    def toLowerCase(self, str: str) -> str:
        #return str.lower()

        newStr = ""
        for c in str:
            # check if c is an uppercase letter
            if ord(c) <= ord('Z') and ord(c) >= ord('A'):
                ascii = ord(c) + ord('a') - ord('A')
                c = chr(ascii)
            newStr += c

        return newStr