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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        helper(root, to_delete, list, null);

        return list;
    }

    public TreeNode helper(TreeNode root, int[] to_delete, List<TreeNode> list, TreeNode parent) {
        if (root == null) {
            return null;
        }

        if (contains(root.val, to_delete)) {
            helper(root.left, to_delete, list, null);
            helper(root.right, to_delete, list, null);
            return null;
        } else {
            if (parent == null) {
                list.add(root);
            }
            root.left = helper(root.left, to_delete, list, root);
            root.right = helper(root.right, to_delete, list, root);
            return root;
        }
    }

    public boolean contains(int val, int[] to_delete) {
        for (int i : to_delete) {
            if (val == i) {
                return true;
            }
        }
        return false;
    }
}