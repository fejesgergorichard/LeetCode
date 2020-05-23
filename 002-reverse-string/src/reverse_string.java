/*
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
extra memory.

You may assume all the characters consist of printable ascii characters.
 */

public class reverse_string {
    public static void main(String[] args) {
        System.out.println(reverseString(new char[] {'h','e','l','l','o'}));        // olleh
        System.out.println(reverseString(new char[] {'H','a','n','n','a','h'}));    // hannaH
    }

    public static char[] reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
        return s;
    }
}
