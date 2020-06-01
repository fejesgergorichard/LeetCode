import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        //Scanner in = new Scanner(System.in);
        long L = 10;
        long R = 100;

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(luckyNumbers(0,10));
        System.out.println(luckyNumbers(10,100));
        System.out.println(luckyNumbers(100,1000));
        System.out.println(luckyNumbers(1000,10000));
    }
    /** This method checks every number, but it's too slow for very large numbers */
    public static int luckyNumbers(long L, long R) {
        int counter = 0;
        char[] temp;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (long i = L; i <= R; i++) {
            hashMap.clear();
            temp = Long.toString(i).toCharArray();
            for (char c : temp) {
                if (c == '8' || c == '6') {
                    if (!hashMap.containsKey(c)) hashMap.put(c, 1);
                }
            }
            if (hashMap.containsKey('8') ^ hashMap.containsKey('6')) {
                //System.out.println(i);
                counter++;
            }
        }
        return counter;
    }

    public static long yieldLuckyNumber(long l) {
        String longString = Long.toString(l);
        if (longString.charAt(longString.length()-1) == '8'){
            return l + 8;
        }
        else return l++;
    }
}