/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
import java.util.HashMap;
import java.util.Map;

class Solution {
    /** HashMap Solution, sacrificing memory for the sake of speed (about 2 ms runtime on leetcode) */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] results = new int[2];

        // we store each element of the nums array and its index in a hashmap (time: O(n))
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // we check if the complementer exists in the hashmap for each element in nums (time: O(n))
        for (int i = 0; i < nums.length; i++) {
            int complementer = target - nums[i];
            if (map.containsKey(complementer)) {
                if (map.get(complementer) != i) { // we should check if the complementer is not just the value itself
                    results[0] = i;
                    results[1] = map.get(complementer);
                    break; // we're done here since there's only one solution
                }
            }
        }

        return results;
    }

    /** O(n^2) solution. Slow. About 147 ms runtime on leetcode */
    public int[] twoSumBrute(int[] nums, int target) {
        int[] solution = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j =0 ; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j){
                    solution[0] = i;
                    solution[1] = j;
                    break;
                }
            }
        }
        return solution;
    }
}