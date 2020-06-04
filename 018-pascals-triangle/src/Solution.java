class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        List<Integer> prev = new ArrayList<Integer>();
        int n = 1;
        while (n <= numRows) {
            // if there's a row in solution, get the previous row for summing up
            if (n > 1) {
                // n is indexing from 1, but the list is indexed from 0
                prev = solution.get(n-2); 
            }
            // create a new list named curr
            List<Integer> curr = new ArrayList<Integer>();

            for (int i = 0; i < n; i++) {
                // put 1 for the first and last elements of the row
                if (i == 0 || i == n-1) curr.add(1);
                // else sum the two elements above the current one
                else curr.add(prev.get(i) + prev.get(i-1));
            }
            solution.add(curr);
            n++;
        }
        
        return solution;
    }
}