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
    int i;
    char arr[];
    int l;

    public TreeNode recoverFromPreorder(String traversal) {
        arr = traversal.toCharArray();
        l = arr.length;
        i=0;
        int num = 0;
        while (i < l && Character.isDigit(arr[i])) {
            num = num * 10 + (arr[i] - '0');
            i++;
        }

        TreeNode root = new TreeNode(num);
        root.left = recoverFromPreorder(1);
        root.right = recoverFromPreorder(1);
        return root;
    }

    private TreeNode recoverFromPreorder(int depth) {
        if (!validDashes(i, depth)) {
            return null;
        }

        i = i + depth;
        int num = 0;
        while (i < l && Character.isDigit(arr[i])) {
            num = num * 10 + (arr[i] - '0');
            i++;
        }

        TreeNode node = new TreeNode(num);

        node.left = recoverFromPreorder(depth+1);
        node.right = recoverFromPreorder(depth+1);
        return node;
    }

    private boolean validDashes(int index, int depth) {
        if (index < 1 || index + depth - 1 >= l) {
            return false;
        }
        for (int j = index; j < index + depth; j++) {
            if (arr[j] != '-') {
                return false;
            }
        }
        return true;
    }

}