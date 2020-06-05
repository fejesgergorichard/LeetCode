/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: J = "aA", S = "aAAbbbb"
Output: 3

Example 2:
Input: J = "z", S = "ZZ"
Output: 0

Note:
    S and J will consist of letters and have length at most 50.
    The characters in J are distinct.
*/

class Solution {
    /** using the indexOf() method and one for loop is the fastest solution */
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        
        // check if any character from 'S' is present in the jewels list
        for (char c : S.toCharArray()) {
            // indexOf returns -1 if the character is not found
            if (J.indexOf(c) > -1) count++;
        }
        return count;
    }


    /** this method is O(n+m) */
    public int numJewelsInStonesSet(String J, String S) {
        HashSet<Character> jewels = new HashSet<Character>();
        int count = 0;
        // fill up a list for jewels
        for (char c: J.toCharArray()) {
            jewels.add(c);
        }
        
        // check if any character from 'S' is present in the jewels list
        for (char c : S.toCharArray()) {
            if (jewels.contains(c)) count++;
        }
        return count;
    }
}