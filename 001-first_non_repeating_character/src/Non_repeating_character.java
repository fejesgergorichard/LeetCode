/*
Given a string, find the first non-repeating character in it. For example, if the input string is “eyeforaneye”,
then the output should be ‘f’ and if the input string is “GeeksQuiz”, then the output should be ‘G’.

If there is no non-repeating character in the string, return a '_'.
 */

import java.util.HashMap;

public class Non_repeating_character {
    public static void main(String[] args) {
        String input1 = "eyeforaneye";      // f
        String input2 = "GeeksQuiz";        // G
        String input3 = "HelloBelloHey";    // B
        String input4 = "aaaaaa";           // _

        System.out.println(firstNonRepeating_hashMap(input1));
        System.out.println(firstNonRepeating_hashMap(input2));
        System.out.println(firstNonRepeating_hashMap(input3));
        System.out.println(firstNonRepeating_hashMap(input4));

        System.out.println(firstNonRepeating_bruteForce(input1));
        System.out.println(firstNonRepeating_bruteForce(input2));
        System.out.println(firstNonRepeating_bruteForce(input3));
        System.out.println(firstNonRepeating_bruteForce(input4));

        System.out.println(firstNonRepeating(input1));
        System.out.println(firstNonRepeating(input2));
        System.out.println(firstNonRepeating(input3));
        System.out.println(firstNonRepeating(input4));
    }

    public static char firstNonRepeating_bruteForce(String string) {
        // O(n^2) <-- nested for loops
        char solution = '_';
        boolean repeating = false;

        // Iterate over the whole string
        for (int i = 0; i < string.length(); i++) {
            char C = string.charAt(i);

            // Iterate over it again to check for repeating characters
            for (int j = 0; j < string.length(); j++) {
                char c = string.charAt(j);
                // If the current character in the inside loop is equal to the one in the outside loop
                //  and it's not on the same index, then it's a repeated character and no need to continue
                if (c == C && i != j) {
                    repeating = true;
                    break;
                }
                else repeating = false;
            }
            // If the character is not repeated
            if (!repeating) {
                solution = C;
                break;
            }
            else solution = '_';
        }
        return solution;
    }

    public static char firstNonRepeating_hashMap(String string) {
        // O(2n)  < -- two separate for loops
        // We use a hashmap to store the number of occurences for each character in the input string
        char solution = '_';
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : string.toCharArray()) {
            // If the given character is not in the HashMap, add it with the value of 1
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, 1);
            }
            // If it's already in the HashMap, increment its value by 1
            else {
                int newValue = hashMap.get(c) + 1;
                hashMap.replace(c, newValue);
            }
        }

        // The HashMap is not sorted so we have to loop through the string again to find the FIRST non-repeating character
        for (char c : string.toCharArray()) {
            if (hashMap.get(c) == 1) {
                solution = c;
                break;
            }
        }

        return solution;
    }

    public static char firstNonRepeating(String string) {
        // O(n) <-- single iteration
        char solution = '_';
        for (char c : string.toCharArray()) {
            if (string.indexOf(c) == string.lastIndexOf(c)) {
                solution = c;
                break;
            }
        }
        return solution;
    }
}
