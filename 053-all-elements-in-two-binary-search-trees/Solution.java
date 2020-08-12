/* Given two binary search trees root1 and root2.
Return a list containing all the integers from both trees sorted in ascending order.

Example 1:
Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Example 2:
Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]

Example 3:
Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]

Example 4:
Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        // Add the root nodes if they are not null
        if (root1 != null) q.add(root1);
        if (root2 != null) q.add(root2);

        TreeNode current = q.poll();

        while (true) {
            // Add the current node's value to the list
            list.add(current.val);
            // Add the left node if it's not null
            if (current.left != null) {
                q.add(current.left);
            }
            // Add the right node if it's not null
            if (current.right != null) {
                q.add(current.right);
            }

            // break if the queue has no more elements
            if (q.isEmpty()) break;
            // else pick the next element
            current = q.poll();
        }

        // Sort the list
        Collections.sort(list);

        return list;
    }
}