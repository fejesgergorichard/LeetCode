import java.util.Arrays;
import java.util.Random;
/*
Shuffle a set of numbers without duplicates.

Example:
// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 */


/*
 Fisher-Yates algorithm:
  On each iteration of the algorithm, we generate a random integer between the current index and the last index of
  the array. Then, we swap the elements at the current index and the chosen index - this simulates drawing
  (and removing) the element from the hat, as the next range from which we select a random index will not include
  the most recently processed one.
  It is possible to swap an element with itself. Otherwise, some array permutations would be more likely than others.
 */
class Solution {
    int[] array, original;
    Random rand;

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone(); // we add .clone() so the two variables actually point to different parts of memory
        rand = new Random();
    }

    /** Returns a number in a random range */
    private int randomInRange(int min, int max) {
        return rand.nextInt(max-min) + min;
    }

    /** Swaps two elements of an array */
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /** Resets the array to its original configuration and returns it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swap(i, randomInRange(i, array.length));
        }
        return array;
    }

    public static void main(String[] args) {
        int[] numz = new int[] {1,2,3,4};
        Solution obj = new Solution(numz);

        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */