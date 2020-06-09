class Solution {
    /** Primitive array solution - better runtime */
    public int[] decompressRLElist(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i % 2 == 0) count += nums[i];
        }
        System.out.println(count);
        
        int[] solution = new int[count];
        count = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = count; j < count + nums[i]; j++) {
                solution[j] = nums[i+1];
            }
            count += nums[i];
        }
        
        return solution;
    }


    /** ArrayList solution - simpler code, slower runtime */
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