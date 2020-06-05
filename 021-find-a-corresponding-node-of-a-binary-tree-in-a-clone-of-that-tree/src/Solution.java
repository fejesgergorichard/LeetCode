/*
Given two binary trees original and cloned and given a reference to a node target in the original tree.
The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    /** BFS (20% speed) */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(cloned);
        TreeNode solution = new TreeNode();
        TreeNode currentNode;
        while (!q.isEmpty()) {
            currentNode = q.remove();
            if (currentNode.val == target.val) {
                solution = currentNode;
                break;
            } 
            
            if (currentNode.left != null) q.add(currentNode.left);
            if (currentNode.right != null) q.add(currentNode.right);
        }
        
        return solution;
    }

    /** DFS (16% speed) */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Stack<TreeNode> q = new Stack<TreeNode>();
        q.push(cloned);
        TreeNode solution = new TreeNode();
        TreeNode currentNode;
        while (!q.isEmpty()) {
            currentNode = q.pop();
            if (currentNode.val == target.val) {
                solution = currentNode;
                break;
            } 
            
            if (currentNode.left != null) q.push(currentNode.left);
            if (currentNode.right != null) q.push(currentNode.right);
        }
        
        return solution;
    }
}