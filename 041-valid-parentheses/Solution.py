# Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is # valid.
# 
# An input string is valid if:
# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.
# Note that an empty string is also considered valid.
# 
# Example 1:
# Input: "()"
# Output: true
# Example 2:
# Input: "()[]{}"
# Output: true
# Example 3:
# Input: "(]"
# Output: false
# Example 4:
# Input: "([)]"
# Output: false
# Example 5:
# Input: "{[]}"
# Output: true
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # 

class Solution:
    def isValid(self, s: str) -> bool:
        # Initialise an empty stack
        stack = []
        # Check for open parentheses
        open_par = set(["(", "[", "{"])
        # Dictionary for finding the closing pair of a type. This makes it easier to add more types later
        bracket_pair = { '(':')', '[':']', '{':'}'}
        
        for ch in s:
            # If it's an opening element, push it into the stack
            if ch in open_par:
                stack.append(ch)
            # If it's the closing pair of an already opened element, pop it from the stack
            elif stack and ch == bracket_pair[stack[-1]]:
                stack.pop()
            # If it's a closing pair of a non-opened bracket, this is an invalid expression
            else:
                return False
        
        # An empty stack means every pair was found and the expression is valid
        return stack == []
            