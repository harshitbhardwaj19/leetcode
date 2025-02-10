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
    int sol;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        sol = -1;
        count = 0;
        helper(root, k);
        return sol;
    }

    public void helper(TreeNode root, int k) {
        if(root == null){
            return;
        }
        helper(root.left, k);
        count++;
        if(count == k){
            sol = root.val;
        }
        helper(root.right, k);
    }
}