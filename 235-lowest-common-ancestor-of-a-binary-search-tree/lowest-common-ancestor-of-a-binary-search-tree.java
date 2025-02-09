/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        boolean pFound = false;
        boolean qFound = false;

        if (left == p || right == p || root == p) {
            pFound = true;
        }
        if (left == q || right == q || root == q) {
            qFound = true;
        }

        if (qFound && pFound) {
            return root;
        }

        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }

        if (root == p || root == q) {
            return root;
        }

        return null;
    }
}