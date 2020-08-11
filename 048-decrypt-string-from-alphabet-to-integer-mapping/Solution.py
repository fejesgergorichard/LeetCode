""" Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:

    Characters ('a' to 'i') are represented by ('1' to '9') respectively.
    Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.

Return the string formed after mapping.
It's guaranteed that a unique mapping will always exist.

Example 1:
Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

Example 2:
Input: s = "1326#"
Output: "acz"
 """

class Solution:
    def freqAlphabets(self, s: str) -> str:
        mappings = {
                '1':'a', '2':'b', '3':'c', '4':'d', '5':'e', '6':'f', '7':'g', '8':'h', '9':'i',
                '10#':'j', '11#':'k', '12#':'l', '13#':'m', '14#':'n', '15#':'o', '16#':'p',
                '17#':'q', '18#':'r', '19#':'s', '20#':'t', '21#':'u', '22#':'v', '23#':'w',
                '24#':'x', '25#':'y', '26#':'z'
               }

        result = ''

        # Let's iterate backwards
        i = len(s) -1

        while i > -1:
            # If there are 3 digits left and we found a '#'
            if (i >= 2) and s[i] == '#':
                result += mappings[s[i-2 : i+1]]
                i -= 3
            # If its only one digit
            else:
                result += mappings[s[i]]
                i -= 1

        # Reverse the result
        result = result[::-1]
        return result