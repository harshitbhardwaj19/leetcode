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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put((long) 0, 1);
        return pathSum(root, targetSum, 0, map);
    }

    public int pathSum(TreeNode root, int targetSum, long sum, Map<Long, Integer> map) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        sum += root.val;
        if (map.containsKey(sum - targetSum)) {
            count += map.get(sum - targetSum);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        count += pathSum(root.left, targetSum, sum, map);
        count += pathSum(root.right, targetSum, sum, map);
        map.put(sum, map.get(sum) - 1);
        return count;
    }

}