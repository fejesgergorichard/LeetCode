import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /** Brute force solution O(n^2) */
    public int[] smallerNumbersThanCurrentBrute(int[] nums) {
        int[] solution = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sum = 0;
            for (int check : nums) {
                if (check < num) sum++;
            }
            solution[i] = sum;
        }

        return solution;
    }
}