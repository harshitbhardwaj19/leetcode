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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l = preorder.length;
        return buildTree(preorder, inorder, 0, l-1, 0, l-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(inStart>inEnd){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int index = -1;

        for(int i = inStart; i<= inEnd; i++){
            if(inorder[i]==preorder[preStart]){
                index=i;
                break;
            }
        }
        int left = index - inStart;
        int right = inEnd - index - 1;
        node.left = buildTree(preorder, inorder, preStart+1, preStart+left, inStart, index-1);
        node.right = buildTree(preorder, inorder, preStart+left+1, preEnd, index+1, inEnd);

        return node;
    }


}