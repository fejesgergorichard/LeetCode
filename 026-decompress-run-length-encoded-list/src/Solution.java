class Solution {
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i+1]);
            }
        }
        
        int[] solution = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            solution[i] = list.get(i);
        }
        
        return solution;
    }
}