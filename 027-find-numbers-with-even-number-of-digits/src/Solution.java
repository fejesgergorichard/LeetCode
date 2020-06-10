class Solution {
    /** Conversion to String object solution (93% speed) */
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (Integer.toString(num).length() % 2 == 0) count++;
        }
    return count;
    }


    /** Solution with dividing each number by 10 until it's zero. */
    public int findNumbersMath(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (reduceToZero(num) % 2 == 0) count++;
        }
    return count;
    }
    
    
    public int reduceToZero(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;    
        }
        return count;
    }
}