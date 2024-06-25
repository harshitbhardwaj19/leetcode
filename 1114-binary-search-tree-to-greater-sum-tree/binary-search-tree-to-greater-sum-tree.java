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
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    public int dfs(TreeNode root, int sum){
        if(root==null){
            return sum;
        }
        // System.out.println("###############");
        // System.out.println(root.val);
        int rightSum = dfs(root.right, sum);
        // System.out.println(rightSum);
        root.val = root.val+rightSum;
        int leftSum = dfs(root.left, root.val);
        // System.out.println(leftSum);
        return leftSum;
    }
}