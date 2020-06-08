class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] x = new int[n];
        int[] y = new int[n];
        int[] solution = new int[2*n];
        
        for (int i = 0; i < n; i++) {
            x[i] = nums[i];
            y[i] = nums[i+n];
        }
        
        int j = 0;
        for (int i = 0; i < 2*n; i += 2) {
            solution[i] = x[j];
            solution[i+1] = y[j];
            j++;
        }

        return solution;
        
    }
}