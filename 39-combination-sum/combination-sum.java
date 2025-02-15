class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combinationSum(nums, 0, list, new ArrayList<>(), target, 0);
        return list;
    }

    public void combinationSum(int[] nums, int start, List<List<Integer>> list, List<Integer> curr, int target, int sum) {
        if (start > nums.length || sum > target) {
            return;
        }
        if (sum == target) {
            list.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            combinationSum(nums, i, list, curr, target, sum+nums[i]);
            curr.remove(curr.size() - 1);
        }
    }
}