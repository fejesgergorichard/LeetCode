/*
Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith
kid has. For each kid check if there is a way to distribute extraCandies among the kids such that he or she can
have the greatest number of candies among them. Notice that multiple kids can have the greatest number of candies.

Example:
Input: candies = [12,1,12], extraCandies = 10
Output: [true,false,true]
*/

import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> kidsWithCandies = new ArrayList<>();
        int n = candies.length;
        int max = maximum(candies);
        for (int i = 0; i < n; i++) {
            if (candies[i] + extraCandies >= max) {
                kidsWithCandies.add(true);
            }
            else {
                kidsWithCandies.add(false);
            }
        }
        return kidsWithCandies;
    }

    /** Finds the maximum in an array (linear search) */
    public int maximum(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            max = (array[i] > max) ? array[i] : max;
        }
        return max;
    }
}