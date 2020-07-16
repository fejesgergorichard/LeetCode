# International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
# For convenience, the full table for the 26 letters of the English alphabet is given below:
# [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
# Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-..--...",
# (which is the concatenation "-.-." + ".-" + "-..."). We'll call such a concatenation, the transformation of a word.
# Return the number of different transformations among all words we have.
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
# Example:
# Input: words = ["gin", "zen", "gig", "msg"]
# Output: 2
# Explanation:
# The transformation of each word is:
# "gin" -> "--...-."
# "zen" -> "--...-."
# "gig" -> "--...--."
# "msg" -> "--...--."
# There are 2 different transformations, "--...-." and "--...--.".
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #

class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        morses = [".-","-...","-.-.","-..",".","..-.","--.","....","..", ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-", "...-",".--","-..-","-.--","--.."]

        # a set does not store duplicates
        uniques = set()

        # iterate over each word in the list
        for word in words:
            # iterate over each char to form a morse-word
            morse = ''
            for c in word:
                morse += morses[ord(c) - ord('a')]
            uniques.add(morse)

        return len(uniques)
