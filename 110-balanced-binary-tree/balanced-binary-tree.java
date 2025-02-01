/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return balanced;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int lDepth = depth(root.left);
        int rDepth = depth(root.right);

        if (Math.abs(lDepth - rDepth) > 1) {
            balanced = false;
        }

        return 1 + Math.max(lDepth, rDepth);
    }
}