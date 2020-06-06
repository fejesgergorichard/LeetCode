import java.util.LinkedList;
import java.util.Queue;

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

    /** BFS solution (pretty slow) */
    public int deepestLeavesSum(TreeNode root) {
        int levelSum = 0;

        // Base case
        if (root.left == null && root.right == null) return root.val;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode temp;

        while (!q.isEmpty()) {
            levelSum = 0;

            int levelSize = q.size();
            for (int i = 0; i < levelSize; i ++) {
                temp = q.poll();
                levelSum += temp.val;
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }

        }

        return levelSum;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
  }
}